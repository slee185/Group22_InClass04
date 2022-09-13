package com.example.group22_inclass04;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DepartmentFragment extends Fragment {

    RadioGroup deptButtons;

    public DepartmentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_department, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        deptButtons = view.findViewById(R.id.deptButtons);

        view.findViewById(R.id.deptSelectButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int chooseDept = deptButtons.getCheckedRadioButtonId();
                String dept;
                if (chooseDept == R.id.compSciButton) {
                    dept = "Computer Science";
                    dlistener.departmentSelected(dept);
                } else if (chooseDept == R.id.sisButtons) {
                    dept = "Software Info. System";
                    dlistener.departmentSelected(dept);
                } else if (chooseDept == R.id.bioInfoButton) {
                    dept = "Bio Informatics";
                    dlistener.departmentSelected(dept);
                } else if (chooseDept == R.id.dataScienceButton) {
                    dept = "Data Science";
                    dlistener.departmentSelected(dept);
                }
            }
        });

        view.findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlistener.deptCancelButtonClicked();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof iListener){
            dlistener = (iListener)context;
        } else {
            throw new RuntimeException(context.toString() + " must implement iListener");
        }
    }

    iListener dlistener;

    public interface iListener {
        void deptCancelButtonClicked();
        void departmentSelected (String dept);
    }
}