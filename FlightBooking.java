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

/*
 * bg: 0x17181d
 * sbg: 0x2c2c2c
 * abg: 0x0057ff
 */

public class FlightBooking extends JPanel {

	JTextField bookingID, flightNumber, passengerID, seatNumber, bookingStatus, bookingDate;

	JLabel l1, l2, l3, l4, l5, l6, topText, back;
	JButton insert, update, delete, search, save, reset;
	JPanel labelpanel, buttonpanel, tablepanel, centerpanel;
	JTable table;
	JScrollPane scrollpane;

	/*
	 * bookingID(String) flightNumber(String) passengerID(String) seatNumber(String)
	 * bookingStatus(String) bookingDate(String)
	 */

	public FlightBooking(final SwitchMain parent) {
		setSize(1200, 900);
//		setTitle("dash board");
//		setBackground(new Color(0x17181d));
		setBackground(new Color(0x1e1e1e));
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);

		topText = new JLabel("Flight Booking");
		topText.setForeground(Color.WHITE);
		topText.setHorizontalAlignment(SwingConstants.CENTER);
		topText.setAlignmentX(Component.CENTER_ALIGNMENT);
		topText.setFont(new Font("Tahoma", Font.BOLD, 30));
		topText.setBounds(400, 11, 240, 46);

		back = new JLabel("<Back");
//		back.setForeground(Color.WHITE);
		back.setForeground(new Color(0x0057ff));
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		back.setFont(new Font("Tahoma", Font.BOLD, 15));
		back.setBounds(900, 11, 60, 30);

		l1 = new JLabel();
		l1.setText("BookingID");
//		l1.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		l1.setForeground(new Color(0xfafafa));
//		l1.setPreferredSize(new Dimension(80, 40));

		l2 = new JLabel();
		l2.setText("Flight Number");
		l2.setForeground(new Color(0xfafafa));
//		l2.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l2.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		l2.setPreferredSize(new Dimension(80, 40));

		l3 = new JLabel();
		l3.setText("PassengerID");
		l3.setForeground(new Color(0xfafafa));
//		l3.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l3.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		l3.setPreferredSize(new Dimension(80, 40));

		l4 = new JLabel();
		l4.setText("Seat Number");
		l4.setForeground(new Color(0xfafafa));
//		l4.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l4.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		l4.setPreferredSize(new Dimension(80, 40));

		l5 = new JLabel();
		l5.setText("Booking Status");
		l5.setForeground(new Color(0xfafafa));
//		l5.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l5.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		l5.setPreferredSize(new Dimension(80, 40));

		l6 = new JLabel();
		l6.setText("Booking Date");
		l6.setForeground(new Color(0xfafafa));
//		l6.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l6.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		l6.setPreferredSize(new Dimension(80, 40));

		bookingID = new JTextField();
		bookingID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bookingID.setPreferredSize(new Dimension(100, 30));
//		bookingID.setForeground(new Color(0xfafafa));
//		bookingID.setOpaque(false);


		flightNumber = new JTextField();
		flightNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		flightNumber.setPreferredSize(new Dimension(100, 30));
//		flightNumber.setForeground(new Color(0xfafafa));
//		flightNumber.setOpaque(false);


		passengerID = new JTextField();
		passengerID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passengerID.setPreferredSize(new Dimension(100, 30));
//		passengerID.setForeground(new Color(0xfafafa));
//		passengerID.setOpaque(false);


		seatNumber = new JTextField();
		seatNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		seatNumber.setPreferredSize(new Dimension(100, 30));
//		seatNumber.setForeground(new Color(0xfafafa));
//		seatNumber.setOpaque(false);


		bookingStatus = new JTextField();
		bookingStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bookingStatus.setPreferredSize(new Dimension(100, 30));
//		bookingStatus.setForeground(new Color(0xfafafa));
//		bookingStatus.setOpaque(false);

		bookingDate = new JTextField();
		bookingDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bookingDate.setPreferredSize(new Dimension(100, 30));
//		bookingDate.setForeground(new Color(0xfafafa));
//		bookingDate.setOpaque(false);


		labelpanel = new JPanel();
		labelpanel.setLocation(10, 91);
		labelpanel.setSize(974, 70);
//		labelpanel.setBackground(new Color(0x4d148c));
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

