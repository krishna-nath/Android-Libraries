package com.example.simplebannerlibrary;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;


public class CustomViewPagerAdapter extends FragmentStateAdapter {
    @NonNull
    private String url = "";
    private List<BannerInfo> banners;
    public CustomViewPagerAdapter(FragmentManager f, List<BannerInfo> banners) {
        super(f, new Lifecycle() {
            @Override
            public void addObserver(@NonNull LifecycleObserver observer) {

            }

            @Override
            public void removeObserver(@NonNull LifecycleObserver observer) {

            }

            @NonNull
            @Override
            public State getCurrentState() {
                return null;
            }
        });
        this.banners = banners;
    }
    @Override
    public int getItemCount() {
        return banners.size();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return BannerFragment.newInstance(banners.get(position));
    }
}

