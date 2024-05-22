import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gise_islem extends veritabanıGise {

	 JFrame frame;
	 private JTextField komisyonMikt;
	 public static String belirlenenkomisyon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gise_islem window = new gise_islem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gise_islem() {
		super("root","","bank_database","account_gise");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Baglanilan Gise İslem : " + veriler[2]);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AHMET\\Desktop\\int bankacılığı.png"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel komisyonMiktar = new JLabel("Belirlenen Komisyon :");
		komisyonMiktar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		komisyonMiktar.setBounds(20, 68, 147, 32);
		panel.add(komisyonMiktar);
		
		komisyonMikt = new JTextField();
		komisyonMikt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		komisyonMikt.setBounds(210, 76, 136, 24);
		panel.add(komisyonMikt);
		komisyonMikt.setColumns(10);
		
		JButton komisyonOnay = new JButton("Uygula");
		komisyonOnay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				belirlenenkomisyon = komisyonMikt.getText();
				
				komisyon_belirle(veriler[2], belirlenenkomisyon);
				
				JOptionPane.showMessageDialog(null, "Belirlenmiş Olan Komisyon :" + belirlenenkomisyon, " BASARILI" , 3);
				
				
			}
		});
		komisyonOnay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		komisyonOnay.setBounds(210, 181, 89, 23);
		panel.add(komisyonOnay);
		
		//komisyonMiktar . gettext ile buraya girilen veriyi alıcam sonrada bunu işlemlere havale işlemlerine dahil edicem!!
		//uygula tusuna bastıgında verı tabanından komısyon oranını guncellemesı gerekıyor
		
		
	}
	

}
