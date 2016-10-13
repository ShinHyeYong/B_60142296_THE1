package com.example.hy.example;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button minBtn1;
    private Button plusBtn1;
    private EditText insertNum;
    //  private int result;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertNum = (EditText) findViewById(R.id.insertNum);

        Intent intent = this.getIntent();
        if (intent != null) {
            if (intent.getExtras() == null) {
            } else {
                insertNum.setText(intent.getExtras().getString("insertNum"));
            }
        }

        Log.i("인설트넘", " : " + insertNum);

        minBtn1 = (Button) findViewById(R.id.minBtn1);
        plusBtn1 = (Button) findViewById(R.id.plusBtn1);

        minBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (insertNum.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, "Insert Number.", Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent1 = new Intent(MainActivity.this, Activity2.class);
                intent1.putExtra("insertNum", insertNum.getText().toString());
                startActivity(intent1);
//                startActivityForResult(intent1, 1); //2로 넘어가도 종료하지 않게 됨
            }
        });

        plusBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (insertNum.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, "Insert Number.", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent2 = new Intent(MainActivity.this, Activity4.class);
                intent2.putExtra("insertNum", insertNum.getText().toString());
                startActivity(intent2);
            }
        });

        textView = (TextView) findViewById(R.id.textView1);
        Log.i("값들어갔니", "insertNum : " + insertNum);
        //      textView.setText(Integer.valueOf("insertNum"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String s = intent.getStringExtra("insertNum");
            }
        }
    }
}
