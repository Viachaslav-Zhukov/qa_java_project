package ru.severotek.company.Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Создали page object — класс для страницы
public class MainPageElements {
    // Добавили поле driver
    private final WebDriver driver;
    // Локатор копки каталога товаров
    private final By catalogButton = By.id("catalogPopupButton");
    // Локатор раздела "Компьютеры"
    private final By computersSection = By.xpath(".//span[text()='Компьютеры']");

    // Добавили конструктор класса page object
    public MainPageElements(WebDriver driver) {
        this.driver = driver;
    }

    // Метод проверяет, активна ли кнопка каталога товаров
    public boolean checkCatalogButton() {
        return driver.findElement(catalogButton).isEnabled();
    }

    // Метод клика по кнопке каталога
    public void clickCatalogButton() {
        driver.findElement(catalogButton).click();
    }

    // Метод клика по разделу «Компьютеры»
    public void clickComputersSection() {
        driver.findElement(computersSection).click();
    }

}
