Use Case:  Generate Report -------------------------------------------------
CHARACTERISTIC INFORMATION
Goal in Context: To generate a specific report from the world database
Scope: World Application
Level:  Primary task
Preconditions: Database is running, data is populated, application is running, user input is functioning.
Success End Condition: User can copy the requested dataset from the terminal into application of choice
Failed End Condition: Application generates an error, no data is returned, application generates incorrect dataset.
Primary Actor: Admin User
Trigger: Keystrokes from user input
 ---------------------------------------
MAIN SUCCESS SCENARIO
1. Application detects user input
2. Application sends a request to the server with the parameters selected in 1.
3. The database returns a dataset based on the supplied request
4. The application displays the returned data correctly in the expected format for the user to copy / use
5. The user is returned to the main menu for further selection
----------------------
RELATED INFORMATION (optional)
Priority: Top priority.
Performance Target: Data should be displayed within 5 seconds of the request being submitted
Frequency: As often as the user desires
Subordinate Use Cases: Country Report Summary
Channel to primary actor: User input from keyboard of the machine running the application.
Secondary Actors: Stakeholders – Authorities and Owners
Channel  to Secondary Actors: Terminal window on monitor of the computer running the application
 ---------------------------
OPEN ISSUES (optional)
1. How will the system recognise the user input?
2. How will the data be displayed?
--------------------------
SCHEDULE Due Date: Version 3.0 release.




Use Case Narrative

User ADMIN needs a report from the world database. She runs the application and waits for the application to initialise.
When the application has initialised and the main menu is shown, the user selects an option.
The user is presented with choices that relate to the selected report (menu 2).
Once the specific report is selected, menu 3 (parameters option) is shown if relevant to the selected report.
Once the parameters are keyed in / selected - the request is sent to the server and the results printed to screen.
The user is returned to the main menu.
