import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class veritabanıMudur {

	
	public static Connection conn =null;//baglantı
	public static Statement stmt =null;//sorgu
	public static ResultSet rs = null;//vericekme verı tabanından
	
	static String[]veriler = new String[5]; 
	
	private static String database_username="";
	private static  String database_password="";
	private  String query="";
	
	private static String database_name="";
	private static String database_table_name="";
	
	
	public veritabanıMudur(String database_username,String database_password,String database_name,String database_table_name) 
	{
		this.setDatabase_username(database_username);
		this.setDatabase_password(database_password);
		this.setDatabase_name(database_name);
		this.setDatabase_table_name(database_table_name);
		
		//try catch ıcıne baglantı adresı yaratıcam verıtbanına baglanıcak constructor cagrıldıgında
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost/"+database_name,database_username,database_password);
			System.err.println("Müdür Bağlandı->" +database_name);
			stmt = (Statement) conn.createStatement();
			
		}
		
		catch(ClassNotFoundException e) 
		{
			System.out.println("Connector bulunamadı");
			System.out.println("Bağlantı başarısız \nClassNotFoundException");
			
		}catch(SQLException e) {
			System.err.println("Baglanti basarisiz\nSql Exception");
		}			
		
		
	}
	
	//mudur gırıs yapnca kontrol ekranı yaratıyom onun ıcın butona bastıgında
        public boolean access_control(String username,String password) {
		
		
		try {
			query= "select * from account_mudur where username = '" +username+"'and password ='"+password+"'";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println("Kulanici Adi :" + rs.getString("username"));
				System.out.println("Parola :" + rs.getString("password"));
				veriler[0] = rs.getString("name");
				veriler[1] = rs.getString("surname");
				veriler[2] = rs.getString("username");
				veriler[3] = rs.getString("password");
					
				return true;
				}
		}catch(SQLException e)
		{ e.printStackTrace();
		
		}
		return false;
	}
	
	//BURDA MUDURE EKLICEGIM TEK OZELLIGI YARATICAM ODA SU OLUCAK ISTEN KOVMA YETENEGI GISE ELEMANINI ALTER TABLE FELAN YAPCAM 
    //gıse verı tabanını once kontrol etsın eger dogru ıse ıslemı sılıp sıldıgınısoylesın eger olmazsa kullanıcı bulunamadı desın hemen    
        public void gise_sonlandir(String username) {
    		
    		
        	try {
                //buraya labelden gelcek olan username zaten varsa sorguda onu silmesi soylenıyo yoksa silemez ondan return true false calısır
                //sorguya gisedeki elemanın user namesını alcaz secicez dogrusu
                int isNotDeleted = 0;

                String query= "select count(1) from account_gise where username = '" +username + "'";
                rs = stmt.executeQuery(query);
                while(rs.next()) {
                    isNotDeleted = Integer.valueOf(rs.getString("count(1)"));
                }

                if(isNotDeleted>0) {
                    String silmekomutu = "Delete from account_gise where username = '" + username + "'";
                    stmt = conn.createStatement();
                    stmt.execute(silmekomutu);
                    JOptionPane.showConfirmDialog(null, "Kayıt Basariyla Silindi","gise tablosu ",JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showConfirmDialog(null, "Kullanıcı bulunamadı.","gise tablosu ",JOptionPane.PLAIN_MESSAGE);
                }

            }catch(SQLException e)
            { 
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Kayıt silinemedi", "gise tablosu", JOptionPane.PLAIN_MESSAGE);

            }
    	}

	public static String getDatabase_username() {
		return database_username;
	}

	public void setDatabase_username(String database_username) {
		veritabanıMudur.database_username = database_username;
	}

	public static String getDatabase_password() {
		return database_password;
	}

	public void setDatabase_password(String database_password) {
		veritabanıMudur.database_password = database_password;
	}

	public static String getDatabase_name() {
		return database_name;
	}

	public void setDatabase_name(String database_name) {
		veritabanıMudur.database_name = database_name;
	}

	public static String getDatabase_table_name() {
		return database_table_name;
	}

	public void setDatabase_table_name(String database_table_name) {
		veritabanıMudur.database_table_name = database_table_name;
	}
	//setlerı statık yapmadık gereksız yer kaplamasın dıye alanda calısırken
	
}
