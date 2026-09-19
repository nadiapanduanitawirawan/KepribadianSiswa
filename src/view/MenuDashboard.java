package view;
 
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import tampilan.scrollbar;
 
public class MenuDashboard extends javax.swing.JPanel {
 
    private int halamanSaatIni = 1;
    private int totalData = 0;
    private int dataPerhalaman = 10;
    private int totalPages = 1;
 
    private JTable tabelSiswa;
    private JScrollPane scrollPane;
    private JComboBox<String> comboFilter;
    private JLabel lblTotal;
    private JButton btnSebelumnya, btnSelanjutnya;
 
    // FIX #1: flag anti-trigger filterData() saat placeholder search di-set ulang programatik
    private boolean isUpdatingPlaceholder = false;
 
    public MenuDashboard() {
        initComponents();
 
        jbl_riwayat.setBackground(new Color(255, 252, 251));
        jScrollPane1.getViewport().setBackground(new Color(255, 252, 251));
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane1.getVerticalScrollBar().setUI(new scrollbar());
        jScrollPane1.getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(10);
        jbl_riwayat.setFillsViewportHeight(false);
 
        setupComboBox();
        loadDataDashboard();
        loadData();
        setupSearch();
    }
 
    private void setupComboBox() {
        cbx_data.removeAllItems();
        cbx_data.addItem("10");
        cbx_data.addItem("25");
        cbx_data.addItem("50");
        cbx_data.addItem("100");
        cbx_data.setSelectedItem("10");
        dataPerhalaman = 10;
    }
 
    public void loadDataDashboard() {
        lb_angka.setText(getTotal("regissiswa"));
        lb_angka7.setText(getTotal("kepribadian"));
        lb_angka6.setText(getTotal("gejalaa"));
        lb_angka8.setText(getTotal("hasil_identifikasi"));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDas = new javax.swing.JPanel();
        carSiswa = new custom.panelcustom();
        lb_siswa = new javax.swing.JLabel();
        lb_angka = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        carCiri = new custom.panelcustom();
        lb_gejala = new javax.swing.JLabel();
        lb_angka6 = new javax.swing.JLabel();
        logociri = new javax.swing.JLabel();
        carKp = new custom.panelcustom();
        lb_kp = new javax.swing.JLabel();
        lb_angka7 = new javax.swing.JLabel();
        logokp = new javax.swing.JLabel();
        carRiwayat = new custom.panelcustom();
        lb_riwayat = new javax.swing.JLabel();
        lb_angka8 = new javax.swing.JLabel();
        logoriwayat = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_first = new javax.swing.JButton();
        btn_before = new javax.swing.JButton();
        cbx_data = new javax.swing.JComboBox<>();
        btn_next = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_cari = new custom.TextFieldRounded();
        jScrollPane1 = new javax.swing.JScrollPane();
        jbl_riwayat = new custom.JTableCustom();

        setBackground(new java.awt.Color(255, 252, 251));
        setPreferredSize(new java.awt.Dimension(1050, 668));
        setLayout(new java.awt.CardLayout());

        panelDas.setBackground(new java.awt.Color(255, 252, 251));
        panelDas.setPreferredSize(new java.awt.Dimension(1033, 612));

        carSiswa.setBackground(new java.awt.Color(243, 243, 243));
        carSiswa.setRoundButtomLeft(30);
        carSiswa.setRoundButtomRight(30);
        carSiswa.setRoundTopLeft(30);
        carSiswa.setRoundTopRight(30);

        lb_siswa.setBackground(new java.awt.Color(78, 147, 181));
        lb_siswa.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lb_siswa.setForeground(new java.awt.Color(78, 147, 181));
        lb_siswa.setText("DATA SISWA");

        lb_angka.setBackground(new java.awt.Color(78, 147, 181));
        lb_angka.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lb_angka.setForeground(new java.awt.Color(78, 147, 181));
        lb_angka.setText("0");
        lb_angka.setAlignmentY(0.0F);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Customer.png"))); // NOI18N

        javax.swing.GroupLayout carSiswaLayout = new javax.swing.GroupLayout(carSiswa);
        carSiswa.setLayout(carSiswaLayout);
        carSiswaLayout.setHorizontalGroup(
            carSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carSiswaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(carSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carSiswaLayout.createSequentialGroup()
                        .addComponent(lb_siswa)
                        .addGap(76, 76, 76))
                    .addGroup(carSiswaLayout.createSequentialGroup()
                        .addComponent(lb_angka)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        carSiswaLayout.setVerticalGroup(
            carSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carSiswaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lb_siswa)
                .addGap(10, 10, 10)
                .addGroup(carSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_angka)
                    .addComponent(jLabel7))
                .addGap(16, 16, 16))
        );

