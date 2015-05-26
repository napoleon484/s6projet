package ca.uSherbrooke.gegi.opusProjectModel.client.application;

import javax.inject.Inject;


import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {
    interface Binder extends UiBinder<Widget, ApplicationView> {
    }

    @UiField VerticalPanel mainVertical;
    @UiField HorizontalPanel SelectedItemPanel;
    @UiField MenuBar menuBar;
    
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
    	  private final MenuItem item;

    	  public SessionMenuCommand(MenuItem item) {
    	    this.item = item;
    	  }

    	  @Override
    	  public void execute() 
    	  {
    		  SelectedItemPanel.clear();
              PanelCreator.CreateSessionPanel(SelectedItemPanel, item.getText());
    	  }
    }
    
    public class QualiteMenuCommand implements ScheduledCommand 
    {
    	  private final MenuItem item;

    	  public QualiteMenuCommand(MenuItem item) {
    	    this.item = item;
    	  }

    	  @Override
    	  public void execute() 
    	  {
    		  SelectedItemPanel.clear();
              PanelCreator.CreateQualitePanel(SelectedItemPanel, item.getText());
    	  }
    }
    
    @Inject
    ApplicationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        mainVertical.setWidth("100%");
        
        // Add Events to Buttons
        btnS1.setScheduledCommand(new SessionMenuCommand(btnS1));
        btnS2.setScheduledCommand(new SessionMenuCommand(btnS2));
        btnS3.setScheduledCommand(new SessionMenuCommand(btnS3));
        btnS4.setScheduledCommand(new SessionMenuCommand(btnS4));
        btnS5.setScheduledCommand(new SessionMenuCommand(btnS5));
        btnS6.setScheduledCommand(new SessionMenuCommand(btnS6));
        btnS7.setScheduledCommand(new SessionMenuCommand(btnS7));
        btnS8.setScheduledCommand(new SessionMenuCommand(btnS8));
        
        btnQualite1.setScheduledCommand(new QualiteMenuCommand(btnQualite1));
        btnQualite2.setScheduledCommand(new QualiteMenuCommand(btnQualite2));
        btnQualite3.setScheduledCommand(new QualiteMenuCommand(btnQualite3));
        btnQualite4.setScheduledCommand(new QualiteMenuCommand(btnQualite4));
        btnQualite5.setScheduledCommand(new QualiteMenuCommand(btnQualite5));
        btnQualite6.setScheduledCommand(new QualiteMenuCommand(btnQualite6));
        btnQualite7.setScheduledCommand(new QualiteMenuCommand(btnQualite7));
        btnQualite8.setScheduledCommand(new QualiteMenuCommand(btnQualite8));
        btnQualite9.setScheduledCommand(new QualiteMenuCommand(btnQualite9));
        btnQualite10.setScheduledCommand(new QualiteMenuCommand(btnQualite10));
        btnQualite11.setScheduledCommand(new QualiteMenuCommand(btnQualite11));
        btnQualite12.setScheduledCommand(new QualiteMenuCommand(btnQualite12));
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