package com.example.meowmaven2.config;

import com.example.meowmaven2.repository.HibernateSpeakerRepositoryImpl;
import com.example.meowmaven2.repository.SpeakerRepository;
import com.example.meowmaven2.service.SpeakerService;
import com.example.meowmaven2.service.SpeakerServiceImpl;
import com.example.meowmaven2.util.CalendarFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Calendar;

/*
* AppConfig contains your bean configurations, like your services to retrieve
*/

@Configuration
@ComponentScan({"com.example.meowmaven2"}) // This needs to be included in order to remove all the below code, you need to have properly defined beans throughout the app, otherwise you can define them below in the config class
public class AppConfig {
    @Bean(name="cal")
    public CalendarFactory calFactory() {
        CalendarFactory factory= new CalendarFactory();
        factory.addDays(2);
        return factory;
    }

    @Bean
    public Calendar cal() throws Exception {
        return calFactory().getObject();
    }


    // @Bean should replace wherever you use New
    // Everything below can be removed if you set the SpeakerServiceImpl class to @Service
    // SCOPE_SINGLETON will give you singleton, SCOPE_PROTOTYPE will generate a new instance of this speaker service
//    @Bean(name = "speakerService") // Optional name. Beans for methods only, not class
//    @Scope(value = BeanDefinition.SCOPE_SINGLETON) //@Scope(value = BeanDefinition.SCOPE_PROTOTYPE) // Alternative string @Scope(value = "singleton")
//    public SpeakerService getSpeakerService() {
//        // 1. Java version
//        //return new SpeakerServiceImpl();
//
//        // 2. Setter injection using a setRepository
//        //SpeakerServiceImpl service = new SpeakerServiceImpl();
//        //service.setRepository(getSpeakerRepository());
//
//        // 3. Constructor injection of the singleton, which is a Hibernate repository
//        // Notice how the service is separate from the repository
//        // The repository is the "database" where the data is hard-coded in this example but could be the SQL
//        // The service serves up the repository, the abstraction between these 2 concepts eludes me
//        // Why this speaker service and its repository is not a single class?
//        //SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());
//        SpeakerServiceImpl service = new SpeakerServiceImpl();
//        return service;
//    }

    // This can be removed as well if HibernateRepository is set up as @Repository
    // Singleton for getting the repository
//    @Bean(name = "speakerRepository")
//    public SpeakerRepository getSpeakerRepository() {
//        return new HibernateSpeakerRepositoryImpl();
//    }
}
