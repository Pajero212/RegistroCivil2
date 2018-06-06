package registrocivil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ListaPersonas implements excel{
    private ArrayList <Persona> personas;
    
    public ListaPersonas (ArrayList personas){
        this.personas = new ArrayList <>();
        this.personas=personas;
    }
    
    public ListaPersonas(){
        ArrayList <Persona> aP = new ArrayList<>();
        this.personas=aP;
    }
    
    public void setPersonas(ArrayList personas){
            this.personas=personas;
    }
    
    public ArrayList getPersonas(){
            return personas;
    }
    
    public Persona buscarPersona(ArrayList aP,String rut){
        Persona user;
        int i;
        for(i=0;i<aP.size();i++){
            user=(Persona)aP.get(i);
            if(rut.equals(user.getRut())) return user;
        }
        System.out.println("No se encontro");
        return null;
    }
    
    public ListaPersonas agruparPersonas(ArrayList l,String comuna){
        ArrayList<Persona> p = new ArrayList<>();
        ListaPersonas p1 = new ListaPersonas (p);
        int i;
        for(i=0;i<l.size();i++){
            Persona persona = (Persona)l.get(i);
            if(comuna.equals(persona.getComuna()))p.add(persona);
        }
        p1.setPersonas(p);
        return p1;
    }
    
    public void modiPersona(Persona p){
        File f=new File("LibroPersona.xlsx");
        ArrayList <Persona> aP = new ArrayList<>();
        ListaPersonas l=new ListaPersonas(aP);
        l=(ListaPersonas)l.cargarExcel();
        aP=l.getPersonas();
        for(int i=0;i<aP.size();i++){
            Persona a = (Persona)aP.get(i);
            if(a.getRut().equals(p.getRut())) aP.remove(i);
        }
        aP.add(p);
        l.setPersonas(aP);
        l.ActualizarExcel(l, f);
    }

    @Override
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
            
        }
    }
    
    public boolean definirEstado(String s){
        boolean b=false;
        if(s.equals("1")){
            b=true;
        }
        return b;
    }
    
    public String conversionEstado(boolean b){
        String s=("0");
        if(b){
            s=("1");
        }
        return s;
    }
    
    public int retornaNum(String s){
        int i;
        i=Integer.parseInt(s);
        return i;
    }

    @Override
    public Object LeerExcel(Object O, File filename) {
        List cellData = new ArrayList();
        try{
            FileInputStream fileInputStream = new FileInputStream (filename);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

            XSSFSheet hssfsheet = workbook.getSheetAt(0);

            Iterator rowIterator = hssfsheet.rowIterator();

            while(rowIterator.hasNext()){
                XSSFRow hssfRow = (XSSFRow) rowIterator.next();

                Iterator iterator = hssfRow.cellIterator();
                List cellTemp = new ArrayList();

                while(iterator.hasNext()){
                    XSSFCell hssfCell = (XSSFCell) iterator.next();

                    cellTemp.add(hssfCell);
                }

                cellData.add(cellTemp);
            }

            }catch(IOException e){

            }
            return obtenerExcel(cellData,O);
    }

    @Override
    public Object obtenerExcel(List cellDataList, Object O) {
        int i,j;
        boolean add;
        Persona persona;
        boolean estado = false;
        ListaPersonas p = (ListaPersonas)O;
        ArrayList <Persona> personass = new ArrayList <>();
        String nombre=null,rut=null,apellidoP=null,estadocivil=null,apellidoM=null,sexo=null,nacionalidad=null,pass=null,sed=null,type=null,a=null,d=null,m=null;
        Fecha fecha,fechaDef=null;
        ListCertEmitidos l=null;
        Certificado cert=null;
        Carnet c=null;
        
        for (i=0;i<cellDataList.size();i++){
            List cellTempList = (List) cellDataList.get(i);
            
            for(j=0;j<cellTempList.size();j++){
                XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
                
                String stringCellValue = hssfCell.toString();
                
                switch(j){
                    case 0:
                    apellidoP=stringCellValue;
                    break;
                    case 1:
                    sexo=stringCellValue;
                    break;
                    case 2:
                    nombre=stringCellValue;
                    break;
                    case 3:
                    rut=stringCellValue;
                    break;
                    case 4:
                    pass=stringCellValue;
                    break;
                    case 5:
                    nacionalidad=stringCellValue;
                    break;
                    case 6:
                    apellidoM=stringCellValue;
                    break;
                    case 7:
                    sed=stringCellValue;
                    break;
                    case 8:
                    estadocivil=stringCellValue;
                    break;
                    case 9:
                    d=stringCellValue;
                    break;
                    case 10:
                    m=stringCellValue;
                    break;
                    case 11:
                    a=stringCellValue;
                    case 12:
                    type=stringCellValue;
                    case 13:
                    estado=p.definirEstado(stringCellValue);
                }
            }
            fecha=new Fecha(d,m,a);
            persona = new Persona(nombre,rut,apellidoP,estadocivil,apellidoM, sexo, nacionalidad, cert, c,pass,fecha,sed,l,fechaDef,type, estado) {};
            add=personass.add(persona);
        }
            p.setPersonas(personass);
            return p;
    }

    @Override
    public Object cargarExcel() {
        File f=new File("LibroPersona.xlsx");
        ArrayList<Persona> p = new ArrayList<>();
        ListaPersonas l = new ListaPersonas(p);
        return LeerExcel(l,f);
    }

}
