package com.asmarasoftwaresolutions.testcasedemo;

import android.graphics.Color;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private MainActivity mActivity;
    private View mView;

    private List<String> mockList = new ArrayList<>();

    private List<String> spyList = new ArrayList();

    @Before
    public void setUp(){
        mActivity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
        mView = LayoutInflater.from(mActivity).inflate(R.layout.activity_main, null);
        mockList = mock(ArrayList.class);
        spyList = spy(ArrayList.class);
    }

    @After
    public void tearDown() {
        mActivity = null;
    }

    @Test
    public void testMockList() {
        //by default, calling the methods of mock object will do nothing
        mockList.add("test");

        verify(mockList, atLeast(1)).add("test");
        assertEquals(0, mockList.size());
        assertNull(mockList.get(0));
    }

    @Test
    public void testSpyList() {
        //spy object will call the real method when not stub
        spyList.add("test");

        verify(spyList).add("test");
        assertEquals(1, spyList.size());
        assertEquals("test", spyList.get(0));
    }

    @Test
    public void testMockWithStub() {
        //try stubbing a method
        String expected = "Mock 100";
        when(mockList.get(100)).thenReturn(expected);

        assertEquals(expected, mockList.get(100));
    }

    @Test
    public void testSpyWithStub() {
        //stubbing a spy method will result the same as the mock object
        String expected = "Spy 100";
        //take note of using doReturn instead of when
        doReturn(expected).when(spyList).get(100);

        assertEquals(expected, spyList.get(100));
    }

    @Test
    public void testAllElements(){
        Assert.assertNotNull(mActivity);
        assertEquals(mActivity.getResources().getString(R.string.app_name), "Test Case Demo");
        assertEquals(mActivity.getResources().getString(R.string.convert), "SHOW");
        assertEquals(mActivity.getResources().getString(R.string.country_prompt), "Choose a country");
        assertEquals(mActivity.getResources().getString(R.string.input_description), "Enter the number you would like to convert");
        assertEquals(mActivity.getResources().getString(R.string.no_input_submitted_error), "Please enter valid number.");
        assertEquals(mActivity.getResources().getString(R.string.result), "Result");
        assertEquals(mActivity.getResources().getString(R.string.unit_prompt), "Choose a country");
        Assert.assertTrue(mActivity.findViewById(R.id.b_show).hasOnClickListeners());
        mActivity.findViewById(R.id.b_show).performClick();
        Assert.assertNotNull(mView); //this tastes the layout
        Assert.assertNotNull(mActivity.findViewById(R.id.s_measurement_units));
        Assert.assertNotNull(mActivity.findViewById(R.id.s_countries));
        Assert.assertNotNull(mActivity.findViewById(R.id.et_user_input));
        Assert.assertNotNull(mActivity.findViewById(R.id.tv_input_description));
        Assert.assertNotNull(mActivity.findViewById(R.id.tv_result));
    }

    /**
     * This test case tests the getComputation method of MainActivity
     */
   @Test
    public void testDimensions(){
        int resutWidth = 250, resultHeight = 20, cntrspinnWidth = 140, cntrsspinnHeight = 25,
                unitsspinnWidth = 140, unitsspinnHeight = 25, inputTextWidth = 100, inputTextHeight = 40,
                        descWidth = 240, descHeight = 20, btnWidth = 170, btnHeight = 50;
        assertEquals(resutWidth, (mActivity.findViewById(R.id.tv_result).getLayoutParams()).width);
        assertEquals(resultHeight, (mActivity.findViewById(R.id.tv_result).getLayoutParams()).height);
        assertEquals(cntrspinnWidth, (mActivity.findViewById(R.id.s_countries).getLayoutParams()).width);
        assertEquals(cntrsspinnHeight, (mActivity.findViewById(R.id.s_countries).getLayoutParams()).height);
        assertEquals(unitsspinnWidth, (mActivity.findViewById(R.id.s_measurement_units).getLayoutParams()).width);
        assertEquals(unitsspinnHeight, (mActivity.findViewById(R.id.s_measurement_units).getLayoutParams()).height);
        assertEquals(inputTextWidth, (mActivity.findViewById(R.id.et_user_input).getLayoutParams()).width);
        assertEquals(inputTextHeight, (mActivity.findViewById(R.id.et_user_input).getLayoutParams()).height);
        assertEquals(descWidth, (mActivity.findViewById(R.id.tv_input_description).getLayoutParams()).width);
        assertEquals(descHeight, (mActivity.findViewById(R.id.tv_input_description).getLayoutParams()).height);
        assertEquals(btnWidth, (mActivity.findViewById(R.id.b_show).getLayoutParams()).width);
        assertEquals(btnHeight, (mActivity.findViewById(R.id.b_show).getLayoutParams()).height);
        //this tests the Toast message
        //Assert.assertEquals("Please enter valid number.", ShadowToast.getTextOfLatestToast());

        Shadows.shadowOf(Color.valueOf(R.color.colorAccent));
    }

    @Test
    public void testShadows(){
       Shadows.shadowOf(Looper.getMainLooper()).getScheduler();
        final String MOCKITO = "mockito";
        final String ESPRESSO = "espresso";
        final int MOCKITO_INT = 1;
        final int ESPRESSO_INT = 2;
        Comparable comparable = mock(Comparable.class);
        when(comparable.compareTo(MOCKITO)).thenReturn(MOCKITO_INT);
        when(comparable.compareTo(ESPRESSO)).thenReturn(ESPRESSO_INT);
        assertEquals(MOCKITO_INT, comparable.compareTo(MOCKITO));
        assertEquals(ESPRESSO_INT, comparable.compareTo(ESPRESSO));
    }
}
