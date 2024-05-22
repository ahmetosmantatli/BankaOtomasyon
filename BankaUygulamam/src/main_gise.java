import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_gise extends veritabanıGise {

	public JFrame frameG;
	private JTextField input_username;
	private JPasswordField password_input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_gise window = new main_gise();
					window.frameG.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main_gise() {
		super("root","","bank_database","account_gise");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameG = new JFrame();
		frameG.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AHMET\\Desktop\\int bankacılığı.png"));
		frameG.getContentPane().setForeground(new Color(0, 0, 0));
		frameG.setBounds(100, 100, 533, 377);
		frameG.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameG.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GİSE GÖREVLİ KONTROL");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(141, 11, 218, 29);
		frameG.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Kullanıcı Adı :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(40, 96, 84, 29);
		frameG.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sifre :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(40, 167, 84, 29);
		frameG.getContentPane().add(lblNewLabel_1_1);
		
		input_username = new JTextField();
		input_username.setBounds(191, 102, 109, 23);
		frameG.getContentPane().add(input_username);
		input_username.setColumns(10);
		
		password_input = new JPasswordField();
		password_input.setBounds(191, 167, 109, 26);
		frameG.getContentPane().add(password_input);
		
		JButton loginGise = new JButton("Giriş Yap");
		loginGise.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loginGise.setBounds(203, 262, 89, 23);
		frameG.getContentPane().add(loginGise);
		
	       loginGise.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					System.out.println("sorgu gonderildi");
					
					if(access_control(input_username.getText(),password_input.getText())==true) {
						
						JOptionPane.showMessageDialog(null,"HESAP BULUNDU : "+veriler[0] + " " +veriler[1],"Gise HESABI BASARILI GIRIS!",3);
						gise_islem f = new gise_islem(); //buraları degıscem sımdı baglancagım sayfayı yaratıp
						f.frame.setVisible(true);
						frameG.setVisible(false);
						
					}
					else {
						JOptionPane.showMessageDialog(null, "HESAP BULUNAMADI", "BASARISIZ", 0);
					}
				}
			});
		
		
	}
}
