package com.rts.ccp.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_symbol")
public class Symbol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long symbolId;

	private String symbolName;

	public Symbol() {
		super();
	}

	public Symbol(long symbolId, String symbolName) {
		super();
		this.symbolId = symbolId;
		this.symbolName = symbolName;
	}

	public long getSymbolId() {
		return symbolId;
	}

	public void setSymbolId(long symbolId) {
		this.symbolId = symbolId;
	}

	public String getSymbolName() {
		return symbolName;
	}

	public void setSymbolName(String symbolName) {
		this.symbolName = symbolName;
	}

}
