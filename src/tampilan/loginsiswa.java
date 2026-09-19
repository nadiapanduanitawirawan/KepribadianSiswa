package tampilan;
 
import main.*;
import koneksi.koneksi;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import tampilan.dashboard;
 
public class loginsiswa extends javax.swing.JFrame {
    public loginsiswa() {
        initComponents();
        int xx, xy;
    }
    
    void bersih(){
        txt_usersiswa.setText("username");
        txt_passsiswa.setText("password");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_passsiswa = new javax.swing.JTextField();
        lbl_daftar1 = new javax.swing.JLabel();
        btn_loginsiswa = new custom.JButtonCustom();
        btn_kembali1 = new custom.JButtonCustom();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_usersiswa = new javax.swing.JTextField();
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
        jLabel4.setBounds(160, 340, 40, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Profile.png"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(160, 260, 40, 30);

        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LOGIN SISWA");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(100, 100, 440, 57);

        txt_passsiswa.setBackground(new java.awt.Color(255, 252, 251));
        txt_passsiswa.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txt_passsiswa.setForeground(new java.awt.Color(78, 147, 181));
        txt_passsiswa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_passsiswa.setText("password");
        txt_passsiswa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 224, 224)));
        txt_passsiswa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_passsiswaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_passsiswaFocusLost(evt);
            }
        });
        jPanel2.add(txt_passsiswa);
        txt_passsiswa.setBounds(150, 330, 340, 50);

        lbl_daftar1.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbl_daftar1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_daftar1.setText("DAFTAR");
        lbl_daftar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_daftar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_daftar1MouseEntered(evt);
            }
        });
        jPanel2.add(lbl_daftar1);
        lbl_daftar1.setBounds(380, 400, 80, 20);

        btn_loginsiswa.setText("LOGIN");
        btn_loginsiswa.setFillClick(new java.awt.Color(70, 127, 156));
        btn_loginsiswa.setFillOriginal(new java.awt.Color(78, 147, 181));
        btn_loginsiswa.setFillOver(new java.awt.Color(117, 171, 197));
        btn_loginsiswa.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        btn_loginsiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_loginsiswaMousePressed(evt);
            }
        });
        jPanel2.add(btn_loginsiswa);
        btn_loginsiswa.setBounds(360, 470, 120, 50);

        btn_kembali1.setText("KEMBALI");
        btn_kembali1.setFillClick(new java.awt.Color(70, 127, 156));
        btn_kembali1.setFillOriginal(new java.awt.Color(78, 147, 181));
        btn_kembali1.setFillOver(new java.awt.Color(117, 171, 197));
        btn_kembali1.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        btn_kembali1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_kembali1MouseClicked(evt);
            }
        });
        btn_kembali1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembali1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_kembali1);
        btn_kembali1.setBounds(150, 470, 120, 50);

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Silahkan login ke akun Anda");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(150, 220, 250, 19);

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Apakah kamu belum memiliki akun?");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(150, 400, 300, 20);

        txt_usersiswa.setBackground(new java.awt.Color(255, 252, 251));
        txt_usersiswa.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txt_usersiswa.setForeground(new java.awt.Color(78, 147, 181));
        txt_usersiswa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_usersiswa.setText("username");
        txt_usersiswa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 224, 224)));
        txt_usersiswa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_usersiswaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usersiswaFocusLost(evt);
            }
        });
        txt_usersiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usersiswaActionPerformed(evt);
            }
        });
        jPanel2.add(txt_usersiswa);
        txt_usersiswa.setBounds(150, 250, 340, 50);

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

        setSize(new java.awt.Dimension(1022, 754));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_passsiswaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passsiswaFocusGained
        String pass = txt_passsiswa.getText();
        if (pass.equals("password")) {
            txt_passsiswa.setText("");
        }
    }//GEN-LAST:event_txt_passsiswaFocusGained

    private void txt_passsiswaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passsiswaFocusLost
        String pass = txt_passsiswa.getText();
        if (pass.equals("") || pass.equals("password")) {
            txt_passsiswa.setText("password");
        }
    }//GEN-LAST:event_txt_passsiswaFocusLost

    private void btn_loginsiswaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginsiswaMousePressed
        try {
 
        String username = txt_usersiswa.getText().trim();
        String password = txt_passsiswa.getText().trim();
 
        if (username.isEmpty()
                || username.equals("username")
                || password.isEmpty()
                || password.equals("password")) {
 
            JOptionPane.showMessageDialog(
                    this,
                    "Username dan Password harus diisi!"
            );
            return;
        }
 
        Connection conn = koneksi.koneksiDB();
 
        if (conn == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Koneksi database gagal!"
            );
            return;
        }
 
        String sql =
                "SELECT * FROM regissiswa "
                + "WHERE username=? AND password=?";
 
        java.sql.PreparedStatement pst =
                conn.prepareStatement(sql);
 
        pst.setString(1, username);
        pst.setString(2, password);
 
        ResultSet rs = pst.executeQuery();
 
        if (rs.next()) {
 
            String namaSiswa =
                    rs.getString("nama_siswa");
            String nisnSiswa =
                    rs.getString("nisn");
 
            JOptionPane.showMessageDialog(
                    this,
                    "Selamat datang, " + namaSiswa
            );
 
            this.dispose();
 
            new menu.kuesioner(nisnSiswa, namaSiswa)
                    .setVisible(true);
 
        } else {
 
            JOptionPane.showMessageDialog(
                    this,
                    "Username atau Password salah!"
            );
        }
 
        rs.close();
        pst.close();
 
    } catch (Exception e) {
 
        JOptionPane.showMessageDialog(
                this,
                "Error : " + e.getMessage()
        );
 
        e.printStackTrace();
    }
    }//GEN-LAST:event_btn_loginsiswaMousePressed

    private void btn_kembali1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kembali1MouseClicked
        new dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_kembali1MouseClicked

    private void lbl_daftar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_daftar1MouseClicked
        lbl_daftar1.setFont(new java.awt.Font(
            lbl_daftar1.getFont().getName(),
            java.awt.Font.BOLD,
            lbl_daftar1.getFont().getSize()
        ));
        register regis = new register();
        regis.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_daftar1MouseClicked

    private void lbl_daftar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_daftar1MouseEntered
        lbl_daftar1.setFont(new java.awt.Font(
            lbl_daftar1.getFont().getName(),
            java.awt.Font.BOLD,
            lbl_daftar1.getFont().getSize()
        ));
    }//GEN-LAST:event_lbl_daftar1MouseEntered

    private void txt_usersiswaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usersiswaFocusGained
        String user = txt_usersiswa.getText();
        if (user.equals("username")) {
            txt_usersiswa.setText("");
        }
    }//GEN-LAST:event_txt_usersiswaFocusGained

    private void txt_usersiswaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usersiswaFocusLost
        String user = txt_usersiswa.getText();
        if (user.equals("") || user.equals("username")) {
            txt_usersiswa.setText("username");
        }
    }//GEN-LAST:event_txt_usersiswaFocusLost

    private void txt_usersiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usersiswaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usersiswaActionPerformed

    private void btn_kembali1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembali1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_kembali1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginsiswa().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom.JButtonCustom btn_kembali1;
    private custom.JButtonCustom btn_loginsiswa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_daftar1;
    private javax.swing.JTextField txt_passsiswa;
    private javax.swing.JTextField txt_usersiswa;
    // End of variables declaration//GEN-END:variables
}
