package com.ams.sampleapp;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest extends SetUp {

    @Test
    public void toggleTestWithoutPageVerify() {
        ams.clickById(R.id.simpleToggleButton1);
        ams.clickById(R.id.addTrip);
        }

    @Test
    public void submitButtonTest() {
        ams.clickById(R.id.simpleToggleButton1);
        ams.clickById(R.id.submitButton);
        ams.verifyPage("sampleSubmitZ",
                testName.getMethodName());
    }
}