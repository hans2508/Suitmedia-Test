package com.hansck.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import model.Event;


public class Screen3 extends ActionBarActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);

        Event data[] = new Event[]
                {
                        new Event(R.drawable.pic1, "Event 1","15-Maret-2015"),
                        new Event(R.drawable.pic2, "Event 2","27-Maret-2015"),
                        new Event(R.drawable.pic3, "Event 3","10-April-2015"),
                        new Event(R.drawable.pic4, "Event 4","12-April-2015"),
                        new Event(R.drawable.pic5, "Event 5","25-Juni-2015"),
                        new Event(R.drawable.pic1, "Event 6","24-Juni-2015"),
                        new Event(R.drawable.pic2, "Event 7","23-Juni-2015"),
                        new Event(R.drawable.pic3, "Event 8","22-Juni-2015")
                };

        ListViewAdapter adapter = new ListViewAdapter(this,R.layout.list_view_item, data);
        listView = (ListView)findViewById(R.id.listView);
        View header = (View)getLayoutInflater().inflate(R.layout.list_view_header, null);
        listView.addHeaderView(header);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position,long id) {

                Event e = (Event) adapterView.getItemAtPosition(position);
                String value = e.getNama();
                Intent intent = new Intent(Screen3.this,Screen2.class);
                intent.putExtra("eNama", value);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_screen3, menu);
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
}
