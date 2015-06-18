package ca.uSherbrooke.gegi.opusProjectModel.server.dispatch;

import java.util.List;

import javax.persistence.EntityManager;

import ca.uSherbrooke.gegi.opusProjectModel.shared.dispatch.MenuAction;
import ca.uSherbrooke.gegi.opusProjectModel.shared.dispatch.MenuResult;

import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class MenuActionHandler implements ActionHandler<MenuAction, MenuResult>{

	@Inject EntityManager em;
	@Override
	public MenuResult execute(MenuAction action, ExecutionContext context)
			throws ActionException 
	{
		MenuResult  menuResult = new MenuResult();
		menuResult.sessionsName.addAll(em.createNativeQuery("SELECT short_description FROM note.educationnal_goal where short_description like '%session%'").getResultList());
		menuResult.QualityName.addAll(em.createNativeQuery("SELECT label FROM note.quality").getResultList());
		return menuResult;
	}

	@Override
	public void undo(MenuAction action, MenuResult result,
			ExecutionContext context) throws ActionException {
		
	}

	@Override
	public Class<MenuAction> getActionType() {
		return null;
	}
}
