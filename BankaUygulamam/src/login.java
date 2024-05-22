import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class login extends veritabanı {

	public JFrame frmBanka;
	private JTextField input_username;
	private JPasswordField password_input;
    public static String HavaleGonderecekKullanici ;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmBanka.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		super("root","","bank_database","account_info"); //bakiyeler var veritabanında
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBanka = new JFrame();
		frmBanka.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AHMET\\Desktop\\int bankacılığı.png"));
		frmBanka.setTitle("Banka Uygulamam Giriş Ekranı");
		frmBanka.setBounds(100, 100, 515, 439);
		frmBanka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		frmBanka.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\AHMET\\Desktop\\int bankacılığı.png"));
		lblNewLabel.setBounds(149, 63, 181, 159);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Kullanıcı Adı");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(10, 235, 152, 40);
		panel.add(lblNewLabel_1);
		
		input_username = new JTextField();
		input_username.setBounds(172, 248, 140, 20);
		panel.add(input_username);
		input_username.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sifre");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(20, 296, 100, 40);
		panel.add(lblNewLabel_1_1);
		
		password_input = new JPasswordField();
		password_input.setBounds(172, 296, 140, 20);
		panel.add(password_input);
		
		JButton login_button = new JButton("Giriş Yap");
		login_button.setBounds(173, 339, 104, 23);
		panel.add(login_button);
		login_button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("sorgu gonderildi");
				
				HavaleGonderecekKullanici = input_username.getText();
				if(access_control(input_username.getText(),password_input.getText())==true) {
					
					JOptionPane.showMessageDialog(null,"HESAP BULUNDU : "+veriler[0] + " " +veriler[1],"BASARILI GIRIS",3);
					main_cb2 cb2 = new main_cb2();
					cb2.frame.setVisible(true);
					frmBanka.setVisible(false);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "HESAP BULUNAMADI", "BASARISIZ", 0);
				}
			}
		});
		
		
		
		JLabel lblNewLabel_2 = new JLabel("BANKA UYGULAMAM");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(149, 28, 181, 14);
		panel.add(lblNewLabel_2);
		
		
		//buralara mudur ve gıse gorvlısı butonları attım farklı panellere yolluycam farklı verı tabanları olcak
		JButton mudur_button = new JButton("Müdür Giriş");
		mudur_button.setBounds(373, 78, 100, 23);
		panel.add(mudur_button);
		
        mudur_button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("mudur girisi icin sorgu gonderildi");
				//sımdı verı tabanına baslıcam ordan mudur verı tabanını yaratıp constructorunu cagırcam burda 
				
				main_mudur m = new main_mudur();
				m.frameM.setVisible(true);
				frmBanka.setVisible(false);
				
			}
		});
		
		
		
		JButton gise_button = new JButton("Gişe Görevlisi Giriş");
		gise_button.setBounds(373, 132, 100, 23);
		panel.add(gise_button);
		
		JButton kullaniciKayitButon = new JButton("Kullanici Kayit");
		kullaniciKayitButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				kullaniciKayit m2 = new kullaniciKayit("root","","bank_database","account_info");
				m2.frameKayit.setVisible(true); //kulanıcı kayıttan sonra gırıs ıcın bu ekranı kapamadım
				
			}
		});
		kullaniciKayitButon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		kullaniciKayitButon.setBounds(172, 373, 105, 23);
		panel.add(kullaniciKayitButon);
		
        gise_button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("gise girisi icin sorgu gonderildi");
				//sımdı verı tabanına baslıcam ordan mudur verı tabanını yaratıp constructorunu cagırcam burda 
				
				main_gise m = new main_gise();
				m.frameG.setVisible(true);
				frmBanka.setVisible(false);
				
			}
		});
        
        //usernameyı alıcaz
        
		
	}
}
