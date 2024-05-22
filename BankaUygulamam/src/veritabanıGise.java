import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class veritabanıGise {

	 Connection conn =null;//baglantı
	 Statement stmt =null;//sorgu
	 ResultSet rs = null;//vericekme verı tabanından
	
	public static String[]veriler = new String[5]; 
	
	private static String database_username="";
	private static  String database_password="";
	private  String query="";
	
	private static String database_name="";
	private static String database_table_name="";
	
	
	public static String getDatabase_username() {
		return database_username;
	}

	public void setDatabase_username(String database_username) {
		veritabanıGise.database_username = database_username;
	}

	public static String getDatabase_password() {
		return database_password;
	}

	public void setDatabase_password(String database_password) {
		veritabanıGise.database_password = database_password;
	}

	public static String getDatabase_name() {
		return database_name;
	}

	public void setDatabase_name(String database_name) {
		veritabanıGise.database_name = database_name;
	}

	public static String getDatabase_table_name() {
		return database_table_name;
	}

	public void setDatabase_table_name(String database_table_name) {
		veritabanıGise.database_table_name = database_table_name;
	}
	
	public veritabanıGise(String database_username,String database_password,String database_name,String database_table_name) {
		
		this.setDatabase_username(database_username);
		this.setDatabase_password(database_password);
		this.setDatabase_name(database_name);
		this.setDatabase_table_name(database_table_name);
		
		//try catch ıcıne baglantı adresı yaratıcam verıtbanına baglanıcak constructor cagrıldıgında
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost/"+database_name,database_username,database_password);
			System.err.println("Görevli Bağlandı->" +database_name);
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
	
	    //görevlide komisyon miktar dıye bı oran olcak bunu gorevlı gırıcek databaseye ve hep degıstırebılcek!!
		//max 10 basamaklı bir komisyon oranı  yapıcağımız işlemden fazla miktarda komisyon miktarı olamaz!!
		//görevli gırıs yapnca kontrol ekranı yaratıyom onun ıcın butona bastıgında
	
	 public boolean access_control(String username,String password) {
			
			
			try {
				query= "select * from account_gise where username = '" +username+"'and password ='"+password+"'";
				rs = stmt.executeQuery(query);
				while(rs.next()) {
					System.out.println("Kulanici Adi :" + rs.getString("username"));
					System.out.println("Parola :" + rs.getString("password"));
					veriler[0] = rs.getString("name");
					veriler[1] = rs.getString("surname");
					veriler[2] = rs.getString("username");
					veriler[3] = rs.getString("password");
					veriler[4] = rs.getString("komisyon");
						
					return true;
					}
			}catch(SQLException e)
			{ e.printStackTrace();
			
			}
			return false;
		}
	 
	 //burda havale yapabilicek ve komisyon oranı belirliyebilicez bunları ele alıcaz komisyon orandan baslayalım
	 
	 public int komisyon_belirle (String username , String Komisyon) {
		 
		 query="update account_gise set komisyon =? where username =?"; //ikincil anahtar gorevı username
			PreparedStatement preparedStatement;
			try {
				
				preparedStatement =(PreparedStatement)  conn.prepareStatement(query);
				preparedStatement.setString(1, Komisyon);
				preparedStatement.setString(2, username);
				preparedStatement.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		 
		 return 1;
	 }
	
	
    
    
}
