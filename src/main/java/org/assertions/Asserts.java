package org.assertions;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

public class Asserts {
    public void intsAreEqual(int actualInt, int expectedInt){
        assertEquals(actualInt,expectedInt,"Found "+ actualInt+", but expected to found "+expectedInt);
    }
    public void StringAreEqual(String actualString, String expectedString){
        assertEquals(actualString,expectedString,"Found "+ actualString+", but expected to found "+expectedString);
    }
    public void intsNotEqual(int actualInt, int expectedInt){
        assertNotEquals(actualInt,expectedInt,actualInt+" shouldn't match expected value "+expectedInt);
    }
    public void StringNotEqual(String actualString, String expectedString){
        assertNotEquals(actualString,expectedString, actualString+" shouldn't match expected value "+expectedString);
    }

    public void assertText(WebElement element, String text){

    }
}
