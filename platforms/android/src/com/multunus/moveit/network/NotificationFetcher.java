package com.multunus.moveit.network;

import android.net.Uri;
import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class NotificationFetcher extends AsyncTask<String, String, JSONObject>{

    NotificationFetchListener notificationFetchListener;
    static final int CONNECTION_TIMEOUT = 30 * 1000;

    public NotificationFetcher(NotificationFetchListener notificationFetchListener) {
        this.notificationFetchListener = notificationFetchListener;
    }

    public interface NotificationFetchListener{
        public void onNotificationSuccess(JSONObject jsonObject);
    }

    @Override
    protected JSONObject doInBackground(String... params) {
        String url = params[0];
        String email = params[1];
        String time = params[2];

        HttpClient httpClient = new DefaultHttpClient();
        HttpParams httpParams = httpClient.getParams();

        HttpConnectionParams.setConnectionTimeout(httpParams, CONNECTION_TIMEOUT);
        HttpConnectionParams.setSoTimeout(httpParams, CONNECTION_TIMEOUT);

        Uri.Builder builder = Uri.parse(url).buildUpon();

        builder.appendQueryParameter("email", email);
        builder.appendQueryParameter("time", time);

        url = builder.build().toString();

        HttpGet httpGet = new HttpGet(url);

        JSONObject jsonObjectResponse = null;
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            String response = EntityUtils.toString(httpResponse.getEntity());
            jsonObjectResponse = new JSONObject(response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObjectResponse;
    }


    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
        this.notificationFetchListener.onNotificationSuccess(jsonObject);
    }
}
