package menu;
 
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import koneksi.koneksi;
import tampilan.scrollbar;
 
public class kuesioner extends javax.swing.JFrame {
 
    private String nisnSiswa;
    private String namaSiswa;
 
    private List<JCheckBox> checkboxList   = new ArrayList<>();
    private List<String>    kodeKpList     = new ArrayList<>(); // ganti dari tipeList -> kode_kp (KP001..KP005)
    private List<String>    idGejalaList   = new ArrayList<>();
    private List<String>    namaGejalaList = new ArrayList<>();
 
    public kuesioner(String nisn, String nama) {
        this.nisnSiswa = nisn;
        this.namaSiswa = nama;
        initComponents();
        txt_namasiswa.setText(nama);
        setupScrollPane();
        loadGejalaFromDB();
    }
 
    public kuesioner(String nama) {
        this.nisnSiswa = "";
        this.namaSiswa = nama;
        initComponents();
        txt_namasiswa.setText(nama);
        setupScrollPane();
        loadGejalaFromDB();
    }
 
    public kuesioner() {
        this.nisnSiswa = "";
        this.namaSiswa = "Preview";
        initComponents();
        txt_namasiswa.setText(namaSiswa);
        setupScrollPane();
        loadGejalaFromDB();
    }
 
    private void setupScrollPane() {
        jPanel3.remove(jPanel1);
        jScrollPane1.getViewport().setBackground(new Color(255,252,251));
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane1.getVerticalScrollBar().setUI(new scrollbar());
        jScrollPane1.getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(10);
    }
 
    private void loadGejalaFromDB() {
        jPanel1.removeAll();
        checkboxList.clear();
        kodeKpList.clear();
        idGejalaList.clear();
        namaGejalaList.clear();
 
        List<String[]> kolomKiri  = new ArrayList<>();
        List<String[]> kolomKanan = new ArrayList<>();
 
        try {
            Connection conn = koneksi.getConnection();
 
            String sql = "SELECT g.id_gejala, g.nama_gejala, a.kode_kp " +
                         "FROM gejalaa g " +
                         "JOIN aturan a ON g.id_gejala = a.id_gejala " +
                         "ORDER BY CAST(SUBSTRING(g.id_gejala,3) AS UNSIGNED)";
 
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
 
            int no = 1;
            while (rs.next()) {
                String[] data = {
                    rs.getString("id_gejala"),
                    rs.getString("nama_gejala"),
                    rs.getString("kode_kp")
                };
 
                if (no <= 20) {
                    kolomKiri.add(data);
                } else {
                    kolomKanan.add(data);
                }
                no++;
            }
 
            rs.close();
            pst.close();
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Gagal memuat data gejala\n" + e.getMessage());
            return;
        }
 
        int panelW = 1380;
        int colW = 690;
        int rowH = 48;
        int startY = 10;
        int cbxW = 28;
        int lblW = 640;
 
        int contentStartY = startY;
 
        tambahKolomGejala(kolomKiri, 10, contentStartY, lblW, cbxW, rowH);
        tambahKolomGejala(kolomKanan, colW + 10, contentStartY, lblW, cbxW, rowH);
 
        int maxRows = Math.max(kolomKiri.size(), kolomKanan.size());
        int panelHeight  = contentStartY + (maxRows * rowH) + 20;
        jPanel1.setPreferredSize(new Dimension(panelW, panelHeight));
        jPanel1.revalidate();
        jPanel1.repaint();
    }
 
