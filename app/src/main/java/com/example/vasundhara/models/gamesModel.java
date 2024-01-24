package com.example.vasundhara.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class gamesModel {
    private List<DataItem> data;

    public List<DataItem> getData() {
        return data;
    }

    public static class DataItem {
        private int id;
        @SerializedName("app_id")
        private int appId;
        private int position;
        private String name;
        @SerializedName("thumb_image")
        private String thumbImage;
        @SerializedName("app_link")
        private String appLink;
        @SerializedName("package_name")
        private String packageName;
        @SerializedName("full_thumb_image")
        private String fullThumbImage;
        @SerializedName("splash_active")
        private int splashActive;

        public int getId() {
            return id;
        }

        public int getAppId() {
            return appId;
        }

        public int getPosition() {
            return position;
        }

        public String getName() {
            return name;
        }

        public String getThumbImage() {
            return thumbImage;
        }

        public String getAppLink() {
            return appLink;
        }

        public String getPackageName() {
            return packageName;
        }

        public String getFullThumbImage() {
            return fullThumbImage;
        }

        public int getSplashActive() {
            return splashActive;
        }
    }
}
