package ca.uSherbrooke.gegi.opusProjectModel.server.guice;

import ca.uSherbrooke.gegi.persist.dao.DaoModule;

import com.google.inject.servlet.ServletModule;

public class DispatchServletModule extends ServletModule {
    @Override
    public void configureServlets() {
    	install(new DaoModule("opusProjectModel"));
    }
}