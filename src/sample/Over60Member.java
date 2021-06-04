package sample;

import java.util.Date;

public class Over60Member extends DefaultMember{
    private int memberAge;
    public Over60Member(String memberFirstName, String memberLastName, String memberID, int memberAge) {
        super(memberFirstName, memberLastName, memberID);
        this.memberAge = memberAge;
    }

    public int getMemberAge() {
        return memberAge;
    }

    public void setMemberAge(int memberAge) {
        if ( memberAge>=60){
            this.memberAge = memberAge;
        } else {
            throw new IllegalArgumentException("Invalid Age For A Over 60 Member!!");
        }

    }
}
