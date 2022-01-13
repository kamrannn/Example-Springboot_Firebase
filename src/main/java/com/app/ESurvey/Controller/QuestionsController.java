package com.app.ESurvey.Controller;

import com.app.ESurvey.Model.Admin;
import com.app.ESurvey.Model.Questions;
import com.app.ESurvey.Service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class QuestionsController {
    QuestionsService questionsService;

    @Autowired
    public QuestionsController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @GetMapping("/getPatientDetails")
    public Questions getQuestions() throws ExecutionException, InterruptedException {
        return questionsService.getQuestionDetails();
    }

    @GetMapping("/getAdminDetails")
    public String getAdmins() throws ExecutionException, InterruptedException {
        return questionsService.getAdminDetails();
    }
}
