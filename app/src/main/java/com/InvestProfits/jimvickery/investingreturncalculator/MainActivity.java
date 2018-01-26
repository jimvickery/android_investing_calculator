package com.InvestProfits.jimvickery.investingreturncalculator;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText purchasePrice;
    EditText soldPrice;
    TextView totalTextView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        purchasePrice = (EditText) findViewById((R.id.purchaseTxt));
        soldPrice = (EditText) findViewById(R.id.soldTxt);
        totalTextView = (TextView) findViewById(R.id.totalTextView);


        Button calcBtn = (Button) findViewById(R.id.calcBtn);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float purchase = Float.parseFloat(purchasePrice.getText().toString());
                float sold = Float.parseFloat(soldPrice.getText().toString());
                float dollarReturn = ((sold / purchase) - 1) * 100;
                dollarReturn = Math.round(dollarReturn * 100);
                dollarReturn = dollarReturn/100;
                totalTextView.setText(Float.toString(dollarReturn));
            }
        });



        Button resetBtn = (Button) findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText purchasePrice =(EditText) findViewById(R.id.purchaseTxt);
                purchasePrice.setText("");

                EditText soldPrice =(EditText) findViewById(R.id.soldTxt);
                soldPrice.setText("");

                TextView totalTextView =(TextView) findViewById(R.id.totalTextView);
                totalTextView.setText("");

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
