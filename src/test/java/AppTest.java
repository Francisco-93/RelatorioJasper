import net.sf.jasperreports.engine.*;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest{

    @Test
    public void teste() throws JRException{
        //Obtem o valor atual do sistema
        long inicioContagem = System.currentTimeMillis();

        //Compilacao no formato jasper para o jrprint
        JasperFillManager.fillReportToFile("src/reports/ManualBook_backcover.jasper", null, new JREmptyDataSource(1));
        System.err.println("Tempo de compilacao jasper -> jrprint: " + (System.currentTimeMillis() - inicioContagem));

        //Reinicia o contador
        inicioContagem = System.currentTimeMillis();

        //Geracao do PDF
        JasperFillManager.fillReportToFile("src/reports/ManualBook_backcover.jasper", null, new JREmptyDataSource());
       // JasperExportManager.exportReportToPdfFile("src/reports/ManualBook_backcover.jrprint");
    }
}