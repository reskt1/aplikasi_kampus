package form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class FormDosenMengajar extends javax.swing.JDialog {

    private final Connection conDB;
    private PreparedStatement ps;
    private ResultSet rs;
    public DefaultTableModel tabelModel;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public FormDosenMengajar() {
        initComponents();
        conDB = KelasKoneksi.koneksiDB();
    }

    public DefaultTableModel getModelMahasiswa() {
        Object[][] data = null;
        try {
            String query = "SELECT * FROM dosen_mengajar ORDER BY id_mengajar";
            ps = conDB.prepareStatement(
            query,
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY
            );
            rs = ps.executeQuery();
            rs.last();
            int i = rs.getRow();
            rs.beforeFirst();

            data = new Object[i][3];
            i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString("id_mengajar");
                data[i][1] = rs.getString("nid");
                data[i][2] = rs.getString("kdMatkul");
                i++;
            }
        } catch (SQLException e) {
            System.out.println("model mahasiswa" + e.getMessage());
        }

        String[] judulTabel = {"ID Mengajar", "NID", "KD Matkul"};
        tabelModel = new DefaultTableModel(data, judulTabel);
        return tabelModel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        id_mengajar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmhs = new javax.swing.JTable();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        cbxkd_matkul = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cbxnid = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Cascadia Code", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("FORM DOSEN MENGAJAR");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NID");

        tblmhs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Mengajar", "NID", "KD Matkul"
            }
        ));
        tblmhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblmhsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblmhs);

        btnadd.setBackground(new java.awt.Color(102, 255, 0));
        btnadd.setText("ADD");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btnclear.setText("CLEAR");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(255, 51, 51));
        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnexit.setBackground(new java.awt.Color(255, 255, 0));
        btnexit.setText("EXIT");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        cbxkd_matkul.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Laki-Laki", "Perempuan", " " }));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("KD MATKUL");

        cbxnid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Laki-Laki", "Perempuan", " " }));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID MENGAJAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_mengajar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxnid, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cbxkd_matkul, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 466, Short.MAX_VALUE))
                                .addComponent(btnupdate)
                                .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id_mengajar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxnid, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxkd_matkul, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnadd)
                        .addGap(18, 18, 18)
                        .addComponent(btnupdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnclear)
                        .addGap(18, 18, 18)
                        .addComponent(btndelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnexit))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tblmhs.setModel(getModelMahasiswa());
        id_mengajar.setEditable(false);
        comboMatkul();
        comboNid();
    }//GEN-LAST:event_formWindowOpened

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnexitActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        int jawab = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data??");
        if (jawab == JOptionPane.YES_OPTION) {
            deleteData();
        }

        tblmhs.setModel(getModelMahasiswa());
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        clearData();
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        updateData();
        tblmhs.setModel(getModelMahasiswa());
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        addData();
        //        tblmhs.setModel(getModelMahasiswa());
    }//GEN-LAST:event_btnaddActionPerformed

    private void tblmhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmhsMouseClicked
        id_mengajar.setText(tabelModel.getValueAt(tblmhs.getSelectedRow(), 0).toString());
        tampilData();
         
    }//GEN-LAST:event_tblmhsMouseClicked

    public void clearData() {
        id_mengajar.setText("");
        cbxnid.setSelectedIndex(0);
        cbxkd_matkul.setSelectedIndex(0);
  

    }
    
    public void comboNid(){
        try{
            String query  =  "SELECT * FROM dosen ORDER BY nid";
            ps = conDB.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();
            
            cbxnid.removeAllItems();
            cbxnid.addItem("pilih");
            
            while(rs.next()){
                cbxnid.addItem(rs.getString("nid") + " - " + rs.getString("nama_dosen"));   
            }       
        }catch(SQLException e){
            System.out.println("combo nid error" + e.getMessage());
        }
    }
    
    public void comboMatkul() {
        try{
            String query = "SELECT * FROM matakuliah ORDER BY kdMatkul";
            ps =conDB.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();
            
            cbxkd_matkul.removeAllItems();
            cbxkd_matkul.addItem("pilih");
            
            while(rs.next()){
                cbxkd_matkul.addItem(rs.getString("kdMatkul") +" - " +rs.getString("namaMatkul"));
            }
        }catch(SQLException e){
            System.out.println("combo id error" + e.getMessage());
        }
    }
    
    public void tampilData() {
        try {
            String query = 
                    "SELECT *, d.nama_dosen AS namaDOSEN, mk.kdMatkul, mk.namaMatkul AS namaMATKUL  " +
                    "FROM dosen_mengajar dm INNER JOIN matakuliah mk " +
                    "INNER JOIN dosen d ON dm.nid = d.nid AND dm.kdMatkul=mk.kdMatkul " +
                    "WHERE dm.id_mengajar = ?";
            ps = conDB.prepareStatement(query);
            ps.setString(1, id_mengajar.getText());
            rs = ps.executeQuery();

            while (rs.next()) {
                cbxnid.setSelectedItem(rs.getString("nid") + " - " + rs.getString("namaDOSEN"));
                cbxkd_matkul.setSelectedItem(rs.getString("kdMatkul") + " - " + rs.getString("namaMATKUL"));
            }
        } catch (SQLException e) {
            System.out.println("tampil Data Error!" + e.getMessage());
        }
    }

    public void addData() {
        try {
            String query = "INSERT INTO dosen_mengajar (nid, kdMatkul) VALUES(?,?)";
            ps = conDB.prepareStatement(query);
            
            String nid = cbxnid.getSelectedItem().toString().split(" - ")[0];
            String kdMatkul = cbxkd_matkul.getSelectedItem().toString().split(" - ")[0];
            
            ps.setString(1, nid);
            ps.setString(2, kdMatkul);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Add data sukses!");
            tblmhs.setModel(getModelMahasiswa());
            clearData();

        } catch (Exception e) {
            System.out.println("Add data error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Add data gagal!");
        }
    }

    public void updateData() {
        try {
            String query = "update dosen_mengajar set nid=?, kdMatkul=? where id_mengajar=?";
            ps = conDB.prepareStatement(query);
            ps.setString(1, cbxnid.getSelectedItem().toString());
            ps.setString(2, cbxkd_matkul.getSelectedItem().toString());
            ps.setString(3, id_mengajar.getText());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "update data suskes");
        } catch (SQLException e) {
            System.out.println("add data eror" + e.getMessage());
            JOptionPane.showMessageDialog(null, "update data gagsl");
        }
    }

    public void deleteData() {
        try {
            String query = "delete from dosen_mengajar where id_mengajar=?";
            ps = conDB.prepareStatement(query);
            ps.setString(1, id_mengajar.getText());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "delete data suskes");
        } catch (SQLException e) {
            System.out.println("add data eror" + e.getMessage());
            JOptionPane.showMessageDialog(null, "delete data gagsl");
        }
    }

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
            java.util.logging.Logger.getLogger(FormDosenMengajar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDosenMengajar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDosenMengajar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDosenMengajar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormDosenMengajar dialog = new FormDosenMengajar();
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
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox cbxkd_matkul;
    private javax.swing.JComboBox cbxnid;
    private javax.swing.JTextField id_mengajar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblmhs;
    // End of variables declaration//GEN-END:variables

}
