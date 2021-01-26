package com.stockify.stocksearch.datastructure;
import com.stockify.stocksearch.dto.SymbolDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndustryAggregateTest {

    @Test
    public void testSum(){
        IndustryAggregate agg = IndustryAggregate.getInstance();
        SymbolDTO sym =  SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("AMD")
                .withSecurityName("AMD inc")
                .withSector("Infrastructure")
                .withIndustry("Computer")
                .withMarketCap("100000")
                .build();

        agg.insert(sym);
        SymbolDTO sym2 =  SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("INTL")
                .withSecurityName("Intel inc")
                .withSector("Infrastructure")
                .withIndustry("Computer")
                .withMarketCap("100000")
                .build();
        agg.insert(sym2);
        SymbolDTO sym3 =  SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("NVDA")
                .withSecurityName("Nvidia inc")
                .withSector("Infrastructure")
                .withIndustry("Computer")
                .withMarketCap("100000")
                .build();
        agg.insert(sym3);
        SymbolDTO sym4 =  SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol("CRM")
                .withSecurityName("Salesforce inc")
                .withSector("Software")
                .withIndustry("Computer")
                .withMarketCap("200000")
                .build();
        agg.insert(sym4);
        assertEquals(Double.valueOf((double) 300000),agg.getAggregateMarketCap("Computer Infrastructure"));
        assertEquals(Double.valueOf((double) 0),agg.getAggregateMarketCap("Computer Games"));
        assertEquals(Double.valueOf((double) 200000),agg.getAggregateMarketCap("Computer Software"));

    }
}