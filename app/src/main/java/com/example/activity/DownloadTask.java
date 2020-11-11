package com.example.activity;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class DownloadTask extends AsyncTask<String,Integer,Void> {

    private static final String TAG = DownloadTask.class.getSimpleName() ;
    ProgressBar mprogressBar;
    public DownloadTask(ProgressBar progressBar) {
       mprogressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mprogressBar.setVisibility(View.VISIBLE);
    }


    /**
     * this method will run on a seperate thread
     * @param strings
     * @return
     */
    @Override
    protected Void doInBackground(String... strings) {
        Log.i(TAG,"doInBackground"+strings[0]);

        try {
            for (int i=1; i<21; i++) {
                publishProgress(i * 5);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mprogressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        mprogressBar.setVisibility(View.INVISIBLE);
    }
}
