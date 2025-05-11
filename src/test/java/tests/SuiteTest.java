package tests;

import models.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuiteTest extends BaseTest {
    private int suiteId;
    private String projectCode;
    //private int caseId;

    @Test(description = "Create a new project, a new suite and a new test case and remove all of them", enabled = true) //update name
    public void createNewTestSuiteAndTestCase() {
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
