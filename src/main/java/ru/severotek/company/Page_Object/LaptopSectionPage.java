package ru.severotek.company.Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Создали page object — класс для страницы
public class LaptopSectionPage {
    // Добавили поле driver
    private final WebDriver driver;
    // Локатор поля ввода мин. цены
    private final By minPriceInputfield = By.className("_3qxDp");
    // Локатор поля ввода макс. цены
    private final By maxPriceInputfield = By.xpath(".//*[@class='_3qxDp']//following::input[1]");
    // Локатор выбора поиска по производителю для "Lenovo"
    private final By laptopLenovo = By.xpath(".//span[text()='Lenovo']");
    // Локатор заголовка результата поиска "Ноутбуки Lenovo"
    private final By lenovoLaptops = By.xpath(".//*[text()='Ноутбуки Lenovo']//ancestor::h1");

    // Добавили конструктор класса page object
    public LaptopSectionPage(WebDriver driver) {
        this.driver = driver;
    }


    // Метод заполняет поле ввода для мин. цены
    public void setMinPrice(String minPrice) {
        driver.findElement(minPriceInputfield).sendKeys(minPrice);
    }

    // Метод заполняет поле ввода для макс. цены
    public void setMaxPrice(String maxPrice) {
        driver.findElement(maxPriceInputfield).sendKeys(maxPrice);
    }

    // Метод кликает для выбора поиска по производителю "Lenovo"
    public void clickLaptopLenovo() {
        driver.findElement(laptopLenovo).click();
    }

    // Метод возвращает полученный результат поиска для мин. цены
    public String getMinPriceInputfield() {
        return driver.findElement(minPriceInputfield).getAttribute("value");
    }

    // Метод возвращает полученный результат поиска для макс. цены
    public String getMaxPriceInputfield() {
        return driver.findElement(maxPriceInputfield).getAttribute("value");
    }

    // Метод возвращает полученный результат поиска по производителю Lenovo
    public String getLenovoLaptops() {
        return driver.findElement(lenovoLaptops).getAttribute("textContent");
    }

}

