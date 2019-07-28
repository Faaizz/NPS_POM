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

public class AddInmateWB {

	private JFrame frame;
	private JTextField txtFirstname;
	private JTextField txtLastName;
	private JTextField txtDay;
	private JTextField txtMonth;
	private JTextField txtYear;
	private JTextField txtMiddleName;
	private JTextField txtCentreNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddInmateWB window = new AddInmateWB();
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
	public AddInmateWB() {
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
		
		JLabel lblAddInmateHeading = new JLabel("Add Inmate");
		lblAddInmateHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddInmateHeading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddInmateHeading.setBounds(10, 11, 850, 43);
		headingPanel.add(lblAddInmateHeading);
		
		JPanel footerPanel = new JPanel();
		footerPanel.setBounds(0, 356, 870, 61);
		footerPanel.setLayout(null);
		footerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainPanel.add(footerPanel);
		
		JLabel lblErrorMsg = new JLabel("Error: Invalid date of birth");
		lblErrorMsg.setForeground(Color.RED);
		lblErrorMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMsg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrorMsg.setBounds(10, 11, 850, 43);
		footerPanel.add(lblErrorMsg);
		
		JButton btnAddinmate = new JButton("Add Inmate");
		btnAddinmate.setBounds(349, 299, 172, 36);
		btnAddinmate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mainPanel.add(btnAddinmate);
		
		JLabel lblFirstname = new JLabel("First Name:");
		lblFirstname.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFirstname.setBounds(45, 111, 145, 26);
		mainPanel.add(lblFirstname);
		
		txtFirstname = new JTextField();
		txtFirstname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFirstname.setBounds(220, 111, 150, 26);
		mainPanel.add(txtFirstname);
		txtFirstname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLastName.setBounds(45, 168, 145, 26);
		mainPanel.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtLastName.setColumns(10);
		txtLastName.setBounds(220, 168, 150, 26);
		mainPanel.add(txtLastName);
		
		JLabel lblDOB = new JLabel("Date of Birth:");
		lblDOB.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDOB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDOB.setBounds(45, 225, 145, 26);
		mainPanel.add(lblDOB);
		
		txtDay = new JTextField();
		txtDay.setToolTipText("DD");
		txtDay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDay.setColumns(10);
		txtDay.setBounds(220, 225, 40, 26);
		mainPanel.add(txtDay);
		
		txtMonth = new JTextField();
		txtMonth.setToolTipText("MM");
		txtMonth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMonth.setColumns(10);
		txtMonth.setBounds(270, 225, 40, 26);
		mainPanel.add(txtMonth);
		
		txtYear = new JTextField();
		txtYear.setToolTipText("YYYY");
		txtYear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtYear.setColumns(10);
		txtYear.setBounds(320, 225, 50, 26);
		mainPanel.add(txtYear);
		
		JLabel lblMiddleName = new JLabel("Middle Name:");
		lblMiddleName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMiddleName.setBounds(430, 111, 145, 26);
		mainPanel.add(lblMiddleName);
		
		txtMiddleName = new JTextField();
		txtMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMiddleName.setColumns(10);
		txtMiddleName.setBounds(605, 111, 150, 26);
		mainPanel.add(txtMiddleName);
		
		JLabel lblCentreNo = new JLabel("Centre No:");
		lblCentreNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCentreNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCentreNo.setBounds(430, 168, 145, 26);
		mainPanel.add(lblCentreNo);
		
		txtCentreNo = new JTextField();
		txtCentreNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCentreNo.setColumns(10);
		txtCentreNo.setBounds(605, 168, 150, 26);
		mainPanel.add(txtCentreNo);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGender.setBounds(430, 225, 145, 26);
		mainPanel.add(lblGender);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(605, 225, 155, 26);
		mainPanel.add(comboBox);
		
		JLabel lblId = new JLabel("Inmate ID: 1");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblId.setBounds(363, 73, 145, 19);
		mainPanel.add(lblId);
		
		JButton btnBack = new JButton("back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(44, 38, 100, 40);
		panel.add(btnBack);
	}
}
