<%
import java.text.DateFormat
import java.text.SimpleDateFormat
%>
<STYLE>
BODY, TABLE, TD, TH, P {
  font-family:Verdana,Helvetica,sans serif;
  font-size:11px;
  color:black;
}
h1 { color:black; }
h2 { color:black; }
h3 { color:black; }
TD.bg1 { color:white; background-color:#0000C0; font-size:120% }
TD.bg2 { color:white; background-color:#4040FF; font-size:110% }
TD.bg3 { color:white; background-color:#8080FF; }
TD.test_passed { color:blue; }
TD.test_failed { color:red; }
TD.console { font-family:Courier New; }
.testResultTable {
    text-align: center;

 }
 .headerRow {
     border: none;
     background-color: #F3F3F3;
 }

 .emptyTableCell { background-color: none;}
</STYLE>
<BODY>
<!-- Robot Framework Results -->
<p><h1>Robot Framework Results</h1></p>

<TABLE>
  <TR><TD>Test Results:</TD>
  <TD valign="center"><B><%= build.result == hudson.model.Result.SUCCESS ? "<span style='color:green'>ALL TESTS PASSED</span>" : "<span style='color:#FF3333'>SOME TESTS FAILED OR THE JOB ENCOUNTERED A PROBLEM</span>" %></B></TD></TR>
  <TR><TD>Build URL:</TD><TD><A href="${rooturl}${build.url}">${rooturl}${build.url}</A></TD></TR>
  <TR><TD>Project URL:</TD><TD><A href="${rooturl}${project.url}">${rooturl}${project.url}</A></TD></TR>
  <TR><TD>Build Name:</TD><TD>${build.displayName}</TD></TR>
  <TR><TD>Date of job:</TD><TD>${it.timestampString}</TD></TR>
  <TR><TD>Job duration:</TD><TD>${build.durationString}</TD></TR>
</TABLE>
<BR/>
<p><img src="http://api.giphy.com/v1/gifs/random?api_key=dc6zaTOxFJmzC&tag=fail&rating=g&fmt=html"/></p>
<%
def robotResults = false
def actions = build.actions // List<hudson.model.Action>
actions.each() { action ->
  if( action.class.simpleName.equals("RobotBuildAction") ) { // hudson.plugins.robot.RobotBuildAction
    robotResults = true %>
    <h3>Overall Results</h3>
<p>
    <table cellspacing="0" cellpadding="4" border="1"  class="testResultTable">
        <tr class="headerRow">
            <th>Test Type</th>
            <th>Total</th>
            <th>Pass</th>
            <th>Fail</th>
            <th>Pass %</th>
        </tr>
        <tr>
            <td>Critical Tests</td>
            <td><%= action.getResult().getCriticalTotal() %></td>
            <td><%= action.getResult().getCriticalPassed() %></td>
            <td><%= action.getResult().getCriticalFailed() %></td>
            <td><%= action.getCriticalPassPercentage() %></td>
        <tr>
            <td>All Tests</td>
            <td><%= action.getResult().getOverallTotal() %></td>
            <td><%= action.getResult().getOverallPassed() %></td>
            <td><%= action.getResult().getOverallFailed() %></td>
            <td><%= action.getOverallPassPercentage() %></td>
        </tr>
    </table>
</p>
<h3>Failed Test Cases</h3>
<table cellspacing="0" cellpadding="4" border="1" class="testResultTable">
<thead>
<tr class="headerRow">
  <td><b>Test Name</b></td>
  <td><b>Status</b></td>
</tr>
</thead>
<tbody>
<% def failedResults = action.getResult().getAllFailedCases()
    failedResults.each { test ->
        def currTest = test %>
        <tr>
          <td><%= currTest.displayName %></td>
          <td style="color: #FF3333">FAIL</td>
        </tr>
    <%}%>
</tbody></table>
<p><a href="${rooturl}${build.url}robot-plugin/report.html">Detailed Report</a></p>
<%
  } // robot results
}
if (!robotResults) { %>
<p>No Robot Framework test results found.</p>
<%
} %>

<br />

<!-- CONSOLE OUTPUT -->
<% if(build.result==hudson.model.Result.FAILURE) { %>
<p>See the <a href="${rooturl}${build.url}console">console output</a></p>
<br />
<% } %>

</BODY>

<% boolean allPassed(testResultsArray) {
    testResultsArray.each() { test ->
        if (test.failed == 1) {
            return false
        }
    }
    return true
}
%>
