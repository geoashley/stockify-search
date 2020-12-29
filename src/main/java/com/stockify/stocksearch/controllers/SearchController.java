package com.stockify.stocksearch.controllers;

import com.stockify.stocksearch.datastructure.SearchHelper;
import com.stockify.stocksearch.dto.SearchDTO;
import com.stockify.stocksearch.dto.SymbolDTO;
import org.springframework.web.bind.annotation.*;

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
}
