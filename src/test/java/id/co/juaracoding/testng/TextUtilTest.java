package id.co.juaracoding.testng;

import id.co.juaracoding.util.TextUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextUtilTest {

    @BeforeClass
    public void setUp() {
        System.out.println("Inisialisasi pengujian TextUtilTest...");
    }

    @Test
    public void is_palindrome_returns_true_for_racecar() {
        boolean result = TextUtil.isPalindrome("racecar");
        Assert.assertTrue(result, "kata 'racecar' seharusnya terdeteksi sebagai palindrome");
    }

    @Test
    public void is_palindrome_returns_false_for_null_input() {
        boolean result = TextUtil.isPalindrome(null);
        Assert.assertFalse(result, "input null pada isPalindrome seharusnya menghasilkan false");
    }

    @Test
    public void count_vowels_returns_correct_count_for_normal_text() {
        int result = TextUtil.countVowels("juaracoding");
        Assert.assertEquals(result, 5, "jumlah vokal pada kata 'juaracoding' seharusnya 5");
    }

    @Test
    public void count_vowels_returns_zero_for_null_input() {
        int result = TextUtil.countVowels(null);
        Assert.assertEquals(result, 0, "jumlah vokal pada input null seharusnya 0");
    }
}
