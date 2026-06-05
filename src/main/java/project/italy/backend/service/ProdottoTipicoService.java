package project.italy.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import project.italy.backend.models.Categoria;
import project.italy.backend.models.ProdottoTipico;
import project.italy.backend.models.Regione;
import project.italy.backend.repository.CategoriaRepository;
import project.italy.backend.repository.ProdottoTipicoRepository;
import project.italy.backend.repository.RegioneRepository;

@Service
public class ProdottoTipicoService {

    @Autowired
    ProdottoTipicoRepository prodottoTipicoRepository;

    @Autowired
    RegioneRepository regioneRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<ProdottoTipico> findAllProdottiOrdinati(String order) {
        if (order.equalsIgnoreCase("alfabetico")) {
            return prodottoTipicoRepository.findAllByOrderByNomeAsc();
        }
        return prodottoTipicoRepository.findAll();
    }

    public List<ProdottoTipico> getProdottiPerRegione(String slugRegione, String order) {

        Regione regione = regioneRepository.findBySlug(slugRegione)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Regione non trovata"));

        if (order.equalsIgnoreCase("alfabetico")) {
            return prodottoTipicoRepository.findByRegioneOrderByNomeAsc(regione);
        }

        return prodottoTipicoRepository.findByRegione(regione);
    }

    public List<ProdottoTipico> getProdottiPerCategoria(String slugCategoria, String order) {

        Categoria categoria = categoriaRepository.findBySlug(slugCategoria)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria non trovata"));

        if (order.equalsIgnoreCase("alfabetico")) {
            return prodottoTipicoRepository.findByCategoriaOrderByNomeAsc(categoria);
        }

        return prodottoTipicoRepository.findByCategoria(categoria);
    }

    public List<ProdottoTipico> getProdottiPerRegioneECategoria(String slugRegione, String slugCategoria,
            String order) {

        Regione regione = regioneRepository.findBySlug(slugRegione)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Regione non trovata"));

        Categoria categoria = categoriaRepository.findBySlug(slugCategoria)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria non trovata"));

        if (order.equalsIgnoreCase("alfabetico")) {
            return prodottoTipicoRepository.findByRegioneAndCategoriaOrderByNomeAsc(regione, categoria);
        }

        return prodottoTipicoRepository.findByRegioneAndCategoria(regione, categoria);
    }
}
