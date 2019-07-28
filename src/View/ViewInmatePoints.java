package View;

import java.awt.Color;
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

import Controller.InmatePoints;
import Controller.RedirectEvent;
import Controller.RedirectEventListener;

public class ViewInmatePoints extends JPanel {
	
	
	private JButton btnBack;
	
	private JButton btnLogout;
	
	private JPanel mainPanel;
	
	private JPanel headingPanel;
	
	private JLabel lblAddInmateHeading;
	
	private JLabel lblInmateID;
	
	private JTextField txtInmateID;
	
	private JLabel lblCentreNo;
	
	private JTextField txtCentreNo;
	
	private JButton btnViewInmatePoints;
	
	private JLabel lblErrorMsg;
	
	private JPanel footerPanel;
	
	
	//	INMATE POINTS
	
	private InmatePoints inmatePoints;
	
	public InmatePoints getInmatePoints() {
		
		return this.inmatePoints;
		
	}
	
	
	//	REDIRECT LISENERS
	
	private RedirectEventListener backRedirect;
	
	private RedirectEventListener logoutRedirect;
	
	private RedirectEventListener inmatePointsRedirect;
	
	
	public void setBackRedirect(RedirectEventListener backRedirect) {
		
		this.backRedirect= backRedirect;
		
	}
	
	public void setLogoutRedirect(RedirectEventListener logoutRedirect) {
		
		this.logoutRedirect= logoutRedirect;
		
	}
	
	public void setInmatePointsRedirect(RedirectEventListener inmatePointsRedirect) {
		
		this.inmatePointsRedirect= inmatePointsRedirect;
		
	}
	
	
	public ViewInmatePoints() {
		
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
		
		
		lblAddInmateHeading = new JLabel("View Inmate Points");
		
		lblAddInmateHeading.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblAddInmateHeading.setFont(MainFrame.HEADERFONT);
		
		lblAddInmateHeading.setForeground(MainFrame.HEADINGCOLOR);
		
		lblAddInmateHeading.setBounds(10, 11, 850, 43);
		
		headingPanel.add(lblAddInmateHeading);
		
		
		//FIRST NAME
		
		lblInmateID = new JLabel("Inmate ID:");
		
		lblInmateID.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblInmateID.setFont(MainFrame.HEADINGFONT);
		
		lblInmateID.setBounds(245, 143, 145, 26);
		
		mainPanel.add(lblInmateID);
		
		
		txtInmateID = new JTextField();
		
		txtInmateID.setFont(MainFrame.HEADINGFONT);
		
		txtInmateID.setBounds(420, 143, 150, 26);
		
		txtInmateID.setColumns(10);
		
		mainPanel.add(txtInmateID);
		
		
		
		//CENTER NUMBER
		
		lblCentreNo = new JLabel("Centre No:");
		
		lblCentreNo.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblCentreNo.setFont(MainFrame.HEADINGFONT);
		
		lblCentreNo.setBounds(245, 200, 145, 26);
		
		mainPanel.add(lblCentreNo);
		
		txtCentreNo = new JTextField();
		
		txtCentreNo.setFont(MainFrame.HEADINGFONT);
		
		txtCentreNo.setColumns(10);
		
		txtCentreNo.setBounds(420, 200, 150, 26);
		
		mainPanel.add(txtCentreNo);
		
		
		
		//FOOTER
		
		footerPanel = new JPanel();
		
		footerPanel.setBounds(0, 356, 870, 61);
		
		footerPanel.setLayout(null);
		
		footerPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		mainPanel.add(footerPanel);
		
		
		lblErrorMsg = new JLabel("Error: Could not find Inmate.");
		
		lblErrorMsg.setForeground(Color.RED);
		
		lblErrorMsg.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblErrorMsg.setFont(MainFrame.FOOTERFONT);
		
		lblErrorMsg.setBounds(10, 11, 850, 43);
		
		lblErrorMsg.setVisible(false);
		
		footerPanel.add(lblErrorMsg);
		
		
		btnViewInmatePoints = new JButton("View Inmate Points");
		
		btnViewInmatePoints.setBounds(335, 299, 221, 36);
		
		btnViewInmatePoints.setBackground(MainFrame.TEALGREEN);
		
		btnViewInmatePoints.setCursor(MainFrame.HANDCURSOR);
		
		btnViewInmatePoints.setFont(MainFrame.INPUTLABEL);
		
		btnViewInmatePoints.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					inmatePoints= new InmatePoints(Integer.parseInt(txtInmateID.getText()), 
																Integer.parseInt(txtCentreNo.getText()));
				
					RedirectEvent inmateEvent= new RedirectEvent(this);
					
					inmatePointsRedirect.redirectActionPerformed(inmateEvent);
					
				} 
				
				catch (NumberFormatException e) {
				
					showError(MainFrame.NUMBERFORMATERROR);
					
					e.printStackTrace();
				
				} 
				
				catch (SQLException e) {
				
					showError("An error occured. Could not access inmate points");
					
					e.printStackTrace();
				
				} 
				
				catch (ClassNotFoundException e) {
					
					showError("A fatal error has occured. Please restart the app.");
					
					e.printStackTrace();
				
				} 
				
				catch (IOException e) {
					
					showError("A fatal error has occured. Please restart the app.");
					
					e.printStackTrace();
				}
				
			}
		});
		
		mainPanel.add(btnViewInmatePoints);
	}
	
	public void showError(String error) {
		
		lblErrorMsg.setText(error);
		
		lblErrorMsg.setVisible(true);
	}

}

















