package com.stockify.stocksearch.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stockify.stocksearch.datastructure.HeapNode;
import org.jetbrains.annotations.NotNull;

public class RelatedSymbolDTO implements Comparable<RelatedSymbolDTO>, HeapNode {
    private Double marketCap;
    private String symbol;
    private String securityName;
    private String lastSale;

    public String getLastSale() {
        return lastSale;
    }

    public void setLastSale(String lastSale) {
        this.lastSale = lastSale;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }


    public Double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Double marketCap) {
        this.marketCap = marketCap;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public RelatedSymbolDTO(String symbol, String company,Double marketCap, String lastSale) {
        this.marketCap = marketCap;
        this.symbol = symbol;
        this.securityName = company;
        this.lastSale=lastSale;
    }

    @Override
    public int compareTo(@NotNull RelatedSymbolDTO o) {
        return marketCap.compareTo(o.marketCap);
    }

    @Override
    public String toString() {
        return
                "marketCap=" + marketCap +
                        ", symbol='" + symbol + '\'';
    }

    @Override
    @JsonIgnore
    public String getKey() {
        return symbol;
    }
}
