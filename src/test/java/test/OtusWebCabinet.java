package test;


import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class OtusWebCabinet extends BaseTest {


        //@Test
    public void testWebCabinet() throws InterruptedException {
                /*итак, что получается, у меня страница https://otus.ru/lk/biography/personal/ с персональными данными,
                мне надо в отдельном классе сделать методы по работе с полями этого компонента(формы),
                некоторые из этих полей +- одинаковые и для них метод один, но xpath будет разный
                насчитали 7 методов, для даты работу через объект localdate
                для проверки данных нужен отдельный класс с методами проверки данных в этих полях через Assert
                для первоначальной страницы отуса нужен тоже класс( Например BasePage), в котором тоже описать работу,
                по итогу в тесте только методы вызывать
                соответственно в классе будут поля privat и методы public, в которых эти поля используются
                и мб ещё конструктор

                                 */

            driver.manage().window().maximize();
            driver.get("https://otus.ru/");
            System.out.println(driver.getWindowHandle());//отладка
            WebElement buttonCool = driver.findElement(By.xpath("//header//*[@data-modal-id='new-log-reg']"));
            buttonCool.click();// нажать на кнопку авторизации
            //String handle2 = driver.getWindowHandle(); // получить handle открытого окна
           //     driver.switchTo().window(handle2); // официально переключися на него)))
            WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions
                            .elementToBeClickable(By.xpath("//form/*/input[@type='text'][@placeholder='Электронная почта']")));
            wait.sendKeys(System.getProperty("username"));
            driver.findElement(By.xpath("//form/*/input[@type='password'][@placeholder='Введите пароль']"))
                    .sendKeys(System.getProperty("password"));
            driver.findElement(By.xpath("//form/div/button[@type='submit' and contains(text(), 'Войти')]")).click();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions
                            .elementToBeClickable(By.xpath("//div/*[@class='header2-menu header2__right__menu']")));
            Actions actions = new Actions(driver);
            actions.moveToElement(wait).build().perform();
            WebElement spisok = driver.findElement(By.xpath("//div/a[@href='/lk/biography/personal/']"));
            spisok.click();
            //В разделе "О себе" заполнить все поля "Личные данные" и добавить не менее двух контактов
            WebElement name = driver.findElement(By.xpath("//div/input[@data-title='Имя']"));
                fillField(name, "Имя");
            WebElement family =  driver.findElement(By.xpath("//div/input[@data-title='Фамилия']"));
                fillField(family,"Фамилия");
            WebElement nameLat = driver.findElement(By.xpath("//div/input[@name='fname_latin']"));
                fillField(nameLat,"NameLat");
            WebElement familyLat = driver.findElement(By.xpath("//div/input[@name='lname_latin']"));
                fillField(familyLat,"FamLat");
            WebElement blogName = driver.findElement(By.xpath("//div/input[@name='blog_name']"));
                fillField(blogName,"NameBlog");
            WebElement dateBirth = driver.findElement(By.xpath("//div/input[@name='date_of_birth']"));
                fillField(dateBirth, "31.05.1996");
                //страна
            //нажать на выпадающий список стран
            driver.findElement(By.xpath("//label/input[@name='country']/..")).click();
            //выбрать страну из выпадающего списка
            driver.findElement(By.xpath("//div/button[@title='Россия']")).click();
            //нажать на выпадающий список городов этот шаг отработал
            driver.findElement(By.xpath("//label/input[@name='city']/..")).click();
            //выбрать город из выпадающего списка тоже отработал
            driver.findElement(By.xpath("//div/button[@title='Самара']")).click(); // нужен wait
            //нажать на выпадающий список владения английским
            driver.findElement(By.xpath("//label/input[@name='english_level']/..")).click();
            //выбрать уровень владения
            driver.findElement(By.xpath("//div/button[@title='Средний (Intermediate)']")).click();
            //кликнуть чекбокс полный день вот тут упал!!! вот тут надо через javascript отобразить элемент
            //запрос который сделает круто document.querySelectorAll(".lk-cv-block__input-alignment")[1].children[0].children[0].style.display="block"
            driver.findElement(By.xpath("//label[./input[@title='Полный день']]")).click();
            //нажать на выпадающий список контактов
            driver.findElement(By.xpath("//div/span[contains(text(), 'Способ связи')]")).click();
            //выбрать тип telegram
            driver.findElement(By.xpath("//div/button[@title='Тelegram']")).click();
            //ввести значение
            driver.findElement(By.xpath("//div/input[@name='contact-0-value']")).sendKeys("Тelegram");
            //нажать на кнопку добавить
            driver.findElement(By.xpath("//div/button[contains(text(),'Добавить')]")).click();
            driver.findElement(By.xpath("//div/span[contains(text(), 'Способ связи')]")).click();
            driver.findElement(By.xpath("//div/button[@title='//div[@data-num='1']//button[@title='Facebook']']")).click();
            driver.findElement(By.xpath("//div/input[@name='contact-1-value']")).sendKeys("Facebook");
            //указать пол тут может быть проблема
            driver.findElement(By.xpath("//select[@name='gender']")).click();
            driver.findElement(By.xpath("//select[@name='gender']/option[@value='m']")).click();
            //компания
            driver.findElement(By.xpath("//div/input[@name='company']")).sendKeys("company");
            //должность
            driver.findElement(By.xpath("//div/input[@name='work']")).sendKeys("work");
            //нажать сохранить и продолжить
            //driver.findElement(By.xpath("//div/button[@type='submit'][@title='Сохранить и продолжить']")).click();
            //хлопаем сессию
            //driver.close();
            //а теперь всё по новой, будет весело, теперь надо сравнить то, что я сделал до этого с тем, что я увижу

            Thread.sleep(10000);

            //Нажать сохранить
            //driver.close();// закрывает сессию браузера
            //Открыть https://otus.ru в "чистом браузере"
            // Авторизоваться на сайте
            // Войти в личный кабинет
            //Проверить, что в разделе "О себе" отображаются указанные ранее данные



        }



}
