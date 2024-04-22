package com.rts.ccp.repository;

import org.springframework.data.repository.CrudRepository;

import com.rts.ccp.bean.Symbol;

public interface SymbolRepo extends CrudRepository<Symbol, Integer> {

}
