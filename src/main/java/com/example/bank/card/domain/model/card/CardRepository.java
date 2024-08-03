package com.example.bank.card.domain.model.card;

import org.jmolecules.ddd.annotation.Repository;

import com.example.bank.card.domain.model.common.BaseRepository;

@Repository
public interface CardRepository extends BaseRepository<Card, CardNumber>{
    
}