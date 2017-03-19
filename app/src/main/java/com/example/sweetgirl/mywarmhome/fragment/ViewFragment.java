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
import com.example.sweetgirl.mywarmhome.ui.PageRecycerViewAdapter;
import com.example.sweetgirl.mywarmhome.ui.SpaceItemDecoration;
import com.example.sweetgirl.mywarmhome.ui.ViewRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * 2017/1/18.
 */
public class ViewFragment extends Fragment {

    private Button btn_view_travel;
    private Button btn_view_technology;
    private Button btn_view_invest;
    private Button btn_view_fitness;

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout layout_swipe_refresh;

    private ViewRecyclerViewAdapter viewRecyclerViewAdapter;
    private ArrayList<String> datas;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_view, null);

        initData();
        initView(view);

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        viewRecyclerViewAdapter=new ViewRecyclerViewAdapter(getActivity(),datas);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(12,8,12,30));
        mRecyclerView.setAdapter(viewRecyclerViewAdapter);


        return view;
    }

    public void initView(View view){

        btn_view_travel=(Button)view.findViewById(R.id.btn_view_travel);
        btn_view_technology=(Button)view.findViewById(R.id.btn_view_technology);
        btn_view_invest=(Button)view.findViewById(R.id.btn_view_invest);
        btn_view_fitness=(Button)view.findViewById(R.id.btn_view_fitness);

        layout_swipe_refresh=(SwipeRefreshLayout)view.findViewById(R.id.layout_swipe_refresh);
        mRecyclerView=(RecyclerView)view.findViewById(R.id.my_recyclerView);

        btn_view_travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_view_travel.setTextColor(Color.rgb(135, 206, 235));
                btn_view_technology.setTextColor(Color.rgb(211, 211, 211));
                btn_view_invest.setTextColor(Color.rgb(211, 211, 211));
                btn_view_fitness.setTextColor(Color.rgb(211, 211, 211));

            }
        });
        btn_view_technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_view_technology.setTextColor(Color.rgb(135, 206, 235));
                btn_view_travel.setTextColor(Color.rgb(211, 211, 211));
                btn_view_invest.setTextColor(Color.rgb(211, 211, 211));
                btn_view_fitness.setTextColor(Color.rgb(211, 211, 211));

            }
        });
        btn_view_invest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_view_invest.setTextColor(Color.rgb(135, 206, 235));
                btn_view_technology.setTextColor(Color.rgb(211, 211, 211));
                btn_view_travel.setTextColor(Color.rgb(211, 211, 211));
                btn_view_fitness.setTextColor(Color.rgb(211, 211, 211));

            }
        });
        btn_view_fitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_view_fitness.setTextColor(Color.rgb(135, 206, 235));
                btn_view_technology.setTextColor(Color.rgb(211, 211, 211));
                btn_view_invest.setTextColor(Color.rgb(211, 211, 211));
                btn_view_travel.setTextColor(Color.rgb(211, 211, 211));
            }
        });

    }
    protected  void initData(){

        datas = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            datas.add("2017-04-08");
        }

    }
}
