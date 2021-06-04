package sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class Over60MemberTest {

    @Test
    public void getMemberAge() {

        int expected = 65;
        Over60Member over60Member = new Over60Member("Mahinda","Rajapakshe","573",65);
        int actual = over60Member.getMemberAge();
        assertEquals(expected,actual);
    }
}