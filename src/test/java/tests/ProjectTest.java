package tests;

import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {
    private String projectCode;

    @Test(description = "Create a new project, update project and remove.", enabled = true) //update name
    public void testCreateProject() {
        projectCode = projectAdapter.addProject(projectFactory.getProject());
        Project result = projectAdapter.getProject(projectCode);
        Assert.assertEquals(result.getCode(), projectCode);
        projectAdapter.deleteProject(projectCode);
    }
}
