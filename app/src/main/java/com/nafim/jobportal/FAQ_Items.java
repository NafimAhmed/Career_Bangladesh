package com.nafim.jobportal;

public class FAQ_Items
{
    String questions, answer;

    public FAQ_Items(String questions, String answer) {
        this.questions = questions;
        this.answer = answer;
    }

    public String getQuestions() {
        return "Question : "+questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getAnswer() {
        return "Answer : "+ answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
