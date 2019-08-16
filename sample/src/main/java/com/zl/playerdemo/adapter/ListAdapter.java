package  com.zl.playerdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zl.playerdemo.R;

import java.util.List;

/**
 * Created by Rukey7 on 2016/11/27.
 */

public class ListAdapter extends BaseListAdapter<String> {

    public ListAdapter(Context context) {
        super(context);
    }

    public ListAdapter(Context context, List<String> datas) {
        super(context, datas);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.adapter_list, viewGroup, false);
        }
        TextView tvContent = (TextView) view.findViewById(R.id.tv_content);
        tvContent.setText(mDatas.get(i));
        return view;
    }
}
