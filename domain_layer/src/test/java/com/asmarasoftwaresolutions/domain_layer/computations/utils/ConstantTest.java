package com.asmarasoftwaresolutions.domain_layer.computations.utils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class ConstantTest {

    private Constant mConstant;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mConstant = Mockito.spy(Constant.class);
    }

    @After
    public void cleanUp(){
        mConstant = null;
    }

    @Test
    public void testObject(){
        Assert.assertNotNull(mConstant);
        Assert.assertTrue(Constant.Country.class.isEnum());
        Assert.assertEquals("America", Constant.Country.values()[0].name());
        Assert.assertEquals("Australia", Constant.Country.values()[1].name());
        Assert.assertEquals("Brazil", Constant.Country.values()[2].name());
        Assert.assertEquals("Canada", Constant.Country.values()[3].name());
        Assert.assertEquals("Congo", Constant.Country.values()[4].name());
        Assert.assertEquals("England", Constant.Country.values()[5].name());
        Assert.assertEquals(6, Constant.Country.values().length);
    }
}
