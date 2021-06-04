package sample;

import javafx.collections.ObservableList;

import java.util.Date;

public interface GymManager {

    public void addDefaultMember(String memberFirstName, String memberLastName, String memberID);
    public void addStudentMember(String memberFirstName, String memberLastName, String memberID,  String schoolName);
    public void addOver60Member(String memberFirstName, String memberLastName, String memberID, int memberAge);
    public void deleteMember(String memberID);
    public void printListOfMembers();
    public void sortMembers();
    public void save();




}
