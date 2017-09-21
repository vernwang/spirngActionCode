package dataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;

import spittr.Spitter;

public class Neo4jRepository {
	
	
	@Autowired
	private Neo4jOperations neo4jOperations;
	 
	public void method() {
		
		Spitter spitter=new Spitter();
		neo4jOperations.save(spitter);
		
		Spitter spitter2=new Spitter();
		
		Lin
	}

}
