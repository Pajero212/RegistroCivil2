package registrocivil;

import java.util.List;

public class Usuario extends Persona {
    
    public Usuario(String nombre, String rut, String apellidoP, String estadocivil, String apellidoM, String sexo, String nacionalidad, Certificado certificados, Carnet carnet, String pass, Fecha fecha, String comuna, ListCertEmitidos cert,Fecha fechaDef,String type, boolean estado) {
        super(nombre, rut, apellidoP, estadocivil, apellidoM, sexo, nacionalidad, certificados, carnet, pass, fecha, comuna, cert,fechaDef,type,estado);
    }
    
    public Usuario(List cellTempList){
        super(cellTempList);
    }
    
}
