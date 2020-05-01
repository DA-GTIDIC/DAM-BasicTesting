package cat.udl.tidic.amd.dam_basictesting;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

@RunWith(AndroidJUnit4.class)
public class LoginUtilsTest {
    @Test
    public void validAddressPasses() throws Exception {
        assertTrue(LoginUtils.isValidEmailAddress("xxx@hotmail.com"));
    }
    @Test
    public void invalidGmailAddressPasses() throws Exception {
        assertFalse(LoginUtils.isValidGmailAddress("xxx@hotmail.com"));
    }
    @Test
    public void validGmailAddressPasses() throws Exception {
        assertTrue(LoginUtils.isValidGmailAddress("xxx@gmail.com"));
    }
    @Test
    public void validUsernamePasses() throws Exception {
        assertTrue(LoginUtils.getUserName("xxx@gmail.com"));
        assertTrue(LoginUtils.getUserName("hol1x@gmail.com"));
    }
    @Test
    public void invalidUsernamePasses() throws Exception {
        assertFalse(LoginUtils.getUserName("x@x+``x@gmail.com"));
        assertFalse(LoginUtils.getUserName("x+`--?`x@gmail.com"));
    }


}