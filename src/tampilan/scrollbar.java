package tampilan;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class scrollbar extends BasicScrollBarUI {

    private final int radius = 10;

    @Override
    protected void configureScrollBarColors() {
        thumbColor = new Color(120,170,200);
        trackColor = new Color(245,245,245);
    }

   
    // tombol panah atas / kiri
@Override
protected JButton createDecreaseButton(int orientation) {
    JButton button = new JButton("▲");
    button.setFont(new Font("Arial", Font.BOLD, 12));
    button.setForeground(new Color(120,170,200));
    button.setBorder(BorderFactory.createEmptyBorder());
    button.setBackground(Color.WHITE);
    button.setFocusPainted(false);
    button.setPreferredSize(new Dimension(18,18)); // ukuran tombol
    return button;
}

// tombol panah bawah / kanan
@Override
protected JButton createIncreaseButton(int orientation) {
    JButton button = new JButton("▼");
    button.setFont(new Font("Arial", Font.BOLD, 12));
    button.setForeground(new Color(120,170,200));
    button.setBorder(BorderFactory.createEmptyBorder());
    button.setBackground(Color.WHITE);
    button.setFocusPainted(false);
    button.setPreferredSize(new Dimension(18,18)); // ukuran tombol
    return button;
}

    // Track
    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(trackColor);
        g2.fillRoundRect(r.x, r.y, r.width, r.height, radius, radius);
    }

    // Thumb
    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (isThumbRollover()) {
            g2.setColor(new Color(90,150,190));
        } else {
            g2.setColor(thumbColor);
        }

        int arc = 10;
        int margin = 2;

        g2.fillRoundRect(
                r.x + margin,
                r.y + margin,
                r.width - margin * 2,
                r.height - margin * 2,
                arc,
                arc
        );
    }
}