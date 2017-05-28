package com.example.android.mynews;

/**
 * Created by berso on 5/25/17.
 */

public class News {

    private String section;
    private String title;
    private String date;
    private String url;


    public News(String section, String title, String date,String url){
        this.section = section;
        this.title = title;
        this.date = date;
        this.url = url;
    }

    public String getSection(){ return section; }

    public String getTitle(){
        return title;
    }

    public String getDate(){
        return date;
    }

    public String getUrl() { return url; }

}
