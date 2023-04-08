package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class login1 extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login1 window = new login1();
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
	public login1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		final String s1,s2;
		frame = this;
		//frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 807, 521);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBounds(316, 97, 282, 58);
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin id:");
		lblNewLabel_1.setBounds(209, 183, 127, 25);
		lblNewLabel_1.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(399, 186, 165, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setBounds(209, 259, 127, 37);
		lblNewLabel_2.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(399, 259, 165, 30);
		frame.getContentPane().add(passwordField);
		
//		 s1 = textField.getText().toString();
//		 s2 = new String(passwordField.getPassword());
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement stmt = conn.createStatement();
					String query1="select * from adminlog where adminid='"+textField.getText()+"' and password = '"+passwordField.getText()+"' ";
//					System.out.println(query1);
					ResultSet rs = stmt.executeQuery(query1);
					
					if(rs.next())
					{
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null, "Login Succesfull");
						adminpanel ap = new adminpanel();
						ap.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Login Failed");
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Error "+e1.getMessage(), "Error" ,JOptionPane.ERROR_MESSAGE);
					
				}
			}
			});
		btnNewButton.setBounds(250, 347, 99, 30);
		btnNewButton.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new index().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(409, 350, 120, 25);
		btnNewButton_1.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(175, 10, 256, 100);
		lblNewLabel_3.setIcon(new ImageIcon("D:\\swing\\pic3.jpg"));
		frame.getContentPane().add(lblNewLabel_3);
	}
}
