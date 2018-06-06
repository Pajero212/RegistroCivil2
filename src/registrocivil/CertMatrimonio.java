package registrocivil;

import java.util.ArrayList;

public class CertMatrimonio {
    private int cod; //identificador
    private String nombreH, rutH, apellidoPH, apellidoMH; //Datos del Novio
    private String nombreM, rutM, apellidoPM, apellidoMM; //Datos de la Novia
    private String estado;
    private Fecha  fecha;
    
    public CertMatrimonio(String nombreH,String rutH,String apellidoPH,String apellidoMH,String nombreM,String rutM,String apellidoPM,String apellidoMM, String estado){
        this.cod=2;
        this.nombreH=nombreH;
        this.apellidoPH=apellidoPH;
        this.apellidoMH=apellidoMH;
        this.nombreM=nombreM;
        this.apellidoPM=apellidoPM;
        this.apellidoMM=apellidoMM;
        this.estado=estado;
        this.rutH=rutH;
        this.rutM=rutM;
    }
    
    public CertMatrimonio(String nombreH,String rutH,String apellidoPH,String apellidoMH, String estado){
        this.cod=2;
        this.nombreH=nombreH;
        this.apellidoPH=apellidoPH;
        this.apellidoMH=apellidoMH;
        this.nombreM=null;
        this.apellidoPM=null;
        this.apellidoMM=null;
        this.estado=estado;
        this.rutH=rutH;
        this.rutM=null;
    }
    
    public CertMatrimonio(){
        this.cod=2;
        this.nombreH=null;
        this.apellidoPH=null;
        this.apellidoMH=null;
        this.nombreM=null;
        this.apellidoPM=null;
        this.apellidoMM=null;
        this.estado=null;
        this.rutH=null;
        this.rutM=null;
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
    
    public void setEstado (String estado){
        this.estado=estado;
    }
    
    public void setFecha (Fecha fecha){
        this.fecha=fecha;
    }
    
    public void setCod (int cod){
        this.cod=cod;
    }
 
//=====================================================================================================================================================    
    
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
    
    public String getEstado(){
        return estado;
    }
    
    public int getCod(){
        return cod;
    }
    
    public Fecha getFecha(){
        return fecha;
    }
    
    public void menuMat(Persona p,String r){
        String c=("2");
        Cert certi = new Cert(c,p.getRut(),p.getComuna(),r);
        ArrayList<Cert> ac=new ArrayList<>();
        ListCertEmitidos lc=new ListCertEmitidos(ac);
        ac=lc.chequeoCert(p);
        ac.add(certi);
        lc.setListaCertificados(ac);
        p.setCert(lc);
    }
    
}
