package intervisual;

import java.util.ArrayList;
import registrocivil.Cert;
import registrocivil.CertNacimiento;
import registrocivil.CertMatrimonio;
import registrocivil.CertDefunsion;
import registrocivil.Fecha;
import registrocivil.ListaCertSolicitados;
import registrocivil.ListaPersonas;
import registrocivil.Persona;

public class StringSubida {
    private String todo;
    
    public StringSubida(String todo){
        this.todo=todo;
    }
    
    public StringSubida(CertNacimiento cert, String nombreSede,String nombre){
        todo=("circunscripcion: "+nombreSede+"\n\n\n\n"+"Nombre Inscrito: "+nombre+" "+cert.getApellidoPH()+" "+cert.getApellidoPM());
        todo=todo+"\n"+"Rut: "+cert.getRutG()+"\n";
        todo=todo+"\nNombre Padre: "+cert.getNombreH()+" "+cert.getApellidoPH()+" "+cert.getApellidoMH()+"\n";
        todo=todo+"Rut Padre: "+cert.getRutH()+"\n";
        todo=todo+"\nNombre Madre: "+cert.getNombreM()+" "+cert.getApellidoPM()+" "+cert.getApellidoMM()+"\n";
        todo=todo+"Rut Madre: "+cert.getRutM()+"\n";
        todo=todo+"\n\n\n\n *  PARA SER PRESENTADO EN INSTITUCIONES PREVISIONALES   *";
    }
    
