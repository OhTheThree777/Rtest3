package cn.edu.imnu.ciec.rtest3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        Button button6= (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent.ACTION_VIEW 对应的常量值 android.intent.action.VIEW
                Intent intent=new Intent(Intent.ACTION_DIAL);//ACTON_VIEW 浏览器 内置  DIAL 电话
                intent.setData(Uri.parse("tel:10086"));//将字符串制成uri对象
                startActivity(intent);
            }
        });


    }
}
