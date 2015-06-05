package ca.uSherbrooke.gegi.opusProjectModel.client.application;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Label;

public class PanelCreator 
{
	public static void CreateSessionPanel(Panel PanelToInit, String PanelName)
	{
		PanelToInit.add(new HTMLPanel("h3", "Description de la session "+ PanelName));
		PanelToInit.add(new Label("Choisissez un cours a gauche"));
	}
	
	public static void CreateQualitePanel(Panel PanelToInit, String PanelName)
	{
		PanelToInit.add(new HTMLPanel("h3", PanelName));
	}
	
	public static void CreateCoursPanel(Panel PanelToInit, String PanelName)
	{
		PanelToInit.add(new HTMLPanel("h3", PanelName));
	}
}
