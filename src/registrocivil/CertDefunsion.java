package registrocivil;

import intervisual.excepcionRegistro;
import java.io.File;
import java.util.ArrayList;

public class CertDefunsion {
    private int cod; //identificador
    private String nombreH, rutH, apellidoPH, apellidoMH; //datos del fallecido
    private Fecha fecha;
    
    public CertDefunsion(String nombreH,String rutH,String apellidoPH,String apellidoMH,Fecha fecha){
        this.cod=3;
        this.nombreH=nombreH;
        this.apellidoPH=apellidoPH;
        this.apellidoMH=apellidoMH;
        this.fecha=fecha;
        this.rutH=rutH;
    }
    
    public CertDefunsion(){
        this.cod=3;
        this.nombreH=null;
        this.apellidoPH=null;
        this.apellidoMH=null;
        this.fecha=null;
        this.rutH=null;
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
    
    public void setCod(int cod){
        this.cod=cod;
    }
    
    public void setFecha(Fecha fecha){
        this.fecha=fecha;
    }
    
//======================================================================================================================================================

    public String getNombreH(){
        return nombreH;
    }
    
    public String getApellidoPH(){
        return apellidoPH;
    }
    
    public String getApellidoMH(){
        return apellidoMH;
    }
    
    public String getRutH(){
        return rutH;
    }
    
    public int getCod(){
        return cod;
    }
    
    public Fecha getFecha(){
        return fecha;
    }

    public void menuDef(Persona p,String r){
        ListaPersonas lp = ListaPersonas.getInstance();
        try{
        Persona p2 = lp.buscarPersona(r);
        String c=("3");
        Cert certi = new Cert(c,p.getRut(),p.getComuna(),r);
        ListaCertSolicitados ls=ListaCertSolicitados.getInstance();
        ArrayList<Cert> as=ls.getListaCertSolicitados();
        as.add(certi);
        ls.setListaCertSolicitados(as);
        ls.Actualizar(ls);
        }catch(excepcionRegistro e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    public void aprobadoCertDef(Persona p, String sede){
        File file=new File("LibroPersona.xlsx");
        ListaSede ls= ListaSede.getInstance();
        Sede s = ls.selectSede(sede);
        ListaPersonas lp=s.getPersonas();
        ArrayList<Persona> ap=lp.getPersonas();
        for (int i=0;i<ap.size();i++){
            Persona pp=(Persona)ap.get(i);
            if(pp.equals(p)) ap.remove(i);
        }
        lp.setPersonas(ap);
        lp.ActualizarExcel(lp, file);
    }
    
}
