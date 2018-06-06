package registrocivil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ListaCertSolicitados implements excel{
    private ArrayList <Cert> list;
    
    public ListaCertSolicitados (ArrayList certificados){
        this.list=certificados;
    }
    
    public ListaCertSolicitados (){
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
    
     @Override
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
                
            }
        }catch(IOException e){
            
        }
    }

    @Override
    public Object LeerExcel(Object O, File filename) {
        List cellData = new ArrayList();
        try{
            FileInputStream fileInputStream = new FileInputStream (filename);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            
            XSSFSheet hssfsheet = workbook.getSheetAt(0);
            
            Iterator rowIterator = hssfsheet.rowIterator();
            
            while(rowIterator.hasNext()){
                XSSFRow hssfRow = (XSSFRow) rowIterator.next();
                
                Iterator iterator = hssfRow.cellIterator();
                List cellTemp = new ArrayList();
                
                while(iterator.hasNext()){
                    XSSFCell hssfCell = (XSSFCell) iterator.next();
                    
                    cellTemp.add(hssfCell);
                }
                
                cellData.add(cellTemp);
            }
            
        }catch(IOException e){
              
        }
        return obtenerExcel(cellData,O);
    }

    @Override
    public Object obtenerExcel(List cellDataList, Object O) {
        int i,j;
        ListaCertSolicitados l=(ListaCertSolicitados)O;
        String sede=null,rut=null,cod=null,piv,rut2=null;
        Cert certificado;
        ArrayList <Cert> c = new ArrayList <>();
        boolean estado=false;
        
        for (i=0;i<cellDataList.size();i++){
            List cellTempList = (List) cellDataList.get(i);

            for(j=0;j<cellTempList.size();j++){
                XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
                
                String stringCellValue = hssfCell.toString();
                
                switch(j){
                    case 0:
                        piv=stringCellValue;
                        if(piv.equals("1")){
                            cod=piv;
                        }else{
                            if(piv.equals("2")){
                                cod=piv;
                            }else{
                                if(piv.equals("3")) cod=piv;
                            }
                        }
                        break;
                    case 1:
                        sede=stringCellValue;
                        break;
                    case 2:
                        rut=stringCellValue;
                        break;
                    case 3:
                        if(stringCellValue.equals("A")){
                            estado=true;
                        }
                        break;
                    case 4:
                        rut2=stringCellValue;
                        break;
                }
            }
            certificado=new Cert(cod,sede,rut,estado,rut2);
            c.add(certificado);
            
        }
        l.setListaCertSolicitados(c);
        return l;
    }

    @Override
    public Object cargarExcel() {
        File f=new File("LibroCert.xlsx");
        ArrayList<Cert> a = new ArrayList<>();
        ListaCertSolicitados l=new ListaCertSolicitados(a);
        return LeerExcel(l,f);
    }
    
    public void Actualizar(ListaCertSolicitados l){
        File f=new File("LibroCert.xlsx");
        ActualizarExcel(l,f);
    }
    
}
