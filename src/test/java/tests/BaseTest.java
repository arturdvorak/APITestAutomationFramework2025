package tests;

import Utils.PropertyReader;
import adapters.ProjectAdapter;
import adapters.SuiteAdapter;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import models.ProjectFactory;
import models.SuiteFactory;
import org.testng.annotations.BeforeTest;

import java.util.Locale;

public abstract class BaseTest {
    protected ProjectAdapter projectAdapter;
    protected ProjectFactory projectFactory;
    protected SuiteAdapter suiteAdapter;
    protected SuiteFactory suiteFactory;
    protected static Faker usFaker;

    @BeforeTest(description = "TBD")
    public void setUp() {
        RestAssured.baseURI =  System.getProperty("url", PropertyReader.getProperty("url"));
        projectAdapter = new ProjectAdapter();
        projectFactory = new ProjectFactory();
        suiteAdapter = new SuiteAdapter();
        suiteFactory = new SuiteFactory();
        usFaker = new Faker(new Locale("en-US"));
    }
}
