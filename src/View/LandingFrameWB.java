package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class LandingFrameWB extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmployeeID;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LandingFrameWB frame = new LandingFrameWB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LandingFrameWB() {
		
		Color borderColor= new Color(180, 180, 180);
		
		Color deepGreen= new Color(56, 87, 35);
		
		setTitle("NPS Prerogative of Mercy");
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBorder(new LineBorder(new Color(180, 180, 180)));
		loginPanel.setBackground(Color.WHITE);
		loginPanel.setBounds(250, 45, 460, 450);
		contentPane.add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel lblPortalLogin = new JLabel("PORTAL LOGIN");
		lblPortalLogin.setForeground(deepGreen);
		lblPortalLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPortalLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortalLogin.setBackground(Color.WHITE);
		lblPortalLogin.setBounds(10, 28, 440, 53);
		loginPanel.add(lblPortalLogin);
		
		JLabel lblEmployeeID = new JLabel("Employee ID:");
		lblEmployeeID.setBounds(32, 182, 147, 36);
		loginPanel.add(lblEmployeeID);
		lblEmployeeID.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmployeeID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(32, 229, 147, 36);
		loginPanel.add(lblPassword);
		
		txtEmployeeID = new JTextField();
		txtEmployeeID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEmployeeID.setBounds(218, 187, 197, 26);
		loginPanel.add(txtEmployeeID);
		txtEmployeeID.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPassword.setColumns(10);
		txtPassword.setBounds(218, 234, 197, 26);
		loginPanel.add(txtPassword);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBackground(deepGreen);
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSignIn.setBounds(172, 332, 116, 36);
		loginPanel.add(btnSignIn);
		
		JLabel lblError = new JLabel("Could not sign you in. Please check entries. Thank You.");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(10, 105, 440, 53);
		loginPanel.add(lblError);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setBounds(761, 45, 99, 40);
		contentPane.add(btnSettings);
	}
}
