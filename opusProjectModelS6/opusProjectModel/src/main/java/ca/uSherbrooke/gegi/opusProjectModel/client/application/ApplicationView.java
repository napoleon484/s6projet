package ca.uSherbrooke.gegi.opusProjectModel.client.application;

import javax.inject.Inject;

import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HeaderPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {
    interface Binder extends UiBinder<Widget, ApplicationView> {
    }

    @UiField VerticalPanel mainVertical;
    @UiField VerticalPanel SelectedItemPanel;
    @UiField MenuBar menuBar;
    @UiField MenuBar SubMenuBar;
    @UiField VerticalPanel SubMenuBarPanel;
    @UiField HTMLPanel SubMenuBarTitle;
    
    // Item 
    @UiField MenuItem btnS1;
    @UiField MenuItem btnS2;
    @UiField MenuItem btnS3;
    @UiField MenuItem btnS4;
    @UiField MenuItem btnS5;
    @UiField MenuItem btnS6;
    @UiField MenuItem btnS7;
    @UiField MenuItem btnS8;
    
    @UiField MenuItem btnQualite1;
    @UiField MenuItem btnQualite2;
    @UiField MenuItem btnQualite3;
    @UiField MenuItem btnQualite4;
    @UiField MenuItem btnQualite5;
    @UiField MenuItem btnQualite6;
    @UiField MenuItem btnQualite7;
    @UiField MenuItem btnQualite8;
    @UiField MenuItem btnQualite9;
    @UiField MenuItem btnQualite10;
    @UiField MenuItem btnQualite11;
    @UiField MenuItem btnQualite12;

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
    		  SubMenuBarTitle.getElement().setInnerHTML("Cours");
    		  CreateSessionSubMenu();
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
    
    
    public void CreateSessionSubMenu()
    {
    	SubMenuBar.clearItems();
        SubMenuBarPanel.setVisible(true);
    	
    	String Cours1Name = "Gen281";
    	String Cours2Name = "Gen282";
    	String Cours3Name = "Gen283";
    	String Cours4Name = "Gen284";
    	String Cours5Name = "Gen285";
    	SubMenuBar.addItem(Cours1Name, new CoursMenuCommand(Cours1Name));
    	SubMenuBar.addItem(Cours2Name, new CoursMenuCommand(Cours2Name));
    	SubMenuBar.addItem(Cours3Name, new CoursMenuCommand(Cours3Name));
    	SubMenuBar.addItem(Cours4Name, new CoursMenuCommand(Cours4Name));
    	SubMenuBar.addItem(Cours5Name, new CoursMenuCommand(Cours5Name));
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
    
    @Inject
    ApplicationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        mainVertical.setWidth("100%");
        SubMenuBarPanel.setVisible(false);
        
        // Add Events to Buttons
        btnS1.setScheduledCommand(new SessionMenuCommand(btnS1.getText()));
        btnS2.setScheduledCommand(new SessionMenuCommand(btnS2.getText()));
        btnS3.setScheduledCommand(new SessionMenuCommand(btnS3.getText()));
        btnS4.setScheduledCommand(new SessionMenuCommand(btnS4.getText()));
        btnS5.setScheduledCommand(new SessionMenuCommand(btnS5.getText()));
        btnS6.setScheduledCommand(new SessionMenuCommand(btnS6.getText()));
        btnS7.setScheduledCommand(new SessionMenuCommand(btnS7.getText()));
        btnS8.setScheduledCommand(new SessionMenuCommand(btnS8.getText()));
        
        btnQualite1.setScheduledCommand(new QualiteMenuCommand(btnQualite1.getText()));
        btnQualite2.setScheduledCommand(new QualiteMenuCommand(btnQualite2.getText()));
        btnQualite3.setScheduledCommand(new QualiteMenuCommand(btnQualite3.getText()));
        btnQualite4.setScheduledCommand(new QualiteMenuCommand(btnQualite4.getText()));
        btnQualite5.setScheduledCommand(new QualiteMenuCommand(btnQualite5.getText()));
        btnQualite6.setScheduledCommand(new QualiteMenuCommand(btnQualite6.getText()));
        btnQualite7.setScheduledCommand(new QualiteMenuCommand(btnQualite7.getText()));
        btnQualite8.setScheduledCommand(new QualiteMenuCommand(btnQualite8.getText()));
        btnQualite9.setScheduledCommand(new QualiteMenuCommand(btnQualite9.getText()));
        btnQualite10.setScheduledCommand(new QualiteMenuCommand(btnQualite10.getText()));
        btnQualite11.setScheduledCommand(new QualiteMenuCommand(btnQualite11.getText()));
        btnQualite12.setScheduledCommand(new QualiteMenuCommand(btnQualite12.getText()));
    }

    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == ApplicationPresenter.SLOT_SetMainContent) {
//        	mainVertical.setWidget(content);
        } else {
            super.setInSlot(slot, content);
        }
    }
}