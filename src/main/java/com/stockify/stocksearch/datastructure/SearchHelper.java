package com.stockify.stocksearch.datastructure;

import com.stockify.stocksearch.dto.SymbolDTO;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchHelper {
    private static SearchHelper _instance;
    private SearchTrie _symbolTrie;
    private SearchTrie _nameTrie;
    private SearchHelper(){
        _symbolTrie = new SearchTrie(false);
        _nameTrie = new SearchTrie(true);
    }
    public static SearchHelper getInstance(){
        if(_instance == null){
            _instance = new SearchHelper();
        }
        return _instance;
    }

    public void reset(){
        _instance =null;
        _symbolTrie = null;
        _nameTrie = null;
    }

    public boolean insert(SymbolDTO dto){
        return (_symbolTrie.insert(dto) &&
                _nameTrie.insert(dto));
    }

    public Set<SymbolDTO> prefixSearch(String word){
        return Stream.concat(_symbolTrie.prefixSearch(word).stream(), _nameTrie.prefixSearch(word).stream())
                .collect(Collectors.toSet());
    }
}
