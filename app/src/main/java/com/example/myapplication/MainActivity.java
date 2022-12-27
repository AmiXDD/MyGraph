package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.jjoe64.graphview.GraphView;

import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    GraphView graph;
    TextInputEditText hint1;
    TextInputEditText hint2;
    Button button;
    String s1;
    String s2;

    String a1;
    String b1;
    String c1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        TextInputEditText hint1 = findViewById(R.id.hint1);

        TextInputEditText hintA = findViewById(R.id.hintA);
        TextInputEditText hintB = findViewById(R.id.hintB);
        TextInputEditText hintC = findViewById(R.id.hintC);

        GraphView graph = findViewById(R.id.graph);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String s1 = hint1.getText().toString();

                String a1 = hintA.getText().toString();
                String b1 = hintB.getText().toString();
                String c1 = hintC.getText().toString();

               // int num1 = Integer.parseInt(s1);

                int numA = Integer.parseInt(a1);
                int numB = Integer.parseInt(b1);
                int numC = Integer.parseInt(c1);

                int a, b, c;
                int x, y;

                x = 0;

                a = numA;
                b = numB;
                c = numC;

                try {


                    LineGraphSeries<DataPoint> series = new LineGraphSeries<>();

                    for(int i =0; i<100; i++){

                        x = x +1;

                        y = a*(int) Math.pow(x,2)+b*x+c;

                        series.appendData(new DataPoint(x,y), true, 100);

                    }
                    graph.addSeries(series);





                }catch(IllegalArgumentException e){


                }










             /*  try {
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{





                            new DataPoint(0, 0),
                           new DataPoint(Double.valueOf(num1), num1*num1)


                    });
                    graph.addSeries(series);


                }catch(IllegalArgumentException e) {

                } */


               graph.getViewport().setXAxisBoundsManual(true);
               graph.getViewport().setMinX(-100.0);
               graph.getViewport().setMaxX(100.0);


               graph.getViewport().setYAxisBoundsManual(true);
               graph.getViewport().setMinY(-100.0);
               graph.getViewport().setMaxY(100.0);


               graph.getViewport().setScrollable(true);
               graph.getViewport().setScalable(true);






            }
        });

    }
}