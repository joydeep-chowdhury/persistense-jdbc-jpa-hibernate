package com.joydeep.jpa;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joydeep.jpa.dao.PersonJdbcDao;
import com.joydeep.jpa.model.Person;
import com.joydeep.jpa.repository.PersonRepository;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{
    
	private PersonRepository personRepo;
	
    private Logger logger=LoggerFactory.getLogger(JpaApplication.class);
    public JpaApplication(PersonRepository personRepo)
    {
    	this.personRepo=personRepo;
    }
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	   // logger.info("All users -> {}",personRepo.findById(10002));
	    logger.info("User id 10002 -> {}",personRepo.findById(10002));
//	    logger.info("Deleting 10001 -> No of rows deleted: "+pdao.deleteById(10001));
	    logger.info("Inserting  -> {}",personRepo.insert(new Person("Kaustav Chatterjee", "New York", new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("03/11/1983 13:31:44"))));
	    logger.info("Updating -> {}",personRepo.insert(new Person(1,"Kaustav Chatterjee", "New York", new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("03/11/1984 13:31:44"))));
	   personRepo.deleteById(10002);
	   logger.info("All users -> {}",personRepo.findAll());
	}

}
