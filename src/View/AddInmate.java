package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.time.DateTimeException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.RedirectEvent;
import Controller.RedirectEventListener;
import Model.CentreMethods;
import Model.InmateMethods;

public class AddInmate extends JPanel {
	
	
	private JButton btnBack;
	
	private JButton btnLogout;
	
	private JPanel mainPanel;
	
	private JPanel headingPanel;
	
	private JLabel lblAddInmateHeading;
	
	private JLabel lblInmateID;
	
	private JLabel lblFirstname;
	
	private JTextField txtFirstname;
	
	private JLabel lblLastName;
	
	private JTextField txtLastName;
	
	private JLabel lblDOB;
	
	//DATE
	
	private JTextField txtDay;
	
	private JTextField txtMonth;
	
	private JTextField txtYear;
	
	private JLabel lblMiddleName;
	
	private JTextField txtMiddleName;
	
	private JLabel lblCentreNo;
	
	private JTextField txtCentreNo;
	
	private JLabel lblGender;
	
	private JComboBox genderCombo;
	
	private JButton btnAddInmate;
	
	private JLabel lblErrorMsg;
	
	private JPanel footerPanel;
	
	
	//REDIRECT LISTENERS
	
	private RedirectEventListener backRedirect;
	
	private RedirectEventListener logoutRedirect;
	
	private RedirectEventListener addInmateRedirect;
	
	
	
