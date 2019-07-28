package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

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

public class AddCentre extends JPanel {
	
	
	private JButton btnBack;
	
	private JButton btnLogout;
	
	private JPanel mainPanel;
	
	private JPanel headingPanel;
	
	private JLabel lblAddCentreHeading;
	
	private JLabel lblCentreID;
	
	private JTextField txtCentreID;
	
	private JLabel lblState;
	
	private JTextField txtState;
	
	private JLabel lblCentreName;
	
	private JTextField txtCentreName;
	
	private JLabel lblRegion;
	
	private JTextField txtRegion;
	
	private JButton btnAddCentre;
	
	private JLabel lblErrorMsg;
	
	private JPanel footerPanel;
	
	
	//	REDIRECT LISENERS
	
	private RedirectEventListener backRedirect;
	
	private RedirectEventListener logoutRedirect;
	
	private RedirectEventListener addCentreRedirect;
	
	
	public void setBackRedirect(RedirectEventListener backRedirect) {
		
		this.backRedirect= backRedirect;
		
	}
	
	public void setLogoutRedirect(RedirectEventListener logoutRedirect) {
		
		this.logoutRedirect= logoutRedirect;
		
	}
	
	
	public void setAddCentreRedirect(RedirectEventListener addCentreRedirect) {
		
		this.addCentreRedirect= addCentreRedirect;
		
	}
	
	
	
	public AddCentre() {
		
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
		
		btnLogout.setCursor(MainFrame.HANDCURSOR);
		
		btnLogout.setForeground(Color.RED);
		
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
		
		
		lblAddCentreHeading = new JLabel("Add Centre");
		
		lblAddCentreHeading.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblAddCentreHeading.setFont(MainFrame.HEADERFONT);
		
		lblAddCentreHeading.setForeground(MainFrame.HEADINGCOLOR);
		
		lblAddCentreHeading.setBounds(10, 11, 850, 43);
		
		headingPanel.add(lblAddCentreHeading);
		
		
		//FIRST NAME
		
		lblCentreID = new JLabel("Centre ID:");
		
		lblCentreID.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblCentreID.setFont(MainFrame.HEADINGFONT);
		
		lblCentreID.setBounds(45, 111, 145, 26);
		
		mainPanel.add(lblCentreID);
		
		
		txtCentreID = new JTextField();
		
		txtCentreID.setFont(MainFrame.HEADINGFONT);
		
		txtCentreID.setBounds(220, 111, 150, 26);
		
		txtCentreID.setColumns(10);
		
		txtCentreID.setEditable(false);
		
		
		
		//LAST NAME
		
		lblState = new JLabel("State:");
		
		lblState.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblState.setFont(MainFrame.HEADINGFONT);
		
		lblState.setBounds(45, 188, 145, 26);
		
		mainPanel.add(lblState);
		
		
		txtState = new JTextField();
		
		txtState.setFont(MainFrame.HEADINGFONT);
		
		txtState.setColumns(10);
		
		txtState.setBounds(220, 188, 150, 26);
		
		mainPanel.add(txtState);
		
		
		//MIDDLE NAME
		
		lblCentreName = new JLabel("Centre Name:");
		
		lblCentreName.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblCentreName.setFont(MainFrame.HEADINGFONT);
		
		lblCentreName.setBounds(430, 111, 145, 26);
		
		mainPanel.add(lblCentreName);
		
		
		txtCentreName = new JTextField();
		
		txtCentreName.setFont(MainFrame.HEADINGFONT);
		
		txtCentreName.setColumns(10);
		
		txtCentreName.setBounds(605, 111, 150, 26);
		
		mainPanel.add(txtCentreName);
		
		
		//CENTER NUMBER
		
		lblRegion = new JLabel("Region:");
		
		lblRegion.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblRegion.setFont(MainFrame.HEADINGFONT);
		
		lblRegion.setBounds(430, 188, 145, 26);
		
		mainPanel.add(lblRegion);
		
		txtRegion = new JTextField();
		
		txtRegion.setFont(MainFrame.HEADINGFONT);
		
		txtRegion.setColumns(10);
		
		txtRegion.setBounds(605, 188, 150, 26);
		
		mainPanel.add(txtRegion);
		
		
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
		
		
		btnAddCentre = new JButton("Add Centre");
		
		btnAddCentre.setBounds(349, 299, 172, 36);
		
		btnAddCentre.setBackground(MainFrame.TEALGREEN);
		
		btnAddCentre.setCursor(MainFrame.HANDCURSOR);
		
		btnAddCentre.setFont(MainFrame.INPUTLABEL);
		
		btnAddCentre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					Controller.AddCentre.addCentre(txtCentreName.getText(),
													txtRegion.getText(),
													txtState.getText()
													);
					
					RedirectEvent addCentreEvent= new RedirectEvent(this);
					
					addCentreRedirect.redirectActionPerformed(addCentreEvent);
					
				} 
				
				catch (SQLException e) {
					
					MainFrame.printLog(LocalDate.now() + "---" + LocalTime.now() + "---" + "Add Center Page: SQLException");
					
					showError("An error occured. Could not add centre.");
					
					e.printStackTrace();
					
				} 
				
				catch (ClassNotFoundException e) {
					
					MainFrame.printLog(LocalDate.now() + "---" + LocalTime.now() + "---" + "Add Center Page: ClassNotFoundException");

					showError("A fatal error occured. Please restart the app.");
					
					e.printStackTrace();
					
				} 
				
				catch (IOException e) {
					
					MainFrame.printLog(LocalDate.now() + "---" + LocalTime.now() + "---" + "Add Center Page: IOException");

					showError("A fatal error occured. Please restart the app.");
					
					e.printStackTrace();
					
				}
				
			}
		});
		
		mainPanel.add(btnAddCentre);
		
		
		//	C	E	N	T	R	E		I	D
		
		try {
			
			txtCentreID.setText(String.valueOf(CentreMethods.getLastCentreID() + 1));
			
		} 
		
		catch (SQLException e1) {
			
			MainFrame.printLog(LocalDate.now() + "---" + LocalTime.now() + "---" + "Add Center Page: SQLException");
			
			showError("Could not fetch records");
			
			e1.printStackTrace();
			
		}
		
		catch (ClassNotFoundException e) {
			
			MainFrame.printLog(LocalDate.now() + "---" + LocalTime.now() + "---" + "Add Center Page: ClassNotFoundException");

			showError("A fatal error occured. Please restart the app.");
			
			e.printStackTrace();
			
		} 
		
		catch (IOException e) {
			
			MainFrame.printLog(LocalDate.now() + "---" + LocalTime.now() + "---" + "Add Center Page: IOException");

			showError("A fatal error occured. Please restart the app.");
			
			e.printStackTrace();
			
		}
		
		mainPanel.add(txtCentreID);
	}
	
	public void showError(String error) {
		
		lblErrorMsg.setText(error);
		
		lblErrorMsg.setVisible(true);
	}

}

















