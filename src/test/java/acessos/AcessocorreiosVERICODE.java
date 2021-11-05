package acessos;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AcessocorreiosVERICODE {
@Test
    public void TesteCorreio(){
    System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe"); //abrindo o navegador / Avaliador observe onde está seu drive
    WebDriver navegador = new ChromeDriver();
    navegador.manage().window().maximize();
    navegador.get("https://www.correios.com.br/");//- entre no site dos correios
    navegador.findElement(By.id("relaxation")).sendKeys("80700000");
    navegador.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div[2]/form/div[2]/button")).click();
    //navegando para segunda guia que abriu
    Object psdbComponent;
    ArrayList<String> tabs2 = new ArrayList<String> (navegador.getWindowHandles());
    navegador.switchTo().window(tabs2.get(1));
    String textoElement = navegador.findElement(By.xpath("/html/body/main/form/div[1]/div[2]/div/div[2]")).getText();
    assertEquals("Não há dados a serem exibidos", textoElement);
    navegador.switchTo().window(tabs2.get(1));
    navegador.close();
    navegador.switchTo().window(tabs2.get(0));
    navegador.findElement(By.id("relaxation")).clear();
    navegador.findElement(By.id("relaxation")).sendKeys("01013-001");
    navegador.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div[2]/form/div[2]/button")).click();
    ArrayList<String> tabs3 = new ArrayList<String> (navegador.getWindowHandles());
    navegador.switchTo().window(tabs3.get(1));
    String bodyText = navegador.findElement(By.tagName("body")).getText();
    Assert.assertTrue("Rua Quinze de Novembro - lado ímpar", bodyText.contains(""));
    Assert.assertTrue("São Paulo/SP", bodyText.contains(""));
    navegador.switchTo().window(tabs3.get(1));
    navegador.close();
    navegador.switchTo().window(tabs3.get(0));
    navegador.findElement(By.id("relaxation")).clear();
    navegador.findElement(By.id("objetos")).sendKeys("SS987654321BR");
    navegador.findElement(By.cssSelector("#content > div.mais-acessados > div > div:nth-child(1) > form > div.campo > button")).click();
    //String textoElement2 = navegador.findElement(By.xpath("//*[@id=\"alerta\"]/div[1]")).getText();
    //assertEquals("Não há dados a serem exibidos", textoElement2);

    navegador.quit();
}
}
