package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import org.junit.Assert;

/**
 * Created by mangesh on 16/8/16.
 */
public class EndPointAsyncTaskTest extends AndroidTestCase implements Callback{


    private EndPointAsyncTask async = null;

    public void setUP() throws Exception{
        super.setUp();
    }

    public void tearDown() throws Exception{
        super.tearDown();
    }

    public void testFetchJoke() {
        async = (EndPointAsyncTask) new EndPointAsyncTask(EndPointAsyncTaskTest.this).execute();

    }

    @Override
    public void onJokeReceived(String joke) {
        Assert.assertNotNull(joke);
        Assert.assertNotEquals("",joke);
    }
}