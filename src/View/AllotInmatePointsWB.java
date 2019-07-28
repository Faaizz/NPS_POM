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

public class AllotInmatePointsWB {

	private JFrame frame;
	private JTextField txtFirstname;
	private JTextField txtDay;
	private JTextField txtCentreNo;
	private JTextField txtBehaviour;
	private JTextField txtAttitude;
	private JTextField txtConduct;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllotInmatePointsWB window = new AllotInmatePointsWB();
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
	public AllotInmatePointsWB() {
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
		
		JLabel lblErrorMsg = new JLabel("Error: Could not add points.");
		lblErrorMsg.setForeground(Color.RED);
		lblErrorMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMsg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrorMsg.setBounds(10, 11, 850, 43);
		footerPanel.add(lblErrorMsg);
		
		JButton btnAddinmate = new JButton("Allot Points");
		btnAddinmate.setBounds(349, 299, 172, 36);
		btnAddinmate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mainPanel.add(btnAddinmate);
		
		JLabel lblFirstname = new JLabel("Inmate ID:");
		lblFirstname.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFirstname.setBounds(45, 95, 145, 26);
		mainPanel.add(lblFirstname);
		
		txtFirstname = new JTextField();
		txtFirstname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFirstname.setBounds(220, 95, 150, 26);
		mainPanel.add(txtFirstname);
		txtFirstname.setColumns(10);
		
		JLabel lblDOB = new JLabel("Change from old ways:");
		lblDOB.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDOB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDOB.setBounds(45, 209, 255, 26);
		mainPanel.add(lblDOB);
		
		txtDay = new JTextField();
		txtDay.setToolTipText("DD");
		txtDay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDay.setColumns(10);
		txtDay.setBounds(330, 211, 40, 26);
		mainPanel.add(txtDay);
		
		JLabel lblCentreNo = new JLabel("Centre No:");
		lblCentreNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCentreNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCentreNo.setBounds(430, 95, 145, 26);
		mainPanel.add(lblCentreNo);
		
		txtCentreNo = new JTextField();
		txtCentreNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCentreNo.setColumns(10);
		txtCentreNo.setBounds(605, 95, 150, 26);
		mainPanel.add(txtCentreNo);
		
		JLabel lblGender = new JLabel("Month:");
		lblGender.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGender.setBounds(273, 152, 145, 26);
		mainPanel.add(lblGender);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(448, 152, 155, 26);
		mainPanel.add(comboBox);
		
		JLabel lblBehaviour = new JLabel("Behaviour:");
		lblBehaviour.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBehaviour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBehaviour.setBounds(448, 207, 145, 26);
		mainPanel.add(lblBehaviour);
		
		txtBehaviour = new JTextField();
		txtBehaviour.setToolTipText("DD");
		txtBehaviour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtBehaviour.setColumns(10);
		txtBehaviour.setBounds(623, 209, 40, 26);
		mainPanel.add(txtBehaviour);
		
		JLabel lblAttitude = new JLabel("Attitude:");
		lblAttitude.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAttitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAttitude.setBounds(448, 244, 145, 26);
		mainPanel.add(lblAttitude);
		
		txtAttitude = new JTextField();
		txtAttitude.setToolTipText("DD");
		txtAttitude.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAttitude.setBounds(623, 246, 40, 26);
		mainPanel.add(txtAttitude);
		
		JLabel lblConduct = new JLabel("Conduct");
		lblConduct.setHorizontalAlignment(SwingConstants.TRAILING);
		lblConduct.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConduct.setBounds(155, 246, 145, 26);
		mainPanel.add(lblConduct);
		
		txtConduct = new JTextField();
		txtConduct.setToolTipText("DD");
		txtConduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtConduct.setColumns(10);
		txtConduct.setBounds(330, 248, 40, 26);
		mainPanel.add(txtConduct);
		
		JButton btnBack = new JButton("back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(44, 38, 100, 40);
		panel.add(btnBack);
		
		JButton btnPointsChart = new JButton("points chart");
		btnPointsChart.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnPointsChart.setBounds(405, 38, 150, 40);
		panel.add(btnPointsChart);
	}
}
