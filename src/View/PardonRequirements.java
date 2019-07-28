package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.CellRendererPane;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import Controller.RedirectEvent;
import Controller.RedirectEventListener;
import Controller.ViewCentre;

public class PardonRequirements extends JPanel {
	
	
	private JButton btnBack;
	
	private JButton btnLogout;
	
	private JPanel mainPanel;
	
	private JPanel headingPanel;
	
	private JLabel lblPardonRequirementsHeading;
	
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
	
	
	
	public PardonRequirements() {
		
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
		
		
		lblPardonRequirementsHeading = new JLabel("Pardon Requirements");
		
		lblPardonRequirementsHeading.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblPardonRequirementsHeading.setFont(MainFrame.HEADERFONT);
		
		lblPardonRequirementsHeading.setForeground(MainFrame.HEADINGCOLOR);
		
		lblPardonRequirementsHeading.setBounds(10, 11, 850, 43);
		
		headingPanel.add(lblPardonRequirementsHeading);
		
		
		//FOOTER
		
		
		
		footerPanel = new JPanel();
		
		footerPanel.setBounds(0, 356, 870, 61);
		
		footerPanel.setLayout(null);
		
		footerPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		mainPanel.add(footerPanel);
		
		
		//TABLE
		
		table = new JTable();		
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{"Change from old ways", "30", "=120"},
					{"Good Behaviour", "30", "=120"},
					{"Conduct", "20", "=80"},
					{"Attitude towards work", "20", "=80"},
					{"Total", "100", "=400"},
				},
				new String[] {
					"Section", "Minimum Contribution (%)", "Minimum Points"
				}
			));		
		
		table.setFont(MainFrame.SMALLLABEL);
		
		table.setBounds(33, 126, 804, 272);
		
		table.setRowHeight(30);
		
		table.getTableHeader().setFont(MainFrame.SMALLLABEL);
		
		table.getTableHeader().setBackground(Color.white);
		
		DefaultTableCellRenderer centreAlignment= new DefaultTableCellRenderer();
		
		centreAlignment.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		table.getColumnModel().setColumnMargin(10);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		
		table.getColumnModel().getColumn(0).setMaxWidth(300);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		
		table.getColumnModel().getColumn(1).setMaxWidth(300);
		
		table.getColumnModel().getColumn(1).setCellRenderer(centreAlignment);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		
		table.getColumnModel().getColumn(2).setMaxWidth(150);
		
		table.getColumnModel().getColumn(2).setCellRenderer(centreAlignment);
		
		table.setBounds(33, 126, 804, 272);
			
		
		tableScrollPane = new JScrollPane(table);
		
		tableScrollPane.setBounds(130, 90, 601, 177);
		
		tableScrollPane.setBackground(Color.WHITE);
		
		mainPanel.add(tableScrollPane);
		
		
	}

}
















