package com.example.meowmaven2.service;

import com.example.meowmaven2.model.Speaker;
import com.example.meowmaven2.repository.HibernateSpeakerRepositoryImpl;
import com.example.meowmaven2.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service("speakerService")
@Profile("dev") // Once you choose a string for your profile, open up run configuration and go into VM options, -Dspring.profiles.active=dev, not an env variable. This bean only becomes available in dev
public class SpeakerServiceImpl implements SpeakerService {
    // This is hard-coded and being used by standard Java
    //private SpeakerRepository repository = new HibernateSpeakerRepositoryImpl();
    private SpeakerRepository repository;

    public SpeakerServiceImpl() {
        System.out.println("SpeakerServiceImpl default constructor");
    }

    @Autowired // Where do you want to autowire in this class? Here in this constructor
    public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
        System.out.println("SpeakerServiceImpl repository constructor");
        this.repository = speakerRepository;
    }

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }

    // Setter injection instead of constructor injection
    //@Autowired
    public void setRepository(SpeakerRepository repository) {
        System.out.println("SpeakerServiceImpl setter");
        this.repository = repository;
    }

    // Added javax, invoke method after construction
    // you don't need to write initialise() inside the constructor
    // Don't put database stuff in there, maybe logging could go in here
    @PostConstruct
    private void initialise() {
        System.out.println("Called after constructors");
    }
}
