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
}