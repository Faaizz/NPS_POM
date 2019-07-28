package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.EmployeeController;
import Controller.RedirectEvent;
import Controller.RedirectEventListener;
import Model.EmployeeLogin;

public class LandingPage extends JPanel {
	
	private String errorMessage= "";
	
	private JPanel loginPanel;
	
	private JButton btnSettings;
	
	private JLabel lblPortalLogin;
	
	private JLabel lblEmployeeID;
	
	private JLabel lblPassword;
	
	private JTextField txtEmployeeID;
	
	private JPasswordField txtPassword;
	
	private JButton btnSignIn;
	
	private JLabel lblError;
	
	private ActionListener signInAction;
	
	private RedirectEventListener homePageRedirect;
	
	private RedirectEventListener settingsRedirect;
	
	
	
	public LandingPage() {
		/*
		 * Default constructor.
		 * Constructs a landing page with no error message
		 * */
		
		this.setBackground(Color.WHITE);
		
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.setLayout(null);
		
		
		//LOGIN	PANEL
		
		loginPanel = new JPanel();
		
		loginPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		loginPanel.setBackground(Color.WHITE);
		
		loginPanel.setBounds(250, 45, 460, 450);
		
		loginPanel.setLayout(null);
		
		this.add(loginPanel);
		
		//SETTINGS
		
		btnSettings = new JButton("Settings");
		
		btnSettings.setBounds(761, 45, 99, 40);
		
		btnSettings.setFont(MainFrame.SMALLLABEL);
		
		btnSettings.setBackground(MainFrame.TEALGREEN);
		
		btnSettings.setCursor(MainFrame.HANDCURSOR);
		
		btnSettings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//if(settingsRedirect != null) {
					
					RedirectEvent settings= new RedirectEvent(this);
					
					settingsRedirect.redirectActionPerformed(settings);
					
				//}
				
			}
		});
		
		
		this.add(btnSettings);
		
		//LOGIN LABEL
		
		lblPortalLogin = new JLabel("PORTAL LOGIN");
		
		lblPortalLogin.setForeground(MainFrame.HEADINGCOLOR);
		
		lblPortalLogin.setFont(MainFrame.HEADERFONT);
		
		lblPortalLogin.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblPortalLogin.setBackground(Color.WHITE);
		
		lblPortalLogin.setBounds(10, 28, 440, 53);
		
		loginPanel.add(lblPortalLogin);
		
		
		//EMPLOYEE ID LABEL
		
		lblEmployeeID = new JLabel("Employee ID:");
		
		lblEmployeeID.setBounds(32, 182, 147, 36);
		
		lblEmployeeID.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblEmployeeID.setFont(MainFrame.INPUTLABEL);
		
		loginPanel.add(lblEmployeeID);
		
		//EMPLOYEE ID INPUT
		
		txtEmployeeID = new JTextField();

		txtEmployeeID.setText("1");
		
		txtEmployeeID.setFont(MainFrame.INPUTLABEL);
		
		txtEmployeeID.setBounds(218, 187, 197, 26);
		
		txtEmployeeID.setColumns(10);	
		
		loginPanel.add(txtEmployeeID);
	
		
		//PASSWORD LABEL
		
		lblPassword = new JLabel("Password:");
		
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblPassword.setFont(MainFrame.INPUTLABEL);
		
		lblPassword.setBounds(32, 229, 147, 36);
		
		loginPanel.add(lblPassword);
		
		//PASSWORD INPUT
		
		txtPassword = new JPasswordField();
		
		txtPassword.setFont(MainFrame.INPUTLABEL);

		txtPassword.setText("Alxe8381");
		
		txtPassword.setColumns(10);
		
		txtPassword.setBounds(218, 234, 197, 26);
		
		loginPanel.add(txtPassword);
		
		//SIGN IN BUTTON
		
		btnSignIn = new JButton("Sign In");
		
		btnSignIn.setBackground(MainFrame.HEADINGCOLOR);
		
		btnSignIn.setForeground(Color.WHITE);
		
		btnSignIn.setFont(MainFrame.INPUTLABEL);
		
		btnSignIn.setBounds(172, 332, 116, 36);
		
		btnSignIn.setCursor(MainFrame.HANDCURSOR);
		
		signInAction= new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					EmployeeLogin empController= new EmployeeLogin(Integer.parseInt(txtEmployeeID.getText()), String.valueOf(txtPassword.getPassword()));

					RedirectEvent loginEvent= new RedirectEvent(this);

					if(homePageRedirect != null) {

						homePageRedirect.redirectActionPerformed(loginEvent);

					}


				}

				catch (NumberFormatException e1) {

					MainFrame.printLog(LocalDate.now() + "---" + LocalTime.now() + "---" + "LandingPage: NumberFormatException");

					errorMessage= "Sorry. An unexpected error occured";

					showError();

					e1.printStackTrace();

				}



				catch (SQLException e2) {

					MainFrame.printLog(LocalDate.now() + "---" + LocalTime.now() + "---" + "LandingPage: SQLException");

					errorMessage= "Could not sign you in. Please retry.";

					showError();

					e2.printStackTrace();

				}

				catch (ClassNotFoundException e1) {

					MainFrame.printLog(LocalDate.now() + "---" + LocalTime.now() + "---" + "LandingPage: ClassNotFoundException");

					errorMessage= "Error! Could not access configuration file.";

					e1.printStackTrace();

				}

				catch (IOException e1) {

					MainFrame.printLog(LocalDate.now() + "---" + LocalTime.now() + "---" + "LandingPage: IOException");

					errorMessage= "Error! Could not access configuration file.";

					e1.printStackTrace();

				}

				
				
			}
		};
		
		btnSignIn.addActionListener(signInAction);
		
		loginPanel.add(btnSignIn);
		
		
		//ERROR LABEL
		
		lblError = new JLabel("Could not sign you in. Please check entries. Thank You.");
		
		lblError.setForeground(Color.RED);
		
		lblError.setFont(MainFrame.FOOTERFONT);
		
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblError.setBounds(10, 105, 440, 53);
		
		lblError.setVisible(false);
		
		loginPanel.add(lblError);

	
	}
	
	public LandingPage(String errorMessage) {
		
		/*
		 * Constructs a landing page with a user specified error message
		 * */
		
		this();		//calls the default constructor
		
		this.errorMessage= errorMessage;
		
		this.showError();
	}
	
	public void showError() {
		
		lblError.setText(errorMessage);
		
		lblError.setVisible(true);
	}
	
	public void setHomePageRedirect(RedirectEventListener homePageRedirect) {
		
		this.homePageRedirect= homePageRedirect;
		
	}
	
	public void setSettingsRedirect(RedirectEventListener settingsRedirect) {
		
		this.settingsRedirect= settingsRedirect;
		
	}

}
