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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class update_balance extends veritabanı {

	 JFrame framebalance;
	private JTextField bakiye;
	private JTextField yuklencekbakiye;
	private JTextField cekilecekbakiye;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_balance window = new update_balance();
					window.framebalance.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public update_balance() {
		super(getDatabase_username(),getDatabase_password(),getDatabase_name(),getDatabase_table_name());
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		framebalance = new JFrame();
		framebalance.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AHMET\\Desktop\\int bankacılığı.png"));
		framebalance.setBounds(100, 100, 529, 386);
		framebalance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		framebalance.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bakiyeniz :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(93, 41, 99, 22);
		panel.add(lblNewLabel);
		
		bakiye = new JTextField();
		bakiye.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bakiye.setBounds(234, 42, 86, 20);
		panel.add(bakiye);
		bakiye.setColumns(10);
		bakiye.setText(getBakiye(veriler[2])+"");
		
		JButton parayuklebtn = new JButton("Para Yukle");
		parayuklebtn.setBounds(93, 118, 89, 23);
		panel.add(parayuklebtn);
		
		
		
	    parayuklebtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				int total = Integer.valueOf(yuklencekbakiye.getText()) + getBakiye(veriler[2]);
				System.out.println(total);
				bakiye_update(veriler[2],total+""); //burda vardı
				
				bakiye.setText( total +"");
			}
		});
	    
	    
		
		JButton paracekbtn = new JButton("Para Cek");
		paracekbtn.setBounds(290, 118, 89, 23);
		panel.add(paracekbtn);
		
		
		
		yuklencekbakiye = new JTextField();
		yuklencekbakiye.setBounds(93, 172, 86, 20);
		panel.add(yuklencekbakiye);
		yuklencekbakiye.setColumns(10);
		
		cekilecekbakiye = new JTextField();
		cekilecekbakiye.setBounds(293, 172, 86, 20);
		panel.add(cekilecekbakiye);
		cekilecekbakiye.setColumns(10);
		
		
		
        paracekbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if(getBakiye(veriler[2])<Integer.valueOf(cekilecekbakiye.getText())) {
					JOptionPane.showMessageDialog(null,"Bakiyenizden Yuksek Miktarda Para Cekemezsiniz!!!");
				}
				else {
					int total = getBakiye(veriler[2])- Integer.valueOf(cekilecekbakiye.getText()) ;
					System.out.println(total);
					bakiye_update(veriler[2],total+"");
					bakiye.setText( total +"");
				}		
				
			}
		});
	}
}
