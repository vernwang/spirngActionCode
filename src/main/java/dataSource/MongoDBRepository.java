package dataSource;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.apache.log4j.chainsaw.Main;
import org.mockito.internal.matchers.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import spittr.Spitter;

public class MongoDBRepository {

	@Autowired
	MongoOperations mongoOperations;
	
	public  void Method() {
		long orderCount=mongoOperations.getCollection("order").count();
		
		Spitter spitter=new Spitter();
		mongoOperations.save(spitter, "order");
		
		String orderId="123123";
		mongoOperations.findById(orderId, Spitter.class);
		
		mongoOperations.find(Query.query(Criteria.where("client").is("Chuck")), Order.class);
		
		
	
	}
	
}
