package com.example.zfr.myapplication2;

import android.app.MediaRouteActionProvider;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView lv;
    EditText et;
    EditText nt;
    Button bt;
    MyDatabaseHelper dbHelper;
    SQLiteDatabase db;//创建数据库对象

   // List<Map<String,Object>> listitem= new ArrayList<Map<String,Object>>();
    SimpleAdapter simpleAdapter;
    String input_text_name;
    String input_text_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv =(ListView)findViewById(R.id.lv);
        et =(EditText)findViewById(R.id.et);
        nt =(EditText)findViewById(R.id.nt);
        bt =(Button)findViewById(R.id.bt);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //参数传入的是具备OnClick方法类的对象
        //this表示MainActivity类的一个对象
        //MainActivity由于实现了View.OnClickListener
        //因此包含Onclick方法
        //也就满足了参数的要求
        bt.setOnClickListener(this);
        //传入将要创建的数据库的名称和版本号，会自动调用DBHelper内的onCreate方法
        //从而创建表单
        //创建   对象，指定数据库版本为1，此处使用相对路径即可
        //数据库文件会自动保存在程序的书库文件夹的databases目录下
        dbHelper =new MyDatabaseHelper( this,"myDict.db3",1);
        //获取操纵数据库的句柄对象，用来操控数据库，进行增删改查等操作
        //只能读取，不能写入
        db=dbHelper.getWritableDatabase();

        //tv =(TextView)findViewById(R.id.item_tv);
        //input_text=et.getText().toString();
       /* simpleAdapter=new SimpleAdapter(
                getApplicationContext(),
                //要显示内容的条目
                listitem,
                //要显示内容的布局文件
                R.layout.text_item,
                //要显示的内容
                new  String[]{"input_text"},
                //要显示内容的控件，该控件在R.layout.text_item中
                //的id的item_tv的textView中去
                new int[]{R.id.item_tv});
        //将listView控件与适配器绑定
        lv.setAdapter(simpleAdapter);*/
        /* bt.setOnClickListener(new View.OnClickListener() {
            //判断电话
            public  boolean isMobile0(String str){
                if(str == null || "".equals(str)){
                    return false;
                }

                return str.matches("^1[0-9]{10}$");

            }

           @Override
            public void onClick(View arg0) {
                //创建一个条目对象，为一个map对象
                input_text_num=et.getText().toString();
                input_text_name=nt.getText().toString();
                boolean y=isMobile0(input_text_num);
                if(y){

                    Map<String,Object> item_num = new HashMap<>();
                    Map<String,Object> item_name = new HashMap<>();
                    //给该条目对象赋值。包括键和值两部分
                    //"input_text"为键，input_text为值
                    item_num.put("input_text",input_text_num);
                    listitem.add(item_num);
                    item_name.put("input_text",input_text_name);
                    //将该条目对象放入list对象
                    listitem.add(item_name);

                    //当list对象重的内容发生变化后，通知适配器，刷新显示的内容
                    simpleAdapter.notifyDataSetChanged();
                }
            }
        });*/


    }


    @Override
    public void onClick(View v) {

    }
}
