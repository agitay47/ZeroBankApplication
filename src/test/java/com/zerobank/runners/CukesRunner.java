package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {//"pretty", "json:target/JSONReports/report.json",
//                "junit:target/JUnitReports/report.xml",
//                "html:target/HtmlReports",
//                "rerun:target/rerun.txt",
//                "html:target/cucumber-report.html"
                "json:target/cucumber.json"},
        features = "src/test/resources/features",
        glue = "com/zerobank/stepdefinitions",
        dryRun =false,
        tags = "@SD"
)


public class CukesRunner {
}
