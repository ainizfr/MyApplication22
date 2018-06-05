package com.example.zfr.myapplication2;

import android.app.MediaRouteActionProvider;
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

public class MainActivity extends AppCompatActivity {

    ListView lv;
    EditText et;
    Button bt;
    List<Map<String,Object>> listitem
            = new ArrayList<Map<String,Object>>();
    SimpleAdapter simpleAdapter;
    String input_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv =(ListView)findViewById(R.id.lv);
        et =(EditText)findViewById(R.id.et);
        bt =(Button)findViewById(R.id.bt);
        //tv =(TextView)findViewById(R.id.item_tv);
        //input_text=et.getText().toString();
        simpleAdapter=new SimpleAdapter(
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
        lv.setAdapter(simpleAdapter);
        bt.setOnClickListener(new View.OnClickListener() {
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
                input_text=et.getText().toString();
                boolean y=isMobile0(input_text);
                if(y){

                    Map<String,Object > item = new HashMap<>();
                    //给该条目对象赋值。包括键和值两部分
                    //"input_text"为键，input_text为值
                    item.put("input_text",input_text);
                    //将该条目对象放入list对象
                    listitem.add(item);
                    //当list对象重的内容发生变化后，通知适配器，刷新显示的内容
                    simpleAdapter.notifyDataSetChanged();
                }



            }
        });

    }







}
