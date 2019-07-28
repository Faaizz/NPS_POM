package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.AllotPoints;
import Controller.RedirectEvent;
import Controller.RedirectEventListener;

public class AllotInmatePoints extends JPanel {
	
	
	private JButton btnBack;
	
	private JButton btnLogout;
	
	private JButton btnPointsChart;
	
	private JPanel mainPanel;
	
	private JPanel headingPanel;
	
	private JLabel lblAllotInmatePointsHeading;
	
	private JLabel lblInmateID;
	
	private JTextField txtInmateID;
	
	private JLabel lblCentreNo;
	
	private JTextField txtCentreNo;
	
	private JLabel lblMonth;
	
	private JComboBox monthCombo;
	
	private JLabel lblOldWays;
	
	private JTextField txtOldWays;
	
	private JLabel lblBehaviour;
	
	private JTextField txtBehaviour;
	
	private JLabel lblAttitude;
	
	private JTextField txtAttitude;
	
	private JLabel lblConduct;
	
	private JTextField txtConduct;
	
	private JButton btnAllotPoints;
	
	private JLabel lblErrorMsg;
	
	private JPanel footerPanel;
	
	
	
	//	REDIRECT LISENERS
	
	private RedirectEventListener backRedirect;
	
	private RedirectEventListener logoutRedirect;
	
	private RedirectEventListener pointsChartRedirect;
	
	private RedirectEventListener allotPointsRedirect;
	
	
	public void setBackRedirect(RedirectEventListener backRedirect) {
		
		this.backRedirect= backRedirect;
		
	}
	
	public void setLogoutRedirect(RedirectEventListener logoutRedirect) {
		
		this.logoutRedirect= logoutRedirect;
		
	}
	
	public void setPointsChartRedirect(RedirectEventListener pointsChartRedirect) {
		
		this.pointsChartRedirect= pointsChartRedirect;
		
	}
	
	public void setAllotPointsRedirect(RedirectEventListener allotPointsRedirect) {
		
		this.allotPointsRedirect= allotPointsRedirect;
		
	}
	
	
	
