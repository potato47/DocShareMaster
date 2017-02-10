package com.next.docsharetest;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.next.docsharetest.message.MessageFragment;
import com.next.docsharetest.mine.MineFragment;
import com.next.docsharetest.share.ShareFragment;
import com.next.docsharetest.store.StoreFragment;

public class MainActivity extends Activity implements View.OnClickListener {

    /**
     * 网盘fragment
     */
    private Fragment storeFragment;

    /**
     * 分享fragment
     */
    private Fragment shareFragment;

    /**
     * 通知fragment
     */
    private Fragment messageFragment;

    /**
     * 我的fragment
     */
    private Fragment mineFragment;


    /**
     * 网盘界面布局
     */
    private View storeLayout;

    /**
     * 分享界面布局
     */
    private View shareLayout;

    /**
     * 消息界面布局
     */
    private View messageLayout;

    /**
     * 我的界面布局
     */
    private View mineLayout;

    /**
     * 在Tab布局上显示网盘图标的控件
     */
    private ImageView storeImage;

    /**
     * 在Tab布局上显示分享图标的控件
     */
    private ImageView shareImage;

    /**
     * 在Tab布局上显示消息图标的控件
     */
    private ImageView messageImage;

    /**
     * 在Tab布局上显示我的图标的控件
     */
    private ImageView mineImage;

    /**
     * 在Tab布局上显示网盘标题的控件
     */
    private TextView storeText;

    /**
     * 在Tab布局上显示分享标题的控件
     */
    private TextView shareText;

    /**
     * 在Tab布局上显示消息标题的控件
     */
    private TextView messageText;

    /**
     * 在Tab布局上显示我的标题的控件
     */
    private TextView mineText;

    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        // 初始化布局元素
        initViews();
        fragmentManager = getFragmentManager();
        // 第一次启动时选中第0个tab
        setTabSelection(0);
    }

    private void initViews() {
        storeLayout = findViewById(R.id.store_layout);
        shareLayout = findViewById(R.id.share_layout);
        messageLayout = findViewById(R.id.message_layout);
        mineLayout = findViewById(R.id.mine_layout);
        storeImage = (ImageView) findViewById(R.id.store_image);
        shareImage = (ImageView) findViewById(R.id.share_image);
        messageImage = (ImageView) findViewById(R.id.message_image);
        mineImage = (ImageView) findViewById(R.id.mine_image);
        storeText = (TextView) findViewById(R.id.store_text);
        shareText = (TextView) findViewById(R.id.share_text);
        messageText = (TextView) findViewById(R.id.message_text);
        mineText = (TextView) findViewById(R.id.mine_text);
        storeLayout.setOnClickListener(this);
        shareLayout.setOnClickListener(this);
        messageLayout.setOnClickListener(this);
        mineLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.store_layout:
                // 当点击了消息tab时，选中第1个tab
                setTabSelection(0);
                break;
            case R.id.share_layout:
                // 当点击了联系人tab时，选中第2个tab
                setTabSelection(1);
                break;
            case R.id.message_layout:
                // 当点击了动态tab时，选中第3个tab
                setTabSelection(2);
                break;
            case R.id.mine_layout:
                // 当点击了设置tab时，选中第4个tab
                setTabSelection(3);
                break;
            default:
                break;
        }
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index
     *            每个tab页对应的下标。0表示网盘，1表示分享，2表示消息，3表示我的。
     */
    private void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                // 当点击了网盘tab时，改变控件的图片和文字颜色
                storeImage.setImageResource(R.drawable.tab_filelist_checked);
                storeText.setTextColor(Color.parseColor("#6495ED"));
                if (storeFragment == null) {
                    // 如果StroeFragment为空，则创建一个并添加到界面上
                    storeFragment = new StoreFragment();
                    transaction.add(R.id.layout_content, storeFragment);
                } else {
                    // 如果StoreFragment不为空，则直接将它显示出来
                    transaction.show(storeFragment);
                }
                break;
            case 1:
                // 当点击了分享tab时，改变控件的图片和文字颜色
                shareImage.setImageResource(R.drawable.tab_share_checked);
                shareText.setTextColor(Color.parseColor("#6495ED"));
                if (shareFragment == null) {
                    // 如果ShareFragment为空，则创建一个并添加到界面上
                    shareFragment = new ShareFragment();
                    transaction.add(R.id.layout_content, shareFragment);
                } else {
                    // 如果ShareFragment不为空，则直接将它显示出来
                    transaction.show(shareFragment);
                }
                break;
            case 2:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                messageImage.setImageResource(R.drawable.tab_discovery_checked);
                messageText.setTextColor(Color.parseColor("#6495ED"));
                if (messageFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    messageFragment = new MessageFragment();
                    transaction.add(R.id.layout_content, messageFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(messageFragment);
                }
                break;
            case 3:
            default:
                // 当点击了我的tab时，改变控件的图片和文字颜色
                mineImage.setImageResource(R.drawable.tab_about_me_checked);
                mineText.setTextColor(Color.parseColor("#6495ED"));
                if (mineFragment == null) {
                    // 如果MineFragment为空，则创建一个并添加到界面上
                    mineFragment = new MineFragment();
                    transaction.add(R.id.layout_content, mineFragment);
                } else {
                    // 如果MineFragment不为空，则直接将它显示出来
                    transaction.show(mineFragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        storeImage.setImageResource(R.drawable.tab_filelist_normal);
        storeText.setTextColor(Color.parseColor("#82858b"));
        shareImage.setImageResource(R.drawable.tab_share_normal);
        shareText.setTextColor(Color.parseColor("#82858b"));
        messageImage.setImageResource(R.drawable.tab_discovery_normal);
        messageText.setTextColor(Color.parseColor("#82858b"));
        mineImage.setImageResource(R.drawable.tab_about_me_normal);
        mineText.setTextColor(Color.parseColor("#82858b"));
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *            用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (storeFragment != null) {
            transaction.hide(storeFragment);
        }
        if (shareFragment != null) {
            transaction.hide(shareFragment);
        }
        if (messageFragment != null) {
            transaction.hide(messageFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }
}
