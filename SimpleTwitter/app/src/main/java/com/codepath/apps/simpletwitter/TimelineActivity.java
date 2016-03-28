package com.codepath.apps.simpletwitter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.codepath.apps.simpletwitter.models.Tweet;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.*;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class TimelineActivity extends AppCompatActivity {

    private TwitterClient client;
    private ArrayList<Tweet> tweets;
    private TweetsArrayAdapter aTweets;
    //private ListView lvTweets;
    private RecyclerView rvTweets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        client = TwitterApp.getRestClient();// singleton client
        rvTweets = (RecyclerView) findViewById(R.id.rvTweet);
        tweets = new ArrayList<>();
        populateTimeLine();
        aTweets = new TweetsArrayAdapter(tweets);
        rvTweets.setAdapter(aTweets);
        rvTweets.setLayoutManager(new LinearLayoutManager(this));

    }

    //send API Request to get the TimeLine  json
    //[]: JSONArray, {}: JSONObject
    private void populateTimeLine() {

        client.getHomeTimeLine(new JsonHttpResponseHandler() {
            //SUCCESS
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                     //deserialize JSON
                Type listType = new TypeToken<List<Tweet>>() {}.getType();
                ArrayList<Tweet> temp = (new Gson().fromJson(response.toString(), listType));
                tweets.addAll(temp);
                 int curSize = aTweets.getItemCount();
                 aTweets.notifyItemRangeInserted(curSize, tweets.size());


           }
           @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("Debug",responseString.toString());
            }
        });

    }

}
