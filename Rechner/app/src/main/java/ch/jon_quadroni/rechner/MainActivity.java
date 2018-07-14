package ch.jon_quadroni.rechner;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private double result = 0.0;
    private double number = 0.0;

    private void addDigit(int digit, TextView rv){
        String resultString = rv.getText().toString();

        if(resultString.startsWith("0")){
            resultString = "";
        }


        resultString = resultString + Integer.toString(digit);
        Log.d("Log-Result", resultString);
        Log.d("Max Int", Integer.toString(Integer.MAX_VALUE));
        rv.setText(resultString);
    }

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

        // Resultat
        final TextView resultView = (TextView)findViewById(R.id.result);

        final Button button0 = (Button)findViewById(R.id.number_0);
        final Button button1 = (Button)findViewById(R.id.number_01);
        final Button button2 = (Button)findViewById(R.id.number_02);
        final Button button3 = (Button)findViewById(R.id.number_03);
        final Button button4 = (Button)findViewById(R.id.number_04);
        final Button button5 = (Button)findViewById(R.id.number_05);
        final Button button6 = (Button)findViewById(R.id.number_06);
        final Button button7 = (Button)findViewById(R.id.number_07);
        final Button button8 = (Button)findViewById(R.id.number_08);
        final Button button9 = (Button)findViewById(R.id.number_09);

        final Button divide     = (Button)findViewById(R.id.divide);
        final Button multiply   = (Button)findViewById(R.id.multiply);
        final Button minus      = (Button)findViewById(R.id.minus);
        final Button clear      = (Button)findViewById(R.id.clear);
        final Button equals     = (Button)findViewById(R.id.equals);
        final Button plus       = (Button)findViewById(R.id.plus);

        button0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addDigit(0, resultView);
            }
        });

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addDigit(1, resultView);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addDigit(2, resultView);
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addDigit(3, resultView);
            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addDigit(4, resultView);
            }
        });

        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addDigit(5, resultView);
            }
        });

        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addDigit(6, resultView);
            }
        });

        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addDigit(7, resultView);
            }
        });

        button8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addDigit(8, resultView);
            }
        });

        button9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addDigit(9, resultView);
            }
        });

        divide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });

        multiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });

        minus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });

        plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                number = Double.parseDouble(resultView.getText().toString());
            }
        });

        equals.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });

        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                result = 0.0;
                number = 0.0;
                resultView.setText("0");
            }
        });
    }

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
