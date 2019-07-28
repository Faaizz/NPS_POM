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

import Controller.RedirectEvent;
import Controller.RedirectEventListener;

public class ViewInmatesByCentre extends JPanel {
	
	
	private JButton btnBack;
	
	private JButton btnLogout;
	
	private JPanel mainPanel;
	
	private JPanel headingPanel;
	
	private JLabel lblAddInmateHeading;
	
	private JLabel lblCentreNo;
	
	private JTextField txtCentreNo;
	
	private JButton btnFindInmates;
	
	private JLabel lblErrorMsg;
	
	private JPanel footerPanel;
	
	
	//	RESULT
	
	Controller.ViewInmatesByCentre viewOne;
	
	public Controller.ViewInmatesByCentre getResult(){
		
		return viewOne;
		
	}
	
	
	//	REDIRECT LISENERS
	
	private RedirectEventListener backRedirect;
	
	private RedirectEventListener logoutRedirect;
	
	private RedirectEventListener findInmatesRedirect;
	
	
	public void setBackRedirect(RedirectEventListener backRedirect) {
		
		this.backRedirect= backRedirect;
		
	}
	
	public void setLogoutRedirect(RedirectEventListener logoutRedirect) {
		
		this.logoutRedirect= logoutRedirect;
		
	}
	
	public void setFindInmatesRedirect(RedirectEventListener findInmatesRedirect) {
		
		this.findInmatesRedirect= findInmatesRedirect;
		
	}
	
	
	
	public ViewInmatesByCentre() {
		
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
		
		
		lblAddInmateHeading = new JLabel("View Inmates By Centre");
		
		lblAddInmateHeading.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblAddInmateHeading.setFont(MainFrame.HEADERFONT);
		
		lblAddInmateHeading.setForeground(MainFrame.HEADINGCOLOR);
		
		lblAddInmateHeading.setBounds(10, 11, 850, 43);
		
		headingPanel.add(lblAddInmateHeading);
		
		
		//CENTER NUMBER
		
		lblCentreNo = new JLabel("Centre No:");
		
		lblCentreNo.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblCentreNo.setFont(MainFrame.HEADINGFONT);
		
		lblCentreNo.setBounds(245, 176, 145, 26);
		
		mainPanel.add(lblCentreNo);
		
		txtCentreNo = new JTextField();
		
		txtCentreNo.setFont(MainFrame.HEADINGFONT);
		
		txtCentreNo.setColumns(10);
		
		txtCentreNo.setBounds(420, 176, 150, 26);
		
		mainPanel.add(txtCentreNo);
		
		
		
		//FOOTER
		
		footerPanel = new JPanel();
		
		footerPanel.setBounds(0, 356, 870, 61);
		
		footerPanel.setLayout(null);
		
		footerPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		mainPanel.add(footerPanel);
		
		
		lblErrorMsg = new JLabel("Error: Could not find Centre.");
		
		lblErrorMsg.setForeground(Color.RED);
		
		lblErrorMsg.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblErrorMsg.setFont(MainFrame.FOOTERFONT);
		
		lblErrorMsg.setBounds(10, 11, 850, 43);
		
		lblErrorMsg.setVisible(false);
		
		footerPanel.add(lblErrorMsg);
		
		
		btnFindInmates = new JButton("Find Inmates");
		
		btnFindInmates.setBounds(325, 299, 221, 36);
		
		btnFindInmates.setBackground(MainFrame.TEALGREEN);
		
		btnFindInmates.setCursor(MainFrame.HANDCURSOR);
		
		btnFindInmates.setFont(MainFrame.INPUTLABEL);
		
		btnFindInmates.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					viewOne= new Controller.ViewInmatesByCentre(Integer.parseInt(txtCentreNo.getText()));
					
					RedirectEvent viewInmatesEvent= new RedirectEvent(this);
					
					findInmatesRedirect.redirectActionPerformed(viewInmatesEvent);
					
				} 
				
				catch (NumberFormatException e1) {
					
					showError(MainFrame.NUMBERFORMATERROR);
					
					e1.printStackTrace();
					
				} 
				
				catch (SQLException e1) {
					
					
					showError("Could not find centre.");
					
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
		
		mainPanel.add(btnFindInmates);
	}
	
	public void showError(String error) {
		
		lblErrorMsg.setText(error);
		
		lblErrorMsg.setVisible(true);
	}

}

















