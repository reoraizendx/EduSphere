// CreateQuizFragment.java
package com.example.edusphere.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.edusphere.R;
import com.example.edusphere.model.Quiz;
import com.example.edusphere.modelview.QuizViewModel;

public class CreateQuizFragment extends Fragment {

    private EditText quizTitleInput;
    private QuizViewModel quizViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_quiz, container, false);

        quizTitleInput = view.findViewById(R.id.quiz_title_input);
        Button saveButton = view.findViewById(R.id.save_quiz_button);

        quizViewModel = new ViewModelProvider(this).get(QuizViewModel.class);

        saveButton.setOnClickListener(v -> saveQuiz());

        return view;
    }

    private void saveQuiz() {
        String title = quizTitleInput.getText().toString().trim();
        if (title.isEmpty()) {
            Toast.makeText(getContext(), "Please enter a quiz title.", Toast.LENGTH_SHORT).show();
            return;
        }

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setCourseId(1); // Example course ID

        quizViewModel.insert(quiz);
        Toast.makeText(getContext(), "Quiz created successfully!", Toast.LENGTH_SHORT).show();
    }
}
