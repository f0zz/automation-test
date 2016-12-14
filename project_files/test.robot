***Settings***
Library             Selenium2Library        implicit_wait=5     timeout=10      run_on_failure=Nothing
Resource            resource.robot
Suite Teardown      Close All Browsers
***Test Cases***

Go To Google
    [Tags]      @mgiardina
    Open Browser Using Chrome   http://www.google.com

Go To Yahoo
    [Tags]      @acalandra
    Open Browser Using Chrome   http://www.yahoo.com
    Element Should Be Visible   xpath=//h3[@id='wow']

Go To Blah
    [Tags]      @cscarborough
    Open Browser Using Chrome   http://www.yahoo.com
    Element Should Be Visible   xpath=//h3[@id='wow']

Test 1
    [Tags]      @jochoa
    Open Browser Using Chrome   http://www.google.com

Test 2
    [Tags]      @dhaecker
    Open Browser Using Chrome   http://www.google.com

Test 3
    [Tags]      @jmartinez
    Open Browser Using Chrome   http://www.google.com

Test 4
    [Tags]      @rhendrickson
    Open Browser Using Chrome   http://www.google.com
