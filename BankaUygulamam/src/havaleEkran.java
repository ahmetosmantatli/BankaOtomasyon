import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class havaleEkran extends veritabanı {

	public JFrame frameHavaleEkran;
	private JTextField havaleYapilacakText;
	private JTextField komisyonKutusu;
	private JTextField havaleMiktar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					havaleEkran window = new havaleEkran();
					window.frameHavaleEkran.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public havaleEkran() {
		super("root","","bank_database","account_info");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameHavaleEkran = new JFrame();
		frameHavaleEkran.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AHMET\\Desktop\\int bankacılığı.png"));
		frameHavaleEkran.setBounds(100, 100, 505, 364);
		frameHavaleEkran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frameHavaleEkran.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Havale Yapılacak Kullanici Adi :");
		lblNewLabel.setBounds(10, 47, 160, 26);
		panel.add(lblNewLabel);
		
		havaleYapilacakText = new JTextField();
		havaleYapilacakText.setBounds(200, 49, 211, 34);
		panel.add(havaleYapilacakText);
		havaleYapilacakText.setColumns(10);
		
		JButton havaleButon = new JButton("Havale Yap");
		
		
		
		
		havaleButon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		havaleButon.setBounds(217, 244, 137, 23);
		panel.add(havaleButon);
		
		JLabel lblKomisyonMiktar = new JLabel("Komisyon Miktarı  :");
		lblKomisyonMiktar.setBounds(10, 178, 108, 26);
		panel.add(lblKomisyonMiktar);
		
		komisyonKutusu = new JTextField();
		komisyonKutusu.setEditable(false);
		komisyonKutusu.setBounds(200, 174, 206, 34);
		panel.add(komisyonKutusu);
		komisyonKutusu.setColumns(10);
		
		int UygulancakKomisyon = Integer.valueOf(getKomisyon());
		komisyonKutusu.setText(String.valueOf(UygulancakKomisyon));
		
		JLabel lblHavaleMiktar = new JLabel("Havale Miktarı  :");
		lblHavaleMiktar.setBounds(10, 108, 108, 26);
		panel.add(lblHavaleMiktar);
		
		havaleMiktar = new JTextField();
		havaleMiktar.setColumns(10);
		havaleMiktar.setBounds(200, 108, 206, 34);
		panel.add(havaleMiktar);
		
		havaleButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String havaleKullanici = havaleYapilacakText.getText(); 
				
				
				
				int HavaleMiktar =  Integer.valueOf(havaleMiktar.getText());
				
				
				
				int havaleGonderecekKisiBakiye = getBakiye(login.HavaleGonderecekKullanici);
				
				
			
				int totalHavaleGonderecekKisi =  havaleGonderecekKisiBakiye-HavaleMiktar - UygulancakKomisyon;
						
				int havaleGonderilecekKisiBakiye = getBakiye(havaleKullanici);
				
				int totalHavaleGonderilecekKisi = havaleGonderilecekKisiBakiye + HavaleMiktar;
				
				if(totalHavaleGonderecekKisi < 0 || havaleGonderecekKisiBakiye  < 0 ) {
					JOptionPane.showMessageDialog(null, "YETERSİZ BAKİYE" , " BASARISIZ" , 0);
					
				}else {   
					
				
				
				bakiye_update(login.HavaleGonderecekKullanici, String.valueOf(totalHavaleGonderecekKisi));
				
				System.out.println(getBakiye(login.HavaleGonderecekKullanici));
				
				bakiye_update(havaleKullanici, String.valueOf(totalHavaleGonderilecekKisi ));
				
				System.out.println(getBakiye(havaleKullanici));
				
				
				JOptionPane.showMessageDialog(null, "HAVALE YAPILMIŞTIR!!" , " BASARILI" , 3);
				}
				
			}
		});
		
	}
}
