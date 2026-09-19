package main;

import koneksi.koneksi;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import tampilan.dashboard;

public class login extends javax.swing.JFrame {

    public login() {
        initComponents();
    }

    void bersih() {
        txt_idadmin.setText("ID");
        txt_username.setText("username");
        txt_password.setText("password");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_password = new javax.swing.JTextField();
        txt_idadmin = new javax.swing.JTextField();
        lbl_daftar = new javax.swing.JLabel();
        btn_login = new custom.JButtonCustom();
        btn_kembali = new custom.JButtonCustom();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 252, 251));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(78, 147, 181));
        jPanel2.setLayout(null);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Password.png"))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(160, 400, 40, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/id.png"))); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(160, 260, 40, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Profile.png"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(160, 330, 40, 30);

        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LOGIN ADMIN");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(100, 100, 440, 57);

        txt_password.setBackground(new java.awt.Color(255, 252, 251));
        txt_password.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txt_password.setForeground(new java.awt.Color(78, 147, 181));
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setText("password");
        txt_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 224, 224)));
        txt_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_passwordFocusLost(evt);
            }
        });
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(txt_password);
        txt_password.setBounds(150, 390, 340, 50);

        txt_idadmin.setBackground(new java.awt.Color(255, 252, 251));
        txt_idadmin.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txt_idadmin.setForeground(new java.awt.Color(78, 147, 181));
        txt_idadmin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_idadmin.setText("ID");
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
        txt_idadmin.setBounds(150, 250, 340, 50);

        lbl_daftar.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbl_daftar.setForeground(new java.awt.Color(255, 255, 255));
        lbl_daftar.setText("DAFTAR");
        lbl_daftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_daftarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_daftarMouseEntered(evt);
            }
        });
        jPanel2.add(lbl_daftar);
        lbl_daftar.setBounds(380, 460, 80, 20);

        btn_login.setText("LOGIN");
        btn_login.setFillClick(new java.awt.Color(70, 127, 156));
        btn_login.setFillOriginal(new java.awt.Color(78, 147, 181));
        btn_login.setFillOver(new java.awt.Color(117, 171, 197));
        btn_login.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_loginMousePressed(evt);
            }
        });
        jPanel2.add(btn_login);
        btn_login.setBounds(370, 510, 120, 50);

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
        btn_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembaliActionPerformed(evt);
            }
        });
        jPanel2.add(btn_kembali);
        btn_kembali.setBounds(150, 510, 120, 50);

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Silahkan login ke akun Anda");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(150, 220, 250, 19);

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Apakah kamu belum memiliki akun?");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(150, 460, 300, 20);

        txt_username.setBackground(new java.awt.Color(255, 252, 251));
        txt_username.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txt_username.setForeground(new java.awt.Color(78, 147, 181));
        txt_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_username.setText("username");
        txt_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 224, 224)));
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username);
        txt_username.setBounds(150, 320, 340, 50);

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
        jPanel1.setBounds(0, 0, 1000, 720);

        setSize(new java.awt.Dimension(1022, 755));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idadminFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idadminFocusGained
        String id = txt_idadmin.getText();
        if (id.equals("ID")) {
            txt_idadmin.setText("");
        }
    }//GEN-LAST:event_txt_idadminFocusGained

    private void txt_idadminFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idadminFocusLost
        String id = txt_idadmin.getText();
        if (id.equals("") || id.equals("ID")) {
            txt_idadmin.setText("ID");
        }
    }//GEN-LAST:event_txt_idadminFocusLost

    private void txt_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passwordFocusGained
        String pass = txt_password.getText();
        if (pass.equals("password")) {
            txt_password.setText("");
        }
    }//GEN-LAST:event_txt_passwordFocusGained

    private void txt_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passwordFocusLost
        String pass = txt_password.getText();
        if (pass.equals("") || pass.equals("password")) {
            txt_password.setText("password");
        }
    }//GEN-LAST:event_txt_passwordFocusLost

    private void btn_loginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMousePressed
        try {
            Connection conn = koneksi.koneksiDB();
            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Koneksi database gagal!");
                return;
            }

            String idAdmin  = txt_idadmin.getText().trim();
            String username = txt_username.getText().trim();
            String password = txt_password.getText().trim();

            // FIX: validasi field kosong sebelum query
            if (idAdmin.equals("ID") || idAdmin.isEmpty() ||
                username.equals("username") || username.isEmpty() ||
                password.equals("password") || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
                return;
            }

            String sql = "SELECT * FROM regisadmin WHERE id_admin=? AND username=? AND password=?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, idAdmin);
            pst.setString(2, username);
            pst.setString(3, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String namaAdmin = rs.getString("username"); // ambil nama dari hasil query
                JOptionPane.showMessageDialog(this, "Login Berhasil");
                rs.close();
                pst.close();
                conn.close();
                this.dispose();
                    menuUtama mn = new menuUtama(namaAdmin); // kirim nama ke sini
                    mn.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "ID Admin, Username atau Password Salah!");
                rs.close();
                pst.close();
                conn.close();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_loginMousePressed

    private void btn_kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kembaliMouseClicked
        new dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_kembaliMouseClicked

    private void lbl_daftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_daftarMouseClicked
        lbl_daftar.setFont(new java.awt.Font(
            lbl_daftar.getFont().getName(), java.awt.Font.BOLD, lbl_daftar.getFont().getSize()));
        RegisAdmin regis = new RegisAdmin();
        regis.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_daftarMouseClicked

    private void lbl_daftarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_daftarMouseEntered
        lbl_daftar.setFont(new java.awt.Font(
            lbl_daftar.getFont().getName(), java.awt.Font.BOLD, lbl_daftar.getFont().getSize()));
    }//GEN-LAST:event_lbl_daftarMouseEntered

    private void txt_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusGained
        String user = txt_username.getText();
        if (user.equals("username")) {
            txt_username.setText("");
        }
    }//GEN-LAST:event_txt_usernameFocusGained

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
        String user = txt_username.getText();
        if (user.equals("") || user.equals("username")) {
            txt_username.setText("username");
        }
    }//GEN-LAST:event_txt_usernameFocusLost

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void btn_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_kembaliActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom.JButtonCustom btn_kembali;
    private custom.JButtonCustom btn_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_daftar;
    private javax.swing.JTextField txt_idadmin;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
