package registrocivil;

public class Certificado {
    
    private CertMatrimonio matrimonio;
    private CertNacimiento nacimiento;
    private CertDefunsion  defunsion;
    
    public Certificado (CertMatrimonio matrimonio, CertNacimiento nacimiento, CertDefunsion defunsion){
        this.defunsion=defunsion;
        this.nacimiento=nacimiento;
        this.matrimonio=matrimonio;
    }
    
    public Certificado (){
        this.defunsion=null;
        this.nacimiento=null;
        this.matrimonio=null;
    }
    
    public void setCertMatrimonio(CertMatrimonio matrimonio){
        this.matrimonio=matrimonio;
    }
    
    public void setCertDefunsion (CertDefunsion defunsion){
        this.defunsion=defunsion;
    }
    
    public void setCertNacimiento (CertNacimiento nacimiento){
        this.nacimiento=nacimiento;
    }
    
    public CertNacimiento getCertNacimiento(){
        return nacimiento;
    }
    
    public CertDefunsion getCertdefunsion(){
        return defunsion;
    }
    
    public CertMatrimonio getCertMatrimonio(){
        return matrimonio;
    }
}

