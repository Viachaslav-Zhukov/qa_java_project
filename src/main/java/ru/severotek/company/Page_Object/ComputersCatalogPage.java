package ru.severotek.company.Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Создали page object — класс для страницы
public class ComputersCatalogPage {
    //Добавили поле driver
    private final WebDriver driver;
    //Локатор раздела ноутбуки
    private final By laptopsSection = By.xpath(".//a[text()='Ноутбуки']");

    //Добавили конструктор класса page object
    public ComputersCatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод клика для перехода в раздел ноутбуки
    public void clickLaptopsSection() {
        driver.findElement(laptopsSection).click();
    }
}