        carCiri.setBackground(new java.awt.Color(243, 243, 243));
        carCiri.setRoundButtomLeft(30);
        carCiri.setRoundButtomRight(30);
        carCiri.setRoundTopLeft(30);
        carCiri.setRoundTopRight(30);

        lb_gejala.setBackground(new java.awt.Color(78, 147, 181));
        lb_gejala.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lb_gejala.setForeground(new java.awt.Color(78, 147, 181));
        lb_gejala.setText("DATA GEJALA");

        lb_angka6.setBackground(new java.awt.Color(78, 147, 181));
        lb_angka6.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lb_angka6.setForeground(new java.awt.Color(78, 147, 181));
        lb_angka6.setText("0");
        lb_angka6.setAlignmentY(0.0F);

        logociri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List.png"))); // NOI18N

        javax.swing.GroupLayout carCiriLayout = new javax.swing.GroupLayout(carCiri);
        carCiri.setLayout(carCiriLayout);
        carCiriLayout.setHorizontalGroup(
            carCiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carCiriLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(carCiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_gejala)
                    .addGroup(carCiriLayout.createSequentialGroup()
                        .addComponent(lb_angka6)
                        .addGap(102, 102, 102)
                        .addComponent(logociri)))
                .addGap(25, 25, 25))
        );
        carCiriLayout.setVerticalGroup(
            carCiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carCiriLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lb_gejala)
                .addGap(10, 10, 10)
                .addGroup(carCiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_angka6)
                    .addComponent(logociri))
                .addGap(16, 16, 16))
        );

        carKp.setBackground(new java.awt.Color(243, 243, 243));
        carKp.setRoundButtomLeft(30);
        carKp.setRoundButtomRight(30);
        carKp.setRoundTopLeft(30);
        carKp.setRoundTopRight(30);

        lb_kp.setBackground(new java.awt.Color(78, 147, 181));
        lb_kp.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lb_kp.setForeground(new java.awt.Color(78, 147, 181));
        lb_kp.setText("DATA KEPRIBADIAN");

        lb_angka7.setBackground(new java.awt.Color(78, 147, 181));
        lb_angka7.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lb_angka7.setForeground(new java.awt.Color(78, 147, 181));
        lb_angka7.setText("0");
        lb_angka7.setAlignmentY(0.0F);

        logokp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List.png"))); // NOI18N

        javax.swing.GroupLayout carKpLayout = new javax.swing.GroupLayout(carKp);
        carKp.setLayout(carKpLayout);
        carKpLayout.setHorizontalGroup(
            carKpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carKpLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(carKpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_kp)
                    .addGroup(carKpLayout.createSequentialGroup()
                        .addComponent(lb_angka7)
                        .addGap(102, 102, 102)
                        .addComponent(logokp)))
                .addGap(25, 25, 25))
        );
        carKpLayout.setVerticalGroup(
            carKpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carKpLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lb_kp)
                .addGap(10, 10, 10)
                .addGroup(carKpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_angka7)
                    .addComponent(logokp))
                .addGap(16, 16, 16))
        );

        carRiwayat.setBackground(new java.awt.Color(243, 243, 243));
        carRiwayat.setRoundButtomLeft(30);
        carRiwayat.setRoundButtomRight(30);
        carRiwayat.setRoundTopLeft(30);
        carRiwayat.setRoundTopRight(30);

        lb_riwayat.setBackground(new java.awt.Color(78, 147, 181));
        lb_riwayat.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lb_riwayat.setForeground(new java.awt.Color(78, 147, 181));
        lb_riwayat.setText("JUMLAH RIWAYAT");

        lb_angka8.setBackground(new java.awt.Color(78, 147, 181));
        lb_angka8.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lb_angka8.setForeground(new java.awt.Color(78, 147, 181));
        lb_angka8.setText("0");
        lb_angka8.setAlignmentY(0.0F);

        logoriwayat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Shortlist.png"))); // NOI18N

        javax.swing.GroupLayout carRiwayatLayout = new javax.swing.GroupLayout(carRiwayat);
        carRiwayat.setLayout(carRiwayatLayout);
        carRiwayatLayout.setHorizontalGroup(
            carRiwayatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carRiwayatLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(carRiwayatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_riwayat)
                    .addGroup(carRiwayatLayout.createSequentialGroup()
                        .addComponent(lb_angka8)
                        .addGap(102, 102, 102)
                        .addComponent(logoriwayat)))
                .addGap(25, 25, 25))
        );
        carRiwayatLayout.setVerticalGroup(
            carRiwayatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carRiwayatLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lb_riwayat)
                .addGap(10, 10, 10)
                .addGroup(carRiwayatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_angka8)
                    .addComponent(logoriwayat))
                .addGap(16, 16, 16))
        );

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(78, 147, 181));
        jLabel1.setText("Riwayat Pengguna");

        btn_first.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btn_first.setText("First Page");
        btn_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstActionPerformed(evt);
            }
        });

        btn_before.setText("<");
        btn_before.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_beforeActionPerformed(evt);
            }
        });

        cbx_data.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbx_data.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_dataActionPerformed(evt);
            }
        });

        btn_next.setText(">");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_last.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btn_last.setText("Last Page");
        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("Halaman of Total Halaman");

        txt_cari.setForeground(new java.awt.Color(153, 153, 153));
        txt_cari.setText("Search...");
        txt_cari.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt_cari.setSelectionColor(new java.awt.Color(204, 204, 204));
        txt_cari.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cariFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cariFocusLost(evt);
            }
        });

        jbl_riwayat.setForeground(new java.awt.Color(204, 204, 204));
        jbl_riwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIS", "Nama Lengkap", "Kelas", "Hasil Identifikasi"
            }
        ));
        jbl_riwayat.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jbl_riwayat.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jbl_riwayat.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jbl_riwayat);

        javax.swing.GroupLayout panelDasLayout = new javax.swing.GroupLayout(panelDas);
        panelDas.setLayout(panelDasLayout);
        panelDasLayout.setHorizontalGroup(
            panelDasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDasLayout.createSequentialGroup()
                .addGroup(panelDasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDasLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelDasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDasLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(532, 532, 532)
                                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1))
                            .addGroup(panelDasLayout.createSequentialGroup()
                                .addComponent(carSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(carCiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(carKp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(carRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelDasLayout.createSequentialGroup()
                        .addGap(441, 441, 441)
                        .addComponent(jLabel2))
                    .addGroup(panelDasLayout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(btn_first)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_before, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_next)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_last)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        panelDasLayout.setVerticalGroup(
            panelDasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelDasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(carRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carKp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carCiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(panelDasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addGroup(panelDasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_first, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_before, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        add(panelDas, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
        halamanSaatIni = 1;
        loadData();
    }//GEN-LAST:event_btn_firstActionPerformed

    private void btn_beforeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_beforeActionPerformed
        if (halamanSaatIni > 1) {
            halamanSaatIni--;
            loadData();
        }
    }//GEN-LAST:event_btn_beforeActionPerformed

    private void cbx_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_dataActionPerformed
        Object selected = cbx_data.getSelectedItem();
        if (selected == null) return;
 
        try {
            dataPerhalaman = Integer.parseInt(selected.toString());
            halamanSaatIni = 1;
            loadData();
        } catch (NumberFormatException ex) {
            System.out.println("Pilihan tidak valid: " + selected);
        }
    }//GEN-LAST:event_cbx_dataActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        System.out.println("[NEXT] halamanSaatIni=" + halamanSaatIni + " totalPages=" + totalPages);
        if (halamanSaatIni < totalPages) {
            halamanSaatIni++;
            loadData();
        }
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        halamanSaatIni = totalPages;
        loadData();
    }//GEN-LAST:event_btn_lastActionPerformed

    private void txt_cariFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cariFocusGained
        String cari = txt_cari.getText();
    if (cari.equals("Search...")) {
        isUpdatingPlaceholder = true;
        txt_cari.setText("");
        isUpdatingPlaceholder = false;
    }
    }//GEN-LAST:event_txt_cariFocusGained

    private void txt_cariFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cariFocusLost
        String cari = txt_cari.getText();
    if (cari.equals("") || cari.equals("Search...")) {
        isUpdatingPlaceholder = true;
        txt_cari.setText("Search...");
        isUpdatingPlaceholder = false;
        }
    }//GEN-LAST:event_txt_cariFocusLost

    private MenuDashboard dashboard;
 
    private String getTotal(String tabel) {
        String total = "0";
        try (java.sql.Connection conn = koneksi.koneksi.getConnection()) {
            if (conn == null) {
                System.out.println("Koneksi gagal!");
                return "0";
            }
            String sql = "SELECT COUNT(*) FROM `" + tabel + "`";
            try (java.sql.Statement st = conn.createStatement();
                 java.sql.ResultSet rs = st.executeQuery(sql)) {
                if (rs.next()) {
                    total = String.valueOf(rs.getInt(1));
                }
            }
        } catch (Exception e) {
            System.out.println("Error tabel: " + tabel + " | Pesan: " + e.getMessage());
            e.printStackTrace();
        }
        return total;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_before;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private custom.panelcustom carCiri;
    private custom.panelcustom carKp;
    private custom.panelcustom carRiwayat;
    private custom.panelcustom carSiswa;
    private javax.swing.JComboBox<String> cbx_data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private custom.JTableCustom jbl_riwayat;
    private javax.swing.JLabel lb_angka;
    private javax.swing.JLabel lb_angka6;
    private javax.swing.JLabel lb_angka7;
    private javax.swing.JLabel lb_angka8;
    private javax.swing.JLabel lb_gejala;
    private javax.swing.JLabel lb_kp;
    private javax.swing.JLabel lb_riwayat;
    private javax.swing.JLabel lb_siswa;
    private javax.swing.JLabel logociri;
    private javax.swing.JLabel logokp;
    private javax.swing.JLabel logoriwayat;
    private javax.swing.JPanel panelDas;
    private custom.TextFieldRounded txt_cari;
    // End of variables declaration//GEN-END:variables

private void loadData() {
    try (java.sql.Connection conn = koneksi.koneksi.getConnection()) {
        if (conn == null) return;
        String keyword = txt_cari.getText();
        if (keyword.equals("Search...")) keyword = "";
        String countSql =
            "SELECT COUNT(*) FROM hasil_identifikasi h " +
            "JOIN regissiswa s ON s.nisn = h.nisn " +
            "WHERE s.nama_siswa LIKE ? " +
            "OR s.nisn LIKE ? " +
            "OR s.kelas LIKE ?";
        try (java.sql.PreparedStatement pstCount = conn.prepareStatement(countSql)) {
            pstCount.setString(1, "%" + keyword + "%");
            pstCount.setString(2, "%" + keyword + "%");
            pstCount.setString(3, "%" + keyword + "%");
            try (java.sql.ResultSet rsCount = pstCount.executeQuery()) {
                if (rsCount.next()) totalData = rsCount.getInt(1);
            }
        }
        totalPages = (int) Math.ceil((double) totalData / dataPerhalaman);
        if (totalPages == 0) totalPages = 1;
        if (halamanSaatIni > totalPages) halamanSaatIni = totalPages;
        if (halamanSaatIni < 1) halamanSaatIni = 1;
        int offset = (halamanSaatIni - 1) * dataPerhalaman;
        String sql =
            "SELECT s.nisn, s.nama_siswa, s.kelas, h.kepribadian " +
            "FROM hasil_identifikasi h " +
            "JOIN regissiswa s ON s.nisn = h.nisn " +
            "WHERE s.nama_siswa LIKE ? " +
            "OR s.nisn LIKE ? " +
            "OR s.kelas LIKE ? " +
            "ORDER BY s.kelas ASC, s.nama_siswa ASC " +
            "LIMIT ? OFFSET ?";
        try (java.sql.PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, "%" + keyword + "%");
            pst.setString(2, "%" + keyword + "%");
            pst.setString(3, "%" + keyword + "%");
            pst.setInt(4, dataPerhalaman);
            pst.setInt(5, offset);
            try (java.sql.ResultSet rs = pst.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) jbl_riwayat.getModel();
                model.setRowCount(0);
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getString("nisn"),
                        rs.getString("nama_siswa"),
                        rs.getString("kelas"),
                    capitalize(rs.getString("kepribadian"))
                });
                }
                System.out.println("[LOAD] halaman=" + halamanSaatIni + " offset=" + offset
                        + " baris didapat=" + model.getRowCount() + " totalData=" + totalData);
            }
        }
        DefaultTableModel model = (DefaultTableModel) jbl_riwayat.getModel();
        model.fireTableDataChanged();
        applyRenderer();
        jbl_riwayat.revalidate();
        jbl_riwayat.repaint();
        jScrollPane1.revalidate();
        jScrollPane1.repaint();
        jLabel2.setText("Halaman " + halamanSaatIni + " dari " + totalPages);
        btn_first.setEnabled(halamanSaatIni > 1);
        btn_before.setEnabled(halamanSaatIni > 1);
        btn_next.setEnabled(halamanSaatIni < totalPages);
        btn_last.setEnabled(halamanSaatIni < totalPages);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private String capitalize(String text) {
    if (text == null || text.isEmpty()) return text;
    return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
}
 
    private void setupSearch() {
        txt_cari.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { if (!isUpdatingPlaceholder) filterData(); }
 
            @Override
            public void removeUpdate(DocumentEvent e) { if (!isUpdatingPlaceholder) filterData(); }
 
            @Override
            public void changedUpdate(DocumentEvent e) { if (!isUpdatingPlaceholder) filterData(); }
        });
    }
 
