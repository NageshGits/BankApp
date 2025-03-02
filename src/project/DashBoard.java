package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DashBoard extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard frame = new DashBoard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public DashBoard() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 577);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 215, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(424, 10, 96, 108);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images\\bank.png"));
		
		JLabel lblSbiBankPvtltd = new JLabel("SBI BANK PVT.LTD");
		lblSbiBankPvtltd.setBounds(359, 128, 239, 33);
		contentPane.add(lblSbiBankPvtltd);
		lblSbiBankPvtltd.setForeground(new Color(0, 0, 128));
		lblSbiBankPvtltd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		
		JPanel panel = 	new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				open_acc op = new open_acc();
				op.show();
				dispose();	
			}
		});
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(0, 0, 0)));
		panel.setBounds(36, 205, 255, 147);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel acc_open_label = new JLabel("");
		acc_open_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				open_acc op = new open_acc();
				op.show();
				dispose();
			}
		});
		
		acc_open_label.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images\\acc-open.png"));
		acc_open_label.setBounds(64, 10, 132, 99);
		panel.add(acc_open_label);
		
		JLabel dash_label1 = new JLabel("Open new Account");
		dash_label1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				open_acc op = new open_acc();
				op.show();
				dispose();
			}
		});
		dash_label1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		dash_label1.setForeground(new Color(0, 0, 0));
		dash_label1.setBounds(64, 119, 181, 18);
		panel.add(dash_label1);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deposit db = new deposit();
				db.show();
				dispose();
			}
		});
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(336, 205, 255, 147);
		contentPane.add(panel_1);
		
		JLabel acc_open_label_1 = new JLabel("");
		acc_open_label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deposit db = new deposit();
				db.show();
				dispose();
			}
		});
		acc_open_label_1.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images\\deposit.png"));
		acc_open_label_1.setBounds(78, 8, 118, 101);
		panel_1.add(acc_open_label_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Deposit Money");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deposit db = new deposit();
				db.show();
				dispose();
			}
		});
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(74, 119, 142, 18);
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				withdraw w = new withdraw();
				w.show();
				dispose();
			}
		});	
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);
		panel_2.setBounds(636, 205, 255, 147);
		contentPane.add(panel_2);
		
		JLabel acc_open_label_2 = new JLabel("");
		acc_open_label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				withdraw w = new withdraw();
				w.show();
				dispose();
				
			}
		});
		acc_open_label_2.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images\\withdraw.png"));
		acc_open_label_2.setBounds(84, 10, 128, 99);
		panel_2.add(acc_open_label_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Withdraw Money");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				withdraw w = new withdraw();
				w.show();
				dispose();
			}
		});
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(84, 119, 142, 18);
		panel_2.add(lblNewLabel_1_1_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passbook p = new passbook();
				p.show();
				dispose();
			}
		});
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setLayout(null);
		panel_5.setBounds(183, 408, 255, 147);
		contentPane.add(panel_5);
		
		JLabel acc_open_label_3_1_1 = new JLabel("");
		acc_open_label_3_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passbook p = new passbook();
				p.show();
				dispose();
			}
		});
		acc_open_label_3_1_1.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images\\balance.png"));
		acc_open_label_3_1_1.setBounds(64, 10, 128, 99);
		panel_5.add(acc_open_label_3_1_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Check Account Info");
		lblNewLabel_1_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passbook p = new passbook();
				p.show();
				dispose();
			}
		});
		lblNewLabel_1_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2_1_1.setBounds(51, 119, 181, 18);
		panel_5.add(lblNewLabel_1_2_1_1);
		
		JLabel login_lbl_1 = new JLabel("");
		login_lbl_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null,"Are you want to close app?","Confirmation",JOptionPane.YES_NO_OPTION)==0){
					DashBoard.this.dispose();
				}
			}
		});
		login_lbl_1.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images\\exit.png"));
		login_lbl_1.setToolTipText("Exit");
		login_lbl_1.setBounds(921, 10, 28, 26);
		contentPane.add(login_lbl_1);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showtable s = new showtable();
				s.show();
				dispose();
				
			}
		});
		panel_5_1.setLayout(null);
		panel_5_1.setBackground(Color.WHITE);
		panel_5_1.setBounds(556, 408, 255, 147);
		contentPane.add(panel_5_1);
		
		JLabel acc_open_label_3_1_1_1 = new JLabel("");
		acc_open_label_3_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showtable s = new showtable();
				s.show();
				dispose();
				
			}
		});
		acc_open_label_3_1_1_1.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images\\customer.png"));
		acc_open_label_3_1_1_1.setBounds(78, 10, 96, 99);
		panel_5_1.add(acc_open_label_3_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Check Customer List");
		lblNewLabel_1_2_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showtable s = new showtable();
				s.show();
				dispose();
				
			}
			
		});
		lblNewLabel_1_2_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2_1_1_1.setBounds(40, 119, 181, 18);
		panel_5_1.add(lblNewLabel_1_2_1_1_1);
	}
}
