package dev.shreya.springbootindepth.repository;

import dev.shreya.springbootindepth.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {

}
