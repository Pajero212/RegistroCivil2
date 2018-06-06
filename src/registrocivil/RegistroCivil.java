package registrocivil;

public class RegistroCivil{
    private ListaSede lista;
    private ListaCertSolicitados lcs;
    
    public RegistroCivil(){
        ListaSede l=new ListaSede();
        ListaCertSolicitados ls= new ListaCertSolicitados();
        RegistroCivil register = new RegistroCivil((ListaSede)l.cargarExcel(),(ListaCertSolicitados)ls.cargarExcel());
    }
    
    public RegistroCivil(ListaSede lista,ListaCertSolicitados l){
        this.lista=lista;
        this.lcs=l;
    }
    
    public void setLista(ListaSede lista){
        this.lista=lista;
    }
    
    public void setLCS(ListaCertSolicitados l){
        this.lcs=l;
    }
    
    public ListaSede getLista(){
        return lista;
    }
    
    public ListaCertSolicitados getLCS(){
        return lcs;
    }
    
}
