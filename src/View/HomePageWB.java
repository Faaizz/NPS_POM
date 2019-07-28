package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class HomePageWB {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePageWB window = new HomePageWB();
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
	public HomePageWB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 960, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(panel);
		panel.setLayout(null);
		
		JPanel inmatesFooterPanel = new JPanel();
		inmatesFooterPanel.setBounds(45, 440, 270, 61);
		panel.add(inmatesFooterPanel);
		inmatesFooterPanel.setLayout(null);
		inmatesFooterPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel inmatesPanel = new JPanel();
		inmatesPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		inmatesPanel.setBackground(Color.WHITE);
		inmatesPanel.setBounds(45, 152, 270, 348);
		panel.add(inmatesPanel);
		inmatesPanel.setLayout(null);
		
		JPanel inmatesHeaderPanel = new JPanel();
		inmatesHeaderPanel.setBounds(0, 0, 270, 61);
		inmatesHeaderPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		inmatesPanel.add(inmatesHeaderPanel);
		inmatesHeaderPanel.setLayout(null);
		
		JLabel lblInmatesHeader = new JLabel("INMATES");
		lblInmatesHeader.setBounds(10, 11, 250, 39);
		lblInmatesHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblInmatesHeader.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblInmatesHeader.setBackground(Color.LIGHT_GRAY);
		inmatesHeaderPanel.add(lblInmatesHeader);
		
		JButton btnAddInmate = new JButton("Add Inmate");
		btnAddInmate.setBackground(Color.GREEN);
		btnAddInmate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddInmate.setBounds(0, 91, 270, 42);
		btnAddInmate.setBorder(new LineBorder(new Color(180, 180, 180)));
		inmatesPanel.add(btnAddInmate);
		
		JButton btnSingleInmate = new JButton("View Single Inmate");
		btnSingleInmate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSingleInmate.setBackground(Color.GREEN);
		btnSingleInmate.setBounds(0, 153, 270, 42);
		inmatesPanel.add(btnSingleInmate);
		
		JButton btnInmatesByCentre = new JButton("View Inmates by Centre");
		btnInmatesByCentre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInmatesByCentre.setBackground(Color.GREEN);
		btnInmatesByCentre.setBounds(0, 215, 270, 42);
		inmatesPanel.add(btnInmatesByCentre);
		
		JPanel centrePanel = new JPanel();
		centrePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		centrePanel.setBackground(Color.WHITE);
		centrePanel.setBounds(340, 152, 270, 349);
		panel.add(centrePanel);
		centrePanel.setLayout(null);
		
		JPanel centreHeaderPanel = new JPanel();
		centreHeaderPanel.setLayout(null);
		centreHeaderPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		centreHeaderPanel.setBounds(0, 0, 270, 61);
		centrePanel.add(centreHeaderPanel);
		
		JLabel lblCentreHeader = new JLabel("CENTRE");
		lblCentreHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblCentreHeader.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCentreHeader.setBackground(Color.LIGHT_GRAY);
		lblCentreHeader.setBounds(10, 11, 250, 39);
		centreHeaderPanel.add(lblCentreHeader);
		
		JPanel centreFooterPanel = new JPanel();
		centreFooterPanel.setLayout(null);
		centreFooterPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		centreFooterPanel.setBounds(0, 288, 270, 61);
		centrePanel.add(centreFooterPanel);
		
		JButton btnAddCentre = new JButton("Add Centre");
		btnAddCentre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddCentre.setBorder(new LineBorder(new Color(180, 180, 180)));
		btnAddCentre.setBackground(Color.GREEN);
		btnAddCentre.setBounds(0, 122, 270, 42);
		centrePanel.add(btnAddCentre);
		
		JButton btnViewCentre = new JButton("View Centre");
		btnViewCentre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewCentre.setBackground(Color.GREEN);
		btnViewCentre.setBounds(0, 184, 270, 42);
		centrePanel.add(btnViewCentre);
		
		JPanel pomPanel = new JPanel();
		pomPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pomPanel.setBackground(Color.WHITE);
		pomPanel.setBounds(635, 152, 270, 349);
		panel.add(pomPanel);
		pomPanel.setLayout(null);
		
		JPanel pomHeaderPanel = new JPanel();
		pomHeaderPanel.setLayout(null);
		pomHeaderPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pomHeaderPanel.setBounds(0, 0, 270, 61);
		pomPanel.add(pomHeaderPanel);
		
		JLabel lblPomHeader = new JLabel("Prerogative of Mercy");
		lblPomHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomHeader.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPomHeader.setBackground(Color.LIGHT_GRAY);
		lblPomHeader.setBounds(10, 11, 250, 39);
		pomHeaderPanel.add(lblPomHeader);
		
		JPanel pomFooterPanel = new JPanel();
		pomFooterPanel.setLayout(null);
		pomFooterPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pomFooterPanel.setBounds(0, 288, 270, 61);
		pomPanel.add(pomFooterPanel);
		
		JButton btnAllotPoints = new JButton("Allot Inmate Points");
		btnAllotPoints.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAllotPoints.setBorder(new LineBorder(new Color(180, 180, 180)));
		btnAllotPoints.setBackground(Color.GREEN);
		btnAllotPoints.setBounds(0, 91, 270, 42);
		pomPanel.add(btnAllotPoints);
		
		JButton btnInmatePoints = new JButton("View Inmate Points");
		btnInmatePoints.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInmatePoints.setBackground(Color.GREEN);
		btnInmatePoints.setBounds(0, 153, 270, 42);
		pomPanel.add(btnInmatePoints);
		
		JButton btnPardonList = new JButton("Publish Pardon List");
		btnPardonList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPardonList.setBackground(Color.GREEN);
		btnPardonList.setBounds(0, 215, 270, 42);
		pomPanel.add(btnPardonList);
		
		JLabel lblLogIn = new JLabel("Logged In as:");
		lblLogIn.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLogIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogIn.setBounds(340, 79, 130, 26);
		panel.add(lblLogIn);
		
		JLabel lblID = new JLabel("1");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblID.setBounds(480, 79, 130, 26);
		panel.add(lblID);
		
		JLabel lblOffice = new JLabel("Office:");
		lblOffice.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOffice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOffice.setBounds(340, 108, 130, 26);
		panel.add(lblOffice);
		
		JLabel lblCentre = new JLabel("Kirikiri Max");
		lblCentre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCentre.setBounds(480, 108, 130, 26);
		panel.add(lblCentre);
		
		JLabel lblHomeHeading = new JLabel("HOME PAGE");
		lblHomeHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomeHeading.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblHomeHeading.setBounds(45, 11, 860, 49);
		panel.add(lblHomeHeading);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(Color.GREEN);
		btnLogout.setForeground(Color.RED);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogout.setBounds(805, 94, 100, 40);
		panel.add(btnLogout);
	}
}
