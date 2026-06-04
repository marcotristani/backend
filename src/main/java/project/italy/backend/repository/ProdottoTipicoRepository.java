package project.italy.backend.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import project.italy.backend.models.Categoria;
import project.italy.backend.models.ProdottoTipico;
import project.italy.backend.models.Regione;

import java.util.List;
import java.util.Optional;

public interface ProdottoTipicoRepository extends JpaRepository<ProdottoTipico, Integer> {

    // recupero tutti i prodotti tramite lo slug che mi faccio passare come
    // pathvariable
    Optional<ProdottoTipico> findBySlug(String slug);

    // Dalla regione voglio recuperare tutti i prodotti collegato ad essa(e poi
    // indico l'ordinamento)
    List<ProdottoTipico> findByRegione(Regione regione, Sort sort);

    // Da una categoria specifica prendo i prodotti che gli appartengono(e poi
    // indico l'ordinamento)
    List<ProdottoTipico> findByCategoria(Categoria categoria, Sort sort);

    // filtro la lista dei prodotti per regione e categoria(e poi indico
    // l'ordinamento)
    List<ProdottoTipico> findByRegioneAndCategoria(Regione regione, Categoria categoria, Sort sort);

    // Prendo la lista dei prodotti collegati a un vino specifico
    List<ProdottoTipico> findByViniSlug(String slugVino);

}
