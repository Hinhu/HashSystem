import org.junit.Test;

import static org.junit.Assert.*;

public class KeyGeneratorTest {

    /* Constructor tests */
    @Test(expected = IllegalArgumentException.class)
    public void emptyPasswordInConstructor(){
        new KeyGenerator("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooShortPasswordInConstructor(){
        new KeyGenerator("ab");
    }

    /* Generating keyA tests */
    @Test
    public void createKeyAShorterThan7() {
        String password = "Haslo";
        String expectedKey = "N2VX\u0080";
        assertEquals(expectedKey, (new KeyGenerator(password)).getKeyA());
    }

    @Test
    public void createKeyALongerThan7() {
        String password = "SuperHaslo";
        String expectedKey = "N2kU4DFiX\u0080";
        assertEquals(expectedKey, (new KeyGenerator(password)).getKeyA());
    }

    @Test
    public void createKeyALengthEquals7() {
        String password = "HaselkO";
        String expectedKey = "XAE86Sx";
        assertEquals(expectedKey, (new KeyGenerator(password)).getKeyA());
    }

    /* Generating keyB tests */
    @Test
    public void createKeyBShorterThan11() {
        String password = "Passs";
        String expectedKey = "P>>a\u009B";
        assertEquals(expectedKey, (new KeyGenerator(password)).getKeyB());
    }

    @Test
    public void createKeyBLongerThan11() {
        String password = "VeryLongPasswd";
        String expectedKey = "BQpqUIsa?GuoP¦";
        assertEquals(expectedKey, (new KeyGenerator(password)).getKeyB());
    }

    @Test
    public void createKeyBLengthEquals11() {
        String password = "HasloRowneX";
        String expectedKey = "gP]A{{VWI{¬";
        assertEquals(expectedKey, (new KeyGenerator(password)).getKeyB());
    }

    /* Generating keyC tests */
    @Test
    public void createKeyC() {
        String password = "SuperTajneHaslo";
        String expectedKey = "D\u001F\u008E¦P%\u0006wÃïtT\u008Azÿ";
        assertEquals(expectedKey, (new KeyGenerator(password)).getKeyC());
    }

    @Test
    public void esincos2PositiveValue() {
        int i = 25;
        int expectedValue = 90;
        assertEquals(expectedValue, new KeyGenerator("PasswordDoesntMatter").esincos2(i));
    }

    @Test
    public void esincos2NegativeValue() {
        int i = -200;
        int expectedValue = 116;
        assertEquals(expectedValue, new KeyGenerator("PasswordDoesntMatter").esincos2(i));
    }

    @Test
    public void esincos2ZeroValue() {
        int i = 0;
        int expectedValue = 100;
        assertEquals(expectedValue, new KeyGenerator("PasswordDoesntMatter").esincos2(i));
    }
}