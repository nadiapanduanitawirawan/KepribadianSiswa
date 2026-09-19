package custom;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class JTableCustom extends JTable {
    private int selectedRow = -1;
    
    public JTableCustom() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean blnl, int i, int il) {
                TablezHeader header = new TablezHeader(o + "");
                header.setHorizontalAlignment(JLabel.CENTER);
                return header;
            }
        });
        
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel lbl = (JLabel) super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);

        lbl.setOpaque(true);

        // Memberikan jarak dalam cell
        lbl.setBorder(new EmptyBorder(0, 10, 0, 10));

        if (isSelected) {
            lbl.setForeground(new Color(15, 89, 140));
            lbl.setBackground(Color.WHITE);
        } else {
            lbl.setForeground(new Color(102, 102, 102));
            lbl.setBackground(Color.WHITE);
        }

        return lbl;
    }
});
    
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = getSelectedRow();
                if(row == selectedRow) {
                    clearSelection();
                    selectedRow = -1;
                }else{
                    selectedRow = row;
                }
            }
        });
    }
    
    // ✅ Otomatis sesuaikan tinggi tabel dengan jumlah baris, scrollbar tidak muncul
    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return getPreferredSize();
    }
    
    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
    
    private class TablezHeader extends JLabel {
        TablezHeader(String text) {
            super(text);
            setOpaque(true);
            setBackground(Color.WHITE);
            setFont(new Font("roboto", 1, 12));
            setForeground(new Color(102, 102, 102));
            setBorder(new EmptyBorder(10, 5, 10, 5));
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(230, 230, 230));
            g.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
        }
    }
}