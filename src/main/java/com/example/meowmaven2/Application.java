package com.example.meowmaven2;

import com.example.meowmaven2.config.AppConfig;
import com.example.meowmaven2.service.SpeakerService;
import com.example.meowmaven2.service.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String args[]) {
        // pass in your config file to here at startup
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // This is standard Java methodology
        //SpeakerService service = new SpeakerServiceImpl(); // This is hard-coded

        // This is the bean method
        SpeakerService service1 = appContext.getBean("speakerService", SpeakerService.class);
        System.out.println(service1);
        System.out.println(service1.findAll().get(0).getFirstName());
        System.out.println(service1.findAll().get(0).getSeedNum());

        // Service2 will be the same singleton as service1 if the bean in AppConfig is designated as such
        // If designated as PROTOTYPE then service2 will be a new
        SpeakerService service2 = appContext.getBean("speakerService", SpeakerService.class);
        System.out.println(service2);
    }
}
