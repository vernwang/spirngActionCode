package dataSource;

import java.util.List;

import javax.inject.Inject;
import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import spittr.Spitter;
import spittr.Spittle;
import spittr.data.SpittleRepository;
@Repository
public class JdbcSpitterRepository implements SpittleRepository{
	
	private JdbcOperations JdbcOperations;

	@Inject
	public  JdbcSpitterRepository(JdbcOperations jdbcOperations) {
		// TODO Auto-generated constructor stub
		this.JdbcOperations=jdbcOperations;
	
	}
	
	@Override
	public List<Spittle> findSpittles(long max, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Spittle findOne(int id) {
		// TODO Auto-generated method stub
		return JdbcOperations.queryForObject("", new , args);
	}

	@Override
	public Spitter saved(Spitter spitter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Spitter findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void addSpitter(Spitter spitter) {
		JdbcOperations.update("","");
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	
	
	private static final class SpitterRowMapper implements RowMapper{

		@Override
		public int[] getRowsForPaths(TreePath[] path) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
