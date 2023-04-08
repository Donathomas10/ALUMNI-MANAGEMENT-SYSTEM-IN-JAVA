package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
//import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class panel1 extends JFrame{

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_4;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					panel1 window = new panel1();
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
	public panel1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame =this;
		frame.setBounds(100, 100, 887, 587);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 46, 839, 481);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Donation", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Donation:");
		lblNewLabel_1.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(76, 191, 98, 29);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(195, 193, 167, 29);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Purpose:");
		lblNewLabel_2.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(76, 275, 124, 23);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
//					String pass=new String(password.getPassword());
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement stmt = conn.createStatement();
					String query = "select count(donationid) from donation";
					
					ResultSet rs=stmt.executeQuery(query);
					rs.next();
					int uid = rs.getInt(1);
					int newuid = uid+1;
					
					String sql = "insert into donation values(?,?,?,?)";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setInt(1,newuid);
					ps.setString(2, textField.getText());
					ps.setString(3, textField_1.getText());
//				ps.setLong(4,Long.parseLong(phone.getText()));
					ps.setString(4,textField_2.getText());
//					ps.setString(6, pass);
					//System.out.print(pass);
					try {
						int i = ps.executeUpdate();
						System.out.println(i);
						if(i!=0) {
							JOptionPane.showMessageDialog(null, "Submitted succesfully");
							panel1 ph = new panel1();
							ph.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Failed");
						}
					}catch(Exception e1) {
						System.out.println(e);
					}
				}catch(Exception e2) {
					System.out.println(e);
				}
				
				
	
			}
		});
		btnNewButton.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnNewButton.setBounds(159, 371, 139, 33);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Alid:");
		lblNewLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		lblNewLabel.setBounds(76, 133, 74, 29);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(195, 133, 167, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(195, 269, 167, 29);
		panel.add(textField_2);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Feedback", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Feedback Form");
		lblNewLabel_3.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(62, 216, 158, 28);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					String pass=new String(password.getPassword());
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement stmt = conn.createStatement();
					String query = "select count(feedbackid) from feedback";
					
					ResultSet rs=stmt.executeQuery(query);
					rs.next();
					int uid = rs.getInt(1);
					int newuid = uid+1;
					
					String sql = "insert into feedback values(?,?,?)";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setInt(1,newuid);
					ps.setString(2, textField_4.getText());
					ps.setString(3, textField_3.getText());
//				ps.setLong(4,Long.parseLong(phone.getText()));
//					ps.setString(4,textField_2.getText());
//					ps.setString(6, pass);
					//System.out.print(pass);
					try {
						int i = ps.executeUpdate();
						System.out.println(i);
						if(i!=0) {
							JOptionPane.showMessageDialog(null, "Submitted succesfully");
							panel1 ph = new panel1();
							ph.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Failed");
						}
					}catch(Exception e1) {
						System.out.println(e);
					}
				}catch(Exception e2) {
					System.out.println(e);
				}
			}			
		});
		btnNewButton_1.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnNewButton_1.setBounds(178, 288, 118, 28);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Alid:");
		lblNewLabel_6.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(62, 111, 118, 28);
		panel_1.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(230, 118, 235, 34);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(230, 210, 235, 34);
		panel_1.add(textField_3);
	}

//	protected void setVisible(boolean b) {
//		// TODO Auto-generated method stub
//		
//	}
}
