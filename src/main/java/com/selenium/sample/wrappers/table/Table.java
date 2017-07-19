package com.selenium.sample.wrappers.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Robert_Ambrus on 7/18/2017.
 */
public class Table {
    private static final By TABLE_ROW_SELECTOR = By.cssSelector("tr");
    public static final By TABLE_COL_SELECTOR = By.cssSelector("td");
    public static final Predicate<WebElement> HAS_COLUMN = r -> r.findElements(TABLE_COL_SELECTOR).size() > 0;

    private WebElement table;

    public Table(WebElement table) {
        this.table = table;
    }

    public List<TableRow> rows() {
        return table.findElements(TABLE_ROW_SELECTOR).stream().filter(HAS_COLUMN).map(rowElement -> new TableRow(rowElement)).collect(Collectors.toList());
    }

    public Optional<TableRow> findRow(Predicate<TableRow> predicate) {
        return rows().stream().filter(predicate).findFirst();
    }
}
