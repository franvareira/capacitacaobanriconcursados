package TestCases;



import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Framework.TestBase;
import Report.Report;
import Report.ReportType;
import Report.Screenshot;
import Tasks.CheckoutTask;
import Tasks.FinishTask;
import Tasks.LoginTask;
import Tasks.ProdutoTask;


public class RealizarCompraComSucessoTest extends TestBase{

    
    private WebDriver driver = getDriverManager();
    
    LoginTask loginTask = new LoginTask(driver);
    ProdutoTask produtoTask = new ProdutoTask(driver);
    CheckoutTask checkoutTask = new CheckoutTask(driver);
    FinishTask finishTask = new FinishTask(driver);
    
    @Test
    public void realizarCompra() {
        try {
            
            Report.createTest("Realizar Compra com Sucesso", ReportType.SINGLE);
            loginTask.efetuarLogin();
            produtoTask.selecionarProduto();
            checkoutTask.preencherForm();
            finishTask.finalizarCompra();
            
            }catch (Exception e) {
            
               Report.log(Status.FAIL, e.getMessage(),Screenshot.capture(driver)); 
            }

    }
}
