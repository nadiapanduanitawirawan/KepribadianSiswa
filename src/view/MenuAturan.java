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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class MenuAturan extends javax.swing.JPanel {
 
    private int halamanSaatIni = 1;
    private int totalData      = 0;
    private int dataPerhalaman = 10;
    private int totalPages     = 1;
    private int selectedRow = -1;
    private String idSedangDiedit = null;
 
    public MenuAturan() {
    initComponents();

    cbx_kepribadian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
        "KP001 - Introvert",
        "KP002 - Cenderung Introvert",
        "KP003 - Ambivert",
        "KP004 - Cenderung Ekstrovert",
        "KP005 - Ekstrovert"
    }));
    cbx_kepribadian1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
        "KP001 - Introvert",
        "KP002 - Cenderung Introvert",
        "KP003 - Ambivert",
        "KP004 - Cenderung Ekstrovert",
        "KP005 - Ekstrovert"
    }));
    
    jScrollPane1.getVerticalScrollBar().setUI(new scrollbar());
    jScrollPane1.getHorizontalScrollBar().setUnitIncrement(20);

    cbx_idgejala.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        int index = cbx_idgejala.getSelectedIndex();

        if (index >= 0 && index < cbx_gejala.getItemCount()) {
            cbx_gejala.setSelectedIndex(index);
        }
    }
});

cbx_idgejala1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        int index = cbx_idgejala1.getSelectedIndex();

        if (index >= 0 && index < cbx_gejala1.getItemCount()) {
            cbx_gejala1.setSelectedIndex(index);
        }
    }
});
    setupComboBox();
    loadIdAturan();
    loadComboGejala();
    setupSearch();
    loadData();
}
    private void loadIdAturan(){

    cbx_idaturan.removeAllItems();

    try{

        Connection conn = koneksi.getConnection();

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(
        "SELECT MAX(id_aturan)+1 AS id FROM aturan");

        if(rs.next()){

            cbx_idaturan.addItem(rs.getString("id"));

        }

    }catch(Exception e){

        JOptionPane.showMessageDialog(this,e.getMessage());

    }

}
   private void loadComboGejala() {

    cbx_idgejala.removeAllItems();
    cbx_gejala.removeAllItems();

    cbx_idgejala1.removeAllItems();
    cbx_gejala1.removeAllItems();

    try {
        Connection conn = koneksi.getConnection();
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(
            "SELECT id_gejala,nama_gejala FROM gejalaa ORDER BY id_gejala");

        while(rs.next()){

            cbx_idgejala.addItem(rs.getString("id_gejala"));
            cbx_gejala.addItem(rs.getString("nama_gejala"));

            cbx_idgejala1.addItem(rs.getString("id_gejala"));
            cbx_gejala1.addItem(rs.getString("nama_gejala"));
        }

    } catch(Exception e){
        e.printStackTrace();
    }
}


