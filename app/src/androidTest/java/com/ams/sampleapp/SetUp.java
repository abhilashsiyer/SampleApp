package com.ams.sampleapp;

import androidx.test.platform.app.InstrumentationRegistry;

import com.ams.amsandroid.AMSAndroid;
import com.ams.amsandroid.api.AMS;
import com.ams.sampleapp.model.AmsConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import java.io.IOException;
import java.io.InputStream;

public class SetUp {
    // au.com.qantas.qantas/.startup.presentation.OnboardingActivity
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    AmsConfig amsConfig;

    {
        try {
            InputStream input = InstrumentationRegistry.getInstrumentation().getContext().
                    getResources().getAssets().open("amsConfig.yml");

            amsConfig = mapper.readValue(input, AmsConfig.class);
            System.out.println("amsConfig" + amsConfig.testMatrix);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    AMS ams = new AMSAndroid("sampleAPIKey",
            "projectSample","master", amsConfig.testMatrix);

    @Rule
    public TestName testName= new TestName();

    @Before
    public void setUp() {
        ams.launchApp("com.ams.sampleapp");
   //     ams.launchAppUsingShell("au.com.qantas.qantas",
   //             ".AppIconRedActivityAlias");
    }

    @After
    public void teardown() {
        ams.end(testName);
    }
}
