// In Class Assignment 04
// Group22_InClass04
// Stephanie Lee Karp & Ken Stanley
package com.example.group22_inclass04;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WelcomeFragment extends Fragment {

    public WelcomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.registerButton).setOnClickListener(v -> mListener.registerButtonClicked());
    }

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);

        if (context instanceof iListener){
            mListener = (iListener)context;
        } else {
            throw new RuntimeException(context + " must implement iListener");
        }
    }

    iListener mListener;

    public interface iListener {
        void registerButtonClicked();
    }
}