private void filterData() {
    String keyword = txt_cari.getText().trim();
    if (keyword.equals("") || keyword.equalsIgnoreCase("search...")) {
        halamanSaatIni = 1;
        loadData();
        return;
    }
    String keywordLower = keyword.toLowerCase();
    try (java.sql.Connection conn = koneksi.koneksi.getConnection()) {
        String sql =
            "SELECT s.nisn, s.nama_siswa, s.kelas, h.kepribadian " +
            "FROM hasil_identifikasi h " +
            "JOIN regissiswa s ON s.nisn = h.nisn " +
            "WHERE LOWER(s.nisn) LIKE ? " +
            "OR LOWER(s.nama_siswa) LIKE ? " +
            "OR LOWER(s.kelas) LIKE ? " +
            "OR LOWER(h.kepribadian) LIKE ? " +
            "ORDER BY s.kelas ASC, s.nama_siswa ASC";
        try (java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {
            String param = "%" + keywordLower + "%";
            ps.setString(1, param);
            ps.setString(2, param);
            ps.setString(3, param);
            ps.setString(4, param);
            try (java.sql.ResultSet rs = ps.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) jbl_riwayat.getModel();
                model.setRowCount(0);
                int jumlahHasil = 0;
                while (rs.next()) {
                    jumlahHasil++;
                    model.addRow(new Object[]{
                        rs.getString("nisn"),
                        rs.getString("nama_siswa"),
                        rs.getString("kelas"),
                        rs.getString("kepribadian")
                    });
                }
                model.fireTableDataChanged();
                jLabel2.setText("Ditemukan " + jumlahHasil + " data untuk \"" + keyword + "\"");
            }
        }
        applyRenderer();
        jbl_riwayat.revalidate();
        jbl_riwayat.repaint();
    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Gagal mencari data: " + e.getMessage());
    }
}
 
    private void applyRenderer() {
        javax.swing.table.DefaultTableCellRenderer centerRenderer =
            new javax.swing.table.DefaultTableCellRenderer() {
                @Override
                public java.awt.Component getTableCellRendererComponent(
                        JTable table, Object value, boolean isSelected,
                        boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    setHorizontalAlignment(javax.swing.JLabel.CENTER);
                    setBorder(null);
                    if (isSelected) {
                        setForeground(new java.awt.Color(15, 89, 140));
                        setBackground(new java.awt.Color(204, 204, 204));
                    } else {
                        setForeground(new java.awt.Color(102, 102, 102));
                        setBackground(row % 2 == 0 ? java.awt.Color.WHITE : new java.awt.Color(245, 245, 245));
                    }
                    return this;
                }
            };
 
        for (int i = 0; i < jbl_riwayat.getColumnCount(); i++) {
            jbl_riwayat.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
 
    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame("Menu Dashboard");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new MenuDashboard());
        frame.setVisible(true);
    }
}