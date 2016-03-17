package txvpn.txjsq.com.pulllistview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class ToobarActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toobar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.GRAY);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        toolbar.setSubtitle("ToolBar");
        toolbar.setOnMenuItemClickListener(this);
        toolbar.setTitleTextColor(Color.BLUE);
        toolbar.setSubtitleTextColor(Color.DKGRAY);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this,item.getItemId()+"id",Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.action_settings:
                break;
        }

        return false;
    }

}
