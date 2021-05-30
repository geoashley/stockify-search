package com.stockify.stocksearch.datastructure;

import com.stockify.stocksearch.dto.RelatedSymbolDTO;
import com.stockify.stocksearch.dto.SymbolDTO;
import com.stockify.stocksearch.util.DataTypeUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IndustryAggregate {
    private static IndustryAggregate _instance;
    private Map<String, IndustryData> _aggregateCache;

    private IndustryAggregate() {
        _aggregateCache = new HashMap<>();
    }

    public static IndustryAggregate getInstance() {
        if (_instance == null) {
            _instance = new IndustryAggregate();
        }
        return _instance;
    }

    public void insert(SymbolDTO newSymbol) {
        String key = newSymbol.getIndustry() + " "+newSymbol.getSector();
        String amount = newSymbol.getMarketCap();
        if (!DataTypeUtil.isNumeric(amount) || key == null) {
            return;
        }
        IndustryData entry = _aggregateCache.get(key);
        if(entry == null){
            _aggregateCache.put(key,new IndustryData(newSymbol.getIndustry(),
                                                  newSymbol.getSector(),
                                                  newSymbol.getSymbol(),
                                                  newSymbol.getSecurityName(),
                                                  Double.parseDouble(amount),
                                                   newSymbol.getLastSale()));
        }else{
            entry.add(newSymbol.getSymbol(), newSymbol.getSecurityName(),Double.parseDouble(amount),newSymbol.getLastSale() );
        }
    }

    public Double getAggregateMarketCap(String key){
        IndustryData entry = _aggregateCache.get(key);
        if(entry==null){
            return Double.valueOf(0);
        }
        return entry.getAggMarketCap();
    }

    public Set<RelatedSymbolDTO> getRelatedSymbols(String key, String symbol){
        IndustryData entry = _aggregateCache.get(key);
        if(entry==null){
            return null;
        }
        return entry.getRelatedSymbols(symbol);
    }
    public void wrap() {
        for (String key : _aggregateCache.keySet()) {
            _aggregateCache.get(key).wrap();
        }
    }
}
