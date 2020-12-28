package com.stockify.stocksearch.datastructure;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTrieNodeTest {
    SearchTrieNode node = new SearchTrieNode();

    @Test
    public void indexTest(){
        assertEquals(0,node.findCharIndex('A'));
        assertEquals(25,node.findCharIndex('Z'));
        assertEquals(0,node.findCharIndex('a'));
        assertEquals(25,node.findCharIndex('z'));
        assertEquals(26,node.findCharIndex('.'));
        assertEquals(-1,node.findCharIndex('4'));
    }

}