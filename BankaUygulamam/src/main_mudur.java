import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class main_mudur extends veritabanıMudur {

	 JFrame frameM;
	 private JTextField input_username;
	 private JPasswordField password_input;
      //LOGINDE MUDUR GIRIS KISMINA BASILINA OTOMATIK BURAYA ATICAK BURDA MUDUR TABLOSUNUN BIGLILERI GIRILIP GIRIS YAP DENILCEK
	 //BU SISTEM KABUL EDILDIGINDE MUDUR 2 DIYE TABLO ACALIM ORDAN GOREVLERINI YAPSIN YALANDAN VERILERI VERSIN MUDUR K AD SIFRE GIBI
	 //TEK GOREVI CALISANI KOVMAK OLSUN
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_mudur window = new main_mudur();
					window.frameM.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */ 
	//mudur constructor koda gore account mudure baglancak extends ettıgı kısma bak anlarsın hedeflerı vermıs oldum
	public main_mudur() {
		super("root","","bank_database","account_mudur");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameM = new JFrame();
		frameM.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AHMET\\Desktop\\int bankacılığı.png"));
		frameM.setBounds(100, 100, 485, 380);
		frameM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setForeground(new Color(255, 255, 255));
		frameM.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MUDUR GIRIS EKRANI");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(155, 26, 223, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Kullanıcı Adı :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(53, 102, 112, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sifre :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(53, 158, 46, 14);
		panel.add(lblNewLabel_2);
		
		input_username = new JTextField();
		input_username.setBounds(223, 96, 86, 20);
		panel.add(input_username);
		input_username.setColumns(10);
		
		password_input = new JPasswordField();
		password_input.setBounds(223, 157, 86, 20);
		panel.add(password_input);
		
		JButton login_mudur = new JButton("Giris Yap");
		login_mudur.setBounds(179, 255, 89, 23);
		panel.add(login_mudur);
		
       login_mudur.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("sorgu gonderildi");
				
				if(access_control(input_username.getText(),password_input.getText())==true) {
					
					JOptionPane.showMessageDialog(null,"HESAP BULUNDU : "+veriler[0] + " " +veriler[1],"MUDUR HESABI BASARILI GIRIS!",3);
					mudur_islem mi = new mudur_islem(); //buraları degıscem sımdı
					mi.frameMislem.setVisible(true);
					frameM.setVisible(false);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "HESAP BULUNAMADI", "BASARISIZ", 0);
				}
			}
		});
	}
}
