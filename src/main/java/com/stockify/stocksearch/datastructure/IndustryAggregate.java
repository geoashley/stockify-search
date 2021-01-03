package com.stockify.stocksearch.datastructure;

import com.stockify.stocksearch.util.DataTypeUtil;

import java.util.HashMap;
import java.util.Map;

public class IndustryAggregate {
    private static IndustryAggregate _instance;
    private Map<String, MarketCap> _aggregateCache;

    private IndustryAggregate() {
        _aggregateCache = new HashMap<>();
    }

    public static IndustryAggregate getInstance() {
        if (_instance == null) {
            _instance = new IndustryAggregate();
        }
        return _instance;
    }

    public void insert(String key, String amount) {
        if (!DataTypeUtil.isNumeric(amount) || key == null) {
            return;
        }
        MarketCap entry = _aggregateCache.get(key);
        if(entry == null){
            _aggregateCache.put(key,new MarketCap(Double.parseDouble(amount)));
        }else{
            entry.add(Double.parseDouble(amount));
        }
    }

    public Double getAggregateMarketCap(String key){
        MarketCap entry = _aggregateCache.get(key);
        if(entry==null){
            return Double.valueOf(0);
        }
        return entry.marketCap;
    }


    private static class MarketCap {
        Double marketCap = (double) 0;

        public MarketCap(Double inAmount){
            marketCap = inAmount;
        }

        private void add( Double amount) {
            marketCap += amount;

        }

    }

}
