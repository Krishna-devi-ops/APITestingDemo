
Feature: calculate the personal expense

  @krishna
  Scenario Outline:user input the expense values and calculate
    Given verify the user should be in borrow calculators page
    And Verify the selected fields as default value stored
    When user enter the annual income "<amount>" in earnings tab
    And user enter the annual other income "<amount>" in earnings tab
    And user enter the Monthly living expenses "<amount>" in expenses tab
    And user enter the Other loan monthly repayments "<amount>" in expenses tab
    And user enter the Other monthly commitments "<amount>" in expenses tab
    And user click on Work out how much I could borrow button
    Then user should see error message "Based on the details.."
    When user click on Start over button
    And user enter the Monthly living expenses "1" in expenses tab
    And user click on Work out how much I could borrow button
    Then user should see error message "Based on the details.."

    Examples:
      | amount |
      | 80000  |
      | 10000  |
      | 500    |
      | 100    |
      | 10000  |
