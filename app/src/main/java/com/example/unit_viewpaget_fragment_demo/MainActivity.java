package com.example.unit_viewpaget_fragment_demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * ViewPager+Fragment
 *
 */
public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private List<Fragment> list;
    private FragmentOnt fragmentOnt;
    private FragmentTwo fragmentTwo;
    private FragmentThree fragmentThree;
    private RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取资源ID
        viewPager = findViewById(R.id.viewpager);
        group = findViewById(R.id.group);
        //添加数据源
        fragmentOnt = new FragmentOnt();
        fragmentTwo = new FragmentTwo();
        fragmentThree  = new FragmentThree();
        list = new ArrayList<>();
        list.add(fragmentOnt);
        list.add(fragmentTwo);
        list.add(fragmentThree);

        //创建适配器
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //得到条目
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }
            //得到总数
            @Override
            public int getCount() {
                return list.size();
            }
        });

        //滑动ViewPager选中Button
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        group.check(R.id.but1);
                        break;
                    case 1:
                        group.check(R.id.but2);
                        break;
                    case 2:
                        group.check(R.id.but3);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


        //点击Button选中对应的页面
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.but1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.but2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.but3:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }
        });


    }
}
