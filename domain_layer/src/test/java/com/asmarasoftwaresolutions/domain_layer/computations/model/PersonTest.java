package com.asmarasoftwaresolutions.domain_layer.computations.model;

import com.asmarasoftwaresolutions.domain_layer.computations.utils.Constant;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PersonTest {
    @Mock
    private Person mPerson;

    private Constant.Country mCountry;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(mPerson);
    }

    @After
    public void cleanUp(){
        mPerson = null;
        mCountry = null;
    }

    @Test
    public void testPerson(){
        mPerson = new Person("Kim", mCountry);
        Assert.assertNotNull(mPerson);
    }
}
