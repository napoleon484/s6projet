package ca.uSherbrooke.gegi.opusProjectModel.client.application.home;

import javax.inject.Inject;

import ca.uSherbrooke.gegi.commons.core.client.gatekeeper.AuthenticationGatekeeper;
import ca.uSherbrooke.gegi.opusProjectModel.client.application.ApplicationPresenter;
import ca.uSherbrooke.gegi.opusProjectModel.client.place.NameTokens;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.GatekeeperParams;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class HomePagePresenter extends Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> {
    
	private static final String ACCES_PRIVILEGE_ID = "1";
	
	interface MyView extends View {
    }

    @ProxyStandard
    @NameToken(NameTokens.home)
	@UseGatekeeper(AuthenticationGatekeeper.class)
	@GatekeeperParams({ACCES_PRIVILEGE_ID})
	
    interface MyProxy extends ProxyPlace<HomePagePresenter> {
    }

    @Inject
    HomePagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
    }
}