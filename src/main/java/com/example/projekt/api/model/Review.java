package com.example.projekt.api.model;

public class Review {
    private Integer rating;
    private String comment;
    private String  date;
    private String reviewerName;
    private String reviewerEmail;

    public Review(){

    }
    public Review(Integer rating, String comment, String date, String reviewerName, String reviewerEmail) {
        this.rating = rating;
        this.comment = comment;
        this.date = date;
        this.reviewerName = reviewerName;
        this.reviewerEmail = reviewerEmail;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getReviewerEmail() {
        return reviewerEmail;
    }

    public void setReviewerEmail(String reviewerEmail) {
        this.reviewerEmail = reviewerEmail;
    }

    @Override
    public String toString() {
        return "Review{" +
                "rating=" + rating +
                ", comment='" + comment + '\'' +
                ", date='" + date + '\'' +
                ", reviewerName='" + reviewerName + '\'' +
                ", reviewerEmail='" + reviewerEmail + '\'' +
                '}';
    }
}
