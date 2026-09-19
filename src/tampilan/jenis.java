package tampilan;
 
import main.login;
import koneksi.koneksi;
import java.awt.Font;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
 
public class jenis extends javax.swing.JFrame {
    private javax.swing.JLabel menuAktif = null;
 
    private void tampilData() {

    jPanel3.removeAll();

    // Judul
    jPanel3.add(jLabel1);
    jLabel1.setBounds(270, 20, 430, 70);

    int yPos = 120;
    int jumlah = 0;

    try {

        Connection conn = koneksi.koneksiDB();

        String sql =
                "SELECT nama_kepribadian, saran " +
                "FROM kepribadian " +
                "ORDER BY kode_kp";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {

            jumlah++;

            String nama =
                    rs.getString("nama_kepribadian");

            String saran =
                    rs.getString("saran");

            System.out.println("DATA : " + nama);

            JPanel kartu =
                    buatPanelKepribadian(nama, saran);

            kartu.setBounds(
                    20,
                    yPos,
                    950,
                    280);

            jPanel3.add(kartu);

            yPos += 300;
        }

        System.out.println("TOTAL DATA = " + jumlah);

        rs.close();
        st.close();
        conn.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    int tinggiTotal = yPos + 50;

    jPanel3.setPreferredSize(
            new Dimension(995, tinggiTotal));

    jPanel3.setSize(
            new Dimension(995, tinggiTotal));

    jPanel1.setPreferredSize(
            new Dimension(995, tinggiTotal));

    jPanel1.setSize(
            new Dimension(995, tinggiTotal));

    jPanel3.revalidate();
    jPanel3.repaint();

    jPanel1.revalidate();
    jPanel1.repaint();

    jScrollPane1.revalidate();
    jScrollPane1.repaint();
}
    
 private JPanel buatPanelKepribadian(
        String nama,
        String saran) {

    JPanel panel = new JPanel();

    panel.setLayout(null);

    panel.setBackground(java.awt.Color.WHITE);

    panel.setBorder(
            javax.swing.BorderFactory.createLineBorder(
                    new java.awt.Color(220,220,220)));

    JLabel lblNama =
        new JLabel(
                "<html><div style='width:340px'>" + nama + "</div></html>");

    lblNama.setFont(
        new Font("Roboto", Font.BOLD, 22));

    lblNama.setForeground(
        new java.awt.Color(78,147,181));

    lblNama.setBounds(
        40,
        100,
        360,
        100);

    panel.add(lblNama);

    JLabel lblJudul =
            new JLabel("Saran:");

    lblJudul.setFont(
            new Font("Roboto", Font.BOLD, 22));

    lblJudul.setForeground(
            new java.awt.Color(78,147,181));

    lblJudul.setBounds(
            430,
            30,
            100,
            30);

    panel.add(lblJudul);

    JLabel lblSaran =
            new JLabel(
                    "<html><div style='width:420px'>"
                            + saran
                            + "</div></html>");

    lblSaran.setFont(
            new Font("Roboto", Font.PLAIN, 17));

    lblSaran.setForeground(
            new java.awt.Color(78,147,181));

    lblSaran.setBounds(
            430,
            70,
            450,
            180);

    panel.add(lblSaran);

    panel.setSize(950, 280);
    panel.setPreferredSize(
            new Dimension(950,280));

    return panel;
}
 
    private String getIconPath(String nama, int index) {
        if (nama.equalsIgnoreCase("Introvert"))  return "/img/introvert-removebg-preview.png";
        if (nama.equalsIgnoreCase("Ekstrovert")) return "/img/eks.jpg";
        if (nama.equalsIgnoreCase("Ambivert"))   return "/img/eks.jpg"; 
 
        String[] defaults = {"/img/icon1.png", "/img/icon2.png", "/img/icon3.png"};
        return (index < defaults.length) ? defaults[index] : "/img/default.png";
    }
 
    private void resetMenu() {
        lbl_beranda.setFont(new java.awt.Font("Roboto", java.awt.Font.PLAIN, 12));
        lbl_jk.setFont(new java.awt.Font("Roboto", java.awt.Font.PLAIN, 12));
        lbl_login.setFont(new java.awt.Font("Roboto", java.awt.Font.PLAIN, 12));
    }
 
    private void setActive(javax.swing.JLabel menu) {
        resetMenu();
        menu.setFont(new Font("Roboto", Font.BOLD, 14));
        menuAktif = menu;
    }
 
    public jenis() {

    initComponents();

    jPanel1.removeAll();
    jPanel1.setLayout(new java.awt.BorderLayout());
    jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

    lbl_beranda.setBorder(
            javax.swing.BorderFactory.createEmptyBorder(
                    5,10,5,10));

    lbl_jk.setBorder(
            javax.swing.BorderFactory.createEmptyBorder(
                    5,10,5,10));

    lbl_login.setBorder(
            javax.swing.BorderFactory.createEmptyBorder(
                    5,10,5,10));

    setActive(lbl_jk);

    getContentPane().setBackground(
            new java.awt.Color(255,252,251));

    jScrollPane1.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    jScrollPane1.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

    jScrollPane1.getVerticalScrollBar()
            .setUI(new scrollbar());

    jScrollPane1.getVerticalScrollBar()
            .setPreferredSize(
                    new Dimension(12,0));

    jScrollPane1.getVerticalScrollBar()
            .setUnitIncrement(10);

    tampilData();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_beranda = new javax.swing.JLabel();
        lbl_login = new javax.swing.JLabel();
        lbl_jk = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 252, 251));

