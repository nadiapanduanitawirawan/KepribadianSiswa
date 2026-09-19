package tampilan;

import koneksi.koneksi;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import menu.kuesioner;

public class register extends javax.swing.JFrame {
private javax.swing.JLabel menuAktif = null;
private javax.swing.JTextField jTextField2;
private javax.swing.JTextField jTextField1;
private javax.swing.JTextField txtKelas;

    public register() {
        initComponents();
        int xx, xy;
    }
    void bersih(){
        txt_id.setText("NISN");
        txt_nama.setText("NAMA LENGKAP");
    }
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btn_daftar1 = new custom.JButtonCustom();
        btn_kembali = new custom.JButtonCustom();
        txt_pass = new javax.swing.JTextField();
        perempuan = new javax.swing.JRadioButton();
        laki_laki = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 252, 251));
        jPanel2.setLayout(null);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kko-removebg-preview.png"))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(80, 150, 220, 280);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(78, 147, 181));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("KenaliDirimu!");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(50, 460, 280, 40);

        jPanel1.setBackground(new java.awt.Color(78, 147, 181));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Jenis Kelamin");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(140, 440, 130, 30);

        txt_nama.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txt_nama.setForeground(new java.awt.Color(78, 147, 181));
        txt_nama.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nama.setText("NAMA LENGKAP");
        txt_nama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(78, 147, 181)));
        txt_nama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_namaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_namaFocusLost(evt);
            }
        });
        txt_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_nama);
        txt_nama.setBounds(140, 290, 340, 50);

        txt_id.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txt_id.setForeground(new java.awt.Color(78, 147, 181));
        txt_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id.setText("ID");
        txt_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(78, 147, 181)));
        txt_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_idFocusLost(evt);
            }
        });
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        jPanel1.add(txt_id);
        txt_id.setBounds(140, 220, 340, 50);

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTER SISWA");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 100, 480, 43);

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Silahkan isi data diri terlebih dahulu");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(140, 190, 280, 19);

        jComboBox1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(78, 147, 181));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "X TKJ", "X ANIMASI", "X PSPT", "X PPLG", "X TE" }));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(220, 370, 260, 40);

        btn_daftar1.setText("DAFTAR");
        btn_daftar1.setFillClick(new java.awt.Color(70, 127, 156));
        btn_daftar1.setFillOriginal(new java.awt.Color(78, 147, 181));
        btn_daftar1.setFillOver(new java.awt.Color(117, 171, 197));
        btn_daftar1.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btn_daftar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_daftar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_daftar1);
        btn_daftar1.setBounds(360, 600, 120, 50);

        btn_kembali.setText("KEMBALI");
        btn_kembali.setFillClick(new java.awt.Color(70, 127, 156));
        btn_kembali.setFillOriginal(new java.awt.Color(78, 147, 181));
        btn_kembali.setFillOver(new java.awt.Color(117, 171, 197));
        btn_kembali.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btn_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembaliActionPerformed(evt);
            }
        });
        jPanel1.add(btn_kembali);
        btn_kembali.setBounds(140, 600, 120, 50);

        txt_pass.setBackground(new java.awt.Color(255, 252, 251));
        txt_pass.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txt_pass.setForeground(new java.awt.Color(78, 147, 181));
        txt_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pass.setText("PASSWORD");
        txt_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 224, 224)));
        txt_pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_passFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_passFocusLost(evt);
            }
        });
        jPanel1.add(txt_pass);
        txt_pass.setBounds(140, 500, 340, 50);

        perempuan.setBackground(new java.awt.Color(78, 147, 181));
        perempuan.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        perempuan.setForeground(new java.awt.Color(255, 255, 255));
        perempuan.setText("P");
        perempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perempuanActionPerformed(evt);
            }
        });
        jPanel1.add(perempuan);
        perempuan.setBounds(350, 440, 60, 29);

        laki_laki.setBackground(new java.awt.Color(78, 147, 181));
        laki_laki.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        laki_laki.setForeground(new java.awt.Color(255, 255, 255));
        laki_laki.setText("L");
        laki_laki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laki_lakiActionPerformed(evt);
            }
        });
        jPanel1.add(laki_laki);
        laki_laki.setBounds(280, 440, 60, 29);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kelas");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(140, 380, 60, 20);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(380, 0, 630, 700);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1000, 700);

        setSize(new java.awt.Dimension(1020, 756));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namaActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idFocusGained
        String ID=txt_id.getText();
        if(ID.equals("ID")){
            txt_id.setText("");   
        }       
    }//GEN-LAST:event_txt_idFocusGained

    private void txt_namaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_namaFocusGained
        String nama=txt_nama.getText();
        if(nama.equals("NAMA LENGKAP")){
            txt_nama.setText("");   
        }       
    }//GEN-LAST:event_txt_namaFocusGained

    private void txt_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idFocusLost
        String ID=txt_id.getText();
        if(ID.equals("")||ID.equals("ID")){
            txt_id.setText("ID");
        }
    }//GEN-LAST:event_txt_idFocusLost

    private void txt_namaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_namaFocusLost
        String nama=txt_nama.getText();
        if(nama.equals("")||nama.equals("NAMA LENGKAP")){
            txt_nama.setText("NAMA LENGKAP");
        }
    }//GEN-LAST:event_txt_namaFocusLost

    private void btn_daftar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_daftar1ActionPerformed
