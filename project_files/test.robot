***Settings***
Library             Selenium2Library        implicit_wait=5     timeout=10      run_on_failure=Nothing
Resource            resource.robot
Suite Teardown      Close All Browsers
***Test Cases***

Go To Google
    Open Browser Using Chrome   http://www.google.com



Test 1
    Open Browser Using Chrome   http://www.google.com

Test 2
    Open Browser Using Chrome   http://www.google.com

Test 3
    Open Browser Using Chrome   http://www.google.com

Test 4
    Open Browser Using Chrome   http://www.google.com
