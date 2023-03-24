package Validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import PageObjects.GenericPage;

public class GenericValidation {

    private WebDriver driver;
    private GenericPage genericPage;
    
    public GenericValidation(WebDriver driver) {
        
        this.driver=driver;
        genericPage = new GenericPage(this.driver);
        
    }
     /*exemplo metodo unico para validacao de cada pagina, 
    teriamos que criar um metodo para cada texto*/
    public void validationPageProducts() {
        
        String label = genericPage.getHomeTextSpan().getText();
        Assertions.assertEquals("Products", label);
    }
    
    
    /*Exemplo de metodo dinamico para validacao das paginas, 
     * onde ira receber por paramentro qual o texto esperado para compacao*/
     
    public void validationPages(String texto) {
        
       String label = genericPage.getHomeTextSpan().getText();
       Assertions.assertEquals(texto, label);
        
    }
    
    public void validationProduto() {
        
        Assertions.assertTrue(genericPage.getProdutoLabel().isDisplayed());
         
     }
}
