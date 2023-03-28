package TestCases;

import javax.security.auth.login.LoginContext;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

import Framework.TestBase;
import Tasks.CheckoutTask;
import Tasks.FinishTask;
import Tasks.LoginTask;
import Tasks.ProdutoTask;
import Validations.CheckoutValidation;

public class RealizarCompraComSucessoCSVTest extends TestBase{

    
    private WebDriver driver = getDriverManager();
    
    LoginTask loginTask = new LoginTask(driver);
    ProdutoTask produtoTask = new ProdutoTask(driver);
    CheckoutTask checkoutTask = new CheckoutTask(driver);
    FinishTask finishTask = new FinishTask(driver);
    
    @ParameterizedTest
    @CsvFileSource(resources = "/CSV/user.csv", numLinesToSkip = 1)
    public void realizarCompra(String user, String password) {
        
        loginTask.efetuarLoginParametrizado(user, password);
        produtoTask.selecionarProduto();
        checkoutTask.preencherForm();
        finishTask.finalizarCompra();
        
    }
}
