package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ProcessBuilder.Redirect;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.RedirectEvent;
import Controller.RedirectEventListener;

public class HomePage extends JPanel {
	
	private JLabel lblLogIn;
	
	private JLabel lblID;
	
	private JLabel lblOffice;
	
	private JLabel lblCentre;
	
	private JLabel lblHomeHeading;
	
	JButton btnLogout;
	
	//INMATES PANEL
	
	private JPanel inmatesPanel;
	
	private JPanel inmatesHeaderPanel;
	
	private JLabel lblInmatesHeader;
	
	private JButton btnAddInmate;
	
	private JButton btnSingleInmate;
	
	private JButton btnInmatesByCentre;
	
	private JPanel inmatesFooterPanel;
	
	
	//CENTRE PANEL
	
	private JPanel centrePanel;
	
	private JPanel centreHeaderPanel;
	
	private JLabel lblCentreHeader;
	
	private JButton btnAddCentre;
	
	private JButton btnViewCentre;
	
	private JPanel centreFooterPanel;
	
	
	//PREROGATIVE OF MERCY PANEL
	
	private JPanel pomPanel;
	
	private JPanel pomHeaderPanel;
	
	private JLabel lblPomHeader;
	
	private JButton btnAllotPoints;
	
	private JButton btnInmatePoints;
	
	private JButton btnPardonList;
	
	private JPanel pomFooterPanel;
	
	
	//REDIRECT LISTENERS
	
	private RedirectEventListener addInmateRedirect;
	
	private RedirectEventListener viewSingleInmateRedirect;
	
	private RedirectEventListener viewInmatesByCentreRedirect;
	
	private RedirectEventListener allotInmatePointsRedirect;
	
	private RedirectEventListener viewInmatePointsRedirect;
	
	private RedirectEventListener publishPardonListRedirect;
	
	private RedirectEventListener addCentreRedirect;
	
	private RedirectEventListener viewCentreListRedirect;	
	
