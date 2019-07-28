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

import Controller.RedirectEvent;
import Controller.RedirectEventListener;

public class ViewInmatesByCentreSuccess extends JPanel {
	
	
	private JButton btnBack;
	
	private JButton btnLogout;
	
	private JPanel mainPanel;
	
	private JPanel headingPanel;
	
	private JLabel lblViewInmatesByCentreSuccessHeading;
	
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
	
	
	
	public ViewInmatesByCentreSuccess(Controller.ViewInmatesByCentre searchResult) {
		
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
		
		
		lblViewInmatesByCentreSuccessHeading = new JLabel(searchResult.getCentreName());
		
		lblViewInmatesByCentreSuccessHeading.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblViewInmatesByCentreSuccessHeading.setFont(MainFrame.HEADERFONT);
		
		lblViewInmatesByCentreSuccessHeading.setForeground(MainFrame.HEADINGCOLOR);
		
		lblViewInmatesByCentreSuccessHeading.setBounds(10, 11, 850, 43);
		
		headingPanel.add(lblViewInmatesByCentreSuccessHeading);
		
		
		//TABLE
		
		table = new JTable();
		
		
		ArrayList<String[]> inmatesList= new ArrayList<>();		
		
		while(searchResult.moreInmates()) {
			
			
			
			searchResult.nextInmate();
			
			String[] temp= {String.valueOf(searchResult.getInmateID()), 
							searchResult.getName(),
							searchResult.getDob().toString(),
							searchResult.getGender(),
							String.valueOf(searchResult.getPoints())
							};
			
			inmatesList.add(temp);	//The ArrayList is populated with String arrays of the details of each inmate
			
			
		}
		
		String[][] endpointArray= new String[inmatesList.size()][5];
		
		for(int ctrOne= 0; ctrOne < inmatesList.size(); ctrOne++){
			
			for(int ctrTwo= 0; ctrTwo < 5; ctrTwo++) {
				
				endpointArray[ctrOne][ctrTwo]= inmatesList.get(ctrOne)[ctrTwo];
				
			}			
						
		}
		
		AbstractTableModel aModel= new DefaultTableModel(
				endpointArray,
				new String[] {
					"Inmate ID", "Name", "Date of Birth", "Gender", "PoM Points"
				}
			);
		
		
		DefaultTableCellRenderer headerRenderer= new DefaultTableCellRenderer();
		headerRenderer.setHorizontalAlignment(JLabel.TRAILING);
		
		DefaultTableCellRenderer dataRenderer= new DefaultTableCellRenderer();
		dataRenderer.setHorizontalAlignment(JLabel.LEADING);
		
		table.setFont(MainFrame.SMALLLABEL);
		
		table.setModel(aModel);
		
		table.setBounds(33, 126, 804, 272);
		
		table.setRowHeight(30);
		
		table.getTableHeader().setFont(MainFrame.SMALLLABEL);
		
		table.getTableHeader().setBackground(Color.white);
		
		
		table.getColumnModel().setColumnMargin(10);
		
		table.getColumnModel().getColumn(0).setMaxWidth(100);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		
		table.getColumnModel().getColumn(1).setMaxWidth(350);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		
		table.getColumnModel().getColumn(2).setMaxWidth(250);
		
		table.getColumnModel().getColumn(3).setMaxWidth(100);
		
		table.getColumnModel().getColumn(4).setMaxWidth(100);
		

		//mainPanel.add(table);
		
		tableScrollPane = new JScrollPane(table);
		
		tableScrollPane.setBounds(33, 91, 804, 242);
		
		tableScrollPane.setBackground(Color.WHITE);
		
		mainPanel.add(tableScrollPane);
		
		
		
		//FOOTER
		
		footerPanel = new JPanel();
		
		footerPanel.setBounds(0, 356, 870, 61);
		
		footerPanel.setLayout(null);
		
		footerPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		mainPanel.add(footerPanel);
		
		
	}

}

















