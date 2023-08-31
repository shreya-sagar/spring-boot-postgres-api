package dev.shreya.springbootindepth.repository;

import dev.shreya.springbootindepth.entity.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker,Long> {

}
