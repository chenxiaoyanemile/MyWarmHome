package com.example.sweetgirl.mywarmhome.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sweetgirl.mywarmhome.R;
import com.example.sweetgirl.mywarmhome.ui.PageRecycerViewAdapter;
import com.example.sweetgirl.mywarmhome.ui.SpaceItemDecoration;
import com.example.sweetgirl.mywarmhome.util.LogUtil;

import java.util.ArrayList;


/**
 * 2017/1/18.
 */
public class FirstPageFragment extends Fragment {

    private static final String TAG = LogUtil.makeLogTag(FirstPageFragment.class);

    private Button btn_page_travel;
    private Button btn_page_exercise;
    private Button btn_page_volunteer;

    private SwipeRefreshLayout layout_swipe_refresh;
    private RecyclerView my_recyclerView;

    private PageRecycerViewAdapter pageRecycerViewAdapter;

    private ArrayList<String> datas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_firstpage, null);

        initView(view);
        initData();

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        pageRecycerViewAdapter=new PageRecycerViewAdapter(getActivity(),datas);
        my_recyclerView.setLayoutManager(mLinearLayoutManager);
        my_recyclerView.addItemDecoration(new SpaceItemDecoration(12,8,12,30));
        my_recyclerView.setAdapter(pageRecycerViewAdapter);

        return view;
    }

    private void initView(View v){

        btn_page_travel=(Button)v.findViewById(R.id.btn_page_travel);
        btn_page_exercise=(Button)v.findViewById(R.id.btn_page_exercise);
        btn_page_volunteer=(Button)v.findViewById(R.id.btn_page_volunteer);

        layout_swipe_refresh=(SwipeRefreshLayout)v.findViewById(R.id.layout_swipe_refresh);
        my_recyclerView=(RecyclerView)v.findViewById(R.id.my_recyclerView);



        btn_page_travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_page_travel.setTextColor(Color.rgb(135, 206, 235));
                btn_page_exercise.setTextColor(Color.rgb(211, 211, 211));
                btn_page_volunteer.setTextColor(Color.rgb(211, 211, 211));


            }
        });

        btn_page_exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_page_exercise.setTextColor(Color.rgb(135, 206, 235));
                btn_page_travel.setTextColor(Color.rgb(211, 211, 211));
                btn_page_volunteer.setTextColor(Color.rgb(211, 211, 211));
            }
        });

        btn_page_volunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_page_volunteer.setTextColor(Color.rgb(135, 206, 235));
                btn_page_travel.setTextColor(Color.rgb(211, 211, 211));
                btn_page_exercise.setTextColor(Color.rgb(211, 211, 211));

            }
        });

    }

    protected void initData()
    {
        datas = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            datas.add("2017-03-20");
        }
    }

}
