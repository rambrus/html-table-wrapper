package com.selenium.sample.wrappers.table;

import org.openqa.selenium.By;

import java.util.function.Predicate;

/**
 * Created by Robert_Ambrus on 7/18/2017.
 */
public class TableRowCondition {
    private TableRowCondition() {
    }

    public static Predicate<TableRow> columnEquals(By colSelector, String value) {
        return row -> value.equals(row.getCellText(colSelector));
    }
}
