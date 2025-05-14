package tests;

import models.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;

public class SuiteTest extends BaseTest {
    private int suiteId;
    private String projectCode;
    //private int caseId;

    @Epic("Test Suites Management")
    @Feature("Create, Update, and Delete Suite")
    @Story("As a user, I want to manage test suites within a project")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Create a new suite inside a project, update and delete both")
    @Description("Full lifecycle test: Project -> Suite -> Update Suite -> Delete Suite -> Delete Project")
    public void createNewTestSuite() {
        projectCode = projectAdapter.addProject(projectFactory.getProject());

        Suite suite = suiteFactory.getSuite();
        suiteId = suiteAdapter.addSuite(suite, projectCode).getId();
        Suite actualSuite = suiteAdapter.getSuite(projectCode, suiteId);
        Assert.assertEquals(actualSuite, suite);

        Suite suiteToPut = suiteFactory.getSuiteToPut(suiteId);
        suiteAdapter.updateSuite(projectCode, suiteId, suiteToPut);
        Suite updatedSuite = suiteAdapter.getSuite(projectCode, suiteId);
        Assert.assertEquals(updatedSuite, suiteToPut);

        //caseAdapter.deleteCase(projectCode, caseId);
        suiteAdapter.deleteSuite(projectCode, suiteId);
        projectAdapter.deleteProject(projectCode);
    }
}
