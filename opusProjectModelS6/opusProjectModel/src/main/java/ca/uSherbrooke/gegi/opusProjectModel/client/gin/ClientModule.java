package ca.uSherbrooke.gegi.opusProjectModel.client.gin;

import ca.uSherbrooke.gegi.opusProjectModel.client.application.ApplicationModule;
import ca.uSherbrooke.gegi.opusProjectModel.client.place.NameTokens;

import com.gwtplatform.dispatch.rpc.client.gin.RpcDispatchAsyncModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

/**
 * See more on setting up the PlaceManager on <a
 * href="// See more on: https://github.com/ArcBees/GWTP/wiki/PlaceManager">DefaultModule's > DefaultPlaceManager</a>
 */
public class ClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
		install(new DefaultModule());
		install(new RpcDispatchAsyncModule());
        install(new ca.uSherbrooke.gegi.commons.core.client.gin.ClientModule());
        install(new ApplicationModule());
		
		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.home);       
    }
}