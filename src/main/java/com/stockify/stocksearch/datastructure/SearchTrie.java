package com.stockify.stocksearch.datastructure;

import com.stockify.stocksearch.dto.SymbolDTO;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

public class SearchTrie {
    private SearchTrieNode _root;
    private boolean _isNameSearch;

    public SearchTrie(boolean nameSearch) {
        _root = new SearchTrieNode();
        _isNameSearch = nameSearch;
    }

    public void reset(){
        _root = new SearchTrieNode();
    }

    // Inserts a word into the trie.
    public boolean insert(SymbolDTO symbolDTO) {
        String word = symbolDTO.getSymbol();
        if(_isNameSearch){
            word = symbolDTO.getSecurityName();
        }
        SearchTrieNode node = insertToTrie( word);
        node.setValidSymbol(true);
        node.setSymbolDTO(symbolDTO);
        return true;
    }

    private SearchTrieNode insertToTrie(String word){
        try{
            SearchTrieNode node = _root;
            int len = word.length();
            int i = 0;
            while (i < len) {
                SearchTrieNode next = node.getNext(word.charAt(i));
                if (next == null) {
                    node = node.setNext(word.charAt(i));
                } else {
                    node = next;
                }
                i++;
            }
            return node;
        }catch (ArrayIndexOutOfBoundsException arr){
            System.out.println("index out of bound on "+word);
            arr.printStackTrace();
            throw arr;
        }

    }

    // Search a word in the trie.
    public boolean search(String word) {
        SearchTrieNode traverseEndNode = traverse(word);
        if (traverseEndNode != null &&
                traverseEndNode.getC() == word.charAt(word.length() - 1)) {
            return true;
        }
        return false;
    }

    // Traverse the trie with the input word.
    public SearchTrieNode traverse(String word) {
        SearchTrieNode node = _root;
        int len = word.length();
        int i = 0;
        boolean searchEnd = false;
        while (i < len && !searchEnd) {
            node = node.getNext(word.charAt(i));
            if (node == null) {
                searchEnd = true;
            } else {
                i++;
            }
        }
        return node;
    }

    // prefix search the trie with the input string.
    public List<SymbolDTO> prefixSearch(String prefix) {
        List<SymbolDTO> returnSymbols = new ArrayList<>();
        SearchTrieNode node = traverse(prefix);
        if(node == null){
            return returnSymbols;
        }
        if (node.isValidSymbol()) {
            returnSymbols.add(node.getSymbolDTO());
        }

        NodeStack searchStack = new NodeStack();
        searchStack.pushAllChildren(node, 0);
        LinkedNode next = searchStack.pop();

        while (next != null) {
            searchStack.pushAllChildren(next.getNode(), next.getLevel() + 1);
            if (next.getNode().isValidSymbol()) {
                returnSymbols.add(next.getNode().getSymbolDTO());
            }
            next = searchStack.pop();
        }

        return returnSymbols;
    }


    @Data
    private class NodeStack {
        LinkedNode stackTop;

        public LinkedNode pop() {
            if (stackTop != null) {
                LinkedNode nextNode = stackTop;
                stackTop = nextNode.getNext();
                nextNode.setNext(null);
                return nextNode;
            }
            return null;
        }

        private void pushAllChildren(SearchTrieNode node, int inLevel) {
            for (SearchTrieNode each : node.getArr()) {
                if (each != null) {
                    LinkedNode newNode = new LinkedNode(each, inLevel);
                    newNode.setNext(stackTop);
                    stackTop = newNode;
                }
            }
        }

    }

    @Data
    private class LinkedNode {
        private SearchTrieNode node;
        private LinkedNode next;
        private int level;

        LinkedNode(SearchTrieNode inNode, int inLevel) {
            node = inNode;
            level = inLevel;
        }
    }
}