    public StringSubida(CertMatrimonio cert,String nombreSede){
        String rp = cert.getRutH();
        ListaPersonas ls = ListaPersonas.getInstance();
        try{
        Persona p = ls.buscarPersona(rp);
        todo=("circunscripcion: "+nombreSede);
        todo=todo+"\n\n\nNombre Solicitante: "+cert.getNombreH()+" "+cert.getApellidoPH()+" "+cert.getApellidoMH()+"\n";
        todo=todo+"Rut Solicitante: "+cert.getRutH()+"\n";
        todo=todo+"Estado civil Actual: "+p.getEstadocivil()+"\n\n";
        todo=todo+"\nNombre Pareja: "+cert.getNombreM()+" "+cert.getApellidoPM()+" "+cert.getApellidoMM()+"\n";
        todo=todo+"Rut Pareja: "+cert.getRutM()+"\n";
        todo=todo+"\n\n\n\n *  PARA SER PRESENTADO EN INSTITUCIONES PREVISIONALES   *";
        }catch(excepcionRegistro e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    public StringSubida(CertDefunsion cert,String nombreSede){
        todo=("circunscripcion: "+nombreSede);
        todo=todo+"\n\n\nNombre Difunto: "+cert.getNombreH()+" "+cert.getApellidoPH()+" "+cert.getApellidoMH()+"\n";
        todo=todo+"Rut Difunto: "+cert.getRutH()+"\n";
        todo=todo+"\n\n\n\n *  PARA SER PRESENTADO EN INSTITUCIONES PREVISIONALES   *";
    }
    
    public StringSubida(Persona p,String nombreSede){
        todo=("circunscripcion: "+nombreSede+"\n\n\n");
        todo=todo+("Nombre del Solicitante:"+p.getNombre()+" "+p.getApellidoP()+" "+p.getApellidoM()+"\n\n");
        todo=todo+("     Mediante el presente Documento, se certifica que el estado civil de la persona es: "+p.getEstadocivil());
        todo=todo+"\n\n\n\n *  PARA SER PRESENTADO EN INSTITUCIONES PREVISIONALES   *";
    }

    public void setStringSubida(String todo){
        this.todo=todo;
    }
    
    public String getStringSubida(){
        return todo;
    }
    
    public int obtenerTamanio(ArrayList ac,int num){
        int tamanio=0;
        for(int i=0;i<ac.size();i++){
            Cert certi = (Cert)ac.get(i);
            if(certi.getCod().equals(Integer.toString(num))){
                tamanio++;
            }
        }
        return tamanio;
    }
    
    public String generarStringdatos(){
        ListaCertSolicitados lc = ListaCertSolicitados.getInstance();
        ArrayList ac = lc.getListaCertSolicitados();
        int tamanio = ac.size();
        String ca = Integer.toString(tamanio);
        Fecha f = new Fecha();
        f=f.fechaHoy();
        todo=(f.getDia()+"/"+f.getMes()+"/"+f.getAgno());
        todo=todo+("\n\n\nActualmente se han solicitado "+ca+" Certificados");
        todo=todo+("\n de los cuales:\n");
        int a,b,c;
        a=obtenerTamanio(ac,1);
        todo =todo +("        Se han solicitado "+tamanio+" Certificados de Nacimiento");
        b=obtenerTamanio(ac,2);
        todo =todo +("\n        Se han solicitado "+tamanio+" Certificados de Matrimonio");
        c=obtenerTamanio(ac,3);
        todo =todo +("\n        Se han solicitado "+tamanio+" Certificados de Defuncion");
        todo=todo+("\n\nCon lo que se puede deducir que actualmente:");
        
        if(a>c){
            todo=todo+("\n Nacen más personas que las que fallecen.");
        }else{
            todo=todo+("\n Fallecen más personas de las que nacen.");
        }
        
        ListaPersonas lp = ListaPersonas.getInstance();
        ArrayList ap = lp.getPersonas();
        tamanio=ap.size();
        ca=Integer.toString(tamanio);
        todo=todo+("\n\nActualmente la población es de "+ca+" habitantes");
        tamanio=0;
        for(int i=0;i<ap.size();i++){
            Persona p = (Persona)ap.get(i);
            if(p.getEstadocivil().equals("soltero") ||  p.getEstadocivil().equals("Soltero")){
                tamanio++;
            }
        }
        todo=todo+("\n"+tamanio+" están solteros");
        return todo;
    }
    
    public String generarStringEstad(){
        ListaPersonas lp = ListaPersonas.getInstance();
        Fecha f = new Fecha();
        f=f.fechaHoy();
        todo=(f.getDia()+"/"+f.getMes()+"/"+f.getAgno());
        todo=todo+"\n\nEl Presente Documento Entrega Informacion respecto a las tasas de estadisticas poblacionales, "
                + "acorde a los datos manejados dentro del sistema, por lo tanto los datos entregados pueden no asemejarse a la realidad nacional"+"\n\n\n" ;
        todo=todo+"Tasa de Natalidad (Tn): \n";
        todo=todo+this.tasaNatalidad(lp);
        todo=todo+"\nTasa de Mortalidad (Tm): \n";
        todo=todo+this.tasaMortalidad(lp);
        todo=todo+"\nTasa de Mortalidad Infantil (Tmi): \n";
        todo=todo+this.tasaMortalidadInfantil(lp);
        todo=todo+"\nTasa de Crecimiento Natural (Tcn): \n";
        todo=todo+(this.tasaNatalidad(lp)-this.tasaMortalidad(lp));
        todo=todo+"\nCrecimiento Natural (CN): \n";
        todo=todo+this.CrecimientoNatural(lp);
        todo=todo+"\nTasa de Divorcio (Td): \n";
        todo=todo+this.tasaDivorcio(lp);
        return todo;
    }
    
    public int tasaDivorcio(ListaPersonas lp){
        int cant=lp.cantDivorcios();
        if(cant!=0){
            int tasa = (cant/lp.cantTotal())*1000;
            return tasa;
        }
        return 0;
    }
    
    public int tasaNatalidad(ListaPersonas lp){
        int cant=lp.cantNacidosAhora();
        if(cant!=0){
            int tasa=(cant/lp.cantTotal())*1000;
            return tasa;
        }
        return 0;
    }
    
    public int tasaMortalidad(ListaPersonas lp){
        int cant=lp.cantMuertosAhora();
        if(cant!=0){
            int tasa=(cant/lp.cantTotal())*1000;
            return tasa;
        }
        return 0;
    }
    
    public int CrecimientoNatural(ListaPersonas lp){
        return (lp.cantNacidosAhora()-lp.cantMuertosAhora());
    }
    
    public int tasaMortalidadInfantil(ListaPersonas lp){
        int cant=lp.cantMuertosPeque();
        if(cant!=0){
            int tasa=(cant/lp.cantTotal())*1000;
            return tasa;
        }
        return 0;
    }

    
}
