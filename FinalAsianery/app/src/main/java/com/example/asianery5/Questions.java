package com.example.asianery5;

public class Questions {

    private String mQuestions[] = {

            "Guest the Flag  ",
            "Guest the Flag  ",
            "Guest the Flag  ",
            "Guest the Flag  ",
            "Guest the Flag  ",
            "Guest the Flag  ",
            "Guest the Flag  ",
            "Guest the Flag  ",
            "Guest the Flag  ",
            "Guest the Flag  "
    };

    private String mchoice[] [] = {

            {"Singapore", "Philippines", "South Korea"},
            {"Sri Lanka", "Cambodia", "Taiwan"},
            {"Saudi Arabia", "Qatar", "Armenia"},
            {"Laos", "Myanmar", "Mongolia"},
            {"Uzbekistan", "Nepal", "Vietnam"},
            {"Pakistan", "Oman", "Palestine"},
            {"Jordan", "Georgia", "Japan"},
            {"Cyprus", "Cambodia", "China"},
            {"Brunei", "India", "Iraq"},
            {"Kuwait", "Maldives", "Malaysia"},
    };

    private String mImages[] = {
            "q1", // Philippines image
            "q2", // Cambodia image
            "q3", // Saudi Arabia image
            "q4", // Laos image
            "q5", // Uzbekistan image
            "q6", // Pakistan image
            "q7", // Japan image
            "q8", // China image
            "q9", // Brunei image
            "q10", // Malaysia image
    };

    private String mQuestionsType[] = {
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",

    };

    private String mCoorectAnswers [] = {
            "Philippines",
            "Cambodia",
            "Saudi Arabia",
            "Laos",
            "Uzbekistan",
            "Pakistan",
            "Japan",
            "China",
            "Brunei",
            "Malaysia",
    };


    public String getQuestions(int q) {
        String questions = mQuestions[q];
        return questions;
    }

    public String[] getChoice(int q) {
        String[] choice = mchoice[q];
        return choice;
    }

    public String getImages(int q) {
        String img = mImages[q];
        return img;
    }

    public String getType(int q) {
        String type = mQuestionsType[q];
        return type;
    }

    public int getLength(){
        return mQuestions.length;
    }
    public String getCoorectAnswers(int q) {

        String correct = mCoorectAnswers[q];

        return correct;
    }
}
