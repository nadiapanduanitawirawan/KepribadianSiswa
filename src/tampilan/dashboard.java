package tampilan;

import main.login;
import java.awt.Font;

public class dashboard extends javax.swing.JFrame {
private javax.swing.JLabel menuAktif = null;

private void bukaForm(javax.swing.JFrame form){
    form.setLocationRelativeTo(null);
    form.setVisible(true);
    this.dispose(); 
}

private void resetMenu() {
    lbl_beranda.setFont(new java.awt.Font("Roboto", java.awt.Font.PLAIN, 12));
    lbl_jk.setFont(new java.awt.Font("Roboto", java.awt.Font.PLAIN, 12));
    lbl_login.setFont(new java.awt.Font("Roboto", java.awt.Font.PLAIN, 12));
}

private void setActive(javax.swing.JLabel menu) {
    resetMenu();
    menu.setFont(new Font("Roboto", Font.BOLD, 14));
    menuAktif = menu;
}
    public dashboard() {
    initComponents();
    setActive(lbl_beranda);
    
    // Di dalam initComponents():
    jPanel3.setBounds(0, 0, 1022, 60);
    jPanel2.setBounds(0, 60, 1022, 696);
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        lbl_beranda = new javax.swing.JLabel();
        lbl_login = new javax.swing.JLabel();
        lbl_jk = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_mulai = new custom.JButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(78, 147, 181));
        jPanel3.setLayout(null);

        lbl_beranda.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbl_beranda.setForeground(new java.awt.Color(255, 255, 255));
        lbl_beranda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_beranda.setText("Beranda");
        lbl_beranda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_berandaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_berandaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_berandaMouseExited(evt);
            }
        });
        jPanel3.add(lbl_beranda);
        lbl_beranda.setBounds(630, 20, 90, 22);

        lbl_login.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbl_login.setForeground(new java.awt.Color(255, 255, 255));
        lbl_login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_login.setText("Admin");
        lbl_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_loginMouseClicked(evt);
            }
        });
        jPanel3.add(lbl_login);
        lbl_login.setBounds(900, 20, 60, 22);

        lbl_jk.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbl_jk.setForeground(new java.awt.Color(255, 255, 255));
        lbl_jk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_jk.setText("Jenis Kepribadian");
        lbl_jk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_jkMouseClicked(evt);
            }
        });
        jPanel3.add(lbl_jk);
        lbl_jk.setBounds(740, 20, 140, 22);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 1000, 60);

        jPanel2.setBackground(new java.awt.Color(255, 252, 251));
        jPanel2.setLayout(null);

        jLabel4.setForeground(new java.awt.Color(78, 147, 181));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anak-removebg-preview.png"))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(650, 310, 350, 340);

        jLabel5.setFont(new java.awt.Font("Roboto Black", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(78, 147, 181));
        jLabel5.setText("Selamat datang!  ");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(90, 260, 440, 57);

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(78, 147, 181));
        jLabel6.setText("“Kenali dirimu, temukan keunikanmu.”");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(90, 330, 310, 22);

        btn_mulai.setText("Yuk Mulai");
        btn_mulai.setFillClick(new java.awt.Color(70, 127, 156));
        btn_mulai.setFillOriginal(new java.awt.Color(78, 147, 181));
        btn_mulai.setFillOver(new java.awt.Color(117, 171, 197));
        btn_mulai.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        btn_mulai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mulaiActionPerformed(evt);
            }
        });
        jPanel2.add(btn_mulai);
        btn_mulai.setBounds(90, 410, 400, 60);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 50, 1000, 650);

        setSize(new java.awt.Dimension(1022, 756));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void btn_mulaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mulaiActionPerformed
        bukaForm(new loginsiswa());
    }//GEN-LAST:event_btn_mulaiActionPerformed

    private void lbl_jkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_jkMouseClicked
        setActive(lbl_jk);
        jenis jk = new jenis();
        jk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_jkMouseClicked

    private void lbl_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_loginMouseClicked
        setActive(lbl_login);
        login lg = new login();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_loginMouseClicked

    private void lbl_berandaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_berandaMouseExited

    }//GEN-LAST:event_lbl_berandaMouseExited

    private void lbl_berandaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_berandaMouseEntered

    }//GEN-LAST:event_lbl_berandaMouseEntered

    private void lbl_berandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_berandaMouseClicked
        setActive(lbl_beranda);
        dashboard beranda = new dashboard();
        beranda.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_berandaMouseClicked

    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom.JButtonCustom btn_mulai;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_beranda;
    private javax.swing.JLabel lbl_jk;
    private javax.swing.JLabel lbl_login;
    // End of variables declaration//GEN-END:variables
}