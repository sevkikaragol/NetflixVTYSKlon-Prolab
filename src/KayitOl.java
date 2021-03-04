
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sevkikaragol
 */
public class KayitOl extends javax.swing.JFrame {
    Sqlite baglanti2=new Sqlite();
    
    /**
     * Creates new form KayitOl
     */
    public KayitOl() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        eposta = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        tarih = new javax.swing.JTextField();
        sifre = new javax.swing.JPasswordField();
        kayitOl = new javax.swing.JLabel();
        tur1 = new javax.swing.JComboBox<>();
        tur2 = new javax.swing.JComboBox<>();
        tur3 = new javax.swing.JComboBox<>();
        seciniz = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        carpi = new javax.swing.JLabel();
        eksi = new javax.swing.JLabel();
        giriseDon = new javax.swing.JLabel();
        arkaplan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Netflix");
        setUndecorated(true);

        jPanel1.setLayout(null);
        jPanel1.add(eposta);
        eposta.setBounds(240, 440, 270, 30);

        username.setToolTipText("");
        jPanel1.add(username);
        username.setBounds(240, 400, 270, 30);
        jPanel1.add(tarih);
        tarih.setBounds(240, 520, 270, 30);
        jPanel1.add(sifre);
        sifre.setBounds(240, 480, 270, 30);

