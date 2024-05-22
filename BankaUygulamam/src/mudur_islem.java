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
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

public class mudur_islem extends veritabanıMudur{

	 JFrame frameMislem;
	 private JTextField cikarilacak_gorevli;
    //ad soy ad kullanıcı adı karsısına get label yapıp oraya ad soy ad kullanıcı adı getırıcem maincb2 gıbı burası
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mudur_islem window = new mudur_islem();
					window.frameMislem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
     //mudur ıslem gıse gorevlı cıkarta basına yanında label koy aynısnı yaz fıeld al oraya cıkarılcak gorevlı usernamesı al silsin
	//altertable ıle databasesınden silsin onu
	/**
	 * Create the application.
	 */
	public mudur_islem() {
		super("root","","bank_database","account_mudur");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMislem = new JFrame("Mudur Hesap Girisi : " +veriler[2]);
		frameMislem.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AHMET\\Desktop\\int bankacılığı.png"));
		frameMislem.setBounds(100, 100, 483, 381);
		frameMislem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		frameMislem.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adı :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(38, 69, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Soyadı :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(38, 121, 72, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Kullanıcı Adı :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(38, 179, 100, 14);
		panel.add(lblNewLabel_2);
		
		JLabel getName = new JLabel(veriler[0]);
		getName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getName.setBounds(120, 71, 46, 14);
		panel.add(getName);
		
		JLabel getSurname = new JLabel(veriler[1]);
		getSurname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getSurname.setBounds(120, 123, 46, 14);
		panel.add(getSurname);
		
		JLabel getUsername = new JLabel(veriler[2]);
		getUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getUsername.setBounds(145, 181, 100, 14);
		panel.add(getUsername);
		
		JButton gorevli_cıkart = new JButton("Gise Görevli Cıkart"); //burda altertable ıle dıger tablodakı calısanı sılcez ekrana yazdırcaz cıkarıldı dıye 
		gorevli_cıkart.setFont(new Font("Tahoma", Font.PLAIN, 13));
		gorevli_cıkart.setBackground(new Color(192, 192, 192));
		gorevli_cıkart.setBounds(38, 257, 150, 37);
		panel.add(gorevli_cıkart);
		
        gorevli_cıkart.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				gise_sonlandir(cikarilacak_gorevli.getText());
				
				
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Çıkarılacak Gorevli K.Adı ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(253, 25, 175, 14);
		panel.add(lblNewLabel_3);
		
		
		cikarilacak_gorevli = new JTextField(); //burdan gorevlının text ıle usernamesını alıcaz onu kullancaz
		cikarilacak_gorevli.setBounds(288, 81, 122, 20);
		panel.add(cikarilacak_gorevli);
		cikarilacak_gorevli.setColumns(10);
	}

}
