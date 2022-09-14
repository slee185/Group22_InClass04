// In Class Assignment 04
// Group22_InClass04
// Stephanie Lee Karp & Ken Stanley

package com.example.group22_inclass04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements WelcomeFragment.iListener, RegisterFragment.iListener, DepartmentFragment.iListener, ProfileFragment.iListener {
    User user;

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
        ProfileFragment fragment = (ProfileFragment)getSupportFragmentManager().findFragmentByTag("profile");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, new ProfileFragment(), "profile")
                .addToBackStack(null)
                .commit();

        if (fragment != null) {
            fragment.setProfile(user);
        }
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