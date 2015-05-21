package ca.uSherbrooke.gegi.opusProjectModel.server.guice;

import ca.uSherbrooke.gegi.persist.dao.BaseDao;
import ca.uSherbrooke.gegi.persist.dao.JpaInitializer;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class GuiceServletConfig extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
    	Injector injector = Guice.createInjector(new ServerModule(), new ca.uSherbrooke.gegi.commons.core.server.guice.DispatchServletModule(), new DispatchServletModule());
		
		injector.getInstance(JpaInitializer.class);
		injector.getInstance(BaseDao.class);

		return injector;
    }
}