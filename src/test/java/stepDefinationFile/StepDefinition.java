package stepDefinationFile;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class StepDefinition {

    public pageObject pageobject;

    @Given("^verify the user should be in borrow calculators page$")
    public void verify_the_user_should_be_in_borrow_calculators_page() {
        Assert.assertTrue(pageobject.verifyBorrowerPage());

    }

    @When("^user click on Work out how much I could borrow button$")
    public void user_click_on_Work_out_how_much_I_could_borrow_button(){
        pageobject.clickOnBorrowCalculatorBtn();
    }

    @When("^user click on Start over button$")
    public void user_click_on_Start_over_button() {
        pageobject.clickOnstartOverButton();
    }

    @When("^user enter the annual income (.+) in earnings tab$")
    public void userEnterTheAnnualIncomeInEarningsTab(String annualIncome){
        pageobject.sendDataToAnnualIncome(annualIncome);
    }

    @And("^user enter the annual other income (.+) in earnings tab$")
    public void userEnterTheAnnualOtherIncomeInEarningsTab(String otherIncome){
        pageobject.sendDataAnnualOtherIncome(otherIncome);
    }

    @And("^user enter the Monthly living expenses (.+) in expenses tab$")
    public void userEnterTheMonthlyLivingExpensesInExpensesTab(String expense) {
        pageobject.sendDataExpense(expense);
    }

    @And("^user enter the Other loan monthly repayments (.+) in expenses tab$")
    public void userEnterTheOtherLoanMonthlyRepaymentsInExpensesTab(String repay) {
        pageobject.dataOtherRepayments(repay);
    }

    @And("^user enter the Other monthly commitments (.+) in expenses tab$")
    public void userEnterTheOtherMonthlyCommitmentsInExpensesTab(String credit)  {
        pageobject.dataCreditCardLimits(credit);
    }

    @Then("^user should see error message (.+)")
    public void thenUserShouldSeeErrorMessage(String expectedErrorMsg) {
        Assert.assertEquals(pageobject.getErrorMessage().contains(expectedErrorMsg),
                "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator.");
    }

    @And("^Verify the selected fields as default value stored$")
    public void verifyTheSelectedFieldsAsDefault() {
        Assert.assertTrue(pageobject.verifyDefault());
        pageobject.selectNumberOfDepandent();
        Assert.assertTrue(pageobject.verifyProperty());
    }
}
