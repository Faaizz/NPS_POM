package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.DefaultsController;
import Controller.RedirectEvent;
import Controller.RedirectEventListener;
import Model.CentreMethods;
import Model.Defaults;

public class Settings extends JPanel {
	
	
	private JButton btnBack;
	
	private JPanel mainPanel;
	
	private JPanel headingPanel;
	
	private JLabel lblSettingsHeading;
	
	private JLabel lblServerAdd;
	
	private JTextField txtServerAdd;
	
	private JLabel lblUsername;
	
	private JTextField txtUsername;
	
	private JLabel lblServerPort;
	
	private JTextField txtServerPort;
	
	private JLabel lblPassword;
	
	private JTextField txtPassword;
	
	private JLabel lblDatabaseName;
	
	private JTextField txtDatabaseName;
	
	private JButton btnSettings;
	
	private JLabel lblErrorMsg;
	
	private JPanel footerPanel;
	
	
	//	REDIRECT LISENERS
	
	private RedirectEventListener backRedirect;
	
	private RedirectEventListener SettingsRedirect;
	
	
	public void setBackRedirect(RedirectEventListener backRedirect) {
		
		this.backRedirect= backRedirect;
		
	}
	
	
	public void setSettingsRedirect(RedirectEventListener SettingsRedirect) {
		
		this.SettingsRedirect= SettingsRedirect;
		
	}
	
	
	
