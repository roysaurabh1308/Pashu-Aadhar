package com.developerdesk9.pashuaadhar;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class splash_screen extends AppCompatActivity {

    TextView text,text1;
    boolean a=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


         text=findViewById(R.id.splashtext);
         text1=findViewById(R.id.bel_tv);
        ImageView suar=findViewById(R.id.logo);
        a=isNetworkAvailable();
        Animation an= AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);
        suar.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {


                if (a==true){
                    finish();
                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);
                }
                else {
                    text.setText("Internet Unavailable !");
                    text1.setText("Please connect to Internet");
                    Toast.makeText(getApplicationContext(),"Please Connect to Internet",Toast.LENGTH_SHORT).show();
                    return;
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        suar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=isNetworkAvailable();
                if (a==true){
                    finish();
                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);
                }
                else {
                    text.setText("Internet Unavailable !");
                    Toast.makeText(getApplicationContext(),"Please Connect to Internet",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
