package com.app.ESurvey.Service;

import com.app.ESurvey.Model.Questions;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class QuestionsService {
    public static final String COL_NAME = "sodium-ray-273413-default-rtdb";

    public Questions getQuestionDetails() throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document("Questions");
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Questions questions = new Questions();

        if (document.exists()) {
            questions = document.toObject(Questions.class);
            return questions;
        } else {
            return null;
        }
    }

    public String getAdminDetails() throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document("Admin");
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();
        String string = "";

        if (document.exists()) {
            string = document.toString();
            return string;
        } else {
            return null;
        }
    }
}
