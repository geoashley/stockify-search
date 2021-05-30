package com.stockify.stocksearch.datastructure;



import com.stockify.stocksearch.dto.RelatedSymbolDTO;

import java.util.*;

public class IndustryData {

    private static final int heapInitialSize = 50;
    private String sector;
    private String industry;
    private List<String> symbols = new ArrayList();
    private Double aggMarketCap = (double) 0;
    private Map<String, Integer> symbolMap;
    private MaxHeap<RelatedSymbolDTO> heap;
    private RelatedSymbolDTO[] sortedList;
    private int symbolListSize;

    public Double getAggMarketCap() {
        return aggMarketCap;
    }

    public IndustryData(String inIndustry, String inSector, String inSymbol, String company,Double inAmount, String lastSale) {
        sector = inSector;
        industry = inIndustry;
        symbols.add(inSymbol);
        aggMarketCap = inAmount;
        heap = new MaxHeap<>(new RelatedSymbolDTO[heapInitialSize]);
        heap.insert(new RelatedSymbolDTO(inSymbol, company, inAmount, lastSale));
    }

    public void add(String inSymbol, String company, Double amount,String lastSale) {
        symbols.add(inSymbol);
        aggMarketCap += amount;
        heap.insert(new RelatedSymbolDTO(inSymbol, company, amount,lastSale));
    }

    public void wrap(){
        sortedList = heap.sort();
        symbolListSize = heap.getHeapSize();
        symbolMap = heap.getKeyMap();
        heap = null;
    }

    public Set<RelatedSymbolDTO> getRelatedSymbols(String symbol) {

        if(symbolMap ==null){
            return null;
        }

        Set<RelatedSymbolDTO> related = new HashSet<>();
        Integer indx = symbolMap.get(symbol);
        if(indx>=0 && indx<symbolListSize){
            if(indx != (symbolListSize-1)){
                related.add(sortedList[symbolListSize-1]);
            }
            if(indx-1 > 0){
                related.add(sortedList[indx-1]);
            }
            if(indx+1 < symbolListSize){
                related.add(sortedList[indx+1]);
            }

            if(indx-2 > 0){
                related.add(sortedList[indx-2]);
            }
            if(indx+2 < symbolListSize){
                related.add(sortedList[indx+2]);
            }
            if(indx-3 > 0){
                related.add(sortedList[indx-3]);
            }
            if(indx+3 < symbolListSize){
                related.add(sortedList[indx+3]);
            }
        }

        return related;
    }
}

