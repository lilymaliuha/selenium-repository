# Setup
1. Clone the repository to your local machine:<br>
`git clone https://gitlab.com/testing-tasks/mechanic-advisor-repository.git`

2. Navigate to the project directory using PowerShell/cmd:<br>
`cd your-repository`

3. Install project dependencies using Maven:<br>
`mvn clean install`

# Running Tests Locally 

To run the Selenium Java tests you should:
1. Go to the .env file and enter USERNAME and PASSWORD values.

2. Open BaseTest file and uncomment the first 2 lines and comment the second 2 lines <br>

**_//public String userName = dotenv.get("USERNAME"); //public String password =  dotenv.get("PASSWORD");
public String userName = System.getProperty("userName"); public String password = System.getProperty("password");_**

3. Execute the following Maven command:<br>
`mvn test`

This command will trigger the test execution using the TestNG framework and generate the test reports.

# Test Reports

After running the tests, the test reports will be generated in the target/surefire-reports directory.<br>
Locally you can open the HTML report files (index.html and emailable-report.html) in a web browser to view<br>
the detailed test results, including the number of tests executed, passed, failed, etc.<br>
In GitLab please click on the commit and select the "Tests" tab to verify results.

# Running the Pipeline

### To run the GitLab CI/CD pipeline, follow these steps:

1. Push your code changes to the GitLab repository.

2. Open the repository in GitLab.

3. Navigate to the CI/CD section or Pipelines tab.

4. You should see the pipeline running automatically, triggered by the code changes.

### Also, you can trigger the pipeline by yourself:

1. Open https://gitlab.com/testing-tasks/mechanic-advisor-repository.

2. In the left menu panel click on the "Build" and after that on the "Pipelines" item.

3. There are 2 variables: USERNAME and PASSWORD you can override them on this step.

4. Click on the "Run Pipeline" button and on the opened page again click on the "Run Pipeline" button.

5. Wait for the result of the pipeline run.

