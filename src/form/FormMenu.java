package form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormMenu extends javax.swing.JFrame{

    private final Connection conDB;
    public static String role;

    public FormMenu() {
        super();
        initComponents();
        conDB = KelasKoneksi.koneksiDB();
        setMenuEnable(true);
        loginGagal();
    }

    public void setMenuEnable(Boolean status){
        btnMhs.setEnabled(status);
        btnDosen.setEnabled(status);
        btnMatkul.setEnabled(status);
        btnNilai.setEnabled(status);
        btnUser.setEnabled(status);
        btnBobot.setEnabled(status);
        btnDosenM.setEnabled(status);
        btnLaporanNilai.setEnabled(status);
    }
    public static void loginGagal(){
        panelMenu.setVisible(false);
        btnLogin.setText("Login");
    }
    
    public static void loginSukses(){
        panelMenu.setVisible(true);
        btnLogin.setText("Logout");
        
        
        if(role.equals("admin")){
            btnMatkul.setVisible(true);
            btnMhs.setVisible(true);
            btnDosen.setVisible(true);
            btnBobot.setVisible(true);
            btnDosenM.setVisible(true);
            btnUser.setVisible(true);
            btnNilai.setVisible(false);
            btnLaporanNilai.setVisible(false);
            
        }else if(role.equals("dosen")){
            btnMatkul.setVisible(false);
            btnMhs.setVisible(false);
            btnDosen.setVisible(true);
            btnBobot.setVisible(false);
            btnDosenM.setVisible(false);
            btnUser.setVisible(false);
            btnNilai.setVisible(true);
            btnLaporanNilai.setVisible(false);
            
        }else if(role.equals("mahasiswa")){
            btnMatkul.setVisible(false);
            btnMhs.setVisible(false);
            btnDosen.setVisible(false);
            btnBobot.setVisible(false);
            btnDosenM.setVisible(false);
            btnUser.setVisible(false);
            btnNilai.setVisible(false);
            btnLaporanNilai.setVisible(true);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        btnMatkul = new javax.swing.JButton();
        btnDosen = new javax.swing.JButton();
        btnMhs = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnDosenM = new javax.swing.JButton();
        btnBobot = new javax.swing.JButton();
        btnNilai = new javax.swing.JButton();
        btnLaporanNilai = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnMatkul7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panelMenu.setBackground(new java.awt.Color(102, 255, 255));

        btnMatkul.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        btnMatkul.setText("Matkul");
        btnMatkul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatkulActionPerformed(evt);
            }
        });

        btnDosen.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        btnDosen.setText("Dosen");
        btnDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDosenActionPerformed(evt);
            }
        });

        btnMhs.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        btnMhs.setText("Mahasiswa");
        btnMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMhsActionPerformed(evt);
            }
        });

        btnUser.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        btnUser.setText("User");
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });

        btnDosenM.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        btnDosenM.setText("Dosen Mengajar");
        btnDosenM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDosenMActionPerformed(evt);
            }
        });

        btnBobot.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        btnBobot.setText("Bobot");
        btnBobot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBobotActionPerformed(evt);
            }
        });

        btnNilai.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        btnNilai.setText("Nilai");
        btnNilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNilaiActionPerformed(evt);
            }
        });

        btnLaporanNilai.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        btnLaporanNilai.setText("Laporan NIlai");
        btnLaporanNilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaporanNilaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMatkul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDosen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMhs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDosenM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBobot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNilai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLaporanNilai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMatkul, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDosen, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMhs, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDosenM, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBobot, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLaporanNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(614, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("MV Boli", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selamat datang di aplikasi kampus");

        btnLogin.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnMatkul7.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        btnMatkul7.setText("Exit");
        btnMatkul7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatkul7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMatkul7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMatkul7)
                .addGap(20, 20, 20))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 692, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void btnMatkulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatkulActionPerformed
        FormMatkul fm = new FormMatkul();
        fm.setVisible(true);
    }//GEN-LAST:event_btnMatkulActionPerformed

    private void btnDosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDosenActionPerformed
        FormDosen fd = new FormDosen();
        fd.setVisible(true);
    }//GEN-LAST:event_btnDosenActionPerformed

    private void btnMhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMhsActionPerformed
        FormMahasiswa fmhs = new FormMahasiswa();
        fmhs.setVisible(true);
    }//GEN-LAST:event_btnMhsActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        FormUser fu = new FormUser();
        fu.setVisible(true);
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnDosenMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDosenMActionPerformed
        FormDosenMengajar fdm = new FormDosenMengajar();
        fdm.setVisible(true);
    }//GEN-LAST:event_btnDosenMActionPerformed

    private void btnBobotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBobotActionPerformed
        FormBobot fb = new FormBobot();
        fb.setVisible(true);
    }//GEN-LAST:event_btnBobotActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if(btnLogin.getText().equals("Login")){
            FormLogin login = new FormLogin(this);
            login.setVisible(true);
        }else {
            loginGagal();
        }
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnMatkul7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatkul7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMatkul7ActionPerformed

    private void btnNilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNilaiActionPerformed
        FormNilai fn = new FormNilai();
        fn.setVisible(true);
    }//GEN-LAST:event_btnNilaiActionPerformed

    private void btnLaporanNilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaporanNilaiActionPerformed
        FormLaporanNilai fln = new FormLaporanNilai();
        fln.setVisible(true);
    }//GEN-LAST:event_btnLaporanNilaiActionPerformed

   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormMenu dialog = new FormMenu();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton btnBobot;
    private static javax.swing.JButton btnDosen;
    private static javax.swing.JButton btnDosenM;
    private static javax.swing.JButton btnLaporanNilai;
    private static javax.swing.JButton btnLogin;
    private static javax.swing.JButton btnMatkul;
    private static javax.swing.JButton btnMatkul7;
    private static javax.swing.JButton btnMhs;
    private static javax.swing.JButton btnNilai;
    private static javax.swing.JButton btnUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private static javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables

}
