
# Naukri.com Automation Project

### How To Clone:

1. Create a project in your local system:  
   **Project Name:** `GitCloneNaukri`
   
2. Open Git Bash terminal and run the following commands:

   ```bash
   git init
   git clone https://github.com/SiddheshVedre/Naukri_Automation.git
   ```

3. Refresh your project and move all files from the `Naukri_Automation` folder to the newly created Java Project `GitCloneNaukri`.

4. Right-click on `GitCloneNaukri` folder in your IDE, then:
   - Click on **Configure**
   - Click on **Convert to Maven Project**

Your setup is now done.

---

### How To Use This Project:

1. Open the `Naukri_Automation_Details.xlsx` file:  
   `/NaukriTesting/TestData/Naukri_Automation_Details.xlsx`

2. Edit the details accordingly:
   - **Username**
   - **Password**
   - **Designation**
   - **Location**
   - **Applications**
   - **Experience**

3. Save the Excel file.

4. Run the `Run_Naurki_Automation.xml` file as a TestNG suite:  
   `/NaukriTesting/Run_Naurki_Automation.xml`

---

### What Does Test Case `TC001_JobSearchTest` Do?

1. Opens Naukri.com on the Chrome browser.
2. Logs in automatically using the **username** and **password** from the Excel file.
3. Fills in the details from the Excel file:
   - **Designation**
   - **Location**
   - **Experience**
4. Opens job applications based on the number of **applications** specified.
5. Automatically clicks the **Apply** button for each job.

You can manually fill in the form that pops up on the **Job Submit Page**.
