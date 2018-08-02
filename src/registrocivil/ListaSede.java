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

public class ListaSede implements excel{
    private ArrayList <Sede> sedes;
    private static ListaSede ls;
    
    public static ListaSede getInstance(){
        if(ls==null){
            File f=new File("sedes.xlsx");
            List lista = excel.LeerExcel(f);
            ls=(ListaSede)ListaSede.obtenerExcel(lista);
        }
        return ls;
    }
    
    private ListaSede (){
        ArrayList<Sede> sede = new ArrayList <>();
        this.sedes=sede;
    }

    private ListaSede(ArrayList<Sede> s) {
        sedes=s;
    }
    
    public void setSedes(ArrayList sedes){
            this.sedes=sedes;
    }
    
    public ArrayList getSedes(){
            return sedes;
    }
    
    public Sede selectSede(String c){
        int i;
        for(i=0;i<sedes.size();i++){
            Sede s = (Sede)sedes.get(i);
            if(s.getComuna().equals(c)) return s;
        }
        return null;
    }
    
    public void eliminarSede(Sede s){
        for(int i=0;i<sedes.size();i++){
            Sede ss = (Sede)sedes.get(i);
            if(ss.getComuna().equals(s.getComuna())){
                ss.eliminarCert();
                sedes.remove(i);
            }
        }
        File f=new File("sedes.xlsx");
        this.ActualizarExcel(this, f);
    }
    
    public ArrayList agruparOficinar(String region){
        ArrayList<Sede> ss=new ArrayList<>();
        int i;
        for(i=0;i<sedes.size();i++){
            Sede s=(Sede)sedes.get(i);
            if(s.getRegion().equals(region)) ss.add(s);
        }
        return ss;
    }

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
                System.out.println("\nError: "+ex.getMessage());
            }
        }catch(IOException e){
            System.out.println("\nError: "+e.getMessage());
        }
    }

    public static Object obtenerExcel(List cellDataList) {
        ArrayList<Sede> s = new ArrayList <>();
        ListaPersonas lp = ListaPersonas.getInstance();
        ListCertEmitidos lc = ListCertEmitidos.getInstance();
        int i;
        for (i=0;i<cellDataList.size();i++){
            List cellTempList = (List) cellDataList.get(i);
            Sede sede=new Sede(cellTempList,lp,lc);
            s.add(sede);
        }
        ListaSede list = new ListaSede(s);
        return list;
    }
    
}
