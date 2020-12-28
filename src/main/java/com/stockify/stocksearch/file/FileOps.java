package com.stockify.stocksearch.file;
import com.stockify.stocksearch.dto.NasdaqSymbolDTO;


public class FileOps extends BaseFileOps {

    private static final String NASDAQ_HEADER_STRING ="Symbol|Security Name|Market Category|Test Issue|Financial Status|Round Lot Size|ETF|NextShares";
    private static final String NASDAQ_FOOTER_STRING = "File Creation Time: 1211202021:33|||||||";

    public String getHeader(){
        return  NASDAQ_HEADER_STRING;
    }

    public String getFooter(){
        return  NASDAQ_FOOTER_STRING;
    }

    public String[] parseCSV(String s) {
        if(s == null){
            return null;
        }
        return s.split("\\|");

    }

    public NasdaqSymbolDTO mapNewSymbol(String[] tokens) {
        return new NasdaqSymbolDTO.Builder()
                .withSymbol(tokens[0])
                .withSecurityName(tokens[1])
                .withMarketCategory(tokens[2])
                .withTestIssue(tokens[3])
                .withFinancialStatus(tokens[4])
                .withRoundLotSize(tokens[5])
                .withETF(tokens[6])
                .withNextShares(tokens[7])
                .build();
    }
}
