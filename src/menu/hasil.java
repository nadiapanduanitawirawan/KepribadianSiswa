package menu;
 
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import tampilan.loginsiswa;
 
public class hasil extends javax.swing.JFrame {
 
    private static final String TABEL_JAWABAN   = "jawaban_siswa"; 
    private static final String KOLOM_NISN      = "nisn";
    private static final String KOLOM_ID_GEJALA = "id_gejala"; 
 
    // urutan tetap: KP001..KP005 -> Introvert .. Ekstrovert
    private static final String[] KODE_KP = {"KP001", "KP002", "KP003", "KP004", "KP005"};
    private static final String[] NAMA_KEPRIBADIAN = {
        "Introvert", "Cenderung Introvert", "Ambivert", "Cenderung Ekstrovert", "Ekstrovert"
    };
 
    private double persenIntrovert;
    private double persenCenderungIntrovert;
    private double persenAmbivert;
    private double persenCenderungEkstrovert;
    private double persenEkstrovert;
    private String kepribadian;
    private String nisn;
    private Connection con;
 
    public hasil() {
        initComponents();
        setTitle("Hasil Identifikasi Kepribadian");
    }
 
    private void tampilkanHasil(String nisn, String nama) {
 
    txt_saran.setLineWrap(true);
    txt_saran.setWrapStyleWord(true);
    txt_saran.setEditable(false);

    jbl_namaa.setText(nama);

    String kelas = "-";
    String jurusan = "";
    this.nisn = nisn;

    try {
        Connection conn = koneksi.getConnection();
        String sql = "SELECT kelas, jurusan FROM datasiswa WHERE nisn = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nisn);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            kelas = rs.getString("kelas");
            jurusan = rs.getString("jurusan");
        }

        rs.close();
        pst.close();

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

    String kelasLengkap = (jurusan != null && !jurusan.isEmpty())
            ? kelas + " " + jurusan
            : kelas;

    jbl_kelass.setText(kelasLengkap);
 
    // menentukan kepribadian terbesar
    double[] nilai = {
        persenIntrovert,
        persenCenderungIntrovert,
        persenAmbivert,
        persenCenderungEkstrovert,
        persenEkstrovert
    };
 
    int index = 0;
 
    for (int i = 1; i < nilai.length; i++) {
        if (nilai[i] > nilai[index]) {
            index = i;
        }
    }
 
    kepribadian = NAMA_KEPRIBADIAN[index];
 
    jbl_kelas2.setText("Tipe kepribadian dominan Anda adalah " + kepribadian);
 
    DefaultTableModel model = (DefaultTableModel) tbl_kepribadian.getModel();
model.setRowCount(0);

model.addRow(new Object[]{"Introvert", bulatkanKe10(persenIntrovert) + " %"});
model.addRow(new Object[]{"Cenderung Introvert", bulatkanKe10(persenCenderungIntrovert) + " %"});
model.addRow(new Object[]{"Ambivert", bulatkanKe10(persenAmbivert) + " %"});
model.addRow(new Object[]{"Cenderung Ekstrovert", bulatkanKe10(persenCenderungEkstrovert) + " %"});
model.addRow(new Object[]{"Ekstrovert", bulatkanKe10(persenEkstrovert) + " %"});
    txt_saran.setText(getSaran(kepribadian));
 
    simpanHasil(
        nisn,
        nama,
        kelas,
        kepribadian,
        persenIntrovert,
        persenCenderungIntrovert,
        persenAmbivert,
        persenCenderungEkstrovert,
        persenEkstrovert
    );
}
    private int bulatkanKe10(double nilai) {
    return (int) (Math.round(nilai / 10.0) * 10);
}
    public hasil(String nisn, String nama) {
 
    double[] p = hitungPersentaseDariGejala(nisn);
 
    this.persenIntrovert            = p[0];
    this.persenCenderungIntrovert  = p[1];
    this.persenAmbivert            = p[2];
    this.persenCenderungEkstrovert = p[3];
    this.persenEkstrovert          = p[4];
 
    initComponents();
 
    tampilkanHasil(nisn, nama);
}
 