	public Settings() {
		
		Defaults myDefaults;
		
		try {
			
			myDefaults = DefaultsController.getDefaults();
			
			btnBack = new JButton("back");
			
			btnBack.setFont(MainFrame.SMALLLABEL);
			
			btnBack.setBackground(MainFrame.TEALGREEN);
			
			btnBack.setCursor(MainFrame.HANDCURSOR);
			
			btnBack.setBounds(44, 38, 100, 40);
			
			btnBack.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					RedirectEvent backEvent= new RedirectEvent(this);
					
					backRedirect.redirectActionPerformed(backEvent);
					
				}
			});
			
			this.add(btnBack);
			
			
			//PANEL
			
			mainPanel = new JPanel();
			
			mainPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
			
			mainPanel.setBackground(Color.WHITE);
			
			mainPanel.setBounds(44, 89, 870, 417);

			mainPanel.setLayout(null);
			
			this.add(mainPanel);
			
			//HEADING	PANEL
			
			headingPanel = new JPanel();
			
			headingPanel.setBounds(0, 0, 870, 61);
			
			headingPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
			
			headingPanel.setLayout(null);
			
			mainPanel.add(headingPanel);
			
			
			lblSettingsHeading = new JLabel("Settings");
			
			lblSettingsHeading.setHorizontalAlignment(SwingConstants.CENTER);
			
			lblSettingsHeading.setFont(MainFrame.HEADERFONT);
			
			lblSettingsHeading.setForeground(MainFrame.HEADINGCOLOR);
			
			lblSettingsHeading.setBounds(10, 11, 850, 43);
			
			headingPanel.add(lblSettingsHeading);
			
			
			//FIRST NAME
			
			lblServerAdd = new JLabel("Server Address:");
			
			lblServerAdd.setHorizontalAlignment(SwingConstants.TRAILING);
			
			lblServerAdd.setFont(MainFrame.SMALLLABEL);
			
			lblServerAdd.setBounds(45, 111, 145, 26);
			
			mainPanel.add(lblServerAdd);
			
			
			txtServerAdd = new JTextField();
			
			txtServerAdd.setFont(MainFrame.SMALLLABEL);

			txtServerAdd.setText(myDefaults.getServerAddress());
			
			txtServerAdd.setBounds(220, 111, 150, 26);
			
			txtServerAdd.setColumns(10);
			
			mainPanel.add(txtServerAdd);
			
			
			//LAST NAME
			
			lblUsername = new JLabel("Username:");
			
			lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
			
			lblUsername.setFont(MainFrame.SMALLLABEL);
			
			lblUsername.setBounds(45, 163, 145, 26);
			
			mainPanel.add(lblUsername);
			
			
			txtUsername = new JTextField();
			
			txtUsername.setFont(MainFrame.SMALLLABEL);
			
			txtUsername.setText(myDefaults.getUsername());
			
			txtUsername.setColumns(10);
			
			txtUsername.setBounds(220, 163, 150, 26);
			
			mainPanel.add(txtUsername);
			
			
			//MIDDLE NAME
			
			lblServerPort = new JLabel("Server Port:");
			
			lblServerPort.setHorizontalAlignment(SwingConstants.TRAILING);
			
			lblServerPort.setFont(MainFrame.SMALLLABEL);
			
			lblServerPort.setBounds(430, 111, 145, 26);
			
			mainPanel.add(lblServerPort);
			
			
			txtServerPort = new JTextField();
			
			txtServerPort.setFont(MainFrame.SMALLLABEL);
			
			txtServerPort.setText(String.valueOf(myDefaults.getPortNumber()));
			
			txtServerPort.setColumns(10);
			
			txtServerPort.setBounds(605, 111, 150, 26);
			
			mainPanel.add(txtServerPort);
			
			
			//CENTER NUMBER
			
			lblPassword = new JLabel("Password:");
			
			lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
			
			lblPassword.setFont(MainFrame.SMALLLABEL);
			
			lblPassword.setBounds(430, 163, 145, 26);
			
			mainPanel.add(lblPassword);
			
			txtPassword = new JTextField();
			
			txtPassword.setFont(MainFrame.SMALLLABEL);
			
			txtPassword.setText(myDefaults.getPassword());
			
			txtPassword.setColumns(10);
			
			txtPassword.setBounds(605, 163, 150, 26);
			
			mainPanel.add(txtPassword);
			
			
			lblDatabaseName = new JLabel("Database Name:");
			
			lblDatabaseName.setHorizontalAlignment(SwingConstants.TRAILING);
			
			lblDatabaseName.setFont(MainFrame.SMALLLABEL);
			
			lblDatabaseName.setBounds(45, 214, 145, 26);
			
			mainPanel.add(lblDatabaseName);
			
			txtDatabaseName = new JTextField();
			
			txtDatabaseName.setFont(MainFrame.SMALLLABEL);
			
			txtDatabaseName.setText(myDefaults.getDatabaseName());
			
			txtDatabaseName.setColumns(10);
			
			txtDatabaseName.setBounds(220, 214, 150, 26);
			
			mainPanel.add(txtDatabaseName);
			
			
			//FOOTER
			
			footerPanel = new JPanel();
			
			footerPanel.setBounds(0, 356, 870, 61);
			
			footerPanel.setLayout(null);
			
			footerPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
			
			mainPanel.add(footerPanel);
			
			
			lblErrorMsg = new JLabel("Error: Could not add centre");
			
			lblErrorMsg.setForeground(Color.RED);
			
			lblErrorMsg.setHorizontalAlignment(SwingConstants.CENTER);
			
			lblErrorMsg.setFont(MainFrame.FOOTERFONT);
			
			lblErrorMsg.setBounds(10, 11, 850, 43);
			
			lblErrorMsg.setVisible(false);
			
			footerPanel.add(lblErrorMsg);
			
			
			btnSettings = new JButton("Save Changes");
			
			btnSettings.setBounds(349, 299, 172, 36);
			
			btnSettings.setBackground(MainFrame.TEALGREEN);
			
			btnSettings.setCursor(MainFrame.HANDCURSOR);
			
			btnSettings.setFont(MainFrame.INPUTLABEL);
			
			btnSettings.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					try {
						DefaultsController.setDefaults(new Defaults(txtServerAdd.getText(), 
																	txtDatabaseName.getText(), 
																	Integer.parseInt(txtServerPort.getText()), 
																	txtUsername.getText(), 
																	txtPassword.getText()));
					} 
					
					catch (NumberFormatException e) {

						showError("An error occured. Could not save cahnges to configuration file.");

						e.printStackTrace();
						
					} 
					
					catch (IOException e) {

						showError("An error occured. Could not save cahnges to configuration file.");

						e.printStackTrace();
					}

				}		
			});
			
			mainPanel.add(btnSettings);
			
		} 
		
		catch (ClassNotFoundException e1) {

			showError("An error occured. Could not access the configuration file.");

			e1.printStackTrace();
			
		} 
		
		catch (IOException e1) {

			showError("An error occured. Could not access the configuration file.");

			e1.printStackTrace();
			
		}
		
		this.setBackground(Color.WHITE);
		
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.setLayout(null);
		
		
		

	}
	
	public void showError(String error) {
		
		lblErrorMsg.setText(error);
		
		lblErrorMsg.setVisible(true);
	}

}

















