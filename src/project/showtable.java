package project;

import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class showtable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	String acc_no,ifsc,fname,sname,lname,mobile_no;
	String balance;
	private JLabel lblNewLabel;
	private JPasswordField passwordField;
	private JLabel label1;
	private JLabel label2;
	private JLabel back_label;
	private JLabel login_lbl;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {+});
	}
	public showtable() {
		setBackground(new Color(255, 215, 0));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 345);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 215, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Times New Roman", Font.BOLD, 12));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setVisible(false);
		scrollPane.setBounds(11, 179, 742, 131);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Enter Password");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(74, 190, 122, 30);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(199, 192, 154, 30);
		contentPane.add(passwordField);
		
		JButton btnSearch = new JButton("Show");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass=passwordField.getText();
				if(pass.equals("JaiHind")) {
					passwordField.setVisible(false);
					lblNewLabel.setVisible(false);
					btnSearch.setVisible(false);
					scrollPane.setVisible(true);
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						String url="jdbc:mysql://localhost:3306/javaprojects";
						String username="root";
						String password="root";
						Connection con=DriverManager.getConnection(url,username,password);
						Statement st=con.createStatement();
						String query="select acc_no,ifsc_code,first_name,second_name,last_name,Mobile_no,Deposite from open_acc";
						ResultSet rs=st.executeQuery(query);
						ResultSetMetaData rsmd = rs.getMetaData();
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						
						int cols=rsmd.getColumnCount();
						String[] colnames=new String [cols];
						for(int i=0;i<cols;i++) 
							colnames[i]=rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colnames);
						while(rs.next()) {
							acc_no=rs.getString(1);
							ifsc=rs.getString(2);
							fname=rs.getString(3);
							sname=rs.getString(4);
							lname=rs.getString(5);
							mobile_no=rs.getString(6);
							balance=rs.getString(7);
							String[] row= {acc_no,ifsc,fname,sname,lname,mobile_no,balance};
							model.addRow(row);
						}
						con.close();
						
					}catch(Exception ee) {
						ee.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Invalid Password!!");
				}
			}	
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSearch.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), null));
		btnSearch.setBackground(new Color(106, 90, 205));
		btnSearch.setBounds(175, 249, 134, 35);
		contentPane.add(btnSearch);
		
		label1 = new JLabel("");
		label1.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images\\bank.png"));
		label1.setBounds(323, 10, 96, 108);
		contentPane.add(label1);
		
		label2 = new JLabel("SBI BANK PVT.LTD");
		label2.setForeground(new Color(0, 0, 128));
		label2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		label2.setBounds(266, 122, 239, 33);
		contentPane.add(label2);
		
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
		back_label.setBounds(11, 10, 42, 33);
		contentPane.add(back_label);
		
		login_lbl = new JLabel("");
		login_lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null,"Are you want to close app?","Confirmation",JOptionPane.YES_NO_OPTION)==0){
					showtable.this.dispose();
				}
			}
		});
		login_lbl.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images\\exit.png"));
		login_lbl.setToolTipText("Exit");
		login_lbl.setBounds(725, 10, 28, 26);
		contentPane.add(login_lbl);
	}
}
