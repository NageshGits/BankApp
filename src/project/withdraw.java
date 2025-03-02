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
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class withdraw extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField text2;
	JButton withdrawbtn;
	JLabel lblAmount;
	JButton search ;
	private JLabel foundlabel;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					withdraw frame = new withdraw();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public withdraw() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 215, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("");
		label1.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images"));
		label1.setBounds(346, 0, 96, 108);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("SBI BANK PVT.LTD");
		label2.setForeground(new Color(0, 0, 128));
		label2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		label2.setBounds(275, 109, 239, 33);
		contentPane.add(label2);
		
		JLabel back_label = new JLabel("");
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
		back_label.setBounds(10, 10, 42, 33);
		contentPane.add(back_label);
		
		JLabel login_lbl = new JLabel("");
		login_lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null,"Are you want to close app?","Confirmation",JOptionPane.YES_NO_OPTION)==0){
					withdraw.this.dispose();
				}
			}
		});
		login_lbl.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images\\exit.png"));
		login_lbl.setToolTipText("Exit");
		login_lbl.setBounds(689, 10, 28, 26);
		contentPane.add(login_lbl);
		
		JLabel label3 = new JLabel("Account No");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		label3.setBounds(27, 249, 123, 33);
		contentPane.add(label3);
		
		lblAmount = new JLabel("Amount ");
		lblAmount.setVisible(false);
		lblAmount.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblAmount.setBounds(27, 249, 123, 33);
		contentPane.add(lblAmount);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(156, 251, 165, 33);
		contentPane.add(t1);
		
		text2 = new JTextField();
		text2.setVisible(false);
		text2.setColumns(10);
		text2.setBounds(156, 249, 165, 33);
		contentPane.add(text2);
		
		JLabel img_label = new JLabel("");
		img_label.setBorder(new LineBorder(new Color(0, 0, 0)));
		img_label.setBounds(448, 139, 229, 226);
		contentPane.add(img_label);
		
		search= new JButton("Search");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/javaprojects";
					String username="root";
					String password="root";
					Connection con=DriverManager.getConnection(url,username,password);
					
					String query ="select * from open_acc where acc_no= '"+t1.getText()+"'";
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
						foundlabel.setText("Account Holder Name : "+first_name+" "+last_name);
						
						lblAmount.setVisible(true);
						text2.setVisible(true);
						t1.setVisible(false);
						label3.setVisible(false);
						withdrawbtn.setVisible(true);
						search.setVisible(false); 
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"NO Data!!");
					}
					
				}catch(Exception ee) {}
			}
		});
		
		search.setForeground(Color.WHITE);
		search.setFont(new Font("Times New Roman", Font.BOLD, 14));
		search.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), null));
		search.setBackground(new Color(106, 90, 205));
		search.setBounds(118, 305, 134, 35);
		contentPane.add(search);
		
		
		withdrawbtn = new JButton("withdraw");
		withdrawbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/javaprojects";
					String username="root";
					String password="root";
					Connection con=DriverManager.getConnection(url,username,password);
					
					PreparedStatement ps = con.prepareStatement("update open_acc set Deposite = Deposite -'"+text2.getText()+"' where acc_no='"+t1.getText()+"'" );
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Amount Withdrawl Successfull...");
					
				}catch(Exception ee) {}
			}
		});
		withdrawbtn.setVisible(false);
		withdrawbtn.setForeground(Color.WHITE);
		withdrawbtn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		withdrawbtn.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), null));
		withdrawbtn.setBackground(new Color(106, 90, 205));
		withdrawbtn.setBounds(118, 305, 134, 35);
		contentPane.add(withdrawbtn);
		
		foundlabel = new JLabel("");
		foundlabel.setForeground(new Color(210, 105, 30));
		foundlabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		foundlabel.setBounds(27, 175, 415, 33);
		contentPane.add(foundlabel);
	}

}
