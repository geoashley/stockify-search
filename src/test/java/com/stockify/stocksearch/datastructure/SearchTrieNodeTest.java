package com.stockify.stocksearch.datastructure;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTrieNodeTest {
    SearchTrieNode node = new SearchTrieNode();

    @Test
    public void indexTest(){
        assertEquals(10,node.findCharIndex('A'));
        assertEquals(35,node.findCharIndex('Z'));
        assertEquals(10,node.findCharIndex('a'));
        assertEquals(35,node.findCharIndex('z'));
        assertEquals(36,node.findCharIndex('.'));
        assertEquals(4,node.findCharIndex('4'));
    }

}