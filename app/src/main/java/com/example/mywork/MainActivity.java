package com.example.mywork;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Fragment weixin=new weixin();
    private Fragment weixin1=new com.example.mywork.weixin1();
    private Fragment weixin2=new weixin2();
    private Fragment weixin3=new weixin3();

    private FragmentManager fragmentManager;

    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;
    private LinearLayout linearLayout4;

    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whole);



        linearLayout1=findViewById(R.id.LinearLayout1);
        linearLayout2=findViewById(R.id.LinearLayout2);
        linearLayout3=findViewById(R.id.LinearLayout3);
        linearLayout4=findViewById(R.id.LinearLayout4);
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipe_refresh);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);


        swipeRefreshLayout.setColorSchemeResources(R.color.design_default_color_primary);
        initFragment();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
    }


    private void initFragment(){
        fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.id_content,weixin);
        transaction.add(R.id.id_content,weixin1);
        transaction.add(R.id.id_content,weixin2);
        transaction.add(R.id.id_content,weixin3);
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(weixin);
        transaction.hide(weixin1);
        transaction.hide(weixin2);
        transaction.hide(weixin3);
    }

    private void setbackgroundcolor(View v) {
        switch (v.getId()) {
            case R.id.LinearLayout1:
                linearLayout1.setBackgroundColor(Color.parseColor("#0DDDDB"));
                break;
            case R.id.LinearLayout2:
                linearLayout2.setBackgroundColor(Color.parseColor("#0DDDDB"));
                break;
            case R.id.LinearLayout3:
                linearLayout3.setBackgroundColor(Color.parseColor("#0DDDDB"));
                break;
            case R.id.LinearLayout4:
                linearLayout4.setBackgroundColor(Color.parseColor("#0DDDDB"));
                break;
            default:
                break;
        }
    }

    private void returnbackground(View v) {
        switch (v.getId()) {
            case R.id.LinearLayout1:
                linearLayout1.setBackgroundColor(Color.parseColor("#269C92"));
                break;
            case R.id.LinearLayout2:
                linearLayout2.setBackgroundColor(Color.parseColor("#269C92"));
                break;
            case R.id.LinearLayout3:
                linearLayout3.setBackgroundColor(Color.parseColor("#269C92"));
                break;
            case R.id.LinearLayout4:
                linearLayout4.setBackgroundColor(Color.parseColor("#269C92"));
                break;
            default:
                break;
        }
    }


    private void showfragment(int i) {
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                transaction.show(weixin);
                setbackgroundcolor(linearLayout1);
                returnbackground(linearLayout2);
                returnbackground(linearLayout3);
                returnbackground(linearLayout4);
                break;
            case 1:
                transaction.show(weixin1);
                setbackgroundcolor(linearLayout2);
                returnbackground(linearLayout1);
                returnbackground(linearLayout3);
                returnbackground(linearLayout4);
                break;
            case 2:
                transaction.show(weixin2);
                setbackgroundcolor(linearLayout3);
                returnbackground(linearLayout2);
                returnbackground(linearLayout1);
                returnbackground(linearLayout4);
                break;
            case 3:
                transaction.show(weixin3);
                setbackgroundcolor(linearLayout4);
                returnbackground(linearLayout2);
                returnbackground(linearLayout3);
                returnbackground(linearLayout1);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.LinearLayout1:
                    showfragment(0);
                    break;
                case R.id.LinearLayout2:
                    showfragment(1);
                    break;
                case R.id.LinearLayout3:
                    showfragment(2);
                    break;
                case R.id.LinearLayout4:
                    showfragment(3);
                    break;
                default:
                    break;
            }
        }
        private void refresh(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }
}