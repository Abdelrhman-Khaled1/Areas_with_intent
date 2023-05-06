package com.example.areaswithintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_triangle , btn_rectangle;
    TextView tv_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_rectangle = findViewById(R.id.main_btn_retangle);
        btn_triangle = findViewById(R.id.main_btn_triangle);
        tv_result = findViewById(R.id.main_tv_result);

        btn_triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),triangle.class);
                startActivityForResult(intent , 1);
            }
        });

        btn_rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),rectangle.class);
                startActivityForResult(intent , 2);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==1){//you come from Triangle
                String oldText = tv_result.getText().toString();
                if(resultCode==1){//Correct
                    double newArea = data.getDoubleExtra("triangle_area",0);
                    tv_result.setText(oldText+"\nTriangle "+newArea);
                }else if(resultCode==2){//wrong input
                    int height = data.getIntExtra("triangle_height",0);
                    int base = data.getIntExtra("triangle_base",0);
                    tv_result.setText(oldText+"\nTriangle Error H: "+height+" B: "+base);
                }

            }else if(requestCode==2){//Rectangle
                String oldText = tv_result.getText().toString();
                if(resultCode==1){//Correct
                    int newArea = data.getIntExtra("rectangle_area",0);//Take care from get***Extra
                    tv_result.setText(oldText+"\nRectangle "+newArea);
                }else if(resultCode==2){//wrong input
                    int height = data.getIntExtra("rectangle_height",0);
                    int width = data.getIntExtra("rectangle_width",0);
                    tv_result.setText(oldText+"\nRectangle Error H: "+height+" W: "+width);
                }


            }
    }
}