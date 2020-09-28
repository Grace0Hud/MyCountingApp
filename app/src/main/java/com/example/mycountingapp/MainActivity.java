package com.example.mycountingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //oncreate is the driver method basically - like main
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("info", "------------This is a message in the log-----------");
        Log.e("error", "-----------oho that's an error----------");
        Log.w("warning", "---------You want to be careful with that---------");
        Log.wtf("What a Terrible Failure", "-----------THAT ONE IS REALLY BAD------------");

        Toast.makeText(this, "Your toast is ready!", Toast.LENGTH_LONG).show();
    }//end on create

    public void onClickFirstButton(View view)
    {
        Toast.makeText(this, "This is the first button!", Toast.LENGTH_SHORT).show();
    }
    public void onClickSecondButton(View view)
    {
        Toast.makeText(this, "This is the second button!", Toast.LENGTH_SHORT).show();
    }
    public void onClickGoToScreen2(View view)
    {
        Intent intent = new Intent(this, Screen2.class);
        startActivity(intent);
    }

}//end class