package com.codepath.apps.simpletwitter.models;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Tweet {
    @SerializedName("text")
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private long uid;// unique for the tweet

    @SerializedName("id")
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @SerializedName("created_at")
    private String createAt;

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    @SerializedName("user")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }




    /*public static Tweet fromJSON(JSONObject jsonObject){
        Tweet tweet = new Tweet();
        //Extract  the values  from the Json , store them
        try {
            tweet.body = jsonObject.getString("text");
            tweet.uid = jsonObject.getLong("id");
            tweet.createAt = jsonObject.getString("created_at");
            tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));

        }catch (JSONException e){
            e.printStackTrace();
        }
        return tweet;
    }
    public static ArrayList<Tweet> fromJSONArray(JSONArray array){

        ArrayList<Tweet> tweets = new ArrayList<>();
        //Extract  the values  from the Json , store them
        for(int i = 0; i < array.length(); i++){
            try {
              JSONObject tweetJSon = array.getJSONObject(i);
                Tweet tweet = Tweet.fromJSON(tweetJSon);
                if(tweet != null)
                    tweets.add(tweet);

            }catch (JSONException e){
                e.printStackTrace();
            }
        }

        return tweets;
    }*/

}
