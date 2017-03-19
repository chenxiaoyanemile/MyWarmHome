package com.example.sweetgirl.mywarmhome.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.sweetgirl.mywarmhome.R;
import com.example.sweetgirl.mywarmhome.fragment.FirstPageFragment;
import com.example.sweetgirl.mywarmhome.fragment.FriendFragment;
import com.example.sweetgirl.mywarmhome.fragment.PersonFragment;
import com.example.sweetgirl.mywarmhome.fragment.ShareFragment;
import com.example.sweetgirl.mywarmhome.fragment.ViewFragment;
import com.example.sweetgirl.mywarmhome.util.L;
import com.example.sweetgirl.mywarmhome.util.LogUtil;


/**
 *  2017/1/18.
 */
public class MainActivity extends FragmentActivity implements
        View.OnClickListener {

    private static final String TAG = LogUtil.makeLogTag(MainActivity.class);

    private FragmentManager manager;
    private FirstPageFragment firstPageFragment;
    private ViewFragment viewFragment;
    private PersonFragment personFragment;
    private ShareFragment shareFragment;
    private FriendFragment friendFragment;
    private RadioButton first,view1,share,person,friend;
    private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        first = (RadioButton)findViewById(R.id.main_fristpage);
        view1  = (RadioButton)findViewById(R.id.main_view);
        share = (RadioButton)findViewById(R.id.main_share);
        person = (RadioButton)findViewById(R.id.main_person);
        friend = (RadioButton)findViewById(R.id.main_friend);
        title = (TextView)findViewById(R.id.titlebar_text_title);
        FrameLayout realtabcontent = (FrameLayout)findViewById(R.id.realtabcontent);
        first.setOnClickListener(this);
        view1.setOnClickListener(this);
        share.setOnClickListener(this);
        person.setOnClickListener(this);
        friend.setOnClickListener(this);
        first.setChecked(true);
        title.setText("首页");
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        firstPageFragment = new FirstPageFragment();
        friendFragment = new FriendFragment();
        shareFragment = new ShareFragment();
        personFragment = new PersonFragment();
        viewFragment = new ViewFragment();
        transaction.replace(R.id.realtabcontent,firstPageFragment).commit();
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.main_fristpage:
                transaction.replace(R.id.realtabcontent, firstPageFragment);
                title.setText("首页");
                break;
            case R.id.main_view:
                transaction.replace(R.id.realtabcontent, viewFragment);
                title.setText("视野区");
                break;
            case R.id.main_share:
                transaction.replace(R.id.realtabcontent, shareFragment);
                title.setText("分享区");
                break;
            case R.id.main_person:
                transaction.replace(R.id.realtabcontent, personFragment);
                title.setText("个人主页");
                break;
            case R.id.main_friend:
                transaction.replace(R.id.realtabcontent, friendFragment);
                title.setText("好友");
                L.d(TAG,"好友");
                break;
        }
        transaction.commit();
    }
}
