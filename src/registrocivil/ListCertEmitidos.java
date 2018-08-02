package registrocivil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ListCertEmitidos implements excel{
    private ArrayList<Cert> certificados;
    private static ListCertEmitidos lc;
    
    public static ListCertEmitidos getInstance(){
        if(lc==null){
            File f=new File("LibroCert.xlsx");
            List lista=excel.LeerExcel(f);
            lc=(ListCertEmitidos)ListCertEmitidos.obtenerExcel(lista);
        }
        return lc;
    }
    
    private ListCertEmitidos (ArrayList certificados){
        this.certificados=certificados;
    }
    
    private ListCertEmitidos (){
        this.certificados=new ArrayList<>();
    }
    
    public void setListaCertificados(ArrayList certificados){
        this.certificados=certificados;
    }
    
    public ArrayList getListaCertificados(){
        return certificados;
    }
    
    public ArrayList agruparCertPersona(String rut){
       ArrayList<Cert> c1 = new ArrayList<>();
       Cert cer;
       int i;
        for(i=0;i<certificados.size();i++){
           cer = certificados.get(i);
           if(cer.getRut().equals(rut)){
               c1.add(cer);
           }
       }
        return c1;
    }
    
    public ArrayList nuevoCert(String cod,String rut, String rut2, String comuna){
        Cert certi = new Cert(cod,rut,comuna,rut2);
        certificados.add(certi);
        return certificados;
    }
    
    public ListCertEmitidos agruparCertSede(String sede){
        ArrayList<Cert> c1 = new ArrayList<>();
        ListCertEmitidos l1 = new ListCertEmitidos(c1);
        Cert cer;
        int i;
        for(i=0;i<certificados.size();i++){
           cer = (Cert)certificados.get(i);
           if(cer.getSede().equals(sede)){
               c1.add(cer);
           }
       }
       l1.setListaCertificados(c1);
       return l1;
    }
    
    public ArrayList chequeoCert(Persona p){
        ArrayList<Cert> ac=new ArrayList<>();
        if(p.getListCert()!=null){
            ListCertEmitidos lic=p.getListCert();
            ac=lic.getListaCertificados();
        }
        return ac;
    }
    
    public void eliminarCertP(Persona p){
        for(int i=0;i<certificados.size();i++){
            Cert c = (Cert)certificados.get(i);
            if(p.getRut().equals(c.getRut())) certificados.remove(i);
        }
        File f = new File("LibroCert.xlsx");
        this.ActualizarExcel(this, f);
        
    }
    
    public void eliminarCertS(Sede s){
        for(int i=0;i<certificados.size();i++){
            Cert c = (Cert)certificados.get(i);
            if(s.getComuna().equals(c.getSede())) certificados.remove(i);
        }
        File f = new File("LibroCert.xlsx");
        this.ActualizarExcel(this, f);
        
    }

    public void ActualizarExcel(Object O, File file) {
        int i,j;
        Cert cert;
        try{
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet hssfsheet = wb.createSheet();
            
            for(i=0;i<certificados.size();i++){
                XSSFRow hssfRow = hssfsheet.createRow(i);
                cert=certificados.get(i);
                for(j=0;j<=4;j++){
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
        ListCertEmitidos l= new ListCertEmitidos(ac);
        return l;
    }
    
}
