package ca.uSherbrooke.gegi.opusProjectModel.server.dispatch;

import java.util.List;

import javax.persistence.EntityManager;

import ca.uSherbrooke.gegi.opusProjectModel.shared.dispatch.CoursAction;
import ca.uSherbrooke.gegi.opusProjectModel.shared.dispatch.CoursResult;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class CoursActionHandler implements ActionHandler<CoursAction,CoursResult>{

	@Inject EntityManager em;
	@Override
	public CoursResult execute(CoursAction arg0, ExecutionContext arg1)
			throws ActionException {
		CoursResult coursResult = new CoursResult();
		coursResult.Cours_session.addAll(em.createNativeQuery("SELECT C.label "
																+ "FROM note.educationnal_goal AS A "
																+ "RIGHT JOIN note.educationnal_goal_hierarchy AS B "
																+ "ON A.eg_id=B.eg_id "
																+ "RIGHT JOIN note.educationnal_goal AS C "
																+ "ON B.edu_eg_id=C.eg_id "
																+ "where A.eg_id=61;").getResultList());
		return coursResult;
	}

	@Override
	public Class<CoursAction> getActionType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void undo(CoursAction arg0, CoursResult arg1, ExecutionContext arg2)
			throws ActionException {
		// TODO Auto-generated method stub
		
	}

}
