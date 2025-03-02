package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class open_acc extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;
	private byte[] picture;

	JLabel img_label;
	String filename = null;
	byte[] person_img = null;
	String s;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					open_acc frame = new open_acc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public open_acc() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 906, 588);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(255, 215, 0));
		contentPane.setBorder(new EmptyBorder(7, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images\\bank.png"));
		lblNewLabel.setBounds(354, 10, 96, 108);
		contentPane.add(lblNewLabel);
		
		JLabel lblSbiBankPvtltd = new JLabel("SBI BANK PVT.LTD");
		lblSbiBankPvtltd.setForeground(new Color(0, 0, 128));
		lblSbiBankPvtltd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblSbiBankPvtltd.setBounds(287, 128, 239, 33);
		contentPane.add(lblSbiBankPvtltd);
		
		JLabel l1 = new JLabel("Name");
		l1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l1.setBounds(71, 180, 165, 33);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Middle Name");
		l2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l2.setBounds(276, 180, 165, 33);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("Last Name");
		l3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l3.setBounds(498, 180, 165, 33);
		contentPane.add(l3);
		
		tf1 = new JTextField();
		tf1.setBounds(71, 223, 134, 33);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(268, 223, 134, 33);
		contentPane.add(tf2);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(477, 223, 134, 33);
		contentPane.add(tf3);
		
		JLabel l4 = new JLabel("Account No");
		l4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l4.setBounds(71, 294, 165, 33);
		contentPane.add(l4);
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(71, 332, 165, 33);
		contentPane.add(tf4);
		
		JLabel l5 = new JLabel("IFSC Code");
		l5.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l5.setBounds(276, 294, 165, 33);
		contentPane.add(l5);
		
		tf5 = new JTextField();
		tf5.setColumns(10);
		tf5.setBounds(276, 332, 165, 33);
		contentPane.add(tf5);
		
		JLabel l6 = new JLabel("Mobile No");
		l6.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l6.setBounds(71, 393, 165, 33);
		contentPane.add(l6);
		
		tf6 = new JTextField();
		tf6.setColumns(10);
		tf6.setBounds(71, 436, 165, 33);
		contentPane.add(tf6);
		
		JLabel l7 = new JLabel("Address ");
		l7.setFont(new Font("Times New Roman", Font.BOLD, 19));
		l7.setBounds(324, 393, 165, 33);
		contentPane.add(l7);
		
		JTextArea ta = new JTextArea();
		ta.setBounds(324, 440, 174, 74);
		contentPane.add(ta);
		
		
		
		
		JButton b1 = new JButton("SUBMIT");
		b1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), null));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/javaprojects";
					String username="root";
					String password="root";
					Connection con=DriverManager.getConnection(url,username,password);	
					PreparedStatement ps = con.prepareStatement("insert into open_acc(acc_no,ifsc_code,first_name,second_name,last_name,Address,Mobile_no,image,Deposite) values(?,?,?,?,?,?,?,?,?)");			
					InputStream is = new FileInputStream(new File(s));
					ps.setString(1,tf4.getText());
					ps.setString(2,tf5.getText());
					ps.setString(3,tf1.getText());
					
					
					ps.setString(4,tf2.getText());
					ps.setString(5,tf3.getText());
					ps.setString(6,ta.getText());
					ps.setString(7,tf6.getText());
					ps.setBlob(8,is);
					ps.setInt(9, 1000);
					
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Your Account Open Successfully..");
				}catch(Exception ee) {
					ee.printStackTrace();
				}
				
			}
		});
		b1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		b1.setForeground(Color.WHITE);
		b1.setBackground(new Color(106, 90, 205));
		b1.setBounds(120, 543, 134, 35);
		contentPane.add(b1);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), null));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
				ta.setText("");
				img_label.setText("");
				
			}
		});
		btnClear.setForeground(Color.WHITE);	
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnClear.setBackground(new Color(106, 90, 205));
		btnClear.setBounds(328, 543, 134, 35);
		contentPane.add(btnClear);
		
		JButton browse = new JButton("Browse");
		browse.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), null));
		browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png","jpeg");
		         fileChooser.addChoosableFileFilter(filter);
		         int result = fileChooser.showSaveDialog(null);
		         if(result == JFileChooser.APPROVE_OPTION){
		             File selectedFile = fileChooser.getSelectedFile();
		             String path = selectedFile.getAbsolutePath();
		             img_label.setIcon(ResizeImage(path));
		             s = path;
		              }
		         else if(result == JFileChooser.CANCEL_OPTION){
		             System.out.println("No Data");
		         }
			}
		});
		browse.setForeground(Color.WHITE);
		browse.setFont(new Font("Times New Roman", Font.BOLD, 14));
		browse.setBackground(new Color(106, 90, 205));
		browse.setBounds(707, 442, 134, 35);
		contentPane.add(browse);
		
		JLabel login_lbl_1 = new JLabel("");
		login_lbl_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null,"Are you want to close app?","Confirmation",JOptionPane.YES_NO_OPTION)==0){
					open_acc.this.dispose();
				}
			}
		});
		login_lbl_1.setIcon(new ImageIcon("D:\\java project\\InternetBanking\\Images\\exit.png"));
		login_lbl_1.setToolTipText("Exit");
		login_lbl_1.setBounds(878, 10, 28, 26);
		contentPane.add(login_lbl_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(620, 100, 276, 288);
		contentPane.add(panel);
		panel.setLayout(null);
		
		img_label = new JLabel("");
		img_label.setBounds(10, 10, 257, 277);
		panel.add(img_label);
		img_label.setBorder(new LineBorder(new Color(0, 0, 0)));
		
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
		back_label.setToolTipText("Go Bdack");
		back_label.setBounds(10, 10, 42, 33);
		contentPane.add(back_label);
	}
	public ImageIcon ResizeImage(String imgPath){
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(img_label.getWidth(), img_label.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
}
