package intervisual;

import registrocivil.*;
import java.io.*;
import java.util.ArrayList;
import interfaz.*;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

public class InterVisual {

    public static void main(String[] args) throws IOException {
        RegistroCivil register=new RegistroCivil();
        Regiones r=new Regiones();
        ArrayList <String> regiones=(ArrayList)r.cargarExcel();
        menu1(register,regiones);
    }
    
    public static void menu1(RegistroCivil register,ArrayList regiones){
        ListaSede ls=register.getLista();
        Main1 m =new Main1(regiones,ls);
        m.setLocation(250,120);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    public static void menu2(String s){
        ListaSede ls=new ListaSede();
        ls=(ListaSede)ls.cargarExcel();
        Sede sede=ls.selectSede(ls.getSedes(), s);
        MenuIngresoUsuario m = new MenuIngresoUsuario(sede);
        m.setLocation(250,120);
        m.setVisible(true);
        m.setResizable(false);
    }
    
    public static void chequeoUser(String rut,String pass,Sede sede){
        ListaPersonas lp=sede.getPersonas();
        Persona user=lp.buscarPersona(lp.getPersonas(), rut);
        if(user.getPass().equals(pass)){
            MenuInter(user);
        }else{
            menu2(sede.getComuna());
        }
    }
    
    public static void MenuInter(Persona p){
        if(p.getType().equals("1.0")){
            MenuUsuario(p);
        }else{
            MenuAdmin(p);
        }
    }
    
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
        MenuCertMat m=new MenuCertMat(user);
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
    
}
