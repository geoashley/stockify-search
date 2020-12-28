package com.stockify.stocksearch.file;

import com.stockify.stocksearch.controllers.ExceptionProperties;
import com.stockify.stocksearch.dto.SymbolDTO;
import com.stockify.stocksearch.exception.StockifyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NasdaqFileOpsTest {
    @Test
    void testParseCSVData(){
        String[] tokens =  new NasdaqScreenerFileOps().parseCSV("AAPL,Apple Inc. Common Stock,$131.97,1.01,0.771%,2288008759800.00,United States,1980,54930064,Technology,Computer Manufacturing");
        assertEquals( 11,tokens.length);
        assertEquals("AAPL",tokens[0]);
        assertEquals("Apple Inc. Common Stock",tokens[1]);
        assertEquals("2288008759800.00",tokens[5]);
        assertEquals("Computer Manufacturing",tokens[10]);
    }
    @Test ()
    void testNoFile(){
        try{
            new NasdaqScreenerFileOps().readFile("no/file/path");
        }catch (StockifyException se){
            assertEquals(se.getType(), ExceptionProperties.FileNotFound);
        }
    }
    @Test ()
    void testInvalidFile(){
        try{
            new NasdaqScreenerFileOps().readFile("src/test/data/Invalid.txt");
        }catch (StockifyException se){
            assertEquals( ExceptionProperties.InvalidFileType,se.getType());
        }
    }

    @Test ()
    void testvalidFile(){
        try{
            int symCount = new NasdaqScreenerFileOps().readFile("src/test/data/nasdaq_screener_1609093073513.csv");

            assertEquals(7241,symCount);
        }catch (StockifyException se){
            se.printStackTrace();
            assertEquals(se.getType(), ExceptionProperties.FileNotFound);
        }
    }

    @Test
    void testSymbolMapping(){
        String[] tokens = {"AAL","American Airlines Group Inc. Common Stock","$15.66","-0.23","-1.447%","9564717865.00","United States","","31048907","Transportation","Air Freight/Delivery Services"};
        SymbolDTO newSymbol = new NasdaqScreenerFileOps().mapNewSymbol(tokens);
        assertEquals("AAL", newSymbol.getSymbol());
        assertEquals("American Airlines Group Inc. Common Stock", newSymbol.getSecurityName());
        assertEquals("$15.66", newSymbol.getLastSale());
        assertEquals("-0.23", newSymbol.getNetChange());
        assertEquals("-1.447%", newSymbol.getPercentChange());
        assertEquals("9564717865.00", newSymbol.getMarketCap());
        assertEquals("United States", newSymbol.getCountry());
        assertEquals("", newSymbol.getIpoYear());
        assertEquals("Transportation", newSymbol.getSector());
        assertEquals("Air Freight/Delivery Services", newSymbol.getIndustry());

    }
}
