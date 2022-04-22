# Automation Test Project for Miro micro services

This is a Demo project to Automate Miro micro services. Automate the Mico application to create the Sticker on canvas. That
automation has been done using Selenium WebDriver and Java. Few services are implemented using rest assured and Java.
## Used Framework and Approach

### Configuration as below

* Programming language         - JAVA
* GUI Automation tool/Suite    - Selenium WebDriver
* Build tool                   - Maven
* Report                       - Extent Report 3
* API Automation library       - Rest assured
* Framework and Annotations    - TestNG
* Framework model approach     - Page Object Model
* Java Editor                  - IntelliJ IDEA

## Base class
In Base class, I have implemented all prerequisites to perform the automation on web page or api services. I am reading the properties file here and initializing the extent report object or variables. I have set the property for the chrome driver also in base class. 

## POM Implementation

I have created two classes for every web page like **AcLogin** and **PgLogin** for the Login page. I have created separate
packages for the **action** classes and **page** classes. Similarly, I have created a separate package for APIs methods namely
as **apiCalls**. Some common methods we have used in our script, So we have put all related methods in a common package.
Report implementation or report related and screenshot methods are in the common package itself.
All the reusable created in main/java dir.

- src/main/java/com/miro/actions
- src/main/java/com/miro/page
- src/main/java/com/miro/apiCalls
- src/main/java/com/miro/common   etc.

I have used two variables **cookies** and **token**. We need to update once while the session has expired.

## Test case / Test classes

We have only test case, So I have created only @Test method to create Sticker as **createSticker** in class **MiroAutomationTest**

### Test Class location
**src/test/java/com/miro/web/test/MiroAutomationTest**


## Test Suite
I have created a test suite to execute our script. The suite name is suite.xml.
Suite is situated at
**test/resources/suite.xml**

## Credential JSON file
I have used a json file for the user1 and user2 and I have created a method in Base test class to initialize username and password variables.
Method name : **readJSONFile**
readJSONFile method is parameterized. file path should be passed here to login.
I have used it for only two users.

# How to run the test case
Before executing / running the script, we need to update the two variables values namely **token** and **cookies** as per current session of web application.
As discussed, we have only test class and only test case,so we can execute using **suite.xml** file.
Once the execution has finished, we can see the generated extent report at below location 

DemoProject\test-output

Report is generating with date time format and html extension like
**MiroReport_21_04_2022_13_00_12.html**

Similarly, captured screenshot would be in dd_MM_yyyy format like
**sticker_21_04_2022.png** with .png extension.
