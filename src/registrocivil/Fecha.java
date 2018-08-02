package registrocivil;

import java.util.Calendar;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class Fecha {
    
    private String dia,mes,agno;

    public Fecha(String dia,String mes,String agno) {
            this.agno=agno;
            this.mes=mes;
            this.dia=dia;
    }
    
    public Fecha() {
            this.agno=null;
            this.mes=null;
            this.dia=null;
    }
    
    public Fecha(List cellTempList){
        XSSFCell hssfCell = (XSSFCell) cellTempList.get(9);
        String stringCellValue = hssfCell.toString();
        dia=stringCellValue;
        hssfCell = (XSSFCell) cellTempList.get(10);
        stringCellValue = hssfCell.toString();
        mes=stringCellValue;
        hssfCell = (XSSFCell) cellTempList.get(11);
        stringCellValue = hssfCell.toString();
        agno=stringCellValue;
    }

    public void setDia(String dia) {
            this.dia=dia;
    }

    public void setMes(String mes) {
            this.mes=mes;
    }

    public void setAgno(String agno) {
            this.agno=agno;
    }

    public String getAgno() {
            return agno;
    }

    public String getDia() {
            return dia;
    }

    public String getMes() {
            return mes;
    }
    
    public boolean nacidoAhora(){
        Fecha f=this.fechaHoy();
        return f.getAgno().equals(agno);
    }
    
    public boolean murioAhora(){
        Fecha f=this.fechaHoy();
        return f.getAgno().equals(agno);
    }
    
    public boolean murioMenor(Fecha f){
        return (f.getAgno() == null ? agno == null : f.getAgno().equals(agno));
    }
    
    public Fecha fechaHoy(){
        Calendar c1 = Calendar.getInstance();
        String day = Integer.toString(c1.get(Calendar.DATE));
        String month = Integer.toString(c1.get(Calendar.MONTH));
        String year = Integer.toString(c1.get(Calendar.YEAR));
        Fecha f= new Fecha(day,month,year);
        return f;
    }
    
}
