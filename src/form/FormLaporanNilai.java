package form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class FormLaporanNilai extends javax.swing.JDialog {

    private final Connection conDB;
    private PreparedStatement ps;
    private ResultSet rs;
    public DefaultTableModel tabelModel;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public FormLaporanNilai() {
        initComponents();
        conDB = KelasKoneksi.koneksiDB();
    }

    public DefaultTableModel getModelNilai() {
        Object[][] data = null;
        try {
            String query = "SELECT * FROM nilai ORDER BY idNilai";
            ps = conDB.prepareStatement(
            query,
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY
            );
            rs = ps.executeQuery();
            rs.last();
            int i = rs.getRow();
            rs.beforeFirst();

            data = new Object[i][7];
            i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString("idNilai");
                data[i][1] = rs.getString("nim");
                data[i][2] = rs.getString("id_mengajar");
                data[i][3] = rs.getString("tgs");
                data[i][4] = rs.getString("uts");
                data[i][5] = rs.getString("uas");
                data[i][6] = rs.getString("nilaiMutu");
                i++;
            }
        } catch (SQLException e) {
            System.out.println("model mahasiswa" + e.getMessage());
        }

        String[] judulTabel = {"ID", "NIM", "ID Mengajar", "TGS", "UTS", "UAS", "N.Mutu"};
        tabelModel = new DefaultTableModel(data, judulTabel);
        return tabelModel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idN = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmhs = new javax.swing.JTable();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        CBIdM = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        CBNim = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtT = new javax.swing.JTextField();
        txtU = new javax.swing.JTextField();
        txtUas = new javax.swing.JTextField();
        txtMt = new javax.swing.JTextField();

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
        jLabel1.setText("FORM NILAI");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("N. UTS");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NIM");

        idN.setEditable(false);
        idN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idNActionPerformed(evt);
            }
        });

        tblmhs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Nilai", "NIM", "ID Mengajar", "TGS", "UTS", "UAS", "N.Mutu"
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

        CBIdM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Laki-Laki", "Perempuan", " " }));
        CBIdM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBIdMActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID MENGAJAR");

        CBNim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Laki-Laki", "Perempuan", " " }));
        CBNim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBNimActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID NILAI");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("N. Tugas");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("N. UAS");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nilai Mutu");

        txtMt.setEditable(false);

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
                            .addComponent(idN, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBNim, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(CBIdM, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(157, 157, 157)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtUas, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtMt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(2, 2, 2)
                                                    .addComponent(jLabel6))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel7)))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtU, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                                .addComponent(txtT))))
                                    .addGap(0, 83, Short.MAX_VALUE))
                                .addComponent(btnupdate)
                                .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(335, 335, 335)
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
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtT, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(CBNim, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtU, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(CBIdM, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtUas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
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
        tblmhs.setModel(getModelNilai());
        comboNIM();
        comboIDMengajar();

    }//GEN-LAST:event_formWindowOpened

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnexitActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        int jawab = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data??");
        if (jawab == JOptionPane.YES_OPTION) {
            deleteData();
        }

        tblmhs.setModel(getModelNilai());
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        clearData();
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        updateData();
        clearData();
        tblmhs.setModel(getModelNilai());
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        addData();
        //        tblmhs.setModel(getModelMahasiswa());
    }//GEN-LAST:event_btnaddActionPerformed

    private void tblmhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmhsMouseClicked
        idN.setText(tabelModel.getValueAt(tblmhs.getSelectedRow(), 0).toString());
        tampilData();
    }//GEN-LAST:event_tblmhsMouseClicked

    private void idNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idNActionPerformed

    private void CBNimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBNimActionPerformed
        
    }//GEN-LAST:event_CBNimActionPerformed

    private void CBIdMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBIdMActionPerformed
        
    }//GEN-LAST:event_CBIdMActionPerformed
    
    public void comboNIM(){
        try{
            String query  =  "SELECT * FROM mahasiswa ORDER BY nim";
            ps = conDB.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();
            
            CBNim.removeAllItems();
            CBNim.addItem("pilih");
            
            while(rs.next()){
                CBNim.addItem(rs.getString("nim") + " - " + rs.getString("nama_mhs"));   
            }       
        }catch(SQLException e){
            System.out.println("combo nim error" + e.getMessage());
        }
    }
    
    public void comboIDMengajar() {
        try{
            String query = "SELECT * FROM dosen_mengajar ORDER BY id_mengajar";
            ps =conDB.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();
            
            CBIdM.removeAllItems();
            CBIdM.addItem("pilih");
            
            while(rs.next()){
                CBIdM.addItem(rs.getString("id_mengajar"));
            }
        }catch(SQLException e){
            System.out.println("combo id error" + e.getMessage());
        }
    }
    public void clearData() {
        idN.setText("");
        CBNim.setSelectedIndex(0);
        CBIdM.setSelectedIndex(0);
        txtT.setText("");
        txtU.setText("");
        txtUas.setText("");
        txtMt.setText("");
    }

