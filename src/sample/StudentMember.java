package sample;

public class StudentMember extends DefaultMember {
    private String schoolName;
    public StudentMember(String memberFirstName, String memberLastName, String memberID,  String schoolName) {
        super(memberFirstName, memberLastName, memberID);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
