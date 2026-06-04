package project.italy.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import project.italy.backend.models.Regione;
import project.italy.backend.models.Tipologia;
import project.italy.backend.models.Vino;

public interface VinoRepository extends JpaRepository<Vino, Integer> {

    Optional<Vino> findBySlug(String slug);

    // prendo i vini collegati a una regione(e poi vado a indicare l'ordine di
    // visualizzazione)
    List<Vino> findByRegione(Regione regione, Sort sort);

    // prendo i vini collegati a una certa tipologia(e poi vado a indicare l'ordine
    // di visualizzazione)
    List<Vino> findByTipologia(Tipologia tipologia, Sort sort);

    // prendo i vini di una determinata regione e una determinatat tipologia(e poi
    // vado a indicare l'ordine di visualizzazione)
    List<Vino> findByRegioneAndTipologia(Regione regione, Tipologia tipologia, Sort sort);

    // prendo i vini correlati a un determinato prodotto
    List<Vino> findByProdottiTipiciSlug(String slugProdottoTipico);

}
