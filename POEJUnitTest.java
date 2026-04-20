/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kesao
 */
public class POEJUnitTest {

    public POEJUnitTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    // UNIT TESTS FOR VALIDATION 

    @Test
    public void testUsernameCorrectlyFormatted() {
        boolean result = POEprojectpart1.checkUsername("kyl_1");   
        assertTrue(result, "Username with underscore and <=5 chars should be valid");
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        boolean result = POEprojectpart1.checkUsername("kyle!!!!");
        assertFalse(result, "Username without underscore or too long should be invalid");
    }

    @Test
    public void testPasswordMeetsComplexity() {
        boolean result = POEprojectpart1.checkPassword("Ch&&sec@ke99!");   
        assertTrue(result, "Password with capital, number, special char and >=8 length should pass");
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        boolean result = POEprojectpart1.checkPassword("password");
        assertFalse(result, "Simple password should fail complexity check");
    }

    @Test
    public void testCellPhoneCorrectlyFormatted() {
        boolean result = POEprojectpart1.checkCellphone("+278398968976");
        assertTrue(result, "Cell number starting with +27 should be valid");
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        boolean result = POEprojectpart1.checkCellphone("08966553");
        assertFalse(result, "Cell number without +27 should be invalid");
    }

    // LOGIN STATUS TESTS 

    @Test
    public void testSuccessfulLoginMessage() {
        
        POEprojectpart1.setTestUser("kyl_1", "Ch&&sec@ke99!", "John", "Doe");  
        
        String message = Login.returnLoginStatus(true);
        assertTrue(message.contains("Welcome John Doe"), "Success message should contain welcome text");
    }

    @Test
    public void testFailedLoginMessage() {
        String message = Login.returnLoginStatus(false);
        assertEquals("Username or password incorrect, please try again.", message);
    }
}