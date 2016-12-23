package cn.edu.imnu.ciec.rtest3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final Intent intent=getIntent();
        String data= intent.getStringExtra("intent_data");
        //放String
        TextView textView= (TextView) findViewById(R.id.TextView);
        textView.setText(data);


        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("return_data","我是回来的冉宏民");
                setResult(RESULT_OK,intent);
                finish();//结束当前activity
            }
        });

        //隐式使用Intent
        Button button5= (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent tmp=new Intent("cn.edu.imnu.ciec.rtest3.ACTION_START");//去manifest
                tmp.addCategory("cn.edu.imnu.ciec.rtest3.MY_CATEGORY");
                //<category android:name="android.intent.category.DEFAULT"/>
                //是一种默认的 category
                //在调用startActivity（） 方法的时候 自动将这个category 添加到intent 中
                startActivity(tmp);
                //startActivityForResult(tmp,1); 和startActivity是相同的
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent();
        intent.putExtra("return_data","这是按返回键的data");
        setResult(RESULT_OK,intent);
        finish();


    }
}
