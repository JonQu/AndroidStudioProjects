package c.quadroni.listviewtest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private String ENDPOINT = "http://transport.opendata.ch/v1/stationboard?station=Zurich&limit=50";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        serverCall();

        Spinner spinner = (Spinner)findViewById(R.id.spinner);

        String[] data = { "1. Element", "2. Element", "3. Element", "4. Element" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this.getBaseContext(),android.R.layout.simple_list_item_1, android.R.id.text1, data);
        spinner.setAdapter(adapter);

    }

    protected void serverCall(){
        //create a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //define a request. You can also define the methods onPostsLoaded
        //and onPostsError as anonymous inner classes.
        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT, onPostsLoaded, onPostsError);

        //add the call to the request queue
        requestQueue.add(request);
    }

    private final Response.Listener<String> onPostsLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response){
            Log.i("PostActivity", response);

            Context ctx = getApplicationContext();
            InputStream inputStream = ctx.getResources().openRawResource(R.raw.stationboard);

            // convert
            Gson gson = new Gson();
            StationBoard sb = gson.fromJson(response, StationBoard.class);

            //and set the adapter for this list view
            ListView listView = (ListView)findViewById(R.id.user_list);
            ListViewAdapter adapter = new ListViewAdapter(sb.stationboard, ctx);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    //our data that we want to sent to the detail activity
                    String data = "my data";
                    //create the intent to our detail activity
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    //write the data
                    intent.putExtra("LISTVIEWID", i);
                    //and start the activity
                    startActivity(intent);
                }
            });

            listView.setAdapter(adapter);
        }
    };

    private final Response.ErrorListener onPostsError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error){
            Log.e("PostActivity", error.toString());
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
