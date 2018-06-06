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

public class ListaSede implements excel{
    private ArrayList <Sede> sedes;
    
    public ListaSede (){
        ArrayList<Sede> sede = new ArrayList <>();
        this.sedes=sede;
    }
    
    public void setSedes(ArrayList sedes){
            this.sedes=sedes;
    }
    
    public ArrayList getSedes(){
            return sedes;
    }
    
    public Sede selectSede(ArrayList a,String c){
        int i;
        for(i=0;i<a.size();i++){
            Sede s = (Sede)a.get(i);
            if(s.getComuna().equals(c)) return s;
        }
        return null;
    }
    
    public ArrayList agruparOficinar(ArrayList todo,String region){
        ArrayList<Sede> ss=new ArrayList<>();
        int i;
        for(i=0;i<todo.size();i++){
            Sede s=(Sede)todo.get(i);
            if(s.getRegion().equals(region)) ss.add(s);
        }
        return ss;
    }
    
    @Override
    public void ActualizarExcel(Object O, File file) {
        int i,j;
        ListaSede s=(ListaSede)O;
        ArrayList <Sede> sede = s.getSedes();
        Sede sed;
        try{
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet hssfsheet = wb.createSheet();
            
            for(i=0;i<sede.size();i++){
                XSSFRow hssfRow = hssfsheet.createRow(i);
                sed=sede.get(i);
                for(j=0;j<2;j++){
                    XSSFCell hssfCell = hssfRow.createCell(j);
                    if(j==0){
                        hssfCell.setCellValue(sed.getRegion());
                    }else{
                        if(j==1){
                            hssfCell.setCellValue(sed.getComuna());
                        }
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
        ArrayList<Sede> s = new ArrayList <>();
        ArrayList<Persona> personas = new ArrayList <>();
        ArrayList<Cert> certificados = new ArrayList <>();
        ListaSede ls = (ListaSede)O;
        ListCertEmitidos lc=new ListCertEmitidos(certificados);
        ListaPersonas lp=new ListaPersonas(personas);
        int i,j;
        String region=null,comuna=null;
        lp=(ListaPersonas)lp.cargarExcel();
        lc=(ListCertEmitidos)lc.cargarExcel();
        personas=lp.getPersonas();
        certificados=lc.getListaCertificados();
        for (i=0;i<cellDataList.size();i++){
            List cellTempList = (List) cellDataList.get(i);
            
            for(j=0;j<cellTempList.size();j++){
                XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
                
                String stringCellValue = hssfCell.toString();
                switch(j){
                    case 0:
                        region=stringCellValue;
                        break;
                    case 1:
                        comuna=stringCellValue;
                        break;
                }
            }
            Sede sede=new Sede(region,comuna,lp.agruparPersonas(personas, comuna),lc.agruparCertSede(comuna,certificados));
            s.add(sede);
        }
        ls.setSedes(s);
        return ls;
    }

    @Override
    public Object cargarExcel(){
        ListaSede l=new ListaSede();
        File f=new File("sedes.xlsx");
        LeerExcel(l,f);
        return l;
    }
    
}
