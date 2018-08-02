package interfaz;

import intervisual.InterVisual;
import intervisual.StringSubida;
import intervisual.excepcionRegistro;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import registrocivil.ListaCertSolicitados;
import registrocivil.Cert;
import registrocivil.CertDefunsion;
import registrocivil.CertMatrimonio;
import registrocivil.CertNacimiento;
import registrocivil.Fecha;
import registrocivil.ListaPersonas;
import registrocivil.Persona;

public class CertificadosVer extends javax.swing.JFrame {
    StringSubida s;
    DefaultListModel modeloLista;
    Persona p;
    Map <String,Object> mapa;
    String name;
    
    public CertificadosVer(Persona p) {
        ListaCertSolicitados list = ListaCertSolicitados.getInstance();
        ArrayList <Cert> al= list.agruparCertPersona(p.getRut());
        Map <String,Object> map = new HashMap <>();
        initComponents();
        modeloLista=new DefaultListModel();
        String cod;
        this.p=p;
        Cert cert;
        for(int i=0;i<al.size();i++){
            cert = (Cert)al.get(i);
            cod=cert.getCod();
            switch(cod){
                case ("1"):
                    cod="Certificado Nacimiento";
                    break;
                case ("2"):
                    cod="Certificado Matrimonio";
                    break;
                case ("3"):
                    cod="Certificado Defunsion";
                    break;
            }
            if(cert.getAprobado()){
                cod=cod+", APROBADO";
            }else{
                cod=cod+", PENDIENTE";
            }
            map.put(cod, cert);
            modeloLista.addElement(cod);
        }
        mapa=map;
        jlista.setModel(modeloLista);
    }
    
    public void generarCertnac(Cert cert,String nombre){
        ListaPersonas lp = ListaPersonas.getInstance();
        try{
            Persona pareja=lp.buscarPersona(cert.getRut2());
            CertNacimiento cn = new CertNacimiento(p.getNombre(),p.getRut(),p.getApellidoP(),p.getApellidoM(),pareja.getNombre(),pareja.getRut(),pareja.getApellidoP(),pareja.getApellidoM(), nombre);
            cn.certAprobado("nombre", p.getApellidoP(), pareja.getApellidoP(), "--", p.getComuna());
            s= new StringSubida(cn,p.getComuna(),nombre);
            String txt = s.getStringSubida();
            System.out.println(txt);
        }catch(excepcionRegistro e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    public void generarCertMat(Cert cert){
        ListaPersonas lp = ListaPersonas.getInstance();
        try{
            Persona pareja=lp.buscarPersona(cert.getRut2());
            CertMatrimonio cn = new CertMatrimonio(p.getNombre(),p.getRut(),p.getApellidoP(),p.getApellidoM(),pareja.getNombre(),pareja.getRut(),pareja.getApellidoP(),pareja.getApellidoM(), p.getEstadocivil());
            s= new StringSubida(cn,p.getComuna());
            String txt = s.getStringSubida();
            System.out.println(txt);
        }catch(excepcionRegistro e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    public void generarCertDef(Cert cert){
        ListaPersonas lp = ListaPersonas.getInstance();
        Fecha f = new Fecha();
        f=f.fechaHoy();
        try{
            Persona difunto=lp.buscarPersona(cert.getRut2());
            CertDefunsion cn = new CertDefunsion(difunto.getNombre(),difunto.getRut(),difunto.getApellidoP(),difunto.getApellidoM(),f);
            s= new StringSubida(cn,p.getComuna());
            String txt = s.getStringSubida();
            System.out.println(txt);
        }catch(excepcionRegistro e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    public Cert seleccionarElemento(){
        String piv = jlista.getSelectedValue();
        Cert c = (Cert)mapa.get(piv);
        return c;
    }
    
    public void Actualizar(){
        ListaCertSolicitados list = ListaCertSolicitados.getInstance();
        ArrayList <Cert> ac = list.agruparCertPersona(p.getRut());
        Map <String,Object> map = new HashMap <>();
        modeloLista.removeAllElements();
        for(int i=0;i<ac.size();i++){
        Cert cert = (Cert)ac.get(i);
            String cod=cert.getCod();
            switch(cod){
                case ("1"):
                    cod="Certificado Nacimiento";
                    break;
                case ("2"):
                    cod="Certificado Matrimonio";
                    break;
                case ("3"):
                    cod="Certificado Defunsion";
                    break;
            }
            if(cert.getAprobado()){
                cod=cod+", APROBADO";
            }else{
                cod=cod+", PENDIENTE";
            }
            map.put(cod, cert);
            modeloLista.addElement(cod);
        }
        mapa=map;
        jlista.setModel(modeloLista);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlista = new javax.swing.JList<>();
        btnver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        eminar = new javax.swing.JButton();

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlista.setToolTipText("");
        jScrollPane1.setViewportView(jlista);

        btnver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnver.setText("Ver");
        btnver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ayrto\\Documents\\NetBeansProjects\\RegistroCivil\\logo-main.png")); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 255), new java.awt.Color(51, 51, 255), new java.awt.Color(102, 102, 255), new java.awt.Color(51, 51, 255)));
        jPanel1.setForeground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        eminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        eminar.setText("Eliminar");
        eminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eminar, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnver, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eminar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverActionPerformed
        Cert cert = seleccionarElemento();
        String nombre="Hijo";
        if(cert.getAprobado()){
            switch (cert.getCod()){
                case "1":   this.generarCertnac(cert,nombre);
                            break;
                case "2":   this.generarCertMat(cert);
                            break;
                case "3":   this.generarCertDef(cert);
                            break;
            }
            main2 m = new main2(s);
            m.setVisible(true);
        }
    }//GEN-LAST:event_btnverActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        InterVisual.MenuInter(p);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void eminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eminarActionPerformed
        Cert cert = seleccionarElemento();
        ListaCertSolicitados list = ListaCertSolicitados.getInstance();
        list.eliminar(cert);
        this.Actualizar();
    }//GEN-LAST:event_eminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnver;
    private javax.swing.JButton eminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jlista;
    // End of variables declaration//GEN-END:variables
}
