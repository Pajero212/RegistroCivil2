package interfaz;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import intervisual.InterVisual;
import intervisual.StringSubida;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import registrocivil.Persona;

public class definirEstadocivil extends javax.swing.JFrame {
    StringSubida ss;
    Persona pp;
    
    public definirEstadocivil(Persona p) {
        pp=p;
        String x =null;
        ss=new StringSubida(x);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        matrimonio = new javax.swing.JButton();
        divorcio = new javax.swing.JButton();
        actual = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ayrto\\Documents\\NetBeansProjects\\RegistroCivil\\logo-main.png")); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(51, 51, 255), new java.awt.Color(0, 0, 255)));
        jPanel1.setForeground(new java.awt.Color(0, 0, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Ingrese Opción:");

        matrimonio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        matrimonio.setText("Validar Matrimonio");
        matrimonio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matrimonioActionPerformed(evt);
            }
        });

        divorcio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        divorcio.setText("Validar Divorcio");
        divorcio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divorcioActionPerformed(evt);
            }
        });

        actual.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        actual.setText("Acreditar Situación Actual");
        actual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(matrimonio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(divorcio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(actual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(matrimonio)
                .addGap(18, 18, 18)
                .addComponent(divorcio)
                .addGap(18, 18, 18)
                .addComponent(actual)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void divorcioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divorcioActionPerformed
        MenuCertMat m = new MenuCertMat(pp,"Divorciado");
        m.setLocation(250,120);
        m.setVisible(true);
        m.setResizable(false);
        this.setVisible(false);
        InterVisual.MenuInter(pp);
    }//GEN-LAST:event_divorcioActionPerformed
    
    /**
     * Funcion Necesaria para la emision de PDF, solo se usa en el caso de que el Usuario
     * haya escogido la opcion "Acreditar Situacion Actual", en caso contrarios, se hace uso
     * de los otros metodos de la interfaz
     * @param evt 
     */
    private void actualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualActionPerformed
        ss=new StringSubida(pp,pp.getComuna());
        String s = ss.getStringSubida();
        String ruta = System.getProperty("user.home") + "/Desktop/SituacionActual"; 
        try{
            FileOutputStream archivo = new FileOutputStream(ruta+".pdf");
            Document document = new Document ();
            PdfWriter.getInstance(document, archivo);
            document.open();
            Image imagen = Image.getInstance("escudoChile.png");
            imagen.scaleAbsolute(100, 100);
            imagen.setAlignment(Element.ALIGN_CENTER);
            document.add(imagen);
            document.add(new Paragraph(s));
            document.close();
            JOptionPane.showMessageDialog(null, "pdf Correctamente creado");
        }catch(FileNotFoundException e){
            
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(main2.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        InterVisual.MenuInter(pp);
    }//GEN-LAST:event_actualActionPerformed

    private void matrimonioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matrimonioActionPerformed
        MenuCertMat m = new MenuCertMat(pp,"Casado");
        m.setLocation(250,120);
        m.setVisible(true);
        m.setResizable(false);
        this.setVisible(false);
        InterVisual.MenuInter(pp);
    }//GEN-LAST:event_matrimonioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actual;
    private javax.swing.JButton divorcio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton matrimonio;
    // End of variables declaration//GEN-END:variables
}
