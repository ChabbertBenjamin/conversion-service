package org.miage.conversionservice.entity;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionRessource {

    private Environment environment;
    private TauxChangeRepository tauxChangeRepository;

    public ConversionRessource(Environment environment, TauxChangeRepository tauxChangeRepository) {
        this.environment = environment;
        this.tauxChangeRepository = tauxChangeRepository;
    }

    @GetMapping("/taux-devise/source/{source}/cible/{cible}")
    public TauxChange getValeurDeChange(@PathVariable String source, @PathVariable String cible){
        TauxChange tauxChange = tauxChangeRepository.findBySourceAndCible(source, cible);
        System.out.println(tauxChange);
        tauxChange.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return tauxChange;
    }
}