	public AllotInmatePoints() {
		
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
		
		
		//	POINTS CHART
		
		btnPointsChart = new JButton("points chart");
		
		btnPointsChart.setFont(MainFrame.SMALLLABEL);
		
		btnPointsChart.setBackground(MainFrame.TEALGREEN);
		
		btnPointsChart.setCursor(MainFrame.HANDCURSOR);
		
		btnPointsChart.setBounds(405, 38, 150, 40);
		
		btnPointsChart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				RedirectEvent pointsChartEvent= new RedirectEvent(this);
				
				pointsChartRedirect.redirectActionPerformed(pointsChartEvent);
				
			}
		});
		
		
		add(btnPointsChart);
		
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
		
		
		lblAllotInmatePointsHeading = new JLabel("Allot Inmate Points");
		
		lblAllotInmatePointsHeading.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblAllotInmatePointsHeading.setFont(MainFrame.HEADERFONT);
		
		lblAllotInmatePointsHeading.setForeground(MainFrame.HEADINGCOLOR);
		
		lblAllotInmatePointsHeading.setBounds(10, 11, 850, 43);
		
		headingPanel.add(lblAllotInmatePointsHeading);
		
		
		//FIRST NAME
		
		lblInmateID = new JLabel("Inmate ID:");
		
		lblInmateID.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblInmateID.setFont(MainFrame.HEADINGFONT);
		
		lblInmateID.setBounds(45, 95, 145, 26);
		
		mainPanel.add(lblInmateID);
		
		
		txtInmateID = new JTextField();
		
		txtInmateID.setFont(MainFrame.HEADINGFONT);
		
		txtInmateID.setBounds(220, 95, 150, 26);
		
		txtInmateID.setColumns(10);
		
		mainPanel.add(txtInmateID);
		
		
		//CENTER NUMBER
		
		lblCentreNo = new JLabel("Centre No:");
		
		lblCentreNo.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblCentreNo.setFont(MainFrame.HEADINGFONT);
		
		lblCentreNo.setBounds(430, 95, 145, 26);
		
		mainPanel.add(lblCentreNo);
		
		txtCentreNo = new JTextField();
		
		txtCentreNo.setFont(MainFrame.HEADINGFONT);
		
		txtCentreNo.setColumns(10);
		
		txtCentreNo.setBounds(605, 95, 150, 26);
		
		mainPanel.add(txtCentreNo);
		
		
		//MONTH
		
		lblMonth = new JLabel("Month:");
		
		lblMonth.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblMonth.setFont(MainFrame.HEADINGFONT);
		
		lblMonth.setBounds(233, 152, 145, 26);
		
		mainPanel.add(lblMonth);
		
		monthCombo = new JComboBox();
		
		monthCombo.setBackground(Color.WHITE);
		
		monthCombo.setFont(MainFrame.HEADINGFONT);
		
		monthCombo.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		
		monthCombo.setBounds(408, 152, 155, 26);
		
		mainPanel.add(monthCombo);
		
		
		lblOldWays = new JLabel("Change from old ways:");
		
		lblOldWays.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblOldWays.setFont(MainFrame.HEADINGFONT);
		
		lblOldWays.setBounds(45, 209, 255, 26);
		
		mainPanel.add(lblOldWays);
		
		txtOldWays = new JTextField();
		
		txtOldWays.setFont(MainFrame.SMALLLABEL);
		
		txtOldWays.setBounds(330, 211, 40, 26);
		
		mainPanel.add(txtOldWays);
		
		
		lblBehaviour = new JLabel("Behaviour:");
		
		lblBehaviour.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblBehaviour.setFont(MainFrame.HEADINGFONT);
		
		lblBehaviour.setBounds(448, 207, 145, 26);
		
		mainPanel.add(lblBehaviour);
		
		txtBehaviour = new JTextField();
		
		txtBehaviour.setFont(MainFrame.SMALLLABEL);
		
		txtBehaviour.setColumns(10);
		
		txtBehaviour.setBounds(623, 209, 40, 26);
		
		mainPanel.add(txtBehaviour);
		
		
		lblAttitude = new JLabel("Attitude:");
		
		lblAttitude.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblAttitude.setFont(MainFrame.HEADINGFONT);
		
		lblAttitude.setBounds(448, 244, 145, 26);
		
		mainPanel.add(lblAttitude);
		
		
		txtAttitude = new JTextField();
		
		txtAttitude.setFont(MainFrame.SMALLLABEL);
		
		txtAttitude.setBounds(623, 246, 40, 26);
		
		mainPanel.add(txtAttitude);
		
		lblConduct = new JLabel("Conduct:");
		
		lblConduct.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblConduct.setFont(MainFrame.HEADINGFONT);
		
		lblConduct.setBounds(155, 246, 145, 26);
		
		mainPanel.add(lblConduct);
		
		txtConduct = new JTextField();
		
		txtConduct.setFont(MainFrame.SMALLLABEL);
		
		txtConduct.setBounds(330, 248, 40, 26);
		
		mainPanel.add(txtConduct);
		
		
		//FOOTER
		
		footerPanel = new JPanel();
		
		footerPanel.setBounds(0, 356, 870, 61);
		
		footerPanel.setLayout(null);
		
		footerPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		mainPanel.add(footerPanel);
		
		
		lblErrorMsg = new JLabel("Error: Could not allot points");
		
		lblErrorMsg.setForeground(Color.RED);
		
		lblErrorMsg.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblErrorMsg.setFont(MainFrame.FOOTERFONT);
		
		lblErrorMsg.setBounds(10, 11, 850, 43);
		
		lblErrorMsg.setVisible(false);
		
		footerPanel.add(lblErrorMsg);
		
		
		btnAllotPoints = new JButton("Allot Points");
		
		btnAllotPoints.setBounds(349, 299, 172, 36);
		
		btnAllotPoints.setBackground(MainFrame.TEALGREEN);
		
		btnAllotPoints.setCursor(MainFrame.HANDCURSOR);
		
		btnAllotPoints.setFont(MainFrame.INPUTLABEL);
		
		btnAllotPoints.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int monthValue;
				
				switch(String.valueOf(monthCombo.getSelectedItem())) {
				
				case "January": monthValue= 1;
				break;
				
				case "February": monthValue= 2;
				break;
				
				case "March": monthValue= 3;
				break;
				
				case "April": monthValue= 4;
				break;
				
				case "May": monthValue= 5;
				break;
				
				case "June": monthValue= 6;
				break;
				
				case "July": monthValue= 7;
				break;
				
				case "August": monthValue= 8;
				break;
				
				case "September": monthValue= 9;
				break;
				
				case "October": monthValue= 10;
				break;
				
				case "November": monthValue= 11;
				break;
				
				case "December": monthValue= 12;
				break;
				
				default: monthValue= -1;
				
				}
				
				try {
					
					if(monthValue == -1) {
						
						throw new InputMismatchException("Must select month");
						
					}
					
					AllotPoints.allot(Integer.parseInt(txtInmateID.getText()), 
										Integer.parseInt(txtCentreNo.getText()), 
										monthValue, 
										Integer.parseInt(txtOldWays.getText()), 
										Integer.parseInt(txtBehaviour.getText()), 
										Integer.parseInt(txtConduct.getText()), 
										Integer.parseInt(txtAttitude.getText()));
					
					RedirectEvent allotPointsEvent= new RedirectEvent(this);
					
					allotPointsRedirect.redirectActionPerformed(allotPointsEvent);
					
				} 
				
				catch (NumberFormatException e) {
					
					showError(MainFrame.NUMBERFORMATERROR);
					
					e.printStackTrace();
					
				} 
				
				catch (InputMismatchException e) {
					
					showError("Please select month.");
					
					e.printStackTrace();
					
				}
				
				catch (SQLException e) {
					
					showError("An error occured. Could not allot points.");
					
					e.printStackTrace();
					
				} 
				
				catch (ClassNotFoundException e) {

					showError("An fatal error occured. Please restart the app.");
					
					e.printStackTrace();
					
				} 
				
				catch (IOException e) {

					showError("An fatal error occured. Please restart the app.");
					
					e.printStackTrace();
					
				}
				
			}
		});
		
		mainPanel.add(btnAllotPoints);
	}
	
	public void showError(String error) {
		
		lblErrorMsg.setText(error);
		
		lblErrorMsg.setVisible(true);
	}

}

















