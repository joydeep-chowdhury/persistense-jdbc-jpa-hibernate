package com.joydeep.jdbc;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joydeep.jdbc.dao.PersonJdbcDao;
import com.joydeep.jdbc.model.Person;
//spring-jdbc
@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner{
    private PersonJdbcDao pdao;
    private Logger logger=LoggerFactory.getLogger(DatabaseDemoApplication.class);
    public DatabaseDemoApplication(PersonJdbcDao pdao)
    {
    	this.pdao=pdao;
    }
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	    logger.info("All users -> {}",pdao.findAll());
	    logger.info("User id 10002 -> {}",pdao.findById(10002));
	    logger.info("Deleting 10001 -> No of rows deleted: "+pdao.deleteById(10001));
	   // logger.info("Inserting 10004 -> {}",pdao.insert(new Person(10004, "Kaustav Chatterjee", "Kolkata", new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("03/11/1985 13:31:44"))));
	    logger.info("Updating 10004 -> {}",pdao.insert(new Person(10004, "Kaustav Chatterjee", "New York", new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("03/11/1984 13:31:44"))));
	}

}
