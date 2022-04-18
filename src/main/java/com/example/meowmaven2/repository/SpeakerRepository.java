package com.example.meowmaven2.repository;

import com.example.meowmaven2.model.Speaker;

import java.util.List;

public interface SpeakerRepository {
    List<Speaker> findAll();
}
