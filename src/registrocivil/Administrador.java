package registrocivil;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Persona {
    
    public Administrador(String nombre, String rut, String apellidoP, String estadocivil, String apellidoM, String sexo, String nacionalidad, Certificado certificados, Carnet carnet, String pass, Fecha fecha, String comuna, ListCertEmitidos cert,Fecha fechaDef,String type, boolean estado) {
        super(nombre, rut, apellidoP, estadocivil, apellidoM, sexo, nacionalidad, certificados, carnet, pass, fecha, comuna, cert,fechaDef,type,estado);
    }
    
    public Administrador(List cellTempList){
        super(cellTempList);
    }
    
    public ArrayList agruparCertNA(ArrayList<Cert> certificados){
        ArrayList <Cert> cert= new ArrayList<>();
        Cert certificado;
        int i;
        for(i=0;i<certificados.size();i++){
            certificado=certificados.get(i);
            if(!certificado.getAprobado()) {
                cert.add(certificado);
            }
        }
        return cert;
    }

    public ArrayList agruparCertA(ArrayList<Cert> certificados){
        ArrayList <Cert> cert= new ArrayList<>();
        Cert certificado;
        int i;
        for(i=0;i<certificados.size();i++){
            certificado=certificados.get(i);
            if(certificado.getAprobado()) {
                cert.add(certificado);
            }
        }
        return cert;
    }
    
    public void menuCertSol(Persona p,Boolean b){
        ListaCertSolicitados ls=ListaCertSolicitados.getInstance();
        ArrayList<Cert> certi=ls.getListaCertSolicitados();
        ArrayList<Cert> subida=new ArrayList<>();
        for(int i=0;i<certi.size();i++){
            Cert certificado =(Cert)certi.get(i);
                if(b){
                    certificado.setAprobado(true);
                    subida.add(certificado);
                }else{
                    subida.add(certificado);
                }
        ls.setListaCertSolicitados(subida);
        ls.Actualizar(ls);
        }

    }
    
}