		mp.gridx = 0;
		mp.gridy = 1;
		labelpanel.add(bookingID, mp);

		mp.gridx = 1;
		mp.gridy = 1;
		labelpanel.add(flightNumber, mp);

		mp.gridx = 2;
		mp.gridy = 1;
		labelpanel.add(passengerID, mp);

		mp.gridx = 3;
		mp.gridy = 1;
		labelpanel.add(seatNumber, mp);

		mp.gridx = 4;
		mp.gridy = 1;
		labelpanel.add(bookingStatus, mp);

		mp.gridx = 5;
		mp.gridy = 1;
		labelpanel.add(bookingDate, mp);

//		insert = new JButton("Insert");
//		insert.setBounds(50, 11, 90, 40);
////		insert.setPreferredSize(new Dimension(80, 40));
//		insert.setFont(new Font("Hack Nerd Font Mono", Font.BOLD, 14));
//		insert.setFocusable(false);
//		insert.setBackground(new Color(0x4d148c));
//		insert.setForeground(new Color(0xfafafa));
//
//		update = new JButton("Update");
//		update.setBounds(194, 11, 90, 40);
////		update.setPreferredSize(new Dimension(80, 40));
//		update.setFont(new Font("Hack Nerd Font Mono", Font.BOLD, 14));
//		update.setFocusable(false);
//		update.setBackground(new Color(0x4d148c));
//		update.setForeground(new Color(0xfafafa));
//
//		delete = new JButton("Delete");
//		delete.setBounds(339, 11, 90, 40);
////		delete.setPreferredSize(new Dimension(80, 40));
//		delete.setFont(new Font("Hack Nerd Font Mono", Font.BOLD, 14));
//		delete.setFocusable(false);
//		delete.setBackground(new Color(0x4d148c));
//		delete.setForeground(new Color(0xfafafa));

		search = new JButton("Search");
		search.setBounds(481, 11, 90, 40);
//		search.setPreferredSize(new Dimension(80, 40));
		search.setFont(new Font("Hack Nerd Font Mono", Font.BOLD, 14));
		search.setFocusable(false);
		search.setBackground(new Color(0x0057ff));
		search.setForeground(new Color(0xfafafa));

		save = new JButton("Save");
//		save.setBounds(481, 11, 90, 40);
		save.setPreferredSize(new Dimension(90, 30));
		save.setFont(new Font("Hack Nerd Font Mono", Font.BOLD, 14));
		save.setFocusable(false);
		save.setBackground(new Color(0x0057ff));
		save.setForeground(new Color(0xfafafa));

		reset = new JButton("Reset");
//		reset.setBounds(481, 11, 90, 40);
		reset.setPreferredSize(new Dimension(90, 30));
		reset.setFont(new Font("Hack Nerd Font Mono", Font.BOLD, 14));
		reset.setFocusable(false);
		reset.setBackground(new Color(0x0057ff));
		reset.setForeground(new Color(0xfafafa));

		buttonpanel = new JPanel();
		buttonpanel.setBounds(226, 184, 602, 64);
//		buttonpanel.setBackground(new Color(0xf2ca18));
		buttonpanel.setBackground(new Color(0x2c2c2c));
		buttonpanel.setLayout(null);

		buttonpanel.setLayout(new GridBagLayout());
		GridBagConstraints bp = new GridBagConstraints();
		bp.weightx = 1;
		bp.weighty = 1;

		bp.gridx = 0;
		bp.gridy = 0;
		buttonpanel.add(save, bp);

		bp.gridx = 1;
		bp.gridy = 0;
		buttonpanel.add(reset, bp);

		bp.gridx = 2;
		bp.gridy = 0;
		buttonpanel.add(search, bp);
		
		
//		--- creating a table ---

		table = new JTable();
//			table.setEnabled(false);
		table.setShowGrid(true);

		Object[] columnheader = { "Booking ID", "Flight Number", "PassengerID", "Seat Number", "Booking Status",
				"Booking Date" };

		DefaultTableModel model = new DefaultTableModel();

		model.setColumnIdentifiers(columnheader);

