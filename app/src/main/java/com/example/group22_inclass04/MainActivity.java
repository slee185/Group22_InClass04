// In Class Assignment 04
// Group22_InClass04
// Stephanie Lee Karp

package com.example.group22_inclass04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements WelcomeFragment.iListener, RegisterFragment.iListener, DepartmentFragment.iListener, ProfileFragment.iListener{
    User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.containerView, new WelcomeFragment())
                .commit();
    }

    @Override
    public void setButtonClicked() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, new RegisterFragment())
                .commit();
    }

    @Override
    public void regSelectButtonClicked() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, new DepartmentFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void regSubmitButtonClicked() {
        ProfileFragment fragment = (ProfileFragment)getSupportFragmentManager().findFragmentByTag("Profile");

        if (fragment != null) {
            fragment.setProfile(user);
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, new ProfileFragment())
                .commit();
    }

    @Override
    public void setUser(User user) {

    }

    @Override
    public void deptCancelButtonClicked() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void departmentSelected(String dept) {
        // line of code below breaks the app
        /* user.setDepartment(dept);
         * */
        getSupportFragmentManager().popBackStack();
    }

    public User getUser() {
        return user;
    }

    @Override
    public String getDept() {
        if (user != null) {
            return user.getDepartment();
        }
        this.user = new User();
        return user.getDepartment();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}