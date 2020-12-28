package com.stockify.stocksearch.datastructure;

import com.stockify.stocksearch.dto.SymbolDTO;
import lombok.Data;

@Data
public class SearchTrieNode {
    private SearchTrieNode[] arr;
    private char c;
    private boolean isValidSymbol;
    private SymbolDTO symbolDTO;
    // Initialize your data structure here.
    public SearchTrieNode() {
        this.arr = new SearchTrieNode[28];
    }
    public SearchTrieNode(char ch) {
        this();
        c = ch;
    }
    public SearchTrieNode getNext(char c){
        return arr[findCharIndex(c)];
    }

    public SearchTrieNode setNext(char c){
        int indx = findCharIndex(c);
        arr[indx] = new SearchTrieNode(c);
        return arr[indx];
    }

    public int findCharIndex(char c){
        if(c=='.'){
            return 26;
        }
        if(c=='/'){
            return 27;
        }
        if(!Character.isAlphabetic(c)){
            return -1;
        }
        return( Character.toUpperCase(c) - 'A');
    }

    @Override
    public String toString() {
        return  c +
                " - " + isValidSymbol
               ;
    }
}
