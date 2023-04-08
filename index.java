package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class index extends JFrame{

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index window = new index();
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
	public index() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		//frame = new JFrame();
		frame.setBounds(100, 100, 981, 657);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Alumni Login");
		btnNewButton.setBounds(165, 287, 262, 78);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Aluminilogin().setVisible(true);
				
			}
		});
		frame.getContentPane().setLayout(null);
		btnNewButton.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnFacultyLogin = new JButton("Faculty Login");
		btnFacultyLogin.setBounds(495, 287, 228, 78);
		btnFacultyLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new login1().setVisible(true);
				
			}
		});
		btnFacultyLogin.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		frame.getContentPane().add(btnFacultyLogin);
		
		JLabel lblNewLabel = new JLabel("ALUMNI DATABASE MANAGEMENT SYSTEM");
		lblNewLabel.setBackground(new Color(0, 139, 139));
		lblNewLabel.setBounds(119, 20, 735, 48);
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 33));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\swing\\user.jpg"));
		lblNewLabel_1.setBounds(-464, 0, 1421, 610);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
