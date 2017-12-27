package com.technotalkative.beproject;

/**
 * Created by Dell on 18/01/2017.
 */


 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;
 import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new IntentLauncher().start();
    }
    public class IntentLauncher extends Thread {
        public void run()
        {
            try
            {
                Thread tr=new Thread();
                tr.sleep(900*7);
                System.out.println("ENTERED");
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
            }
            catch (Exception e){}
        }
    }
}