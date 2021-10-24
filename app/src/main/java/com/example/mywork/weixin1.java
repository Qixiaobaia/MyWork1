package com.example.mywork;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class weixin1 extends Fragment {
    private RecyclerView recyclerView;
    private List<Map<String,Object>> items;
    private Context context;
    private myclass myclass;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView textview;

    public weixin1(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_weixin1, container, false);

        context=this.getActivity();
        recyclerView=view.findViewById(R.id.recycleView1);
        swipeRefreshLayout=view.findViewById(R.id.refresh_layout);
        textview=view.findViewById(R.id.textvieww);

        handleDownPullUpdate();
        String[] products={"文案：玩笑仅限于即兴，留下误会就成了谎言。","文案：希望你永久快乐，任何选择过后都洒脱。","文案：飞扬的少年最动人心，奔跑的时候像是穿过了光阴。","文案：满怀希望就会所向披靡。"};
        String[] prices={"————动画《冰菓》","————小说《刺青》","————小说《某某》","————小说《撒野》"};
        String[] configurations={"转发1023    喜欢1586    点赞8999    评论2658","转发1023    喜欢1586    点赞8999    评论2658","转发1023    喜欢1586    点赞8999    评论2658","转发1023    喜欢1586    点赞8999    评论2658"};

        int[] png={R.drawable.feng1,R.drawable.feng2,R.drawable.feng3,R.drawable.feng4};
        List<Map<String,Object>> items= new ArrayList<Map<String,Object>>();
        for(int i=0;i<products.length;i++) {
            Map<String,Object> item=new HashMap<String,Object>();
            item.put("PNG", png[i]);
            item.put("PRODUCT", products[i]);
            item.put("PRICE", prices[i]);
            item.put("CONFIGURATION", configurations[i]);
            items.add(item);
        }

        myclass=new myclass(items,context);
        LinearLayoutManager layoutManager=new LinearLayoutManager(context);

        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myclass);
        return view;
    }

    private void handleDownPullUpdate() {
        swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.setColorSchemeResources(R.color.design_default_color_primary,R.color.design_default_color_primary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                textview.setText("正在刷新...");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textview.setText("刷新成功！");
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },3000);
            }
        });
    }
}

