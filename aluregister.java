package demo;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class aluregister extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aluregister window = new aluregister();
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
	public aluregister() {
		getContentPane().setBackground(new Color(255, 255, 255));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		//frame = new JFrame();
		frame.setBounds(100, 100, 1080, 1000);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ALUMINI REGISTRATION");
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblNewLabel.setBounds(121, 125, 397, 63);
		frame.getContentPane().add(lblNewLabel);
		
//		JLabel lblNewLabel_1 = new JLabel("Aluminid:");
//		lblNewLabel_1.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
//		lblNewLabel_1.setBounds(112, 186, 133, 32);
//		frame.getContentPane().add(lblNewLabel_1);
		
//		textField = new JTextField();
//		textField.setBounds(279, 186, 165, 32);
//		frame.getContentPane().add(textField);
//		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(57, 184, 102, 32);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(266, 188, 164, 32);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(57, 244, 102, 25);
		frame.getContentPane().add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(265, 244, 165, 32);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("Degree:");
		lblNewLabel_4.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(57, 312, 79, 25);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Pass-out year");
		lblNewLabel_5.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(57, 397, 138, 25);
		frame.getContentPane().add(lblNewLabel_5);
		

		final JComboBox degree = new JComboBox();
		degree.setModel(new DefaultComboBoxModel(new String[] {"MCA", "MSC", "MSW"}));
		degree.setBounds(265, 311, 165, 32);
		getContentPane().add(degree);
		
		final JComboBox passyear = new JComboBox();
		passyear.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		passyear.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023"}));
		passyear.setBounds(266, 395, 165, 32);
		frame.getContentPane().add(passyear);
		
		JButton btnNewButton = new JButton("SIGN-IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String pass=new String(passwordField.getPassword());
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement stmt = conn.createStatement();
					String query = "select count(alid) from alumini";
					
					ResultSet rs = stmt.executeQuery(query);
					int aid,newaid = 0;
					while(rs.next())
					{
						aid = rs.getInt(1);
						newaid = aid+1;
					}
					
					String sql = "insert into alumini values(?,?,?,?,?)";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setInt(1,newaid);
					ps.setString(2, textField_1.getText());
					ps.setString(3, pass);
					ps.setString(4,degree.getSelectedItem().toString());
					ps.setString(5, passyear.getSelectedItem().toString());
					//System.out.print(pass);
					
						int i = ps.executeUpdate();
						System.out.println(i);
						if(i!=0) {
							//frame.setVisible(false);
							JOptionPane.showMessageDialog(null, "Data inserted succesfully","Success", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							//frame.setVisible(false);
							JOptionPane.showMessageDialog(null, "Data Insertion Failed","Error", JOptionPane.ERROR_MESSAGE);
						}
					
				}catch(Exception e1) {
					System.out.println(e1);
					JOptionPane.showMessageDialog(null, "Data Insertion Failed","Error"+e1.getMessage(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnNewButton.setBounds(107, 476, 139, 32);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new index().setVisible(true);
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnNewButton_1.setBounds(331, 476, 131, 32);
		frame.getContentPane().add(btnNewButton_1);
		
		
		JLabel lblNewLabel_6 = new JLabel("Already have an account?");
		lblNewLabel_6.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(148, 547, 208, 25);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton_2 = new JButton("LOGIN");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Aluminilogin().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		btnNewButton_2.setBounds(366, 550, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\swing\\pic5.jpeg"));
		lblNewLabel_1.setBounds(76, 10, 352, 105);
		getContentPane().add(lblNewLabel_1);
		
	}
}
