This is the Naukri.com Automation Project...

How To Clone :
<1> Create Normal Project in your Local System [Name: GitCloneNaukri]
<2> Open git bash terminal
<3> git init
<4> git clone https://github.com/SiddheshVedre/Naukri_Automation.git
<5> Refresh and Move all Naukri_Automation folder's files to the created folder [GitCloneNaukri]
<6> Right Click on [GitCloneNaukri] and > click on "Configure" > click on "Convert to Maven Project"

...The setup is Done...

How To Use this Project : 
<1> Open Naukri_Automation_Details Excel file          >   /NaukriTesting/TestData/Naukri_Automation_Details.xlsx
<2> Edit Details Accordingly : username, password, designation, Location, applications, experience
<3> Save file
<4> Run xml file Run_Naurki_Automation as TestNG Suite >   /NaukriTesting/Run_Naurki_Automation.xml

What >TC001_JobSearchTest< Test Do...
<1> Open Naukri.com on Chrome Browser
<2> Login Automatically using  >username & password<
<3> Filling all the details you provided in Excel file as per you provided  >designation, Location, experience<  
<4> Opening Job Applications as per you provided  >applications<
<5> Click Apply Button Automatically

...Then you can Fill the form Mannually that popup on JobSubmitPage...