try {
    String nisn     = txt_id.getText().trim();
    String nama     = txt_nama.getText().trim();
    String password = txt_pass.getText().trim();
    String kelas    = jComboBox1.getSelectedItem().toString().trim(); // contoh: "X ANIMASI"

    String jenisKelamin = "";
    if (perempuan.isSelected()) {
        jenisKelamin = "P";
    } else if (laki_laki.isSelected()) {
        jenisKelamin = "L";
    }

    if (nisn.isEmpty() || nisn.equals("ID")) {
        JOptionPane.showMessageDialog(this, "NISN tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }
    if (nama.isEmpty() || nama.equals("NAMA LENGKAP")) {
        JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }
    if (password.isEmpty() || password.equals("PASSWORD")) {
        JOptionPane.showMessageDialog(this, "Password tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }
    if (jenisKelamin.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Pilih jenis kelamin terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    Connection conn = koneksi.koneksiDB();

    // Cek NISN sudah terdaftar atau belum (cek di regissiswa)
    String cek = "SELECT * FROM regissiswa WHERE nisn = ?";
    PreparedStatement pstCek = conn.prepareStatement(cek);
    pstCek.setString(1, nisn);
    ResultSet rsCek = pstCek.executeQuery();

    if (rsCek.next()) {
        JOptionPane.showMessageDialog(this, "NISN sudah terdaftar!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        rsCek.close();
        pstCek.close();
        conn.close();
        return;
    }
    rsCek.close();
    pstCek.close();

    // Pecah "X ANIMASI" menjadi kelasSaja="X" dan jurusan="ANIMASI"
    String kelasSaja = kelas;
    String jurusan = "";
    int spaceIdx = kelas.indexOf(' ');
    if (spaceIdx != -1) {
        kelasSaja = kelas.substring(0, spaceIdx).trim();
        jurusan = kelas.substring(spaceIdx + 1).trim();
    }

    String jenisKelaminFull = jenisKelamin.equals("L") ? "Laki - Laki" : "Perempuan";

    // ===== 1) INSERT ke datasiswa DULU (tabel induk / parent, wajib ada duluan) =====
    // Cek dulu apakah nisn ini sudah ada di datasiswa (mis. sudah diinput admin sebelumnya)
    String cekDataSiswa = "SELECT * FROM datasiswa WHERE nisn = ?";
    PreparedStatement pstCekDS = conn.prepareStatement(cekDataSiswa);
    pstCekDS.setString(1, nisn);
    ResultSet rsCekDS = pstCekDS.executeQuery();
    boolean sudahAdaDiDataSiswa = rsCekDS.next();
    rsCekDS.close();
    pstCekDS.close();

    if (!sudahAdaDiDataSiswa) {
        String sqlSiswa = "INSERT INTO datasiswa "
                + "(nisn, nama_siswa, kelas, jurusan, jenis_kelamin) "
                + "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement pstSiswa = conn.prepareStatement(sqlSiswa);
        pstSiswa.setString(1, nisn);
        pstSiswa.setString(2, nama);
        pstSiswa.setString(3, kelasSaja);
        pstSiswa.setString(4, jurusan);
        pstSiswa.setString(5, jenisKelaminFull);
        pstSiswa.executeUpdate();
        pstSiswa.close();
    }

    // ===== 2) INSERT ke regissiswa (untuk login), setelah nisn dipastikan ada di datasiswa =====
    String sql = "INSERT INTO regissiswa "
            + "(nisn, nama_siswa, username, password, kelas, jenis_kelamin) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

    PreparedStatement pst = conn.prepareStatement(sql);
    pst.setString(1, nisn);
    pst.setString(2, nama);
    pst.setString(3, nisn);
    pst.setString(4, password);
    pst.setString(5, kelas);
    pst.setString(6, jenisKelamin);

    int berhasil = pst.executeUpdate();
    pst.close();

    if (berhasil > 0) {
        JOptionPane.showMessageDialog(
            this,
            "Registrasi berhasil!\n\n"
            + "Username : " + nisn + "\n"
            + "Password : " + password + "\n\n"
            + "Silakan login menggunakan akun tersebut.",
            "Sukses",
            JOptionPane.INFORMATION_MESSAGE
        );

        loginsiswa login = new loginsiswa();
        login.setVisible(true);
        this.dispose();
    }

    conn.close();

} catch (Exception e) {
    JOptionPane.showMessageDialog(
        this,
        "Gagal menyimpan data!\n" + e.getMessage(),
        "Error",
        JOptionPane.ERROR_MESSAGE
    );
    e.printStackTrace();
}
    }//GEN-LAST:event_btn_daftar1ActionPerformed

    private void btn_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembaliActionPerformed
        new loginsiswa().setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_btn_kembaliActionPerformed

    private void txt_passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passFocusGained
        String pass=txt_pass.getText();
        if(pass.equals("PASSWORD")){
            txt_pass.setText("");
        }
    }//GEN-LAST:event_txt_passFocusGained

    private void txt_passFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passFocusLost
        String pass=txt_pass.getText();
        if(pass.equals("")||pass.equals("PASSWORD")){
            txt_pass.setText("PASSWORD");
        }
    }//GEN-LAST:event_txt_passFocusLost

    private void perempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perempuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perempuanActionPerformed

    private void laki_lakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laki_lakiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laki_lakiActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom.JButtonCustom btn_daftar1;
    private custom.JButtonCustom btn_kembali;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton laki_laki;
    private javax.swing.JRadioButton perempuan;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_pass;
    // End of variables declaration//GEN-END:variables
}
