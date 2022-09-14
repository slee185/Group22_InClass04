// In Class Assignment 04
// Group22_InClass04
// Stephanie Lee Karp & Ken Stanley
package com.example.group22_inclass04;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RegisterFragment extends Fragment {
    EditText enterNameView;
    EditText enterEmailView;
    EditText enterIdView;
    TextView departmentView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        enterNameView = view.findViewById(R.id.enterName);
        enterEmailView = view.findViewById(R.id.enterEmail);
        enterIdView = view.findViewById(R.id.enterID);
        departmentView = view.findViewById(R.id.textViewSelectedDept);

        view.findViewById(R.id.selectButton).setOnClickListener(v -> rListener.regSelectButtonClicked());

        // Validate that the required fields are filled in and if not, display a toast.
        view.findViewById(R.id.submitButton).setOnClickListener(v -> {
            Editable nameText = enterNameView.getText();
            Editable emailText = enterEmailView.getText();
            Editable idText = enterIdView.getText();

            if (nameText.length() > 0 && emailText.length() > 0 && idText.length() > 0 && departmentView.length() > 0) {
                rListener.setUser(new User(
                        enterNameView.getText().toString(),
                        enterEmailView.getText().toString(),
                        enterIdView.getText().toString(),
                        departmentView.getText().toString()
                ));

                rListener.submitRegistrationButtonClicked();
            }

            Toast.makeText(getActivity(), "You must enter a name, email, id and select a department to continue.", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof iListener) {
            rListener = (iListener) context;
            return;
        }

        throw new RuntimeException(context + " must implement iListener");
    }

    iListener rListener;

    public interface iListener {
        void regSelectButtonClicked();
        void regSubmitButtonClicked();
        void setUser(User user);
        String getDept();
    }
}