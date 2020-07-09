package com.codedifferently.stayready;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ConvertTest {
    private static final double DELTA = 2;
    Convert con=new Convert();
    @Before
    public void beforeTest(){
        con.addRates();
    }
    @Test public void addTest(){
        assertTrue(con.contains("USD"));
        assertTrue(con.getRate("USD")==1.00);
        assertEquals(1.43,con.getRate("SD"),DELTA);
        assertEquals(1.32,con.getRate("CAD"),DELTA);

    }
    @Test public void ratesTest(){
        assertEquals(1.00,con.getRate("USD"), 0.01);
        assertFalse(con.getRate("USD")==con.getRate("SD"));
    }
    @Test public void dollarEuroTest(){
        double actual=con.convertToCurrency("USD","Euro",1.00);
        assertEquals(con.getRate("Euro"),actual, DELTA);
    }
    @Test public void euroDollarTest(){
        double actual=con.convertToCurrency("Euro","USD",20.00);
        assertEquals(22.57,actual, DELTA);
    }
    @Test public void euroPoundTest(){
        double actual=con.convertToCurrency("Euro","Pound",20.00);
        assertEquals(17.90,actual, DELTA);
    }
    @Test public void poundRupeeTest(){
        double actual=con.convertToCurrency("Pound","Rupee",20.00);
        assertEquals(1894.65,actual, DELTA);
    }
    @Test public void rupeeCADTest(){
        double actual=con.convertToCurrency("Rupee","CAD",20.00);
        assertEquals(.36,actual, DELTA);
    }
    @Test public void cadSDTest(){
        double actual=con.convertToCurrency("CAD","SD",20.00);
        assertEquals(20.48,actual, DELTA);
    }
    @Test public void sdSFTest(){
        double actual=con.convertToCurrency("SD","SF",20.00);
        assertEquals(13.51,actual, DELTA);
    }
    @Test public void sfRinggitTest(){
        double actual=con.convertToCurrency("SF","Ringgit",20.00);
        assertEquals(90.60,actual, DELTA);
    }
    @Test public void ringgitYenTest(){
        double actual=con.convertToCurrency("Ringgit","Yen",20.00);
        assertEquals(503.13,actual, DELTA);
    }@Test public void yenYuanTest(){
        double actual=con.convertToCurrency("Yen","Yuan",20.00);
        assertEquals(1.304,actual, DELTA);
    }

}
