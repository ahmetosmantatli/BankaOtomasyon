import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class kullaniciKayit   {

	
	private static String database_username="";
	private static  String database_password="";
	
	
	private static String database_name="";
	private static String database_table_name="";
	
	public JFrame frameKayit ;
	private JTextField adGiris;
	private JTextField soyadGiris;
	private JTextField kullanıcıadGiris;
	private JTextField sifreGiris;
	private JTextField bakiyeGiris;
	
	public  Connection conn =null;//veri tabanına baglantı saglar
	public  Statement stmt =null;//sorgu
	public  ResultSet rs = null;//veri tabanındakı verılerın cekılmesı
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kullaniciKayit window = new kullaniciKayit("root","","bank_database","account_info");
					window.frameKayit.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 */
	public kullaniciKayit(String database_username,String database_password,String database_name,String database_table_name) {
		
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
		initialize();
	}

	public static String getDatabase_username() {
		return database_username;
	}

	public void setDatabase_username(String database_username) {
		kullaniciKayit.database_username = database_username;
	}

	public static String getDatabase_password() {
		return database_password;
	}

	public void setDatabase_password(String database_password) {
		kullaniciKayit.database_password = database_password;
	}

	public static String getDatabase_name() {
		return database_name;
	}

	public void setDatabase_name(String database_name) {
		kullaniciKayit.database_name = database_name;
	}

	public static String getDatabase_table_name() {
		return database_table_name;
	}

	public void setDatabase_table_name(String database_table_name) {
		kullaniciKayit.database_table_name = database_table_name;
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameKayit = new JFrame();
		frameKayit.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AHMET\\Desktop\\int bankacılığı.png"));
		frameKayit.setBounds(100, 100, 450, 300);
		frameKayit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frameKayit.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adınız : ");
		lblNewLabel.setBounds(25, 36, 83, 22);
		panel.add(lblNewLabel);
		
		JLabel lblSoyadnz = new JLabel("Soyadınız :");
		lblSoyadnz.setBounds(25, 69, 83, 22);
		panel.add(lblSoyadnz);
		
		JLabel lblKullancAd = new JLabel("Kullanıcı Ad :");
		lblKullancAd.setBounds(25, 102, 83, 22);
		panel.add(lblKullancAd);
		
		JLabel lblifre = new JLabel("Şifre :");
		lblifre.setBounds(25, 135, 83, 22);
		panel.add(lblifre);
		
		JLabel lblAyrcanzBakiyeniz = new JLabel("Ayırıcağınız Bakiyeniz :");
		lblAyrcanzBakiyeniz.setBounds(23, 168, 108, 22);
		panel.add(lblAyrcanzBakiyeniz);
		
		adGiris = new JTextField();
		adGiris.setBounds(153, 37, 86, 20);
		panel.add(adGiris);
		adGiris.setColumns(10);
		
		soyadGiris = new JTextField();
		soyadGiris.setColumns(10);
		soyadGiris.setBounds(153, 70, 86, 20);
		panel.add(soyadGiris);
		
		kullanıcıadGiris = new JTextField();
		kullanıcıadGiris.setColumns(10);
		kullanıcıadGiris.setBounds(153, 103, 86, 20);
		panel.add(kullanıcıadGiris);
		
		sifreGiris = new JTextField();
		sifreGiris.setColumns(10);
		sifreGiris.setBounds(153, 136, 86, 20);
		panel.add(sifreGiris);
		
		bakiyeGiris = new JTextField();
		bakiyeGiris.setColumns(10);
		bakiyeGiris.setBounds(153, 169, 86, 20);
		panel.add(bakiyeGiris);
		
		JButton KayıtKabul = new JButton("Kayıt Ol");
		KayıtKabul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ekle();
			}
		});
		KayıtKabul.setBounds(313, 215, 89, 23);
		panel.add(KayıtKabul);
	}
	
	public void ekle() {
		
		String name,surname,username;
		int password,bakiye;
		
		password = Integer.valueOf(sifreGiris.getText());
		
		bakiye = Integer.valueOf(bakiyeGiris.getText());
		
		name = adGiris.getText();
		
		surname = soyadGiris.getText();
		
		username = kullanıcıadGiris.getText();
		
		String eklemeSorgusu = "insert into account_info (name,surname,username,password,bakiye) values('"+name+"','"+ surname +"',"
				+ "'"+username +"', '"+password+"' , '"+bakiye+"')";
				
		try {
			
			
			Statement calistir =conn.createStatement();
			calistir.execute(eklemeSorgusu);
			
			JOptionPane.showMessageDialog(null, "Kayıt Ekleme Başarılı..");
			
		}catch(SQLException e){
			
			JOptionPane.showMessageDialog(null, "Kayıt Ekleme Başarısız Lütfen Farklı Kullanıcı Adı Deneyiniz Verileri Bos Gecmeyiniz!"+e);
			System.out.println(e);
		}
	}
}
