package com.csungreen.In_Plane_App;

import android.os.AsyncTask;
import org.apache.http.impl.client.*;
import org.apache.http.client.methods.*;
import java.util.*;
import org.apache.http.*;
import org.apache.http.message.*;
import android.provider.Settings.Secure;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import android.util.Log;

/**
 * Created by warren on 2/9/14.
 */
public class DequeueTask extends AsyncTask<Void, Void, String> {
    public String doInBackground(Void...v){
        DefaultHttpClient httpcli;
        HttpPost httppost;
        Secure secure = new Secure();
        String deviceID = secure.ANDROID_ID;
        String result = "true";
        try {
            httpcli = new DefaultHttpClient();
            httppost = new HttpPost("http://172.31.176.125/no_name_yet.php");
            ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
            postParameters.add(new BasicNameValuePair("DeviceID", deviceID ));

            httppost.setEntity(new UrlEncodedFormEntity(postParameters));
            HttpResponse response = httpcli.execute(httppost);
            Log.i("postData", response.getStatusLine().toString());
        }
        catch(Exception e)
        {
            Log.e("kablooey", "Error:  "+e.toString());
        }
        return result;
    }
}
