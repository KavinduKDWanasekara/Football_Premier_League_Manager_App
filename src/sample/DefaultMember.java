package sample;

import java.util.Date;

public class DefaultMember {
    private String memberFirstName;
    private String memberLastName;
    private String memberID;


    public DefaultMember(String memberFirstName, String memberLastName, String memberID) {
        super();
        this.memberFirstName = memberFirstName;
        this.memberLastName = memberLastName;
        this.memberID = memberID;

    }


    public String getMemberFirstName() {
        return memberFirstName;
    }

    public void setMemberFirstName(String memberFirstName) {
        this.memberFirstName = memberFirstName;
    }

    public String getMemberLastName() {
        return memberLastName;
    }

    public void setMemberLastName(String memberLastName) {
        this.memberLastName = memberLastName;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }


}
