package intercorp.retail.reto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import intercorp.retail.reto.domain.Parameters;

public interface ParametersRepository extends MongoRepository<Parameters, String> {

	@Query("{'key' : 'lifeExpectancy'}")
	Parameters findLifeExpectancy();
}
