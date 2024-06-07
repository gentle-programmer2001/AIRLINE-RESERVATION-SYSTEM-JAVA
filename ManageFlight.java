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

public class ManageFlight extends JPanel {

	JTextField flightNumber, departureCity, destinationCity, departureTime, arrivalTime, aircraftType, availableSeats,
			ticketPrice;

	JLabel l1, l2, l3, l4, l5, l6, l7, l8, topText, back;
	JButton insert, update, delete, search;
	JPanel labelpanel, buttonpanel, tablepanel, centerpanel;
	JTable table;
	JScrollPane scrollpane;

	public ManageFlight(final SwitchMain parent) {

		flightNumber = new JTextField();
		flightNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		flightNumber.setPreferredSize(new Dimension(100, 30));

		departureCity = new JTextField();
		departureCity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		departureCity.setPreferredSize(new Dimension(100, 30));

		destinationCity = new JTextField();
		destinationCity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		destinationCity.setPreferredSize(new Dimension(100, 30));

		departureTime = new JTextField();
		departureTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		departureTime.setPreferredSize(new Dimension(100, 30));

		arrivalTime = new JTextField();
		arrivalTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		arrivalTime.setPreferredSize(new Dimension(100, 30));

		aircraftType = new JTextField();
		aircraftType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		aircraftType.setPreferredSize(new Dimension(100, 30));

		availableSeats = new JTextField();
		availableSeats.setFont(new Font("Tahoma", Font.PLAIN, 15));
		availableSeats.setPreferredSize(new Dimension(100, 30));

		ticketPrice = new JTextField();
		ticketPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ticketPrice.setPreferredSize(new Dimension(100, 30));

//		-----------------------------------------------------
		back = new JLabel("<Back");
		back.setForeground(new Color(0x0057ff));
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		back.setFont(new Font("Tahoma", Font.BOLD, 15));
		back.setBounds(900, 11, 60, 30);

		topText = new JLabel("Flight");
		topText.setForeground(Color.WHITE);
		topText.setHorizontalAlignment(SwingConstants.CENTER);
		topText.setAlignmentX(Component.CENTER_ALIGNMENT);
		topText.setFont(new Font("Tahoma", Font.BOLD, 30));
		topText.setBounds(462, 11, 113, 46);

		l1 = new JLabel();
		l1.setText("Flight Number");
//		l1.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		l1.setForeground(new Color(0xfafafa));
//		l1.setPreferredSize(new Dimension(80, 40));

		l2 = new JLabel();
		l2.setText("Departure City");
		l2.setForeground(new Color(0xfafafa));
//		l2.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l2.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		l2.setPreferredSize(new Dimension(80, 40));

		l3 = new JLabel();
		l3.setText("Destination City");
		l3.setForeground(new Color(0xfafafa));
//		l3.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l3.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		l3.setPreferredSize(new Dimension(80, 40));

		l4 = new JLabel();
		l4.setText("Departure Time");
		l4.setForeground(new Color(0xfafafa));
//		l4.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l4.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		l4.setPreferredSize(new Dimension(80, 40));

		l5 = new JLabel();
		l5.setText("Arrival Time");
		l5.setForeground(new Color(0xfafafa));
//		l5.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l5.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		l5.setPreferredSize(new Dimension(80, 40));

		l6 = new JLabel();
		l6.setText("Aircraft Type");
		l6.setForeground(new Color(0xfafafa));
//		l6.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l6.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		l6.setPreferredSize(new Dimension(80, 40));

		l7 = new JLabel();
		l7.setText("Available Seats");
		l7.setForeground(new Color(0xfafafa));
//		l7.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l7.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		l7.setPreferredSize(new Dimension(80, 40));

		l8 = new JLabel();
		l8.setText("Ticket Price");
		l8.setForeground(new Color(0xfafafa));
//		l8.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l8.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		l8.setPreferredSize(new Dimension(80, 40));

//		-----------------------------------------------------

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

		mp.gridx = 5;
		mp.gridy = 0;
		labelpanel.add(l6, mp);

		mp.gridx = 6;
		mp.gridy = 0;
		labelpanel.add(l7, mp);

		mp.gridx = 7;
		mp.gridy = 0;
		labelpanel.add(l8, mp);

		mp.gridx = 0;
		mp.gridy = 1;
		labelpanel.add(flightNumber, mp);

		mp.gridx = 1;
		mp.gridy = 1;
		labelpanel.add(departureCity, mp);

		mp.gridx = 2;
		mp.gridy = 1;
		labelpanel.add(destinationCity, mp);

		mp.gridx = 3;
		mp.gridy = 1;
		labelpanel.add(departureTime, mp);

		mp.gridx = 4;
		mp.gridy = 1;
		labelpanel.add(arrivalTime, mp);

		mp.gridx = 5;
		mp.gridy = 1;
		labelpanel.add(aircraftType, mp);

		mp.gridx = 6;
		mp.gridy = 1;
		labelpanel.add(availableSeats, mp);

		mp.gridx = 7;
		mp.gridy = 1;
		labelpanel.add(ticketPrice, mp);

//		labelpanel.add(l1);
//		labelpanel.add(l2);
//		labelpanel.add(l3);
//		labelpanel.add(l4);
//		labelpanel.add(l5);
//		labelpanel.add(l6);
//		labelpanel.add(l7);
//		labelpanel.add(l8);
//
//		labelpanel.add(flightNumber);
//		labelpanel.add(departureCity);
//		labelpanel.add(destinationCity);
//		labelpanel.add(departureTime);
//		labelpanel.add(arrivalTime);
//		labelpanel.add(aircraftType);
//		labelpanel.add(availableSeats);
//		labelpanel.add(ticketPrice);

//		--------------------------------------------------------------

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

//		buttonpanel.add(insert);
//		buttonpanel.add(update);
//		buttonpanel.add(delete);
//		buttonpanel.add(search);

//		--------------------------------------------------------------
		table = new JTable();
//		table.setEnabled(false);
		table.setShowGrid(true);

//		Object[] columnheader = { "1", "2", "3", "4", "5", "6", "7", "8" };

		Object[] columnheader = { "Flight Number", "Departure City", "DestinationCity", "Departure Time",
				"Arrival Time", "Aircraft Type", "Available Seats", "Ticket Price" };

		DefaultTableModel model = new DefaultTableModel();

		model.setColumnIdentifiers(columnheader);

		table.setModel(model);
		table.setForeground(new Color(0xffffff));
		table.setBackground(new Color(0x2c2c2c));
		table.setSelectionBackground(new Color(0xfafafa));
//		table.setSize(190, 150);
//		table.setBounds(50, 208, 802, 300);
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);
		;

