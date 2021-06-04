package sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultMemberTest {

    @Test
    public void getMemberFirstName() {
        String expected = "Kavindu";
        DefaultMember defaultMember = new DefaultMember("Kavindu","Wanasekara","570");
        String actual = defaultMember.getMemberFirstName();
        assertEquals(expected,actual);
    }

    @Test
    public void getMemberLastName() {
        String expected = "Wanasekara";
        DefaultMember defaultMember = new DefaultMember("Kavindu","Wanasekara","570");
        String actual = defaultMember.getMemberLastName();
        assertEquals(expected,actual);
    }

    @Test
    public void getMemberID() {
        String expected = "570";
        DefaultMember defaultMember = new DefaultMember("Kavindu","Wanasekara","570");
        String actual = defaultMember.getMemberID();
        assertEquals(expected,actual);
    }
}