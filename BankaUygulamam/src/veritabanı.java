import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class veritabanı {

	Connection conn =null;//veri tabanına baglantı saglar
	Statement stmt =null;//sorgu
	ResultSet rs = null;//veri tabanındakı verılerın cekılmesı
	
	static String[]veriler = new String[5]; //aralarina bakiyeyide ekledim artik
	
	private static String database_username="";
	private static  String database_password="";
	private  String query="";
	
	private static String database_name="";
	private static String database_table_name="";
	private static String database_bakiye="";
	
	
	
	public static String getDatabase_bakiye() {
		return database_bakiye;
	}

	public static void setDatabase_bakiye(String database_bakiye) {
		veritabanı.database_bakiye = database_bakiye;
	}

	
	
	
	public veritabanı(String database_username,String database_password,String database_name,String database_table_name)
	{
		this.setDatabase_username(database_username);
		this.setDatabase_password(database_password);
		this.setDatabase_name(database_name);
		this.setDatabase_table_name(database_table_name);
		
		
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost/"+database_name,database_username,database_password);
			System.err.println("Bağlandı->" +database_name);
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
	
	public boolean access_control(String username,String password) {
		
		
		try {
			query= "select * from account_info where username = '" +username+"'and password ='"+password+"'";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println("Kulanici Adi :" + rs.getString("username"));
				System.out.println("Parola :" + rs.getString("password"));
				veriler[0] = rs.getString("name");
				veriler[1] = rs.getString("surname");
				veriler[2] = rs.getString("username");
				veriler[3] = rs.getString("password");
				veriler[4] = rs.getString("bakiye");
				
				
				return true;
				}
		}catch(SQLException e)
		{ e.printStackTrace();
		
		}
		return false;
	}
	
	public void pass_update(String reset_username ,String new_password) { //veritabanına sorgu yolluycam kontrol amaclı
		query="update account_info set password =? where username =?";
		PreparedStatement preparedStatement;
		try {
			
			preparedStatement =(PreparedStatement)  conn.prepareStatement(query);
			preparedStatement.setString(1, new_password);
			preparedStatement.setString(2, reset_username);
			preparedStatement.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void bakiye_update(String reset_username ,String new_bakiye) { //veritabanına sorgu yolluycam kontrol amaclı
		query="update account_info set bakiye =? where username =?"; //ikincil anahtar gorevı username
		PreparedStatement preparedStatement;
		try {
			
			preparedStatement =(PreparedStatement)  conn.prepareStatement(query);
			preparedStatement.setString(1, new_bakiye);
			preparedStatement.setString(2, reset_username);
			preparedStatement.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getBakiye(String username) { //veritabanına sorgu yolluycam kontrol amaclı get bakıyeden bakıye alıyoz
		//query="select bakiye from account_info where username = '" + username +"'"; //ikincil anahtar gorevı username
		String bakiye="";
		try {
			query= "select * from account_info where username = '" +username+"'";
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				System.out.println("Kulanici Adi :" + rs.getString("username"));
				System.out.println("Parola :" + rs.getString("password"));
				veriler[0] = rs.getString("name");
				veriler[1] = rs.getString("surname");
				veriler[2] = rs.getString("username");
				veriler[3] = rs.getString("password");
				bakiye = rs.getString("bakiye"); //burda onemlı olan tek sey bu
				
				}
		}catch(SQLException e)
		{ e.printStackTrace();
		
		}
		return Integer.valueOf(bakiye);
	}
	
	public int getKomisyon() { //veritabanına sorgu yolluycam kontrol amaclı get bakıyeden bakıye alıyoz
		//query="select bakiye from account_info where username = '" + username +"'"; //ikincil anahtar gorevı username
		String komisyon="";
		try {
			query= "select * from account_gise ";
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				 
            
				komisyon = rs.getString("komisyon"); //burda onemlı olan tek sey bu
				
				}
		}catch(SQLException e)
		{ e.printStackTrace();
		
		}
		return Integer.valueOf(komisyon);
	}
	
	
	
	
	
	
	public void reset_pass(String username ,String eski_pass,String yeni_pass) {
		
		
		if(eski_pass.equals(veriler[3])) {
			pass_update(username,yeni_pass);
			JOptionPane.showMessageDialog(null, "Sifreniz Guncellendi!" , "Basarili",3);
			
			
		}
		else {
			JOptionPane.showMessageDialog(null,"Eski Sifrenizi Hatali Girdiniz" ,"Basarisiz",0);
			System.err.println("Eski Sifre Hatali!!");
		}
	}
	
	

	public static String getDatabase_username() {
		return database_username;
	}

	public void setDatabase_username(String database_username) {
		veritabanı.database_username = database_username;
	}

	public static String getDatabase_password() {
		return database_password;
	}

	public void setDatabase_password(String database_password) {
		veritabanı.database_password = database_password;
	}

	public static String getDatabase_name() {
		return database_name;
	}

	public void setDatabase_name(String database_name) {
		veritabanı.database_name = database_name;
	}

	public static String getDatabase_table_name() {
		return database_table_name;
	}

	public void setDatabase_table_name(String database_table_name) {
		veritabanı.database_table_name = database_table_name;
	}
	
	
	
}
