package com.stockify.stocksearch.datastructure;

import com.stockify.stocksearch.dto.SymbolDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SearchTrieTest {

    private SearchTrie trie = SearchTrie.getInstance();
    @BeforeAll
    static void beforeAll() {
        SearchTrie.getInstance().reset();

    }

    @Test
    public void testInsert(){
        assertEquals(true, trie.insert(SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("AAPL").build()));
        assertEquals(true, trie.search("AAPL"));
    }

    @Test
    public void testNotFound(){
        assertEquals(true, trie.insert(SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("AAPL").build()));
        assertEquals(false, trie.search("SHOP"));
    }

    @Test
    public void testTraverse(){
        assertEquals(true, trie.insert(SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("AAPL").build()));
        assertEquals('L', trie.traverse("AAPL").getC());
        assertEquals('P', trie.traverse("AAP").getC());

    }

    @Test
    public void testPrefixSearch(){
        trie.insert(SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("AAPL").build());
        trie.insert(SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("AMZN").build());
        trie.insert(SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("ABNT").build());
        trie.insert(SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("ABNB").build());
        trie.insert(SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("ABUS").build());
        trie.insert(SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("ABST").build());

        assertTrue(trie.prefixSearch("AAPL").stream().map(symbolDTO -> symbolDTO.getSymbol()).collect(Collectors.toList()).contains("AAPL"));
        List<SymbolDTO> ret = trie.prefixSearch("AB");
        List<String> retSym = ret.stream().map(symbolDTO -> symbolDTO.getSymbol()).collect(Collectors.toList());

        assertTrue(retSym.contains("ABUS"));
        assertTrue(retSym.contains("ABNT"));
        assertTrue(retSym.contains("ABNB"));
        assertTrue(retSym.contains("ABST"));
    }
    @Test
    public void testPrefixSearch2(){
        trie.insert(SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("A").build());
        trie.insert(SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("AAPL").build());
        trie.insert(SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("AMZN").build());
        trie.insert(SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("ABNT").build());
        trie.insert(SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("ABNB").build());
        trie.insert(SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("ABUS").build());
        trie.insert(SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("ABST").build());

        List<SymbolDTO> ret = trie.prefixSearch("A");
        List<String> retSym = ret.stream().map(symbolDTO -> symbolDTO.getSymbol()).collect(Collectors.toList());
        assertTrue(retSym.contains("A"));
        assertTrue(retSym.contains("ABUS"));
        assertTrue(retSym.contains("ABNT"));
        assertTrue(retSym.contains("ABNB"));
        assertTrue(retSym.contains("ABST"));
    }
}