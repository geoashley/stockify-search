package com.stockify.stocksearch.file;

import com.stockify.stocksearch.datastructure.SearchTrie;
import com.stockify.stocksearch.dto.SymbolDTO;
import com.stockify.stocksearch.util.DataTypeUtil;

public class NasdaqScreenerFileOps extends BaseFileOps{

    private static final String HEADER_STRING ="Symbol,Name,Last Sale,Net Change,% Change,Market Cap,Country,IPO Year,Volume,Sector,Industry";
    private static final String FOOTER_STRING = "";


    public String getHeader(){
        return HEADER_STRING;
    }

    public String getFooter(){
        return FOOTER_STRING;
    }

    public String[] parseCSV(String s) {
        if(s == null){
            return null;
        }
        String CSV_PATTERN = ",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)";
        return s.split(CSV_PATTERN,-1);
    }

    public SymbolDTO mapNewSymbol(String[] tokens) {
        return SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol(DataTypeUtil.nonNullString(tokens[0]).trim())
                .withSecurityName(DataTypeUtil.nonNullString(tokens[1]).trim())
                .withLastSale(DataTypeUtil.nonNullString(tokens[2]).trim())
                .withNetChange(DataTypeUtil.nonNullString(tokens[3]).trim())
                .withPercentChange(DataTypeUtil.nonNullString(tokens[4]).trim())
                .withMarketCap(DataTypeUtil.nonNullString(tokens[5]).trim())
                .withCountry(DataTypeUtil.nonNullString(tokens[6]).trim())
                .withIpoYear(DataTypeUtil.nonNullString(tokens[7]).trim())
                .withVolume(DataTypeUtil.nonNullString(tokens[8]).trim())
                .withSector(DataTypeUtil.nonNullString(tokens[9]).trim())
                .withIndustry(DataTypeUtil.nonNullString(tokens[10]).trim())
                .build();
    }
    public void insertToTrie(String[] tokens){
        SearchTrie trie = SearchTrie.getInstance();
        trie.insert(mapNewSymbol(tokens));


    }


}
