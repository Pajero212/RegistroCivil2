package registrocivil;

public class Carnet {
    private int nDocumento; //identificador
    private String nombre, rut, apellidoP, apellidoM, estadocivil,nacionalidad,sexo,lugarNac;
    private int edad;
    private Fecha fecha;

public Carnet(String nombre,String rut,String apellidoP,String estadocivil,String apellidoM,int nDocumento, String lugarNac, String sexo,String nacionalidad,Fecha fecha){
    this.nombre=nombre;
    this.apellidoM=apellidoM;
    this.estadocivil=estadocivil;
    this.rut=rut;
    this.apellidoP=apellidoP;
    this.edad=0;
    this.nDocumento=nDocumento;
    this.nacionalidad=nacionalidad;
    this.sexo=sexo;
    this.lugarNac=lugarNac;
    this.fecha=fecha;
}

    public void setSexo(String sexo) {
       this.sexo=sexo;
    }

    public void setNacionalidad(String nacionalidad) {
       this.nacionalidad=nacionalidad;
    }

    public void setLugarNac(String lugarNac) {
            this.lugarNac=lugarNac;
    }

    public void setNDocumento(int nDocumento) {
            this.nDocumento=nDocumento;
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
   
   public void setEdad(int edad) {
	   this.edad=edad;
   }
   
   public void setFecha(Fecha fecha){
       this.fecha=fecha;
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
   
   public int getEdad() {
	   return edad;
   }
   
   public String getSexo() {
	   return sexo;
   }
   
   public String getNacionalidad() {
	   return nacionalidad;
   }
   
   public int getNDocumento() {
	   return nDocumento;
   }
   
   public String getLugarNac() {
	   return lugarNac;
   }
   
   public Fecha getFecha(){
       return fecha;
   }
}
