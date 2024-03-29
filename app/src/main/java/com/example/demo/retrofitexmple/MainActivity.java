package com.example.demo.retrofitexmple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.demo.retrofitexmple.module.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView mResponseTv;
    private APIService mAPIService;
    private static String TAG = "hello world";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText titleEt = (EditText) findViewById(R.id.ed_title);
        final EditText bodyEt = (EditText) findViewById(R.id.et_body);
        Button submitBtn = (Button) findViewById(R.id.btn_submit);
        mResponseTv = (TextView) findViewById(R.id.tv_response);
        mAPIService = ApiUtils.getAPIService();
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleEt.getText().toString().trim();
                String body = bodyEt.getText().toString().trim();
                if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)){
                    sendPost(title,body);
                }
            }
        });
    }

    private void sendPost(String title, String body) {
        mAPIService.savePost(title,body,101).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()){
                    showResponse(response.body().toString());
                    Log.i(TAG, "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e(TAG, "Unable to submit post to API.");
                Log.e(TAG, call.toString());
            }
        });
    }

    private void showResponse(String response) {
        if (mResponseTv.getVisibility()== View.GONE){
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }


}
