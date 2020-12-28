package com.stockify.stocksearch.controllers;

import com.stockify.stocksearch.dto.FileDTO;
import com.stockify.stocksearch.exception.StockifyException;
import com.stockify.stocksearch.file.FileOps;
import com.stockify.stocksearch.file.NasdaqScreenerFileOps;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadDataController {

    @PostMapping(value = "/load", consumes = "application/json", produces = "application/json")
    public boolean loadSymbols(@RequestBody FileDTO fileDTO){

        //read file
        try {
            switch (fileDTO.getFileType()){
                case all:
                    new NasdaqScreenerFileOps().readFile(fileDTO.getFileName());
                    break;
                case nasdaq_only:
                    new FileOps().readFile(fileDTO.getFileName());
                    break;

            }
        } catch (StockifyException e) {
            e.printStackTrace();
            return false;
        }
        //parse
        //load trie
        return true;
    }
}
