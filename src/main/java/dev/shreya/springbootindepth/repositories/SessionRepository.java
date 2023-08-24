package dev.shreya.springbootindepth.repositories;

import dev.shreya.springbootindepth.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {

}
