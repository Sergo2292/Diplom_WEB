import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class LoginTest extends AbstractTest {
    Logger logger = LoggerFactory.getLogger(LoginTest.class);
    @BeforeEach
    void  goLogin(){
        getWebDriver().get(getLoginUrl());
    }
    @Test
    @DisplayName("Тест-кейс №1")
    public void logTest1() {
        Page myPage = new Page(getWebDriver());
        myPage.login(getUsername1(), getPassword1());
        assertThat(Page.getHeaderText(), is(equalTo("Hello, " + getUsername1())));
    }
    @Test
    @DisplayName("Тест-кейс №2")
      public void logTest2() {
        Page myPage = new Page(getWebDriver());
        myPage.login(getUsername2(), getPassword2());
        assertThat(myPage.getHeaderText(), is(equalTo("Hello, " + getUsername2())));
    }
    @Test
    @DisplayName("Тест-кейс №3")
      public void logTest3() {
        Page myPage = new Page(getWebDriver());
        myPage.login("", "");
        assertThat(myPage.getErrorCode(), is(equalTo("401")));
    }
    @Test
    @DisplayName("Тест-кейс №4")
      public void logTest4() {
        Page myPage = new Page(getWebDriver());
        myPage.login("", getPassword1());
        assertThat(myPage.getErrorCode(), is(equalTo("401")));
    }
    @Test
    @DisplayName("Тест-кейс №5")
     public void loginTest9() {
        Page myPage = new Page(getWebDriver());
        myPage.login(getUsername1(), "");
        assertThat(myPage.getErrorCode(), is(equalTo("401")));
    }
}
