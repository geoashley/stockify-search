package com.stockify.stocksearch.controllers;

import com.stockify.stocksearch.datastructure.SearchHelper;
import com.stockify.stocksearch.dto.SearchDTO;
import com.stockify.stocksearch.dto.SymbolDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;
import java.util.Set;

@RestController

public class SearchController {
    @PostMapping(value = "/search", consumes = "application/json", produces = "application/json")
    public Set<SymbolDTO> prefixSearch(@RequestBody SearchDTO searchDTO){
        SearchHelper helper = SearchHelper.getInstance();
        return helper.prefixSearch(searchDTO.getSymbol().toUpperCase(Locale.ROOT));
    }
}
