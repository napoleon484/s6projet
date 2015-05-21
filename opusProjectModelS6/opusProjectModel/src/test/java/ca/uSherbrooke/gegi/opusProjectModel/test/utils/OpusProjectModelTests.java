package ca.uSherbrooke.gegi.opusProjectModel.test.utils;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import ca.uSherbrooke.gegi.commons.core.test.utils.CoreTests;
import ca.uSherbrooke.gegi.persist.dao.BaseDao;
import ca.uSherbrooke.gegi.persist.dao.DaoModule;
import ca.uSherbrooke.gegi.persist.dao.JpaInitializer;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class OpusProjectModelTests extends CoreTests {
	
	protected static String TABLE_UNDER_TEST = "public.users";
	private static String DAO_MODULE_NAME = "commons";
	
	@BeforeClass
	public static void initDao(){
		Injector injector = Guice.createInjector(new DaoModule(DAO_MODULE_NAME));
		injector.getInstance(JpaInitializer.class);
		dao = injector.getInstance(BaseDao.class);
		DataSetsForOpusProjectModelTests.dao = dao;
		
		clearUsersAndGroups();
		clearTableUnderTest();
	}
}
