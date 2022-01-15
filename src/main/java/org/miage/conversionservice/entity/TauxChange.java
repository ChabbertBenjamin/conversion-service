package org.miage.conversionservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class TauxChange {
    @Id
    private Long id;
    @Column(name = "devise_source")
    private String source;
    @Column(name = "devise_cible")
    private String cible;
    private BigDecimal tauxConversion;
    private int port;

    public TauxChange() {
        // JPA
    }

    public TauxChange(Long id, String source, String cible, BigDecimal taux) {
        super();
        this.id = id;
        this.source = source;
        this.cible = cible;
        this.tauxConversion = taux;
    }

    public Long getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getCible() {
        return cible;
    }

    public BigDecimal getTauxConversion() {
        return tauxConversion;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
