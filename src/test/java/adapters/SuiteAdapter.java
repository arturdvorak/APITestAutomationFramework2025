package adapters;

import com.google.gson.reflect.TypeToken;
import io.restassured.response.Response;
import models.ErrorFields;
import models.ErrorResult;
import models.Result;
import models.Suite;
import org.testng.Assert;
import io.qameta.allure.*;

import java.util.ArrayList;

public class SuiteAdapter extends BaseAdapter{
    String uriAdd = "suite/";

    @Step("Create a suite with title: {suite.title}")
    public Suite addSuite(Suite suite, String projectCode) {
        Response response = post(uriAdd + projectCode, gson.toJson(suite), 200);
        Result<Suite> result = gson.fromJson(response.asString(),
                new TypeToken<Result<Suite>>(){}.getType());
        Assert.assertTrue(result.isStatus());
        return result.getResult();
    }

    public ArrayList<ErrorFields> addSuite(Suite suite, String projectCode, boolean status, int expectedStatusCode) {
        Response response = post(uriAdd + projectCode, gson.toJson(suite), expectedStatusCode);
        ErrorResult result = gson.fromJson(response.asString(), ErrorResult.class);
        Assert.assertEquals(result.isStatus(), status);
        return result.getErrorFields();
    }

    @Step("Update suite {suiteId} in project {projectCode}")
    public Suite getSuite(String projectCode, int suiteId) {
        Response response = get(uriAdd + projectCode + "/" + suiteId,200);
        Result<Suite> result = gson.fromJson(response.asString(),
                new TypeToken<Result<Suite>>(){}.getType());
        return result.getResult();
    }

    @Step("Update suite {suiteId} in project {projectCode}")
    public void updateSuite(String projectCode, int suiteId, Suite suiteToPut) {
        Response response = patch(uriAdd + projectCode + "/" + suiteId, gson.toJson(suiteToPut), 200);
        Result<Suite> result = gson.fromJson(response.asString(),
                new TypeToken<Result<Suite>>(){}.getType());
        Assert.assertTrue(result.isStatus());
    }

    @Step("Delete suite {suiteId} from project {projectCode}")
    public void deleteSuite(String projectCode, int suiteId) {
        Response response = delete(uriAdd + projectCode + "/" + suiteId, 200);
        Result<Suite> result = gson.fromJson(response.asString(),
                new TypeToken<Result<Suite>>(){}.getType());
        Assert.assertTrue(result.isStatus());
    }
}
