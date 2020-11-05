package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;

public class StatementsAndDocumentsDetailsPage {


    public StatementsAndDocumentsDetailsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Online Statements']")
    private WebElement onlineStatementsTab;

    @FindBy(xpath = "//div[@class='tab-pane active']//tbody//tr")
    private List<WebElement> statementsList;

    public void click_onlineStatementsTab() {
        BrowserUtils.waitElementToBeClickableAndClick(onlineStatementsTab);
    }

    public void click_year(int year) {
        WebElement yearElement = Driver.getDriver().findElement(By.xpath("//a[.='" + year + "']"));
        BrowserUtils.waitElementToBeClickableAndClick(yearElement);
    }

    public int statementsListNumber() {
        return statementsList.size();
    }

    public void click_statement(String statementName) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='" + statementName + "']"));
        BrowserUtils.waitElementToBeClickableAndClick(element);
    }

    public String lastFileName() {
        String downloadPath = "C:\\Users\\47agi\\Downloads";
        File dir = new File(downloadPath);
        File[] files = dir.listFiles();
        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        System.out.println("lastModifiedFile.getName() = " + lastModifiedFile.getName());
        return lastModifiedFile.getName();
    }


}


