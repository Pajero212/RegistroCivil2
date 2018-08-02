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

public class Regiones implements excel{
    
    private ArrayList<String> regions;
    private static Regiones rns;
    
    public static Regiones getInstance(){
        if(rns==null){
            File f=new File("regiones.xlsx");
            List lista=excel.LeerExcel(f);
            rns=(Regiones)Regiones.obtenerExcel(lista);
        }
        return rns;
    }
    
    private Regiones(){
        ArrayList<String> regiones = new ArrayList<>();
        this.regions=regiones;
    }

    private Regiones(ArrayList<String> regioness) {
        regions=regioness;
    }
    
    public void setRegiones(ArrayList regiones){
        this.regions=regiones;
    }
    
    public ArrayList getRegiones(){
        return regions;
    }

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

    public static Object obtenerExcel(List cellDataList) {
        int i,j;
        ArrayList<String> regioness=new ArrayList<>();
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
            regioness.add(region);
        }
        Regiones regiones=new Regiones(regioness);
        return regiones;
    }
    
}
