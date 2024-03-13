package com.ccp.repo;

import org.springframework.data.repository.CrudRepository;

import com.ccp.bean.Symbol;

public interface SymbolRepo extends CrudRepository<Symbol, Long> {

}