        kayitOl.setBackground(new java.awt.Color(255, 0, 0));
        kayitOl.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        kayitOl.setForeground(new java.awt.Color(255, 255, 255));
        kayitOl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kayitOl.setText("Kayıt Ol");
        kayitOl.setOpaque(true);
        kayitOl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kayitOlMouseClicked(evt);
            }
        });
        jPanel1.add(kayitOl);
        kayitOl.setBounds(435, 600, 200, 30);

        tur1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Aksiyon ve Macera", "Bilim Kurgu ve Fantastik Yapimlar", "Romantik", "Drama", "Çocuk ve Aile", "Belgesel", "Komedi", "Aksiyon", "Korku", "Bilim ve Doğa", "Gerilim", "Anime", "Reality Program", "Bilim Kurgu" }));
        jPanel1.add(tur1);
        tur1.setBounds(560, 520, 270, 30);

        tur2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Aksiyon ve Macera", "Bilim Kurgu ve Fantastik Yapimlar", "Romantik", "Drama", "Çocuk ve Aile", "Belgesel", "Komedi", "Aksiyon", "Korku", "Bilim ve Doğa", "Gerilim", "Anime", "Reality Program", "Bilim Kurgu" }));
        jPanel1.add(tur2);
        tur2.setBounds(560, 460, 270, 30);

        tur3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Aksiyon ve Macera", "Bilim Kurgu ve Fantastik Yapimlar", "Romantik", "Drama", "Çocuk ve Aile", "Belgesel", "Komedi", "Aksiyon", "Korku", "Bilim ve Doğa", "Gerilim", "Anime", "Reality Program", "Bilim Kurgu" }));
        jPanel1.add(tur3);
        tur3.setBounds(560, 400, 270, 30);

        seciniz.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        seciniz.setForeground(new java.awt.Color(255, 255, 255));
        seciniz.setText("Sevdiğiniz üç türü seçiniz");
        jPanel1.add(seciniz);
        seciniz.setBounds(560, 350, 330, 50);

        jLabel1.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kullanıcı Adı");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(100, 400, 150, 30);

        jLabel2.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("E-posta");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(150, 440, 110, 30);

        jLabel3.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Parola");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(160, 480, 120, 30);

        jLabel4.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Doğum Tarihi");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(90, 520, 150, 30);

        jLabel5.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("**Doğum tarihi örnek format : 2000-01-21");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(290, 670, 430, 40);

        carpi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carpı.png"))); // NOI18N
        carpi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carpiMouseClicked(evt);
            }
        });
        jPanel1.add(carpi);
        carpi.setBounds(970, 20, 35, 35);

        eksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eksi.png"))); // NOI18N
        eksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eksiMouseClicked(evt);
            }
        });
        jPanel1.add(eksi);
        eksi.setBounds(920, 20, 35, 35);

        giriseDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geri_butonu_v2.png"))); // NOI18N
        giriseDon.setText("jLabel1");
        giriseDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                giriseDonMouseClicked(evt);
            }
        });
        jPanel1.add(giriseDon);
        giriseDon.setBounds(20, 20, 240, 80);

        arkaplan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.png"))); // NOI18N
        arkaplan.setText("jLabel2");
        jPanel1.add(arkaplan);
        arkaplan.setBounds(0, 0, 1020, 768);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(1020, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kayitOlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kayitOlMouseClicked
       
       //kayit alanlarinin bos birakilmamasi icin kontrol kismi
        boolean k1=username.getText().equals("");
        boolean k2=eposta.getText().equals("");
        String stringPassword=new String(sifre.getPassword());
        boolean k3=stringPassword.equals("");
        boolean k4=tarih.getText().equals("");
        boolean k5=tur1.getSelectedItem().toString().equals("...");
        boolean k6=tur2.getSelectedItem().toString().equals("...");
        boolean k7=tur3.getSelectedItem().toString().equals("...");
        
        if(k1==true||k2==true||k3==true||k4==true||k5==true||k6==true||k7==true){
            
            JOptionPane uyariMesaji = new JOptionPane();
            uyariMesaji.showMessageDialog(rootPane,"Kayıt alanlarını "
                    + "boş bırakmayınız.");
            return;
            
        }
        
        
        
        
       int kontrol1=baglanti2.kontrolEt1(username.getText());
       int kontrol2=baglanti2.kontrolEt2(eposta.getText());
       

       if(kontrol1==1&&kontrol2==1){
          
           try {
               baglanti2.kayitOl(username.getText(),new String(sifre.getPassword()),
                       eposta.getText(),tarih.getText());
           } catch (SQLException ex) {
               Logger.getLogger(KayitOl.class.getName()).log(Level.SEVERE, null, ex);
           }
          
       
       
       String secim1=tur1.getSelectedItem().toString();
       String secim2=tur2.getSelectedItem().toString();
       String secim3=tur3.getSelectedItem().toString();
       
       
       FilmOnerileri nesne=new FilmOnerileri(secim1,secim2,secim3);
       this.setVisible(false); 
       nesne.setVisible(true);
        
        
        //new FilmOnerileri(secim1,secim2,secim3).setVisible(true);
           
       }
       else{
           if(kontrol1!=1){
              JOptionPane mesaj1=new JOptionPane();
              mesaj1.showMessageDialog(rootPane,"Girdiğiniz kullanıcı adı sisteme kayıtlıdır.");
           }
           if(kontrol2!=1){
              JOptionPane mesaj2=new JOptionPane();
              mesaj2.showMessageDialog(rootPane,"Girdiğiniz e-posta zaten kayıtlıdır.");
           }
           
           
       }
       
       
       
       
       
       
       
      
    }//GEN-LAST:event_kayitOlMouseClicked

    private void carpiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carpiMouseClicked
        System.exit(0);
    }//GEN-LAST:event_carpiMouseClicked

    private void eksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eksiMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_eksiMouseClicked

    private void giriseDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_giriseDonMouseClicked
       baglanti2.dbKapat();
        AnaEkran nesne=new AnaEkran();
        this.dispose();
        nesne.setVisible(true);

    }//GEN-LAST:event_giriseDonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KayitOl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KayitOl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KayitOl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KayitOl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KayitOl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arkaplan;
    private javax.swing.JLabel carpi;
    private javax.swing.JLabel eksi;
    private javax.swing.JTextField eposta;
    private javax.swing.JLabel giriseDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel kayitOl;
    private javax.swing.JLabel seciniz;
    private javax.swing.JPasswordField sifre;
    private javax.swing.JTextField tarih;
    private javax.swing.JComboBox<String> tur1;
    private javax.swing.JComboBox<String> tur2;
    private javax.swing.JComboBox<String> tur3;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
