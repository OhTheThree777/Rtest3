package cn.edu.imnu.ciec.rtest3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private static final String TAG ="FirstActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);




        //强制类型转换
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //意图  intent 是android 程序中各组件之间进行交互的一种重要方式
                //他可以指明当前组件想要执行的动作 ，还可以在不同组件之间传递数据
                //intent 一般可被用于启动活动 启动服务 发送广播等场景
                //intent 可以飞为两种 显式 和 隐式
                //
                String data= "我是过来的冉宏民";

                Intent intent =new Intent(FirstActivity.this,SecondActivity.class);
                //类名.class  使用它 可以返回于该类对应的Class对象
                //Java 的Class 类 是Java反射机制的一个基础，通过Class类可以获取一个类的相关信息。
                //java.lang.Class是一个比较特殊的类，他用来封装被装入到JVM中的类（类和接口）的信息，
                //当一个类或接口被装入JVM时会产生与之关联的java.lang.Class对象，通过该对象可以访问被装入类的详细信息。
                intent.putExtra("intent_data",data);
                //startActivity(intent);

                startActivityForResult(intent,1);

            }
        });


        Button button2= (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String data= "我是第三个冉宏民";
                Intent intent=new Intent(FirstActivity.this,ThirdActivity.class);
                startActivityForResult(intent,2);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {//requset 是上面的那个1  resultcode 是那边的result_ok

        Log.d(TAG, "onActivityResult: "+requestCode);//TAG 需要按alt+enter去添加13行那样的东西
        switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK){
                    Toast.makeText(this,data.getStringExtra("return_data"),Toast.LENGTH_LONG).show();
                }
                break;
            case 2:
                if (resultCode==RESULT_OK){
                    Toast.makeText(this,data.getStringExtra("return_data"),Toast.LENGTH_LONG).show();
                }
                break;
        }


    }

}
