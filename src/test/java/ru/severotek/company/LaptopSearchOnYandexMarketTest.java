package ru.severotek.company;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.severotek.company.Page_Object.ComputersCatalogPage;
import ru.severotek.company.Page_Object.LaptopSectionPage;
import ru.severotek.company.Page_Object.MainPageElements;

import java.time.Duration;

// Создали тестовый класс, для выполнения тестового сценария
public class LaptopSearchOnYandexMarketTest {
    // Создали переменную драйвера
    private static WebDriver driver;
    // Создали переменные классов страниц page object
    private static MainPageElements startPage;
    private static ComputersCatalogPage computersCatalogPage;
    private static LaptopSectionPage laptopSectionPage;

    // Осуществление первоначальной настройки
    @BeforeClass
    public static void setup() {
        // Oпределение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        // Cоздание экземпляра драйвера
        driver = new ChromeDriver();
        // Создали экземпляры классов страниц
        startPage = new MainPageElements(driver);
        computersCatalogPage = new ComputersCatalogPage(driver);
        laptopSectionPage = new LaptopSectionPage(driver);
        // Окно разворачивается на полный экран
        driver.manage().window().maximize();
        // Задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Получение ссылки на страницу из файла настроек
        driver.get(ConfProperties.getProperty("pageAddress"));
    }

    // Закрытием окна браузера
    @AfterClass
    public static void teardown() {
        driver.quit();
    }


    @Test
    public void searchLaptopByModelAndPriceTest() {
        // Получение доступа к методам классов page object для взаимодействия с элементами страницы
        // Значение minPrice/maxPrice/lenovoLaptop берутся из файла настроек по аналогии с chromedriver и pageAddress
        // Вызываем метод проверяем активна ли кнопка каталога товаров
        startPage.checkCatalogButton();
        // Вызываем метод клика по кнопке каталога товаров
        startPage.clickCatalogButton();
        // Вызываем метод клика по разделу "Компьютеры"
        startPage.clickComputersSection();
        // Вызываем метод клака по разделу "Ноутбуки"
        computersCatalogPage.clickLaptopsSection();
        // Вызываем метод объединяющий все параметры поиска
        laptopSectionPage.laptopSearchByParameters(ConfProperties.getProperty("minPrice"), ConfProperties.getProperty("maxPrice"));
        // Получаем отображаемую мин. цену поиска
        String priceMin = laptopSectionPage.getMinPriceInputfield();
        // Получаем отображаемую макс. цену поиска
        String priceMax = laptopSectionPage.getMaxPriceInputfield();
        // Получаем отображаемого производителя Lenovo в поиске
        String lenovo = laptopSectionPage.getLenovoLaptops();
        // Сравниваем мин. цену из файла настроек с отображаемой в поиске
        Assert.assertEquals(ConfProperties.getProperty("minPrice"), priceMin);
        // Сравниваем макс. цену из файла настроек с отображаемой в поиске
        Assert.assertEquals(ConfProperties.getProperty("maxPrice"), priceMax);
        // Сравниваем производителя из файла настроек с отображаемым в поиске
        Assert.assertEquals(ConfProperties.getProperty("lenovoLaptop"), lenovo);

    }

}
