// In Class Assignment 04
// Group22_InClass04
// Stephanie Lee Karp & Ken Stanley
package com.example.group22_inclass04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements WelcomeFragment.iListener, RegisterFragment.iListener, DepartmentFragment.iListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.containerView, new WelcomeFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void registerButtonClicked() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, new RegisterFragment(), "register")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void selectDepartmentButtonClicked() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, new DepartmentFragment(), "department")
                .addToBackStack("department")
                .commit();
    }

    @Override
    public void submitRegistrationButtonClicked(User user) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, new ProfileFragment(user), "profile")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void deptCancelButtonClicked() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void departmentSelected(String dept) {
        RegisterFragment fragment = (RegisterFragment)getSupportFragmentManager().findFragmentByTag("register");

        getSupportFragmentManager()
                .popBackStack("department", FragmentManager.POP_BACK_STACK_INCLUSIVE);

        if (fragment != null) {
            fragment.setDepartment(dept);
        }
    }


}