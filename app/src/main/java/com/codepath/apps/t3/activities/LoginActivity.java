package com.codepath.apps.t3.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.codepath.apps.t3.R;
import com.codepath.apps.t3.TwitterClient;
import com.codepath.oauth.OAuthLoginActionBarActivity;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends OAuthLoginActionBarActivity<TwitterClient> {

    @Bind(R.id.ivLoginPhoto)
    ImageView ivLoginPhoto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

        init();
	}

    protected void init() {
        ButterKnife.bind(this);

        String url = "https://i.imgur.com/mBumL3s.jpg";
        Picasso.with(this).load(url).into(ivLoginPhoto);
    }


	// Inflate the menu; this adds items to the action bar if it is present.
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	// OAuth authenticated successfully, launch primary authenticated activity
	// i.e Display application "homepage"
	@Override
	public void onLoginSuccess() {
		// Intent i = new Intent(this, PhotosActivity.class);
		// startActivity(i);
        Toast.makeText( this, "Success", Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        Log.i("Return", "Done");
        finish();
	}

	// OAuth authentication flow failed, handle the error
	// i.e Display an error dialog or toast
	@Override
	public void onLoginFailure(Exception e) {
		e.printStackTrace();
	}

	// Click handler method for the button used to start OAuth flow
	// Uses the client to initiate OAuth authorization
	// This should be tied to a button used to login
	public void loginToRest(View view) {
		getClient().connect();
	}

}
