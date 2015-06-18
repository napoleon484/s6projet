package ca.uSherbrooke.gegi.opusProjectModel.client.application;

import javax.inject.Inject;

import ca.uSherbrooke.gegi.opusProjectModel.shared.dispatch.CoursResult;
import ca.uSherbrooke.gegi.opusProjectModel.shared.dispatch.MenuResult;

import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

class ApplicationView extends ViewWithUiHandlers<ApplicationUiHandlers> implements ApplicationPresenter.MyView {
    interface Binder extends UiBinder<Widget, ApplicationView> {
    }

    @UiField VerticalPanel mainVertical;
    @UiField VerticalPanel SelectedItemPanel;
    @UiField MenuBar menuBar;
    @UiField MenuBar SubMenuBar;
    @UiField VerticalPanel SubMenuBarPanel;
    @UiField HTMLPanel SubMenuBarTitle;
    @UiField MenuBar SessionMenu;
    @UiField MenuBar QualityMenu;

    public class SessionMenuCommand implements ScheduledCommand 
    {
    	  private final String itemName;

    	  public SessionMenuCommand(String itemName) {
    	    this.itemName = itemName;
    	  }

    	  @Override
    	  public void execute() 
    	  {
    		  SelectedItemPanel.clear();
    		  SubMenuBarTitle.getElement().setInnerHTML("Session : ");
    		  getCoursSessionMenu(itemName);
              PanelCreator.CreateSessionPanel(SelectedItemPanel, itemName);
    	  }
    }
    

    public class CoursMenuCommand implements ScheduledCommand 
    {
    	  private final String itemName;

    	  public CoursMenuCommand(String itemName) {
    	    this.itemName = itemName;
    	  }

    	  @Override
    	  public void execute() 
    	  {
    		  SelectedItemPanel.clear();
              PanelCreator.CreateCoursPanel(SelectedItemPanel, itemName);
    	  }
    }
    
    public void getCoursSessionMenu(String itemName)
    {
    	getUiHandlers().GetCoursItem(itemName);
    }
    public void CreateSessionSubMenu(CoursResult coursresult)
    {
    	SubMenuBar.clearItems();
        SubMenuBarPanel.setVisible(true);
        for(String coursName : coursresult.Cours_session)
    	{
        	SubMenuBar.addItem(new MenuItem(coursName, new CoursMenuCommand(coursName)));
    	}
    	
    }
    
    public class QualiteMenuCommand implements ScheduledCommand 
    {
    	  private final String itemName;

    	  public QualiteMenuCommand(String itemName) {
    	    this.itemName = itemName;
    	  }

    	  @Override
    	  public void execute() 
    	  {
    	      SubMenuBarPanel.setVisible(false);
    		  SubMenuBar.clearItems();
    		  SelectedItemPanel.clear();
              PanelCreator.CreateQualitePanel(SelectedItemPanel, itemName);
    	  }
    }
    
    public void CreateMenuItems(MenuResult menuResult)
    {
    	for(String sessionName : menuResult.sessionsName)
    	{
        	SessionMenu.addItem(new MenuItem(sessionName, new SessionMenuCommand(sessionName)));
    	}
    	for(String qualityName : menuResult.QualityName)
    	{
        	QualityMenu.addItem(new MenuItem(qualityName, new QualiteMenuCommand(qualityName)));
    	}
    }
    
    
    
    @Inject
    ApplicationView(Binder uiBinder) 
    {
        initWidget(uiBinder.createAndBindUi(this));
        mainVertical.setWidth("100%");
        SubMenuBarPanel.setVisible(false);
    }

    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == ApplicationPresenter.SLOT_SetMainContent) {
        } else {
            super.setInSlot(slot, content);
        }
    }
}