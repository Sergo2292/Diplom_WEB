import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class Page extends AbstractPage{
    private final String urlPage = "https://test-stand.gb.ru/";
    private final String urlNextPage = "https://test-stand.gb.ru/?page=2";
       private final String urlDESC = "https://test-stand.gb.ru/?sort=createdAt&order=DESC";

    public Page(WebDriver driver) {
        super(driver);
    }

    public String getUrlNextPage() {
        return urlNextPage;
    }

    public String getUrlDESC() {
        return urlDESC;
    }



    @FindBy(xpath = "//li[3]/a")
    private static WebElement userNameLink;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement inputUsername;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[@form='login']")
    private WebElement btnLogin;
    @FindBy(xpath = "//li[3]/span[2]")
    private WebElement btnLogout;
    @FindBy(xpath = "//h2")
    private WebElement errorCode;
    @FindBy(xpath = "//p")
    private WebElement errorMessage;


    @FindBy(css = ".post.svelte-127jg4t")
    private List<WebElement> allPosts;
    @FindBy(xpath = "//img")
    private WebElement testImage;
    @FindBy(xpath = "//a[1]/h2")
    private WebElement testTitleFirstPostFirstPage;
    @FindBy(xpath = "//a[3]/h2")
    private WebElement testTitleFirstPostLastPage;
    @FindBy(xpath = "//a/div")
    private WebElement testDescription;
    @FindBy(xpath = "//p")
    private WebElement noPostsMessage;
    @FindBy(xpath = "//div[2]/div/a[2]")
    private WebElement btnNextPage;
    @FindBy(css = ".disabled:nth-child(2)")
    private WebElement btnNextPageDisabled;
    @FindBy(xpath = "//div[2]/div/a")
    private WebElement btnPrevPage;
    @FindBy(css = ".disabled")
    private WebElement btnPageDisabled;
    @FindBy(xpath = "//i")
    private WebElement btnOrderASC;
    @FindBy(xpath = "//i[2]")
    private WebElement btnOrderDESC;
    @FindBy(xpath = "//*[@id=\"SMUI-form-field-1\"]")
    private WebElement btnNotMyPosts;
    public int countPosts() {
        return allPosts.size();
    }
    public boolean checkBtnPage() {
        try {
            return btnPageDisabled.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean checkBtnNextPage() {
        try {
            return btnNextPageDisabled.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public Page goToNextPage() {
        btnNextPage.click();
        return this;
    }

    public Page getOrderDESC() {
        btnOrderDESC.click();
        return this;
    }

    public String getTitleFirstPostFirstPage() {
        return testTitleFirstPostFirstPage.getText().trim();
    }

    public Page login(String username, String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        btnLogin.click();
        return this;
    }


    public static String getHeaderText() {
        return userNameLink.getText().trim();
    }

    public String getErrorCode() {
        return errorCode.getText().trim();
    }
}
