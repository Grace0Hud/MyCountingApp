package com.example.mycountingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    int num1 = 0;
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
        num1++;
        updateIntroTV();
        //Toast.makeText(this, "This is the first button!", Toast.LENGTH_SHORT).show();
    }

    public void onClickSecondButton(View view)
    {
        num1--;
        updateIntroTV();
        //Toast.makeText(this, "This is the second button!", Toast.LENGTH_SHORT).show();
    }
    public void onClickGoToScreen2(View view)
    {
        Intent intent = new Intent(this, Screen2.class);
        startActivity(intent);
    }

    public void openDialogue(View view)
    {
        //creating it programatically
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Confirm reset count");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i)
            {
              Toast.makeText(MainActivity.this, "Reset confirmed",Toast.LENGTH_LONG).show();
              num1 = 0;
              updateIntroTV();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                //nothing here but having listener allows box to close
            }
        });
        //actually calls it to be made and shown
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
     }

    private void updateIntroTV() {
        TextView introTV = (TextView) findViewById(R.id.introTV);
        introTV.setText("You now have " + num1 + " fishies");
    }

}//end class