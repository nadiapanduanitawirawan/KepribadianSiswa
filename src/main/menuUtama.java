package main;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import view.MenuDashboard;
import view.MenuGejalaa;
import view.MenuKepribadiann;
import view.MenuRiwayat;
import view.MenuSiswa;
import view.MenuAturan;

public class menuUtama extends javax.swing.JFrame {

    private final MenuDashboard    panelDashboard   = new MenuDashboard();
    private final MenuSiswa        panelSiswa       = new MenuSiswa();
    private final MenuKepribadiann panelKepribadian = new MenuKepribadiann();
    private final MenuGejalaa      panelgejala      = new MenuGejalaa();
    private final MenuRiwayat      panelRiwayat     = new MenuRiwayat();
    private final MenuAturan panelAturan = new MenuAturan();
    private String namaAdmin = "Admin";
    private javax.swing.JLabel lb_namaAdmin;
    
    public menuUtama() {
    this("Admin"); // fallback kalau dipanggil tanpa nama
}

public menuUtama(String namaAdmin) {
    initComponents();
    this.namaAdmin = namaAdmin;

    lb_title = new javax.swing.JLabel();
    lb_title.setFont(new java.awt.Font("Roboto", 1, 18));
    lb_title.setForeground(new java.awt.Color(255, 255, 255));
    lb_title.setText("");
    jPanel1.add(lb_title);
    lb_title.setBounds(20, 15, 200, 30);

    // label baru untuk nama admin yang login
    lb_namaAdmin = new javax.swing.JLabel();
    lb_namaAdmin.setFont(new java.awt.Font("Roboto", 1, 14));
    lb_namaAdmin.setForeground(new java.awt.Color(255, 255, 255));
    lb_namaAdmin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    lb_namaAdmin.setText(namaAdmin); // bisa juga "Halo, " + namaAdmin
    jPanel1.add(lb_namaAdmin);
    lb_namaAdmin.setBounds(823, 15, 220, 30);

    showPanel(panelDashboard, "Dashboard");
    setActive(pn_dashboard, pn_line, btn_dashboard);
}

    private void showPanel(JPanel panel, String title) {
        lb_title.setText(title);
        pn_utama.removeAll();
        pn_utama.setLayout(new BorderLayout());
        pn_utama.add(panel, BorderLayout.CENTER);
        pn_utama.revalidate();
        pn_utama.repaint();
    }

    private javax.swing.JLabel lb_title;

    private void setActive(javax.swing.JPanel panel, javax.swing.JPanel line, javax.swing.JLabel label) {
        panel.setBackground(new Color(240, 240, 240));
        line.setBackground(new Color(0, 102, 153));
        label.setFont(label.getFont().deriveFont(java.awt.Font.BOLD));
    }

    private void setDefault(javax.swing.JPanel panel, javax.swing.JPanel line, javax.swing.JLabel label) {
        panel.setBackground(new Color(255, 252, 251));
        line.setBackground(new Color(255, 252, 251));
        label.setFont(label.getFont().deriveFont(java.awt.Font.PLAIN));
    }

    private void resetAllMenu() {
        setDefault(pn_dashboard,   pn_line,  btn_dashboard);
        setDefault(pn_datasiswa,   pn_line1, btn_siswa);
        setDefault(pn_gejala,      pn_line5, btn_gejala);
        setDefault(pn_kepribadian, pn_line8, btn_kepribadian);
        setDefault(pn_riwayat,     pn_line6, btn_riwayat);
        setDefault(pn_aturan,      pn_line10, btn_aturan);   // tambahan ini
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_kiri = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lb_logo = new javax.swing.JLabel();
        lb_dirimu = new javax.swing.JLabel();
        pn_dashboard = new javax.swing.JPanel();
        pn_line = new javax.swing.JPanel();
        logodas = new javax.swing.JLabel();
        btn_dashboard = new javax.swing.JLabel();
        pn_logout = new javax.swing.JPanel();
        pn_line7 = new javax.swing.JPanel();
        logologout = new javax.swing.JLabel();
        btn_logout = new javax.swing.JLabel();
        pn_datasiswa = new javax.swing.JPanel();
        pn_line1 = new javax.swing.JPanel();
        logosiswa = new javax.swing.JLabel();
        btn_siswa = new javax.swing.JLabel();
        pn_gejala = new javax.swing.JPanel();
        pn_line5 = new javax.swing.JPanel();
        logorule = new javax.swing.JLabel();
        btn_gejala = new javax.swing.JLabel();
        pn_riwayat = new javax.swing.JPanel();
        pn_line6 = new javax.swing.JPanel();
        logorule1 = new javax.swing.JLabel();
        btn_riwayat = new javax.swing.JLabel();
        pn_kepribadian = new javax.swing.JPanel();
        pn_line8 = new javax.swing.JPanel();
        logorule2 = new javax.swing.JLabel();
        btn_kepribadian = new javax.swing.JLabel();
        pn_aturan = new javax.swing.JPanel();
        pn_line10 = new javax.swing.JPanel();
        logorule3 = new javax.swing.JLabel();
        btn_aturan = new javax.swing.JLabel();
        pn_kanan = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pn_dasar = new javax.swing.JPanel();
        pn_utama = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pn_kiri.setBackground(new java.awt.Color(255, 252, 251));

        jLabel1.setBackground(new java.awt.Color(78, 147, 181));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(78, 147, 181));
        jLabel1.setText("Kenali");

