package hibernate4.spittr.db.jdbc;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;


import spittr.Spitter;
import spittr.Spittle;
import spittr.data.SpittleRepository;
@Repository
public class JdbcSpitterRepository implements SpittleRepository{
	
	private SessionFactory sessionFactory;

	@Inject
	public  JdbcSpitterRepository(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory=sessionFactory;
	
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	
	
	@Override
	public List<Spittle> findSpittles(long max, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Spittle findOne(int id) {
		// TODO Auto-generated method stub
		currentSession().get(Spitter.class, id);
		return null;
	}

	@Override
	public Spitter saved(Spitter spitter) {
		Serializable id=currentSession().save(spitter);
		return null;
	}

	@Override
	public Spitter findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void addSpitter(Spitter spitter) {
	}
	
	
	private static final class SpitterRowMapper implements RowMapper{

		@Override
		public int[] getRowsForPaths(TreePath[] path) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
