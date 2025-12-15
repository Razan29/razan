package com.example.game2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView t1,t2,t3,t4,t5,t6,t,s,tvname;
    private Button st,n,score,exit,submit;
    private int  count =0,x1,x2,x3,x4,x5,x6,count2=0;
    public static int countg=0,countA=0;
   private Handler  handler ;
   private Runnable runnable;
   private boolean isRunning = false;
   private String name,name1,age1;
   private AlertDialog dialog;
   private Dialog nameDialog;

   private void buildName (){
       nameDialog = new Dialog(this);
       nameDialog.setContentView(R.layout.my_dialog);
       EditText a=nameDialog.findViewById(R.id.ageid);
       EditText na=nameDialog.findViewById(R.id.nameid);
       Button ok=nameDialog.findViewById(R.id.bid);
         ok.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(!(a.getText().toString().isEmpty()&&na.getText().toString().isEmpty())){
                     name1=na.getText().toString();
                     age1=a.getText().toString();
                     tvname.setText(name1+"  "+age1);
                     nameDialog.dismiss();
                 }
             }
         });
         nameDialog.show();
   }

   private void intDialog(){
       AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
       alertDialog.setTitle("Exit");
       alertDialog.setMessage("are you sure?");
       alertDialog.setIcon(android.R.drawable.stat_sys_warning);
       alertDialog.setCancelable(true);

       alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {
              finish();
              System.exit(0);
               dialog.dismiss();
           }
       });
       alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {

               dialog.dismiss();
           }
       });
       alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {

               dialog.dismiss();
           }
       });
       dialog=alertDialog.create();
   }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score=findViewById(R.id.scoreid);
        t1=findViewById(R.id.textView1);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView3);
        t4=findViewById(R.id.textView4);
        t5=findViewById(R.id.textView5);
        t6=findViewById(R.id.textView6);
        t=findViewById(R.id.textView7);
        s=findViewById(R.id.textView8);
        st=findViewById(R.id.button);
        n=findViewById(R.id.button2);
        exit=findViewById(R.id.exit2);
        tvname = findViewById(R.id.nameid2);
        intDialog();
        buildName();





        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        handler = new Handler(Looper.getMainLooper());
        Intent scoreAc= new Intent(MainActivity.this,ScoreActivity.class);


        runnable = new Runnable() {
            @Override
            public void run() {
                int x = (int) (Math.random() * 39 + 1);
                t.setText(String.valueOf(x));


                handler.postDelayed(this, 1000);
            }
        };

        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x1=(int)(Math.random()*39+1);
                t1.setText(x1+"");
                x2=(int)(Math.random()*39+1);
                t2.setText(x2+"");
                x3=(int)(Math.random()*39+1);
                t3.setText(x3+"");
                x4=(int)(Math.random()*39+1);
                t4.setText(x4+"");
                x5=(int)(Math.random()*39+1);
                t5.setText(x5+"");
                x6=(int)(Math.random()*39+1);
                t6.setText(x6+"");
                count=0;
                count2=0;
                s.setText(count+"/6");
                t1.setBackgroundColor(Color.WHITE);
                t2.setBackgroundColor(Color.WHITE);
                t3.setBackgroundColor(Color.WHITE);
                t4.setBackgroundColor(Color.WHITE);
                t5.setBackgroundColor(Color.WHITE);
                t6.setBackgroundColor(Color.WHITE);
                countg++;


            }
        });

        st.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if(count2<6) {

                    if (!isRunning) {
                        // Start
                        st.setText("Stop");
                        isRunning = true;



                        handler.post(runnable);

                    } else {
                        // Stop
                        st.setText("Start");
                        isRunning = false;
                        handler.removeCallbacks(runnable);
                    }
                    if (st.getText().toString().equals("Start")) {
                        count2++;
                    }

                    if (t1.getText().equals(t.getText())) {
                        t1.setBackgroundColor(Color.RED);
                        count++;
                        countA++;
                        t1.setText(x1 + " ");
                        s.setText(count + "of 6");
                    }
                    if (t2.getText().equals(t.getText())) {
                        t2.setBackgroundColor(Color.RED);
                        count++;
                        countA++;
                        t2.setText(x2 + " ");
                        s.setText(count + "of 6");
                    }
                    if (t3.getText().equals(t.getText())) {
                        t3.setBackgroundColor(Color.RED);
                        count++;
                        countA++;
                        t3.setText(x3 + " ");
                        s.setText(count + "of 6");
                    }
                    if (t4.getText().equals(t.getText())) {
                        t4.setBackgroundColor(Color.RED);
                        count++;
                        countA++;
                        t4.setText(x4 + " ");
                        s.setText(count + "of 6");
                    }
                    if (t5.getText().equals(t.getText())) {
                        t5.setBackgroundColor(Color.RED);
                        count++;
                        countA++;
                        t5.setText(x5 + " ");
                        s.setText(count + "of 6");
                    }
                    if (t6.getText().equals(t.getText())) {
                        t6.setBackgroundColor(Color.RED);
                        count++;
                        countA++;
                        t6.setText(x6 + " ");
                        s.setText(count + "of 6");
                    }
                }


            }
        });
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreAc.putExtra("SCORE",countA);
                scoreAc.putExtra("Name", name);
                startActivity(scoreAc);
                finish();
            }
        });





        }

    }

