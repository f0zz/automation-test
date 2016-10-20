***Settings***
Library     Selenium2Library
Resource    resource.robot

***Test Cases***

Go To Google
    Open Browser Using Chrome   http://www.google.com

ABCDEFG
    Open Browser Using Chrome   http://www.google.com
    Click Element    xpath=//h3[@id='wow']
