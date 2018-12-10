package cryptoWilku;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
    public void createKeyA() {
        String password = "SuperHaslo";
        String expectedKey = "N2kU4DFiX\u0080";
        assertEquals(expectedKey, (new KeyGenerator(password)).getKeyA());
    }

    /* Generating keyB tests */
    @Test
    public void createKeyB() {
        String password = "VeryLongPasswd";
        String expectedKey = "BQpqUIsa?GuoP¦";
        assertEquals(expectedKey, (new KeyGenerator(password)).getKeyB());
    }

    /* Generating keyC tests */
    @Test
    public void createKeyC() {
        String password = "SuperTajneHaslo";
        String expectedKey = "D\u001F\u008E¦P%\u0006wÃïtT\u008Azÿ";
        assertEquals(expectedKey, (new KeyGenerator(password)).getKeyC());
    }

    /* esincos2 method tests */
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

    /* createSubKey method tests */
    @Test
    public void createSubKeySeedPositive(){
        String password = "Haslo";
        int seed = 5;
        String expectedSubKey = "\u001AƭŚĿŷ";
        assertEquals(expectedSubKey, new KeyGenerator(password).createSubKey(seed));
    }

    @Test
    public void createSubKeySeedNegative(){
        String password = "Haslo";
        int seed = -11;
        String expectedSubKey = "ú\u00ADúğǇ";
        assertEquals(expectedSubKey, new KeyGenerator(password).createSubKey(seed));
    }

    @Test
    public void createSubKeySeedZero(){
        String password = "Haslo";
        int seed = 0;
        String expectedSubKey = "æ¯úĝǘ";
        assertEquals(expectedSubKey, new KeyGenerator(password).createSubKey(seed));
    }

}