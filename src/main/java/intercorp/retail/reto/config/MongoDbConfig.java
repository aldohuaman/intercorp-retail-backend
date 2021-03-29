package intercorp.retail.reto.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoDbConfig extends AbstractMongoClientConfiguration  {
	
	@Value("${mongodb.database.name}")
	private String mongoDatabase;
	
	@Value("${mongodb.database.connection-string}")
	private String mongoConnectionString;

	@Override
	protected String getDatabaseName() {
		return mongoDatabase;
	}

	@Override
	public MongoClient mongoClient() {
		 ConnectionString connectionString = new ConnectionString(mongoConnectionString);
	        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
	            .applyConnectionString(connectionString)
	            .build();
	        
	        return MongoClients.create(mongoClientSettings);
	}
	


	
}
