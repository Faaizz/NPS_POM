package Controller;

import View.MainFrame;
import View.PublishListSuccess;
import javax.swing.SwingWorker;

public class PardonListSwingWorker extends SwingWorker<PardonList, PublishListSuccess> {
	
	private PublishListSuccess aPublishListSuccess;
	
	private PardonList aPardonList;
	
	public PardonListSwingWorker(PublishListSuccess aPublishListSuccess) {
		
		this.aPublishListSuccess= aPublishListSuccess;
		
	}

	@Override
	protected PardonList doInBackground() throws Exception {
		
		this.aPardonList= new PardonList();
		
		return aPardonList;
		
	}
	
	@Override	
	protected void done() {
		
		this.aPublishListSuccess.hideLoadingIcon();
		
		this.aPublishListSuccess.drawTable(this.aPardonList);
		
	}

}