		JScrollPane pane = new JScrollPane(table);
		pane.setForeground(new Color(0xd00412));
		pane.setBackground(new Color(0xfafafa));
		pane.setBounds(10, 283, 974, 300);

//-------------------------------------------------------------------

		centerpanel = new JPanel();
//		centerpanel.setSize(800, 600);
		centerpanel.setPreferredSize(new Dimension(1000, 650));
		centerpanel.setBackground(new Color(0x2c2c2c));
		centerpanel.setLayout(null);

		centerpanel.add(labelpanel);
		centerpanel.add(buttonpanel);
//		centerpanel.add(table);
		centerpanel.add(pane);
		centerpanel.add(topText);
		centerpanel.add(back);

		setSize(1200, 900);
//		setTitle("Manage Flight");
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setBackground(new Color(0x1e1e1e));
		setLayout(new GridBagLayout());
		GridBagConstraints fc = new GridBagConstraints();
		fc.weightx = 1;
		fc.weighty = 1;
		add(centerpanel, fc);

		setVisible(true);

//		Handling events

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
				try {
					updateAction();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					deleteAction();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

	public void insertAction() throws SQLException {
		String query = "insert into manageFlight values (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			// loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// connecting to the database

		Connection conn = DriverManager.getConnection(url, uname, password);
		PreparedStatement psd = conn.prepareStatement(query); // Creates a PreparedStatement object for sending
																// parameterized SQL statements to the database

//		flightNumber(String)
//		departureCity(String)
//		destinationCity(String)
//		departureTime(DateTime)
//		arrivalTime(DateTime)
//		aircraftType(String)
//		availableSeats(int)
//		ticketPrice (double)

		psd.setString(1, flightNumber.getText());
		psd.setString(2, departureCity.getText());
		psd.setString(3, destinationCity.getText());
		psd.setString(4, departureTime.getText());
		psd.setString(5, arrivalTime.getText());
		psd.setString(6, aircraftType.getText());
		psd.setString(7, availableSeats.getText());
		psd.setString(8, ticketPrice.getText());

		psd.executeUpdate();

		JOptionPane.showMessageDialog(this, "data inserted Succesfully!");

		conn.close();

	}

	public void searchAction() throws SQLException {
		String query = "select * from manageFlight";

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
				Object inside[] = { result.getString("flightNumber"), result.getString("departureCity"),
						result.getString("destinationCity"), result.getString("departureTime"),
						result.getString("arrivalTime"), result.getString("aircraftType"),
						result.getString("availableSeats"), result.getString("ticketPrice"),

				};
				dt.addRow(inside);
			}
		} catch (Exception ea) {
			JOptionPane.showMessageDialog(this, ea);
		}

//		flightNumber
//		departureCity
//		destinationCity
//		departureTime
//		arrivalTime
//		ircraftType
//		availableSeats
//		ticketPrice

