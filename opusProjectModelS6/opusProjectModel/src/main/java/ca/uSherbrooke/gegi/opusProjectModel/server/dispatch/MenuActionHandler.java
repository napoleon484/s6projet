package ca.uSherbrooke.gegi.opusProjectModel.server.dispatch;

import ca.uSherbrooke.gegi.opusProjectModel.shared.dispatch.MenuAction;
import ca.uSherbrooke.gegi.opusProjectModel.shared.dispatch.MenuResult;

import com.google.gwt.user.client.Window;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class MenuActionHandler implements ActionHandler<MenuAction, MenuResult>{

	@Override
	public MenuResult execute(MenuAction action, ExecutionContext context)
			throws ActionException 
	{
		MenuResult  menuResult = new MenuResult();
		menuResult.sessionsName.add("Sesseion---1");
		menuResult.sessionsName.add("Sesseion---2");
		menuResult.sessionsName.add("Sesseion---3");
		menuResult.sessionsName.add("Sesseion---4");
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
