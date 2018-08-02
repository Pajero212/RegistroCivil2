package registrocivil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface excel {
    
    //public void ActualizarExcel(Object O,File file);
    
    public static List LeerExcel(File filename){
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
        return cellData;
    }
    
}
