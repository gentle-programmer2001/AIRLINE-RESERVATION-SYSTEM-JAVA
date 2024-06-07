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

public class TicketCancel extends JPanel {

	JLabel topText, l1, back;
	JButton submit;
	JTextField value;
	JPanel centerpanel;

	public TicketCancel(final SwitchMain parent) {
		setSize(1200, 900);
		setBackground(new Color(0x1e1e1e));
//		setTitle("dash board");
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);

		topText = new JLabel("Ticket Cancellation");
		topText.setForeground(Color.WHITE);
		topText.setHorizontalAlignment(SwingConstants.CENTER);
		topText.setAlignmentX(Component.CENTER_ALIGNMENT);
		topText.setFont(new Font("Tahoma", Font.BOLD, 30));
		topText.setBounds(350, 11, 340, 46);

		back = new JLabel("<Back");
		back.setForeground(new Color(0x0057ff));
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		back.setFont(new Font("Tahoma", Font.BOLD, 15));
		back.setBounds(900, 11, 60, 30);

		l1 = new JLabel();
		l1.setText("Enter Ticket ID");
//		l1.setFont(new Font("Hack Nerd Font Mono", Font.PLAIN, 14));
		l1.setFont(new Font("Tahoma", Font.BOLD, 18));
		l1.setForeground(new Color(0xfafafa));
		l1.setBounds(300, 280, 150, 30);
//		l1.setPreferredSize(new Dimension(80, 40));

		value = new JTextField();
		value.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		value.setForeground(new Color(0xfafafa));
		value.setPreferredSize(new Dimension(100, 30));
		value.setBounds(460, 280, 200, 30);

		submit = new JButton("Submit");
		submit.setPreferredSize(new Dimension(90, 30));
		submit.setFont(new Font("Tahoma", Font.BOLD, 14));
		submit.setFocusable(false);
		submit.setBackground(new Color(0x0057ff));
		submit.setForeground(new Color(0xfafafa));
		submit.setBounds(460, 350, 90, 30);

		centerpanel = new JPanel();
//		centerpanel.setSize(800, 600);
		centerpanel.setPreferredSize(new Dimension(1000, 650));
		centerpanel.setBackground(new Color(0x2c2c2c));
		centerpanel.setLayout(null);

		centerpanel.add(topText);
		centerpanel.add(back);
		centerpanel.add(l1);
		centerpanel.add(value);
		centerpanel.add(submit);

		setLayout(new GridBagLayout());
		GridBagConstraints fc = new GridBagConstraints();
		fc.weightx = 1;
		fc.weighty = 1;
		add(centerpanel, fc);

		setVisible(true);

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("deleting");
				try {
					deleteAction();
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

	private void deleteAction() throws SQLException {

		String id = value.getText();
		String query = "DELETE FROM flightBooking WHERE flightNumber=" + id;

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
			JOptionPane.showMessageDialog(this, "Ticket deleted successfully");
			conn.close();

		} catch (Exception ea) {
			JOptionPane.showMessageDialog(this, ea);
		}

	}

//	public static void main(String[] args) {
//		new TicketCancel();
//
//	}

}
