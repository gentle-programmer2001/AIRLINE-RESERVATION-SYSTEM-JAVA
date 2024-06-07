package airlineManagement;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class SignUp extends JPanel {

	JLabel l3, l4, l5, l6, pl, logo, topText2, info2;
	JPanel panel4, panel5, signuppanel;
	JTextField firstName, lastName, email, phone;
	JButton submit2, signUp2;
	JPasswordField ppwd;

	public SignUp(final SwitchMain parent) {

		Border border = BorderFactory.createLineBorder(Color.GREEN, 2);
		ImageIcon originalicon = new ImageIcon("src//airlineManagement//images//Airplain.png");
		Image scaledicon = originalicon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(scaledicon);

		logo = new JLabel();
		logo.setIcon(icon);
		logo.setBounds(50, 100, 400, 400);
		logo.setVerticalAlignment(JLabel.CENTER);
		logo.setHorizontalAlignment(JLabel.CENTER);
//		logo.setBorder(border);

//		firstName, lastName, email, phone

		l3 = new JLabel();
		l3.setText("First Name");
		l3.setForeground(new Color(0xfafafa));
		l3.setBounds(130, 100, 80, 30);

		firstName = new JTextField();
		firstName.setBounds(130, 130, 250, 30);
		firstName.setForeground(new Color(0xfafafa));
		firstName.setOpaque(false);

		l4 = new JLabel();
		l4.setText("Last Name");
		l4.setForeground(new Color(0xfafafa));
		l4.setBounds(130, 170, 80, 30);

		lastName = new JTextField();
		lastName.setBounds(130, 200, 250, 30);
		lastName.setForeground(new Color(0xfafafa));
		lastName.setOpaque(false);

		l5 = new JLabel();
		l5.setText("Email");
		l5.setForeground(new Color(0xfafafa));
		l5.setBounds(130, 240, 80, 30);

		email = new JTextField();
		email.setBounds(130, 270, 250, 30);
		email.setForeground(new Color(0xfafafa));
		email.setOpaque(false);

		pl = new JLabel();
		pl.setText("Password");
		pl.setForeground(new Color(0xfafafa));
		pl.setBounds(130, 310, 80, 30);

		ppwd = new JPasswordField();
		ppwd.setBounds(130, 340, 250, 30);
		ppwd.setForeground(new Color(0xfafafa));
		ppwd.setOpaque(false);

		l6 = new JLabel();
		l6.setText("Phone");
		l6.setForeground(new Color(0xfafafa));
		l6.setBounds(130, 370, 80, 30);

		phone = new JTextField();
		phone.setBounds(130, 400, 250, 30);
		phone.setForeground(new Color(0xfafafa));
		phone.setOpaque(false);

		submit2 = new JButton();
		submit2.setFocusable(false);
		submit2.setText("SignUp");
		submit2.setBounds(130, 450, 80, 30);
		submit2.setBackground(new Color(0x0057ff));
		submit2.setForeground(new Color(0xfafafa));

		signUp2 = new JButton();
		signUp2.setFocusable(false);
		signUp2.setText("Login");
		signUp2.setBounds(300, 540, 80, 30);
		signUp2.setBackground(new Color(0x0057ff));
		signUp2.setForeground(new Color(0xfafafa));

		info2 = new JLabel("you have an account login.");
		info2.setForeground(new Color(0xfafafa));
		info2.setBounds(130, 540, 350, 30);

		topText2 = new JLabel("SignUp");
		topText2.setForeground(Color.WHITE);
		topText2.setHorizontalAlignment(SwingConstants.CENTER);
		topText2.setAlignmentX(Component.CENTER_ALIGNMENT);
		topText2.setFont(new Font("Tahoma", Font.BOLD, 30));
		topText2.setBounds(200, 50, 150, 46);

		signuppanel = new JPanel();
		signuppanel.setBackground(new Color(0x2c2c2c));
		signuppanel.setPreferredSize(new Dimension(500, 600));
		signuppanel.setLayout(null);

		signuppanel.add(topText2);
		signuppanel.add(l3);
		signuppanel.add(firstName);
		signuppanel.add(l4);
		signuppanel.add(lastName);
		signuppanel.add(l5);
		signuppanel.add(email);
		signuppanel.add(pl);
		signuppanel.add(ppwd);
		signuppanel.add(l6);
		signuppanel.add(phone);
		signuppanel.add(submit2);
		signuppanel.add(info2);
		signuppanel.add(signUp2);

		panel5 = new JPanel();
		panel5.setBackground(new Color(0x1F274C));
//		panel5.setSize(1000, 600);
		panel5.setPreferredSize(new Dimension(500, 600));
		panel5.add(logo);
		panel5.setLayout(new GridBagLayout());

		panel4 = new JPanel();
		panel4.setBackground(Color.ORANGE);
//		panel4.setSize(1000, 600);
		panel4.setPreferredSize(new Dimension(1000, 600));
		panel4.setLayout(new GridBagLayout());
		GridBagConstraints pg = new GridBagConstraints();
//		pg.weightx = 1;
//		pg.weighty = 1;
		pg.gridx = 0;
		pg.gridy = 0;
		panel4.add(panel5, pg);
		pg.gridx = 1;
		pg.gridy = 0;
		panel4.add(signuppanel, pg);

//		panel4.add(signuppanel);

		setBackground(new Color(0x1e1e1e));
		setSize(1200, 900);
//		setTitle("SignUp");
		setLayout(null);
//		setLocationRelativeTo(null);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);

//		add(panel4);

		setLayout(new GridBagLayout());
		GridBagConstraints gb = new GridBagConstraints();
		gb.weightx = 1;
		gb.weighty = 1;
		add(panel4, gb);

//		setVisible(true);

		signUp2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				parent.switchToPanel("Panel 1");
			}
		});
		
		submit2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					insertAction();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});

	}
	
	
	String url = "jdbc:mysql://localhost:3306/airlineManagementDB";
	String uname = "root";
	String password = "password@123";

	private void insertAction() throws SQLException {
		String query = "insert into signupTable values (?, ?, ?, ?, ?)";

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
		 * firstName lastName email phone
		 */

		psd.setString(1, firstName.getText());
		psd.setString(2, lastName.getText());
		psd.setString(3, email.getText());
		psd.setString(4, ppwd.getText());
		psd.setString(5, phone.getText());

		psd.executeUpdate();

		JOptionPane.showMessageDialog(this, "data inserted Succesfully!");

		conn.close();

	}

//	public static void main(String[] args) {
//		new SignUp();
//	}

}
