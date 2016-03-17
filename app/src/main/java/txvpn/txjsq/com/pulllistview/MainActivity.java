package txvpn.txjsq.com.pulllistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    List<UserData> datas;
    private ListView listView;
    private PullListAdapter adapter;
    private RadioGroup curGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datas=new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            datas.add(new UserData(i,"name"+i));
        }
        listView = (ListView) findViewById(R.id.list);
        adapter = new PullListAdapter(datas, this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        adapter.setSelectItem(position);
        adapter.notifyDataSetInvalidated();
        //adapter.notifyDataSetChanged();
        /*RadioGroup group = (RadioGroup) view.findViewById(R.id.footList);
        if (curGroup == null) {
            group.setVisibility(View.VISIBLE);
        }else {
            if (group==curGroup){
                //todo：当再次点击的时候让那个group消失
                group.setVisibility(View.GONE);
                adapter.notifyDataSetChanged();
            }else{
                curGroup.setVisibility(View.GONE);
                group.setVisibility(View.VISIBLE);
            }
        }
        curGroup=group;
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId) {
                    case R.id.radio1:
                        Toast.makeText(MainActivity.this, "radio1", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });*/
    }
}
