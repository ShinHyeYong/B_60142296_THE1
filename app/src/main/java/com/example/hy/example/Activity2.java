package com.example.hy.example;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private int minNum;
    private int result;
    private Button minBtn2;
    private Button plusBtn2;
    private Button back2;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        minBtn2 = (Button) findViewById(R.id.minBtn2);
        plusBtn2 = (Button) findViewById(R.id.plusBtn2);
        back2 = (Button) findViewById(R.id.back2);

        Intent intent1 = getIntent();
        minNum = Integer.valueOf(intent1.getExtras().getString("insertNum"));
        Log.i("TAG-2", "" + minNum);

        result = minNum - 1; // 계산된 결과 값
        textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(String.valueOf(result));

        minBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 2에서 - 누르면 4로 이동한다.
                Intent intent4 = new Intent(Activity2.this, Activity4.class);
                intent4.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                intent4.putExtra("insertNum", result);
                startActivity(intent4);
            }
        });

        plusBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 2에서 + 누르면 3으로 이동한다.
                Intent intent3 = new Intent(Activity2.this, Activity3.class);
                intent3.putExtra("insertNum", result);
                startActivity(intent3);
            }
        });

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.hy_activityex1.intent2");
                intent.putExtra("insertNum", result);
                Log.i("리절트값뭐임", "뭐임이거 : " + result);
                //      setResult(Activity.RESULT_OK, intent);
                startActivityForResult(intent, 10);
            }
        });
            /*
        }
        else(intent1 == ){
            minNum = Integer.parseInt(intent1.getExtras().getString("insertNum"));

            result = minNum + 1; // 계산된 결과 값

            textView2 = (TextView) findViewById(R.id.textView2);
            textView2.setText(String.valueOf(result));
        }*/
    }
    /*
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        switch(requestCode){
        case 1:
            if(resultCode == RESULT_OK){

            }
        }
    }
    */
}
