package com.stockify.stocksearch.dto;


import com.stockify.stocksearch.datastructure.HeapNode;
import org.jetbrains.annotations.NotNull;

public class RelatedSymbolDTO implements Comparable<RelatedSymbolDTO>, HeapNode {
    private Double marketCap;
    private String symbol;

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

    public RelatedSymbolDTO(String symbol, Double marketCap) {
        this.marketCap = marketCap;
        this.symbol = symbol;
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
    public String getKey() {
        return symbol;
    }
}
