package ca.uSherbrooke.gegi.opusProjectModel.server.guice;

import ca.uSherbrooke.gegi.opusProjectModel.server.dispatch.MenuActionHandler;
import ca.uSherbrooke.gegi.opusProjectModel.shared.dispatch.MenuAction;

import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;

public class ServerModule extends HandlerModule {
    @Override
    protected void configureHandlers() 
    {
        bindHandler(MenuAction.class, MenuActionHandler.class);
    }
}