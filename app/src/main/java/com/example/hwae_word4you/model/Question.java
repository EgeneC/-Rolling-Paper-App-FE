package com.example.hwae_word4you.model;

import org.jetbrains.annotations.NotNull;

public class Question {

    private int question_id;
    private String question_content;
    private String member_id;

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_content() {
        return question_content;
    }

    public void setQuestion_content(@NotNull String question_content) {
        this.question_content = question_content;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(@NotNull String member_id) {
        this.member_id = member_id;
    }

//    public void questionContent(@NotNull String s) {
//
//    }
//
//    public void memberId(@NotNull String s) {
//        this.memberId = memberId;
//    }
}