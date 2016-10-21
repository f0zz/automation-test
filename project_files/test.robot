***Settings***
Library             Selenium2Library        implicit_wait=5     timeout=10      run_on_failure=Nothing
Resource            resource.robot
Suite Teardown      Close All Browsers
***Test Cases***

Go To Google
    Open Browser Using Chrome   http://www.google.com

Go To Yahoo
    Open Browser Using Chrome   http://www.yahoo.com
    Element Should Be Visible   xpath=//h3[@id='wow']

Go To Blah
    Open Browser Using Chrome   http://www.yahoo.com
    Element Should Be Visible   xpath=//h3[@id='wow']
