package com.isa.knowledgequiz;

public class Question
{
    private int id;
    private String question;
    private String optionOne;
    private String optionTwo;
    private String optionThree;
    private String optionFour;
    private int correctAnswer;

    // Constructor
    public Question(int id, String question, String optionOne, String optionTwo, String optionThree, String optionFour, int correctAnswer)
    {
        this.id = id;
        this.question = question;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.correctAnswer = correctAnswer;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getOptionOne() {
        return optionOne;
    }

    public String getOptionTwo() {
        return optionTwo;
    }

    public String getOptionThree() {
        return optionThree;
    }

    public String getOptionFour() {
        return optionFour;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptionOne(String optionOne) {
        this.optionOne = optionOne;
    }

    public void setOptionTwo(String optionTwo) {
        this.optionTwo = optionTwo;
    }

    public void setOptionThree(String optionThree) {
        this.optionThree = optionThree;
    }

    public void setOptionFour(String optionFour) {
        this.optionFour = optionFour;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    // Overriding equals, hashCode, and toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id &&
                correctAnswer == question.correctAnswer &&
                this.question.equals(question.question) &&
                optionOne.equals(question.optionOne) &&
                optionTwo.equals(question.optionTwo) &&
                optionThree.equals(question.optionThree) &&
                optionFour.equals(question.optionFour);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, question,  optionOne, optionTwo, optionThree, optionFour, correctAnswer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", optionOne='" + optionOne + '\'' +
                ", optionTwo='" + optionTwo + '\'' +
                ", optionThree='" + optionThree + '\'' +
                ", optionFour='" + optionFour + '\'' +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}

