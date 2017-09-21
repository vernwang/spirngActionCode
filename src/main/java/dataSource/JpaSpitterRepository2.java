package dataSource;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import spittr.Spitter;
import spittr.Spittle;
import spittr.data.SpittleRepository;
@Repository
public class JpaSpitterRepository2 implements SpittleRepository{

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	
	@Override
	public List<Spittle> findSpittles(long max, int count) {
		// TODO Auto-generated method stub
		entityManagerFactory.createEntityManager()
		return null;
	}

	@Override
	public Spittle findOne(int id) {
		entityManagerFactory.createEntityManager().find(Spitter.class, id);
		return null;
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
	

	}
	
}
