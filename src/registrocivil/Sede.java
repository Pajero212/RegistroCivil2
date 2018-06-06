package registrocivil;

import java.util.ArrayList;

public class Sede{
        private String nombreComuna;
	private String region;
        private ListaPersonas personas ;
        private ListCertEmitidos listCert;
	
        public Sede(String region,String nombreComuna,ListaPersonas personas,ListCertEmitidos cert) {
		this.region=region;
                this.listCert = cert;
		this.nombreComuna=nombreComuna;
                this.personas=personas;
	}
        
        public void setPersonas(ListaPersonas personas){
            this.personas=personas;
        }
        
        public void setListCert(ListCertEmitidos listCert){
            this.listCert=listCert;
        }
        
        public ListCertEmitidos getListCert(){
            return listCert;
        }
	
	public void setRegion(String region) {
		this.region=region;
	}
	
	public void setComuna(String nombreComuna) {
		this.nombreComuna=nombreComuna;
	}

	public String getRegion() {
		return region;
	}
	
	public String getComuna() {
		return nombreComuna;
	}

        public ListaPersonas getPersonas(){
            return personas;
        }
        /**
         * A PARTIR DEL RUT Y LA CONTRASEÑA, EL USUARIO
         * INGRESA LOS DATOS PARA PODER INGRESAR AL SISTEMA.
         * @param rut
         * @param list
         * @param pass
         * @return persona
         */
        public Persona Ingresar(String rut, ListaPersonas list, String pass){
            int i;
            Persona type;

            if(list.getPersonas() == null) return null;

            for(i=0;i<list.getPersonas().size();i++){
                
                type=(Persona)list.getPersonas().get(i);
                
                if(rut.equals(type.getRut()) && pass.equals(type.getPass())){
                    return type; //Se encontró Al usuario y la contraseña es correcta
                }else{
                    if(rut.equals(type.getRut()) && (!pass.equals(type.getPass()))){
                        return null; //La contraseña es incorrecta
                    }
                }
            }
            return null;
        }
        
        public Sede buscarSede(String s){
        ListaSede ls= new ListaSede();
        ls=(ListaSede)ls.cargarExcel();
        ArrayList<Sede> as = ls.getSedes();
        for(int i=0;i<as.size();i++){
            Sede ss=(Sede)as.get(i);
            if(ss.getComuna().equals(s)) return ss;
        }
        return null;
    }
        
    }
