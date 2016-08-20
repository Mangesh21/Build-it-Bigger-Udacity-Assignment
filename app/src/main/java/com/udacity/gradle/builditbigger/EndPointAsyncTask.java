package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.jokesapp.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by mangesh on 16/8/16.
 */


public class EndPointAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Callback mCallback;
    private Exception exception = null;

    public EndPointAsyncTask(Callback callback) {
        this.mCallback = callback;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8081/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        try {
            return myApiService.getJokes().execute().getJoke();
        } catch (IOException e) {
            exception = e;
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) { //result can be either joke or error message
        if (mCallback != null) {
            mCallback.onComplete(result, exception);
        }
    }
}