	public AddInmate() {
		
		this.setBackground(Color.WHITE);
		
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.setLayout(null);
		
		
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
		
		
		btnLogout = new JButton("logout");
		
		btnLogout.setFont(MainFrame.SMALLLABEL);
		
		btnLogout.setBackground(MainFrame.TEALGREEN);
		
		btnLogout.setForeground(Color.RED);
		
		btnLogout.setCursor(MainFrame.HANDCURSOR);
		
		btnLogout.setBounds(814, 38, 100, 40);
		
		btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				RedirectEvent logoutEvent= new RedirectEvent(this);
				
				logoutRedirect.redirectActionPerformed(logoutEvent);
				
			}
		});
		
		this.add(btnLogout);
		
		
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
		
		
		lblAddInmateHeading = new JLabel("Add Inmate");
		
		lblAddInmateHeading.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblAddInmateHeading.setFont(MainFrame.HEADERFONT);
		
		lblAddInmateHeading.setForeground(MainFrame.HEADINGCOLOR);
		
		lblAddInmateHeading.setBounds(10, 11, 850, 43);
		
		headingPanel.add(lblAddInmateHeading);
		
		
		lblInmateID = new JLabel();
		
		lblInmateID.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblInmateID.setFont(MainFrame.SMALLLABEL);
		
		lblInmateID.setBounds(363, 73, 145, 19);
		
		
		//	I	N	M	A	T	E		I	D
		
		try {
			
			lblInmateID.setText("Inmate ID: " + String.valueOf(InmateMethods.getLastInmateID() + 1));
			
		} 
		
		catch (SQLException e1) {
			
			showError("Could not fetch records to get last inmate ID");
			
			e1.printStackTrace();
			
		}
		
		catch (ClassNotFoundException e) {

			showError("A fatal error occured. Please restart the app.");
			
			e.printStackTrace();
			
		} 
		
		catch (IOException e) {

			showError("A fatal error occured. Please restart the app.");
			
			e.printStackTrace();
			
		}
		
		mainPanel.add(lblInmateID);
		
		
		//FIRST NAME
		
		lblFirstname = new JLabel("First Name:");
		
		lblFirstname.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblFirstname.setFont(MainFrame.HEADINGFONT);
		
		lblFirstname.setBounds(45, 111, 145, 26);
		
		mainPanel.add(lblFirstname);
		
		
		txtFirstname = new JTextField();
		
		txtFirstname.setFont(MainFrame.HEADINGFONT);
		
		txtFirstname.setBounds(220, 111, 150, 26);
		
		txtFirstname.setColumns(10);
		
		mainPanel.add(txtFirstname);
		
		
		//LAST NAME
		
		lblLastName = new JLabel("Last Name:");
		
		lblLastName.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblLastName.setFont(MainFrame.HEADINGFONT);
		
		lblLastName.setBounds(45, 168, 145, 26);
		
		mainPanel.add(lblLastName);
		
		
		txtLastName = new JTextField();
		
		txtLastName.setFont(MainFrame.HEADINGFONT);
		
		txtLastName.setColumns(10);
		
		txtLastName.setBounds(220, 168, 150, 26);
		
		mainPanel.add(txtLastName);
		
		//DOB
		
		lblDOB = new JLabel("Date of Birth:");
		
		lblDOB.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblDOB.setFont(MainFrame.HEADINGFONT);
		
		lblDOB.setBounds(45, 225, 145, 26);
		
		mainPanel.add(lblDOB);
		
		//DAY
		
		txtDay = new JTextField();
		
		txtDay.setToolTipText("DD");
		
		txtDay.setFont(MainFrame.SMALLLABEL);
		
		txtDay.setColumns(10);
		
		txtDay.setBounds(220, 225, 40, 26);
		
		mainPanel.add(txtDay);
		
		//MONTH
		
		txtMonth = new JTextField();
		
		txtMonth.setToolTipText("MM");
		
		txtMonth.setFont(MainFrame.SMALLLABEL);
		
		txtMonth.setColumns(10);
		
		txtMonth.setBounds(270, 225, 40, 26);
		
		mainPanel.add(txtMonth);
		
		//YEAR
		
		txtYear = new JTextField();
		
		txtYear.setToolTipText("YYYY");
		
		txtYear.setFont(MainFrame.SMALLLABEL);
		
		txtYear.setColumns(10);
		
		txtYear.setBounds(320, 225, 50, 26);
		
		mainPanel.add(txtYear);
		
		
		//MIDDLE NAME
		
		lblMiddleName = new JLabel("Middle Name:");
		
		lblMiddleName.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblMiddleName.setFont(MainFrame.HEADINGFONT);
		
		lblMiddleName.setBounds(430, 111, 145, 26);
		
		mainPanel.add(lblMiddleName);
		
		
		txtMiddleName = new JTextField();
		
		txtMiddleName.setFont(MainFrame.HEADINGFONT);
		
		txtMiddleName.setColumns(10);
		
		txtMiddleName.setBounds(605, 111, 150, 26);
		
		mainPanel.add(txtMiddleName);
		
		
		//CENTER NUMBER
		
		lblCentreNo = new JLabel("Centre No:");
		
		lblCentreNo.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblCentreNo.setFont(MainFrame.HEADINGFONT);
		
		lblCentreNo.setBounds(430, 168, 145, 26);
		
		mainPanel.add(lblCentreNo);
		
		txtCentreNo = new JTextField();
		
		txtCentreNo.setFont(MainFrame.HEADINGFONT);
		
		txtCentreNo.setColumns(10);
		
		txtCentreNo.setBounds(605, 168, 150, 26);
		
		mainPanel.add(txtCentreNo);
		
		
		//GENDER
		
		lblGender = new JLabel("Gender:");
		
		lblGender.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblGender.setFont(MainFrame.HEADINGFONT);
		
		lblGender.setBounds(430, 225, 145, 26);
		
		mainPanel.add(lblGender);
		
		genderCombo = new JComboBox();
		
		genderCombo.setBackground(Color.WHITE);
		
		genderCombo.setFont(MainFrame.HEADINGFONT);
		
		genderCombo.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		
		genderCombo.setBounds(605, 225, 155, 26);
		
		mainPanel.add(genderCombo);
		
		
		//FOOTER
		
		footerPanel = new JPanel();
		
		footerPanel.setBounds(0, 356, 870, 61);
		
		footerPanel.setLayout(null);
		
		footerPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		mainPanel.add(footerPanel);
		
		
		lblErrorMsg = new JLabel("Error: Invalid date of birth");
		
		lblErrorMsg.setForeground(Color.RED);
		
		lblErrorMsg.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblErrorMsg.setFont(MainFrame.FOOTERFONT);
		
		lblErrorMsg.setBounds(10, 11, 850, 43);
		
		lblErrorMsg.setVisible(false);
		
		footerPanel.add(lblErrorMsg);
		
		
		btnAddInmate = new JButton("Add Inmate");
		
		btnAddInmate.setBounds(349, 299, 172, 36);
		
		btnAddInmate.setBackground(MainFrame.TEALGREEN);
		
		btnAddInmate.setCursor(MainFrame.HANDCURSOR);
		
		btnAddInmate.setFont(MainFrame.INPUTLABEL);
		
		btnAddInmate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Controller.AddInmate.addInmate(Integer.parseInt(txtCentreNo.getText()), 
													txtFirstname.getText(), 
													txtLastName.getText(), 
													txtMiddleName.getText(), 
													Integer.parseInt(txtDay.getText()), 
													Integer.parseInt(txtMonth.getText()), 
													Integer.parseInt(txtYear.getText()), 
													String.valueOf(genderCombo.getSelectedItem()));
				
					RedirectEvent success= new RedirectEvent(this);
					
					addInmateRedirect.redirectActionPerformed(success);
				
				} 
				
				catch (NumberFormatException e1) {
					
					showError("Please recheck your entries.");
					
					e1.printStackTrace();
					
				} 
				
				catch (DateTimeException e1) {
					
					
					showError("You have entered an invalid date.");
					
					e1.printStackTrace();
					
				} 
				
				catch (SQLException e1) {
					
					showError("An unexpected error has occured. Could not communicate with database.");
					
					e1.printStackTrace();
					
				} 
				
				catch (ClassNotFoundException e1) {

					showError("An unexpected error has occured. Could not access configuration file.");
					
					e1.printStackTrace();
					
				} catch (IOException e1) {

					showError("An unexpected error has occured. Could not access configuration file.");
					
					e1.printStackTrace();
					
				}
				
			}
		});
		
		mainPanel.add(btnAddInmate);
	}
	
	public void showError(String error) {
		
		lblErrorMsg.setText(error);
		
		lblErrorMsg.setVisible(true);
	}
	
	public void setBackRedirect(RedirectEventListener backRedirect) {
		
		this.backRedirect= backRedirect;
		
	}
	
	public void setLogoutRedirect(RedirectEventListener logoutRedirect) {
		
		this.logoutRedirect= logoutRedirect;
		
	}
	
	public void setAddInmateRedirect(RedirectEventListener addInmateRedirect) {
		
		this.addInmateRedirect= addInmateRedirect;
		
	}

}

















