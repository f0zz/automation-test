***Settings***
Library     Selenium2Library
Resource    resource.robot

***Test Cases***

Go To Google
    Open Browser Using Chrome   http://www.google.com

Go To Yahoo
    Open Browser Using Chrome   http://www.yahoo.com
    Element Should Be Visible   xpath=//h3[@id='wow']      
