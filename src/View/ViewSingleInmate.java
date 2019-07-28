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

import Controller.GetSingleInmate;
import Controller.RedirectEvent;
import Controller.RedirectEventListener;

public class ViewSingleInmate extends JPanel {
	
	
	private JButton btnBack;
	
	private JButton btnLogout;
	
	private JPanel mainPanel;
	
	private JPanel headingPanel;
	
	private JLabel lblAddInmateHeading;
	
	private JLabel lblInmateID;
	
	private JTextField txtInmateID;
	
	private JLabel lblCentreNo;
	
	private JTextField txtCentreNo;
	
	private JButton btnFindInmate;
	
	private JLabel lblErrorMsg;
	
	private JPanel footerPanel;
	
	
	//	REDIRECT LISENERS
	
	private RedirectEventListener backRedirect;
	
	private RedirectEventListener logoutRedirect;
	
	private RedirectEventListener findInmateRedirect;
	
	
	//	INMATE
	
	GetSingleInmate foundInmate;
	
	
	
	public ViewSingleInmate() {
		
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
		
		
		lblAddInmateHeading = new JLabel("View Single Inmate");
		
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
		
		
		btnFindInmate = new JButton("Find Inmate");
		
		btnFindInmate.setBounds(349, 299, 172, 36);
		
		btnFindInmate.setBackground(MainFrame.TEALGREEN);
		
		btnFindInmate.setCursor(MainFrame.HANDCURSOR);
		
		btnFindInmate.setFont(MainFrame.INPUTLABEL);
		
		btnFindInmate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					foundInmate= new GetSingleInmate(Integer.parseInt(txtInmateID.getText()), 
																	Integer.parseInt(txtCentreNo.getText()));
					
					RedirectEvent findInmateEvent= new RedirectEvent(this);
					
					findInmateRedirect.redirectActionPerformed(findInmateEvent);
					
				} 
				
				catch (NumberFormatException e1) {
					
					showError("You have made invalid entries. Please try again.");
					
					e1.printStackTrace();
					
				} 
				
				catch (SQLException e1) {
					
					
					showError("Could not find inmate.");
					
					e1.printStackTrace();
					
				} catch (ClassNotFoundException e1) {
					
					showError("A fatal error has occured. Please restart the app.");
					
					e1.printStackTrace();
					
				} catch (IOException e1) {
					
					showError("A fatal error has occured. Please restart the app.");
					
					e1.printStackTrace();
				}
			
				
			}
		});
		
		mainPanel.add(btnFindInmate);
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
	
	public void setFindInmateRedirect(RedirectEventListener findInmateRedirect) {
		
		this.findInmateRedirect= findInmateRedirect;
		
	}
	
	public GetSingleInmate getInmate() {
		
		return this.foundInmate;
		
	}

}

















