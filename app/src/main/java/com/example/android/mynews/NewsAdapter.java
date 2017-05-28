package com.example.android.mynews;

/**
 * Created by berso on 5/25/17.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
public class NewsAdapter extends ArrayAdapter<News> {

    private List<News> news;
    private Context context;

    public NewsAdapter(Activity context, ArrayList<News> news) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, news);
        this.news = news;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final NewsViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.news_list_item, parent, false);

            viewHolder = new NewsViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (NewsViewHolder) convertView.getTag();
        }

        final News currenNew = news.get(position);

        String section = currenNew.getSection();
        String title = currenNew.getTitle();
        String date = currenNew.getDate();
        viewHolder.sectionTextView.setText(section);
        viewHolder.titleTextView.setText(title);
        viewHolder.dateTextView.setText(date);


        //Set the on click listener to show the page related to the new the user click in the browser
        viewHolder.rootLayOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = currenNew.getUrl();
              //  Log.v("click",url);
                Uri uri = Uri.parse(url); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }
        });


        return convertView;
    }


    static class NewsViewHolder {

        private TextView sectionTextView;
        private TextView titleTextView;
        private TextView dateTextView;
        private LinearLayout rootLayOut;


        public NewsViewHolder(@NonNull View view) {
            this.sectionTextView = (TextView) view.findViewById(R.id.section);
            this.titleTextView = (TextView) view.findViewById(R.id.title);
            this.dateTextView = (TextView) view.findViewById(R.id.date);
            this.rootLayOut = (LinearLayout)view.findViewById(R.id.root_layout);
        }

    }


}


