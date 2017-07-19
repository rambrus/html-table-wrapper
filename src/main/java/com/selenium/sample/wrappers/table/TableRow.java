package com.selenium.sample.wrappers.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Robert_Ambrus on 7/18/2017.
 */
public class TableRow {
    private WebElement row;

    public TableRow(WebElement row) {
        this.row = row;
    }

    public String getCellText(By colSelector) {
        return row.findElement(colSelector).getText();
    }

    public void clickCell(By colSelector) {
        row.findElement(colSelector).click();
    }
}
