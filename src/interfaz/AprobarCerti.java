package interfaz;

import intervisual.InterVisual;
import registrocivil.ListaCertSolicitados;
import registrocivil.Cert;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import registrocivil.Persona;

public class AprobarCerti extends javax.swing.JFrame {
    DefaultListModel modeloLista;
    Persona p;
    Map mapa;
    
    public AprobarCerti(Persona p) {
        ListaCertSolicitados list = ListaCertSolicitados.getInstance();
        ArrayList <Cert> al= list.getListaCertSolicitados();
        Map <String,Object> map = new HashMap <>();
        initComponents();
        this.p=p;
        modeloLista=new DefaultListModel();
        String cod;
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
            cod=cod+" , "+cert.getRut()+" , "+cert.getSede();
            if(!cert.getAprobado()){
                map.put(cod, cert);
                modeloLista.addElement(cod);
            }
        }
        mapa=map;
        jlista.setModel(modeloLista);
    }
    
    public void Actualizar(){
        String subida;
        ListaCertSolicitados list = ListaCertSolicitados.getInstance();
        ArrayList <Cert> ac = list.getListaCertSolicitados();
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
    
    public Cert seleccionarElemento(){
        String piv = jlista.getSelectedValue();
        Cert c = (Cert)mapa.get(piv);
        return c;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlista = new javax.swing.JList<>();
        btnver = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        elimina = new javax.swing.JButton();

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ayrto\\Documents\\NetBeansProjects\\RegistroCivil\\logo-main.png")); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), null, new java.awt.Color(51, 51, 255), new java.awt.Color(0, 0, 255)));

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

        jlista.setToolTipText("");
        jScrollPane1.setViewportView(jlista);

        btnver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnver.setText("Aprobar");
        btnver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        elimina.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        elimina.setText("Eliminar");
        elimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(elimina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnver, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(elimina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverActionPerformed
      Cert c = seleccionarElemento();
      c.setAprobado(true);
      ListaCertSolicitados lc = ListaCertSolicitados.getInstance();
      lc.modiLista(c);
    }//GEN-LAST:event_btnverActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        InterVisual.MenuInter(p);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void eliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminaActionPerformed
        Cert cert = seleccionarElemento();
        ListaCertSolicitados list = ListaCertSolicitados.getInstance();
        list.eliminar(cert);
        this.Actualizar();
    }//GEN-LAST:event_eliminaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnver;
    private javax.swing.JButton elimina;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jlista;
    // End of variables declaration//GEN-END:variables
}
