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

    EditText enterName;
    EditText enterEmail;
    EditText enterID;
    TextView textViewSelectedDept;
    final static public String USER_KEY = "User";

    public RegisterFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        enterName = view.findViewById(R.id.enterName);
        enterEmail = view.findViewById(R.id.enterEmail);
        enterID = view.findViewById(R.id.enterID);
        textViewSelectedDept = view.findViewById(R.id.textViewSelectedDept);

        view.findViewById(R.id.selectButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rListener.regSelectButtonClicked();
            }
        });

        view.findViewById(R.id.submitButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rListener.regSelectButtonClicked();
                if (enterName == null || enterEmail == null || enterID == null) {
                    Toast.makeText(getActivity(), "Enter a name, email and ID!", Toast.LENGTH_SHORT).show();
                } else {
                    User user = new User (enterName.getText().toString(), enterEmail.getText().toString(), enterID.getText().toString(), rListener.getDept());
                    rListener.setUser(user);
                }
                rListener.regSubmitButtonClicked();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);

        if (context instanceof iListener){
            rListener = (iListener)context;
        } else {
            throw new RuntimeException(context.toString() + " must implement iListener");
        }
    }

    iListener rListener;

    public interface iListener {
        void regSelectButtonClicked();
        void regSubmitButtonClicked();
        void setUser(User user);
        String getDept();
    }
}