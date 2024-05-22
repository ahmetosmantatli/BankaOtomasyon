import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class reset_password extends main_cb2 {

	 JFrame frame;
	private JTextField eski_sifre;
	private JTextField yeni_sifre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reset_password window = new reset_password();
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
	public reset_password() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Sifresi Sifirlanicak Hesap : "+ veriler[2]);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AHMET\\Desktop\\int bankacılığı.png"));
		frame.setBounds(100, 100, 483, 343);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		eski_sifre = new JTextField();
		eski_sifre.setBounds(220, 55, 144, 30);
		panel.add(eski_sifre);
		eski_sifre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Eski Sifreniz :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(47, 64, 96, 14);
		panel.add(lblNewLabel);
		
		JLabel lblYeniSifreniz = new JLabel("Yeni Sifreniz :");
		lblYeniSifreniz.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYeniSifreniz.setBounds(47, 132, 96, 14);
		panel.add(lblYeniSifreniz);
		
		yeni_sifre = new JTextField();
		yeni_sifre.setColumns(10);
		yeni_sifre.setBounds(220, 126, 144, 30);
		panel.add(yeni_sifre);
		
		JButton btnNewButton = new JButton("SİFREYİ DEGİSTİR");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(148, 211, 154, 42);
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				String get_oldpass = eski_sifre.getText();
				String get_newpass = yeni_sifre.getText();
				System.out.println(get_oldpass+" - "+get_newpass);
						
				reset_pass(veriler[2],get_oldpass,get_newpass);
			}
		});
	}

}
