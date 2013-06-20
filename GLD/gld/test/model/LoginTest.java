/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author itallorossi
 */
public class LoginTest {

    static Login l1, l2;

    public LoginTest() {
    }

    @Before
    public void setUp() {
        l1 = Login.getInstance();
        l2 = Login.getInstance();
    }

    @Test
    public void singletonTest() {
        assertEquals(l1, l2);
    }
}