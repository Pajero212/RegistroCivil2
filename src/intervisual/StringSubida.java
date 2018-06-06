package intervisual;

import registrocivil.CertNacimiento;
import registrocivil.CertMatrimonio;
import registrocivil.CertDefunsion;

public class StringSubida {
    private String todo;
    
    public StringSubida(String todo){
        this.todo=todo;
    }
    
    public void setStringSubida(String todo){
        this.todo=todo;
    }
    
    public String getStringSubida(){
        return todo;
    }
    
    public String generarStringNac(CertNacimiento cert,String nombreSede){
        todo=("circunscripcion: "+nombreSede+"\n"+"Nombre Inscrito: "+cert.getNombreG()+" "+cert.getApellidoPH()+" "+cert.getApellidoPM());
        todo=todo+"\n"+"Rut: "+cert.getRutG()+"\n";
        todo=todo+"Nombre Padre: "+cert.getNombreH()+" "+cert.getApellidoPH()+" "+cert.getApellidoMH()+"\n";
        todo=todo+"Rut Padre: "+cert.getRutH()+"\n";
        todo=todo+"Nombre Madre: "+cert.getNombreM()+" "+cert.getApellidoPM()+" "+cert.getApellidoMM()+"\n";
        todo=todo+"Rut Madre: "+cert.getRutM()+"\n";
        todo=todo+"*  PARA SER PRESENTADO EN INSTITUCIONES PREVISIONALES   *";
        return todo;
    }
    
    public String generarStringMat(CertMatrimonio cert,String nombreSede){
        todo=("circunscripcion: "+nombreSede);
        todo=todo+"Nombre Novio: "+cert.getNombreH()+" "+cert.getApellidoPH()+" "+cert.getApellidoMH()+"\n";
        todo=todo+"Rut Novio: "+cert.getRutH()+"\n";
        todo=todo+"Nombre Novia: "+cert.getNombreM()+" "+cert.getApellidoPM()+" "+cert.getApellidoMM()+"\n";
        todo=todo+"Rut Novia: "+cert.getRutM()+"\n";
        todo=todo+"*  PARA SER PRESENTADO EN INSTITUCIONES PREVISIONALES   *";
        return todo;
    }
    
    public String generarStringDef(CertDefunsion cert,String nombreSede){
        todo=("circunscripcion: "+nombreSede);
        todo=todo+"Nombre Difunto: "+cert.getNombreH()+" "+cert.getApellidoPH()+" "+cert.getApellidoMH()+"\n";
        todo=todo+"Rut Difunto: "+cert.getRutH()+"\n";
        todo=todo+"*  PARA SER PRESENTADO EN INSTITUCIONES PREVISIONALES   *";
        return todo;
    }
    
}
