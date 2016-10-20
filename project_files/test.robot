***Settings***
Library     Selenium2Library
Resource    resource.robot

***Test Cases***
Go To Google
    Open Browser Using Chrome   http://www.google.com

This Should Fail
    Open Browser Using Chrome   http://www.google.compile
    Wait Until Page Contains Element    xpath=//h3[@id='wow']    10
