package custom;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class JComboBoCustom<E> extends JComboBox<E> {

    public JComboBoCustom() {

        setOpaque(true);
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setFont(new Font("Tahoma", Font.PLAIN, 11));

        setBorder(new LineBorder(new Color(180, 180, 180), 1));
        setFocusable(false);

        setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                    JList<?> list,
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus) {

                JLabel lbl = (JLabel) super.getListCellRendererComponent(
                        list, value, index, isSelected, cellHasFocus);

                lbl.setOpaque(true);

                if (isSelected) {
                    lbl.setBackground(Color.WHITE);
                    lbl.setForeground(Color.BLACK);
                } else {
                    lbl.setBackground(Color.WHITE);
                    lbl.setForeground(Color.BLACK);
                }

                return lbl;
            }
        });

        setUI(new BasicComboBoxUI() {

            @Override
            protected JButton createArrowButton() {

                BasicArrowButton btn = new BasicArrowButton(
                        BasicArrowButton.SOUTH,
                        Color.WHITE,
                        Color.WHITE,
                        Color.BLACK,
                        Color.WHITE);

                btn.setBorder(BorderFactory.createEmptyBorder());
                return btn;
            }

            @Override
            public void paintCurrentValueBackground(
                    Graphics g,
                    Rectangle bounds,
                    boolean hasFocus) {

                g.setColor(Color.WHITE);
                g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.dispose();

        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        d.height = 25;
        return d;
    }
}