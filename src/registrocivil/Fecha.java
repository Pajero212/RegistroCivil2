package registrocivil;

public class Fecha {
    
    private String dia,mes,agno;

    public Fecha(String dia,String mes,String agno) {
            this.agno=agno;
            this.mes=mes;
            this.dia=dia;
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
}
