package com.app.ESurvey.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.nio.file.Paths;

@Service
public class FBInitialize {
    @PostConstruct
    public void initialize() {
        try {
            String path = Paths.get("").toAbsolutePath().toString();

            FileInputStream serviceAccount =
                    new FileInputStream(path + "/ServiceAccount.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://sodium-ray-273413-default-rtdb.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
