package sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentMemberTest {

    @Test
    public void getSchoolName() {

        String expected = "Sivali";
        StudentMember studentMember = new StudentMember("Kavindu","Wanasekara","570","Sivali");
        String actual = studentMember.getSchoolName();
        assertEquals(expected,actual);

    }
}