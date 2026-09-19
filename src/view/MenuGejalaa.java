package view;
 
import custom.JButtonCustom;
import custom.JTableCustom;
import custom.TextFieldRounded;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import tampilan.scrollbar;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
 
public class MenuGejalaa extends javax.swing.JPanel {
 
    private int halamanSaatIni = 1;
    private int totalData      = 0;
    private int dataPerhalaman = 10;
    private int totalPages     = 1;
    private int selectedRow = -1;
    private String idSedangDiedit = null;
 
   public MenuGejalaa() {
    initComponents();
    setupComboBox();
    setupSearch();
 
    // Scrollbar custom
    jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    jScrollPane1.getVerticalScrollBar().setUI(new scrollbar());
    jScrollPane1.getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));
    jScrollPane1.getVerticalScrollBar().setUnitIncrement(10);
 
    // Generate otomatis ID Gejala
    populateIdGejalaOptions();
 
    loadData();
}
 
    private void setupSearch() {
        txt_cari1.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterData();
            }
        });
    }
 
    private void filterData() {
 
    String keyword = txt_cari1.getText().trim().toLowerCase();
 
    if (keyword.isEmpty() || keyword.equals("search...")) {
        loadData();
        return;
    }
 
    try (Connection conn = koneksi.getConnection()) {
 
        String sql =
            "SELECT id_gejala, nama_gejala " +
            "FROM gejalaa " +
            "WHERE LOWER(id_gejala) LIKE ? " +
            "OR LOWER(nama_gejala) LIKE ? " +
            "ORDER BY CAST(SUBSTRING(id_gejala,3) AS UNSIGNED)";
 
        PreparedStatement ps = conn.prepareStatement(sql);
 
        String cari = "%" + keyword + "%";
 
        ps.setString(1, cari);
        ps.setString(2, cari);
 
        ResultSet rs = ps.executeQuery();
 
        DefaultTableModel model = (DefaultTableModel) jbl_gejala.getModel();
        model.setRowCount(0);
 
        while (rs.next()) {
 
            model.addRow(new Object[]{
                rs.getString("id_gejala"),
                rs.getString("nama_gejala")
            });
 
        }
 
        applyRenderer();
 
    } catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(this,
            "Gagal : " + e.getMessage());
}
}
 
    /**
     * Renderer khusus untuk kolom "Nama Gejala" agar teks panjang
     * tidak terpotong, melainkan wrap ke baris baru (multi-line)
     * dan tinggi baris menyesuaikan otomatis.
     */
    private class WrapCellRenderer extends JTextArea implements javax.swing.table.TableCellRenderer {
        public WrapCellRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
            setOpaque(true);
            setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 10, 6, 10));
        }
 
        @Override
        public java.awt.Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
 
            setText(value == null ? "" : value.toString());
            setFont(table.getFont());
 
            if (isSelected) {
                setForeground(new Color(15, 89, 140));
                setBackground(new Color(204, 204, 204));
            } else {
                setForeground(new Color(102, 102, 102));
                setBackground(row % 2 == 0 ? Color.WHITE : new Color(245, 245, 245));
            }
 
            // Hitung ulang lebar kolom saat ini untuk menentukan tinggi baris yang pas
            int colWidth = table.getColumnModel().getColumn(column).getWidth();
            if (colWidth > 0) {
                setSize(colWidth, Short.MAX_VALUE);
                int preferredHeight = Math.max(getPreferredSize().height + 4, 32);
                if (table.getRowHeight(row) != preferredHeight) {
                    // Set di luar cycle render supaya tidak infinite loop repaint
                    javax.swing.SwingUtilities.invokeLater(() -> {
                        if (row < table.getRowCount()) {
                            table.setRowHeight(row, preferredHeight);
                        }
                    });
                }
            }
 
            return this;
        }
    }
 
    /**
     * Mengatur lebar kolom tabel: Id Gejala dibuat sempit dan tetap,
     * Nama Gejala melebar mengisi sisa ruang yang tersedia.
     */
    private void applyColumnWidths() {
        if (jbl_gejala.getColumnCount() < 2) return;
 
        jbl_gejala.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
 
        javax.swing.table.TableColumn colId = jbl_gejala.getColumnModel().getColumn(0);
        colId.setPreferredWidth(110);
        colId.setMinWidth(90);
        colId.setMaxWidth(140);
 
        javax.swing.table.TableColumn colNama = jbl_gejala.getColumnModel().getColumn(1);
        colNama.setPreferredWidth(880);
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
 
        // Kolom 0 (Id Gejala) tetap rata tengah, sederhana
        jbl_gejala.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
 
        // Kolom 1 (Nama Gejala) pakai renderer wrap supaya teks panjang tidak terpotong
        jbl_gejala.getColumnModel().getColumn(1).setCellRenderer(new WrapCellRenderer());
 
        applyColumnWidths();
    }
 
   private String generateIdGejala() {
 
    String prefix = "KG";
    int nomor = 1;
 
    try (Connection conn = koneksi.getConnection()) {
 
        String sql =
            "SELECT id_gejala FROM gejalaa " +
            "ORDER BY CAST(SUBSTRING(id_gejala, 3) AS UNSIGNED) DESC LIMIT 1";
 
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                nomor = Integer.parseInt(rs.getString("id_gejala").substring(2)) + 1;
            }
        }
 
        String checkSql = "SELECT COUNT(*) FROM gejalaa WHERE id_gejala = ?";
        try (PreparedStatement psCheck = conn.prepareStatement(checkSql)) {
            while (true) {
                String candidateId = String.format("%s%03d", prefix, nomor);
                psCheck.setString(1, candidateId);
                try (ResultSet rsCheck = psCheck.executeQuery()) {
                    if (rsCheck.next() && rsCheck.getInt(1) > 0) {
                        nomor++;
                    } else {
                        return candidateId;
                    }
                }
            }
        }
 
    } catch (Exception e) {
        e.printStackTrace();
    }
 
    return prefix + String.format("%03d", nomor);
}
 
   private void populateIdGejalaOptions() {
 
    String nextId = generateIdGejala();
 
    cbx_idgejala.setModel(
        new DefaultComboBoxModel<>(new String[]{nextId})
    );
 
    cbx_idgejala.setSelectedIndex(0);
    cbx_idgejala.setEnabled(false);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        panelgejala = new javax.swing.JPanel();
        btn_edit = new custom.JButtonCustom();
        btn_tambah = new custom.JButtonCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        jbl_gejala = new custom.JTableCustom();
        btn_hapus = new custom.JButtonCustom();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_printgejala = new custom.JButtonCustom();
        txt_cari1 = new custom.TextFieldRounded();
        btn_first = new javax.swing.JButton();
        btn_before = new javax.swing.JButton();
        cbx_data = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btn_next = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        btn_batal = new custom.JButtonCustom();
        panelAdd = new javax.swing.JPanel();
        btn_batal2 = new custom.JButtonCustom();
        btn_simpan = new custom.JButtonCustom();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_idgejala = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_namagejala = new custom.TextFieldRounded();
        cbx_idgejala = new javax.swing.JComboBox<>();
        panelEdit = new javax.swing.JPanel();
        btn_batal3 = new custom.JButtonCustom();
        btn_simpan1 = new custom.JButtonCustom();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_namagejala1 = new custom.TextFieldRounded();
        cbx_idgejala1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 252, 251));
        setPreferredSize(new java.awt.Dimension(1050, 668));
        setLayout(new java.awt.CardLayout());

        panelMain.setBackground(new java.awt.Color(255, 252, 251));
        panelMain.setPreferredSize(new java.awt.Dimension(1050, 668));
        panelMain.setLayout(new java.awt.CardLayout());

        panelgejala.setBackground(new java.awt.Color(255, 252, 251));
        panelgejala.setPreferredSize(new java.awt.Dimension(1050, 668));

        btn_edit.setBackground(new java.awt.Color(153, 153, 153));
        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit2.png"))); // NOI18N
        btn_edit.setText("EDIT");
        btn_edit.setFillClick(new java.awt.Color(153, 153, 153));
        btn_edit.setFillOriginal(new java.awt.Color(155, 154, 154));
        btn_edit.setFillOver(new java.awt.Color(217, 217, 217));
        btn_edit.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        btn_tambah.setText("TAMBAH");
        btn_tambah.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        jbl_gejala.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id Gejala", "Nama Gejala"
            }
        ));
        jbl_gejala.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jbl_gejala.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jbl_gejala);

        btn_hapus.setBackground(new java.awt.Color(236, 46, 46));
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete Trash.png"))); // NOI18N
        btn_hapus.setText("HAPUS");
        btn_hapus.setFillClick(new java.awt.Color(188, 31, 31));
        btn_hapus.setFillOriginal(new java.awt.Color(228, 47, 47));
        btn_hapus.setFillOver(new java.awt.Color(254, 21, 21));
        btn_hapus.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(78, 147, 181));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Shaking.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(78, 147, 181));
        jLabel1.setText("DAFTAR GEJALA");

        btn_printgejala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Print.png"))); // NOI18N
        btn_printgejala.setText("PRINT");
        btn_printgejala.setFillClick(new java.awt.Color(0, 153, 153));
        btn_printgejala.setFillOriginal(new java.awt.Color(0, 102, 102));
        btn_printgejala.setFillOver(new java.awt.Color(0, 153, 153));
        btn_printgejala.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        btn_printgejala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printgejalaActionPerformed(evt);
            }
        });

        txt_cari1.setForeground(new java.awt.Color(153, 153, 153));
        txt_cari1.setText("Search...");
        txt_cari1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt_cari1.setSelectionColor(new java.awt.Color(204, 204, 204));
        txt_cari1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cari1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cari1FocusLost(evt);
            }
        });

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

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setText("Halaman of Total Halaman");

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

        btn_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rollback.png"))); // NOI18N
        btn_batal.setText("BATAL");
        btn_batal.setFillClick(new java.awt.Color(102, 102, 102));
        btn_batal.setFillOriginal(new java.awt.Color(51, 51, 51));
        btn_batal.setFillOver(new java.awt.Color(0, 0, 0));
        btn_batal.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelgejalaLayout = new javax.swing.GroupLayout(panelgejala);
        panelgejala.setLayout(panelgejalaLayout);
        panelgejalaLayout.setHorizontalGroup(
            panelgejalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelgejalaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelgejalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelgejalaLayout.createSequentialGroup()
                        .addComponent(btn_printgejala, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(221, 221, 221)
                        .addComponent(btn_first)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelgejalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(panelgejalaLayout.createSequentialGroup()
                                .addComponent(btn_before, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_next)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_last)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelgejalaLayout.createSequentialGroup()
                        .addGroup(panelgejalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
                            .addGroup(panelgejalaLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelgejalaLayout.createSequentialGroup()
                                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_cari1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))))
        );
        panelgejalaLayout.setVerticalGroup(
            panelgejalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelgejalaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelgejalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addGroup(panelgejalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cari1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelgejalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelgejalaLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btn_printgejala, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(92, Short.MAX_VALUE))
                    .addGroup(panelgejalaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelgejalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_first, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_before, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbx_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))))
        );

        panelMain.add(panelgejala, "card2");

        panelAdd.setBackground(new java.awt.Color(255, 252, 251));
        panelAdd.setPreferredSize(new java.awt.Dimension(1050, 668));

        btn_batal2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rollback.png"))); // NOI18N
        btn_batal2.setText("BATAL");
        btn_batal2.setFillClick(new java.awt.Color(102, 102, 102));
        btn_batal2.setFillOriginal(new java.awt.Color(51, 51, 51));
        btn_batal2.setFillOver(new java.awt.Color(0, 0, 0));
        btn_batal2.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btn_batal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batal2ActionPerformed(evt);
            }
        });

        btn_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save.png"))); // NOI18N
        btn_simpan.setText("SIMPAN");
        btn_simpan.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(78, 147, 181));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Shaking.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(78, 147, 181));
        jLabel2.setText("TAMBAH DATA GEJALA");

        txt_idgejala.setForeground(new java.awt.Color(153, 153, 153));
        txt_idgejala.setText("Id Gejala");

        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Nama Gejala");

        txt_namagejala.setForeground(new java.awt.Color(153, 153, 153));
        txt_namagejala.setText("Gejala");
        txt_namagejala.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        txt_namagejala.setSelectionColor(new java.awt.Color(204, 204, 204));
        txt_namagejala.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_namagejalaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_namagejalaFocusLost(evt);
            }
        });
        txt_namagejala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namagejalaActionPerformed(evt);
            }
        });

        cbx_idgejala.setBackground(new java.awt.Color(78, 147, 181));
        cbx_idgejala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelAddLayout = new javax.swing.GroupLayout(panelAdd);
        panelAdd.setLayout(panelAddLayout);
        panelAddLayout.setHorizontalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAddLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2))
                            .addGroup(panelAddLayout.createSequentialGroup()
                                .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_batal2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_idgejala)
                            .addComponent(txt_namagejala, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(cbx_idgejala, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(711, Short.MAX_VALUE))
        );
        panelAddLayout.setVerticalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_batal2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(txt_idgejala)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbx_idgejala, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel6)
                .addGap(15, 15, 15)
                .addComponent(txt_namagejala, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        panelMain.add(panelAdd, "card2");

        panelEdit.setBackground(new java.awt.Color(255, 252, 251));
        panelEdit.setPreferredSize(new java.awt.Dimension(1050, 668));

        btn_batal3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rollback.png"))); // NOI18N
        btn_batal3.setText("BATAL");
        btn_batal3.setFillClick(new java.awt.Color(102, 102, 102));
        btn_batal3.setFillOriginal(new java.awt.Color(51, 51, 51));
        btn_batal3.setFillOver(new java.awt.Color(0, 0, 0));
        btn_batal3.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btn_batal3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batal3ActionPerformed(evt);
            }
        });

        btn_simpan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save.png"))); // NOI18N
        btn_simpan1.setText("SIMPAN");
        btn_simpan1.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btn_simpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(78, 147, 181));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Shaking.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(78, 147, 181));
        jLabel9.setText("EDIT DATA GEJALA");

        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Id Gejala");

        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("Nama Gejala");

        txt_namagejala1.setForeground(new java.awt.Color(153, 153, 153));
        txt_namagejala1.setText("Gejala");
        txt_namagejala1.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        txt_namagejala1.setSelectionColor(new java.awt.Color(204, 204, 204));
        txt_namagejala1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_namagejala1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_namagejala1FocusLost(evt);
            }
        });
        txt_namagejala1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namagejala1ActionPerformed(evt);
            }
        });

        cbx_idgejala1.setBackground(new java.awt.Color(78, 147, 181));
        cbx_idgejala1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelEditLayout = new javax.swing.GroupLayout(panelEdit);
        panelEdit.setLayout(panelEditLayout);
        panelEditLayout.setHorizontalGroup(
            panelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditLayout.createSequentialGroup()
                .addGroup(panelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelEditLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9))
                            .addGroup(panelEditLayout.createSequentialGroup()
                                .addComponent(btn_simpan1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_batal3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelEditLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(panelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(txt_namagejala1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbx_idgejala1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(541, Short.MAX_VALUE))
        );
        panelEditLayout.setVerticalGroup(
            panelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(33, 33, 33)
                .addGroup(panelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_batal3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_simpan1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(cbx_idgejala1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel11)
                .addGap(15, 15, 15)
                .addComponent(txt_namagejala1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );

        panelMain.add(panelEdit, "card2");

        add(panelMain, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        int selectedRow = jbl_gejala.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus terlebih dahulu.");
            return;
        }
        String idGejala   = jbl_gejala.getValueAt(selectedRow, 0).toString();
        String namaGejala = jbl_gejala.getValueAt(selectedRow, 1).toString();
 
        int confirm = JOptionPane.showConfirmDialog(this,
            "Hapus gejala \"" + namaGejala + "\" (" + idGejala + ")?\nData tidak bisa dikembalikan.",
            "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm != JOptionPane.YES_OPTION) return;
 
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pst = conn.prepareStatement("DELETE FROM gejalaa WHERE id_gejala = ?")) {
            pst.setString(1, idGejala);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal menghapus: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void txt_cari1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cari1FocusGained
        if (txt_cari1.getText().equals("Search...")) txt_cari1.setText("");
    }//GEN-LAST:event_txt_cari1FocusGained

    private void txt_cari1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cari1FocusLost
        String cari = txt_cari1.getText();
        if (cari.equals("") || cari.equals("Search...")) txt_cari1.setText("Search...");
    }//GEN-LAST:event_txt_cari1FocusLost

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        populateIdGejalaOptions();
        panelMain.removeAll();
        panelMain.add(panelAdd);
        panelMain.repaint();
        panelMain.revalidate();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void clearAddForm() {
        txt_namagejala.setText("Gejala");
    cbx_idgejala.setSelectedIndex(0);
    populateIdGejalaOptions();
    }
    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
    int row = jbl_gejala.getSelectedRow();

    if (row == -1) {
        JOptionPane.showMessageDialog(this,
                "Pilih data yang akan diedit terlebih dahulu!");
        return;
    }

    String id   = jbl_gejala.getValueAt(row, 0).toString();
    String nama = jbl_gejala.getValueAt(row, 1).toString();

    idSedangDiedit = id;

    cbx_idgejala1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{ id }));
    cbx_idgejala1.setSelectedIndex(0);
    cbx_idgejala1.setEnabled(true);     // <-- tetap aktif/bisa diklik
    cbx_idgejala1.setEditable(false);   // <-- tapi tidak bisa diketik manual

    txt_namagejala1.setText(nama);
    txt_namagejala1.setCaretPosition(0);

    panelMain.removeAll();
    panelMain.add(panelEdit);
    panelMain.repaint();
    panelMain.revalidate();   
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_printgejalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printgejalaActionPerformed
    try {
        Connection con = koneksi.getConnection();
 
        String jrxmlPath = "src/laporan/laporangejala.jrxml";
        String jasperPath = "src/laporan/laporangejala.jasper";
 
        net.sf.jasperreports.engine.JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);
 
        JasperPrint jprint = JasperFillManager.fillReport(
                jasperPath,
                null,
                con);
 
        JasperViewer viewer = new JasperViewer(jprint, false);
        viewer.setVisible(true);
 
    } catch (Exception e) {
        e.printStackTrace();
        Throwable akar = e;
        while (akar.getCause() != null) {
            akar = akar.getCause();
        }
        JOptionPane.showMessageDialog(this, "Gagal : " + akar.getMessage());
    }
    }//GEN-LAST:event_btn_printgejalaActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        halamanSaatIni = totalPages;
        loadData();
    }//GEN-LAST:event_btn_lastActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        if (halamanSaatIni < totalPages) {
            halamanSaatIni++;
            loadData();
        }
    }//GEN-LAST:event_btn_nextActionPerformed

    private void cbx_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_dataActionPerformed
        try {
            dataPerhalaman = Integer.parseInt(cbx_data.getSelectedItem().toString());
            halamanSaatIni = 1;
            loadData();
        } catch (NumberFormatException ex) {
            System.out.println("Pilihan tidak valid: " + cbx_data.getSelectedItem());
        }
    }//GEN-LAST:event_cbx_dataActionPerformed

    private void btn_beforeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_beforeActionPerformed
        if (halamanSaatIni > 1)
        {
            halamanSaatIni--;
            loadData();
        }
    }//GEN-LAST:event_btn_beforeActionPerformed

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
        halamanSaatIni = 1;
        loadData();
    }//GEN-LAST:event_btn_firstActionPerformed

    private void btn_batal3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal3ActionPerformed
    idSedangDiedit = null;

    panelMain.removeAll();
    panelMain.add(panelgejala);
    panelMain.repaint();
    panelMain.revalidate();
    }//GEN-LAST:event_btn_batal3ActionPerformed

    private void btn_simpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan1ActionPerformed
 
        if (idSedangDiedit == null) {
        JOptionPane.showMessageDialog(this,
                "Tidak ada data yang sedang diedit!");
        return;
    }

    String idGejala = cbx_idgejala1.getSelectedItem().toString();
    String namaGejala = txt_namagejala1.getText().trim();

    if (namaGejala.isEmpty() || namaGejala.equals("Gejala")) {
        JOptionPane.showMessageDialog(this,
                "Nama gejala tidak boleh kosong!");
        return;
    }

    try (Connection conn = koneksi.getConnection();
         PreparedStatement pst = conn.prepareStatement(
                 "UPDATE gejalaa SET nama_gejala = ? WHERE id_gejala = ?")) {

        pst.setString(1, namaGejala);
        pst.setString(2, idGejala);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data berhasil diubah!");

        idSedangDiedit = null;

        loadData();

        panelMain.removeAll();
        panelMain.add(panelgejala);
        panelMain.repaint();
        panelMain.revalidate();

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "Gagal mengubah data : " + e.getMessage());
    }
    }//GEN-LAST:event_btn_simpan1ActionPerformed

    private void txt_namagejala1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_namagejala1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namagejala1FocusGained

    private void txt_namagejala1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_namagejala1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namagejala1FocusLost

    private void txt_namagejala1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namagejala1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namagejala1ActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        jbl_gejala.clearSelection();
        selectedRow = -1;
        idSedangDiedit = null;

        filterData();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void txt_namagejalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namagejalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namagejalaActionPerformed

    private void txt_namagejalaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_namagejalaFocusLost
        String tambahjab=txt_namagejala.getText();
        if(tambahjab.equals("")||tambahjab.equals("Gejala")){
    txt_namagejala.setText("Gejala");
        }
    }//GEN-LAST:event_txt_namagejalaFocusLost

    private void txt_namagejalaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_namagejalaFocusGained
        String tambahjab=txt_namagejala.getText();
        if(tambahjab.equals("Gejala")){
    txt_namagejala.setText("");
}
    }//GEN-LAST:event_txt_namagejalaFocusGained

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed

        try {
        Connection conn = koneksi.getConnection();
        String idGejala = cbx_idgejala.getSelectedItem().toString();

        String sql1 = "INSERT INTO gejalaa(id_gejala,nama_gejala) VALUES(?,?)";
        PreparedStatement ps1 = conn.prepareStatement(sql1);
        ps1.setString(1, idGejala);
        ps1.setString(2, txt_namagejala.getText().trim());
        ps1.executeUpdate();

        JOptionPane.showMessageDialog(this,
            "Gejala berhasil disimpan. Silakan buat aturannya di menu Data Aturan.");

        populateIdGejalaOptions();
        clearAddForm();

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_batal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal2ActionPerformed
        panelMain.removeAll();
        panelMain.add(panelgejala);
        panelMain.repaint();
        panelMain.revalidate();
    }//GEN-LAST:event_btn_batal2ActionPerformed
    
    private MenuGejalaa dashboard;
 
    private String getTotalGejala() {
        String total = "0";
        try (Connection conn = koneksi.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM gejalaa")) {
            if (rs.next()) total = String.valueOf(rs.getInt(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom.JButtonCustom btn_batal;
    private custom.JButtonCustom btn_batal2;
    private custom.JButtonCustom btn_batal3;
    private javax.swing.JButton btn_before;
    private custom.JButtonCustom btn_edit;
    private javax.swing.JButton btn_first;
    private custom.JButtonCustom btn_hapus;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private custom.JButtonCustom btn_printgejala;
    private custom.JButtonCustom btn_simpan;
    private custom.JButtonCustom btn_simpan1;
    private custom.JButtonCustom btn_tambah;
    private javax.swing.JComboBox<String> cbx_data;
    private javax.swing.JComboBox<String> cbx_idgejala;
    private javax.swing.JComboBox<String> cbx_idgejala1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private custom.JTableCustom jbl_gejala;
    private javax.swing.JPanel panelAdd;
    private javax.swing.JPanel panelEdit;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelgejala;
    private custom.TextFieldRounded txt_cari1;
    private javax.swing.JLabel txt_idgejala;
    private custom.TextFieldRounded txt_namagejala;
    private custom.TextFieldRounded txt_namagejala1;
    // End of variables declaration//GEN-END:variables


private void loadData() {
 
    try (Connection conn = koneksi.getConnection()) {
 
        String sqlCount = "SELECT COUNT(*) FROM gejalaa";
 
        Statement st = conn.createStatement();
        ResultSet rsCount = st.executeQuery(sqlCount);
 
        if (rsCount.next()) {
            totalData = rsCount.getInt(1);
        }
 
        totalPages = (int) Math.ceil((double) totalData / dataPerhalaman);
 
        if (totalPages == 0) totalPages = 1;
 
        if (halamanSaatIni > totalPages)
            halamanSaatIni = totalPages;
 
        int offset = (halamanSaatIni - 1) * dataPerhalaman;
 
        String sql =
            "SELECT id_gejala, nama_gejala " +
            "FROM gejalaa " +
            "ORDER BY CAST(SUBSTRING(id_gejala,3) AS UNSIGNED) " +
            "LIMIT ? OFFSET ?";
 
        PreparedStatement ps = conn.prepareStatement(sql);
 
        ps.setInt(1, dataPerhalaman);
        ps.setInt(2, offset);
 
        ResultSet rs = ps.executeQuery();
 
        DefaultTableModel model = (DefaultTableModel) jbl_gejala.getModel();
        model.setRowCount(0);
 
        while (rs.next()) {
 
            model.addRow(new Object[]{
                rs.getString("id_gejala"),
                rs.getString("nama_gejala")
            });
 
        }
 
        jLabel7.setText("Halaman " + halamanSaatIni + " dari " + totalPages);
 
        btn_first.setEnabled(halamanSaatIni > 1);
        btn_before.setEnabled(halamanSaatIni > 1);
        btn_next.setEnabled(halamanSaatIni < totalPages);
        btn_last.setEnabled(halamanSaatIni < totalPages);
 
        applyRenderer();
 
    } catch (Exception e) {
 
        e.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "Gagal memuat data : " + e.getMessage());
 
    }
}
    private void setupComboBox() {
        cbx_data.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"10","25","50","100"}));
        dataPerhalaman = 10;
    }
 
    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame("Menu Gejala");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setSize(1050, 668);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new MenuGejalaa());
        frame.setVisible(true);
    }
}