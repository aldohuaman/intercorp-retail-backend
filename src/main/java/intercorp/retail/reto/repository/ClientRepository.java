package intercorp.retail.reto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import intercorp.retail.reto.domain.Client;

public interface ClientRepository extends MongoRepository<Client, String> {

}
