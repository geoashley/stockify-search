package com.stockify.stocksearch.controllers;

import com.stockify.stocksearch.datastructure.SearchTrie;
import com.stockify.stocksearch.dto.SearchDTO;
import com.stockify.stocksearch.dto.SymbolDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController

public class SearchController {
    @PostMapping(value = "/search", consumes = "application/json", produces = "application/json")
    public List<SymbolDTO> prefixSearch(@RequestBody SearchDTO searchDTO){
        SearchTrie trie = SearchTrie.getInstance();
        return trie.prefixSearch(searchDTO.getSymbol().toUpperCase(Locale.ROOT));
    }
}
