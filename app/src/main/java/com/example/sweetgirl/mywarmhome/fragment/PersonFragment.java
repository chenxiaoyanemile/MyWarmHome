package com.example.sweetgirl.mywarmhome.fragment;

import android.graphics.Color;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sweetgirl.mywarmhome.R;
import com.example.sweetgirl.mywarmhome.ui.PersonRecyclerViewAdapter;
import com.example.sweetgirl.mywarmhome.ui.SpaceItemDecoration;
import com.example.sweetgirl.mywarmhome.util.LogUtil;

import java.util.ArrayList;

/**
 *  2017/1/18.
 */
public class PersonFragment extends Fragment {

    private static final String TAG = LogUtil.makeLogTag(PersonFragment.class);

    private Button btn_my_share;
    private Button btn_my_attention;
    private Button btn_he_attention;
    private Button btn_my_activity;

    private SwipeRefreshLayout layout_swipe_refresh;
    private RecyclerView my_recyclerView;

    private PersonRecyclerViewAdapter personRecyclerViewAdapter;

    private ArrayList<String> datas;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_person, null);

        initData();
        initView(view);

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        personRecyclerViewAdapter=new PersonRecyclerViewAdapter(getActivity(),datas);
        my_recyclerView.setLayoutManager(mLinearLayoutManager);
        my_recyclerView.addItemDecoration(new SpaceItemDecoration(12,8,12,30));
        my_recyclerView.setAdapter(personRecyclerViewAdapter);

        return view;
    }

    protected void initView(View view){

        btn_my_share=(Button)view.findViewById(R.id.btn_my_share);
        btn_my_attention=(Button)view.findViewById(R.id.btn_my_attention);
        btn_he_attention=(Button)view.findViewById(R.id.btn_he_attention);
        btn_my_activity=(Button)view.findViewById(R.id.btn_my_activity);

        layout_swipe_refresh=(SwipeRefreshLayout)view.findViewById(R.id.layout_swipe_refresh);
        my_recyclerView=(RecyclerView)view.findViewById(R.id.my_recyclerView);

        btn_my_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_my_share.setTextColor(Color.rgb(135, 206, 235));
                btn_my_attention.setTextColor(Color.rgb(211, 211, 211));
                btn_he_attention.setTextColor(Color.rgb(211, 211, 211));
                btn_my_activity.setTextColor(Color.rgb(211, 211, 211));

            }
        });
        btn_my_attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_my_attention.setTextColor(Color.rgb(135, 206, 235));
                btn_my_share.setTextColor(Color.rgb(211, 211, 211));
                btn_he_attention.setTextColor(Color.rgb(211, 211, 211));
                btn_my_activity.setTextColor(Color.rgb(211, 211, 211));

            }
        });
        btn_he_attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_he_attention.setTextColor(Color.rgb(135, 206, 235));
                btn_my_attention.setTextColor(Color.rgb(211, 211, 211));
                btn_my_share.setTextColor(Color.rgb(211, 211, 211));
                btn_my_activity.setTextColor(Color.rgb(211, 211, 211));

            }
        });
        btn_my_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_my_activity.setTextColor(Color.rgb(135, 206, 235));
                btn_my_attention.setTextColor(Color.rgb(211, 211, 211));
                btn_he_attention.setTextColor(Color.rgb(211, 211, 211));
                btn_my_share.setTextColor(Color.rgb(211, 211, 211));

            }
        });

    }

    protected  void initData(){

        datas = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            datas.add("2017-03-20");
        }

    }

}
