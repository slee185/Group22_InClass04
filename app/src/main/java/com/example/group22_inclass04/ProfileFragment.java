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

public class ProfileFragment extends Fragment {

    TextView printName;
    TextView printEmail;
    TextView printID;
    TextView printDept;

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

        //com.example.groupa2_inclass04.User user = pListener.getUser();
        // line of code below breaks app
        /*printName.setText(user.getName());
         printEmail.setText(user.getEmail());
         printID.setText(user.getId());
        printDept.setText(user.getDepartment()); */
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
        //com.example.groupa2_inclass04.User getUser();
    }
}