    private static double[] hitungPersentaseDariGejala(String nisn){
 
        int[] jumlahDipilih = new int[KODE_KP.length];
        int[] totalGejala   = new int[KODE_KP.length];
 
        try{
 
            Connection conn = koneksi.getConnection();
 
            // 1) Hitung total gejala per kode_kp dari tabel aturan
            PreparedStatement psTotal = conn.prepareStatement(
                "SELECT kode_kp, COUNT(*) AS jumlah FROM aturan GROUP BY kode_kp");
            ResultSet rsTotal = psTotal.executeQuery();
 
            while (rsTotal.next()) {
                int idx = indexOfKode(rsTotal.getString("kode_kp"));
                if (idx != -1) {
                    totalGejala[idx] = rsTotal.getInt("jumlah");
                }
            }
            rsTotal.close();
            psTotal.close();
 
            // 2) Ambil id_gejala yang dipilih siswa (disimpan koma-terpisah di jawaban_siswa)
            PreparedStatement ps =
            conn.prepareStatement(
            "SELECT id_gejala FROM jawaban_siswa WHERE nisn=?");
 
            ps.setString(1, nisn);
 
            ResultSet rs = ps.executeQuery();
 
            if(rs.next()){
 
                String data = rs.getString("id_gejala");
 
                String[] gejala = data.split(",");
 
                // 3) Untuk tiap gejala yang dipilih, cari kode_kp-nya lewat tabel aturan
                PreparedStatement ps2 =
                conn.prepareStatement(
                "SELECT kode_kp FROM aturan WHERE id_gejala=?");
 
                for(String g : gejala){
 
                    g = g.trim();
 
                    ps2.setString(1,g);
 
                    ResultSet r2 = ps2.executeQuery();
 
                    if(r2.next()){
 
                        String kodeKp = r2.getString("kode_kp").trim();
                        int idx = indexOfKode(kodeKp);
                        if (idx != -1) {
                            jumlahDipilih[idx]++;
                        }
                    }
 
                    r2.close();
                }
 
                ps2.close();
            }
 
            rs.close();
            ps.close();
 
        }catch(Exception e){
 
            e.printStackTrace();
        }
 
        double[] hasilPersen = new double[KODE_KP.length];
        for (int i = 0; i < KODE_KP.length; i++) {
            hasilPersen[i] = (totalGejala[i] == 0)
                ? 0
                : (jumlahDipilih[i] / (double) totalGejala[i]) * 100;
        }
 
        return hasilPersen;
    }
 
    private static int indexOfKode(String kodeKp) {
        if (kodeKp == null) return -1;
        for (int i = 0; i < KODE_KP.length; i++) {
            if (KODE_KP[i].equalsIgnoreCase(kodeKp)) {
                return i;
            }
        }
        return -1;
    }
 
    private String getSaran(String kepribadian) {
 
    try {
        Connection conn = koneksi.getConnection();
 
        String sql = "SELECT saran FROM kepribadian WHERE nama_kepribadian = ?";
 
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, kepribadian);
 
        ResultSet rs = pst.executeQuery();
 
        if (rs.next()) {
            return rs.getString("saran");
        }
 
        rs.close();
        pst.close();
 
    } catch (Exception e) {
        System.out.println("Error ambil saran : " + e.getMessage());
    }
 
