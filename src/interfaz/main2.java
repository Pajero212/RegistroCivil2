package interfaz;

import intervisual.StringSubida;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import intervisual.excepcionInterfaz;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class main2 extends javax.swing.JFrame {
    
    private StringSubida s;
    
    public main2(StringSubida s) {
        initComponents();
        this.s=s;
    }
    
    public void setString(StringSubida s){
        this.s=s;
    }
    
    public StringSubida getString(){
        return s;
    }
    
    public void validarTexto() throws excepcionInterfaz{
        if(txtruta==null){
            throw new excepcionInterfaz("Campo de Texto Vacio");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtruta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Generar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtruta, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser dlg = new JFileChooser();
        int option=dlg.showSaveDialog(this);
        if(option==JFileChooser.APPROVE_OPTION){
            File f=dlg.getSelectedFile();
            txtruta.setText(f.toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            validarTexto();
            String ruta=txtruta.getText();
            String contenido=s.getStringSubida();
            try{
                FileOutputStream archivo = new FileOutputStream(ruta+".pdf");
                Document document = new Document ();
                PdfWriter.getInstance(document, archivo);
                document.open();
                Image imagen = Image.getInstance("escudoChile.png");
                imagen.scaleAbsolute(100, 100);
                imagen.setAlignment(Element.ALIGN_CENTER);
                document.add(imagen);
                document.add(new Paragraph(contenido));
                document.close();
                JOptionPane.showMessageDialog(null, "pdf Correctamente creado");
            }catch(FileNotFoundException e){

            }catch (DocumentException | IOException ex) {
                Logger.getLogger(main2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch (excepcionInterfaz ex) {
            System.out.println("Eror: "+ex.getMessage());
        }
        this.setVisible(false);
               
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField txtruta;
    // End of variables declaration//GEN-END:variables
}
