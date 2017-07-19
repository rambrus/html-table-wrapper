package com.selenium.sample.pageobjects;

import com.selenium.sample.wrappers.table.Table;
import com.selenium.sample.wrappers.table.TableRow;
import com.selenium.sample.wrappers.table.TableRowCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Robert_Ambrus on 7/18/2017.
 */
public class TestPage {
    public static final By COMPANY_COL_SELECTOR = By.id("companyColumn");
    public static final By CONTACT_COL_SELECTOR = By.id("contactColumn");
    public static final By COUNTRY_COL_SELECTOR = By.id("countryColumn");
    public static final By WEBSITE_COL_SELECTOR = By.cssSelector("#websiteColumn a");

    @FindBy(id = "myTable")
    private WebElement tableElement;
    private Table table;

    public TestPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.table = new Table(tableElement);
    }

    public String getCompanyContact(String company) {
        return findCompanyRow(company).getCellText(CONTACT_COL_SELECTOR);
    }

    public String getCompanyCountry(String company) {
        return findCompanyRow(company).getCellText(COUNTRY_COL_SELECTOR);
    }

    public void openWebsite(String company) {
        findCompanyRow(company).clickCell(WEBSITE_COL_SELECTOR);
    }

    private TableRow findCompanyRow(String company) {
        return table.findRow(TableRowCondition.columnEquals(COMPANY_COL_SELECTOR, company)).orElseThrow(() -> new IllegalStateException("Company not found!"));
    }
}
