package com.stockify.stocksearch.datastructure;

import com.stockify.stocksearch.dto.RelatedSymbolDTO;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {

    @Test
    public void testSort(){
        MaxHeap<RelatedSymbolDTO> testHeap = new MaxHeap<>(new RelatedSymbolDTO[5]);
        testHeap.insert(new RelatedSymbolDTO("abc", "", 30.0,""));
        testHeap.insert(new RelatedSymbolDTO("bbc", "",10.0,""));
        testHeap.insert(new RelatedSymbolDTO("cbc", "",40.0,""));
        testHeap.insert(new RelatedSymbolDTO("dbc","", 5.0,""));
        testHeap.insert(new RelatedSymbolDTO("ebc","", 7.0,""));
        RelatedSymbolDTO[] arr = testHeap.sort();

        System.out.println(arr);
        assertEquals(5.0, arr[0].getMarketCap());
        assertEquals(7.0, arr[1].getMarketCap());
        assertEquals(10.0, arr[2].getMarketCap());
        assertEquals(30.0, arr[3].getMarketCap());
        assertEquals(40.0, arr[4].getMarketCap());
    }

    @Test
    public void testResizeAndSort(){
        MaxHeap<RelatedSymbolDTO> testHeap = new MaxHeap<>(new RelatedSymbolDTO[5]);
        testHeap.insert(new RelatedSymbolDTO("abc","", 30.0,""));
        testHeap.insert(new RelatedSymbolDTO("bbc", "",10.0,""));
        testHeap.insert(new RelatedSymbolDTO("cbc", "",40.0,""));
        testHeap.insert(new RelatedSymbolDTO("dbc","", 5.0,""));
        testHeap.insert(new RelatedSymbolDTO("ebc", "",7.0,""));

        testHeap.insert(new RelatedSymbolDTO("fbc","", 3.0,""));
        testHeap.insert(new RelatedSymbolDTO("gbc", "",100.0,""));
        testHeap.insert(new RelatedSymbolDTO("hbc","", 4.0,""));
        testHeap.insert(new RelatedSymbolDTO("ibc", "",50.0,""));
        testHeap.insert(new RelatedSymbolDTO("jbc","", 70.0,""));
        testHeap.insert(new RelatedSymbolDTO("kbc", "",60.0,""));

        RelatedSymbolDTO[] arr = testHeap.sort();

        System.out.println(arr);
        assertEquals(3.0, arr[0].getMarketCap());
        assertEquals(4.0, arr[1].getMarketCap());
        assertEquals(5.0, arr[2].getMarketCap());
        assertEquals(7.0, arr[3].getMarketCap());
        assertEquals(10.0, arr[4].getMarketCap());
        assertEquals(30.0, arr[5].getMarketCap());
        assertEquals(40.0, arr[6].getMarketCap());
        assertEquals(50.0, arr[7].getMarketCap());
        assertEquals(60.0, arr[8].getMarketCap());
        assertEquals(70.0, arr[9].getMarketCap());
        assertEquals(100.0, arr[10].getMarketCap());
        assertEquals(20, arr.length);
        assertEquals(11, testHeap.getHeapSize());
        Map<String, Integer> keyMap = testHeap.getKeyMap();
        assertEquals(11, keyMap.keySet().size());
        assertEquals(0, keyMap.get("fbc"));
        assertEquals(1, keyMap.get("hbc"));
        assertEquals(9, keyMap.get("jbc"));

    }

}