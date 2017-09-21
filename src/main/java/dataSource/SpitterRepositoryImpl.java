package dataSource;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.stereotype.Repository;

import spittr.Spitter;
import spittr.Spittle;
import spittr.data.SpittleRepository;
@Repository
public class SpitterRepositoryImpl implements SpitterSweeper{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public int eliteSweep() {
		// TODO Auto-generated method stub
		
		String update="Update Spitter";
		
		return em.createQuery(update).executeUpdate();
		
	}
	

	
}
