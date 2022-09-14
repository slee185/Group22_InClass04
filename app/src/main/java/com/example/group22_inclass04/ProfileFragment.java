// In Class Assignment 04
// Group22_InClass04
// Stephanie Lee Karp & Ken Stanley
package com.example.group22_inclass04;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class ProfileFragment extends Fragment {

    TextView printName;
    TextView printEmail;
    TextView printID;
    TextView printDept;

    final String TAG = "Profile";


    public ProfileFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void setProfile(User user) {
        printName.setText(user.name);
        printEmail.setText(user.email);
        printID.setText(user.ID);
        printDept.setText(user.dept);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof iListener){
            pListener = (iListener)context;
        } else {
            throw new RuntimeException(context + " must implement iListener");
        }
    }

    iListener pListener;

    public interface iListener{
        //com.example.Group22_InClass04.User getUser();
    }
}