        jPanel3.setBackground(new java.awt.Color(255, 252, 251));
        jPanel3.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(78, 147, 181));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("JENIS KEPRIBADIAN");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(340, 20, 430, 70);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 995, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 80, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 60, 1000, 640);

        jPanel2.setBackground(new java.awt.Color(78, 147, 181));
        jPanel2.setLayout(null);

        lbl_beranda.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbl_beranda.setForeground(new java.awt.Color(255, 255, 255));
        lbl_beranda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_beranda.setText("Beranda");
        lbl_beranda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_berandaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_berandaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_berandaMouseExited(evt);
            }
        });
        jPanel2.add(lbl_beranda);
        lbl_beranda.setBounds(630, 20, 90, 22);

        lbl_login.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbl_login.setForeground(new java.awt.Color(255, 255, 255));
        lbl_login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_login.setText("Admin");
        lbl_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_loginMouseClicked(evt);
            }
        });
        jPanel2.add(lbl_login);
        lbl_login.setBounds(900, 20, 60, 22);

        lbl_jk.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbl_jk.setForeground(new java.awt.Color(255, 255, 255));
        lbl_jk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_jk.setText("Jenis Kepribadian");
        lbl_jk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_jkMouseClicked(evt);
            }
        });
        jPanel2.add(lbl_jk);
        lbl_jk.setBounds(740, 20, 140, 22);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1000, 60);

        setSize(new java.awt.Dimension(1022, 756));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_berandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_berandaMouseClicked
        setActive(lbl_beranda);
        dashboard beranda = new dashboard();
        beranda.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_berandaMouseClicked

    private void lbl_berandaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_berandaMouseEntered

    }//GEN-LAST:event_lbl_berandaMouseEntered

    private void lbl_berandaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_berandaMouseExited

    }//GEN-LAST:event_lbl_berandaMouseExited

    private void lbl_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_loginMouseClicked
        setActive(lbl_login);
        login lg = new login();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_loginMouseClicked

    private void lbl_jkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_jkMouseClicked
        setActive(lbl_jk);
        jenis jk = new jenis();
        jk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_jkMouseClicked
public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jenis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_beranda;
    private javax.swing.JLabel lbl_jk;
    private javax.swing.JLabel lbl_login;
    // End of variables declaration//GEN-END:variables
}
