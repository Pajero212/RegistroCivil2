package registrocivil;

import java.util.ArrayList;

public class CertNacimiento {
    private int cod; //identificador
    private String nombreH, rutH, apellidoPH, apellidoMH; //datos del padre
    private String nombreM, rutM, apellidoPM, apellidoMM; //datos de la madre
    private String nombreG, rutG, apellidoPG, apellidoMG; //datos del recien nacido
    private Fecha date;
    
    public CertNacimiento(String nombreH,String rutH,String apellidoPH,String apellidoMH,String nombreM,String rutM,String apellidoPM,String apellidoMM, String nombreG){
        this.cod=1;
        this.nombreH=nombreH;
        this.apellidoPH=apellidoPH;
        this.apellidoMH=apellidoMH;
        this.nombreM=nombreM;
        this.apellidoPM=apellidoPM;
        this.apellidoMM=apellidoMM;
        this.date=null;
        this.nombreG=nombreG;
        this.rutG=null;
        this.apellidoPG=apellidoPH;
        this.apellidoMG=apellidoPM;
    }
    
    public CertNacimiento(){
        this.cod=1;
        this.nombreH=null;
        this.apellidoPH=null;
        this.apellidoMH=null;
        this.nombreM=null;
        this.apellidoPM=null;
        this.apellidoMM=null;
        this.date=null;
        this.nombreG=null;
        this.rutG=null;
        this.apellidoPG=null;
        this.apellidoMG=null;
    }
    
    
    public void setNombreH(String nombreH){
        this.nombreH=nombreH;
    }
    
    public void setApellidoPH(String apellidoPH){
        this.apellidoPH=apellidoPH;
    }
    
    public void setApellidoMH(String apellidoMH){
        this.apellidoMH=apellidoMH;
    }
    
    public void setRutH(String rutH){
        this.rutH=rutH;
    }
    
    public void setNombreM(String nombreM){
        this.nombreM=nombreM;
    }
    
    public void setApellidoPM(String apellidoPM){
        this.apellidoPM=apellidoPM;
    }
    
    public void setApellidoMM(String apellidoMM){
        this.apellidoMM=apellidoMM;
    }
    
    public void setRutM (String rutM){
        this.rutM=rutM;
    }

    public void setFecha (Fecha date){
        this.date=date;
    }
    
    public void setCod (int cod){
        this.cod=cod;
    }
    
    public void setNombreG(String nombreG){
        this.nombreG=nombreG;
    }
    
    public void setApellidoPG(String apellidoPG){
        this.apellidoPG=apellidoPG;
    }
    
    public void setApellidoMG(String apellidoMG){
        this.apellidoMG=apellidoMG;
    }
    
    public void setRutG(String rutG){
        this.rutG=rutG;
    }
    
//========================================================================================================================================================== 
    
    public String getNombreH(){
        return nombreH;
    }
    
    public String getNombreM(){
        return nombreM;
    }
    
    public String getApellidoPH(){
        return apellidoPH;
    }
    
    public String getApellidoMH(){
        return apellidoMH;
    }
    
    public String getApellidoPM(){
        return apellidoPM;
    }
    
    public String getApellidoMM(){
        return apellidoMM;
    }
    
    public String getRutH(){
        return rutH;
    }
    
    public String getRutM(){
        return rutM;
    }
    
    public int getCod(){
        return cod;
    }
    
    public Fecha getDate(){
        return date;
    }
    
    public String getNombreG(){
        return nombreG;
    }

    public String getApellidoPG(){
        return apellidoPG;
    }
    
    public String getApellidoMG(){
        return apellidoMG;
    }
    
    public String getRutG(){
        return rutG;
    }
    
    public void menuNac(Persona p,String r){
        String c=("1");
        Cert certi = new Cert(c,p.getRut(),p.getComuna(),r);
        ListaCertSolicitados ls=new ListaCertSolicitados();
        ls=(ListaCertSolicitados)ls.cargarExcel();
        ArrayList<Cert> as=ls.getListaCertSolicitados();
        as.add(certi);
        ls.setListaCertSolicitados(as);
        ls.Actualizar(ls);
    }
    
}
