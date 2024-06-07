package airlineManagement;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class LoginPage extends JPanel {

	JLabel l1, l2, logo, topText, info;
	JPanel panel1, panel2, panel3, signuppanel;
	JTextField utf, tf2;
	JButton submit, signUp;
	JPasswordField pwd;

	public LoginPage(final SwitchMain parent) {

		Border border = BorderFactory.createLineBorder(Color.GREEN, 2);
//		ImageIcon originalicon = new ImageIcon("src//airlineManagement//images//airline-logo.jpg");
		ImageIcon originalicon = new ImageIcon("src//airlineManagement//images//Airplain.png");
		Image scaledicon = originalicon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(scaledicon);

		logo = new JLabel();
		logo.setIcon(icon);
		logo.setBounds(50, 100, 400, 400);
		logo.setVerticalAlignment(JLabel.CENTER);
		logo.setHorizontalAlignment(JLabel.CENTER);
//		logo.setBorder(border); 

		l1 = new JLabel();
		l1.setText("UserName");
		l1.setForeground(new Color(0xfafafa));
		l1.setBounds(130, 150, 80, 30);

		utf = new JTextField();
		utf.setBounds(130, 180, 250, 30);
		utf.setForeground(new Color(0xfafafa));
		utf.setOpaque(false);

		l2 = new JLabel();
		l2.setText("Password");
		l2.setForeground(new Color(0xfafafa));
		l2.setBounds(130, 250, 80, 30);

		pwd = new JPasswordField();
		pwd.setBounds(130, 280, 250, 30);
		pwd.setForeground(new Color(0xfafafa));
		pwd.setOpaque(false);

		submit = new JButton();
		submit.setFocusable(false);
		submit.setText("Login");
		submit.setBounds(130, 350, 80, 30);
		submit.setBackground(new Color(0x0057ff));
		submit.setForeground(new Color(0xfafafa));

		signUp = new JButton();
		signUp.setFocusable(false);
		signUp.setText("SignUp");
		signUp.setBounds(300, 540, 80, 30);
		signUp.setBackground(new Color(0x0057ff));
		signUp.setForeground(new Color(0xfafafa));

		info = new JLabel("You don't have an account?.");
		info.setForeground(new Color(0xfafafa));
		info.setBounds(130, 540, 350, 30);

		topText = new JLabel("Login");
		topText.setForeground(Color.WHITE);
		topText.setHorizontalAlignment(SwingConstants.CENTER);
		topText.setAlignmentX(Component.CENTER_ALIGNMENT);
		topText.setFont(new Font("Tahoma", Font.BOLD, 30));
		topText.setBounds(200, 50, 100, 46);

		panel2 = new JPanel();
//		panel2.setBackground(Color.YELLOW);
//		panel2.setBackground(new Color(0x5472F8));
		panel2.setBackground(new Color(0x1F274C));
//		panel2.setBackground(new Color(0x0057ff));
		panel2.setPreferredSize(new Dimension(500, 600));
		panel2.add(logo);
		panel2.setLayout(null);

		panel3 = new JPanel();
		panel3.setBackground(new Color(0x2c2c2c));
//		panel3.setOpaque(false);
		panel3.setPreferredSize(new Dimension(500, 600));
		panel3.setLayout(null);
		panel3.add(topText);
		panel3.add(l1);
		panel3.add(l2);
		panel3.add(utf);
		panel3.add(pwd);
		panel3.add(submit);
		panel3.add(info);
		panel3.add(signUp);

//		signuppanel = new JPanel();
//		signuppanel.setSize(new Dimension(1000, 650));
//		signuppanel.setBackground(Color.BLACK);
//		signuppanel.setPreferredSize(new Dimension(500, 600));
//		signuppanel.setLayout(null);
//		signuppanel.add(topText2);
//		signuppanel.add(l3);
//		signuppanel.add(firstName);
//		signuppanel.add(l4);
//		signuppanel.add(lastName);
//		signuppanel.add(l5);
//		signuppanel.add(email);
//		signuppanel.add(pl);
//		signuppanel.add(ppwd);
//		signuppanel.add(l6);
//		signuppanel.add(phone);
//		signuppanel.add(submit2);
//		signuppanel.add(info2);
//		signuppanel.add(signUp2);

		panel1 = new JPanel();
		panel1.setBackground(Color.GREEN);
		panel1.setPreferredSize(new Dimension(1000, 600));

		panel1.setLayout(new GridBagLayout());
		GridBagConstraints pg = new GridBagConstraints();
//		fc.weightx = 1;
//		fc.weighty = 1;
		pg.gridx = 0;
		pg.gridy = 0;
		panel1.add(panel2, pg);

		pg.gridx = 1;
		pg.gridy = 0;
		panel1.add(panel3, pg);

//		pg.gridx = 1;
//		pg.gridy = 0;
//		panel1.add(signuppanel, pg);

		setSize(1200, 900);
//		setName("login");
//		setLocationRelativeTo(null);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		setBackground(new Color(0x17181d));
		setBackground(new Color(0x1e1e1e));
		setLayout(new GridBagLayout());
		GridBagConstraints fc = new GridBagConstraints();
		fc.weightx = 1;
		fc.weighty = 1;
		add(panel1, fc);

		setVisible(true);

//		submit.addActionListener(this);
//		signUp.addActionListener(this);

		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				signUpAction();

				parent.switchToPanel("Panel 2");

			}
		});

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				try {
					Class.forName("com.mysql.cj.jdbc.Driver");

					String un = utf.getText();
					String pw = pwd.getText();

					String query = "select * from loginTable";

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlineManagementDB",
							"root", "password@123");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);

					while (rs.next()) {
						String username = rs.getString("username"); // admin
						String password = rs.getString("password"); // admin123

						if (un.equals(username) && pw.equals(password)) {
//							this.dispose();
//							new dashBoard().setVisible(true);

							parent.switchToPanel("Panel 10");

						} else {
//							JOptionPane.showMessageDialog(this, "UserName or Password is in correct!");
							
							JOptionPane.showInternalMessageDialog(null, "UserName or Password is incorrect!");
						}

					}

				} catch (Exception ex) {
//					ex.printStackTrace();
//					JOptionPane.showConfirmDialog(this, "Error while establishing connection!!!");
					
					JOptionPane.showInternalConfirmDialog(null, "Error while establishing connection!!!");
				}

			}
		});

	}

//	public static void main(String[] args) {
//
//		new LoginPage();
//	}
}
