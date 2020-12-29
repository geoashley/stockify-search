package com.stockify.stocksearch.file;

import com.stockify.stocksearch.controllers.ExceptionProperties;
import com.stockify.stocksearch.exception.StockifyException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class BaseFileOps {

    private static final String NASDAQ_HEADER_STRING ="Symbol|Security Name|Market Category|Test Issue|Financial Status|Round Lot Size|ETF|NextShares";
    private static final String NASDAQ_FOOTER_STRING = "File Creation Time: 1211202021:33|||||||";

    public String getHeader(){
        return  NASDAQ_HEADER_STRING;
    }

    public  String getFooter(){
        return  NASDAQ_FOOTER_STRING;
    }

    public  int readFile(String path) throws StockifyException {
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);

            int noOfSymbols=0;
            //read header
            String header = myReader.nextLine();
            if(!header.equals(getHeader())){
                throw new StockifyException("Invalid file type provided", ExceptionProperties.InvalidFileType);
            }
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if(!data.equals(getFooter())){
                    String[] tokens = parseCSV(data);
                    insertToTrie(tokens);
                    noOfSymbols++;
                }else{
                    break;
                }

            }
            myReader.close();
            return noOfSymbols;
        }
        catch(StockifyException se){
            throw se;
        }
        catch (FileNotFoundException fe) {
            System.out.println("File Not Found in path "+path);
            throw new StockifyException(fe.getMessage(), ExceptionProperties.FileNotFound);
        }
        catch (Exception e){
            System.out.println("An error occurred in reading file "+e.getMessage());
            e.printStackTrace();
            throw new StockifyException(e.getMessage(), ExceptionProperties.Unknown);
        }
    }

    public String[] parseCSV(String s) {
        if(s == null){
            return null;
        }
        return s.split("\\|");

    }

    public  void insertToTrie(String[] tokens){
//        SearchTrie trie = SearchTrie.getInstance();
//        trie.insert(tokens[0]);
    }


}
