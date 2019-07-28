package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ViewSIngleInmateWB {

	private JFrame frame;
	private JTextField txtFirstname;
	private JTextField txtCentreNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSIngleInmateWB window = new ViewSIngleInmateWB();
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
	public ViewSIngleInmateWB() {
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
		
		JButton btnLogout = new JButton("logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnLogout.setBounds(814, 38, 100, 40);
		
		panel.add(btnLogout);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(44, 89, 870, 417);
		panel.add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel headingPanel = new JPanel();
		headingPanel.setBounds(0, 0, 870, 61);
		headingPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainPanel.add(headingPanel);
		headingPanel.setLayout(null);
		
		JLabel lblAddInmateHeading = new JLabel("View Single Inmate");
		lblAddInmateHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddInmateHeading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddInmateHeading.setBounds(10, 11, 850, 43);
		headingPanel.add(lblAddInmateHeading);
		
		JPanel footerPanel = new JPanel();
		footerPanel.setBounds(0, 356, 870, 61);
		footerPanel.setLayout(null);
		footerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainPanel.add(footerPanel);
		
		JLabel lblErrorMsg = new JLabel("Error: Could not find Inmate.");
		lblErrorMsg.setForeground(Color.RED);
		lblErrorMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMsg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrorMsg.setBounds(10, 11, 850, 43);
		footerPanel.add(lblErrorMsg);
		
		JButton btnAddinmate = new JButton("Find Inmate");
		btnAddinmate.setBounds(349, 299, 172, 36);
		btnAddinmate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mainPanel.add(btnAddinmate);
		
		JLabel lblFirstname = new JLabel("Inmate ID:");
		lblFirstname.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFirstname.setBounds(245, 143, 145, 26);
		mainPanel.add(lblFirstname);
		
		txtFirstname = new JTextField();
		txtFirstname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFirstname.setBounds(420, 143, 150, 26);
		mainPanel.add(txtFirstname);
		txtFirstname.setColumns(10);
		
		JLabel lblCentreNo = new JLabel("Centre No:");
		lblCentreNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCentreNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCentreNo.setBounds(245, 200, 145, 26);
		mainPanel.add(lblCentreNo);
		
		txtCentreNo = new JTextField();
		txtCentreNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCentreNo.setColumns(10);
		txtCentreNo.setBounds(420, 200, 150, 26);
		mainPanel.add(txtCentreNo);
		
		JButton btnBack = new JButton("back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(44, 38, 100, 40);
		panel.add(btnBack);
	}
}
