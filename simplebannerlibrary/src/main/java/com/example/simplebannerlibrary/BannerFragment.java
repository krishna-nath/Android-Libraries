package com.example.simplebannerlibrary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class BannerFragment extends Fragment {

    private static final String ARG_BANNER = "BANNER_DETAIL";
    private  @Nullable  BannerInfo mBanner;
    public BannerFragment() {
    }
    public static BannerFragment newInstance(BannerInfo banner) {
        BannerFragment fragment = new BannerFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_BANNER, banner);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mBanner = (BannerInfo) getArguments().getSerializable(ARG_BANNER);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.banner_view, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AppCompatImageView iv = view.findViewById(R.id.bannerImageView);
        String name = mBanner.getBannerName();
        String imageUrl = mBanner.getImageUrl();
        Glide.with(this).load(imageUrl).into(iv);
    }
}