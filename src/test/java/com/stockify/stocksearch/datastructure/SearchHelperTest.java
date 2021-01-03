package com.stockify.stocksearch.datastructure;

import com.stockify.stocksearch.dto.SymbolDTO;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class SearchHelperTest {

    @Test
    public void testHelper(){
        SearchHelper.getInstance().reset();
        SearchHelper helper = SearchHelper.getInstance();

        SymbolDTO dto1 = SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("AAPL")
                .withSecurityName("Apple Inc")
                .build();
        SymbolDTO dto2 = SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("A")
                .withSecurityName("AT&T")
                .build();
        SymbolDTO dto3 = SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("ABNB")
                .withSecurityName("Airbnb")
                .build();
        SymbolDTO dto4 = SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("F")
                .withSecurityName("Ford")
                .build();
        SymbolDTO dto5 = SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("TSLA")
                .withSecurityName("TESLA")
                .build();

        helper.insert(dto1);
        helper.insert(dto2);
        helper.insert(dto3);
        helper.insert(dto4);
        helper.insert(dto5);

        Set<SymbolDTO> ret   = helper.prefixSearch("a");
        List<String> symbols = ret.stream().map(symbolDTO -> symbolDTO.getSymbol()).collect(Collectors.toList());
        List<String> names   = ret.stream().map(symbolDTO -> symbolDTO.getSecurityName()).collect(Collectors.toList());

        assertEquals(3,symbols.size());
        assertTrue(symbols.contains("AAPL"));
        assertTrue(symbols.contains("ABNB"));
        assertTrue(symbols.contains("A"));
        assertTrue(names.contains("Apple Inc"));
        assertTrue(names.contains("AT&T"));
        assertTrue(names.contains("Airbnb"));

        ret     = helper.prefixSearch("t");
        symbols = ret.stream().map(symbolDTO -> symbolDTO.getSymbol()).collect(Collectors.toList());
        names   = ret.stream().map(symbolDTO -> symbolDTO.getSecurityName()).collect(Collectors.toList());

        assertEquals(1,symbols.size());
        assertTrue(symbols.contains("TSLA"));
        assertTrue(names.contains("TESLA"));
    }
}