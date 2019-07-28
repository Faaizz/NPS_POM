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

import Controller.PardonList;
import Controller.RedirectEvent;
import Controller.RedirectEventListener;

public class PublishListSuccess extends JPanel {
	
	
	private JButton btnBack;
	
	private JButton btnLogout;
	
	private JButton btnPardonRequirements;
	
	private JPanel mainPanel;
	
	private JPanel headingPanel;
	
	private JLabel lblPublishListSuccessHeading;
	
	private JTable table;
	
	private JScrollPane tableScrollPane;
	
	private JPanel footerPanel;
	
	private JLabel loadingIcon;
	
	
	//	REDIRECT LISENERS
	
	private RedirectEventListener backRedirect;
	
	private RedirectEventListener logoutRedirect;
	
	private RedirectEventListener failedPublishRedirect;
	
	private RedirectEventListener pardonRedirect;
	
	
	public void setBackRedirect(RedirectEventListener backRedirect) {
		
		this.backRedirect= backRedirect;
		
	}
	
	public void setLogoutRedirect(RedirectEventListener logoutRedirect) {
		
		this.logoutRedirect= logoutRedirect;
		
	}
	
	public void setFailedPublishRedirect(RedirectEventListener failedPublishRedirect) {
		
		this.failedPublishRedirect= failedPublishRedirect;
		
	}
	
	public void setPardonRequirementsRedirect(RedirectEventListener pardonRedirect) {
		
		this.pardonRedirect= pardonRedirect;
		
	}
	
	
	public PublishListSuccess(JLabel loadingIcon) {
		
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
		
		
		btnPardonRequirements = new JButton("pardon requirements");
		
		btnPardonRequirements.setFont(MainFrame.SMALLLABEL);
		
		btnPardonRequirements.setBackground(MainFrame.TEALGREEN);
		
		btnPardonRequirements.setCursor(MainFrame.HANDCURSOR);
		
		btnPardonRequirements.setBounds(355, 38, 250, 40);
		
		btnPardonRequirements.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				RedirectEvent pardonEvent= new RedirectEvent(this);
				
				pardonRedirect.redirectActionPerformed(pardonEvent);
				
			}
		});
		
		add(btnPardonRequirements);
		
		
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
		
		
		lblPublishListSuccessHeading = new JLabel("Pardon List");
		
		lblPublishListSuccessHeading.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblPublishListSuccessHeading.setFont(MainFrame.HEADERFONT);
		
		lblPublishListSuccessHeading.setForeground(MainFrame.HEADINGCOLOR);
		
		lblPublishListSuccessHeading.setBounds(10, 11, 850, 43);
		
		headingPanel.add(lblPublishListSuccessHeading);
		

		//LOADING ICON
		
		this.loadingIcon= loadingIcon;
		
		mainPanel.add(loadingIcon);
		
		
		//FOOTER
		
		footerPanel = new JPanel();
		
		footerPanel.setBounds(0, 356, 870, 61);
		
		footerPanel.setLayout(null);
		
		footerPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		mainPanel.add(footerPanel);	
		
		
	}
	
	public void drawTable(PardonList pardonList){
		
		//TABLE

		table = new JTable();
	
		//try 
		{
			/*
			PardonList pardonList = new PardonList();
			*/
			
			ArrayList<String[]> theList = new ArrayList<>();
			
			while(pardonList.moreInmates()) {
				
				pardonList.nextInmate();
				
				String[] temp= {String.valueOf(pardonList.getInmateID()),
								pardonList.getName(),
								String.valueOf(pardonList.getCentreID()),
								String.valueOf(pardonList.getPoints())
										};
				
				theList.add(temp);
				
			}
			
			int listSize= theList.size();
			
			String[][] endpointArray= new String[listSize][4];
			
			for(int ctrOne= 0; ctrOne < listSize; ctrOne++) {
				
				for(int ctrTwo=0; ctrTwo < 4; ctrTwo++) {
					
					endpointArray[ctrOne][ctrTwo]= theList.get(ctrOne)[ctrTwo];
					
				}
				
			}
			
			AbstractTableModel aModel= new DefaultTableModel(
					endpointArray,
					new String[] {
						"Inmate ID", "Inmate Name", "Centre No", "Total Points"
					}
				);
			
			table.setFont(MainFrame.SMALLLABEL);
			
			table.setModel(aModel);
			
			table.setBounds(33, 126, 804, 272);
			
			table.setRowHeight(30);
			
			table.getTableHeader().setFont(MainFrame.SMALLLABEL);
			
			table.getTableHeader().setBackground(Color.white);
			
			
			table.getColumnModel().setColumnMargin(10);
			
			table.getColumnModel().getColumn(0).setPreferredWidth(90);
			
			table.getColumnModel().getColumn(0).setMaxWidth(150);
			
			table.getColumnModel().getColumn(1).setPreferredWidth(230);
			
			table.getColumnModel().getColumn(1).setMaxWidth(350);
			
			table.getColumnModel().getColumn(2).setPreferredWidth(90);
			
			table.getColumnModel().getColumn(2).setMaxWidth(150);
			
			table.getColumnModel().getColumn(3).setPreferredWidth(90);
			
			table.getColumnModel().getColumn(3).setMaxWidth(150);
			
			table.setBounds(33, 126, 804, 272);
			

			//mainPanel.add(table);
			
			tableScrollPane = new JScrollPane(table);
			
			tableScrollPane.setBounds(63, 90, 765, 242);
			
			tableScrollPane.setBackground(Color.WHITE);
			
			mainPanel.add(tableScrollPane);
			
		} /*
		
		catch (SQLException e1) {
			
			RedirectEvent failedPublish= new RedirectEvent(this);
			
			failedPublishRedirect.redirectActionPerformed(failedPublish);
			
			e1.printStackTrace();
			
		} 
		
		catch (ClassNotFoundException e) {
			
			RedirectEvent failedPublish= new RedirectEvent(this);
			
			failedPublishRedirect.redirectActionPerformed(failedPublish);
			
			e.printStackTrace();
		
		} 
		
		catch (IOException e) {
			
			RedirectEvent failedPublish= new RedirectEvent(this);
			
			failedPublishRedirect.redirectActionPerformed(failedPublish);
			
			e.printStackTrace();
			
		}
		*/
		
		
	}
	
	public void hideLoadingIcon() {
		
		this.loadingIcon.setVisible(false);
		
		mainPanel.remove(loadingIcon);
		
	}

}

















