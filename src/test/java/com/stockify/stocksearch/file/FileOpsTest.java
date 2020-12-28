package com.stockify.stocksearch.file;

import com.stockify.stocksearch.controllers.ExceptionProperties;
import com.stockify.stocksearch.dto.NasdaqSymbolDTO;
import com.stockify.stocksearch.exception.StockifyException;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class FileOpsTest {

    @Test
    void testParseCSVNull(){
        String[] tokens =  new FileOps().parseCSV(null);
        assertEquals( null,tokens);
    }

    @Test
    void testParseCSVEmpty(){
        String[] tokens =  new FileOps().parseCSV("");
        assertEquals( 1,tokens.length);
        assertEquals("",tokens[0]);
    }

    @Test
    void testParseCSVData(){
        String[] tokens =  new FileOps().parseCSV("ABNB|Airbnb, Inc. - Class A Common Stock|Q|N|N|100|N|N");
        assertEquals( 8,tokens.length);
        assertEquals("ABNB",tokens[0]);
        assertEquals("Airbnb, Inc. - Class A Common Stock",tokens[1]);
        assertEquals("100",tokens[5]);
        assertEquals("N",tokens[7]);
    }
    @Test ()
    void testNoFile(){
        try{
            new FileOps().readFile("no/file/path");
        }catch (StockifyException se){
            assertEquals(se.getType(), ExceptionProperties.FileNotFound);
        }
    }
    @Test ()
    void testInvalidFile(){
        try{
            new FileOps().readFile("src/test/data/Invalid.txt");
        }catch (StockifyException se){
            assertEquals( ExceptionProperties.InvalidFileType,se.getType());
        }
    }

    @Test ()
    void testvalidFile(){
        try{
            int symCount = new FileOps().readFile("src/test/data/nasdaqlisted.txt");
            assertEquals(3904,symCount);
        }catch (StockifyException se){
            assertEquals(se.getType(), ExceptionProperties.FileNotFound);
        }
    }

    @Test
    void testSymbolMapping(){
        String[] tokens = {"ZNGA","Zynga Inc. - Class A Common Stock","Q","N","N","100","N","N"};
        NasdaqSymbolDTO newSymbol = new FileOps().mapNewSymbol(tokens);
        assertEquals("ZNGA", newSymbol.getSymbol());
        assertEquals("Zynga Inc. - Class A Common Stock", newSymbol.getSecurityName());
        assertEquals("Q", newSymbol.getMarketCategory());
        assertEquals("N", newSymbol.getTestIssue());
        assertEquals("N", newSymbol.getFinancialStatus());
        assertEquals("100", newSymbol.getRoundLotSize());
        assertEquals("N", newSymbol.getETF());
        assertEquals("N", newSymbol.getNextShares());
    }

}