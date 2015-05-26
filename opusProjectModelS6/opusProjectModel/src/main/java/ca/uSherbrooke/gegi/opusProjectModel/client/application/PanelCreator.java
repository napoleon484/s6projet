package ca.uSherbrooke.gegi.opusProjectModel.client.application;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class PanelCreator 
{
	public static void CreateSessionPanel(HorizontalPanel PanelToInit, String PanelName)
	{
		PanelToInit.add(new Label(PanelName));
	}
	
	public static void CreateQualitePanel(HorizontalPanel PanelToInit, String PanelName)
	{
		PanelToInit.add(new Label("--"+PanelName));
	}
}
