package com.isa.knowledgequiz;

import java.util.ArrayList;
public class Questions_Constants
{

    // TODO (STEP 1: Create constant variables which we required in the result screen.)
    // START
    public static final String USER_NAME = "user_name";
    public static final String TOTAL_QUESTIONS = "total_questions";
    public static final String CORRECT_ANSWERS = "correct_answers";
    // END

    public static ArrayList<Question> getQuestions() {
        ArrayList<Question> questionsList = new ArrayList<>();

        // 1 Start of History
        Question que1 = new Question(
                1, "Which woman discovered radium and polonium?",
                "Marie Curie", "Michelle Obama",
                "Alice Ball", "Dorothy Hodgkin", 1
        );

        questionsList.add(que1);

        // 2 History
        Question que2 = new Question(
                2, "In what year did the Battle of Hastings take place?",
                "1068", "1199",
                "1066", "1201", 3
        );

        questionsList.add(que2);

        // 3 History
        Question que3 = new Question(
                3, "Bosnia and Herzegovina was part of what former European country?",
                "Soviet Union", "East Germany",
                "Brunei", "Yugoslavia", 4
        );

        questionsList.add(que3);

        // 4 History
        Question que4 = new Question(
                4, "Who was the first explorer to sail around the world?",
                "Franck Cammas ", "Ferdinand Magellan",
                "Bernard Gilboy", "Francis Chichester ", 2
        );

        questionsList.add(que4);

        // 5 History
        Question que5 = new Question(
                5, "One of these countries was Neutral in WW2",
                "Poland", "Romania",
                "Sweden", "Hungary", 3
        );

        questionsList.add(que5);

        // 6 History
        Question que6 = new Question(
                6, "Who was President during the Bay of Pigs Invasion?",
                "U.S. President John F. Kennedy", "U.S. President Jimmy Carter",
                "U.S. President Richard Nixon", "none of these", 1
        );

        questionsList.add(que6);

        // 7 History
        Question que7 = new Question(
                7, "Who was the first person to orbit the earth ?",
                "Neil Armstrong", "William B. Bridgeman",
                "Yuri A. Gagarin", "Albert S. Crossfield", 3
        );

        questionsList.add(que7);

        // 8 History
        Question que8 = new Question(
                8, "When did Turkish War of Independence start and end ?",
                "25 April 1935 – 27 August 1939", "20 March 1925 – 24 July 1929",
                "5 September 1939 – 31 August 1945", "19 May 1919 – 24 July 1923", 4
        );

        questionsList.add(que8);

        // 9 History
        Question que9 = new Question(
                9, "On what island was Napoleon born?",
                "Elba", "Corsica",
                "St Helen", "Isle of Man", 2
        );

        questionsList.add(que9);

        // 10 History
        Question que10 = new Question(
                10, "Where did Joseph Stalin, Winston Churchill, and Franklin D. Roosevelt meet following the conclusion of WW2?",
                "Yalta", "Moscow",
                "Paris", "London", 1
        );

        questionsList.add(que10);

        return questionsList;
    }
}