		conn.close();

	}

	public void deleteAction() throws SQLException {

		String id = flightNumber.getText();
		String query = "delete from manageFlight where flightNumber = " + id;

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

	public void updateAction() throws SQLException {

		try {
			// loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {

//			String fn = flightNumber.getText();
//			String depac = departureCity.getText();
//			String desc = destinationCity.getText();
//			String depat = departureTime.getText();
//			String arr = arrivalTime.getText();
//			String ac = aircraftType.getText();
//			String seat = availableSeats.getText();
//			String tp = ticketPrice.getText();
//
			String query = "UPDATE manageFlight SET departureCity = ?, destinationCity = ?, departureTime = ?, arrivalTime = ?, aircraftType = ?, availableSeats = ?, ticketPrice = ? WHERE flightNumber = ?";

//			String query = "UPDATE manageFlight SET flightNumber =" +fn 
//					+ ", departureCity =" + depac
//					+ ", destinationCity= " + desc 
//					+ ", departureTime =" + depat 
//					+ ", arrivalTime =" + arr
//					+ ", aircraftType =" + ac 
//					+ ", availableSeats =" + seat 
//					+ ", ticketPrice =" + tp;

			// connecting to the database
			Connection conn = DriverManager.getConnection(url, uname, password);
//			Statement statement = conn.createStatement();

			PreparedStatement psd = conn.prepareStatement(query);

			psd.setString(1, departureCity.getText());
			psd.setString(2, destinationCity.getText());
			psd.setString(3, departureTime.getText());
			psd.setString(4, arrivalTime.getText());
			psd.setString(5, aircraftType.getText());
			psd.setString(6, availableSeats.getText());
			psd.setString(7, ticketPrice.getText());
			psd.setString(8, flightNumber.getText());

			psd.executeUpdate();
			JOptionPane.showMessageDialog(this, "Data Updated successfully");
			conn.close();

		} catch (Exception ea) {
			JOptionPane.showMessageDialog(this, ea);
			ea.printStackTrace();
		}

	}

//	public static void main(String[] args) {
//		new ManageFlight();
//	}

}
