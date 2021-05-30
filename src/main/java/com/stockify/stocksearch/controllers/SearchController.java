package com.stockify.stocksearch.controllers;

import com.stockify.stocksearch.datastructure.IndustryAggregate;
import com.stockify.stocksearch.datastructure.SearchHelper;
import com.stockify.stocksearch.dto.RelatedSymbolDTO;
import com.stockify.stocksearch.dto.SymbolDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Set;

@RestController
public class SearchController {
    @GetMapping(value = "/search",produces = "application/json")
    public SymbolDTO[] prefixSearch(@RequestParam(value = "symbol") String symbol){
        SearchHelper helper = SearchHelper.getInstance();
        Set<SymbolDTO> returnSet = helper.prefixSearch(symbol.toUpperCase(Locale.ROOT));
        return returnSet.stream().toArray(SymbolDTO[] ::new);
        //return returnSet;
    }
    @GetMapping(value = "/aggregate",produces = "application/json")
    public Double getIndustryAggregate(@RequestParam(value = "industry") String industry, @RequestParam(value = "sector")String sector){
        IndustryAggregate helper = IndustryAggregate.getInstance();
        return helper.getAggregateMarketCap(industry+" "+sector);
    }
    @GetMapping(value = "/related",produces = "application/json")
    public RelatedSymbolDTO[] getIndustryRelated(@RequestParam(value = "industry") String industry, @RequestParam(value = "sector")String sector,  @RequestParam(value = "symbol")String symbol){
        IndustryAggregate helper = IndustryAggregate.getInstance();
        Set<RelatedSymbolDTO> returnSet =  helper.getRelatedSymbols(industry+" "+sector, symbol);
        return returnSet.stream().toArray(RelatedSymbolDTO[] ::new);
    }

}
