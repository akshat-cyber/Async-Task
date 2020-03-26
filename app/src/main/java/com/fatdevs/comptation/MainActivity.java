package com.fatdevs.comptation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
public void Start(View view){
async as = new async();
as.onPreExecute();
as.doInBackground(12);
as.onProgressUpdate(50);
as.onPostExecute(1);
}
    public void Stop(View view){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
  static class async extends AsyncTask<Integer ,Integer,Integer>{

      @Override
      protected void onPreExecute() {
          super.onPreExecute();
          Log.i("onPreExecute","Starting Background Processes");
      }
      @Override
      protected Integer doInBackground(Integer... strings) {
          for(int i =0 ;i<strings[0];i++){
              Log.i("Background ", String.valueOf(i));
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
          return 0;
      }

      @SuppressLint("WrongThread")
      @Override
      protected void onProgressUpdate(Integer... values) {
          super.onProgressUpdate(values);
          if (values[0] == 50 ){
              Log.i("Progress:","50% completed");
          }
      }

      @Override
      protected void onPostExecute(Integer integer) {
          super.onPostExecute(integer);
          Log.i("onPostExecute:","Executed");
      }
  }
}