    return "Belum terdapat saran untuk tipe kepribadian ini.";
}
 
    private void simpanHasil(String nisn,
                         String nama,
                         String kelas,
                         String kepribadian,
                         double pIntrovert,
                         double pCIntrovert,
                         double pAmbivert,
                         double pCEkstrovert,
                         double pEkstrovert) {
 
    if (nisn == null || nisn.trim().isEmpty()) return;
 
    try {
        Connection conn = koneksi.getConnection();
 
        String cek = "SELECT nisn FROM hasil_identifikasi WHERE nisn=?";
        PreparedStatement pstCek = conn.prepareStatement(cek);
        pstCek.setString(1, nisn);
        ResultSet rs = pstCek.executeQuery();
 
        if (rs.next()) {
 
            String update =
                "UPDATE hasil_identifikasi SET " +
                "nama_siswa=?, kelas_siswa=?, kepribadian=?, " +
                "persen_introvert=?, persen_cenderung_introvert=?, " +
                "persen_ambivert=?, persen_cenderung_ekstrovert=?, " +
                "persen_ekstrovert=?, saran=?, tanggal=NOW() " +
                "WHERE nisn=?";
 
            PreparedStatement pst = conn.prepareStatement(update);
 
            pst.setString(1, nama);
            pst.setString(2, kelas);
            pst.setString(3, kepribadian);
            pst.setDouble(4, pIntrovert);
            pst.setDouble(5, pCIntrovert);
            pst.setDouble(6, pAmbivert);
            pst.setDouble(7, pCEkstrovert);
            pst.setDouble(8, pEkstrovert);
            pst.setString(9, getSaran(kepribadian));
            pst.setString(10, nisn);
 
            pst.executeUpdate();
            pst.close();
 
        } else {
 
            String insert =
                "INSERT INTO hasil_identifikasi " +
                "(nisn, nama_siswa, kelas_siswa, kepribadian, " +
                "persen_introvert, persen_cenderung_introvert, " +
                "persen_ambivert, persen_cenderung_ekstrovert, " +
                "persen_ekstrovert, saran) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";
 
            PreparedStatement pst = conn.prepareStatement(insert);
 
            pst.setString(1, nisn);
            pst.setString(2, nama);
            pst.setString(3, kelas);
            pst.setString(4, kepribadian);
            pst.setDouble(5, pIntrovert);
            pst.setDouble(6, pCIntrovert);
            pst.setDouble(7, pAmbivert);
            pst.setDouble(8, pCEkstrovert);
            pst.setDouble(9, pEkstrovert);
            pst.setString(10, getSaran(kepribadian));
 
            pst.executeUpdate();
            pst.close();
        }
 
        rs.close();
        pstCek.close();
 
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Gagal menyimpan hasil:\n" + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        judul = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        gambartb = new javax.swing.JLabel();
        jbl_namasiswa = new javax.swing.JLabel();
        jbl_kelas = new javax.swing.JLabel();
        jbl_kelas1 = new javax.swing.JLabel();
        jbl_kelas2 = new javax.swing.JLabel();
        jbl_namaa = new javax.swing.JLabel();
        jbl_kelass = new javax.swing.JLabel();
        gambarr = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_saran = new javax.swing.JTextArea();
        btn_printhasil = new custom.JButtonCustom();
        btn_logout = new custom.JButtonCustom();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_kepribadian = new custom.JTableCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 252, 251));
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(78, 147, 181));
        jPanel2.setLayout(null);

        judul.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        judul.setForeground(new java.awt.Color(255, 255, 255));
        judul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul.setText("SISTEM PAKAR IDENTIFIKASI KEPRIBADIAN SISWA");
        jPanel2.add(judul);
        judul.setBounds(360, 20, 640, 20);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1370, 60);

        jPanel6.setBackground(new java.awt.Color(255, 252, 251));

        gambartb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoo.png"))); // NOI18N

        jbl_namasiswa.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jbl_namasiswa.setText("Nama     :");

        jbl_kelas.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jbl_kelas.setText("Kelas      :");

        jbl_kelas1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jbl_kelas1.setText("Saran");

        jbl_kelas2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jbl_kelas2.setText("Kepribadian dengan persentase tertinggi adalah tipe kepribadianmu");

        jbl_namaa.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N

        jbl_kelass.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N

        gambarr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/426822c552d9504a6fb4bea287ee810b.jpg"))); // NOI18N
        gambarr.setText("jLabel1");

        txt_saran.setColumns(20);
        txt_saran.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        txt_saran.setRows(5);
        txt_saran.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(txt_saran);

        btn_printhasil.setText("PRINT");
        btn_printhasil.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        btn_printhasil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printhasilActionPerformed(evt);
            }
        });

        btn_logout.setText("LOGOUT");
        btn_logout.setFillClick(new java.awt.Color(83, 97, 106));
        btn_logout.setFillOriginal(new java.awt.Color(153, 153, 153));
        btn_logout.setFillOver(new java.awt.Color(180, 188, 194));
        btn_logout.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        btn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_logoutMouseExited(evt);
            }
        });

        tbl_kepribadian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Kepribadian", "Persentase"
            }
        ));
        tbl_kepribadian.setFont(new java.awt.Font("Roboto", 0, 17)); // NOI18N
        jScrollPane3.setViewportView(tbl_kepribadian);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(gambartb, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbl_namasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbl_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbl_kelass, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jbl_namaa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(512, 512, 512))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbl_kelas2, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_printhasil, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jbl_kelas1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(gambarr, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gambartb))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jbl_namasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jbl_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jbl_namaa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jbl_kelass, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jbl_kelas2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gambarr)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbl_kelas1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_printhasil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );

        getContentPane().add(jPanel6);
        jPanel6.setBounds(0, 60, 1370, 710);

        setSize(new java.awt.Dimension(1388, 824));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked
       int confirm = javax.swing.JOptionPane.showConfirmDialog(
            this, "Yakin ingin logout?", "Logout", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            this.dispose();
            new loginsiswa().setVisible(true);
        }
    }//GEN-LAST:event_btn_logoutMouseClicked

    private void btn_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseEntered
        btn_logout.setBackground(new Color(247,246,246));  
    }//GEN-LAST:event_btn_logoutMouseEntered

    private void btn_logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseExited
        btn_logout.setBackground(new Color(255,252,251));
    }//GEN-LAST:event_btn_logoutMouseExited

    private void btn_printhasilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printhasilActionPerformed
        try {
            Connection con = koneksi.getConnection();
 
            String jrxmlPath = "src/laporan/laporanjawaban.jrxml";
            String jasperPath = "src/laporan/laporanjawaban.jasper";
 
            net.sf.jasperreports.engine.JasperCompileManager.compileReportToFile(
                jrxmlPath, jasperPath
            );
 
            java.util.HashMap<String, Object> parameter = new java.util.HashMap<>();
            parameter.put("P_NISN", nisn);
 
            JasperPrint jprint = JasperFillManager.fillReport(
                jasperPath, parameter, con
            );
 
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setVisible(true);
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hasil().setVisible(true);
            }
        });
    }//GEN-LAST:event_btn_printhasilActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom.JButtonCustom btn_logout;
    private custom.JButtonCustom btn_printhasil;
    private javax.swing.JLabel gambarr;
    private javax.swing.JLabel gambartb;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jbl_kelas;
    private javax.swing.JLabel jbl_kelas1;
    private javax.swing.JLabel jbl_kelas2;
    private javax.swing.JLabel jbl_kelass;
    private javax.swing.JLabel jbl_namaa;
    private javax.swing.JLabel jbl_namasiswa;
    private javax.swing.JLabel judul;
    private custom.JTableCustom tbl_kepribadian;
    private javax.swing.JTextArea txt_saran;
    // End of variables declaration//GEN-END:variables

}
