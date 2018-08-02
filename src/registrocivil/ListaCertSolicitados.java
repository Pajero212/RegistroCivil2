package registrocivil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ListaCertSolicitados implements excel{
    private ArrayList <Cert> list;
    private static ListaCertSolicitados ls;
    
    public static ListaCertSolicitados getInstance(){
        if(ls==null){
            File f=new File("LibroCert.xlsx");
            List lista=excel.LeerExcel(f);
            ls=(ListaCertSolicitados)ListaCertSolicitados.obtenerExcel(lista);
        }
        return ls;
    }
    
    
    private ListaCertSolicitados (ArrayList certificados){
        this.list=certificados;
    }
    
    private ListaCertSolicitados (){
        ArrayList<Cert> certificados = new ArrayList<>(); 
        this.list=certificados;
    }
    
    public void setListaCertSolicitados(ArrayList certificados){
        this.list=certificados;
    }
    
    public ArrayList getListaCertSolicitados(){
        return list;
    }
    
    public ArrayList agruparCertPersona(String rut){
       ArrayList<Cert> c1 = new ArrayList<>();
       Cert cer;
       int i;
        for(i=0;i<list.size();i++){
           cer = list.get(i);
           if(cer.getRut().equals(rut)){
               c1.add(cer);
           }
       }
        return c1;
    }
    
    public ArrayList nuevoCert(String cod,String rut, String rut2, String comuna){
        Cert certi = new Cert(cod,rut,comuna,rut2);
        list.add(certi);
        return list;
    }
    
    public ArrayList agruparDatos(ListaCertSolicitados ls){
        ArrayList<Cert> central = ls.getListaCertSolicitados();
        ArrayList retorno = new ArrayList<>();
        int c1=0,c2=0,c3=0;
        
        for(int i=0;i<central.size();i++){
            Cert c =(Cert)central.get(i);
            switch (c.getCod()){
                case "1":
                    c1++;
                    break;
                case "2":
                    c2++;
                    break;
                case "3":
                    c3++;
                    break;
            }
        }
        retorno.add(c1);
        retorno.add(c2);
        retorno.add(c3);
        return retorno;
    }
    
    public ArrayList agruparTipo(String tipo){
        ArrayList<Cert> cl = new ArrayList<>();
        Cert cer;
        int i;
         for(i=0;i<list.size();i++){
             cer = list.get(i);
             if(cer.getCod().equals(tipo)){
               cl.add(cer);
           }
         }
         return cl;
    }

    public void ActualizarExcel(Object O, File file) {
        int i,j;
        Cert cert;
        ListaCertSolicitados certific=(ListaCertSolicitados)O;
        ArrayList <Cert> certi=certific.getListaCertSolicitados();
        try{
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet hssfsheet = wb.createSheet();
            
            for(i=0;i<certi.size();i++){
                XSSFRow hssfRow = hssfsheet.createRow(i);
                cert=certi.get(i);
                for(j=0;j<5;j++){
                    XSSFCell hssfCell = hssfRow.createCell(j);
                    switch(j){
                    case 0:
                        hssfCell.setCellValue(cert.getCod());
                        break;
                    case 1:
                        hssfCell.setCellValue(cert.getRut());
                        break;
                    case 2:
                        hssfCell.setCellValue(cert.getSede());
                        break;
                    case 3:
                        if(cert.getAprobado()){
                            hssfCell.setCellValue("A");
                        }else{
                            hssfCell.setCellValue("P");
                        }
                        break;
                    case 4:
                        hssfCell.setCellValue(cert.getRut2());
                        break;
                    }
                }
            }
            
            try{
                try (FileOutputStream fsIP = new FileOutputStream(file)) {
                    wb.write(fsIP);
                }
            }catch(FileNotFoundException ex){
                System.out.println("\nError: "+ex.getMessage());
            }
        }catch(IOException e){
            System.out.println("\nError: "+e.getMessage());
        }
    }

    public static Object obtenerExcel(List cellDataList) {
        int i;
        ArrayList<Cert> ac = new ArrayList<>();
        Cert certificado;
        for (i=0;i<cellDataList.size();i++){
            List cellTempList = (List) cellDataList.get(i);
            certificado=new Cert(cellTempList);
            ac.add(certificado);
        }
        ListaCertSolicitados l = new ListaCertSolicitados(ac);
        return l;
    }
    
    public void Actualizar(ListaCertSolicitados l){
        File f=new File("LibroCert.xlsx");
        ActualizarExcel(l,f);
    }
    
    public void modiLista(Cert c){
        ListaCertSolicitados l=ListaCertSolicitados.getInstance();
        ArrayList<Cert> lc=l.getListaCertSolicitados();
        for(int i=0;i<lc.size();i++){
            Cert piv = (Cert)lc.get(i);
            if(piv.equals(c)) lc.remove(i);
        }
        lc.add(c);
        l.setListaCertSolicitados(lc);
        this.Actualizar(l);
    }
    
    public void eliminar(Cert c){
        for (int i=0;i<list.size();i++){
            Cert piv = (Cert)list.get(i);
            if(piv.equals(c)) list.remove(i);
        }
        File f=new File("LibroCert.xlsx");
        ActualizarExcel(this,f);
    }
    
    
}
