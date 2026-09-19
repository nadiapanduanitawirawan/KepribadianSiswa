package custom;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTextFieldUI;

public class TextFieldRounded extends JTextField {

    private String placeholder = "Search...";
    private Color placeholderColor = Color.GRAY;

    private int round = 20;
    private int borderSize = 2;

    private Color borderColor = new Color(200, 200, 200);
    private Color focusColor = new Color(0, 120, 215);

    private boolean focused = false;

    public TextFieldRounded() {

        setUI(new BasicTextFieldUI());

        setOpaque(false);
        setBorder(new RoundedBorder(10));

        setMargin(new java.awt.Insets(5, 10, 5, 10));

        addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                focused = true;

                repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                focused = false;

                repaint();
            }
        });
    }

    public void setPlaceholder(String text) {
        this.placeholder = text;
        repaint();
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholderColor(Color color) {
        this.placeholderColor = color;
        repaint();
    }

    public void setRound(int round) {
        this.round = round;
        repaint();
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
        repaint();
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    public void setFocusColor(Color focusColor) {
        this.focusColor = focusColor;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(
                0,
                0,
                getWidth(),
                getHeight(),
                round,
                round);

        super.paintComponent(g);
        if (getText().length() == 0 && !focused) {

            g2.setColor(placeholderColor);

            g2.setFont(getFont().deriveFont(Font.ITALIC));

            int padding = 10;

            int y = ((getHeight() - g2.getFontMetrics().getHeight()) / 2)
                    + g2.getFontMetrics().getAscent();

            g2.drawString(placeholder, padding, y);
        }

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new java.awt.BasicStroke(borderSize));

            g2.setColor(borderColor);

            g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, round, round);
            g2.dispose();
    }

    private class RoundedBorder extends EmptyBorder {

        public RoundedBorder(int padding) {
            super(padding, padding, padding, padding);
        }
    }
}