package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import alumini.Alumini;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.ImageIcon;
import java.awt.Color;
public class Aluminilogin extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aluminilogin window = new Aluminilogin();
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
	public Aluminilogin() {
		getContentPane().setBackground(new Color(255, 255, 255));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		//frame = new JFrame();
		frame.setBounds(100, 100, 979, 749);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBounds(228, 154, 235, 58);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Alumni name:");
		lblNewLabel_1.setBounds(109, 239, 132, 35);
		lblNewLabel_1.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(306, 242, 187, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setBounds(126, 348, 101, 25);
		lblNewLabel_2.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(306, 346, 187, 35);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(126, 439, 145, 35);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username= textField.getText();
				String password= textField_1.getText();
				
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement stmt = conn.createStatement();
					String query1="select * from alumini where alname= ? and password =? ";
					//System.out.println(query1);
					
					PreparedStatement statement1 = conn.prepareStatement(query1);
					statement1.setString(1,username);
					statement1.setString(2,password);
					ResultSet rs = statement1.executeQuery();
					
					if(rs.next())
					{
						frame.setVisible(false);
						
						JOptionPane.showMessageDialog(null, "Login Succesfull", "Success",JOptionPane.INFORMATION_MESSAGE);
						panel1 p1 = new panel1();
						p1.setVisible(true);
						dispose();
						
////						user_homepage uh = new user_homepage(rs.getInt("USER_ID"));
//						uh.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Login Failed");
					}
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Error "+e1.getMessage(), "Error" ,JOptionPane.ERROR_MESSAGE);
					
				}
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton.setFont(new Font("Book Antiqua", Font.BOLD, 15));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new index().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(351, 441, 117, 31);
		btnNewButton_1.setFont(new Font("Book Antiqua", Font.BOLD, 15));
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Don't have an account?");
		lblNewLabel_3.setBounds(143, 542, 158, 25);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("REGISTER");
		btnNewButton_2.setBounds(321, 544, 110, 21);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new aluregister().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel label = new JLabel("New label");
		label.setBounds(159, 10, 365, 134);
		label.setIcon(new ImageIcon("D:\\swing\\pic5.jpeg"));
		getContentPane().add(label);
	}

}
