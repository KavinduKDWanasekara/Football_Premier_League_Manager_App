package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Observable;

public class MyGymManager implements GymManager{

    public ObservableList<DefaultMember> membersDetail = FXCollections.observableArrayList();


    @Override
    public void addDefaultMember(String memberFirstName, String memberLastName, String memberID) {
        DefaultMember defaultMember = new DefaultMember(memberFirstName, memberLastName, memberID);

        Database database = new Database();
        database.defaultMem(defaultMember);

        membersDetail.add(defaultMember);
    }

    @Override
    public void addStudentMember(String memberFirstName, String memberLastName, String memberID,  String schoolName) {
        StudentMember studentMember = new StudentMember(memberFirstName,memberLastName,memberID,schoolName);

        Database database = new Database();
        database.studentMem(studentMember);

        membersDetail.add(studentMember);

    }

    @Override
    public void addOver60Member(String memberFirstName, String memberLastName, String memberID, int memberAge) {
        Over60Member over60Member = new Over60Member(memberFirstName,memberLastName,memberID,memberAge);

        Database database = new Database();
        database.over60Mem(over60Member);

        membersDetail.add(over60Member);
    }

    @Override
    public void deleteMember(String memberID) {

        Database database = new Database();
        database.deleteRecode(memberID);


    }

    @Override
    public void printListOfMembers() {


       Database database = new Database();
       database.printMembers();

    }

    @Override
    public void sortMembers() {

        Database database = new Database();
        database.sortMemberList();

    }

    @Override
    public void save() {

        Database database = new Database();
        database.writeFile();

    }


    public ObservableList<DefaultMember> addTable (){
        System.out.println(membersDetail);
        return membersDetail;
    }


}
