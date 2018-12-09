import org.junit.Test;

import static org.junit.Assert.*;

public class CryptoWilkuTest {

    /* applyCrypto method tests */
    @Test
    public void encryptTextLongerThanPassword() {
        String text = "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...";
        String password = "Haslomaslo";
        String expected = "I^o´¢ý©SǔşT?\u000B4*Æ¸QǃŮ9\u0010}3a>>\u0005ǆľf\u0019q5$2{\u0015ƖırF.02$(\fǂĊ\u0015rHc2\u00123Dƃōn[&á º·WǇŘMxrJ³\u009BkEÊ§wRm\".}/YǊĄ}ǃ$ǭ";
        assertEquals(expected, CryptoWilku.applyCrypto(text, password));
    }

    @Test
    public void encryptTextShorterThanPassword() {
        String text = "Krótkitekst";
        String password = "Bardzodlugiehaslo";
        String expected = "\u001E<\tÉ%\u0088\u0098aWyp";
        assertEquals(expected, CryptoWilku.applyCrypto(text, password));
    }

    @Test
    public void encryptTextSameLengthAsPassword() {
        String text = "Tekst";
        String password = "haslo";
        String expected = "rJ±î¬";
        assertEquals(expected, CryptoWilku.applyCrypto(text, password));
    }

    @Test
    public void encryptEmptyText() {
        String text = "";
        String password = "haslo";
        String expected = "";
        assertEquals(expected, CryptoWilku.applyCrypto(text, password));
    }

    /* decrypt method tests */
    @Test
    public void decryptTextLongerThanPassword() {
        String password = "haselko";
        String text = "KDTǃ\tŦ\u0012P\u001E&ǹ5ŵ>]";
        String expected = "TajnyTekstTekst";
        assertEquals(expected, CryptoWilku.applyCrypto(text, password));
    }

    @Test
    public void decryptTextShorterThanPassword() {
        String password = "haselko";
        String text = "K`mǹ";
        String expected = "TEST";
        assertEquals(expected, CryptoWilku.applyCrypto(text, password));
    }

    @Test
    public void decryptTextSameLengthAsPassword() {
        String password = "bardzotajnehaselko";
        String text = "h\u007FÒÖ\u0090*4\u009AaËÊ¥ŎƷĵƹ½:";
        String expected = "tajnawiadomośćdddd";
        assertEquals(expected, CryptoWilku.applyCrypto(text, password));
    }



}