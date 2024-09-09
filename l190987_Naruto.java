package com.example.nartuoShippuden;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.Locale;

public class naruto extends AppCompatActivity {
    private TextView timerTextView, questionTextView;
    private RadioGroup optionsGroup;
    private AppCompatButton prevButton, nextButton, seeAnswerButton;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private int totalTime = 180; // 3 minutes in seconds
    private boolean quizEnded = false;
    private boolean hasSeenAnswer = false;

    private String[] questions = { "Q1: Who is the main antagonist of Naruto Series?",
            "Q2: Which tail beast is inside Naruto Uzumaki?",
            "Q3: Who pierced Madara Uchiha?",
            "Q4: Who was the Hokage at the time of 4th Great Ninja War?",
            "Q5: Who is considered as the weakest Hokage?",
            "Q6: Who killed Rin?",
            "Q7: Who gave Sharinagn to Kakashi Hatake?",
            "Q8: What technique Itachi Uchiha uses?",
            "Q9: Who sealed Kaguya Sama?",
            "Q10: Who was manipulating Obito Uchiha?",
            "Q11: What are the total number of tailed beast?",
            "Q12: Who taught Naruto Uzumaki how to master tailed beast?",
            "Q13: What were Akatsuki memebers after?",
            "Q14: Who is the leader of Akatsuki?",
            "Q15: Obito Uchiha was Jinchuriki of which tailed beast?",
            "Q16: Jiraya was known as?",
            "Q17: Total number of Saanin?",
            "Q18: What are the names of Naruto Uzumaki parents?",
            "Q19: Who was responsbile for Naruto Uzumaki's parents death?",
            "Q20: What was Orochimaru after?",
            "Q21: Who killed the whole Uchiha Clan?",
            "Q22: Who killed Danzo?",
            "Q23: Total number of Villages in naruto.",
            "Q24: Who opened all 8 inner gates against Madara Uchiha?",
            "Q25: Who portrayed as Madara Uchiha before Great Ninja War?",
            "Q26: Who declared the start of Great Ninja War 4?",
            "Q27: Who became the leader of All Shinobi Alliance?",
            "Q28: What is the line said most by Naruto Uzumaki?",
            "Q29: Who married Naruto Uzumaki?",
            "Q30: Which member of Hyuga Clan died in the Great Ninja War?"
    };
    private String[][] options = {
            { "Madara", "Black Zetsu", "Kaguya", "Obito" },
            { "Kurama", "Son Goku", "Shukaku", "Saiken" },
            { "Naruto Uzumaki", "Black Zetsu", "Obito Uchiha", "Might Guy" },
            { "Kakashi Hatake", "Hashirama Senju", "Tsunade Senju", "Minato Namikaze" },
            { "Naruto Uzumaki", "Tsunade Senju", "Hashirama Senu", "Hiruzen Sarutobi" },
            { "Kakshi Hatake", "Obito Uchiha", "MIght Guy", "Invaders" },
            { "Itachi Uchiha", "Shisui Uchiha", "Danzo", "Obito Uchiha" },
            { "Amaterasu", "Beast bomb", "Kamui", "Infinte Tsukiyomi" },
            { "Naruto & Sakura", "Sakura & Sasuke", "Sasuke & Obito", "Sasuke & Naruto" },
            { "Black Zetsu", "Madara Uchiha", "Kaguya Sama", "None of these" },
            { "7", "8", "9", "2" },
            { "Obito Uchiha", "Killer B", "Kakashi Hatake", "Sasuke" },
            { "World Domination", "Destruction of Leaf Village", "Capture Tailed Beasts", "Just having fun" },
            { "Orochimaru", "Hidan", "Pain", "Kakuzu" },
            { "7", "2", "10", "11" },
            { "Toad Sage", "Copy Ninja", "Sage of Six Paths", "Clumsy Ninja" },
            { "7", "2", "3", "6" },
            { "Sakura & Sasuke", "Kushina & Minato", "Tsuande & Hiruzen", "Ten Ten & Obito" },
            { "Akatsuki", "Obito Uchiha", "Kurama", "Naruto Himself" },
            { "Eternal Life", "Power", "Destruction", "Love" },
            { "Kakshi Hatake", "Minato Namikaze", "Itachi Uchiha", "Naruto Uzumaki" },
            { "Naruto Uzumake", "Obito Uchiha", "Itachi Uchiha", "Sasuke Uchiha" },
            { "3", "4", "6", "10" },
            { "Might Guy", "Rock Lee", "Kakshi Uchiha", "All of them" },
            { "Black Zetsu", "Orochimaru", "Obito Uchiha", "Sasuke Uchiha" },
            { "Obito Uchiha", "Danzo", "Sasuke Uchiha", "All Kages" },
            { "Naruto Uzumake", "Tsunade Senju", "Killer B", "Gaara" },
            { "Sasuke", "Dattebayo", "Sakura", "None of these" },
            { "Ten Ten", "Sakura", "Ino", "Hinata Hyuga" },
            { "Neji Hyuga", "Hinata Hyuga", "Hanabi hyuga", "Hizashi Hyuga" }
    };
    private int[] correctAnswers = {
            2, // kaguya
            0, // kurana
            1, // black zetsu
            3, // tsunade
            1, // tsunade
            0, // kakshi
            3, // obito
            0, // amaterasu
            3, // sasuke naruto
            1, // madara
            2, // 9
            1, // killer b
            2, // tailed beast
            2, // pain
            2, // 10
            0, // toad sage
            2, // 3
            1, // kushina minato
            2, // kurana
            0, // eternal life
            2, // itachi uchiha
            3, // sasuke
            2, // 6
            0, // might guy
            2, // obito uchiha
            0, // obito uchiha
            3, // gaara
            1, // dattebayo
            3, // hinata
            0,// neji
    };
    private CountDownTimer countdownTimer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naruto);

        timerTextView = findViewById(R.id.timer);
        questionTextView = findViewById(R.id.question);
        optionsGroup = findViewById(R.id.options);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);
        seeAnswerButton = findViewById(R.id.seeAnswerButton); // New button for seeing answer

        updateQuestion();

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex--;
                    hasSeenAnswer = false; // Reset the "see answer" status
                    updateQuestion();
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (optionsGroup.getCheckedRadioButtonId() != -1) {
                    checkAnswer(); // Check answer when moving to next question
                    if (currentQuestionIndex < questions.length - 1) {
                        currentQuestionIndex++;
                        hasSeenAnswer = false; // Reset the "see answer" status
                        updateQuestion();
                    } else {
                        quizEnded = true;
                        showScore(); // Show the score when the last question is reached
                    }
                } else {
                    Toast.makeText(naruto.this, "Please select an answer!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // "See Answer" button functionality
        seeAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!hasSeenAnswer) {
                    revealCorrectAnswer();
                    score -= 1; // Deduct 1 point for seeing the answer
                    hasSeenAnswer = true; // Disable further use of this button for the same question
                } else {
                    Toast.makeText(naruto.this, "You've already seen the answer for this question!", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        startTimer();
    }

    private void startTimer() {
        countdownTimer = new CountDownTimer(totalTime * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int minutes = (int) (millisUntilFinished / 1000) / 60;
                int seconds = (int) (millisUntilFinished / 1000) % 60;
                timerTextView.setText(String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds));
            }

            @Override
            public void onFinish() {
                quizEnded = true;
                showScore(); // Show score when time runs out
            }
        }.start();
    }

    private void updateQuestion() {
        // Reset the background color of all options
        for (int i = 0; i < optionsGroup.getChildCount(); i++) {
            RadioButton option = (RadioButton) optionsGroup.getChildAt(i);
            option.setBackgroundColor(getResources().getColor(android.R.color.transparent)); // Reset to transparent
            // background
        }

        // Set the new question and options
        questionTextView.setText(questions[currentQuestionIndex]);
        String[] currentOptions = options[currentQuestionIndex];
        ((RadioButton) findViewById(R.id.option1)).setText(currentOptions[0]);
        ((RadioButton) findViewById(R.id.option2)).setText(currentOptions[1]);
        ((RadioButton) findViewById(R.id.option3)).setText(currentOptions[2]);
        ((RadioButton) findViewById(R.id.option4)).setText(currentOptions[3]);

        optionsGroup.clearCheck(); // Clear the selection for the new question
        hasSeenAnswer = false; // Reset the "see answer" flag for the new question
    }

    private void checkAnswer() {
        int selectedAnswerIndex = optionsGroup.indexOfChild(findViewById(optionsGroup.getCheckedRadioButtonId()));
        if (selectedAnswerIndex == correctAnswers[currentQuestionIndex]) {
            score += 5; // Increase score by 5 for correct answer
        } else {
            score--; // Decrease score by 1 for wrong answer
        }
    }

    private void revealCorrectAnswer() {
        // Highlight or show the correct answer
        int correctAnswerIndex = correctAnswers[currentQuestionIndex];
        RadioButton correctOption = (RadioButton) optionsGroup.getChildAt(correctAnswerIndex);
        correctOption.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
    }

    private void showScore() {
        countdownTimer.cancel(); // Stop the timer if it's still running

        // Show the score in an AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Quiz Completed");
        builder.setMessage("Your final score is: " + score);
        builder.setPositiveButton("OK", (dialog, which) -> finish()); // Close the activity
        builder.setCancelable(false);
        builder.show();
}
}