package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import koneksi.koneksi;

public class RegisAdmin extends javax.swing.JFrame {
    public RegisAdmin() {
        initComponents();
        int xx, xy;
    }
    
    void bersih(){
        txt_idadmin.setText("ID ADMIN");
        txt_username1.setText("username");
        txt_password1.setText("password");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_password1 = new javax.swing.JTextField();
        txt_idadmin = new javax.swing.JTextField();
        btn_daftar = new custom.JButtonCustom();
        btn_kembali = new custom.JButtonCustom();
        jLabel7 = new javax.swing.JLabel();
        txt_username1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 252, 251));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(78, 147, 181));
        jPanel2.setPreferredSize(new java.awt.Dimension(620, 700));
        jPanel2.setLayout(null);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ID.png"))); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(150, 250, 40, 50);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Password.png"))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(150, 400, 40, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Profile.png"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(150, 330, 80, 30);

        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REGISTER ADMIN");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(60, 100, 480, 43);

        txt_password1.setBackground(new java.awt.Color(255, 252, 251));
        txt_password1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txt_password1.setForeground(new java.awt.Color(78, 147, 181));
        txt_password1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password1.setText("password");
        txt_password1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 224, 224)));
        txt_password1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_password1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_password1FocusLost(evt);
            }
        });
        jPanel2.add(txt_password1);
        txt_password1.setBounds(140, 390, 340, 50);

        txt_idadmin.setBackground(new java.awt.Color(255, 252, 251));
        txt_idadmin.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txt_idadmin.setForeground(new java.awt.Color(78, 147, 181));
        txt_idadmin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_idadmin.setText("ID Admin");
        txt_idadmin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 224, 224)));
        txt_idadmin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_idadminFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_idadminFocusLost(evt);
            }
        });
        jPanel2.add(txt_idadmin);
        txt_idadmin.setBounds(140, 250, 340, 50);

        btn_daftar.setText("DAFTAR");
        btn_daftar.setFillClick(new java.awt.Color(70, 127, 156));
        btn_daftar.setFillOriginal(new java.awt.Color(78, 147, 181));
        btn_daftar.setFillOver(new java.awt.Color(117, 171, 197));
        btn_daftar.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        btn_daftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_daftarMousePressed(evt);
            }
        });
        jPanel2.add(btn_daftar);
        btn_daftar.setBounds(360, 490, 120, 50);

        btn_kembali.setText("KEMBALI");
        btn_kembali.setFillClick(new java.awt.Color(70, 127, 156));
        btn_kembali.setFillOriginal(new java.awt.Color(78, 147, 181));
        btn_kembali.setFillOver(new java.awt.Color(117, 171, 197));
        btn_kembali.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        btn_kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_kembaliMouseClicked(evt);
            }
        });
        jPanel2.add(btn_kembali);
        btn_kembali.setBounds(140, 490, 120, 50);

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Silahkan isi data terlebih dahulu");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(140, 220, 280, 19);

        txt_username1.setBackground(new java.awt.Color(255, 252, 251));
        txt_username1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txt_username1.setForeground(new java.awt.Color(78, 147, 181));
        txt_username1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_username1.setText("username");
        txt_username1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 224, 224)));
        txt_username1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_username1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_username1FocusLost(evt);
            }
        });
        jPanel2.add(txt_username1);
        txt_username1.setBounds(140, 320, 340, 50);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(380, 0, 620, 700);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kko-removebg-preview.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(80, 150, 220, 280);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(78, 147, 181));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("KenaliDirimu!");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 460, 280, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1000, 700);

        setSize(new java.awt.Dimension(1022, 756));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_username1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_username1FocusLost
        if(txt_username1.getText().equals("")){
            txt_username1.setText("username");
        }
    }//GEN-LAST:event_txt_username1FocusLost

    private void txt_username1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_username1FocusGained
        if(txt_username1.getText().equals("username")){
            txt_username1.setText("");
        }
    }//GEN-LAST:event_txt_username1FocusGained

    private void btn_kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kembaliMouseClicked
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_kembaliMouseClicked

    private void btn_daftarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_daftarMousePressed
        try {

            // Validasi data
            if (txt_idadmin.getText().trim().isEmpty()
                || txt_username1.getText().trim().isEmpty()
                || txt_password1.getText().trim().isEmpty()
                || txt_idadmin.getText().equals("ID ADMIN")
                || txt_username1.getText().equals("username")
                || txt_password1.getText().equals("password")) {

                JOptionPane.showMessageDialog(
                    this,
                    "Data belum lengkap!");

                return;
            }

            // Koneksi database
            Connection conn = koneksi.koneksiDB();

            // Cek apakah ID atau username sudah ada
            String cek = "SELECT * FROM regisadmin WHERE id_admin=? OR username=?";

            PreparedStatement pstCek = conn.prepareStatement(cek);
            pstCek.setString(1, txt_idadmin.getText().trim());
            pstCek.setString(2, txt_username1.getText().trim());

            ResultSet rs = pstCek.executeQuery();

            if (rs.next()) {

                JOptionPane.showMessageDialog(
                    this,
                    "ID Admin atau Username sudah digunakan!");

                return;
            }

            // Simpan data ke tabel regisadmin
            String sql = "INSERT INTO regisadmin(id_admin, username, password) VALUES (?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, txt_idadmin.getText().trim());
            pst.setString(2, txt_username1.getText().trim());
            pst.setString(3, txt_password1.getText().trim());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(
                this,
                "Registrasi Admin Berhasil!\nSilakan Login.");

            // Buka form login
            new login().setVisible(true);

            // Tutup form registrasi
            this.dispose();

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                this,
                "Terjadi kesalahan : " + e.getMessage());

        }
    }//GEN-LAST:event_btn_daftarMousePressed

    private void txt_idadminFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idadminFocusLost
        String id = txt_idadmin.getText();
        if(id.equals("")){
            txt_idadmin.setText("ID Admin");
        }
    }//GEN-LAST:event_txt_idadminFocusLost

    private void txt_idadminFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idadminFocusGained
        String id = txt_idadmin.getText();
        if(id.equals("ID Admin")){
            txt_idadmin.setText("");
        }
    }//GEN-LAST:event_txt_idadminFocusGained

    private void txt_password1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_password1FocusLost
        String pass=txt_password1.getText();
        if(pass.equals("")||pass.equals("password")){
            txt_password1.setText("password");
        }
    }//GEN-LAST:event_txt_password1FocusLost

    private void txt_password1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_password1FocusGained
        String pass=txt_password1.getText();
        if(pass.equals("password")){
            txt_password1.setText("");
        }
    }//GEN-LAST:event_txt_password1FocusGained

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisAdmin().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom.JButtonCustom btn_daftar;
    private custom.JButtonCustom btn_kembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_idadmin;
    private javax.swing.JTextField txt_password1;
    private javax.swing.JTextField txt_username1;
    // End of variables declaration//GEN-END:variables
}
