package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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

public class AllotInmatePointsSuccess extends JPanel{

	private JButton btnBack;
	
	private JButton btnLogout;
	
	private JPanel mainPanel;
	
	private JPanel headingPanel;
	
	private JLabel lblAllotPointsHeading;
	
	private JLabel lblSuccess;
	
	private JLabel lblSuccessMsg;
	
	private JPanel footerPanel;
	
	private JButton btnBackToHome;
	
	
	
	//	REDIRECT LISENERS
	
	private RedirectEventListener backRedirect;
	
	private RedirectEventListener logoutRedirect;
	
	private RedirectEventListener toHomeRedirect;
	
	
	public void setBackRedirect(RedirectEventListener backRedirect) {
		
		this.backRedirect= backRedirect;
		
	}
	
	public void setLogoutRedirect(RedirectEventListener logoutRedirect) {
		
		this.logoutRedirect= logoutRedirect;
		
	}
	
	public void setToHomeRedirect(RedirectEventListener toHomeRedirect) {
		
		this.toHomeRedirect= toHomeRedirect;
		
	}
	
	
	
	public AllotInmatePointsSuccess() {
		
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
		
		mainPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
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
		
		
		lblAllotPointsHeading = new JLabel("Allot Inmate Points");
		
		lblAllotPointsHeading.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblAllotPointsHeading.setFont(MainFrame.HEADERFONT);
		
		lblAllotPointsHeading.setForeground(MainFrame.HEADINGCOLOR);
		
		lblAllotPointsHeading.setBounds(10, 11, 850, 43);
		
		headingPanel.add(lblAllotPointsHeading);
		
		
		
		lblSuccess = new JLabel("");
		
		lblSuccess.setIcon(MainFrame.SUCCESSIMAGE);
		
		lblSuccess.setBounds(360, 69, 150, 150);
		
		mainPanel.add(lblSuccess);
		
		
		lblSuccessMsg = new JLabel("You have successfully alloted points to the inmate.");
		
		lblSuccessMsg.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblSuccessMsg.setFont(MainFrame.HEADINGFONT);
		
		lblSuccessMsg.setBounds(127, 262, 616, 26);
		
		mainPanel.add(lblSuccessMsg);
		
		
		//FOOTER
		
		footerPanel = new JPanel();
		
		footerPanel.setBounds(0, 356, 870, 61);
		
		footerPanel.setLayout(null);
		
		footerPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		mainPanel.add(footerPanel);
		
		
		btnBackToHome = new JButton("Back To Home");
		
		btnBackToHome.setBounds(349, 299, 172, 36);
		
		btnBackToHome.setBackground(MainFrame.TEALGREEN);
		
		btnBackToHome.setCursor(MainFrame.HANDCURSOR);
		
		btnBackToHome.setFont(MainFrame.INPUTLABEL);
		
		btnBackToHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				RedirectEvent toHomeEvent= new RedirectEvent(this);
				
				toHomeRedirect.redirectActionPerformed(toHomeEvent);
				
			}
		});
		
		mainPanel.add(btnBackToHome);
	}	
	

}
