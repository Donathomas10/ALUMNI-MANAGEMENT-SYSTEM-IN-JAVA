package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class adminpanel extends JFrame{

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminpanel window = new adminpanel();
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
	public adminpanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.setBounds(100, 100, 1298, 711);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(62, 112, 1150, 491);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Alumni", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 111, 689, 174);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "Name", "Password", "Degree", "Pass Year"
			}
		));
		
		JButton btnNewButton = new JButton("View Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
				Statement st = con.createStatement();
				String query = "select * from alumini order by ALID";
				ResultSet rs = st.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception e1) {System.out.println(e1);}
			}
		});
		btnNewButton.setBounds(81, 56, 115, 21);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Donation", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(59, 87, 655, 208);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Donationid", "Alid", "Donation", "Purpose"
			}
		));
		
		JButton btnNewButton_1 = new JButton("View details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
				Statement st = con.createStatement();
				String query = "select * from donation order by donationid";
				ResultSet rs = st.executeQuery(query);
				table_1.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception e1) {System.out.println(e1);}
			}
			
		});
		btnNewButton_1.setBounds(52, 50, 115, 21);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Feedback", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(55, 68, 755, 215);
		panel_2.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Feedbackid", "alid", "Description"
			}
		));
		
		JButton btnNewButton_2 = new JButton("view details");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
				Statement st = con.createStatement();
				String query = "select * from feedback order by feedbackid";
				ResultSet rs = st.executeQuery(query);
				table_2.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception e1) {System.out.println(e1);}
			}
		});
		btnNewButton_2.setBounds(55, 40, 117, 21);
		panel_2.add(btnNewButton_2);
	}

//	public void setVisible(boolean b) {
//		// TODO Auto-generated method stub
//		
//	}
}
