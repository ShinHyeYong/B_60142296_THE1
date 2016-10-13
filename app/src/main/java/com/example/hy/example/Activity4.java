package com.example.hy.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {

    private int plusNum;
    private int result;
    private Button minBtn4;
    private Button plusBtn4;
    private Button back4;
    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        minBtn4 = (Button) findViewById(R.id.minBtn4);
        plusBtn4 = (Button) findViewById(R.id.plusBtn4);
        back4 = (Button) findViewById(R.id.back4);

        Intent intent = getIntent();

        // 이건 필요없어보이는데
        result = intent.getExtras().getInt("insertNum");

//        result = plusNum + 1;

        textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setText(String.valueOf(result));

        minBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 4에서 - 누르면 3으로
                Intent intent = new Intent(Activity4.this, Activity3.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                intent.putExtra("insertNum", result - 1);
                startActivity(intent);
            }
        });

        plusBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 4에서 + 누르면 2로
                Intent intent = new Intent(Activity4.this, Activity2.class);
                intent.putExtra("insertNum", result + 1);
                startActivity(intent);
            }
        });

        back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity4.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
