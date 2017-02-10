package com.next.docsharetest.message;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.next.docsharetest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/27 0027.
 */

public class MessageFragment extends Fragment {

    private List<Message> msgList = new ArrayList<Message>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        initMessages();
        MsgAdapter adapter = new MsgAdapter(this.getActivity(), R.layout.msg_item, msgList);
        ListView listView = (ListView) view.findViewById(R.id.msg_list_view);
        listView.setAdapter(adapter);
        return view;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private void initMessages() {
        Message message1 = new Message("校长", "晚上来我办公室", "2016.1.1");
        msgList.add(message1);
        Message message2 = new Message("刘老师", "把获奖证书传过来,把获奖证书传过来把获奖证书传过奖证书传过来奖证书传过来把获奖证书传过来", "2016.3.1");
        msgList.add(message2);
        Message message3 = new Message("赵老师", "发一张一寸照片", "2016.12.12");
        msgList.add(message3);
        Message message4 = new Message("孙老师", "身份证正反面", "2016.8.8");
        msgList.add(message4);
        Message message5 = new Message("张老师", "工作经历", "2016.4.5");
        msgList.add(message5);
        Message message6 = new Message("李老师", "晚上来我办公室晚上来我办公室晚上来我办公室晚上来我办公室晚上来我办公室晚上来我办公室晚上来我办公室晚上来我办公室晚上来我办公室晚上来我办公室晚上来我办公室晚上来我办公室晚上来我办公室晚上来我办公室晚上来我办公室", "2016.9.9");
        msgList.add(message6);
        Message message7 = new Message("小明", "晚上来我办公室", "2016.5.8");
        msgList.add(message7);
        Message message8 = new Message("大明", "晚上来我办公室", "2016.8.5");
        msgList.add(message8);

    }

}
