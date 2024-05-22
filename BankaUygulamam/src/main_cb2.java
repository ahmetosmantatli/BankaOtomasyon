import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class main_cb2 extends veritabanı {

	 JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_cb2 window = new main_cb2();
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
	public main_cb2() {
		super(getDatabase_username(),getDatabase_password(),getDatabase_name(),getDatabase_table_name());
		initialize(); //getDatabase_bakiye
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Baglanilan Hesap :"+veriler[2]);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AHMET\\Desktop\\int bankacılığı.png"));
		frame.setBounds(100, 100, 559, 392);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adi:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(24, 66, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel getname = new JLabel(veriler[0]);
		getname.setBounds(147, 66, 82, 24);
		panel.add(getname);
		
		JLabel lblNewLabel_1 = new JLabel("Soyadi :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(24, 100, 73, 24);
		panel.add(lblNewLabel_1);
		
		JLabel getsurname = new JLabel(veriler[1]);
		getsurname.setBounds(147, 101, 73, 14);
		panel.add(getsurname);
		
		JLabel lblNewLabel_2 = new JLabel("Kullanici Adi :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(24, 153, 82, 14);
		panel.add(lblNewLabel_2);
		
		JLabel getusername = new JLabel(veriler[2]);
		getusername.setBounds(147, 149, 120, 14);
		panel.add(getusername);
		
		JLabel lblNewLabel_3 = new JLabel("Sifre :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(24, 194, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel getpassword = new JLabel(veriler[3]);
		getpassword.setBounds(147, 194, 82, 14);
		panel.add(getpassword);
		
		JButton btnNewButton = new JButton("SİFRE SIFIRLA");
		btnNewButton.setBounds(350, 242, 120, 50);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Bakiye Yükle/Cek");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(350, 41, 160, 39);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("HAVALE/TRANSFER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				havaleEkran rs3 = new havaleEkran();
				rs3.frameHavaleEkran.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(350, 100, 160, 40);
		panel.add(btnNewButton_2);
		
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				update_balance rs2 = new update_balance();
				rs2.framebalance.setVisible(true);
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				reset_password rs = new reset_password();
				rs.frame.setVisible(true);
			}
		});
	}
}
