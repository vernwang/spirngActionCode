package dataSource;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import spittr.Spitter;

public interface OrderRepository  extends MongoRepository<Spitter, String>{ 

	List<Spitter> findByCustomer(String c);

	@Query("{'customer':'Chuck Wagon','type':?0}")
	List<Spitter> findChucksOrders(String c);

}