        lb_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoo.png"))); // NOI18N

        lb_dirimu.setBackground(new java.awt.Color(78, 147, 181));
        lb_dirimu.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lb_dirimu.setForeground(new java.awt.Color(78, 147, 181));
        lb_dirimu.setText("Dirimu");

        pn_dashboard.setBackground(new java.awt.Color(255, 252, 251));
        pn_dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_dashboardMouseClicked(evt);
            }
        });

        pn_line.setBackground(new java.awt.Color(255, 252, 251));

        javax.swing.GroupLayout pn_lineLayout = new javax.swing.GroupLayout(pn_line);
        pn_line.setLayout(pn_lineLayout);
        pn_lineLayout.setHorizontalGroup(
            pn_lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        pn_lineLayout.setVerticalGroup(
            pn_lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        logodas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/das.png"))); // NOI18N

        btn_dashboard.setBackground(new java.awt.Color(255, 252, 251));
        btn_dashboard.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        btn_dashboard.setForeground(new java.awt.Color(187, 187, 187));
        btn_dashboard.setText("Dashboard");
        btn_dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_dashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_dashboardMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_dashboardLayout = new javax.swing.GroupLayout(pn_dashboard);
        pn_dashboard.setLayout(pn_dashboardLayout);
        pn_dashboardLayout.setHorizontalGroup(
            pn_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dashboardLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pn_line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logodas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        pn_dashboardLayout.setVerticalGroup(
            pn_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dashboardLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(pn_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_dashboardLayout.createSequentialGroup()
                        .addGroup(pn_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logodas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pn_line, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pn_logout.setBackground(new java.awt.Color(255, 252, 251));
        pn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_logoutMouseClicked(evt);
            }
        });

        pn_line7.setBackground(new java.awt.Color(255, 252, 251));

        javax.swing.GroupLayout pn_line7Layout = new javax.swing.GroupLayout(pn_line7);
        pn_line7.setLayout(pn_line7Layout);
        pn_line7Layout.setHorizontalGroup(
            pn_line7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        pn_line7Layout.setVerticalGroup(
            pn_line7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        logologout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log.png"))); // NOI18N

        btn_logout.setBackground(new java.awt.Color(255, 252, 251));
        btn_logout.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(187, 187, 187));
        btn_logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_logout.setText("Logout");
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

        javax.swing.GroupLayout pn_logoutLayout = new javax.swing.GroupLayout(pn_logout);
        pn_logout.setLayout(pn_logoutLayout);
        pn_logoutLayout.setHorizontalGroup(
            pn_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_logoutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pn_line7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logologout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        pn_logoutLayout.setVerticalGroup(
            pn_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_logoutLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(pn_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_logoutLayout.createSequentialGroup()
                        .addGroup(pn_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logologout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pn_line7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pn_datasiswa.setBackground(new java.awt.Color(255, 252, 251));
        pn_datasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_datasiswaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_datasiswaMouseEntered(evt);
            }
        });

        pn_line1.setBackground(new java.awt.Color(255, 252, 251));

        javax.swing.GroupLayout pn_line1Layout = new javax.swing.GroupLayout(pn_line1);
        pn_line1.setLayout(pn_line1Layout);
        pn_line1Layout.setHorizontalGroup(
            pn_line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        pn_line1Layout.setVerticalGroup(
            pn_line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        logosiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N

        btn_siswa.setBackground(new java.awt.Color(255, 252, 251));
        btn_siswa.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        btn_siswa.setForeground(new java.awt.Color(187, 187, 187));
        btn_siswa.setText("Data Siswa");
        btn_siswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_siswaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_siswaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_siswaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_datasiswaLayout = new javax.swing.GroupLayout(pn_datasiswa);
        pn_datasiswa.setLayout(pn_datasiswaLayout);
        pn_datasiswaLayout.setHorizontalGroup(
            pn_datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_datasiswaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pn_line1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logosiswa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        pn_datasiswaLayout.setVerticalGroup(
            pn_datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_datasiswaLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(pn_datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_datasiswaLayout.createSequentialGroup()
                        .addGroup(pn_datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logosiswa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pn_line1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pn_gejala.setBackground(new java.awt.Color(255, 252, 251));
        pn_gejala.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_gejalaMouseClicked(evt);
            }
        });

        pn_line5.setBackground(new java.awt.Color(255, 252, 251));

        javax.swing.GroupLayout pn_line5Layout = new javax.swing.GroupLayout(pn_line5);
        pn_line5.setLayout(pn_line5Layout);
        pn_line5Layout.setHorizontalGroup(
            pn_line5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        pn_line5Layout.setVerticalGroup(
            pn_line5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        logorule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Shaking.png"))); // NOI18N

        btn_gejala.setBackground(new java.awt.Color(255, 252, 251));
        btn_gejala.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        btn_gejala.setForeground(new java.awt.Color(187, 187, 187));
        btn_gejala.setText("Data Gejala");
        btn_gejala.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_gejalaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_gejalaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_gejalaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_gejalaLayout = new javax.swing.GroupLayout(pn_gejala);
        pn_gejala.setLayout(pn_gejalaLayout);
        pn_gejalaLayout.setHorizontalGroup(
            pn_gejalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_gejalaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pn_line5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logorule)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_gejala, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_gejalaLayout.setVerticalGroup(
            pn_gejalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_gejalaLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(pn_gejalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_gejalaLayout.createSequentialGroup()
                        .addGroup(pn_gejalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logorule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_gejala, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pn_line5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pn_riwayat.setBackground(new java.awt.Color(255, 252, 251));
        pn_riwayat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_riwayatMouseClicked(evt);
            }
        });

        pn_line6.setBackground(new java.awt.Color(255, 252, 251));

        javax.swing.GroupLayout pn_line6Layout = new javax.swing.GroupLayout(pn_line6);
        pn_line6.setLayout(pn_line6Layout);
        pn_line6Layout.setHorizontalGroup(
            pn_line6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        pn_line6Layout.setVerticalGroup(
            pn_line6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        logorule1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Report Card.png"))); // NOI18N

        btn_riwayat.setBackground(new java.awt.Color(255, 252, 251));
        btn_riwayat.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        btn_riwayat.setForeground(new java.awt.Color(187, 187, 187));
        btn_riwayat.setText("Jumlah Riwayat");
        btn_riwayat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_riwayatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_riwayatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_riwayatMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_riwayatLayout = new javax.swing.GroupLayout(pn_riwayat);
        pn_riwayat.setLayout(pn_riwayatLayout);
        pn_riwayatLayout.setHorizontalGroup(
            pn_riwayatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_riwayatLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pn_line6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logorule1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_riwayat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_riwayatLayout.setVerticalGroup(
            pn_riwayatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_riwayatLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(pn_riwayatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_riwayatLayout.createSequentialGroup()
                        .addGroup(pn_riwayatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logorule1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_riwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pn_line6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );

        pn_kepribadian.setBackground(new java.awt.Color(255, 252, 251));
        pn_kepribadian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_kepribadianMouseClicked(evt);
            }
        });

        pn_line8.setBackground(new java.awt.Color(255, 252, 251));

        javax.swing.GroupLayout pn_line8Layout = new javax.swing.GroupLayout(pn_line8);
        pn_line8.setLayout(pn_line8Layout);
        pn_line8Layout.setHorizontalGroup(
            pn_line8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        pn_line8Layout.setVerticalGroup(
            pn_line8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        logorule2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Bipolar Disorder.png"))); // NOI18N

        btn_kepribadian.setBackground(new java.awt.Color(255, 252, 251));
        btn_kepribadian.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        btn_kepribadian.setForeground(new java.awt.Color(187, 187, 187));
        btn_kepribadian.setText("Data Kepribadian");
        btn_kepribadian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_kepribadianMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_kepribadianMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_kepribadianMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_kepribadianLayout = new javax.swing.GroupLayout(pn_kepribadian);
        pn_kepribadian.setLayout(pn_kepribadianLayout);
        pn_kepribadianLayout.setHorizontalGroup(
            pn_kepribadianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_kepribadianLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pn_line8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logorule2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_kepribadian, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_kepribadianLayout.setVerticalGroup(
            pn_kepribadianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_kepribadianLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(pn_kepribadianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_kepribadianLayout.createSequentialGroup()
                        .addGroup(pn_kepribadianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logorule2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_kepribadian, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pn_line8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pn_aturan.setBackground(new java.awt.Color(255, 252, 251));
        pn_aturan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_aturanMouseClicked(evt);
            }
        });

        pn_line10.setBackground(new java.awt.Color(255, 252, 251));

        javax.swing.GroupLayout pn_line10Layout = new javax.swing.GroupLayout(pn_line10);
        pn_line10.setLayout(pn_line10Layout);
        pn_line10Layout.setHorizontalGroup(
            pn_line10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        pn_line10Layout.setVerticalGroup(
            pn_line10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        logorule3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rules Book.png"))); // NOI18N

        btn_aturan.setBackground(new java.awt.Color(255, 252, 251));
        btn_aturan.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        btn_aturan.setForeground(new java.awt.Color(187, 187, 187));
        btn_aturan.setText("Data Aturan");
        btn_aturan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_aturanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_aturanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_aturanMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_aturanLayout = new javax.swing.GroupLayout(pn_aturan);
        pn_aturan.setLayout(pn_aturanLayout);
        pn_aturanLayout.setHorizontalGroup(
            pn_aturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_aturanLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pn_line10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logorule3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_aturan, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_aturanLayout.setVerticalGroup(
            pn_aturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_aturanLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(pn_aturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_aturanLayout.createSequentialGroup()
                        .addGroup(pn_aturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logorule3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_aturan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pn_line10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pn_kiriLayout = new javax.swing.GroupLayout(pn_kiri);
        pn_kiri.setLayout(pn_kiriLayout);
        pn_kiriLayout.setHorizontalGroup(
            pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_kiriLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_kiriLayout.createSequentialGroup()
                        .addComponent(lb_logo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_dirimu, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pn_datasiswa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_gejala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_kepribadian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_aturan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_riwayat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_kiriLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pn_kiriLayout.setVerticalGroup(
            pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_kiriLayout.createSequentialGroup()
                .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_kiriLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lb_logo))
                    .addGroup(pn_kiriLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)
                        .addComponent(lb_dirimu)))
                .addGap(45, 45, 45)
                .addComponent(pn_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(pn_datasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(pn_gejala, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(pn_kepribadian, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(pn_aturan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(pn_riwayat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(pn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        getContentPane().add(pn_kiri, java.awt.BorderLayout.LINE_START);

        pn_kanan.setBackground(new java.awt.Color(255, 252, 251));
        pn_kanan.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(78, 147, 181));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1073, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        pn_kanan.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pn_dasar.setBackground(new java.awt.Color(247, 246, 246));

        pn_utama.setBackground(new java.awt.Color(255, 252, 251));
        pn_utama.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pn_dasarLayout = new javax.swing.GroupLayout(pn_dasar);
        pn_dasar.setLayout(pn_dasarLayout);
        pn_dasarLayout.setHorizontalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dasarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pn_utama, javax.swing.GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        pn_dasarLayout.setVerticalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_dasarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pn_utama, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pn_kanan.add(pn_dasar, java.awt.BorderLayout.CENTER);

        getContentPane().add(pn_kanan, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1366, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboardMouseEntered
        if (!btn_dashboard.getFont().isBold()) { 
            pn_dashboard.setBackground(new Color(247,246,246)); 
            pn_line.setBackground(new Color(0,102,153)); 
        }
    }//GEN-LAST:event_btn_dashboardMouseEntered

    private void btn_dashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboardMouseExited
        if (!btn_dashboard.getFont().isBold()) { 
            pn_dashboard.setBackground(new Color(255,252,251));
            pn_line.setBackground(new Color(255,252,251)); 
        }
    }//GEN-LAST:event_btn_dashboardMouseExited

    private void pn_dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_dashboardMouseClicked
        resetAllMenu();
        setActive(pn_dashboard, pn_line, btn_dashboard);
        showPanel(panelDashboard, "Dashboard");
    }//GEN-LAST:event_pn_dashboardMouseClicked

    private void btn_dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboardMouseClicked
        resetAllMenu();
        setActive(pn_dashboard, pn_line, btn_dashboard);
        showPanel(panelDashboard, "Dashboard");
    }//GEN-LAST:event_btn_dashboardMouseClicked

    private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked
        int confirm = javax.swing.JOptionPane.showConfirmDialog(
            this, "Yakin ingin logout?", "Logout", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            this.dispose();
            new login().setVisible(true);
        }
    }//GEN-LAST:event_btn_logoutMouseClicked

    private void btn_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseEntered
        pn_logout.setBackground(new Color(247,246,246)); 
        pn_line7.setBackground(new Color(0,102,153));
    }//GEN-LAST:event_btn_logoutMouseEntered

    private void btn_logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseExited
        pn_logout.setBackground(new Color(255,252,251)); 
        pn_line7.setBackground(new Color(255,252,251));
    }//GEN-LAST:event_btn_logoutMouseExited

    private void pn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_logoutMouseClicked
        btn_logoutMouseClicked(evt);
    }//GEN-LAST:event_pn_logoutMouseClicked

    private void btn_siswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_siswaMouseClicked
        resetAllMenu();
        setActive(pn_datasiswa, pn_line1, btn_siswa);
        showPanel(panelSiswa, "Data Siswa");
    }//GEN-LAST:event_btn_siswaMouseClicked

    private void btn_siswaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_siswaMouseEntered
        if (!btn_siswa.getFont().isBold()) { 
            pn_datasiswa.setBackground(new Color(247,246,246)); 
            pn_line1.setBackground(new Color(0,102,153)); 
        }
    }//GEN-LAST:event_btn_siswaMouseEntered

    private void btn_siswaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_siswaMouseExited
        if (!btn_siswa.getFont().isBold()) { 
            pn_datasiswa.setBackground(new Color(255,252,251)); 
            pn_line1.setBackground(new Color(255,252,251)); 
        }
    }//GEN-LAST:event_btn_siswaMouseExited

    private void pn_datasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_datasiswaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pn_datasiswaMouseClicked

    private void pn_datasiswaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_datasiswaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_pn_datasiswaMouseEntered

    private void btn_gejalaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gejalaMouseClicked
        resetAllMenu();
        setActive(pn_gejala, pn_line5, btn_gejala);
        showPanel(panelgejala, "Data Gejala");
    }//GEN-LAST:event_btn_gejalaMouseClicked

    private void btn_gejalaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gejalaMouseEntered
        if (!btn_gejala.getFont().isBold()) { 
            pn_gejala.setBackground(new Color(247,246,246)); 
            pn_line5.setBackground(new Color(0,102,153)); 
        }
    }//GEN-LAST:event_btn_gejalaMouseEntered

    private void btn_gejalaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gejalaMouseExited
        if (!btn_gejala.getFont().isBold()) { 
            pn_gejala.setBackground(new Color(255,252,251)); 
            pn_line5.setBackground(new Color(255,252,251)); 
        }
    }//GEN-LAST:event_btn_gejalaMouseExited

    private void pn_gejalaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_gejalaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pn_gejalaMouseClicked

    private void btn_riwayatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_riwayatMouseClicked
        resetAllMenu();
        setActive(pn_riwayat, pn_line6, btn_riwayat);
        showPanel(panelRiwayat, "Riwayat Pengguna");
    }//GEN-LAST:event_btn_riwayatMouseClicked

    private void btn_riwayatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_riwayatMouseEntered
        if (!btn_riwayat.getFont().isBold()) { 
            pn_riwayat.setBackground(new Color(247,246,246)); 
            pn_line6.setBackground(new Color(0,102,153)); 
        }
    }//GEN-LAST:event_btn_riwayatMouseEntered

    private void btn_riwayatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_riwayatMouseExited
        if (!btn_riwayat.getFont().isBold()) { 
            pn_riwayat.setBackground(new Color(255,252,251)); 
            pn_line6.setBackground(new Color(255,252,251)); 
        }
    }//GEN-LAST:event_btn_riwayatMouseExited

    private void pn_riwayatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_riwayatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pn_riwayatMouseClicked

    private void btn_kepribadianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kepribadianMouseClicked
        resetAllMenu();
        setActive(pn_kepribadian, pn_line8, btn_kepribadian);
        showPanel(panelKepribadian, "Data Kepribadian");
    }//GEN-LAST:event_btn_kepribadianMouseClicked

    private void btn_kepribadianMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kepribadianMouseEntered
        if (!btn_kepribadian.getFont().isBold()) { 
            pn_kepribadian.setBackground(new Color(247,246,246)); 
            pn_line8.setBackground(new Color(0,102,153)); 
        }
    }//GEN-LAST:event_btn_kepribadianMouseEntered

    private void btn_kepribadianMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kepribadianMouseExited
        if (!btn_kepribadian.getFont().isBold()) { 
            pn_kepribadian.setBackground(new Color(255,252,251)); 
            pn_line8.setBackground(new Color(255,252,251)); 
        }
    }//GEN-LAST:event_btn_kepribadianMouseExited

    private void pn_kepribadianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_kepribadianMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pn_kepribadianMouseClicked

    private void btn_aturanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_aturanMouseClicked
        resetAllMenu();
    setActive(pn_aturan, pn_line10, btn_aturan);
    showPanel(panelAturan, "Data Aturan");
    }//GEN-LAST:event_btn_aturanMouseClicked

    private void btn_aturanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_aturanMouseEntered
        if (!btn_aturan.getFont().isBold()) { 
        pn_aturan.setBackground(new Color(247,246,246)); 
        pn_line10.setBackground(new Color(0,102,153)); 
    }
    }//GEN-LAST:event_btn_aturanMouseEntered

    private void btn_aturanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_aturanMouseExited
        if (!btn_aturan.getFont().isBold()) { 
        pn_aturan.setBackground(new Color(255,252,251)); 
        pn_line10.setBackground(new Color(255,252,251)); 
    }
    }//GEN-LAST:event_btn_aturanMouseExited

    private void pn_aturanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_aturanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pn_aturanMouseClicked
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(menuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new menuUtama().setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_aturan;
    private javax.swing.JLabel btn_dashboard;
    private javax.swing.JLabel btn_gejala;
    private javax.swing.JLabel btn_kepribadian;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JLabel btn_riwayat;
    private javax.swing.JLabel btn_siswa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_dirimu;
    private javax.swing.JLabel lb_logo;
    private javax.swing.JLabel logodas;
    private javax.swing.JLabel logologout;
    private javax.swing.JLabel logorule;
    private javax.swing.JLabel logorule1;
    private javax.swing.JLabel logorule2;
    private javax.swing.JLabel logorule3;
    private javax.swing.JLabel logosiswa;
    private javax.swing.JPanel pn_aturan;
    private javax.swing.JPanel pn_dasar;
    private javax.swing.JPanel pn_dashboard;
    private javax.swing.JPanel pn_datasiswa;
    private javax.swing.JPanel pn_gejala;
    private javax.swing.JPanel pn_kanan;
    private javax.swing.JPanel pn_kepribadian;
    private javax.swing.JPanel pn_kiri;
    private javax.swing.JPanel pn_line;
    private javax.swing.JPanel pn_line1;
    private javax.swing.JPanel pn_line10;
    private javax.swing.JPanel pn_line5;
    private javax.swing.JPanel pn_line6;
    private javax.swing.JPanel pn_line7;
    private javax.swing.JPanel pn_line8;
    private javax.swing.JPanel pn_logout;
    private javax.swing.JPanel pn_riwayat;
    private javax.swing.JPanel pn_utama;
    // End of variables declaration//GEN-END:variables
}
