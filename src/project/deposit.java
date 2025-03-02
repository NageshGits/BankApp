package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class deposit extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	JLabel img_label;	
	private JLabel login_lbl;
	private JLabel back_label;
	JButton btnDeposit;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel lblAmount;
	JButton btnSearch;
	private JLabel labelnew;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deposit frame = new deposit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public deposit() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 515);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 215, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label1 = new JLabel("");
		label1.setIcon(new ImageIcon("D:\\java project\\Internet Banking\\Images\\bank.png"));
		label1.setBounds(290, 10, 96, 108);
		contentPane.add(label1);
		
		label2 = new JLabel("SBI BANK PVT.LTD");
		label2.setForeground(new Color(0, 0, 128));
		label2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		label2.setBounds(231, 120, 239, 33);
		contentPane.add(label2);
		
		label3 = new JLabel("Account No");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		label3.setBounds(23, 240, 165, 33);
		contentPane.add(label3);
		
		tf1 = new JTextField();
		tf1.setColumns(10);
		tf1.setBounds(189, 238, 165, 33);
		contentPane.add(tf1);
		
	    lblAmount = new JLabel("Amount ");
		lblAmount.setVisible(false);
		lblAmount.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblAmount.setBounds(23, 238, 165, 33);
		contentPane.add(lblAmount);
		
		tf2 = new JTextField();
		tf2.setVisible(false);
		tf2.setColumns(10);
		tf2.setBounds(189, 240, 165, 33);
		contentPane.add(tf2);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/javaprojects";
					String username="root";
					String password="root";
					Connection con=DriverManager.getConnection(url,username,password);
					
					String query ="select * from open_acc where acc_no= '"+tf1.getText()+"'";
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					if (rs.next()) {
						byte[] img = rs.getBytes("Image");
						ImageIcon image = new ImageIcon(img);
						Image im = image.getImage();
						Image myimg = im.getScaledInstance(img_label.getWidth(),img_label.getHeight(),Image.SCALE_SMOOTH);
						ImageIcon newimg = new ImageIcon(myimg);
						
						img_label.setIcon(newimg);
						String first_name = rs.getString(3);
						String last_name = rs.getString(5);
						labelnew.setText("Account Holder Name: "+first_name+" "+last_name);
						img_label.setVisible(true);
						btnDeposit.setVisible(true);
						tf2.setVisible(true);
						lblAmount.setVisible(true);
						btnSearch.setVisible(false);
						tf1.setVisible(false);
						label3.setVisible(false);
						
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"NO Data!!");
					}
					
				}catch(Exception ee) {}
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSearch.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), null));
		btnSearch.setBackground(new Color(106, 90, 205));
		btnSearch.setBounds(122, 301, 134, 35);
		contentPane.add(btnSearch);
		
		btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/javaprojects";
					String username="root";
					String password="root";
					Connection con=DriverManager.getConnection(url,username,password);
					
					PreparedStatement ps = con.prepareStatement("update open_acc set Deposite = Deposite +'"+tf2.getText()+"' where acc_no='"+tf1.getText()+"'" );
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Amount Deposited Successfully..");
					tf2.setText("");
					labelnew.setText("");
					img_label.setText("");
					
					
				}catch(Exception ee) {}
			}
		});
		btnDeposit.setVisible(false);
		btnDeposit.setForeground(Color.WHITE);
		btnDeposit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDeposit.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), null));
		btnDeposit.setBackground(new Color(106, 90, 205));
		btnDeposit.setBounds(122, 301, 134, 35);
		contentPane.add(btnDeposit);
		
		img_label = new JLabel("");
		img_label.setVisible(false);
		img_label.setBounds(450, 160, 229, 226);
		contentPane.add(img_label);
		img_label.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		login_lbl = new JLabel("");
		login_lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null,"Are you want to close app?","Confirmation",JOptionPane.YES_NO_OPTION)==0){
					deposit.this.dispose();
				}
			}
		});
		login_lbl.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images\\exit.png"));
		login_lbl.setToolTipText("Exit");
		login_lbl.setBounds(711, 10, 28, 26);
		contentPane.add(login_lbl);
		
		back_label = new JLabel("");
		back_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashBoard db = new DashBoard();
				db.show();
				dispose();
			}
		});
		back_label.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images\\back_button.png"));
		back_label.setToolTipText("Go Back");
		back_label.setBounds(10, 3, 42, 33);
		contentPane.add(back_label);
		
		labelnew = new JLabel("");
		labelnew.setForeground(new Color(139, 0, 0));
		
		labelnew.setFont(new Font("Times New Roman", Font.BOLD, 19));
		labelnew.setBounds(23, 180, 397, 33);
		contentPane.add(labelnew);
	}
}
