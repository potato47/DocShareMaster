package com.next.docsharetest.message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.next.docsharetest.R;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28 0028.
 */

public class MsgAdapter extends ArrayAdapter<Message> {

    private int resourceId;

    public MsgAdapter(Context context, int textViewResourceId, List<Message> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView msgTip = (TextView) view.findViewById(R.id.tv_tip);
        TextView msgTime = (TextView) view.findViewById(R.id.tv_time);
        msgTip.setText(message.getTip());
        msgTime.setText(message.getTime());
        return view;
    }
}
