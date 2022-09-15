// In Class Assignment 04
// Group22_InClass04
// Stephanie Lee Karp & Ken Stanley
package com.example.group22_inclass04;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    TextView printName;
    TextView printEmail;
    TextView printID;
    TextView printDept;

    User user;

    public ProfileFragment(User user) {
        this.user = user;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        printName = view.findViewById(R.id.printName);
        printEmail = view.findViewById(R.id.printEmail);
        printID = view.findViewById(R.id.printID);
        printDept = view.findViewById(R.id.printDept);

        setProfile(user);
    }

    public void setProfile(User user) {
        printName.setText(user.name);
        printEmail.setText(user.email);
        printID.setText(user.ID);
        printDept.setText(user.dept);
    }
}