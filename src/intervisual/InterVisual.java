package intervisual;

import registrocivil.*;
import java.util.ArrayList;
import interfaz.*;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

public class InterVisual {

    public static void main(String[] args) {
        Regiones r=Regiones.getInstance();
        ArrayList <String> regiones=r.getRegiones();
        menu1(regiones);
    }
    
    /**
     *  Menu de Inicio, se le entrega el arreglo con las regiones cargadas
     *  Ofrece funcionalidades para el manejo de la interfaz grafica y 
     *  define su ubicacion y propiedades.
     * @param regiones 
     */
    public static void menu1(ArrayList regiones){
        Main1 m =new Main1(regiones);
        m.setLocation(250,120);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    public static void menuDatos(){
        String s=null;
        StringSubida ss=new StringSubida(s);
        s=ss.generarStringdatos();
        ss.setStringSubida(s);
        main2 m = new main2(ss);
        m.setLocation(250,120);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    public static void menuEstad(){
        String s=null;
        StringSubida ss=new StringSubida(s);
        s=ss.generarStringEstad();
        ss.setStringSubida(s);
        main2 m = new main2(ss);
        m.setLocation(250,120);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    public static void menuProblemas(){
        problemas m = new problemas();
        m.setLocation(250,120);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    /**
     * Menu de Inicio de Sesion, primero se valida la sede ingresada
     * luego se despliega la interfaz grafica para el usuario.
     * Se define ubicacion y propiedades de Interfaz
     * @param comuna 
     */
    public static void menu2(String comuna){
        ListaSede ls=ListaSede.getInstance();
        Sede sede=ls.selectSede(comuna);
        MenuIngresoUsuario m = new MenuIngresoUsuario(sede);
        m.setLocation(250,120);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    /**
     * Funcion encargada de verificar si los datos ingresados por el usuario,
     * corresponden a los datos de algun usuario registrado en el sistema, o en 
     * defecto, si son correctos.
     * @param rut
     * @param pass
     * @param sede 
     */
    public static void chequeoUser(String rut,String pass,Sede sede){
        ListaPersonas lp=sede.getPersonas();
        try{
        Persona user=lp.buscarPersona(rut);
            try{
                if(user.checkPass(user, pass)){
                    MenuInter(user);
                }
            }catch(excepcionRegistro e){
                System.out.println("Error: "+e.getMessage());
                menu2(sede.getComuna());
            }
        }catch(excepcionRegistro e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    /**
     * Menu encargado de verificar el tipo de usuario que ingreso al sistema,
     * en el caso de ser administrador se ofrece un menu distinto, con mayores
     * funcionalidades, en caso de ser un usuario corriente, se despliegan las 
     * funciones predeterminadas-.
     * @param p 
     */
    public static void MenuInter(Persona p){
        if(p instanceof Usuario){
            MenuUsuario(p);
        }else{
            MenuAdmin(p);
        }
    }
    
    /**
     * Menu Para Usuario corriente, ofrece las funcionalidades basicas del sistema
     * @param user 
     */
    public static void MenuUsuario(Persona user){
        MenuUsuario m=new MenuUsuario(user);
        m.setLocation(250,120);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    public static void MenuUCert(Persona user){
        MenuCerts m=new MenuCerts(user);
        m.setLocation(250,120);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    public static void MenuNac(Persona user){
        MenuCertNac m = new MenuCertNac(user);
        m.setLocation(250,120);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    public static void MenuMat(Persona user){
        definirEstadocivil m = new definirEstadocivil(user);
        m.setLocation(250,120);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    public static void MenuDef(Persona user){
        MenuCertDef m=new MenuCertDef(user);
        m.setLocation(250,120);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    public static void MenuPas(Persona user){
        MenuPass m=new MenuPass(user);
        m.setLocation(250,120);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    public static void MenuCertVer(Persona user){
        CertificadosVer m=new CertificadosVer(user);
        m.setLocation(250,120);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    public static void MenuCarton(Persona user){
        MenuCarnet m = new MenuCarnet(user);
        m.setLocation(250,120);
        m.setVisible(true);
        m.setResizable(false);
        m.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    
    public static void MenuAdmin(Persona user){
        MenuAdmin m= new MenuAdmin(user);
        m.setLocation(250,120);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    public static void MenuAprobCert(Persona user){
        AprobarCerti m= new AprobarCerti(user);
        m.setLocation(250,120);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    public static void MenuAgregarP(Persona user){
        MenuNuevaP m = new MenuNuevaP(user);
        m.setLocation(250,110);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    public static void MenuModificarP(Persona user){
        modiPersona m = new modiPersona(user);
        m.setLocation(250,110);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    public static void EliminaPersona(Persona user){
        deletePeople m = new deletePeople(user);
        m.setLocation(250,110);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    public static void EliminarSede(Persona user){
        deletesede m = new deletesede(user);
        m.setLocation(250,110);
        m.setVisible(true);
        m.setResizable(false);
    }
    
}
