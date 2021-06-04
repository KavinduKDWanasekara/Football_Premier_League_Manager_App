package sample;

import com.mongodb.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileOutputStream;
import java.io.IOException;

public class Database {

    public MongoClient mongoClient ;
    public DB database;
    public  DBCollection membersCollection;

    public Database() {
        {
            try {
                mongoClient = new MongoClient("localhost", 27017);
                database = mongoClient.getDB("database");
                membersCollection = database.getCollection("details");
            }catch (Exception e){
                System.out.println(" ");
            }
        }

    }


    public void defaultMem(DefaultMember defaultMember){
        DBObject gymMember=createDBObject(defaultMember);
        WriteResult memRecode =membersCollection.insert(gymMember);
    }


    private DBObject createDBObject(DefaultMember defaultMember){
        BasicDBObjectBuilder memberRecode=BasicDBObjectBuilder.start();
        memberRecode.append("fname",defaultMember.getMemberFirstName());
        memberRecode.append("lname",defaultMember.getMemberLastName());
        memberRecode.append("ID",defaultMember.getMemberID());
        memberRecode.append("Member_Type","default");

        return memberRecode.get();
    }

    public void studentMem(StudentMember studentMember){
        DBObject gymMember=createDBObject(studentMember);
        WriteResult memRecode =membersCollection.insert(gymMember);
    }


    private DBObject createDBObject(StudentMember studentMember){
        BasicDBObjectBuilder memberRecode=BasicDBObjectBuilder.start();
        memberRecode.append("fname",studentMember.getMemberFirstName());
        memberRecode.append("lname",studentMember.getMemberLastName());
        memberRecode.append("ID",studentMember.getMemberID());
        memberRecode.append("schoolName",studentMember.getSchoolName());
        memberRecode.append("Member_Type","student");

        return memberRecode.get();

    }

    public void over60Mem(Over60Member over60Member){
        DBObject gymMember=createDBObject(over60Member);
        WriteResult memRecode =membersCollection.insert(gymMember);
    }


    private DBObject createDBObject(Over60Member over60Member){
        BasicDBObjectBuilder memberRecode=BasicDBObjectBuilder.start();
        memberRecode.append("fname",over60Member.getMemberFirstName());
        memberRecode.append("lname",over60Member.getMemberLastName());
        memberRecode.append("ID",over60Member.getMemberID());
        memberRecode.append("age",over60Member.getMemberAge());
        memberRecode.append("Member_Type","60+");

        return memberRecode.get();


    }


    //deleting a recode
    public void deleteRecode(String memberID){
        DBObject recode=BasicDBObjectBuilder.start().add("ID",memberID).get();
        WriteResult result =membersCollection.remove(recode);
    }

    public void printMembers() {
        DBCursor cursor = database.getCollection("details").find();
        DBObject record;
        while (cursor.hasNext()) {
            record = cursor.next();
            String printMembers = record.get("ID").toString() +"     "+ record.get("fname") +"     "+ record.get("lname") +"     "+ record.get("schoolName") +"     "+  record.get("age")+"     ";
            System.out.println(printMembers);
        }

    }

    public void sortMemberList(){
        String keyValue = "fname";
        BasicDBObject basicDBObject = new BasicDBObject();
        BasicDBObject sortDetails = new BasicDBObject();
        sortDetails.put(keyValue, 1);
        DBCollection keyCheck = database.getCollection("details");
        DBCursor cursor = keyCheck.find(basicDBObject).sort(sortDetails);
        DBObject record;
        while (cursor.hasNext()) {
            record = cursor.next();
            String sortMembers = record.get("ID").toString() +"     "+ record.get("fname") +"     "+ record.get("lname") +"     "+ record.get("schoolName") + "     "+ record.get("age")+"    ";
            System.out.println(sortMembers);
        }
    }

    public void writeFile() {
        try {
            DBCollection details = database.getCollection("details");
            DBCursor cursor = details.find();
            FileOutputStream write = new FileOutputStream("Details.txt");
            DBObject record;
            while (cursor.hasNext()) {
                record = cursor.next();
                String writeMembers = record.get("ID").toString() +"      "+ record.get("fname") +"     "+ record.get("lname") +"     "+ record.get("schoolName") +"     "+  record.get("age") +"     "+  "\n";
                write.write(writeMembers.getBytes());
            }
            write.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<DefaultMember> dMemTable (){
        ObservableList<DefaultMember> dMemDetails = FXCollections.observableArrayList();
        DBCursor dMemRecord = membersCollection.find();
        for (DBObject record : dMemRecord){
            if (record.get("Member_Type").toString().equals("default")){
                dMemDetails.add(new DefaultMember(record.get("ID").toString() , record.get("fname").toString() ,record.get("lname").toString()));
            } else if (record.get("Member_Type").toString().equals("student")){
                dMemDetails.add(new StudentMember(record.get("ID").toString(), record.get("fname").toString(), record.get("lname").toString(), record.get("schoolName").toString()));
            } else if (record.get("Member_Type").toString().equals("60+")){
                dMemDetails.add(new Over60Member(record.get("ID").toString(), record.get("fname").toString(), record.get("lname").toString(), Integer.parseInt(record.get("age").toString())));
            } else {
                System.out.println("Member type does not exist!!!!!");
            }
        }
        return dMemDetails;

    }







}