	private RedirectEventListener logoutRedirect;
	
	
	public HomePage() {
		
		this.setBackground(Color.WHITE);
		
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.setLayout(null);
		
		
		//HEADING
		
		lblHomeHeading = new JLabel("HOME PAGE");
		
		lblHomeHeading.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblHomeHeading.setFont(MainFrame.HEADERFONT);
		
		lblHomeHeading.setForeground(MainFrame.HEADINGCOLOR);
		
		lblHomeHeading.setBounds(45, 11, 860, 49);
		
		this.add(lblHomeHeading);
		
		/*
		lblLogIn = new JLabel("Logged In as:");
		
		lblLogIn.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblLogIn.setFont(MainFrame.SMALLLABEL);
		
		lblLogIn.setBounds(340, 79, 130, 26);
		
		this.add(lblLogIn);
		
		
		lblID = new JLabel("1");
		
		lblID.setFont(MainFrame.SMALLLABEL);
		
		lblID.setBounds(480, 79, 130, 26);
		
		this.add(lblID);
		
		
		lblOffice = new JLabel("Office:");
		
		lblOffice.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblOffice.setFont(MainFrame.SMALLLABEL);
		
		lblOffice.setBounds(340, 108, 130, 26);
		
		this.add(lblOffice);
		
		
		lblCentre = new JLabel("Kirikiri Max");
		
		lblCentre.setFont(MainFrame.SMALLLABEL);
		
		lblCentre.setBounds(480, 108, 130, 26);
		
		this.add(lblCentre);
		*/
		
		
		btnLogout = new JButton("logout");
		
		btnLogout.setBackground(MainFrame.TEALGREEN);
		
		btnLogout.setForeground(Color.RED);
		
		btnLogout.setCursor(MainFrame.HANDCURSOR);
		
		btnLogout.setFont(MainFrame.SMALLLABEL);
		
		btnLogout.setBounds(805, 94, 100, 40);
		
		btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				RedirectEvent logoutEvent= new RedirectEvent(this);
				
				logoutRedirect.redirectActionPerformed(logoutEvent);
				
			}
		});
		
		this.add(btnLogout);
		
		
		//MANAGE	INMATES
		
		inmatesPanel = new JPanel();
		
		inmatesPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		inmatesPanel.setBackground(Color.WHITE);
		
		inmatesPanel.setBounds(45, 152, 270, 348);
		
		inmatesPanel.setLayout(null);		
		
		//add(inmatesPanel);		-inmatesPanel is added below, after inmatesFooterPanel so that inmatesFooterPanel displays on top of it
		
		
		inmatesHeaderPanel = new JPanel();
		
		inmatesHeaderPanel.setBounds(0, 0, 270, 61);
		
		inmatesHeaderPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		inmatesHeaderPanel.setLayout(null);
		
		inmatesPanel.add(inmatesHeaderPanel);
		
		
		lblInmatesHeader = new JLabel("Manage Inmates");
		
		lblInmatesHeader.setBounds(10, 11, 250, 39);
		
		lblInmatesHeader.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblInmatesHeader.setFont(MainFrame.HEADINGFONT);
		
		lblInmatesHeader.setForeground(MainFrame.HEADINGCOLOR);
		
		inmatesHeaderPanel.add(lblInmatesHeader);
		
		
		btnAddInmate = new JButton("Add Inmate");
		
		btnAddInmate.setBackground(MainFrame.TEALGREEN);
		
		btnAddInmate.setFont(MainFrame.INPUTLABEL);
		
		btnAddInmate.setCursor(MainFrame.HANDCURSOR);
		
		btnAddInmate.setBounds(0, 91, 270, 42);
		
		btnAddInmate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				RedirectEvent addInmateEvent= new RedirectEvent(this);
				
				addInmateRedirect.redirectActionPerformed(addInmateEvent);
				
			}
		});
		
		inmatesPanel.add(btnAddInmate);
		
		
		btnSingleInmate = new JButton("View Single Inmate");
		
		btnSingleInmate.setFont(MainFrame.INPUTLABEL);
		
		btnSingleInmate.setBackground(MainFrame.TEALGREEN);
		
		btnSingleInmate.setCursor(MainFrame.HANDCURSOR);
		
		btnSingleInmate.setBounds(0, 153, 270, 42);
		
		btnSingleInmate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				RedirectEvent singleInmateEvent= new RedirectEvent(this);
				
				viewSingleInmateRedirect.redirectActionPerformed(singleInmateEvent);
				
			}
		});
		
		inmatesPanel.add(btnSingleInmate);
		
		
		btnInmatesByCentre = new JButton("View Inmates by Centre");
		
		btnInmatesByCentre.setFont(MainFrame.INPUTLABEL);
		
		btnInmatesByCentre.setBackground(MainFrame.TEALGREEN);
		
		btnInmatesByCentre.setCursor(MainFrame.HANDCURSOR);
		
		btnInmatesByCentre.setBounds(0, 215, 270, 42);
		
		btnInmatesByCentre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				RedirectEvent viewInmatesByCentreEvent= new RedirectEvent(this);
				
				viewInmatesByCentreRedirect.redirectActionPerformed(viewInmatesByCentreEvent);
				
			}
		});
		
		inmatesPanel.add(btnInmatesByCentre);
		
		
		
		inmatesFooterPanel = new JPanel();
		
		inmatesFooterPanel.setBounds(45, 440, 270, 61);
		
		inmatesFooterPanel.setLayout(null);
		
		inmatesFooterPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		this.add(inmatesFooterPanel);
		
		
		this.add(inmatesPanel);
		
		
		//PREROGATIVE	OF	MERCY
		
		pomPanel = new JPanel();
		
		pomPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		pomPanel.setBackground(Color.WHITE);
		
		pomPanel.setBounds(635, 152, 270, 349);
		
		pomPanel.setLayout(null);
		
		this.add(pomPanel);
		
		
		pomHeaderPanel = new JPanel();
		
		pomHeaderPanel.setLayout(null);
		
		pomHeaderPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		pomHeaderPanel.setBounds(0, 0, 270, 61);
		
		pomPanel.add(pomHeaderPanel);
		
		
		lblPomHeader = new JLabel("Prerogative of Mercy");
		
		lblPomHeader.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblPomHeader.setFont(MainFrame.HEADINGFONT);
		
		lblPomHeader.setForeground(MainFrame.HEADINGCOLOR);
		
		lblPomHeader.setBounds(10, 11, 250, 39);
		
		pomHeaderPanel.add(lblPomHeader);
		
		
		btnAllotPoints = new JButton("Allot Inmate Points");
		
		btnAllotPoints.setFont(MainFrame.INPUTLABEL);
		
		btnAllotPoints.setBackground(MainFrame.TEALGREEN);
		
		btnAllotPoints.setCursor(MainFrame.HANDCURSOR);
		
		btnAllotPoints.setBounds(0, 91, 270, 42);
		
		btnAllotPoints.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				RedirectEvent allotPointsEvent= new RedirectEvent(this);
				
				allotInmatePointsRedirect.redirectActionPerformed(allotPointsEvent);
			}
		});
		
		pomPanel.add(btnAllotPoints);
		
		
		btnInmatePoints = new JButton("View Inmate Points");
		
		btnInmatePoints.setFont(MainFrame.INPUTLABEL);
		
		btnInmatePoints.setBackground(MainFrame.TEALGREEN);
		
		btnInmatePoints.setCursor(MainFrame.HANDCURSOR);
		
		btnInmatePoints.setBounds(0, 153, 270, 42);
		
		btnInmatePoints.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				RedirectEvent inmatePointsEvent= new RedirectEvent(this);
				
				viewInmatePointsRedirect.redirectActionPerformed(inmatePointsEvent);
				
			}
		});
		
		pomPanel.add(btnInmatePoints);
		
		
		btnPardonList = new JButton("Publish Pardon List");
		
		btnPardonList.setFont(MainFrame.INPUTLABEL);
		
		btnPardonList.setBackground(MainFrame.TEALGREEN);
		
		btnPardonList.setBounds(0, 215, 270, 42);
		
		btnPardonList.setCursor(MainFrame.HANDCURSOR);
		
		btnPardonList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				RedirectEvent pardonListEvent= new RedirectEvent(this);
				
				publishPardonListRedirect.redirectActionPerformed(pardonListEvent);
				
			}
		});
		
		pomPanel.add(btnPardonList);
		
		
		pomFooterPanel = new JPanel();
		
		pomFooterPanel.setLayout(null);
		
		pomFooterPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		pomFooterPanel.setBounds(0, 288, 270, 61);
		
		pomPanel.add(pomFooterPanel);
		
		
		//MANAGE	CENTRE	
		
		centrePanel = new JPanel();
		
		centrePanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		centrePanel.setBackground(Color.WHITE);
		
		centrePanel.setBounds(340, 152, 270, 349);
		
		centrePanel.setLayout(null);
		
		this.add(centrePanel);
		
		
		centreHeaderPanel = new JPanel();
		
		centreHeaderPanel.setLayout(null);
		
		centreHeaderPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		centreHeaderPanel.setBounds(0, 0, 270, 61);
		
		centrePanel.add(centreHeaderPanel);
		
		
		lblCentreHeader = new JLabel("Manage Centre");
		
		lblCentreHeader.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblCentreHeader.setFont(MainFrame.HEADINGFONT);
		
		lblCentreHeader.setForeground(MainFrame.HEADINGCOLOR);
		
		lblCentreHeader.setBounds(10, 11, 250, 39);
		
		centreHeaderPanel.add(lblCentreHeader);
		
		
		btnAddCentre = new JButton("Add Centre");
		
		btnAddCentre.setFont(MainFrame.INPUTLABEL);
		
		btnAddCentre.setBackground(MainFrame.TEALGREEN);
		
		btnAddCentre.setCursor(MainFrame.HANDCURSOR);
		
		btnAddCentre.setBounds(0, 122, 270, 42);
		
		btnAddCentre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				RedirectEvent addCentreEvent= new RedirectEvent(this);
				
				addCentreRedirect.redirectActionPerformed(addCentreEvent);
				
			}
		});
		
		centrePanel.add(btnAddCentre);
		
		
		btnViewCentre = new JButton("View Centre List");
		
		btnViewCentre.setFont(MainFrame.INPUTLABEL);
		
		btnViewCentre.setBackground(MainFrame.TEALGREEN);
		
		btnViewCentre.setBounds(0, 184, 270, 42);
		
		btnViewCentre.setCursor(MainFrame.HANDCURSOR);
		
		btnViewCentre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				RedirectEvent viewCentreEvent= new RedirectEvent(this);
				
				viewCentreListRedirect.redirectActionPerformed(viewCentreEvent);
				
			}
		});
		
		centrePanel.add(btnViewCentre);
		
		
		centreFooterPanel = new JPanel();
		
		centreFooterPanel.setLayout(null);
		
		centreFooterPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		centreFooterPanel.setBounds(0, 288, 270, 61);
		
		centrePanel.add(centreFooterPanel);
		
		
		
	}
	
	public void setAddInmateRedirect(RedirectEventListener addInmateRedirect) {
		
		this.addInmateRedirect= addInmateRedirect;
		
	}
	
	public void setViewSingleInmateRedirect(RedirectEventListener viewSingleInmateRedirect) {
		
		this.viewSingleInmateRedirect= viewSingleInmateRedirect;
		
	}
	
	public void setViewInmatesByCentreRedirect(RedirectEventListener viewInmatesByCentreRedirect) {
		
		this.viewInmatesByCentreRedirect= viewInmatesByCentreRedirect;
		
	}
	
	public void setAllotInmatePointsRedirect(RedirectEventListener allotInmatePointsRedirect) {
		
		this.allotInmatePointsRedirect= allotInmatePointsRedirect;
		
	}
	
	public void setViewInmatePointsRedirect(RedirectEventListener viewInmatePointsRedirect) {
		
		this.viewInmatePointsRedirect= viewInmatePointsRedirect;
		
	}
	
	public void setPublishPardonListRedirect(RedirectEventListener publishPardonListRedirect) {
		
		this.publishPardonListRedirect= publishPardonListRedirect;
		
	}
	
	public void setAddCentreRedirect(RedirectEventListener addCentreRedirect) {
		
		this.addCentreRedirect= addCentreRedirect;
		
	}
	
	public void setViewCentreRedirect(RedirectEventListener viewCentreListRedirect) {
		
		this.viewCentreListRedirect= viewCentreListRedirect;
		
	}
	
	public void setLogoutRedirect(RedirectEventListener logoutRedirect) {
		
		this.logoutRedirect= logoutRedirect;
		
	}

}
