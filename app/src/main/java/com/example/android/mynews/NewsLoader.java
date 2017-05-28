package com.example.android.mynews;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by berso on 5/25/17.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {

        public static final String LOG_TAG = NewsActivity.class.getName();
        private String mUrl;

        public NewsLoader(Context context, String Url) {
            super(context);
            mUrl = Url;
        }

        @Override
        protected void onStartLoading() {
            forceLoad();
        }

        @Override
        public List<News> loadInBackground() {
            if (mUrl == null) {
                return null;
            }

            List<News> news = QueryUtils.fetchNewsData(mUrl);
            return news;
        }


    }

