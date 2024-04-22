package com.relevantz.ccp.repository;

import org.springframework.data.repository.CrudRepository;

import com.relevantz.ccp.model.Symbol;

public interface SymbolRepo extends CrudRepository<Symbol, Long> {

}
