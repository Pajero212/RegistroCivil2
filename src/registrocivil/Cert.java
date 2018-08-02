package registrocivil;

import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class Cert {
    private String cod;
    private String rut;
    private String rut2;
    private String sede;
    private boolean aprobado;
    
    public Cert(String cod,String rut,String sede){
        this.cod=cod;
        this.rut=rut;
        this.sede=sede;
        this.aprobado=false;
        this.rut2=null;
    }
    
    public Cert(String cod,String rut,String sede,String rut2){
        this.cod=cod;
        this.rut=rut;
        this.sede=sede;
        this.aprobado=false;
        this.rut2=rut2;
    }
    
    public Cert(String cod,String rut,String sede,boolean aprobado,String rut2){
        this.cod=cod;
        this.rut=rut;
        this.sede=sede;
        this.aprobado=aprobado;
        this.rut2=rut2;
    }
    
    public void setCod(String cod){
        this.cod=cod;
    }
    
    public void setRut2(String rut2){
        this.rut2=rut2;
    }
    
    public void setRut(String rut){
        this.rut=rut;
    }
    
    public void setSede(String sede){
        this.sede=sede;
    }
    
    public void setAprobado(boolean aprob){
        this.aprobado=aprob;
    }
    
    public String getCod(){
        return cod;
    }
    
    public String getRut(){
        return rut;
    }
    
    public String getSede(){
        return sede;
    }
    
    public boolean getAprobado(){
        return aprobado;
    }
    
    public String getRut2(){
        return rut2;
    }
    
    public Cert(List cellTempList){
        aprobado=false;
        XSSFCell hssfCell = (XSSFCell) cellTempList.get(0);
        String stringCellValue = hssfCell.toString();
        cod=stringCellValue;
        hssfCell = (XSSFCell) cellTempList.get(1);
        stringCellValue = hssfCell.toString();
        rut=stringCellValue;
        hssfCell = (XSSFCell) cellTempList.get(2);
        stringCellValue = hssfCell.toString();
        sede=stringCellValue;
        hssfCell = (XSSFCell) cellTempList.get(3);
        stringCellValue = hssfCell.toString();
        if(stringCellValue.equals("A")){
            aprobado=true;
        }
        hssfCell = (XSSFCell) cellTempList.get(4);
        stringCellValue = hssfCell.toString();
        rut2=stringCellValue;
    }
    
    
    
}
