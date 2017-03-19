package com.example.sweetgirl.mywarmhome.fragment;

import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sweetgirl.mywarmhome.R;
import com.example.sweetgirl.mywarmhome.ui.ShareRecyclerViewAdapter;
import com.example.sweetgirl.mywarmhome.ui.SpaceItemDecoration;
import com.example.sweetgirl.mywarmhome.util.LogUtil;

import java.util.ArrayList;

/**
 * 2017/1/18.
 */
public class ShareFragment extends Fragment {

    private static final String TAG = LogUtil.makeLogTag(ShareFragment.class);

    private SwipeRefreshLayout layout_swipe_refresh;
    private RecyclerView my_recyclerView;
    private ArrayList<String> datas;
    private ShareRecyclerViewAdapter shareRecyclerViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_share, null);

        initData();
        initView(view);

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        shareRecyclerViewAdapter=new ShareRecyclerViewAdapter(getActivity(),datas);
        my_recyclerView.setLayoutManager(mLinearLayoutManager);
        my_recyclerView.addItemDecoration(new SpaceItemDecoration(12,8,12,30));
        my_recyclerView.setAdapter(shareRecyclerViewAdapter);


        return view;
    }

    protected void initView(View view){

        layout_swipe_refresh=(SwipeRefreshLayout)view.findViewById(R.id.layout_swipe_refresh);
        my_recyclerView=(RecyclerView)view.findViewById(R.id.my_recyclerView);

    }

    protected void initData(){
        datas = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            datas.add("2017-03-20");
        }

    }


}