    private void tambahKolomGejala(List<String[]> gejalaList, int xBase, int startY,
                               int lblW, int cbxW, int rowH) {

    for (int i = 0; i < gejalaList.size(); i++) {

        String[] data = gejalaList.get(i);
        int y = startY + (i * rowH);

        JCheckBox cbx = new JCheckBox();
        cbx.setBackground(new Color(249, 248, 248));
        cbx.setBounds(xBase, y + 6, cbxW, 28);
        jPanel1.add(cbx);

        JLabel lbl = new JLabel("<html>" + data[1] + "</html>");
        lbl.setFont(new Font("Roboto", Font.PLAIN, 14));
        lbl.setForeground(new Color(102, 102, 102));

        lbl.setBounds(
            xBase + cbxW,
            y,
            lblW,
            40
        );

        jPanel1.add(lbl);

        checkboxList.add(cbx);
        kodeKpList.add(data[2]);
        idGejalaList.add(data[0]);
        namaGejalaList.add(data[1]);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel24 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_namasiswa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_selesai = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        jLabel24.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(78, 147, 181));
        jLabel24.setText("Nama Siswa :");

        jTextField2.setForeground(new java.awt.Color(78, 147, 181));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 252, 251));
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(78, 147, 181));
        jPanel2.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("SISTEM PAKAR IDENTIFIKASI KEPRIBADIAN SISWA");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(380, 20, 640, 20);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1440, 60);

        jPanel3.setBackground(new java.awt.Color(255, 252, 251));
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(78, 147, 181));
        jLabel2.setText("Nama Siswa :");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(20, 50, 110, 30);

        txt_namasiswa.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txt_namasiswa.setForeground(new java.awt.Color(78, 147, 181));
        jPanel3.add(txt_namasiswa);
        txt_namasiswa.setBounds(130, 50, 290, 30);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(78, 147, 181));
        jLabel1.setText("Data Fakta   :");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(20, 110, 110, 19);

        btn_selesai.setBackground(new java.awt.Color(78, 147, 181));
        btn_selesai.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        btn_selesai.setForeground(new java.awt.Color(255, 252, 251));
        btn_selesai.setText("SELESAI");
        btn_selesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selesaiActionPerformed(evt);
            }
        });
        jPanel3.add(btn_selesai);
        btn_selesai.setBounds(1150, 650, 190, 40);

        jPanel1.setBackground(new java.awt.Color(249, 248, 248));
        jPanel1.setMinimumSize(new java.awt.Dimension(1340, 440));
        jPanel1.setPreferredSize(new java.awt.Dimension(1340, 440));
        jPanel1.setLayout(null);
        jScrollPane1.setViewportView(jPanel1);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(20, 140, 1400, 480);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 60, 1440, 710);

        setSize(new java.awt.Dimension(1457, 824));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btn_selesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selesaiActionPerformed
       List<String> gejalaDipilih = new ArrayList<>();
 
        for (int i = 0; i < checkboxList.size(); i++) {
            if (checkboxList.get(i).isSelected()) {
                gejalaDipilih.add(idGejalaList.get(i));
            }
        }
 
        if (gejalaDipilih.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih minimal satu jawaban.",
                "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            Connection conn = koneksi.getConnection();
            String nisnInsert = (nisnSiswa == null || nisnSiswa.isEmpty()) ? "0" : nisnSiswa;
 
            PreparedStatement pstHapus = conn.prepareStatement(
                "DELETE FROM jawaban_siswa WHERE nisn = ?");
            pstHapus.setString(1, nisnInsert);
            pstHapus.executeUpdate();
            pstHapus.close();
 
            String idGejalaGabung = String.join(", ", gejalaDipilih);
 
            PreparedStatement pstInsert = conn.prepareStatement(
                "INSERT INTO jawaban_siswa (nisn, nama_siswa, id_gejala) VALUES (?, ?, ?)");
            pstInsert.setString(1, nisnInsert);
            pstInsert.setString(2, txt_namasiswa.getText());
            pstInsert.setString(3, idGejalaGabung);
            pstInsert.executeUpdate();
            pstInsert.close();
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
 
            hasil halamanHasil = new hasil(
            nisnSiswa,
            txt_namasiswa.getText()
        );
        halamanHasil.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_selesaiActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new kuesioner().setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_selesai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField txt_namasiswa;
    // End of variables declaration//GEN-END:variables
}
