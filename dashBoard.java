package airlineManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class dashBoard extends JPanel {
	JPanel textpanel, panel, centerPanel;
	JButton opt1, opt2, opt3, opt4, opt5, opt6, opt7;
	JLabel panellabel, label;

	/*
	 * bg: 1e1e1e
	 * sbg: 0x2c2c2c
	 * abg: 0x0057ff
	 */
	
	public dashBoard(final SwitchMain parent) {
		
		label = new JLabel("DASHBOARD");
		label.setForeground(new Color(0xfafafa));
//		label.setForeground(new Color(0x000000));
//		label.setFont(new Font("Hack Nerd Font Mono", Font.BOLD, 50));
		label.setFont(new Font("Fira mono", Font.BOLD, 50));

		opt1 = new JButton("Flight");
		opt1.setPreferredSize(new Dimension(300, 40));
		opt1.setFont(new Font("Hack Nerd Font Mono", Font.BOLD, 14));
//		opt1.setFont(new Font("Fira mono", Font.BOLD, 14));
		opt1.setFocusable(false);
		opt1.setBackground(new Color(0x0057ff));
		opt1.setForeground(new Color(0xfafafa));

		opt2 = new JButton("Passenger");
		opt2.setPreferredSize(new Dimension(300, 40));
		opt2.setFont(new Font("Hack Nerd Font Mono", Font.BOLD, 14));
		opt2.setFocusable(false);
		opt2.setBackground(new Color(0x0057ff));
		opt2.setForeground(new Color(0xfafafa));

		opt3 = new JButton("Booking");
		opt3.setPreferredSize(new Dimension(300, 40));
		opt3.setFont(new Font("Hack Nerd Font Mono", Font.BOLD, 14));
		opt3.setFocusable(false);
		opt3.setBackground(new Color(0x0057ff));
		opt3.setForeground(new Color(0xfafafa));

		opt7 = new JButton("Ticket");
		opt7.setPreferredSize(new Dimension(300, 40));
		opt7.setFont(new Font("Hack Nerd Font Mono", Font.BOLD, 14));
		opt7.setFocusable(false);
		opt7.setBackground(new Color(0x0057ff));
		opt7.setForeground(new Color(0xfafafa));

		opt4 = new JButton("Ticket Cancellation");
		opt4.setPreferredSize(new Dimension(300, 40));
		opt4.setFont(new Font("Hack Nerd Font Mono", Font.BOLD, 14));
		opt4.setFocusable(false);
		opt4.setBackground(new Color(0x0057ff));
		opt4.setForeground(new Color(0xfafafa));

		opt5 = new JButton("Aircraft");
		opt5.setPreferredSize(new Dimension(300, 40));
		opt5.setFont(new Font("Hack Nerd Font Mono", Font.BOLD, 14));
		opt5.setFocusable(false);
		opt5.setBackground(new Color(0x0057ff));
		opt5.setForeground(new Color(0xfafafa));

		opt6 = new JButton("Airport");
		opt6.setPreferredSize(new Dimension(300, 40));
		opt6.setFont(new Font("Hack Nerd Font Mono", Font.BOLD, 14));
		opt6.setFocusable(false);
		opt6.setBackground(new Color(0x0057ff));
		opt6.setForeground(new Color(0xfafafa));

//		-----------------  Center Panel --------------------------
		centerPanel = new JPanel();
//		centerPanel.setPreferredSize(new Dimension(600, 650));
		centerPanel.setBounds(150, 0, 600, 700);
		centerPanel.setBackground(new Color(0x2c2c2c));

		centerPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 1;
		c.anchor = GridBagConstraints.CENTER;
		centerPanel.add(label, c);

		c.gridy = 1;
		c.gridx = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(opt1, c);

		c.gridy = 2;
		c.gridx = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(opt2, c);

		c.gridy = 3;
		c.gridx = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(opt3, c);

		c.gridy = 4;
		c.gridx = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(opt6, c);

		c.gridy = 5;
		c.gridx = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(opt5, c);

		c.gridy = 6;
		c.gridx = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(opt7, c);

		c.gridy = 7;
		c.gridx = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(opt4, c);

		opt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ManageFlight obj = new ManageFlight();
//				obj.setVisible(true);
//				dispose();

				parent.switchToPanel("Panel 3");

			}
		});

		opt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				ManagePassenger obj = new ManagePassenger();
//				obj.setVisible(true);
//				dispose();

				parent.switchToPanel("Panel 4");
			}
		});

		opt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				FlightBooking obj = new FlightBooking();
//				obj.setVisible(true);
////				dispose();
				parent.switchToPanel("Panel 5");

			}
		});

		opt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				TicketCancel obj = new TicketCancel();
//				obj.setVisible(true);
////				dispose();
				
				parent.switchToPanel("Panel 9");

			}
		});

		opt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				Manage_Aircraft obj = new Manage_Aircraft();
//				obj.setVisible(true);
//				dispose();
				
				parent.switchToPanel("Panel 6");

			}
		});

		opt6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				Manage_Airport obj = new Manage_Airport();
//				obj.setVisible(true);
//				dispose();

				parent.switchToPanel("Panel 7");
				
			}
		});

		opt7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				Ticket obj = new Ticket();
//				obj.setVisible(true);
////				dispose();
				
				parent.switchToPanel("Panel 8");

			}
		});

		// adding components
//		addComponent();

		panellabel = new JLabel("<Back");
//		panellabel.setForeground(new Color(0x0057ff));
		panellabel.setForeground(new Color(0x0057ff));
		panellabel.setHorizontalAlignment(SwingConstants.CENTER);
		panellabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panellabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panellabel.setBounds(800, 13, 60, 30);


//		textpanel = new JPanel();
//		textpanel.setSize(700, 300);
//		textpanel.setBackground(new Color(0x0057ff));
//		textpanel.add(panellabel);

		panel = new JPanel();
		panel.setPreferredSize(new Dimension (900, 750));
		panel.setBackground(new Color(0x2c2c2c));
		panel.setLayout(null);
		panel.add(panellabel);
		panel.add(centerPanel);
		
//		panel.setLayout(new GridBagLayout());
//		GridBagConstraints gbc = new GridBagConstraints();
//		gbc.weightx = 1;
//		gbc.weighty = 1;
//		panel.add(centerPanel, gbc);

//		setSize(1250, 950);
		setBackground(new Color(0x1e1e1e)); //v
//		setBackground(Color.green);
//		setTitle("dash board");
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		GridBagConstraints fc = new GridBagConstraints();
		fc.weightx = 1;
		fc.weighty = 1;
		add(panel, fc);

//		add(textpanel, BorderLayout.NORTH);
//		add(panel, BorderLayout.CENTER);
		
//		add(textpanel);
//		add(panel);		

//		panel.add(centerPanel);

//		setVisible(true);

		panellabel.addMouseListener(new MouseListener() {

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

				parent.switchToPanel("Panel 1");

//				LoginPage obj = new LoginPage();
//				obj.setVisible(true);
//				dispose();
			}
		});

	}



//	public static void main(String[] args) {
//
//		new dashBoard();
//	}

}
