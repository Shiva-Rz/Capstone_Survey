package com.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.post.entity.Symbol;


@Repository
public interface SymbolRepo extends JpaRepository<Symbol, Long> {
	
}
