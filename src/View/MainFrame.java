package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Controller.GetSingleInmate;
import Controller.InmatePoints;
import Controller.PardonListSwingWorker;
import Controller.RedirectEvent;
import Controller.RedirectEventListener;
import Controller.ViewCentre;

public class MainFrame extends JFrame{
	
	public static Color BORDERCOLOR= new Color(180, 180, 180);
	
	public static Color HEADINGCOLOR= new Color(56, 87, 35);
	
	public static Color TEALGREEN= new Color(226, 240, 217);
	
	public static Font HEADERFONT= new Font("Tahoma", Font.PLAIN, 24);
	
	public static Font HEADINGFONT= new Font("Tahoma", Font.PLAIN, 20);
	
	public static Font INPUTLABEL= new Font("Tahoma", Font.PLAIN, 18);
	
	public static Font SMALLLABEL= new Font("Tahoma", Font.PLAIN, 16);
	
	public static Font FOOTERFONT= new Font("Tahoma", Font.PLAIN, 14);
	
	public static Cursor HANDCURSOR= new Cursor(Cursor.HAND_CURSOR);
	
	public static ImageIcon SUCCESSIMAGE= new ImageIcon("./img/success.png");
	
	public static ImageIcon FAILUREIMAGE= new ImageIcon("./img/failure.jpg");
	
	public static ImageIcon LOADINGICON= new ImageIcon("./img/loading.gif");
	
	public static String NUMBERFORMATERROR= "You have made invalid entries. Please retry.";
	
