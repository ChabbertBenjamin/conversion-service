package org.miage.conversionservice.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TauxChangeRepository extends JpaRepository<TauxChange,Long> {
    TauxChange findBySourceAndCible(String source, String cible);
}

