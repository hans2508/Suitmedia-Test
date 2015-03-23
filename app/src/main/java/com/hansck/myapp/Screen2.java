package com.hansck.myapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Screen2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        Intent intent = getIntent();
        String message = intent.getStringExtra("nama");
        String eventMessage = intent.getStringExtra("eNama");
        String guestNama = intent.getStringExtra("gNama");
        String guestBirthdate = intent.getStringExtra("gBirthdate");
        SharedPreferences prefs = this.getSharedPreferences("keyNama", Context.MODE_PRIVATE);

        //Cek Palindrom
        if (message != null) {
            boolean status = true;
            int i = 0;
            int j = message.length() - 1;
            char[] arrMessage = message.toCharArray();
            while (i < j) {

                if (arrMessage[i] != (arrMessage[j])) {
                    status = false;
                    break;
                }
                i++;
                j--;
            }

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("Informasi");
            if (status == true) {
                alertDialog.setMessage("Nama palindrom");
            } else {
                alertDialog.setMessage("Nama bukan palindrom");
            }
            alertDialog.setPositiveButton("OK", null);
            alertDialog.show();
        }

        //Set Textview Nama
        String nameKey = "keyNama";
        String nama = prefs.getString(nameKey, "");
        if (nama != null && !nama.equals("") && message == null) {
            message = nama;
        }
        prefs.edit().putString(nameKey, message).apply();

        TextView textNama = (TextView) findViewById(R.id.textNama);
        textNama.setTextSize(40);
        textNama.setText("Nama : " + message);

        //Set Button Event
        if (eventMessage != null) {
            Button btn = (Button) findViewById(R.id.btnEvent);
            btn.setText(eventMessage);
        }

        //Set Button Guest
        if (guestNama != null && guestBirthdate != null) {
            Button btn = (Button) findViewById(R.id.btnGuest);
            btn.setText(guestNama);

            //Birthdate : YYYY-MM-DD
            int tanggal = Integer.parseInt(guestBirthdate.substring(8, 10));
            if (tanggal % 2 == 0 && tanggal % 3 == 0) {
                Toast.makeText(getBaseContext(), "iOS", Toast.LENGTH_SHORT).show();
            } else if (tanggal % 2 == 0) {
                Toast.makeText(getBaseContext(), "Blackberry", Toast.LENGTH_SHORT).show();
            } else if (tanggal % 3 == 0) {
                Toast.makeText(getBaseContext(), "Android", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getBaseContext(), "Feature phone", Toast.LENGTH_SHORT).show();
            }

            int bulan = Integer.parseInt(guestBirthdate.substring(5, 7));
            boolean prima = false;
            int i = 2;
            while (prima == false && i < bulan) {
                if (bulan % i == 0) {
                    prima = true;
                }
                i++;
            }
            if (prima == true) {
                Toast.makeText(getBaseContext(), "Bulan tidak prima", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getBaseContext(), "Bulan prima", Toast.LENGTH_SHORT).show();
            }

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void searchEvent(View view) {

        Intent intent = new Intent(this, Screen3.class);
        startActivity(intent);
    }

    public void searchGuest(View view) {

        Intent intent = new Intent(this, Screen4.class);
        startActivity(intent);
    }

}
