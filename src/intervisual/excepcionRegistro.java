package intervisual;

public class excepcionRegistro extends Exception {
    private static final long serialVersionUID = 700L;
     
    public excepcionRegistro(String mensaje){
        super(mensaje);
    }
}
