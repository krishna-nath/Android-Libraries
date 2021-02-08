package com.example.simplebannerlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

public class BannerView extends RelativeLayout {
    private List<BannerInfo> bannerInfo;
    private View mView;

    public BannerView(Context context) {
        super(context);
    }

    public BannerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = inflate(context, R.layout.banner_container, this);
        this.mView = view;
        final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BannerView, 0, 0);
        String url = typedArray.getString(R.styleable.BannerView_imageUrl);
        typedArray.recycle();

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    public void setBannerInfoData(List<BannerInfo> bannerList){
      this.bannerInfo = bannerList;
      init();
    }

    public void init(){
        FragmentManager f = ((AppCompatActivity)getContext()).getSupportFragmentManager();
        ViewPager2 pager = findViewById(R.id.view_pager);
            if(this.bannerInfo != null) {
                CustomViewPagerAdapter adapter = new CustomViewPagerAdapter(f, this.bannerInfo);
                pager.setAdapter(adapter);
                TabLayout tabLayout = findViewById(R.id.tablayout);
                new TabLayoutMediator(tabLayout, pager, (tab, position) -> pager.setCurrentItem(tab.getPosition(), true)).attach();
            }
    }
}


