package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
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

import Controller.RedirectEvent;
import Controller.RedirectEventListener;
import Controller.ViewCentre;

public class ViewCentreListSuccess extends JPanel {
	
	
	private JButton btnBack;
	
	private JButton btnLogout;
	
	private JPanel mainPanel;
	
	private JPanel headingPanel;
	
	private JLabel lblViewCentreListSuccessHeading;
	
	private JTable table;
	
	private JScrollPane tableScrollPane;
	
	private JPanel footerPanel;
	
	private JLabel lblErrorMsg;
	

	//	REDIRECT LISENERS
	
	private RedirectEventListener backRedirect;
	
	private RedirectEventListener logoutRedirect;
	
	
	public void setBackRedirect(RedirectEventListener backRedirect) {
		
		this.backRedirect= backRedirect;
		
	}
	
	public void setLogoutRedirect(RedirectEventListener logoutRedirect) {
		
		this.logoutRedirect= logoutRedirect;
		
	}
	
	
	
	public ViewCentreListSuccess() {
		
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
		
		
		lblViewCentreListSuccessHeading = new JLabel("Centre List");
		
		lblViewCentreListSuccessHeading.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblViewCentreListSuccessHeading.setFont(MainFrame.HEADERFONT);
		
		lblViewCentreListSuccessHeading.setForeground(MainFrame.HEADINGCOLOR);
		
		lblViewCentreListSuccessHeading.setBounds(10, 11, 850, 43);
		
		headingPanel.add(lblViewCentreListSuccessHeading);
		
		
		
		//FOOTER
		
		
		
		footerPanel = new JPanel();
		
		footerPanel.setBounds(0, 356, 870, 61);
		
		footerPanel.setLayout(null);
		
		footerPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		
		lblErrorMsg = new JLabel("Error: Could not populate centre list.");
		
		lblErrorMsg.setForeground(Color.RED);
		
		lblErrorMsg.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblErrorMsg.setFont(MainFrame.FOOTERFONT);
		
		lblErrorMsg.setBounds(10, 11, 850, 43);
		
		lblErrorMsg.setVisible(false);
		
		footerPanel.add(lblErrorMsg);
		
		
		mainPanel.add(footerPanel);
		
		
		//TABLE
		
		table = new JTable();
		
		ViewCentre centreList;
		
		try {
			
			centreList = new ViewCentre();
			
			ArrayList<String[]> aList= new ArrayList<>();
			
			while(centreList.moreCentre()) {
				
				centreList.nextCentre();
				
				String[] temp= {String.valueOf(centreList.getID()),
								centreList.getName(),
								centreList.getRegion(),
								centreList.getState()
								};
				
				aList.add(temp);
			}
			
			int centreSize= aList.size();
			
			String[][] endPointArray= new String[centreSize][4];
			
			for(int ctrOne=0; ctrOne<centreSize; ctrOne++) {
				
				for(int ctrTwo=0; ctrTwo<4; ctrTwo++) {
					
					endPointArray[ctrOne][ctrTwo]= aList.get(ctrOne)[ctrTwo];
					
				}
				
			}
			
			AbstractTableModel aModel= new DefaultTableModel(
					endPointArray,
					new String[] {
						"Centre No", "Centre Name", "Region", "State"
					});
			
			table.setModel(aModel);
			
			
			table.setFont(MainFrame.SMALLLABEL);
			
			table.setBounds(33, 126, 804, 272);
			
			table.setRowHeight(30);
			
			table.getTableHeader().setFont(MainFrame.SMALLLABEL);
			
			table.getTableHeader().setBackground(Color.white);
			
			
			table.getColumnModel().setColumnMargin(10);
			
			table.getColumnModel().getColumn(0).setPreferredWidth(90);
			
			table.getColumnModel().getColumn(0).setMaxWidth(250);
			
			table.getColumnModel().getColumn(1).setPreferredWidth(90);
			
			table.getColumnModel().getColumn(1).setMaxWidth(250);
			
			table.getColumnModel().getColumn(2).setPreferredWidth(90);
			
			table.getColumnModel().getColumn(2).setMaxWidth(250);
			
			table.getColumnModel().getColumn(3).setPreferredWidth(90);
			
			table.getColumnModel().getColumn(3).setMaxWidth(250);
			
			table.setBounds(33, 126, 804, 272);
			

			//mainPanel.add(table);
			
			tableScrollPane = new JScrollPane(table);
			
			tableScrollPane.setBounds(35, 90, 796, 242);
			
			tableScrollPane.setBackground(Color.WHITE);
			
			mainPanel.add(tableScrollPane);
			
		} 
		
		catch (SQLException e) {
			
			showError("Error: Could not populate centre list.");
			
			e.printStackTrace();
			
		} 
		
		catch (ClassNotFoundException e1) {
			
			showError("A fatal error has occured. Please restart the app.");
			
			e1.printStackTrace();
			
		} 
		
		catch (IOException e1) {
			
			showError("A fatal error has occured. Please restart the app.");
			
			e1.printStackTrace();
		}
		
		
	}
	
	public void showError(String error) {
		
		lblErrorMsg.setText(error);
		
		lblErrorMsg.setVisible(true);
		
	}

}

















