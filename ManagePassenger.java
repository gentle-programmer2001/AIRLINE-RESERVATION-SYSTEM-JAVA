package airlineManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.*;
//import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManagePassenger extends JPanel {

	JTextField passengerID, firstName, lastName, email, phone;

	JLabel l1, l2, l3, l4, l5, topText, back;
	JButton insert, update, delete, search;
	JPanel labelpanel, buttonpanel, tablepanel, centerpanel;
	JTable table;
	JScrollPane scrollpane;

	/*
	 * passengerID(String) firstName(String) lastName(String) email(String)
	 * phone(String)
	 * 
	 */

	public ManagePassenger(final SwitchMain parent) {
		setSize(1200, 900);
//		setTitle("Manage Passenger");
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBackground(new Color(0x1e1e1e));

		topText = new JLabel("Passenger");
		topText.setForeground(Color.WHITE);
		topText.setHorizontalAlignment(SwingConstants.CENTER);
		topText.setAlignmentX(Component.CENTER_ALIGNMENT);
		topText.setFont(new Font("Tahoma", Font.BOLD, 30));
		topText.setBounds(400, 11, 200, 46);

		back = new JLabel("<Back");
		back.setForeground(new Color(0x0057ff));
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		back.setFont(new Font("Tahoma", Font.BOLD, 15));
		back.setBounds(900, 11, 60, 30);

		l1 = new JLabel();
		l1.setText("PassengerID");
//		l1.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		l1.setForeground(new Color(0xfafafa));
//		l1.setPreferredSize(new Dimension(80, 40));

		l2 = new JLabel();
		l2.setText("FirstName");
		l2.setForeground(new Color(0xfafafa));
//		l2.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l2.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		l2.setPreferredSize(new Dimension(80, 40));

		l3 = new JLabel();
		l3.setText("LastName");
		l3.setForeground(new Color(0xfafafa));
//		l3.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l3.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		l3.setPreferredSize(new Dimension(80, 40));

		l4 = new JLabel();
		l4.setText("Email");
		l4.setForeground(new Color(0xfafafa));
//		l4.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l4.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		l4.setPreferredSize(new Dimension(80, 40));

		l5 = new JLabel();
		l5.setText("Phone");
		l5.setForeground(new Color(0xfafafa));
//		l5.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l5.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		l5.setPreferredSize(new Dimension(80, 40));

		passengerID = new JTextField();
		passengerID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passengerID.setPreferredSize(new Dimension(100, 30));
		passengerID.setForeground(Color.WHITE);

		firstName = new JTextField();
		firstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstName.setPreferredSize(new Dimension(100, 30));

		lastName = new JTextField();
		lastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastName.setPreferredSize(new Dimension(100, 30));

		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		email.setPreferredSize(new Dimension(100, 30));

		phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phone.setPreferredSize(new Dimension(100, 30));

		labelpanel = new JPanel();
		labelpanel.setLocation(10, 91);
		labelpanel.setSize(974, 70);
		labelpanel.setBackground(new Color(0x2c2c2c));

		labelpanel.setLayout(new GridBagLayout());
		GridBagConstraints mp = new GridBagConstraints();
		mp.weightx = 1;
		mp.weighty = 1;
		mp.gridx = 0;
		mp.gridy = 0;
		labelpanel.add(l1, mp);

		mp.gridx = 1;
		mp.gridy = 0;
		labelpanel.add(l2, mp);

		mp.gridx = 2;
		mp.gridy = 0;
		labelpanel.add(l3, mp);

		mp.gridx = 3;
		mp.gridy = 0;
		labelpanel.add(l4, mp);

		mp.gridx = 4;
		mp.gridy = 0;
		labelpanel.add(l5, mp);

		mp.gridx = 0;
		mp.gridy = 1;
		labelpanel.add(passengerID, mp);

		mp.gridx = 1;
		mp.gridy = 1;
		labelpanel.add(firstName, mp);

		mp.gridx = 2;
		mp.gridy = 1;
		labelpanel.add(lastName, mp);

		mp.gridx = 3;
		mp.gridy = 1;
		labelpanel.add(email, mp);

		mp.gridx = 4;
		mp.gridy = 1;
		labelpanel.add(phone, mp);

		insert = new JButton("Insert");
		insert.setBounds(50, 11, 90, 40);
//		insert.setPreferredSize(new Dimension(80, 40));
		insert.setFont(new Font("Hack Nerd Font Mono", Font.BOLD, 14));
		insert.setFocusable(false);
		insert.setBackground(new Color(0x0057ff));
		insert.setForeground(new Color(0xfafafa));

		update = new JButton("Update");
		update.setBounds(194, 11, 90, 40);
//		update.setPreferredSize(new Dimension(80, 40));
		update.setFont(new Font("Hack Nerd Font Mono", Font.BOLD, 14));
		update.setFocusable(false);
		update.setBackground(new Color(0x0057ff));
		update.setForeground(new Color(0xfafafa));

		delete = new JButton("Delete");
		delete.setBounds(339, 11, 90, 40);
//		delete.setPreferredSize(new Dimension(80, 40));
		delete.setFont(new Font("Hack Nerd Font Mono", Font.BOLD, 14));
		delete.setFocusable(false);
		delete.setBackground(new Color(0x0057ff));
		delete.setForeground(new Color(0xfafafa));

		search = new JButton("Search");
		search.setBounds(481, 11, 90, 40);
//		search.setPreferredSize(new Dimension(80, 40));
		search.setFont(new Font("Hack Nerd Font Mono", Font.BOLD, 14));
		search.setFocusable(false);
		search.setBackground(new Color(0x0057ff));
		search.setForeground(new Color(0xfafafa));

		buttonpanel = new JPanel();
		buttonpanel.setBounds(226, 184, 602, 64);
		buttonpanel.setBackground(new Color(0x2c2c2c));
		buttonpanel.setLayout(null);

		buttonpanel.setLayout(new GridBagLayout());
		GridBagConstraints bp = new GridBagConstraints();
		bp.weightx = 1;
		// bp.weighty = 1;
		bp.gridx = 0;
		bp.gridy = 0;
		buttonpanel.add(insert, bp);

		bp.gridx = 1;
		bp.gridy = 0;
		buttonpanel.add(update, bp);

		bp.gridx = 2;
		bp.gridy = 0;
		buttonpanel.add(delete, bp);

		bp.gridx = 3;
		bp.gridy = 0;
		buttonpanel.add(search, bp);

		table = new JTable();
//			table.setEnabled(false);
		table.setShowGrid(true);

		Object[] columnheader = { "Passenger ID", "First Name", "Last Name", "Email", "Phone" };

		DefaultTableModel model = new DefaultTableModel();

		model.setColumnIdentifiers(columnheader);

		table.setModel(model);
		table.setForeground(new Color(0xffffff));
		table.setBackground(new Color(0x2c2c2c));
		table.setSelectionBackground(new Color(0xfafafa));
//			table.setSize(190, 150);
//			table.setBounds(50, 208, 802, 300);
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);

		JScrollPane pane = new JScrollPane(table);
		pane.setForeground(new Color(0xd00412));
		pane.setBackground(new Color(0xfafafa));
		pane.setBounds(10, 283, 974, 300);

		centerpanel = new JPanel();
