package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;

/**
 * Created by mangesh on 16/8/16.
 */
public class EndPointAsyncTaskTest extends ApplicationTestCase<Application> {

    String result = null;
    Exception mError = null;
    CountDownLatch signal = null;

    public EndPointAsyncTaskTest(Class<Application> applicationClass) {
        super(applicationClass);
    }

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }


    public void testjoke() throws InterruptedException {

        EndPointAsyncTask endPointAsyncTask = (EndPointAsyncTask) new EndPointAsyncTask(new Callback() {
            @Override
            public void onComplete(String result, Exception e) {
                EndPointAsyncTaskTest.this.result = result;
                mError = e;
                signal.countDown();;
            }
        }).execute();
        signal.await();

        assertNull(mError);
        assertFalse(TextUtils.isEmpty(result));
    }
}

