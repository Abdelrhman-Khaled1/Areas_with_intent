package com.example.areaswithintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class rectangle extends AppCompatActivity {

    TextView tv_height , tv_width;
    Button btn_calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        tv_height = findViewById(R.id.rectangle_tv_height);
        tv_width = findViewById(R.id.rectangle_tv_width);
        btn_calculate = findViewById(R.id.rectangle_btn_calculate);

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int width = Integer.parseInt(tv_width.getText().toString());
                int height = Integer.parseInt(tv_height.getText().toString());
                Intent intent = new Intent(); //it's only used to return area to the base activity

                if(width>0 && height >0){
                    int area = width * height;
                    intent.putExtra("rectangle_area",area);
                    setResult(1,intent);//the activity return the area in the base activity and want the onActivityReuslt to handle it
                }else{
                    intent.putExtra("rectangle_height",height);
                    intent.putExtra("rectangle_width",width);
                    setResult(2,intent);
                }
                finish();

            }
        });

    }
}