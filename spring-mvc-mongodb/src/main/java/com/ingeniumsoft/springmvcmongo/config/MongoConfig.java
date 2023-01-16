/**
 * com.ingeniumsoft.springmvcmongo.config
 */
package com.ingeniumsoft.springmvcmongo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * @author miguelromero717
 * 13/03/2016
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.ingeniumsoft.springmvcmongo.repositories")
public class MongoConfig extends AbstractMongoConfiguration{

	@Override
    protected String getDatabaseName() {
        return "test";
    }
 
    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1", 27017);
    }
 
    @Override
    protected String getMappingBasePackage() {
        return "com.ingeniumsoft.springmvcmongo";
    }
	
}
