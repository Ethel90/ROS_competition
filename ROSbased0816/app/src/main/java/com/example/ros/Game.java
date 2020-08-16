package com.example.ros;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Game extends Page {
    private int num = getrandom(1, 15);
    private int i = 0;
    int min = 1;
    int max = 15;
    private String St = new String("失敗");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        buildViews();
    }
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause()
    {
        super.onPause();
    }
    @Override
    public void onStop()
    {
        super.onStop();
    }
    @Override
    public void onRestart()
    {
        super.onRestart();
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
    }

    private  void buildViews() {
        final Button btGO;
        final TextView txtInput;
        final TextView txtRange;

        btGO = (Button) findViewById(R.id.btGO);
        txtInput = (TextView) findViewById(R.id.txtSub);
        txtRange = (TextView) findViewById(R.id.range);
        txtRange.setText("1~15");

        btGO.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                i++;

                String S = txtInput.getText().toString();
                int Input= Integer.parseInt(S);
                Run(Input);

                String stMin = ""+min;
                String stMax = ""+max;
                txtRange.setText(stMin +'~'+ stMax);
            }
        });
    }

    private void Run(int input){
        String st = new String();

        if(min<=input&&input<=max){
            if(i == 3){
                if(input == num){
                    st = "成功!!";
                    Toast.makeText(Game.this, st, Toast.LENGTH_SHORT).show();
                    SwitchPage(Success.class);
                    finish();
                }else {
                    Toast.makeText(Game.this, St, Toast.LENGTH_SHORT).show();
                    SwitchPage(Failed.class);
                    finish();
                }
            } else if (input > num) {
                max = input;
                st = "數字太大，請往小的猜";
                Toast.makeText(Game.this, st, Toast.LENGTH_LONG).show();
            } else if (input < num) {
                min = input;
                st = "數字太小，請往大的猜";
                Toast.makeText(Game.this, st, Toast.LENGTH_LONG).show();
            } else if (input == num){
                st = "成功!!";
                Toast.makeText(Game.this, st, Toast.LENGTH_SHORT).show();
                SwitchPage(Success.class);
                finish();
            }
        }else{
            st = "請輸入正確範圍！";
            Toast.makeText(Game.this, st, Toast.LENGTH_LONG).show();
            i--;
        }
    }

    private static int getrandom(int min, int max) {
        return (int)(Math.random()*(max-min+1)+min);
    }
}
