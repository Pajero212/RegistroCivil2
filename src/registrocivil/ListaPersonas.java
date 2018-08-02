package registrocivil;

import intervisual.excepcionRegistro;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ListaPersonas implements excel{
    private ArrayList <Persona> personas;
    private static ListaPersonas ls;
    
    public static ListaPersonas getInstance(){
        if(ls==null){
            File f=new File("LibroPersona.xlsx");
            List lista = excel.LeerExcel(f);
            ls= (ListaPersonas)ListaPersonas.obtenerExcel(lista);
        }
        return ls;
    }
    
    private ListaPersonas(){
        ArrayList <Persona> aP = new ArrayList<>();
        this.personas=aP;
    }

    private ListaPersonas(ArrayList<Persona> p) {
        personas=p;
    }
    
    public void setPersonas(ArrayList personas){
            this.personas=personas;
    }
    
    public ArrayList getPersonas(){
            return personas;
    }
    
    public Persona buscarPersona(String rut) throws excepcionRegistro{
        Persona user;
        int i;
        for(i=0;i<personas.size();i++){
            user=(Persona)personas.get(i);
            if(rut.equals(user.getRut())) return user;
        }
        throw new excepcionRegistro("Persona no Valida");
    }
    
    public int cantDivorcios(){
        int cant=0;
        for(int i=0;i<personas.size();i++){
            Persona user=(Persona)personas.get(i);
            if(user.esDivorciade()) cant++;
        }
        return cant;
    }
    
    public int cantTotal(){
        return personas.size();
    }
    
    public int cantNacidosAhora(){
        int cant=0;
        for(int i=0;i<personas.size();i++){
            Persona user=(Persona)personas.get(i);
            if(user.nacidoAhora()) cant ++;
        }
        return cant;
    }
    
    public int cantMuertosAhora(){
        int cant=0;
        for(int i=0;i<personas.size();i++){
            Persona user=(Persona)personas.get(i);
            if(user.muertoAhora()) cant ++;
        }
        return cant;
    }
    
    public int cantMuertosPeque(){
        int cant=0;
        for(int i=0;i<personas.size();i++){
            Persona user=(Persona)personas.get(i);
            if(user.murioMenor()) cant ++;
        }
        return cant;
    }
    
    public ListaPersonas agruparPersonas(String comuna){
        ArrayList<Persona> p = new ArrayList<>();
        int i;
        for(i=0;i<personas.size();i++){
            Persona persona = (Persona)personas.get(i);
            if(comuna.equals(persona.getComuna()))p.add(persona);
        }
        return (new ListaPersonas (p));
    }
    
    public void actualizable(Persona p){
        for(int i=0; i<personas.size();i++){
            Persona pp = (Persona)personas.get(i);
            if(pp.getRut().equals(p.getRut()))personas.remove(i);
        }
        personas.add(p);
        this.setPersonas(personas);
        File file = new File("LibroPersona.xlsx");
        this.ActualizarExcel(this, file);
    }
    
    public void eliminarP(Persona p){
        for(int i=0;i<personas.size();i++){
            Persona pp = (Persona)personas.get(i);
            if(pp.getRut().equals(p.getRut())){
                pp.eliminarCert();
                personas.remove(i);
            }
        }
        File file = new File("LibroPersona.xlsx");
        this.ActualizarExcel(this, file);
    }
    
    public void ActualizarExcel(Object O, File file) {
        int i,j;
        ListaPersonas p=(ListaPersonas)O;
        ArrayList <Persona> persona = p.getPersonas();
        Persona people;
        Fecha date;
        try{     
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet hssfsheet = wb.createSheet();
            for(i=0;i<persona.size();i++){
                XSSFRow hssfRow = hssfsheet.createRow(i);
                people=persona.get(i);
                date=people.getFecha();
                for(j=0;j<=13;j++){
                    XSSFCell hssfCell = hssfRow.createCell(j);
                    switch(j){
                        case 0:
                            hssfCell.setCellValue(people.getApellidoP());
                            break;
                        case 1:
                            hssfCell.setCellValue(people.getSexo());
                            break;
                        case 2:
                            hssfCell.setCellValue(people.getNombre());
                            break;
                        case 3:
                            hssfCell.setCellValue(people.getRut());
                            break;
                        case 4:
                            hssfCell.setCellValue(people.getPass());
                            break;
                        case 5:
                            hssfCell.setCellValue(people.getNacionalidad());
                            break;
                        case 6:
                            hssfCell.setCellValue(people.getApellidoM());
                            break;
                        case 7:
                            hssfCell.setCellValue(people.getComuna());
                            break;
                        case 8:
                            hssfCell.setCellValue(people.getEstadocivil());
                            break;
                        case 9:
                            hssfCell.setCellValue(date.getDia());
                            break;
                        case 10:
                            hssfCell.setCellValue(date.getMes());
                            break;
                        case 11:
                            hssfCell.setCellValue(date.getAgno());
                            break;
                        case 12:
                            hssfCell.setCellValue(people.getType());
                            break;
                        case 13:
                            hssfCell.setCellValue(p.conversionEstado(people.getEstado()));
                            break;
                    }
                }
            }
            try (FileOutputStream fsIP = new FileOutputStream(file)) {
                wb.write(fsIP);
            }catch(FileNotFoundException ex){

            }
        }catch(IOException e){
            System.out.println("\nError: "+e.getMessage());
        }
    }
    
    public String conversionEstado(boolean b){
        String s=("0");
        if(b){
            s=("1");
        }
        return s;
    }

    public static Object obtenerExcel(List cellDataList) {
        int i;
        ListaPersonas p = new ListaPersonas();
        ArrayList <Persona> personass = new ArrayList <>();
        
        for (i=0;i<cellDataList.size();i++){
            List cellTempList = (List) cellDataList.get(i);
            XSSFCell hssfCell = (XSSFCell) cellTempList.get(12);
            String s = hssfCell.toString();
            if(s.equals("1")){
                Usuario usuario = new Usuario(cellTempList);
                personass.add(usuario);
            }else{
                Administrador administrador = new Administrador(cellTempList);
                personass.add(administrador);
            }
        }
            p.setPersonas(personass);
            return p;
    }

}
