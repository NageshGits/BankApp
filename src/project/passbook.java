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

import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class passbook extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,img_label;
	JButton submit;
	private JLabel login_lbl;
	private JLabel back_label;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					passbook frame = new passbook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public passbook() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 597);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 215, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images\\bank.png"));
		lblNewLabel.setBounds(417, 10, 96, 108);
		contentPane.add(lblNewLabel);
		
		JLabel lblSbiBankPvtltd = new JLabel("SBI BANK PVT.LTD");
		lblSbiBankPvtltd.setForeground(new Color(0, 0, 128));
		lblSbiBankPvtltd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblSbiBankPvtltd.setBounds(362, 128, 239, 33);
		contentPane.add(lblSbiBankPvtltd);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(10, 166, 933, 410);
		contentPane.add(panel);
		panel.setLayout(null);
		
		l1 = new JLabel("Name");
		l1.setVisible(false);
		l1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l1.setBounds(10, 10, 165, 33);
		panel.add(l1);
		
		l2 = new JLabel("Acount No");
		l2.setVisible(false);
		l2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l2.setBounds(10, 67, 165, 33);
		panel.add(l2);
		
		l3 = new JLabel("IFSC Code");
		l3.setVisible(false);
		l3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l3.setBounds(10, 127, 165, 33);
		panel.add(l3);
		
		l4 = new JLabel("Mobile Number");
		l4.setVisible(false);
		l4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l4.setBounds(10, 192, 165, 33);
		panel.add(l4);
		
		l5 = new JLabel("Address");
		l5.setVisible(false);
		l5.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l5.setBounds(10, 262, 165, 33);
		panel.add(l5);
		
		l6 = new JLabel("Available Bal:");
		l6.setVisible(false);
		l6.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l6.setBounds(10, 315, 165, 33);
		panel.add(l6);
		
		l7 = new JLabel("");
		l7.setVisible(false);
		l7.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l7.setBounds(185, 10, 351, 33);
		panel.add(l7);
		
		l8 = new JLabel("");
		l8.setVisible(false);
		l8.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l8.setBounds(185, 67, 165, 33);
		panel.add(l8);
		
		l9 = new JLabel("");
		l9.setVisible(false);
		l9.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l9.setBounds(185, 127, 165, 33);
		panel.add(l9);
		
		l10 = new JLabel("");
		l10.setVisible(false);
		l10.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l10.setBounds(185, 192, 165, 33);
		panel.add(l10);
		
		l11 = new JLabel("");
		l11.setVisible(false);
		l11.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l11.setBounds(185, 262, 192, 43);
		panel.add(l11);
		
		l12 = new JLabel("");
		l12.setVisible(false);
		l12.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l12.setBounds(185, 315, 165, 33);
		panel.add(l12);
		
		img_label = new JLabel("");
		img_label.setVisible(false);
		img_label.setBorder(new LineBorder(new Color(0, 0, 0)));
		img_label.setBounds(601, 44, 322, 304);
		panel.add(img_label);
		
		t1 = new JTextField();
		t1.setBounds(196, 127, 224, 43);
		panel.add(t1);
		t1.setColumns(10);
		
		l13 = new JLabel("Account No");
		l13.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l13.setBounds(10, 139, 165, 33);
		panel.add(l13);
		
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
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
						String fname,sname,lname;
						String account_no=rs.getString(1);
						String ifsc=rs.getString(2);
						fname=rs.getString(3);
						sname=rs.getString(4);
						lname=rs.getString(5);
						String address=rs.getString(6);
						String mobile=rs.getString(7);
						int balance =rs.getInt(9);
						
						l7.setText(fname+" "+sname+" "+lname);
						l8.setText(""+account_no);
						l9.setText(""+ifsc);
						l10.setText(""+mobile);
						l11.setText(""+address);
						l12.setText(""+balance+"/-");
						
						l1.setVisible(true);
						l2.setVisible(true);
						l3.setVisible(true);
						l4.setVisible(true);
						l5.setVisible(true);
						l6.setVisible(true);
						l7.setVisible(true);
						l8.setVisible(true);
						l9.setVisible(true);
						l10.setVisible(true);
						l11.setVisible(true);
						l12.setVisible(true);
						img_label.setVisible(true);
						l13.setVisible(false);
						t1.setVisible(false);
						submit.setVisible(false);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"NO Data!!");
					}
					
				}catch(Exception ee) {}
			}
		});
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		submit.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), null));
		submit.setBackground(new Color(106, 90, 205));
		submit.setBounds(141, 217, 134, 35);
		panel.add(submit);
		
		login_lbl = new JLabel("");
		login_lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you want to close?","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
					passbook.this.dispose();
				}
			}
		});
		login_lbl.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images\\exit.png"));
		login_lbl.setToolTipText("Exit");
		login_lbl.setBounds(915, 10, 28, 26);
		contentPane.add(login_lbl);
		
		back_label = new JLabel("");
		back_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashBoard db = new DashBoard();
				db.show();
				dispose();			}
		});
		back_label.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images\\back_button.png"));
		back_label.setToolTipText("Go Back");
		back_label.setBounds(10, 10, 42, 33);
		contentPane.add(back_label);
	}
}
