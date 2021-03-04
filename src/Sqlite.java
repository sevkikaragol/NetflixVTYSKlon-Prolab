
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sun.security.rsa.RSACore;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Sqlite {
    private Statement statement=null;
    private Connection conn=null;
    private String url="jdbc:sqlite";
    private String dbName=":DB/netflix.db";
    private String driver="org.sqlite.JDBC";
    
    float average;

    
 
    public int oturumAc(String kullanici_eposta,String password){
        
       String sorgu = "select * from USERS where USER_EMAIL='"
               +kullanici_eposta+"'"+"and USER_PASSWORD='"+
               password+"'";

      try {
          statement =conn.createStatement();
          ResultSet rs=null;

          rs=statement.executeQuery(sorgu);
          while (rs.next()) {
              return 1;

          }

      } catch (Exception e) {
          System.out.println("Basarisiz");
      }

      return 0;
        
    }
    
    
    
    
    
  public int kontrolEt1(String kullaniciAdi) //kayit kullanici adi kontrol
  {
      
      String sorgu = "select * from USERS where USER_NAME='"+kullaniciAdi+"'";
      
      try {
          statement =conn.createStatement();
          ResultSet rs=null;
          
          rs=statement.executeQuery(sorgu);
          while (rs.next()) {
              return 0;
              
          }
          
      } catch (Exception e) {
          System.out.println("Basarisiz");
      }
      
      return 1;
      
  }
  
  
  
  
  public int kontrolEt2(String mail)  //kayit mail kontrol
  {
      
      String sorgu = "select * from USERS where USER_EMAIL='"+mail+"'";
      
      try {
          statement =conn.createStatement();
          ResultSet rs=null;
          
          rs=statement.executeQuery(sorgu);
          while (rs.next()) {
              return 0;
              
          }
          
      } catch (Exception e) {
          System.out.println("Basarisiz");
      }
      
      return 1;
      
  }
  
  public int userIdBul(String eposta){
      
    int id = 0;  
       String sorgu = "select ID from USERS where USER_EMAIL='"+eposta+"'";
      
      try {
          statement =conn.createStatement();
          ResultSet rs=null;
          
          rs=statement.executeQuery(sorgu);
          id=rs.getInt("ID");
          
      } catch (Exception e) {
          System.out.println("Basarisiz");
      }
      
      return id;
     
  }
  
  
  
  public void kayitOl(String kullaniciAdi ,String parola ,String mail ,String dogumTarihi) throws SQLException{
        
        String sorgu = "insert into USERS(USER_NAME,USER_PASSWORD,USER_EMAIL,USER_BIRTHDATE) values(?,?,?,?)";
        System.out.println("kullanici eklendi");
        try {
            PreparedStatement preparedStatement = (PreparedStatement)conn.prepareStatement(sorgu);
            
            preparedStatement.setString(1,kullaniciAdi);
            preparedStatement.setString(2,parola);
            preparedStatement.setString(3,mail);
            preparedStatement.setString(4,dogumTarihi);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Sqlite.class.getName()).log(Level.SEVERE, null,ex);
           
        }
        finally{
                 dbKapat();
        }
    }
  
  
  
    public ArrayList onerilenEkle(String tur1,String tur2,String tur3){
        
     ArrayList<Integer> programId=new ArrayList<>();
     ArrayList<String> turler= new ArrayList<>();
        turler.add(tur1);
        turler.add(tur2);
        turler.add(tur3);
        
     ResultSet rs=null;
        for (int i = 0; i <3; i++) {
            String sorgu="select * from PROGRAMS where ID in (select PROGRAM_ID"
                   + " from PROGRAM_TUR where TUR_ID= (select ID from TUR where"
                   + " TUR_NAME = '"+turler.get(i)+"'))"
                   + "order by PROGRAM_PUAN desc limit 2";
            try {
          statement =conn.createStatement();
          rs=statement.executeQuery(sorgu);
          while (rs.next()) {
             programId.add(rs.getInt("ID"));
             
          }
            } catch (Exception e) {
                System.out.println("Basarisiz ID alma islemi"); 
            }
            
        
       
   }
        
        return programId;
   }
    
    
    
    public ArrayList programAdlari(ArrayList program_id){
       
        ArrayList<String> programAdlari= new ArrayList<>();
        
        for(int i=0;i<program_id.size();i++){
        String sorgu="select PROGRAM_NAME from PROGRAMS where id="
                +program_id.get(i);
        try {
          ResultSet rs=null;
          statement =conn.createStatement();
          rs=statement.executeQuery(sorgu);
          programAdlari.add(rs.getString("PROGRAM_NAME"));

          
      } catch (Exception e) {
          System.out.println("Basarisiz...(Program adi bulunamadi)");
      }
        
        
    }
        
        return programAdlari;
    }
    
    public ArrayList programAdiBul(String aranan){
        
    ArrayList<String> adlar= new  ArrayList<>();
     /*
       String sorgu = "SELECT DISTINCT PROGRAMS.PROGRAM_NAME FROM "
            + "PROGRAM_TUR,PROGRAMS,TUR WHERE ( TUR_NAME = '"+aranan+"'"
            + " AND TUR.ID =PROGRAM_TUR.TUR_ID  AND  PROGRAM_TUR.PROGRAM_ID = "
            + "PROGRAMS.ID ) OR ( PROGRAMS.PROGRAM_NAME = '"+aranan+"')";
      */
    String sorgu = "SELECT DISTINCT PROGRAMS.PROGRAM_NAME FROM "
            + "PROGRAM_TUR,PROGRAMS,TUR WHERE ( TUR_NAME LIKE '%"+aranan+"%'"
            + " AND TUR.ID =PROGRAM_TUR.TUR_ID  AND  PROGRAM_TUR.PROGRAM_ID = "
            + "PROGRAMS.ID ) OR ( PROGRAMS.PROGRAM_NAME LIKE '%"+aranan+"%')";
      try {
          statement =conn.createStatement();
          ResultSet rs=null;
          
          rs=statement.executeQuery(sorgu);
           while (rs.next()) {
             
             adlar.add(rs.getString("PROGRAM_NAME"));
             
          }
          
      } catch (Exception e) {
          System.out.println("Basarisiz program adi bulma işlemi");
      }
      
    
        return adlar;
    }
    
    public ResultSet programBilgileri(String name){
        
          String sorgu ="SELECT * FROM PROGRAMS WHERE "
                  + "PROGRAM_NAME = '"+name+"'";
      ResultSet rs=null;
      try {
          statement =conn.createStatement();
          
          
          rs=statement.executeQuery(sorgu);
          
          
      } catch (Exception e) {
          System.out.println("program bilgisi bulma basarisiz oldu!");
      }
      
        return rs ;
    }
    
    
    
    public ResultSet izlemeBilgi(int kullanici_id,int program_id){
        
      String sorgu= "SELECT * FROM PROGRAM_USER WHERE "
              + "USER_ID = '"+kullanici_id+"'AND PROGRAM_ID = '"+program_id+"'";
      
      ResultSet rs;
      try {
          statement =conn.createStatement();
          rs=statement.executeQuery(sorgu);
            while (rs.next()) {
             return rs;
             
          }
         
          
      } catch (Exception e) {
          System.out.println("izleme bilgi bulma basarisiz oldu!");
      }
      
        return null ;
    }
    
    
    public void programKullaniciGuncelle(int tercih,int user_id,int program_id
            ,int gecenZaman,int secilenBolum,int verilenPuanTut){
        //tercih=1 ise insert,tercih=2 ise update islemi yapilir
        
        
        if(tercih==1){
            //ekleme islemi
        String sorgu = "insert into PROGRAM_USER(USER_ID,PROGRAM_ID,"
                + "MONITORING_DATE,MONITORING_TIME,EPISODE,POINT) values(?,?,?,?,?,?)";
        
       
        try {
            PreparedStatement preparedStatement = (PreparedStatement)conn.prepareStatement(sorgu);
            
            preparedStatement.setString(1,String.valueOf(user_id));
            preparedStatement.setString(2,String.valueOf(program_id));
            preparedStatement.setString(3,tarihBul());
            preparedStatement.setString(4,String.valueOf(gecenZaman));
            preparedStatement.setString(5,String.valueOf(secilenBolum));
            preparedStatement.setString(6,String.valueOf(verilenPuanTut));
            preparedStatement.executeUpdate();
            System.out.println("izleme etkinligi eklendi");
            
        } catch (SQLException ex) {
              System.out.println("izleme etkinligi eklenemedi");
           
        }
      
        
        
        
        
        
        }else if(tercih==2){
            
                 //guncelleme islemi
        String sorgu = "UPDATE PROGRAM_USER SET MONITORING_DATE=?,"
      + "MONITORING_TIME=?,EPISODE=?,POINT=? WHERE USER_ID=? AND PROGRAM_ID=?";
        
       
        try {
            PreparedStatement preparedStatement = (PreparedStatement)conn.prepareStatement(sorgu);
            
            preparedStatement.setString(1,tarihBul());
            preparedStatement.setString(2,String.valueOf(gecenZaman));
            preparedStatement.setString(3,String.valueOf(secilenBolum));
            preparedStatement.setString(4,String.valueOf(verilenPuanTut));
            preparedStatement.setString(5,String.valueOf(user_id));
            preparedStatement.setString(6,String.valueOf(program_id));
            preparedStatement.executeUpdate();
            
            System.out.println("izleme etkinligi guncellendi");
            
        } catch (SQLException ex) {
              System.out.println("izleme etkinligi guncellenemedi");
            
        }
        }
      //ortalama puan bulma  
          String sorgu2 = "SELECT AVG(POINT) as PUAN FROM PROGRAM_USER WHERE "
     + "PROGRAM_USER.PROGRAM_ID='"+program_id+"'GROUP BY PROGRAM_USER.PROGRAM_ID";

      try {
          statement =conn.createStatement();
          
          ResultSet rs2=statement.executeQuery(sorgu2);
          
          average =rs2.getFloat("PUAN");
                  
          System.out.println(average);
         

      } catch (Exception e) {
          System.out.println("Basarisiz PUAN BULMA");
      }
      
      
      //ortalama puanı degistirme 
              String sorgu3 = "UPDATE PROGRAMS SET PROGRAM_PUAN=? WHERE ID=?";
        
       
        try {
            PreparedStatement preparedStatement = (PreparedStatement)conn.prepareStatement(sorgu3);
            
            preparedStatement.setString(1,String.valueOf(average));
            preparedStatement.setString(2,String.valueOf(program_id));
            
            preparedStatement.executeUpdate();
            
            System.out.println("ortalama puan guncellendi");
            
        } catch (SQLException ex) {
              System.out.println("ortalama puan guncellenemedi");
            
        }
      
      
            
        
        
        
        
    }
        
    
    
     public String tarihBul(){
        
         Date objDate = new Date();
         String strDateFormat = "yyyy-MM-dd";
         SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
         
  
         String tarih=objSDF.format(objDate).toString();
         //System.out.println("tarih "+tarih);
        
       return tarih;
    }
    
    
    
    
    
    
    
    
    public void dbKapat(){
        try {
            conn.close();
            System.out.println("veritabani kapandi");
        } catch (SQLException ex) {
            System.out.println("veritabani kapanamadi");
        }
        
    }
    
 
    
    public Sqlite() {
    
     
    
          try {
        Class.forName(driver).newInstance();
        conn=DriverManager.getConnection(url+dbName);
             System.out.println("Veritabanı baglantisi basarili");
    } catch (Exception ex) {
        Logger.getLogger(Sqlite.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("Veritabanı baglantisi basarisiz");
    }                  
      
          
          
    }
    
   
    
    public static void main(String[] args) {
       // Sqlite sqlite = new Sqlite();
        
        AnaEkran ekran=new AnaEkran();
        ekran.setVisible(true);
        
    }
    
}