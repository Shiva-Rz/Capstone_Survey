package com.survey.repo;

import org.springframework.data.repository.CrudRepository;

import com.survey.bean.Symbol;

public interface SymbolRepo extends CrudRepository<Symbol, Long> {

}
