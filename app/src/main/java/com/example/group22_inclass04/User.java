// In Class Assignment 04
// Group22_InClass04
// Stephanie Lee Karp & Ken Stanley
package com.example.group22_inclass04;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    String name;
    String email;
    String ID;
    String dept;

    public User(String name, String email, String ID, String dept) {
        this.name = name;
        this.email = email;
        this.ID = ID;
        this.dept = dept;
    }

    public User() {

    }

    protected User(Parcel in) {
        name = in.readString();
        email = in.readString();
        ID = in.readString();
        dept = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[1];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(ID);
        dest.writeString(dept);
    }

    public void setDepartment(String department){
        this.dept = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return ID;
    }

    public void setId(String id) {
        this.ID = id;
    }

    public User getUser() {
        return new User(this.name, this.email, this.ID, this.dept);
    }

    public String getDepartment() {
        return dept;
    }
}
