package com.example.simplebannerlibrary;

import java.io.Serializable;

public interface BannerInfo extends Serializable {
    public String getImageUrl();
    public String getBannerName();
    public String getDeepLinkUrl();
    public void onClickBanner();
}
