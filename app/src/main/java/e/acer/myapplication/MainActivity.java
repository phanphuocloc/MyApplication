package e.acer.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.database.Cursor;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button add, reload;
    TextView result;
    Time time = new Time(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reload = (Button) findViewById(R.id.btnload);
        add = (Button) findViewById(R.id.btnadd);
        result = (TextView) findViewById(R.id.tvresult);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddTime.class);
                startActivity(intent);
            }
        });
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor con_tro = time.getAllTime();
                String chuoi = "";
                if (con_tro.getCount() >= 1) {
                    con_tro.moveToFirst();
                    do {
                        chuoi += con_tro.getString(0) + "\t\t\t";
                        chuoi += con_tro.getString(1) + "\t\t\t";
                        chuoi += con_tro.getString(2) + "\n";
                    } while (con_tro.moveToNext());
                    result.setText(chuoi);
                }
            }
        });
    }
}