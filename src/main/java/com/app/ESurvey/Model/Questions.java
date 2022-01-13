package com.app.ESurvey.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class Questions {
    String question_id;
    String question;
    String answer;
}
