package spittr.data;

import org.springframework.data.jpa.repository.JpaRepository;

import dataSource.SpitterSweeper;

import java.util.List;

import spittr.Spitter;
import spittr.Spittle;

public interface SpittleRepository extends JpaRepository<Spitter,Long>,SpitterSweeper{

	List<Spittle> findSpittles(long max,int count);
	
	Spittle findOne(int id);
	
	Spitter saved(Spitter spitter);
	Spitter findByUsername(String username);
	
	Spitter readSpitterByFirstnameOrLastname(String firstname,String lastname);
	
	List<Spitter> readSpitterByFirstnameIgnoringCaseOrLastnameIgnoringCase(String firstname,String lastname);
	
	List<Spitter> readSpitterByFirstnameIgnoringCaseOrLastnameIgnoringCaseOrderByLastnameAsc(String firstname,String lastname);
}
