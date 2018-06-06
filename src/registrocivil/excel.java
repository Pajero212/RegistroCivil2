package registrocivil;

import java.io.File;
import java.util.List;

public interface excel {
    
    public void ActualizarExcel(Object O,File file);
    public Object LeerExcel(Object O,File filename);
    public Object obtenerExcel(List cellDataList,Object O);
    public Object cargarExcel();
    
}
