package pageElements_tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Table {

    WebElement table;//получаем опорный элемент внутри которого ведем поиск

    public Table (WebElement table){
        this.table = table;
    }

    public int getRowsCount(){
        return table.findElements(By.tagName("tr")).size();//находим количество строк
    }

    public int getColumnsCount(){
        return table.findElement(By.tagName("tr")).findElements(By.tagName("th")).size();//находим количество ячеек в строке/т.е. количество столбцов
    }

    public WebElement getCell(int x, int y){
        WebElement row = table.findElements(By.tagName("tr")).get(x);//получили строку нужную по индексу X
        WebElement cell;
        if (y==0) {
            cell = row.findElements(By.tagName("th")).get(y);//в первой строке теги th
        }else{
            cell = row.findElements(By.tagName("td")).get(y);//от второй строки и следующих теги td
        }
        return cell;
    }
}
