package airlineManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchMain extends JFrame implements ActionListener {
	JPanel cards;
	CardLayout cardLayout;

	public SwitchMain() {
		setTitle("AirlineManagement");
		setSize(1250, 950);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Image icon = Toolkit.getDefaultToolkit().getImage("src//airlineManagement//images//logo2.png");
//		Image icon = Toolkit.getDefaultToolkit().getImage("src//airlineManagement//images//Airplain.png");
		setIconImage(icon);

		cardLayout = new CardLayout();
		cards = new JPanel(cardLayout);

//	        cards.add(new LoginPage(this), "Panel 1");

		cards.add(new LoginPage(this), "Panel 1");
		cards.add(new SignUp(this), "Panel 2");
		cards.add(new ManageFlight(this), "Panel 3");
		cards.add(new ManagePassenger(this), "Panel 4");
		cards.add(new FlightBooking(this), "Panel 5");
		cards.add(new Manage_Aircraft(this), "Panel 6");
		cards.add(new Manage_Airport(this), "Panel 7");
		cards.add(new Ticket(this), "Panel 8");
		cards.add(new TicketCancel(this), "Panel 9");
		cards.add(new dashBoard(this), "Panel 10");

		add(cards);
		setVisible(true);
	}

	public void switchToPanel(String panelName) {

		cardLayout.show(cards, panelName);
	}

	public void actionPerformed(ActionEvent e) {
		// This method can be used for common action handling if needed
	}

	public static void main(String[] args) {

		new SwitchMain();

	}

}