		table.setModel(model);
		table.setForeground(new Color(0xffffff));
//		table.setBackground(new Color(0xd00412));
		table.setBackground(new Color(0x2c2c2c));
		table.setSelectionBackground(new Color(0xfafafa));
//			table.setSize(190, 150);
//			table.setBounds(50, 208, 802, 300);
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);

		JScrollPane pane = new JScrollPane(table);
		pane.setForeground(new Color(0xd00412));
//		pane.setBackground(new Color(0xfafafa));
		pane.setBackground(new Color(0x2c2c2c));
		pane.setBounds(10, 283, 974, 300);

		centerpanel = new JPanel();
//			centerpanel.setSize(800, 600);
		centerpanel.setPreferredSize(new Dimension(1000, 650));
		centerpanel.setBackground(new Color(0x2c2c2c));
//		centerpanel.setBackground(new Color(0x17181d));
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

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("inserting");
				try {
					saveAction();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("inserting");
				try {
					resetAction();
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

	private void saveAction() throws SQLException {
		String query = "insert into flightBooking values (?, ?, ?, ?, ?, ?)";

		try {
			// loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// connecting to the database

		Connection conn = DriverManager.getConnection(url, uname, password);
		PreparedStatement psd = conn.prepareStatement(query);

		/*
		 * bookingID(String) flightNumber(String) passengerID(String) seatNumber(String)
		 * bookingStatus(String) bookingDate(String)
		 * 
		 */
	
		
		String value1 = bookingID.getText();
		
		try {
			Integer.parseInt(value1);
		} catch (NumberFormatException e) {
			
//			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "BookingID is not an integer");
			
		}
		
		String value2 = flightNumber.getText();
		
		try {
			Integer.parseInt(value2);
		} catch (NumberFormatException e) {
			
//			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "flightNumber is not an integer");
			
		}
		
		String value3 = passengerID.getText();
		
		try {
			Integer.parseInt(value3);
		} catch (NumberFormatException e) {
			
//			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "passengerID is not an integer");
			
		}
		
		String value4 = seatNumber.getText();
		
		try {
			Integer.parseInt(value4);
		} catch (NumberFormatException e) {
			
//			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "seatNumber is not an integer");
			
		}
		
//		String value5 = bookingID.getText();
//		
//		try {
//			Integer.parseInt(value5);
//		} catch (NumberFormatException e) {
//			
////			e.printStackTrace();
//			JOptionPane.showMessageDialog(this, "BookingID is not an integer");
//			
//		}
//		
//		String value6 = bookingID.getText();
//		
//		try {
//			Integer.parseInt(value6);
//		} catch (NumberFormatException e) {
//			
////			e.printStackTrace();
//			JOptionPane.showMessageDialog(this, "BookingID is not an integer");
//			
//		}

		psd.setString(1, value1);
		psd.setString(2, value2);
		psd.setString(3, value3);
		psd.setString(4, value4);
		psd.setString(5, bookingStatus.getText());
		psd.setString(6, bookingDate.getText());
		
//		--------------------
		
//		psd.setString(1, bookingID.getText());
//		psd.setString(2, flightNumber.getText());
//		psd.setString(3, passengerID.getText());
//		psd.setString(4, seatNumber.getText());
//		psd.setString(5, bookingStatus.getText());
//		psd.setString(6, bookingDate.getText());
		
//		--------------------

		psd.executeUpdate();

		JOptionPane.showMessageDialog(this, "data inserted Succesfully!");

		conn.close();

	}

	private void resetAction() throws SQLException {

		bookingID.setText("");
		flightNumber.setText("");
		passengerID.setText("");
		seatNumber.setText("");
		bookingStatus.setText("");
		bookingDate.setText("");

	}

	private void searchAction() throws SQLException {
		String query = "select * from flightBooking";

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

			dt.setRowCount(0);

			while (result.next()) {
				Object inside[] = { result.getString("bookingID"),

						result.getString("flightNumber"), result.getString("passengerID"),
						result.getString("seatNumber"), result.getString("bookingStatus"),
						result.getString("bookingDate")

				};
				dt.addRow(inside);
			}
		} catch (Exception ea) {
			JOptionPane.showMessageDialog(this, ea);
		}

		conn.close();

	}

//	public static void main(String[] args) {
//		new FlightBooking();
//
//	}

}
