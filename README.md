# Automation Test Project for Miro micro services

This is Demo project to Automate Miro micro serves. Automate the Mico application to create the Sticker on canvas. That
automation has been done using Selenium WebDriver and Java. Few services are implement using rest assured and Java.

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
In Base class, I have implemented all prerequisite to perform the automation on web page or api services. I am reading the properties file here and initialing extent report object  or variables. I have set the property for the chrome driver also in base class. 

## POM Implementation

I have created two class for every web page like **AcLogin** and **PgLogin** for Login page. I have created separate
package for the **action** classes and **page** classes. Similarly, I have created separate package for APIs method name
as **apiCalls**. Some common methods we have used in our script, So we have put all related method in common package.
Report implementation or report related and screenshot methods are in common package itself.
All the reusable created in main/java dir.

- src/main/java/com/miro/actions
- src/main/java/com/miro/page
- src/main/java/com/miro/apiCalls
- src/main/java/com/miro/common   etc.

## Test case / Test classes

We have only test case, So I have created only @Test method to create Sticker as **createSticker** in class **MiroAutomationTest**

### Test Class location
**src/test/java/com/miro/web/test/MiroAutomationTest**


## Test Suite
I have created a test suite to execute our script. Suite name is suite.xml.
Suite is situated at 
**test/resources/suite.xml**

## Credential JSON file
I have used a json file for the user1 and user2 and I have created a method in Base test class to initialize username and password variables.
Method name : **readJSONFile**
readJSONFile method is parameterized. file path should be pass here to login.
I have used for only two users.

# How to run the test case

As discussed that we have only test class and only test case,so we can execute using **suite.xml** file.
Once the execution is finish, we can see the generated extent report at below location

DemoProject\test-output

Report is generating with date time formate and html extension like
**MiroReport_21_04_2022_13_00_12.html**

Similarly, captured screenshot would be in dd_MM_yyyy format like
**sticker_21_04_2022.png** with .png extension.
