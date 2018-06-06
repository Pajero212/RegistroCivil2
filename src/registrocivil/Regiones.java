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

public class Regiones implements excel{
    
    ArrayList<String> regions;
    
    public Regiones(){
        ArrayList<String> regiones = new ArrayList<>();
        this.regions=regiones;
    }
    
    public void setRegiones(ArrayList regiones){
        this.regions=regiones;
    }
    
    public ArrayList getRegiones(){
        return regions;
    }

    @Override
    public void ActualizarExcel(Object O, File file) {
        int i,j;
        ArrayList <String> regiones =(ArrayList)O;
        String region;
        try{
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet hssfsheet = wb.createSheet();
            
            for(i=0;i<regiones.size();i++){
                XSSFRow hssfRow = hssfsheet.createRow(i);
                region=regiones.get(i);
                for(j=0;j<3;j++){
                    XSSFCell hssfCell = hssfRow.createCell(j);
                    if(j==0){
                        hssfCell.setCellValue(region);
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
        ArrayList<String> regiones=(ArrayList)O;
        String region=null;
        for (i=0;i<cellDataList.size();i++){
            List cellTempList = (List) cellDataList.get(i);
            
            for(j=0;j<cellTempList.size();j++){
                XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
                
                String stringCellValue = hssfCell.toString();
                switch(j){
                    case 0:
                        region=stringCellValue;
                        break;
                }
            }
            regiones.add(region);
        }
        return regiones;
    }

    @Override
    public Object cargarExcel() {
        ArrayList <String> s = new ArrayList<>();
        File f=new File("regiones.xlsx");
        LeerExcel(s,f);
        return s;
    }
    
}
