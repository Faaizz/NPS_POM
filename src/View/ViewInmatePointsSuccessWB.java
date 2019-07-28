package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;

public class ViewInmatePointsSuccessWB {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewInmatePointsSuccessWB window = new ViewInmatePointsSuccessWB();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewInmatePointsSuccessWB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 960, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(panel);
		panel.setLayout(null);
		
		JButton btnLogout = new JButton("logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnLogout.setBounds(814, 38, 100, 40);
		
		panel.add(btnLogout);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(44, 89, 870, 417);
		panel.add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel headingPanel = new JPanel();
		headingPanel.setBounds(0, 0, 870, 61);
		headingPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainPanel.add(headingPanel);
		headingPanel.setLayout(null);
		
		JLabel lblAddInmateHeading = new JLabel("View Single Inmate");
		lblAddInmateHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddInmateHeading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddInmateHeading.setBounds(10, 11, 850, 43);
		headingPanel.add(lblAddInmateHeading);
		
		JPanel footerPanel = new JPanel();
		footerPanel.setBounds(0, 356, 870, 61);
		footerPanel.setLayout(null);
		footerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainPanel.add(footerPanel);
		
	
		
		table = new JTable();
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		int[][] allPoints= {{10, 10, 10, 10}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
							{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
		
	
		
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
					"Month", "Change from old ways", "Good behaviour", "Conduct", "Attitude towards work", "TotalPoints"
				}
			);
		table.setModel(aModel);
		table.getColumnModel().getColumn(0).setMaxWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setMaxWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(15);
		table.getColumnModel().getColumn(2).setMaxWidth(150);
		table.getColumnModel().getColumn(3).setMaxWidth(150);
		table.getColumnModel().getColumn(4).setMaxWidth(200);
		table.getColumnModel().getColumn(5).setMaxWidth(100);
		table.setBounds(33, 126, 804, 272);
		table.setRowHeight(30);
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.getTableHeader().setBackground(Color.white);
		
	
		
		DefaultTableCellRenderer headerRenderer= new DefaultTableCellRenderer();
		headerRenderer.setHorizontalAlignment(JLabel.TRAILING);

		//mainPanel.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(29, 91, 819, 242);
		scrollPane.setBackground(Color.WHITE);
		mainPanel.add(scrollPane);
		
		JButton btnBack = new JButton("back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(44, 38, 100, 40);
		panel.add(btnBack);
	}
}
