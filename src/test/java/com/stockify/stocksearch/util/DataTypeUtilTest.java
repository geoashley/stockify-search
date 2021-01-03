package com.stockify.stocksearch.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataTypeUtilTest {

    @Test
    public void isNull(){
        assertEquals("",DataTypeUtil.nonNullString(null));
    }

    @Test
    public void isNotNull(){
        assertEquals("AB",DataTypeUtil.nonNullString("AB"));
    }

    @Test
    public void testNumeric(){
        assertEquals(true, DataTypeUtil.isNumeric("111"));
        assertEquals(true, DataTypeUtil.isNumeric("111.00"));
        assertEquals(true, DataTypeUtil.isNumeric("111.12"));
    }

    @Test
    public void testNotNumeric(){
        assertEquals(false, DataTypeUtil.isNumeric(""));
        assertEquals(false, DataTypeUtil.isNumeric("11s1.00"));
        assertEquals(false, DataTypeUtil.isNumeric("111.1a2"));
    }
}