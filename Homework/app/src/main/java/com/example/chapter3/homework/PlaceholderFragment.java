package com.example.chapter3.homework;


import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {

    private View fadein,fadeout;
    String[] str = new String[]
            {
                    "Kobe","LeBorn","Shaq","Ingram"
            };




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_placeholder, container, false);

        fadein = v.findViewById(R.id.listView);
        fadeout = v.findViewById(R.id.animation_view);
        ListView l = v.findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,str);

        l.setAdapter(adapter);


        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        fadein.setAlpha(0f);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行


                ObjectAnimator animator1 = ObjectAnimator.ofFloat(fadeout,"Alpha",1f,0f);
                animator1.setRepeatCount(0);
                animator1.setDuration(1500);
                animator1.start();
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(fadein,"alpha",0f,1f);
                animator2.setRepeatCount(0);
                animator2.setDuration(1500);
                animator2.start();
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
            }
        }, 5000);
    }
}
