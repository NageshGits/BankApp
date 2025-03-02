
package project;

import project.DashBoard;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	String user,pass;
	JLabel valid_label;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Home() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 370);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 215, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\java project\\Internet Banking\\Images\\bank.png"));
		lblNewLabel.setBounds(196, 10, 96, 97);
		contentPane.add(lblNewLabel);
		
		JLabel name = new JLabel("SBI BANK PVT.LTD");
		name.setForeground(new Color(0, 0, 128));
		name.setBounds(133, 117, 239, 33);
		name.setFont(new Font("Times New Roman",Font.BOLD|Font.ITALIC,25));
		contentPane.add(name);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(182, 242, 248));
		panel.setBounds(115, 159, 297, 201);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel userlabel = new JLabel("UserName");
		userlabel.setBackground(new Color(240, 240, 240));
		userlabel.setBounds(26, 33, 59, 13);
		panel.add(userlabel);
		
		JLabel password_label = new JLabel("Password");
		password_label.setBounds(26, 78, 69, 13);
		panel.add(password_label);
		
		textField = new JTextField();
		textField.setBounds(26, 49, 141, 19);
		textField.setFont(new Font("Times New Roman",Font.PLAIN,15));
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(26, 101, 141, 19);
		passwordField.setFont(new Font("Times New Roman",Font.PLAIN,15));
		panel.add(passwordField);
		
		
		
		JCheckBox show = new JCheckBox("Show Password");
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(show.isSelected()) {
					passwordField.setEchoChar((char)0);
				}
				else
				{
					passwordField.setEchoChar('●');
				}
				
			}
		});
		show.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images\\eye.png"));
		show.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		show.setBounds(47, 165, 112, 21);
		panel.add(show);
		
		valid_label = new JLabel("");
		valid_label.setBounds(26, 130, 201, 13);
		valid_label.setFont(new Font("Times New Roman",Font.PLAIN,15));
		valid_label.setForeground(Color.red);
		panel.add(valid_label);
		
		JButton login = new JButton("Login");
		login.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), null));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user=textField.getText();
				pass=passwordField.getText();
				if(textField.equals("") && passwordField.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter valid input!!");
				}
				else if (user.equals("nageshwar") &&  pass.equals("JaiHind")) {
				
					DashBoard db = new DashBoard();
					db.show();
					dispose();
				}
				else {
					valid_label.setText("Invalid Username or Password!!");
					
				}
			}
		});
		login.setIcon(null);
		login.setBackground(new Color(106, 90, 205));
		login.setForeground(new Color(255, 255, 255));
		login.setBounds(183, 162, 105, 24);
		panel.add(login);
		
		JLabel login_lbl_1 = new JLabel("");
		login_lbl_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null,"Are you want to close app?","Confirmation",JOptionPane.YES_NO_OPTION)==0){
					Home.this.dispose();
				}
			}
		}); 
		login_lbl_1.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images\\exit.png"));
		login_lbl_1.setBounds(445, 10, 28, 26);
		contentPane.add(login_lbl_1);
		login_lbl_1.setToolTipText("");
		
	}
}
