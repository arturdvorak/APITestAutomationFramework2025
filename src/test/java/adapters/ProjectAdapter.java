package adapters;

import com.google.gson.reflect.TypeToken;
import io.restassured.response.Response;
import models.Project;
import models.Result;
import org.testng.Assert;
import static org.hamcrest.CoreMatchers.equalTo;

public class ProjectAdapter extends BaseAdapter {
    String uriAdd = "project";

    public String addProject(Project project) {
        Response response =  post(uriAdd, gson.toJson(project), 200);
        //response.body().path("status", String.valueOf(equalTo("true")));
        return response.body().path("result.code");
    }

    public Project getProject(String projectCode) {
        Response response = get(uriAdd + "/" + projectCode,200);
        Result<Project> result = gson.fromJson(response.asString(),
                new TypeToken<Result<Project>>(){}.getType());
        return result.getResult();
    }

    public void updateProject(String projectCode, Project projectToPut) {
        Response response = patch(uriAdd + "/" + projectCode, gson.toJson(projectToPut), 200);
        Result<Project> result = gson.fromJson(response.asString(),
                new TypeToken<Result<Project>>(){}.getType());
        Assert.assertTrue(result.isStatus());
    }

    public void deleteProject(String projectCode) {
        Response response = delete(uriAdd + "/" + projectCode, 200);
        Result<Project> result = gson.fromJson(response.asString(),
                new TypeToken<Result<Project>>(){}.getType());
        Assert.assertTrue(result.isStatus());
    }

/*    public static CreateProjectResponse creteNewProject(CreateProjectRequest rq) {
        return
                given()
                        .spec(headerRequest)
                        .log().all()
                        .body(rq)
                        .when()
                        .post("https://api.qase.io/v1/project")
                        .then()
                        .log().all()
                        .extract().as(CreateProjectResponse.class);
    } */
}