//    public void getCode() {
//        try {
//            String query = "SELECT MAX(nim) FROM mahasiswa";
//            ps = conDB.prepareStatement(query);
//            rs = ps.executeQuery();
//
//            int kode = 1;
//            if (rs.next() && rs.getString(1) != null) {
//                String lastNim = rs.getString(1);
//                kode = Integer.parseInt(lastNim.substring(1)) + 1;
//            }
//
//            String newKode = String.format("M%02d", kode);
//            idN.setText(newKode);
//
//        } catch (SQLException e) {
//            System.out.println("getCode error: " + e.getMessage());
//        }
//    }

    public void tampilData() {
        try {
            String query = 
                    "SELECT *, m.nama_mhs AS namaMHS " +
                    "FROM nilai n " +
                    "INNER JOIN mahasiswa m ON n.nim = m.nim " +
                    "WHERE idNilai = ?";
            ps = conDB.prepareStatement(query);
            ps.setString(1, idN.getText());
            rs = ps.executeQuery();

            while (rs.next()) {
                CBNim.setSelectedItem(rs.getString("nim") + " - " + rs.getString("namaMHS"));
                CBIdM.addItem(String.valueOf(rs.getInt("id_mengajar")));
                txtT.setText(rs.getString("tgs"));
                txtU.setText(rs.getString("uts"));
                txtUas.setText(rs.getString("uas"));
                txtMt.setText(rs.getString("nilaiMutu"));
                        
            }
        } catch (SQLException e) {
            System.out.println("tampil Data Error!" + e.getMessage());
        }
    }

    public void addData() {
        try {
            String selectedIdM = CBIdM.getSelectedItem().toString().trim();
            if (selectedIdM.equals("pilih")) {
                JOptionPane.showMessageDialog(null, "Pilih ID Mengajar terlebih dahulu!");
                return;
            }
            int idMengajar = Integer.parseInt(selectedIdM);
            int tgs = Integer.parseInt(txtT.getText());
            int uts = Integer.parseInt(txtU.getText());
            int uas = Integer.parseInt(txtUas.getText());
            
            
            String query = "INSERT INTO nilai VALUES(?,?,?,?,?,?,?)";
            
            ps = conDB.prepareStatement(query);
            ps.setString(1, null);
            ps.setString(2, CBNim.getSelectedItem().toString().substring(0,3));
            ps.setInt(3, idMengajar);
            ps.setDouble (4, tgs);
            ps.setDouble (5, uts);
            ps.setDouble (6, uas);
            ps.setString (7, null);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Add data sukses!");
            tblmhs.setModel(getModelNilai());
            clearData();

        } catch (SQLException e) {
            System.out.println("Add data error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Add data gagal!");
        }
    }

    public void updateData() {
        try {
            String query = "update nilai set nim=?, id_mengajar=?, tgs=?, uts=?, uas=? where idNilai=?";
            ps = conDB.prepareStatement(query);
            ps.setString(1, CBNim.getSelectedItem().toString().substring(0,3));
            ps.setInt(2, Integer.parseInt(CBIdM.getSelectedItem().toString().trim()));
            ps.setString(3, txtT.getText());
            ps.setString(4, txtU.getText());
            ps.setString(5, txtUas.getText());
            ps.setString(6, idN.getText());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "update data suskes");
        } catch (SQLException e) {
            System.out.println("add data eror" + e.getMessage());
            JOptionPane.showMessageDialog(null, "update data gagsl");
        }
    }

    public void deleteData() {
        try {
            String query = "delete from nilai where idNilai=?";
            ps = conDB.prepareStatement(query);
            ps.setString(1, idN.getText());
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
            java.util.logging.Logger.getLogger(FormLaporanNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLaporanNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLaporanNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLaporanNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormLaporanNilai dialog = new FormLaporanNilai();
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
    private javax.swing.JComboBox CBIdM;
    private javax.swing.JComboBox CBNim;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnupdate;
    private javax.swing.JTextField idN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblmhs;
    private javax.swing.JTextField txtMt;
    private javax.swing.JTextField txtT;
    private javax.swing.JTextField txtU;
    private javax.swing.JTextField txtUas;
    // End of variables declaration//GEN-END:variables

}
