
package project.italy.backend.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import project.italy.backend.models.ProdottoTipico;
import project.italy.backend.service.ProdottoTipicoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin
@RequestMapping("/api/prodotti")
public class ProdottoTipicoRestController {

    @Autowired
    ProdottoTipicoService prodottoTipicoService;

    @GetMapping("/all")
    public List<ProdottoTipico> index(@RequestParam(defaultValue = "default") String order) {
        return prodottoTipicoService.findAllProdottiOrdinati(order);
    }

    @GetMapping("/regione/{slugRegione}")
    public List<ProdottoTipico> indexRegione(@PathVariable("slugRegione") String slugRegione,
            @RequestParam(defaultValue = "default") String order) {
        return prodottoTipicoService.getProdottiPerRegione(slugRegione, order);
    }

    @GetMapping("/categoria/{slugCategoria}")
    public List<ProdottoTipico> indexCategoria(@PathVariable("slugCategoria") String slugCategoria,
            @RequestParam(defaultValue = "default") String order) {
        return prodottoTipicoService.getProdottiPerCategoria(slugCategoria, order);
    }

    @GetMapping("/regione/{slugRegione}/categoria/{slugCategoria}")
    public List<ProdottoTipico> indexRegioneECategoria(
            @PathVariable("slugRegione") String slugRegione,
            @PathVariable("slugCategoria") String slugCategoria,
            @RequestParam(defaultValue = "default") String order) {
        return prodottoTipicoService.getProdottiPerRegioneECategoria(slugRegione, slugCategoria, order);
    }

}