// TAMBAHKAN DI BAWAH INI
public void refreshData() {
    loadComboGejala();
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
            String sql = "SELECT id_aturan, kode_kp, id_gejala FROM aturan "
                       + "WHERE LOWER(id_aturan) LIKE ? OR LOWER(kode_kp) LIKE ? OR LOWER(id_gejala) LIKE ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                String param = "%" + keyword + "%";
                ps.setString(1, param);
                ps.setString(2, param);
                ps.setString(3, param);
                try (ResultSet rs = ps.executeQuery()) {
                    DefaultTableModel model = (DefaultTableModel) jbl_gejala.getModel();
                    model.setRowCount(0);
                    while (rs.next()) {
                        model.addRow(new Object[]{
                            rs.getString("id_aturan"),
                            rs.getString("kode_kp"),
                            rs.getString("id_gejala")
                        });
                    }
                }
            }
            applyRenderer();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal mencari data: " + e.getMessage());
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
        for (int i = 0; i < jbl_gejala.getColumnCount(); i++) {
            jbl_gejala.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        panelaturan = new javax.swing.JPanel();
        btn_batal = new custom.JButtonCustom();
        btn_tambah = new custom.JButtonCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        jbl_gejala = new custom.JTableCustom();
        btn_hapus = new custom.JButtonCustom();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_cari1 = new custom.TextFieldRounded();
        btn_first = new javax.swing.JButton();
        btn_before = new javax.swing.JButton();
        cbx_data = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btn_next = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        btn_batal1 = new custom.JButtonCustom();
        panelAdd = new javax.swing.JPanel();
        btn_batal2 = new custom.JButtonCustom();
        btn_simpan = new custom.JButtonCustom();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_kepribadian = new javax.swing.JLabel();
        cbx_kepribadian = new javax.swing.JComboBox<>();
        lbl_kepribadian1 = new javax.swing.JLabel();
        lbl_kepribadian2 = new javax.swing.JLabel();
        cbx_gejala = new javax.swing.JComboBox<>();
        cbx_idgejala = new javax.swing.JComboBox<>();
        cbx_idaturan = new javax.swing.JComboBox<>();
        panelEdit = new javax.swing.JPanel();
        btn_batal3 = new custom.JButtonCustom();
        btn_simpan1 = new custom.JButtonCustom();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_kepribadian3 = new javax.swing.JLabel();
        cbx_kepribadian1 = new javax.swing.JComboBox<>();
        lbl_kepribadian4 = new javax.swing.JLabel();
        lbl_kepribadian5 = new javax.swing.JLabel();
        cbx_gejala1 = new javax.swing.JComboBox<>();
        cbx_idgejala1 = new javax.swing.JComboBox<>();
        cbx_idaturan1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 252, 251));
        setPreferredSize(new java.awt.Dimension(1050, 668));
        setLayout(new java.awt.CardLayout());

        panelMain.setBackground(new java.awt.Color(255, 252, 251));
        panelMain.setPreferredSize(new java.awt.Dimension(1050, 668));
        panelMain.setLayout(new java.awt.CardLayout());

        panelaturan.setBackground(new java.awt.Color(255, 252, 251));
        panelaturan.setPreferredSize(new java.awt.Dimension(1050, 668));

        btn_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit2.png"))); // NOI18N
        btn_batal.setText("EDIT");
        btn_batal.setFillClick(new java.awt.Color(153, 153, 153));
        btn_batal.setFillOriginal(new java.awt.Color(155, 154, 154));
        btn_batal.setFillOver(new java.awt.Color(217, 217, 217));
        btn_batal.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
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
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Aturan", "Kode_kp", "Id Gejala"
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
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rules Book.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(78, 147, 181));
        jLabel1.setText("DAFTAR ATURAN");

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

        btn_batal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rollback.png"))); // NOI18N
        btn_batal1.setText("BATAL");
        btn_batal1.setFillClick(new java.awt.Color(102, 102, 102));
        btn_batal1.setFillOriginal(new java.awt.Color(51, 51, 51));
        btn_batal1.setFillOver(new java.awt.Color(0, 0, 0));
        btn_batal1.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btn_batal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batal1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelaturanLayout = new javax.swing.GroupLayout(panelaturan);
        panelaturan.setLayout(panelaturanLayout);
        panelaturanLayout.setHorizontalGroup(
            panelaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelaturanLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
                    .addGroup(panelaturanLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelaturanLayout.createSequentialGroup()
                        .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_batal1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_cari1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
            .addGroup(panelaturanLayout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(btn_first)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(panelaturanLayout.createSequentialGroup()
                        .addComponent(btn_before, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_next)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_last)))
                .addGap(320, 320, 320))
        );
        panelaturanLayout.setVerticalGroup(
            panelaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelaturanLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addGroup(panelaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cari1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_first, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_before, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        panelMain.add(panelaturan, "card2");

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
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rules Book.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(78, 147, 181));
        jLabel2.setText("TAMBAH DATA ATURAN");

        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Id Aturan");

        lbl_kepribadian.setForeground(new java.awt.Color(153, 153, 153));
        lbl_kepribadian.setText("Id Gejala");

        cbx_kepribadian.setBackground(new java.awt.Color(78, 147, 181));
        cbx_kepribadian.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        cbx_kepribadian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Introvert", "Ekstrovert" }));

        lbl_kepribadian1.setForeground(new java.awt.Color(153, 153, 153));
        lbl_kepribadian1.setText("Kepribadian");

        lbl_kepribadian2.setForeground(new java.awt.Color(153, 153, 153));
        lbl_kepribadian2.setText("Gejala");

        cbx_gejala.setBackground(new java.awt.Color(78, 147, 181));
        cbx_gejala.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        cbx_gejala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Introvert", "Ekstrovert" }));

        cbx_idgejala.setBackground(new java.awt.Color(78, 147, 181));
        cbx_idgejala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbx_idaturan.setBackground(new java.awt.Color(78, 147, 181));
        cbx_idaturan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_kepribadian)
                            .addComponent(lbl_kepribadian2)
                            .addComponent(jLabel5)
                            .addComponent(lbl_kepribadian1)
                            .addComponent(cbx_kepribadian, 0, 289, Short.MAX_VALUE)
                            .addComponent(cbx_gejala, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbx_idaturan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbx_idgejala, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(62, 733, Short.MAX_VALUE))
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
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(cbx_idaturan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lbl_kepribadian)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_idgejala, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lbl_kepribadian2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_gejala, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lbl_kepribadian1)
                .addGap(18, 18, 18)
                .addComponent(cbx_kepribadian, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
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

        jLabel6.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(78, 147, 181));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rules Book.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(78, 147, 181));
        jLabel8.setText("EDIT DATA ATURAN");

        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Id Aturan");

        lbl_kepribadian3.setForeground(new java.awt.Color(153, 153, 153));
        lbl_kepribadian3.setText("Id Gejala");

        cbx_kepribadian1.setBackground(new java.awt.Color(78, 147, 181));
        cbx_kepribadian1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        cbx_kepribadian1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Introvert", "Ekstrovert" }));

        lbl_kepribadian4.setForeground(new java.awt.Color(153, 153, 153));
        lbl_kepribadian4.setText("Kepribadian");

        lbl_kepribadian5.setForeground(new java.awt.Color(153, 153, 153));
        lbl_kepribadian5.setText("Gejala");

        cbx_gejala1.setBackground(new java.awt.Color(78, 147, 181));
        cbx_gejala1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        cbx_gejala1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Introvert", "Ekstrovert" }));

        cbx_idgejala1.setBackground(new java.awt.Color(78, 147, 181));
        cbx_idgejala1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbx_idaturan1.setBackground(new java.awt.Color(78, 147, 181));
        cbx_idaturan1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8))
                            .addGroup(panelEditLayout.createSequentialGroup()
                                .addComponent(btn_simpan1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_batal3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelEditLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(panelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_kepribadian3)
                            .addComponent(lbl_kepribadian5)
                            .addComponent(jLabel9)
                            .addComponent(lbl_kepribadian4)
                            .addComponent(cbx_kepribadian1, 0, 289, Short.MAX_VALUE)
                            .addComponent(cbx_gejala1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbx_idaturan1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbx_idgejala1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(62, 733, Short.MAX_VALUE))
        );
        panelEditLayout.setVerticalGroup(
            panelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(33, 33, 33)
                .addGroup(panelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_batal3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_simpan1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(cbx_idaturan1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lbl_kepribadian3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_idgejala1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lbl_kepribadian5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_gejala1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lbl_kepribadian4)
                .addGap(18, 18, 18)
                .addComponent(cbx_kepribadian1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
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
        String idAturan = jbl_gejala.getValueAt(selectedRow, 0).toString();
        String kodeKp    = jbl_gejala.getValueAt(selectedRow, 1).toString();
 
        int confirm = JOptionPane.showConfirmDialog(this,
            "Hapus aturan \"" + kodeKp + "\" (" + idAturan + ")?\nData tidak bisa dikembalikan.",
            "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm != JOptionPane.YES_OPTION) return;
 
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pst = conn.prepareStatement("DELETE FROM aturan WHERE id_aturan = ?")) {
            pst.setString(1, idAturan);
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
        loadComboGejala();   // Refresh gejala terbaru
    loadIdAturan();      // Refresh ID aturan

    panelMain.removeAll();
    panelMain.add(panelAdd);
    panelMain.repaint();
    panelMain.revalidate();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
    try {
        Connection conn = koneksi.getConnection();

        String idGejala = cbx_idgejala.getSelectedItem().toString();
        String kodeKP = cbx_kepribadian.getSelectedItem().toString().split(" - ")[0];

        String sql = "INSERT INTO aturan(kode_kp, id_gejala) VALUES(?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, kodeKP);
        ps.setString(2, idGejala);
        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Data berhasil disimpan");

        loadIdAturan();
        loadData();
        clearAddForm();

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void clearAddForm(){

    if(cbx_idaturan.getItemCount()>0)
        cbx_idaturan.setSelectedIndex(0);

    if(cbx_idgejala.getItemCount()>0)
        cbx_idgejala.setSelectedIndex(0);

    if(cbx_gejala.getItemCount()>0)
        cbx_gejala.setSelectedIndex(0);

    cbx_kepribadian.setSelectedIndex(0);

}
    private void btn_batal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal2ActionPerformed
        panelMain.removeAll();
        panelMain.add(panelaturan);
        panelMain.repaint();
        panelMain.revalidate();
    }//GEN-LAST:event_btn_batal2ActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
    int viewRow = jbl_gejala.getSelectedRow();

    if (viewRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data aturan yang ingin diedit terlebih dahulu.");
        return;
    }

    selectedRow = viewRow;

    String idAturan = jbl_gejala.getValueAt(viewRow, 0).toString();
    String kodeKp    = jbl_gejala.getValueAt(viewRow, 1).toString();
    String idGejala  = jbl_gejala.getValueAt(viewRow, 2).toString();

    idSedangDiedit = idAturan;

    loadComboGejala(); // pastikan combo gejala1 terisi lengkap sebelum di-set

    cbx_idaturan1.removeAllItems();
    cbx_idaturan1.addItem(idAturan);
    cbx_idaturan1.setSelectedItem(idAturan);

    cbx_idgejala1.setSelectedItem(idGejala);

    // Sinkronkan nama gejala berdasarkan index id_gejala yang dipilih
    int idx = cbx_idgejala1.getSelectedIndex();
    if (idx >= 0 && idx < cbx_gejala1.getItemCount()) {
        cbx_gejala1.setSelectedIndex(idx);
    }

    for (int i = 0; i < cbx_kepribadian1.getItemCount(); i++) {
    String item = cbx_kepribadian1.getItemAt(i);
    if (item.startsWith(kodeKp)) {
        cbx_kepribadian1.setSelectedIndex(i);
        break;
    }
}

    panelMain.removeAll();
    panelMain.add(panelEdit);
    panelMain.repaint();
    panelMain.revalidate();
    }//GEN-LAST:event_btn_batalActionPerformed

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

    private void btn_batal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal1ActionPerformed
        jbl_gejala.clearSelection();
        selectedRow = -1;
        idSedangDiedit = null;

        filterData();
    }//GEN-LAST:event_btn_batal1ActionPerformed

    private void btn_batal3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal3ActionPerformed
    idSedangDiedit = null;
    selectedRow = -1;
    jbl_gejala.clearSelection();

    panelMain.removeAll();
    panelMain.add(panelaturan);
    panelMain.repaint();
    panelMain.revalidate();
    }//GEN-LAST:event_btn_batal3ActionPerformed

    private void btn_simpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan1ActionPerformed
        if (idSedangDiedit == null) {
        JOptionPane.showMessageDialog(this, "Tidak ada data yang sedang diedit.");
        return;
    }

    String kodeKP = cbx_kepribadian1.getSelectedItem().toString().split(" - ")[0];
    String idGejala = cbx_idgejala1.getSelectedItem().toString();

    try (Connection conn = koneksi.getConnection();
         PreparedStatement pst = conn.prepareStatement(
                 "UPDATE aturan SET kode_kp=?, id_gejala=? WHERE id_aturan=?")) {

        pst.setString(1, kodeKP);
        pst.setString(2, idGejala);
        pst.setString(3, idSedangDiedit);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data berhasil diperbarui.");

        idSedangDiedit = null;
        selectedRow = -1;

        loadData();

        panelMain.removeAll();
        panelMain.add(panelaturan);
        panelMain.repaint();
        panelMain.revalidate();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Gagal mengubah : " + e.getMessage());
    }

    }//GEN-LAST:event_btn_simpan1ActionPerformed
    
    private MenuAturan dashboard;
 
    private String getTotalGejala() {
        String total = "0";
        try (Connection conn = koneksi.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM aturan")) {
            if (rs.next()) total = String.valueOf(rs.getInt(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom.JButtonCustom btn_batal;
    private custom.JButtonCustom btn_batal1;
    private custom.JButtonCustom btn_batal2;
    private custom.JButtonCustom btn_batal3;
    private javax.swing.JButton btn_before;
    private javax.swing.JButton btn_first;
    private custom.JButtonCustom btn_hapus;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private custom.JButtonCustom btn_simpan;
    private custom.JButtonCustom btn_simpan1;
    private custom.JButtonCustom btn_tambah;
    private javax.swing.JComboBox<String> cbx_data;
    private javax.swing.JComboBox<String> cbx_gejala;
    private javax.swing.JComboBox<String> cbx_gejala1;
    private javax.swing.JComboBox<String> cbx_idaturan;
    private javax.swing.JComboBox<String> cbx_idaturan1;
    private javax.swing.JComboBox<String> cbx_idgejala;
    private javax.swing.JComboBox<String> cbx_idgejala1;
    private javax.swing.JComboBox<String> cbx_kepribadian;
    private javax.swing.JComboBox<String> cbx_kepribadian1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private custom.JTableCustom jbl_gejala;
    private javax.swing.JLabel lbl_kepribadian;
    private javax.swing.JLabel lbl_kepribadian1;
    private javax.swing.JLabel lbl_kepribadian2;
    private javax.swing.JLabel lbl_kepribadian3;
    private javax.swing.JLabel lbl_kepribadian4;
    private javax.swing.JLabel lbl_kepribadian5;
    private javax.swing.JPanel panelAdd;
    private javax.swing.JPanel panelEdit;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelaturan;
    private custom.TextFieldRounded txt_cari1;
    // End of variables declaration//GEN-END:variables

private void loadData() {
        try (Connection conn = koneksi.getConnection()) {
            totalData  = Integer.parseInt(getTotalGejala());
            totalPages = (int) Math.ceil((double) totalData / dataPerhalaman);
            if (totalPages == 0) totalPages = 1;
            if (halamanSaatIni > totalPages) halamanSaatIni = totalPages;
            if (halamanSaatIni < 1) halamanSaatIni = 1;
 
            int offset = (halamanSaatIni - 1) * dataPerhalaman;
            String sql =
            "SELECT id_aturan, kode_kp, id_gejala FROM aturan LIMIT ? OFFSET ?";
 
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, dataPerhalaman);
                ps.setInt(2, offset);
                try (ResultSet rs = ps.executeQuery()) {
                    DefaultTableModel model = (DefaultTableModel) jbl_gejala.getModel();
                    model.setRowCount(0);
                    while (rs.next()) {
                        model.addRow(new Object[]{
                            rs.getString("id_aturan"),
                            rs.getString("kode_kp"),
                            rs.getString("id_gejala")
                        });
                    }
                }
            }
            jLabel7.setText("Halaman " + halamanSaatIni + " dari " + totalPages);
            btn_first.setEnabled(halamanSaatIni > 1);
            btn_before.setEnabled(halamanSaatIni > 1);
            btn_next.setEnabled(halamanSaatIni < totalPages);
            btn_last.setEnabled(halamanSaatIni < totalPages);
            applyRenderer();
 
        } catch (Exception e) {
            e.printStackTrace();
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
        frame.setContentPane(new MenuAturan());
        frame.setVisible(true);
    }
}