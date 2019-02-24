package com.asmarasoftwaresolutions.testcasedemo;

import android.app.ActionBar;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    private MainActivity mActivity;

    @Before
    public void setUp() throws Exception {
        mActivity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    /**
     * This test case tests if the views are present and are performing their tasks
     * @throws Exception
     */
    @Test
    public void testAllElements() throws Exception{
        Assert.assertNotNull(mActivity);
        //Assert.assertEquals(mActivity.findViewById(R.string.app_name).toString(), "Test Case Demo");
        //Assert.assertNotNull(mActivity.findViewById(R.string.convert));
        //Assert.assertNotNull(mActivity.findViewById(R.string.country_prompt));
        //Assert.assertNotNull(mActivity.findViewById(R.string.input_description));
        //Assert.assertNotNull(mActivity.findViewById(R.string.no_input_submitted_error));
        //Assert.assertNotNull(mActivity.findViewById(R.string.result));
        //Assert.assertNotNull(mActivity.findViewById(R.string.unit_prompt));
        Assert.assertTrue(mActivity.findViewById(R.id.b_show).hasOnClickListeners());
        mActivity.findViewById(R.id.b_show).performClick();
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
        //Assert.assertThat(ShadowToast.getTextOfLatestToast(), equalTo("Please enter valid number."));
    }
}
