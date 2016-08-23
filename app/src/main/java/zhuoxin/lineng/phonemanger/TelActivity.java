package zhuoxin.lineng.phonemanger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class TelActivity extends AppCompatActivity {
    //    TextView textView;
//    Button button;
    private ListView listView;
    private ArrayList<Telclass> list;
    private MainListViewAdapter adapter;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            listView = (ListView) findViewById(R.id.lv_main);
            try {
                Assets.saveFile(TelActivity.this, "commonnum.db", constant.DATA_PATH);
                list = SQLiteUtil.getclass();
                adapter = new MainListViewAdapter(TelActivity.this, list);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        listView.setAdapter(adapter);
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        listView = (ListView) findViewById(R.id.lv_main);
        new Thread(runnable).start();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TelActivity.this, activity_tel.class);
                String name = list.get(position).getName();
                int idx = list.get(position).getIdx();
                intent.putExtra("name", name);
                intent.putExtra("idx", idx);
                TelActivity.this.startActivity(intent);
            }
        });


//        textView= (TextView) findViewById(R.id.textview);
//        button= (Button) findViewById(R.id.button);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.exit(0);
//            }
//        });
    }
}
