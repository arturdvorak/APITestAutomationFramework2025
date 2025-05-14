package tests;

import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;

public class ProjectTest extends BaseTest {
    private String projectCode;

    @Epic("Projects Management")
    @Feature("Create, Verify, and Delete Project")
    @Story("As a user, I want to create a project and verify its code")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Create a new project, verify it, and then delete it")
    @Description("This test covers project creation, validation via GET, and cleanup via DELETE.")
    public void testCreateProject() {
        projectCode = projectAdapter.addProject(projectFactory.getProject());
        Project result = projectAdapter.getProject(projectCode);
        Assert.assertEquals(result.getCode(), projectCode);
        projectAdapter.deleteProject(projectCode);
    }
}
