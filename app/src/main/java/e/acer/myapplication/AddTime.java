package e.acer.myapplication;

import android.database.sqlite.SQLiteOpenHelper;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddTime extends AppCompatActivity {
    Button them,sua,xoa,quaylai;
    EditText ednote,edtime,eddate;
    Time time= new Time(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        them=(Button)findViewById(R.id.btnthem);
        sua=(Button)findViewById(R.id.btnsua);
        xoa=(Button)findViewById(R.id.btnxoa);

        quaylai=(Button)findViewById(R.id.btnquaylai);
        ednote =(EditText)findViewById(R.id.ednote);
        edtime=(EditText)findViewById(R.id.edtime);
        eddate=(EditText)findViewById(R.id.eddate);

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // lay thong tin de chuyen qua coso dulieu
                time.taotime(ednote.getText().toString(),edtime.getText().toString(),eddate.getText().toString());
                finish();
            }
        });
        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time.suatime(ednote.getText().toString(),edtime.getText().toString(),eddate.getText().toString());
                finish();
            }
        });
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time.xoatime(eddate.getText().toString());

                finish();
            }
        });
        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}