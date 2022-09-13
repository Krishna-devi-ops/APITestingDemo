package stepDefinationFile;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class pageObject extends BaseClass {

    private final WebDriver driver;
    public BaseClass baseClass;
    @FindBy(xpath = "//title[contains(text(),'Home loan')]")
    WebElement borrowerPage;

    @FindBy(xpath = "//input[@aria-labelledby='q2q1']")
    WebElement annualIncome;

    @FindBy(xpath = "//input[@aria-labelledby='q2q2']")
    WebElement annualOtherIncome;

    @FindBy(xpath = "//input[@aria-labelledby='q3q1']")
    WebElement livingExpenses;

    @FindBy(xpath = "//input[@aria-labelledby='q3q3']")
    WebElement otherRepayments;

    @FindBy(xpath = "//input[@aria-labelledby='q3q5']")
    WebElement creditCardLimits;

    @FindBy(xpath = "//button[@id='btnBorrowCalculater']")
    WebElement clickOnborrowBtn;

    @FindBy(xpath = "//div[@class='borrow__error__text']")
    WebElement verifyErrorMsg;

    @FindBy(xpath = "//div[contains(@class,'borrow__error--textcontainer')]//button[@class='start-over']")
    WebElement clickOnStartOverBtn;

    @FindBy(xpath = "//label[contains(text(),'Single')]")
    WebElement appType;


    @FindBy(xpath = "//label[contains(text(),'Home to live')]")
    WebElement propertyLiked;

    @FindBy(xpath = "//select[@title='Number of dependants']//option")
    List<WebElement> numberOfDependants;


    public pageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        baseClass.setup();
    }

    public boolean verifyBorrowerPage() {
        return borrowerPage.isDisplayed();
    }

    public boolean verifyDefault() {
        return appType.isSelected();
    }

    public WebElement selectNumberOfDepandent(){
        List<WebElement> list=null;
        list=driver.findElements(By.xpath(String.valueOf(numberOfDependants)));
        for(WebElement number:list) {
            if (number.equals("0")) {
                return number;
            }
        } return (WebElement) list;
    }

    public boolean verifyProperty(){
        return propertyLiked.isSelected();
    }

    public void sendDataToAnnualIncome(String income) {
        annualIncome.sendKeys(income);
    }

    public void sendDataAnnualOtherIncome(String otherIncome) {
        annualOtherIncome.sendKeys(otherIncome);
    }

    public void sendDataExpense(String expense) {
        livingExpenses.sendKeys(expense);
    }

    public void dataOtherRepayments(String repay) {
        otherRepayments.sendKeys(repay);
    }

    public void dataCreditCardLimits(String credit) {
        creditCardLimits.sendKeys(credit);
    }

    public void clickOnBorrowCalculatorBtn() {
        clickOnborrowBtn.click();
    }

    public String getErrorMessage() {
        return verifyErrorMsg.getText();
    }

    public void clickOnstartOverButton() {
        clickOnStartOverBtn.click();
    }
}
