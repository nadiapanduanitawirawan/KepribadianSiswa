package custom;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class panelcustom extends JPanel {
    
    private int roundTopLeft = 0;
    int roundTopRight = 0;
    int roundButtomLeft = 0;
    int roundButtomRight = 0;

    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
    }

    public int getRoundTopRight() {
        return roundTopRight;
    }

    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
    }

    public int getRoundButtomLeft() {
        return roundButtomLeft;
    }

    public void setRoundButtomLeft(int roundButtomLeft) {
        this.roundButtomLeft = roundButtomLeft;
    }

    public int getRoundButtomRight() {
        return roundButtomRight;
    }

    public void setRoundButtomRight(int roundButtomRight) {
        this.roundButtomRight = roundButtomRight;
    }
    
    public panelcustom() {
        setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics graphic) {
    super.paintComponent(graphic); // penting!
    
    Graphics2D g2 = (Graphics2D) graphic.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setColor(getBackground());
    Area area = new Area(createRoundTopLeft());
    
    if(roundTopRight>0) {
        area.intersect(new Area(createRoundTopRight()));
    }
    if(roundTopLeft>0) {
        area.intersect(new Area(createRoundTopLeft()));
    }
    
    if(roundButtomRight>0) {
        area.intersect(new Area (createRoundButtomRight()));
    }
    if(roundButtomLeft>0) {
        area.intersect(new Area (createRoundButtomLeft()));
    }
    
    g2.fill(area);
    g2.dispose();
    super.paintComponent(graphic);
}
    
    private Shape createRoundTopRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX=Math.min(width, roundTopRight);
        int roundY=Math.min(height, roundTopRight);
        
        Area area = new Area (new RoundRectangle2D.Double(0,0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0,0, width - roundX / 2, width)));
        area.add(new Area(new Rectangle2D.Double(0, roundY/2, width, height - roundY / 2)));
        return area;
    }
    
    private Shape createRoundTopLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX=Math.min(width, roundTopLeft);
        int roundY=Math.min(height, roundTopLeft);
        
        Area area = new Area (new RoundRectangle2D.Double(0,0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, width)));
        area.add(new Area(new Rectangle2D.Double(0, roundY/2, width, height - roundY / 2)));
        return area;
    }
    
    private Shape createRoundButtomRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundButtomRight);
        int roundY = Math.min(height, roundButtomRight);

        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));

        return area;
    }
    
    private Shape createRoundButtomLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundButtomLeft);
        int roundY = Math.min(height, roundButtomLeft);

        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));

        return area;
        }
}
