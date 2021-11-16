package org.miage.conversionservice.boundary;

import java.math.BigDecimal;
import org.miage.conversionservice.entity.DeviseConversionBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConversionController {

	RestTemplate template;

	public ConversionController (RestTemplate rt) {
		this.template = rt;
	}

	@GetMapping("/conversion-devise/source/{source}/cible/{cible}/quantite/{qte}")
	public DeviseConversionBean call(@PathVariable("source") String source, 
				@PathVariable("cible") String cible, @PathVariable BigDecimal qte) {
		String url = "http://localhost:8000/taux-devise/source/{source}/cible/{cible}";
		DeviseConversionBean response = template.getForObject(url, DeviseConversionBean.class, source, cible);
		return new DeviseConversionBean(response.getId(), source, cible, response.getTauxConversion(), qte,
                qte.multiply(response.getTauxConversion()), response.getPort());
	}

}