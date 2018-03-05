package com.onedrive.sdk.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.onedrive.sdk.authentication.MSAAuthenticator;
import com.onedrive.sdk.concurrency.ICallback;
import com.onedrive.sdk.core.ClientException;
import com.onedrive.sdk.core.DefaultClientConfig;
import com.onedrive.sdk.core.IClientConfig;
import com.onedrive.sdk.extensions.IOneDriveClient;
import com.onedrive.sdk.extensions.OneDriveClient;

public class MainActivity extends AppCompatActivity {

    private static final String APP_ID = "<client-id>"; // in GUID format like `00000000-0000-0000-0000-000000000000`

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        authorizeToOneDrive();
    }

    private void authorizeToOneDrive() {
        MSAAuthenticator authenticator = createMSAAuthenticator();
        IClientConfig oneDriveConfig = DefaultClientConfig.createWithAuthenticator(authenticator);
        final ICallback<IOneDriveClient> callback = new ICallback<IOneDriveClient>() {
            @Override
            public void success(final IOneDriveClient result) {
                // OneDrive client created successfully.
                Toast.makeText(MainActivity.this, "OneDrive client created successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(final ClientException error) {
                // Exception happened during creation.
                Toast.makeText(MainActivity.this, "OneDrive Exception: " + error.toString(), Toast.LENGTH_SHORT).show();
            }
        };
        new OneDriveClient.Builder()
                .fromConfig(oneDriveConfig)
                .loginAndBuildClient(this, callback);
    }

    private MSAAuthenticator createMSAAuthenticator() {
        return new MSAAuthenticator() {
            @Override
            public String getClientId() {
                return APP_ID;
            }

            @Override
            public String[] getScopes() {
                return new String[]{
                        "offline_access", // use this scope to enable silent login
                        "onedrive.appfolder"
                };
            }
        };
    }
}