//			centerpanel.setSize(800, 600);
		centerpanel.setPreferredSize(new Dimension(1000, 650));
		centerpanel.setBackground(new Color(0x2c2c2c));
//		centerpanel.setOpaque(false);
		centerpanel.setLayout(null);

		centerpanel.add(labelpanel);
		centerpanel.add(buttonpanel);
//			centerpanel.add(table);
		centerpanel.add(pane);
		centerpanel.add(topText);
		centerpanel.add(back);

		setLayout(new GridBagLayout());
		GridBagConstraints fc = new GridBagConstraints();
		fc.weightx = 1;
		fc.weighty = 1;
		add(centerpanel, fc);

		setVisible(true);

		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("inserting");
				try {
					insertAction();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("inserting");
				try {
					updateAction();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("inserting");
				try {
					deleteAction();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("inserting");
				try {
					searchAction();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		back.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseClicked(MouseEvent e) {

//				dashBoard obj = new dashBoard();
//				obj.setVisible(true);
//				dispose();
				
				parent.switchToPanel("Panel 10");
				
			}
		});

	}

	String url = "jdbc:mysql://localhost:3306/airlineManagementDB"; // jdbc url of the database
	String uname = "root";
	String password = "password@123";

	private void insertAction() throws SQLException {
		String query = "insert into managePassenger values (?, ?, ?, ?, ?)";

		try {
			// loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// connecting to the database

		Connection conn = DriverManager.getConnection(url, uname, password);
		PreparedStatement psd = conn.prepareStatement(query); // Creates a PreparedStatement object for sending

		/*
		 * passengerID firstName lastName email phone;
		 */

		psd.setString(1, passengerID.getText());
		psd.setString(2, firstName.getText());
		psd.setString(3, lastName.getText());
		psd.setString(4, email.getText());
		psd.setString(5, phone.getText());

		psd.executeUpdate();

		JOptionPane.showMessageDialog(this, "data inserted Succesfully!");

		conn.close();

	}

	private void updateAction() throws SQLException {

		try {
			// loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {

			String query = "UPDATE managePassenger SET firstName = ?, lastName = ?, email = ?, phone = ? WHERE passengerID = ?";

			// connecting to the database
			Connection conn = DriverManager.getConnection(url, uname, password);
//			Statement statement = conn.createStatement();

			PreparedStatement psd = conn.prepareStatement(query);

			psd.setString(1, firstName.getText());
			psd.setString(2, lastName.getText());
			psd.setString(3, email.getText());
			psd.setString(4, phone.getText());
			psd.setString(5, passengerID.getText());

			psd.executeUpdate();
			JOptionPane.showMessageDialog(this, "Data Updated successfully");
			conn.close();

		} catch (Exception ea) {
			JOptionPane.showMessageDialog(this, ea);
			ea.printStackTrace();
		}

	}

	private void searchAction() throws SQLException {
		String query = "select * from managePassenger";

		try {
			// loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// connecting to the database
		Connection conn = DriverManager.getConnection(url, uname, password);
//		Statement statement = conn.createStatement(); // initiating the instance to send request to the database

		PreparedStatement psd = conn.prepareStatement(query); // Creates a PreparedStatement object for sending
																// parameterized SQL statements to the database
		ResultSet result = psd.executeQuery();

		try {
			DefaultTableModel dt = (DefaultTableModel) table.getModel();

//		DefaultTableModel model  = new DefaultTableModel();
//		table.getModel();

			dt.setRowCount(0);

			while (result.next()) {
				Object inside[] = { result.getString("passengerID"), result.getString("firstName"),
						result.getString("lastName"), result.getString("email"), result.getString("phone")

				};
				dt.addRow(inside);
			}
		} catch (Exception ea) {
			JOptionPane.showMessageDialog(this, ea);
		}

		conn.close();

	}

	private void deleteAction() throws SQLException {

		String id = passengerID.getText();
		String query = "delete from managePassenger where passengerID = " + id;

		try {
			// loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			// connecting to the database
			Connection conn = DriverManager.getConnection(url, uname, password);
//			Statement statement = conn.createStatement();

			PreparedStatement psd = conn.prepareStatement(query);
			psd.executeUpdate();
			JOptionPane.showMessageDialog(this, "Data deleted successfully");
			conn.close();

		} catch (Exception ea) {
			JOptionPane.showMessageDialog(this, ea);
		}

	}

//	public static void main(String[] args) {
//		new ManagePassenger();
//	}

}
