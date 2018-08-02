package registrocivil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;

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
        
        public Sede() {
		this.region=null;
                this.listCert = null;
		this.nombreComuna=null;
                this.personas=null;
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
        
        public void modiPersona(Persona p){
        File f=new File("LibroPersona.xlsx");
        ArrayList aP =personas.getPersonas();
        for(int i=0;i<aP.size();i++){
            Persona a = (Persona)aP.get(i);
            if(a.getRut().equals(p.getRut())) aP.remove(i);
        }
        aP.add(p);
        personas.setPersonas(aP);
        personas.ActualizarExcel(personas, f);
        }
        
        public void eliminarCert(){
            listCert.eliminarCertS(this);
        }        
        public Sede(List cellTempList,ListaPersonas lp, ListCertEmitidos lc){
            XSSFCell hssfCell = (XSSFCell) cellTempList.get(0);
            String stringCellValue = hssfCell.toString();
            region=stringCellValue;
            hssfCell = (XSSFCell) cellTempList.get(1);
            stringCellValue = hssfCell.toString();
            nombreComuna=stringCellValue;
            personas = lp.agruparPersonas(nombreComuna);
            listCert=lc.agruparCertSede(nombreComuna);
        }
        
    }
