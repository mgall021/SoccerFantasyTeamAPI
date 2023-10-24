package com.example.capstone.repository;

import com.example.capstone.model.SoccerPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoccerPlayerRepository extends JpaRepository<SoccerPlayer, Long> {

    List<SoccerPlayer> findByPosition(String position);

    List<SoccerPlayer> findByTeam(String team);

    List<SoccerPlayer> findByCountry(String country);

}