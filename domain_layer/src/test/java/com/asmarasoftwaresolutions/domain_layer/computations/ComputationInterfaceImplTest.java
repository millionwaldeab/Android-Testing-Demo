package com.asmarasoftwaresolutions.domain_layer.computations;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComputationInterfaceImplTest {

    ComputationsInterfaceImpl mComputationInterfaceImpl;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mComputationInterfaceImpl = Mockito.spy(ComputationsInterfaceImpl.class);
    }

    @After
    public void cleanUp(){
        mComputationInterfaceImpl = null;
    }

    @Test
    public void testCelcToHrenht(){
        double test = mComputationInterfaceImpl.celsiusToFrenheit("0");
        Assert.assertEquals(32.0, test); //to test double import Junit.framework.Assert
    }

    @Test
    public void testFrnhtToCelc(){
        double test = mComputationInterfaceImpl.frenheitToCelcius("32");
        Assert.assertEquals(0.0, test); //to test double import Junit.framework.Assert
    }

    @Test
    public void testCentmToInch(){
        double test = mComputationInterfaceImpl.centimeterToInches("100");
        Assert.assertEquals(254.0, test); //to test double import Junit.framework.Assert
    }

    @Test
    public void testInchToCentm(){
        double test = mComputationInterfaceImpl.inchesToCentimeter("254");
        Assert.assertEquals(100.0, test); //to test double import Junit.framework.Assert
    }

    @Test
    public void testKgToLb(){
        double test = mComputationInterfaceImpl.kgToLb("10");
        Assert.assertEquals(4.535147392290249, test); //to test double import Junit.framework.Assert
    }

    @Test
    public void testLbToKg(){
        double test = mComputationInterfaceImpl.lbToKg("4.535147392290249");
        Assert.assertEquals(10.0, test); //to test double import Junit.framework.Assert
    }
}
