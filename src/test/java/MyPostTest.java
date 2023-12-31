
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyPostTest extends AbstractTest{
    Logger logger = LoggerFactory.getLogger(MyPostTest.class);
    @BeforeEach
    void myPosts() {
        getWebDriver().get(getPostsUrl());
    }
    @Test
    @DisplayName("Тест-кейс №1")
   // @Description("Check default sort at the 1st page")
    public void myPostsTest1() {
        Page myPage = new Page(getWebDriver());
        myPage.login(getUsername1(), getPassword1());
        assertTrue(myPage.checkBtnPage());
        assertThat(myPage.getTitleFirstPostFirstPage(), is(equalTo("Пост 5 - последний")));
    }

    @Test
    @DisplayName("Тест-кейс №2")

    public void myPostsTest2() {
        Page myPage = new Page(getWebDriver());
        myPage.login(getUsername1(), getPassword1());
        assertTrue(!myPage.checkBtnNextPage());
    }
    @Test
    @DisplayName("Тест-кейс №3")
    public void myPostsTest3() {
        Page myPage = new Page(getWebDriver());
        myPage.login(getUsername1(), getPassword1());
        assertThat(myPage.countPosts(), is(equalTo(10)));
        logger.error("Тест-кейс 3 провален");
    }
    @Test
    @DisplayName("Тест-кейс №4")
        public void myPostsTest4() {
        Page myPage = new Page(getWebDriver());
        myPage
                .login(getUsername1(), getPassword1())
                .goToNextPage();
        getWait().until(ExpectedConditions.urlToBe(myPage.getUrlNextPage()));
        assertThat(getWebDriver().getCurrentUrl(), is(equalTo(myPage.getUrlNextPage())));
    }
    @Test
    @DisplayName("Тест-кейс №5")
       public void myPostsTest5() {
        Page myPage = new Page(getWebDriver());
        myPage
                .login(getUsername1(), getPassword1())
                .getOrderDESC();
        assertThat(getWebDriver().getCurrentUrl(), is(equalTo(myPage.getUrlDESC())));
        assertThat(myPage.getTitleFirstPostFirstPage(), is(equalTo("Пост 5 последний")));
    }
}
