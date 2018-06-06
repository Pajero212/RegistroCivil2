package registrocivil;

import java.util.ArrayList;

public abstract class Persona {
    private String rut;
    private String pass;
    private String nombre, apellidoP, apellidoM, estadocivil,nacionalidad,sexo,comuna;
    private Fecha fecha;//FechaNacimiento
    private Fecha fechaDef;
    private String type;
    private Boolean estado;
    private Certificado certificados;
    private Carnet carnet;
    private ListCertEmitidos cert;
    
    public Persona(String nombre,String rut,String apellidoP,String estadocivil,String apellidoM, String sexo, String nacionalidad, Certificado certificados, Carnet carnet,String pass,Fecha fecha,String comuna,ListCertEmitidos cert,Fecha fechaDef,String type, boolean estado){
        this.nombre=nombre;
        this.comuna=comuna;
        this.apellidoM=apellidoM;
        this.estadocivil=estadocivil;
        this.rut=rut;
        this.apellidoP=apellidoP;
        this.sexo=sexo;
        this.nacionalidad=nacionalidad;
        this.certificados=certificados;
        this.carnet=carnet;
        this.pass=pass;
        this.fecha=fecha;
        this.cert=cert;
        this.fechaDef=fechaDef;
        this.type=type;
        this.estado=estado;
    }
    
    public Persona(String nombre,String rut,String apellidoP,String estadocivil,String apellidoM, String sexo, String nacionalidad, String pass,Fecha fecha ,String comuna,String type,boolean estado){
        this.nombre=nombre;
        this.apellidoM=apellidoM;
        this.estadocivil=estadocivil;
        this.rut=rut;
        this.apellidoP=apellidoP;
        this.sexo=sexo;
        this.nacionalidad=nacionalidad;
        this.certificados=null;
        this.carnet=null;
        this.pass=pass;
        this.fecha=fecha;
        this.comuna=comuna;
        this.fechaDef=null;
        this.type=type;
        this.estado=estado;
    }
    
public void setComuna(String comuna){
        this.comuna=comuna;
}   

public void setCert(ListCertEmitidos cert){
        this.cert=cert;
}

public void setPass(String pass){
           this.pass=pass;
}   
   
public void setSexo(String sexo) {
	   this.sexo=sexo;
   }

public void setCarnet(Carnet carnet){
          this.carnet=carnet;
}

public void setCertificados(Certificado certificados){
          this.certificados=certificados;
}
   
   public void setNacionalidad(String nacionalidad) {
	   this.nacionalidad=nacionalidad;
   }
    
   public void setNombre(String nombre){
       this.nombre = nombre;
   }
   
   public void setRut(String rut){
       this.rut = rut;
   }
   
   public void setApellidoP(String apellidoP) {
	   this.apellidoP=apellidoP;
   }
   
   public void setApellidoM(String apellidoM) {
	   this.apellidoM=apellidoM;
   }
   
   public void setEstadocivil(String estadocivil) {
	   this.estadocivil=estadocivil;
   }
   
   public void setFecha(Fecha fecha){
            this.fecha=fecha;
   }
   
   public void setEstado(boolean estado){
       this.estado=estado;
   }
   
   public void setType(String type){
       this.type=type;
   }
   
   public void setFechaDef(Fecha fechaDef){
       this.fechaDef=fechaDef;
   }
   
   public String getNombre() {
	   return nombre;
   }
   
   public String getRut() {
	   return rut;
   }
   
   public String getApellidoP() {
	   return apellidoP;
   }
   
   public String getApellidoM() {
	   return apellidoM;
   }
   
   public String getEstadocivil() {
	   return estadocivil;
   }

   public String getSexo() {
	   return sexo;
   }
   
   public String getComuna(){
       return comuna;
   }
   
   public String getNacionalidad() {
	   return nacionalidad;
   }
   
   public Certificado getCertificados(){
           return certificados;
   }
   
   public Carnet getCarnet(){
           return carnet;
   }
   
   public String getPass(){
       return pass;
   }
   
   public Fecha getFecha(){
       return fecha;
   }
   
   public ListCertEmitidos getListCert(){
       return cert;
   }
   
   public Fecha getFechaDef(){
       return fechaDef;
   }
   
   public String getType(){
       return type;
   }
   
   public boolean getEstado(){
       return estado;
   }
   
   /**
     * CREA UNA INSTANCIA DE CARNET CON LOS DATOS ACTUALES DE LA PERSONA
     * @param persona
     * @param nDocumento
     * @param lugarNac
     * @param fechanac
     * @return Carnet
     */
    public Carnet generarCarnet(Persona persona, int nDocumento, String lugarNac,Fecha fechanac){
        Carnet carton = new Carnet(persona.getNombre(),persona.getRut(),persona.getApellidoP(),persona.getEstadocivil(),persona.getApellidoM(),nDocumento,lugarNac,persona.getSexo(),persona.getNacionalidad(),fechanac);
        return carton;
    }
    
    public ListaCertSolicitados menuCertEmi(Persona p){
        ListaCertSolicitados ls= new ListaCertSolicitados();
        ls=(ListaCertSolicitados)ls.cargarExcel();
        ArrayList <Cert> certi = ls.agruparCertPersona(p.getRut());
        ArrayList <Cert> cert2 = new ArrayList <>();
        Cert certif;
        int i;
        for(i=0;i<certi.size();i++){
        certif=(Cert)certi.get(i);
        if(certif.getAprobado()){
            cert2.add(certif);
            }
        }
        ls.setListaCertSolicitados(cert2);
        return ls;
    }
    
    public boolean checkPass(Persona p, String pass){
        boolean b=false;
        if(pass.equals(p.getPass())){
            b=true;
            return b;
        }
        return b;
    }
    
    public void Pass(Persona p,String pass1,String pass2){
        if(p.checkPass(p, pass1)){
           p.setPass(pass2);
        }
        ListaPersonas lP = new ListaPersonas();
        lP.modiPersona(p);
    }
    
    public void buscarCert(Usuario persona, Sede sede){
       ListCertEmitidos certpiv = sede.getListCert();
       ArrayList <Cert> certi;
       certi=certpiv.agruparCertPersona(persona.getRut());
       certpiv.setListaCertificados(certi);
       persona.setCert(certpiv);
   }
    
    public void menuCarnet(Persona p){
        p.generarCarnet(p, 0, null, null);
        System.out.println("Solicitud generada, la fecha para retirarlo se le notificara una vez listo.");
    }
    
}
