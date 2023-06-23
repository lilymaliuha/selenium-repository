# Setup
1. Clone the repository to your local machine:
`git clone https://gitlab.com/testing-tasks/mechanic-advisor-repository.git`

2. Navigate to the project directory using PowerShell/cmd:
`cd your-repository`

3. Install project dependencies using Maven:
`mvn clean install`

# Running the Tests

To run the Selenium Java tests, execute the following Maven command:
`mvn test`
This command will trigger the test execution using the TestNG framework and generate the test reports.

# Test Reports

After running the tests, the test reports will be generated in the target/surefire-reports directory. 
Open the HTML report file (index.html and emailable-report.html) in a web browser to view the detailed test results, including the number of tests 
executed, passed, failed, etc.

# Running the Pipeline

### To run the GitLab CI/CD pipeline, follow these steps:

1. Push your code changes to the GitLab repository.

2. Open the repository in GitLab.

3. Navigate to the CI/CD section or Pipelines tab.

4. You should see the pipeline running automatically, triggered by the code changes.

### Also, you can trigger the pipeline by yourself:

1. Open https://gitlab.com/testing-tasks/mechanic-advisor-repository.

2. In the left menu panel click on the "Build" and after that on the "Pipelines" item.

3. Click on the "Run Pipeline" button and on the opened page again click on the "Run Pipeline" button.

4.Wait for the result of the pipeline run.

