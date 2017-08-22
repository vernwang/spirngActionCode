package spittr.data;


import java.util.List;

import spittr.Spitter;
import spittr.Spittle;

public interface SpittleRepository {

	List<Spittle> findSpittles(long max,int count);
	
	Spittle findOne(int id);
	
	Spitter saved(Spitter spitter);
	Spitter findByUsername(String username);
}
