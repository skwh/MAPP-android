package com.fhscompsci.mapp;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;

import org.json.JSONException;

/**
 * Created by Evan on 6/9/16.
 */
public class SocialMediaListing {
    public enum FeedType {
        TWITTER, FACEBOOK
    }
    public String title;
    private String source;
    private FeedType type;
    public String latestItemMessage;

    public SocialMediaListing(String title, String source, FeedType type) {
        this.title = title;
        this.source = source;
        this.type = type;
    }

    public SocialMediaListing(String title, String latestItemMessage) {
        // TODO: 6/12/16 TEST DATA TEMPORARY
        this.latestItemMessage = latestItemMessage;
        this.title = title;
    }

    public String getLatestItem() {
        // TODO: 6/12/16 FINISH SOCIAL MEDIA GETTER
        if (this.type == FeedType.FACEBOOK) {
            new GraphRequest(
                    AccessToken.getCurrentAccessToken(),
                    "/" + source + "/feed",
                    null,
                    HttpMethod.GET,
                    new GraphRequest.Callback() {
                        public void onCompleted(GraphResponse response) {
                            try {
                                latestItemMessage = response.getJSONArray().get(0).toString();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            ).executeAsync();
        } else if (this.type == FeedType.TWITTER) {
            this.latestItemMessage = "Eventually I'll get around to the twitter implementation";
        }
        return this.latestItemMessage;
    }
}
