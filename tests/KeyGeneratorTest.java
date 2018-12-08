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
        String password = "Has";
        String expectedKey = "jX¤";
        assertEquals(expectedKey, (new KeyGenerator(password)).getKeyA());
    }

    @Test
    public void createKeyALongerThan7() {
        String password = "SuperHaslo";
        String expectedKey = "FiXAN2kU4w";
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
        String expectedKey = "aoP>\u008D";
        assertEquals(expectedKey, (new KeyGenerator(password)).getKeyB());
    }

    @Test
    public void createKeyBLongerThan11() {
        String password = "VeryLongPasswd";
        String expectedKey = "Isa?GuoP>BQpq¯";
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
        String password = "TopSecret";
        String expectedKey = "gP]A{{VWI{¬";
        assertEquals(expectedKey, (new KeyGenerator(password)).getKeyC());
    }

    @Test
    public void esincos2() {
    }
}