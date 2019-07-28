package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Controller.InmatePoints;
import Controller.RedirectEvent;
import Controller.RedirectEventListener;

public class ViewInmatePointsSuccess extends JPanel {
	
	
	private JButton btnBack;
	
	private JButton btnLogout;
	
	private JPanel mainPanel;
	
	private JPanel headingPanel;
	
	private JLabel lblViewInmatePointsSuccessHeading;
	
	private JTable table;
	
	private JScrollPane tableScrollPane;
	
	private JPanel footerPanel;
	
	
	//	REDIRECT LISENERS
	
	private RedirectEventListener backRedirect;
	
	private RedirectEventListener logoutRedirect;
	
	
	public void setBackRedirect(RedirectEventListener backRedirect) {
		
		this.backRedirect= backRedirect;
		
	}
	
	public void setLogoutRedirect(RedirectEventListener logoutRedirect) {
		
		this.logoutRedirect= logoutRedirect;
		
	}
	
	
	
	public ViewInmatePointsSuccess(InmatePoints inmatePoints) {
		
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
		
		
		lblViewInmatePointsSuccessHeading = new JLabel(inmatePoints.getName());
		
		lblViewInmatePointsSuccessHeading.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblViewInmatePointsSuccessHeading.setFont(MainFrame.HEADERFONT);
		
		lblViewInmatePointsSuccessHeading.setForeground(MainFrame.HEADINGCOLOR);
		
		lblViewInmatePointsSuccessHeading.setBounds(10, 11, 850, 43);
		
		headingPanel.add(lblViewInmatePointsSuccessHeading);
		
		
		//FOOTER
		
		footerPanel = new JPanel();
		
		footerPanel.setBounds(0, 356, 870, 61);
		
		footerPanel.setLayout(null);
		
		footerPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		mainPanel.add(footerPanel);
		
		//TABLE
		
		table = new JTable();
		
		int[][] allPoints= inmatePoints.getAllPoints();
		
		String[][] formattedPoints= new String[12][6];
		
		for(int ctrOne=0; ctrOne < 12; ctrOne++) {
			
			switch (ctrOne) {
			
			case 0: formattedPoints[ctrOne][0]= "January";
			break;
			
			case 1: formattedPoints[ctrOne][0]= "February";
			break;
			
			case 2: formattedPoints[ctrOne][0]= "March";
			break;
			
			case 3: formattedPoints[ctrOne][0]= "April";
			break;
			
			case 4: formattedPoints[ctrOne][0]= "May";
			break;
			
			case 5: formattedPoints[ctrOne][0]= "June";
			break;
			
			case 6: formattedPoints[ctrOne][0]= "July";
			break;
			
			case 7: formattedPoints[ctrOne][0]= "August";
			break;
			
			case 8: formattedPoints[ctrOne][0]= "September";
			break;
			
			case 9: formattedPoints[ctrOne][0]= "October";
			break;
			
			case 10: formattedPoints[ctrOne][0]= "November";
			break;
			
			case 11: formattedPoints[ctrOne][0]= "December";
			break;
			
			}
			
			int total= 0;
			
			for(int ctrTwo=1; ctrTwo < 5; ctrTwo++) {
				
				formattedPoints[ctrOne][ctrTwo]= String.valueOf(allPoints[ctrOne][ctrTwo-1]);
				
				total+= allPoints[ctrOne][ctrTwo-1];
			}
			
			formattedPoints[ctrOne][5]= String.valueOf(total);
			
		}
		
		
		
		AbstractTableModel aModel= new DefaultTableModel(
				formattedPoints,
				new String[] {
					"Month", "Change from old ways", "Good behaviour", "Conduct", "Attitude towards work", "Total Points"
				}
			);
		
		
		table.setFont(MainFrame.SMALLLABEL);
		
		table.setModel(aModel);
		
		table.setBounds(33, 126, 804, 272);
		
		table.setRowHeight(30);
		
		table.getTableHeader().setFont(MainFrame.SMALLLABEL);
		
		table.getTableHeader().setBackground(Color.white);
		
		
		table.getColumnModel().setColumnMargin(10);
		
		table.getColumnModel().getColumn(0).setMaxWidth(100);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		
		table.getColumnModel().getColumn(1).setMaxWidth(200);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(15);
		
		table.getColumnModel().getColumn(2).setMaxWidth(150);
		
		table.getColumnModel().getColumn(3).setMaxWidth(150);
		
		table.getColumnModel().getColumn(4).setMaxWidth(200);
		
		table.getColumnModel().getColumn(5).setMaxWidth(100);
		
		table.setBounds(33, 126, 804, 272);
		

		//mainPanel.add(table);
		
		tableScrollPane = new JScrollPane(table);
		
		tableScrollPane.setBounds(33, 91, 804, 242);
		
		tableScrollPane.setBackground(Color.WHITE);
		
		mainPanel.add(tableScrollPane);
		
		
	}

}

