	public static void printLog(String message) {
		
		File logFile= new File("./files/logfile.log");		//FILE TO REDIRECT CONSOLE OUTPUT
		
		try {
			
			FileOutputStream outStream= new FileOutputStream(logFile, true);
			
			PrintWriter logStream= new PrintWriter(outStream);
			
			logStream.println(message);
			
			logStream.close();
			
		} 
		
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
	
	private LandingPage aLandingPage;
	
	private HomePage aHomePage;
	
	private AddInmate anAddInmate;
	
	private AddInmateSuccess anAddInmateSuccess;
	
	private AddCentreSuccess anAddCentreSuccess;
	
	private AddCentre anAddCentre;
	
	private ViewSingleInmate aViewSingleInmate;
	
	private ViewInmatesByCentre aViewInmatesByCentre;
	
	private PublishListFailure aPublishListFailure;
	
	private ViewInmatePoints aViewInmatePoints;
	
	private AllotInmatePointsSuccess anAllotInmatePointsSuccess;
	
	private AllotInmatePoints anAllotInmatePoints;
	
	private ViewSingleInmateSuccess aViewSingleInmateSuccess;
	
	private ViewInmatesByCentreSuccess aViewInmatesByCentreSuccess;
	
	private ViewInmatePointsSuccess aViewInmatePointsSuccess;
	
	private PublishListSuccess aPublishListSuccess;
	
	private ViewCentreListSuccess aViewCentreListSuccess;;
	
	private Settings settingsPage;
	
	private PardonRequirements aPardonRequirements;
	
	private PointsChart aPointsChart;
	
	private JLabel loadingLabel= new JLabel();
	
	
	
	public MainFrame() {
		
		this.setTitle("NPS Prerogative of Mercy");
		
		this.setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setBounds(140, 100, 960, 600);
		
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		printLog("--------------------------");
		printLog(LocalDate.now() + "---" + LocalTime.now() + "---" + "Program Launch");
		
		configureLoadingIcon();
		
		initializeLandingPage();
		
		
		
		//All pages must be initialised before the JFrame is set to be visible otherwise they would not be displayed
		
		this.setVisible(true);
	
	}
	
	private void addToContentPane(JPanel page) {
		
		this.getContentPane().add(page);

	}
	
	private void removeFromContentPane(JPanel page) {
		
		page.setVisible(false);
		
		this.getContentPane().remove(page);
		
	}
	
	public void configureLoadingIcon() {
		
		loadingLabel.setIcon(LOADINGICON);
		
		loadingLabel.setBounds(350, 123, 240, 169);
		
	}
	
	
	
	//	B	A	C	K		R	E	D	I	R	E	C	T
	
	private Stack<JPanel> backStack= new Stack<>();
	
	private RedirectEventListener backRedirect(final JPanel currentPage) {
		
		return(
				new RedirectEventListener() {
					
					@Override
					public void redirectActionPerformed(RedirectEvent e) {
						
						removeFromContentPane(currentPage);
						
						initializePreviousPage();
						
					}
				}
				
				);
		
	}
	
	
	private void initializePreviousPage() {
		
		JPanel previousPage= this.backStack.pop();
		
		previousPage.setVisible(true);
		
		addToContentPane(previousPage);
		
	}
	
	private void setPreviousPage(JPanel page) {
		
		this.backStack.push(page);
		
	}
	
	
	//	L	O	G	O	U	T		R	E	D	I	R	E	C	T
	
	private RedirectEventListener logoutRedirectAction(final JPanel currentPage) {
		
		/*This method returns a RedirectEventListener that redirects to the landing page on logout*/
		
		return(
				new RedirectEventListener() {
					
					@Override
					public void redirectActionPerformed(RedirectEvent e) {
						
						removeFromContentPane(currentPage);
						
						initializeLandingPage();
						
					}
				}
				);
		
	}
	
	//L	A	N	D	I	N	G		P	A	G	E
	
	private void initializeLandingPage() {
		
		aLandingPage= new LandingPage();
		
		addToContentPane(aLandingPage);
		
		aLandingPage.setHomePageRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(aLandingPage);
				
				initializeHomePage();
				
				setPreviousPage(aLandingPage);
				
			}
		});
		
		aLandingPage.setSettingsRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(aLandingPage);
				
				initializeSettingsPage();
				
				setPreviousPage(aLandingPage);
				
			}
		});
		
	}
	
	
	//H	O	M	E		P	A	G	E
	
	private void initializeHomePage() {
		
		aHomePage= new HomePage();
		
		addToContentPane(aHomePage);
		
		aHomePage.setAddInmateRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(aHomePage);
				
				initializeAddInmate();
				
				setPreviousPage(aHomePage);
				
			}
		});
		
		aHomePage.setViewSingleInmateRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(aHomePage);
				
				initializeViewSingleInmate();
				
				setPreviousPage(aHomePage);
				
			}
		});
		
		aHomePage.setViewInmatesByCentreRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(aHomePage);
				
				initializeViewInmatesByCentre();
				
				setPreviousPage(aHomePage);
				
			}
		});
		
		aHomePage.setAllotInmatePointsRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(aHomePage);
				
				initializeAllotInmatePoints();
				
				setPreviousPage(aHomePage);
				
			}
		});
		
		aHomePage.setViewInmatePointsRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(aHomePage);
				
				initializeViewInmatePoints();
				
				setPreviousPage(aHomePage);
				
			}
		});
		
		aHomePage.setPublishPardonListRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(aHomePage);
				
				initializePublishList();
				
				setPreviousPage(aHomePage);
				
			}
		});
		
		aHomePage.setAddCentreRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(aHomePage);
				
				initializeAddCentre();
				
				setPreviousPage(aHomePage);
				
			}
		});
		
		aHomePage.setViewCentreRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(aHomePage);
				
				initializeViewCentreList();
				
				setPreviousPage(aHomePage);
				
			}
		});
		
		aHomePage.setLogoutRedirect(logoutRedirectAction(aHomePage));
		
	}
	
	
	//	S	E	T	T	I	N	G	S
	
	private void initializeSettingsPage() {
		
		settingsPage= new Settings();
		
		addToContentPane(settingsPage);
		
		settingsPage.setBackRedirect(backRedirect(settingsPage));
		
	}
	
	
	
	//	A	D	D		I	N	M	A	T	E
	
	private void initializeAddInmate() {
		
		anAddInmate= new AddInmate();
		
		addToContentPane(anAddInmate);
		
		anAddInmate.setBackRedirect(backRedirect(anAddInmate));
		
		anAddInmate.setLogoutRedirect(logoutRedirectAction(anAddInmate));
		
		anAddInmate.setAddInmateRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(anAddInmate);
				
				initializeAddInmateSuccess();
				
				setPreviousPage(anAddInmate);
				
			}
		});
		
	}
	
	private void initializeAddInmateSuccess() {
		
		anAddInmateSuccess= new AddInmateSuccess();
		
		addToContentPane(anAddInmateSuccess);
		
		anAddInmateSuccess.setBackRedirect(backRedirect(anAddInmateSuccess));
		
		anAddInmateSuccess.setLogoutRedirect(logoutRedirectAction(anAddInmateSuccess));
		
		anAddInmateSuccess.setHomeRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(anAddInmateSuccess);
				
				initializeHomePage();
				
				setPreviousPage(anAddInmateSuccess);
				
			}
		});
		
	}
	
	
	//	V	I	E	W		S	I	N	G	L	E		I	N	M	A	T	E
	
	private void initializeViewSingleInmate() {
		
		aViewSingleInmate= new ViewSingleInmate();
		
		addToContentPane(aViewSingleInmate);
		
		aViewSingleInmate.setBackRedirect(backRedirect(aViewSingleInmate));
		
		aViewSingleInmate.setLogoutRedirect(logoutRedirectAction(aViewSingleInmate));
		
		aViewSingleInmate.setFindInmateRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(aViewSingleInmate);
				
				initializeViewSingleInmateSuccess(aViewSingleInmate.getInmate());
				
				setPreviousPage(aViewSingleInmate);
				
			}
		});
		
	}
	
	private void initializeViewSingleInmateSuccess(GetSingleInmate foundInmate) {
		
		aViewSingleInmateSuccess= new ViewSingleInmateSuccess(foundInmate);
		
		addToContentPane(aViewSingleInmateSuccess);
		
		aViewSingleInmateSuccess.setBackRedirect(backRedirect(aViewSingleInmateSuccess));
		
		aViewSingleInmateSuccess.setLogoutRedirect(logoutRedirectAction(aViewSingleInmateSuccess));

	}
	
	
	//	V	I	E	W		I	N	M	A	T	E	S		B	Y		C	E	N	T	R	E
	
	private void initializeViewInmatesByCentre() {
		
		aViewInmatesByCentre= new ViewInmatesByCentre();
		
		addToContentPane(aViewInmatesByCentre);
		
		aViewInmatesByCentre.setBackRedirect(backRedirect(aViewInmatesByCentre));
		
		aViewInmatesByCentre.setLogoutRedirect(logoutRedirectAction(aViewInmatesByCentre));
		
		aViewInmatesByCentre.setFindInmatesRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(aViewInmatesByCentre);
				
				initializeViewInmatesByCentreSuccess(aViewInmatesByCentre.getResult());
				
				setPreviousPage(aViewInmatesByCentre);
				
			}
		});
		
	}
	
	private void initializeViewInmatesByCentreSuccess(Controller.ViewInmatesByCentre result) {
		
		aViewInmatesByCentreSuccess= new ViewInmatesByCentreSuccess(result);
		
		addToContentPane(aViewInmatesByCentreSuccess);
		
		aViewInmatesByCentreSuccess.setBackRedirect(backRedirect(aViewInmatesByCentreSuccess));
		
		aViewInmatesByCentreSuccess.setLogoutRedirect(logoutRedirectAction(aViewInmatesByCentreSuccess));
		
	}
	
	
	//	A	L	L	O	T		I	N	M	A	T	E		P	O	I	N	T	S
	
	private void initializeAllotInmatePoints() {
		
		anAllotInmatePoints= new AllotInmatePoints();
		
		addToContentPane(anAllotInmatePoints);
		
		anAllotInmatePoints.setBackRedirect(backRedirect(anAllotInmatePoints));
		
		anAllotInmatePoints.setLogoutRedirect(logoutRedirectAction(anAllotInmatePoints));
		
		anAllotInmatePoints.setAllotPointsRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(anAllotInmatePoints);
				
				initializeAllotInmatePointsSuccess();
				
				setPreviousPage(anAllotInmatePoints);
				
			}
		});
		
		anAllotInmatePoints.setPointsChartRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(anAllotInmatePoints);
				
				initializePointsChart();
				
				setPreviousPage(anAllotInmatePoints);
				
			}
		});
		
	}
	
	private void initializeAllotInmatePointsSuccess() {
		
		anAllotInmatePointsSuccess= new AllotInmatePointsSuccess();
		
		addToContentPane(anAllotInmatePointsSuccess);
		
		anAllotInmatePointsSuccess.setBackRedirect(backRedirect(anAllotInmatePointsSuccess));
		
		anAllotInmatePointsSuccess.setLogoutRedirect(logoutRedirectAction(anAllotInmatePointsSuccess));		
		
		anAllotInmatePointsSuccess.setToHomeRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(anAllotInmatePointsSuccess);
				
				initializeHomePage();
				
				setPreviousPage(anAllotInmatePointsSuccess);
				
			}
		});
		
	}
	
	
	//	V	I	E	W		I	N	M	A	T	E		P	O	I	N	T	S
	
	private void initializeViewInmatePoints() {
		
		aViewInmatePoints= new ViewInmatePoints();
		
		addToContentPane(aViewInmatePoints);
		
		aViewInmatePoints.setBackRedirect(backRedirect(aViewInmatePoints));
		
		aViewInmatePoints.setLogoutRedirect(logoutRedirectAction(aViewInmatePoints));
		
		aViewInmatePoints.setInmatePointsRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(aViewInmatePoints);
				
				initializeViewInmatePointsSuccess(aViewInmatePoints.getInmatePoints());
				
				setPreviousPage(aViewInmatePoints);
				
			}
		});
		
	}
	
	private void initializeViewInmatePointsSuccess(InmatePoints inmatePoints) {
		
		aViewInmatePointsSuccess= new ViewInmatePointsSuccess(inmatePoints);
		
		addToContentPane(aViewInmatePointsSuccess);
		
		aViewInmatePointsSuccess.setBackRedirect(backRedirect(aViewInmatePointsSuccess));
		
		aViewInmatePointsSuccess.setLogoutRedirect(logoutRedirectAction(aViewInmatePointsSuccess));
		
	}
	
	//	P	U	B	L	I	S	H		L	I	S	T
	
	private void initializePublishList() {
		
		aPublishListSuccess= new PublishListSuccess(loadingLabel);
		
		addToContentPane(aPublishListSuccess);
		
		aPublishListSuccess.setFailedPublishRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(aPublishListSuccess);
				
				initializePublishListFailure();
				
				setPreviousPage(aPublishListSuccess);
				
			}
		});
		
		aPublishListSuccess.setPardonRequirementsRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(aPublishListSuccess);
				
				initializePardonRequirements();
				
				setPreviousPage(aPublishListSuccess);
				
			}
		});
		
		//aPublishListSuccess.drawTable();
		
		PardonListSwingWorker aSwingWorker= new PardonListSwingWorker(aPublishListSuccess);
		
		aSwingWorker.execute();
		
		aPublishListSuccess.setBackRedirect(backRedirect(aPublishListSuccess));
		
		aPublishListSuccess.setLogoutRedirect(logoutRedirectAction(aPublishListSuccess));
		
	}
	
	private void initializePublishListFailure() {
		
		aPublishListFailure= new PublishListFailure();
		
		addToContentPane(aPublishListFailure);
		
		aPublishListFailure.setBackRedirect(backRedirect(aPublishListFailure));
		
		aPublishListFailure.setLogoutRedirect(logoutRedirectAction(aPublishListFailure));
		
		aPublishListFailure.setToHomeRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(aPublishListFailure);
				
				initializeHomePage();
				
				setPreviousPage(aPublishListFailure);
				
			}
		});
		
	}
	
	//	A	D	D		C	E	N	T	R	E
	
	private void initializeAddCentre() {
		
		anAddCentre= new AddCentre();
		
		addToContentPane(anAddCentre);
		
		anAddCentre.setBackRedirect(backRedirect(anAddCentre));
		
		anAddCentre.setLogoutRedirect(logoutRedirectAction(anAddCentre));
		
		anAddCentre.setAddCentreRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(anAddCentre);
				
				initializeAddCentreSuccess();
				
				setPreviousPage(anAddCentre);
				
			}
		});
		
	}
	
	private void initializeAddCentreSuccess() {
		
		anAddCentreSuccess= new AddCentreSuccess();
		
		addToContentPane(anAddCentreSuccess);
		
		anAddCentreSuccess.setBackRedirect(backRedirect(anAddCentreSuccess));
		
		anAddCentreSuccess.setLogoutRedirect(logoutRedirectAction(anAddCentreSuccess));
		
		anAddCentreSuccess.setHomeRedirect(new RedirectEventListener() {
			
			@Override
			public void redirectActionPerformed(RedirectEvent e) {
				
				removeFromContentPane(anAddCentreSuccess);
				
				initializeHomePage();
				
				setPreviousPage(anAddCentreSuccess);
				
			}
		});
		
	}
	
	
	//	V	I	E	W		C	E	N	T	R	E		L	I	S	T
	
	private void initializeViewCentreList() {
		
		aViewCentreListSuccess= new ViewCentreListSuccess();
		
		addToContentPane(aViewCentreListSuccess);
		
		aViewCentreListSuccess.setBackRedirect(backRedirect(aViewCentreListSuccess));
		
		aViewCentreListSuccess.setLogoutRedirect(logoutRedirectAction(aViewCentreListSuccess));
		
	}
	
	//	P	A	R	D	O	N		R	E	Q	U	I	R	E	M	E	N	T	S
	
	public void initializePardonRequirements() {
		
		aPardonRequirements= new PardonRequirements();
		
		addToContentPane(aPardonRequirements);
		
		aPardonRequirements.setBackRedirect(backRedirect(aPardonRequirements));
		
		aPardonRequirements.setLogoutRedirect(logoutRedirectAction(aPardonRequirements));
		
	}
	
	//	P	O	I	N	T	S		C	H	A	R	T
	
	public void initializePointsChart() {
		
		aPointsChart= new PointsChart();
		
		addToContentPane(aPointsChart);
		
		aPointsChart.setBackRedirect(backRedirect(aPointsChart));
		
		aPointsChart.setLogoutRedirect(logoutRedirectAction(aPointsChart));
		
	}


	
}














