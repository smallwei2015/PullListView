package txvpn.txjsq.com.pulllistview;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by anpy on 2016/3/17.
 */
public class PullListAdapter extends BaseAdapter {

    List<UserData> datas;
    Context context;
    int selectItem=-1,sign=-1;

    public int getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }

    public PullListAdapter(List<UserData> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (datas == null) {
            return 0;
        }
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView= LayoutInflater.from(context).inflate(R.layout.pulllist_item,parent,false);
            convertView.setTag(new ViewHolder(convertView));
        }

        RadioGroup info = (RadioGroup)convertView.findViewById(R.id.footList);
        if(position == selectItem){//被选中的元素
            if(sign == selectItem){//再次选中的时候会隐藏，并初始化标记位置
                info.setVisibility(View.GONE);
                //没有被选中设置透明色
                convertView.setBackgroundColor(Color.parseColor("#00000000"));
                sign = -1;
            }else{//选中的时候会展示，并标记此位置
                info.setVisibility(View.VISIBLE);
                //被选中设置背景颜色
                convertView.setBackgroundColor(Color.parseColor("#B0E2FF"));
                sign = selectItem;
            }
        }else {//未被选中的元素
            info.setVisibility(View.GONE);
            convertView.setBackgroundColor(Color.parseColor("#00000000"));
        }

        ViewHolder tag = (ViewHolder) convertView.getTag();
        tag.name.setText(datas.get(position).getName());
        tag.age.setText(datas.get(position).getAge()+"");
        //消除复用问题
        //tag.group.setVisibility(View.GONE);
        return convertView;
    }


    class ViewHolder{
        TextView name,age;
        RadioGroup group;
        public ViewHolder(View view){
            name= (TextView) view.findViewById(R.id.name);
            age= (TextView) view.findViewById(R.id.age);
            group= (RadioGroup) view.findViewById(R.id.footList);
        }
    }
}
