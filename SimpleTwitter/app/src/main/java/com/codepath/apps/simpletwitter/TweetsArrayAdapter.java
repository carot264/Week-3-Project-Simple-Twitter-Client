package com.codepath.apps.simpletwitter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.codepath.apps.simpletwitter.models.Tweet;
import com.codepath.apps.simpletwitter.utils.Util;
import com.squareup.picasso.Picasso;
import java.util.List;


public class TweetsArrayAdapter extends RecyclerView.Adapter<TweetsArrayAdapter.ViewHolder> {

    private List<Tweet> tweets;
    private Context context;
    public TweetsArrayAdapter(List<Tweet> tweetList){
        tweets = tweetList;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivProfileImage;
        public TextView tvFullName;
        public  TextView tvUserName;
        public TextView tvBody;
        public TextView tvCreateAt;
        public ViewHolder(View v) {
            super(v);
        ivProfileImage  = (ImageView)v.findViewById(R.id.ivProfileImage);
        tvFullName  = (TextView) v.findViewById(R.id.tvFullName);
        tvUserName  = (TextView) v.findViewById(R.id.tvUserName);
        tvBody      = (TextView) v.findViewById(R.id.tvBody);
        tvCreateAt  =(TextView)v.findViewById(R.id.tvCreateAt);
        }
    }
    @Override
    public TweetsArrayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_tweet, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TweetsArrayAdapter.ViewHolder holder, int position) {

        Tweet tweet = tweets.get(position);
        ImageView ivProfileImage = holder.ivProfileImage;
        TextView tvFullName = holder.tvFullName;
        TextView tvUserName = holder.tvUserName;
        TextView tvBody =  holder.tvBody;
        TextView tvCreateAt= holder.tvCreateAt;

        tvFullName.setText(tweet.getUser().getName());
        tvUserName.setText(tweet.getUser().getScreenName());
        tvBody.setText(tweet.getBody());

        if(tweet.getCreateAt() != "") {
            tvCreateAt.setText(Util.getRelativeTimeAgo(tweet.getCreateAt()));
        }
        ivProfileImage.setImageResource(android.R.color.transparent);
        Picasso.with(context).load(tweet.getUser().getProfileImageUrl()).into(ivProfileImage);
    }

    @Override
    public int getItemCount() {
        if(tweets == null) {
            return 0;
        }
        return tweets.size();
    }
    /*public View getView(int position, View convertView, ViewGroup parent){

        Tweet tweet = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_tweet,parent,false);
        ImageView ivProfileImage = (ImageView)convertView.findViewById(R.id.ivProfileImage);
        TextView tvFullName = (TextView) convertView.findViewById(R.id.tvFullName);
        TextView tvUserName = (TextView) convertView.findViewById(R.id.tvUserName);
        TextView tvBody = (TextView) convertView.findViewById(R.id.tvBody);
        TextView tvCreateAt=(TextView)convertView.findViewById(R.id.tvCreateAt);

        tvFullName.setText(tweet.getUser().getName());
        tvUserName.setText(tweet.getUser().getScreenName());
        tvBody.setText(tweet.getBody());

        if(tweet.getCreateAt() != "") {
           tvCreateAt.setText(Util.getRelativeTimeAgo(tweet.getCreateAt()));
        }
        ivProfileImage.setImageResource(android.R.color.transparent);
        Picasso.with(getContext()).load(tweet.getUser().getProfileImageUrl()).into(ivProfileImage);
        return convertView;
    }*/

}

