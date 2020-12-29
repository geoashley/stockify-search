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
        this.arr = new SearchTrieNode[53];
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
        if(Character.isDigit(c)){
            return c-'0';
        }
        int charOffset = 10;
        switch (c){
            case '.':
                return charOffset+26;
            case '/':
                return charOffset+27;
            case ' ':
                return charOffset+28;
            case '(':
                return charOffset+29;
            case ')':
                return charOffset+30;
            case '%':
                return charOffset+31;
            case '-':
                return charOffset+32;
            case '$':
                return charOffset+33;
            case '&':
                return charOffset+34;
            case '\'':
                return charOffset+35;
            case ';':
                return charOffset+36;
            case '?':
                return charOffset+37;
            case '!':
                return charOffset+38;
            case '@':
                return charOffset+39;
            case '#':
                return charOffset+40;
            case '*':
                return charOffset+41;
            case ':':
                return charOffset+42;
        }
        if(!Character.isAlphabetic(c)){
            return -1;
        }
        return( charOffset + (Character.toUpperCase(c) - 'A'));
    }

    @Override
    public String toString() {
        return  c +
                " - " + isValidSymbol
               ;
    }
}
