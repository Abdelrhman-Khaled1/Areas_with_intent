package com.example.areaswithintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class triangle extends AppCompatActivity {

    TextView tv_height , tv_base;
    Button btn_calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        tv_height = findViewById(R.id.triangle_tv_height);
        tv_base = findViewById(R.id.triangle_tv_base);
        btn_calculate = findViewById(R.id.triangle_btn_calculate);


        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int base = Integer.parseInt(tv_base.getText().toString());
                int height = Integer.parseInt(tv_height.getText().toString());

                Intent intent = new Intent(); //it's only used to return area to the base activity

                if(base>0 && height >0){
                    double area = 0.5 * base * height;
                    intent.putExtra("triangle_area",area);
                    setResult(1,intent);
                }else{
                    intent.putExtra("triangle_base",base);
                    intent.putExtra("triangle_height",height);
                    setResult(2,intent);
                }
                finish();

            }
        });
    }
}