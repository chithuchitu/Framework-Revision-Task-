Feature:  To Test The Facebook Application Page
Scenario: Test The Create Account and Invalid Credential 
    Given launch The Browser and Enter The Url
    When user Enter The  Invalid Username and Password
    Then  user Click The Login Button
    And user Take ScrrenShot for Wrong Password Page
    Then user Go Back To Home Page
    Then user Click the Create New Accont Button With I478nvalid Data
    And user Take Screenshot For Error Page