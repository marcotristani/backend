package project.italy.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import project.italy.backend.models.Tipologia;

public interface TipologiaRepository extends JpaRepository<Tipologia, Integer> {

    Optional<Tipologia> findBySlug(String slug);
}
