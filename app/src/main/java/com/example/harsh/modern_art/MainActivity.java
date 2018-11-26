package com.example.harsh.modern_art;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    View v1, v2, v3, v4, v5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v1 = findViewById(R.id.view1);
        v2 = findViewById(R.id.view2);
        v3 = findViewById(R.id.view3);
        v4 = findViewById(R.id.view4);
        v5 = findViewById(R.id.view5);
        SeekBar sk = findViewById(R.id.seek);

        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateColor(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    void updateColor(int change)
    {
        //Log.i("Hello", ""+change);
        v1.setBackgroundColor(Color.parseColor("#ef0b0b")+change*2);
        v2.setBackgroundColor(Color.parseColor("#00dbba")+change/2  );
        v3.setBackgroundColor(Color.parseColor("#ff9000")+change*2);
        v4.setBackgroundColor(Color.parseColor("#FFFFFF")+change*2);
        v5.setBackgroundColor(Color.parseColor("#00ad3c")+change);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.more) {
            final AlertDialog alert = new AlertDialog.Builder(this).create();
            alert.setMessage("Inspired by the works of artists such as Piet Mondrian and Ben Nicholson\n\nClick below to know more!");

            alert.setButton(DialogInterface.BUTTON_POSITIVE, "Visit Moma",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(("https://www.moma.org/")));
                            startActivity(intent);
                        }
                    });
            alert.setButton(DialogInterface.BUTTON_NEGATIVE, "Later",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            alert.dismiss();
                        }
                    });

            alert.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
