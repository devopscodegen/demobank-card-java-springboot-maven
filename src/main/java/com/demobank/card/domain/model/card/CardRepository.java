package com.demobank.card.domain.model.card;

import org.jmolecules.ddd.annotation.Repository;

import com.demobank.card.domain.model.common.BaseRepository;

@Repository
public interface CardRepository extends BaseRepository<Card, CardNumber>{
    
}