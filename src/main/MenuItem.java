package main;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import view.MenuDashboard;

public class MenuItem extends javax.swing.JPanel {

    private static MenuItem activeMenu = null;

    private java.awt.Color defaultColor = new java.awt.Color(255, 252, 251);
    private java.awt.Color activeColor = new java.awt.Color(220, 220, 220);
    private java.awt.Color hoverColor = new java.awt.Color(240, 240, 240); 

    public ArrayList<MenuItem> getSubMenu() {
        return subMenu;
    }
    private java.awt.Font defaultFont = new java.awt.Font("Roboto", java.awt.Font.PLAIN, 16);
    private java.awt.Font boldFont = new java.awt.Font("Roboto", java.awt.Font.BOLD, 16);
    private final ArrayList<MenuItem> subMenu = new ArrayList<>();

    private ActionListener act;

    public MenuItem(Icon icon, boolean sbm, Icon iconSub, String menuName, ActionListener act, MenuItem... subMenu) {
        initComponents();
        
        lbl_menuName.setFont(defaultFont);
        lbl_icon.setIcon(icon);
        lbl_menuName.setText(menuName);
        lbl_iconSub.setIcon(iconSub);
        lbl_iconSub.setVisible(sbm);
        
        if (act != null) {
            this.act = act;
        }

        this.setSize(new Dimension(Integer.MAX_VALUE, 45));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        this.setMinimumSize(new Dimension(Integer.MAX_VALUE, 45));

        for (int i = 0; i < subMenu.length; i++) {
            this.subMenu.add(subMenu[i]);
            subMenu[i].setVisible(false);
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_menuName = new javax.swing.JLabel();
        lbl_icon = new javax.swing.JLabel();
        lbl_iconSub = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 252, 251));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        lbl_menuName.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbl_menuName.setForeground(new java.awt.Color(78, 147, 181));
        lbl_menuName.setText("MenuItem");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lbl_iconSub, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_menuName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_menuName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_iconSub, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private boolean showing = false;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if (activeMenu != null && activeMenu != this) {
        activeMenu.setBackground(activeMenu.defaultColor);
        activeMenu.lbl_menuName.setFont(activeMenu.defaultFont); 
    }

    this.setBackground(activeColor);
    this.lbl_menuName.setFont(boldFont);
    activeMenu = this;

    if (showing) {
        hideMenu();
    } else {
        showMenu();
    }

    if (act != null) {
        act.actionPerformed(null);
    }
    }//GEN-LAST:event_formMousePressed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {
        if (this != activeMenu) {
            setBackground(hoverColor);
        }
    }

    private void formMouseExited(java.awt.event.MouseEvent evt) {
        if (this != activeMenu) {
            setBackground(defaultColor);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_icon;
    private javax.swing.JLabel lbl_iconSub;
    private javax.swing.JLabel lbl_menuName;
    // End of variables declaration//GEN-END:variables

    private void hideMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = subMenu.size() - 1; i >= 0; i--) {
                    sleep();
                    subMenu.get(i).setVisible(false);
                    subMenu.get(i).hideMenu();
                }
                getParent().repaint();     
                getParent().revalidate();
                showing = false;
            }
        }).start();
    }

    private void showMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < subMenu.size(); i++) {
                    sleep();
                    subMenu.get(i).setVisible(true);
                }
                showing = true;
                getParent().repaint();  
                getParent().revalidate();
            }
        }).start();
    }

    private void sleep() {
        try {
            Thread.sleep(20);
        } catch (Exception e) {
        }
    }
}