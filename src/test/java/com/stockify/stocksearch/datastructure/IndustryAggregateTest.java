package com.stockify.stocksearch.datastructure;

import org.junit.jupiter.api.Test;

import java.net.PortUnreachableException;

import static org.junit.jupiter.api.Assertions.*;

class IndustryAggregateTest {

    @Test
    public void testSum(){
        IndustryAggregate agg = IndustryAggregate.getInstance();
        agg.insert("Computer Infrastructure","100000");
        agg.insert("Computer Infrastructure","100000");
        agg.insert("Computer Infrastructure","100000");
        agg.insert("Computer chips","200000");
        assertEquals(Double.valueOf((double) 300000),agg.getAggregateMarketCap("Computer Infrastructure"));
        assertEquals(Double.valueOf((double) 0),agg.getAggregateMarketCap("Computer Games"));
        assertEquals(Double.valueOf((double) 200000),agg.getAggregateMarketCap("Computer chips"));

    }
}