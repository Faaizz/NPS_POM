package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Controller.GetSingleInmate;
import Controller.RedirectEvent;
import Controller.RedirectEventListener;

public class ViewSingleInmateSuccess extends JPanel {
	
	
	private JButton btnBack;
	
	private JButton btnLogout;
	
	private JPanel mainPanel;
	
	private JPanel headingPanel;
	
	private JLabel lblViewSingleInmateSuccessHeading;
	
	private JTable table;
	
	private JPanel footerPanel;
	
	
	//REDIRECT LISTENERS
	
	private RedirectEventListener backRedirect;
	
	private RedirectEventListener logoutRedirect;
	
	
	
	public ViewSingleInmateSuccess(GetSingleInmate foundInmate) {
		
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
		
		
		lblViewSingleInmateSuccessHeading = new JLabel(foundInmate.getName());
		
		lblViewSingleInmateSuccessHeading.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblViewSingleInmateSuccessHeading.setFont(MainFrame.HEADERFONT);
		
		lblViewSingleInmateSuccessHeading.setForeground(MainFrame.HEADINGCOLOR);
		
		lblViewSingleInmateSuccessHeading.setBounds(10, 11, 850, 43);
		
		headingPanel.add(lblViewSingleInmateSuccessHeading);
		
		
		//TABLE
		
		table = new JTable();
		
		AbstractTableModel aModel= new DefaultTableModel(
										new String[][] {
											{"Inmate ID", String.valueOf(foundInmate.getInmateID())},
											{"Centre No", String.valueOf(foundInmate.getCentreID())},
											{"Name", foundInmate.getName()},
											{"Date of Birth", String.valueOf(foundInmate.getDob())},
											{"Gender", foundInmate.getGender()},
											{"PoM Points", String.valueOf(foundInmate.getPoints())},
										},
										new String[] {
											"", ""
										});
		
		
		DefaultTableCellRenderer headerRenderer= new DefaultTableCellRenderer();
		headerRenderer.setHorizontalAlignment(JLabel.TRAILING);
		
		DefaultTableCellRenderer dataRenderer= new DefaultTableCellRenderer();
		dataRenderer.setHorizontalAlignment(JLabel.LEADING);

		table.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		table.setFont(MainFrame.SMALLLABEL);
		
		table.setModel(aModel);
		
		table.setBounds(86, 126, 694, 180);
		
		table.setRowHeight(30);
		
		table.getColumnModel().setColumnMargin(50);
	
		//HEADER COLUMN

		TableColumn headerColumn= table.getColumnModel().getColumn(0);
		
		headerColumn.setCellRenderer(headerRenderer);
		
		headerColumn.setMaxWidth(300);
		
		headerColumn.setPreferredWidth(230);
		
		
		//DATA COLUMN
		
		TableColumn dataColumn= table.getColumnModel().getColumn(1);
		
		dataColumn.setCellRenderer(dataRenderer);
		

		mainPanel.add(table);
		
		
		
		//FOOTER
		
		footerPanel = new JPanel();
		
		footerPanel.setBounds(0, 356, 870, 61);
		
		footerPanel.setLayout(null);
		
		footerPanel.setBorder(new LineBorder(MainFrame.BORDERCOLOR));
		
		mainPanel.add(footerPanel);
		
		
	}
	
	public void setBackRedirect(RedirectEventListener backRedirect) {
		
		this.backRedirect= backRedirect;
		
	}
	
	public void setLogoutRedirect(RedirectEventListener logoutRedirect) {
		
		this.logoutRedirect= logoutRedirect;
		
	}

}

















