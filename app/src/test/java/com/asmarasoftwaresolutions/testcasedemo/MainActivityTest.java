package com.asmarasoftwaresolutions.testcasedemo;


import android.graphics.Color;
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
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    private MainActivity mActivity;
    private View mView;

    @Before
    public void setUp() throws Exception {
        mActivity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
        mView = LayoutInflater.from(mActivity).inflate(R.layout.activity_main, null);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }


    /**
     * This test case tests if the views are present and are performing their tasks
     * @throws Exception
     */
    @Test
    public void testAllElements() throws Exception{
        Assert.assertNotNull(mActivity);
        Assert.assertEquals(mActivity.getResources().getString(R.string.app_name), "Test Case Demo");
        Assert.assertEquals(mActivity.getResources().getString(R.string.convert), "SHOW");
        Assert.assertEquals(mActivity.getResources().getString(R.string.country_prompt), "Choose a country");
        Assert.assertEquals(mActivity.getResources().getString(R.string.input_description), "Enter the number you would like to convert");
        Assert.assertEquals(mActivity.getResources().getString(R.string.no_input_submitted_error), "Please enter valid number.");
        Assert.assertEquals(mActivity.getResources().getString(R.string.result), "Result");
        Assert.assertEquals(mActivity.getResources().getString(R.string.unit_prompt), "Choose a country");
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
        Assert.assertEquals(resutWidth, (mActivity.findViewById(R.id.tv_result).getLayoutParams()).width);
        Assert.assertEquals(resultHeight, (mActivity.findViewById(R.id.tv_result).getLayoutParams()).height);
        Assert.assertEquals(cntrspinnWidth, (mActivity.findViewById(R.id.s_countries).getLayoutParams()).width);
        Assert.assertEquals(cntrsspinnHeight, (mActivity.findViewById(R.id.s_countries).getLayoutParams()).height);
        Assert.assertEquals(unitsspinnWidth, (mActivity.findViewById(R.id.s_measurement_units).getLayoutParams()).width);
        Assert.assertEquals(unitsspinnHeight, (mActivity.findViewById(R.id.s_measurement_units).getLayoutParams()).height);
        Assert.assertEquals(inputTextWidth, (mActivity.findViewById(R.id.et_user_input).getLayoutParams()).width);
        Assert.assertEquals(inputTextHeight, (mActivity.findViewById(R.id.et_user_input).getLayoutParams()).height);
        Assert.assertEquals(descWidth, (mActivity.findViewById(R.id.tv_input_description).getLayoutParams()).width);
        Assert.assertEquals(descHeight, (mActivity.findViewById(R.id.tv_input_description).getLayoutParams()).height);
        Assert.assertEquals(btnWidth, (mActivity.findViewById(R.id.b_show).getLayoutParams()).width);
        Assert.assertEquals(btnHeight, (mActivity.findViewById(R.id.b_show).getLayoutParams()).height);
        //this tests the Toast message
        Assert.assertEquals("Please enter valid number.", ShadowToast.getTextOfLatestToast());

        Shadows.shadowOf(Color.valueOf(R.color.colorAccent));
    }
}
