import net.sf.jasperreports.engine.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws JRException
    {
        //Obtem o valor atual do sistema
        long inicioContagem = System.currentTimeMillis();

        //Link entre chave valor do formulário
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("BookTitle", "Titulo passado");

        //Compilação no formato jrxml para o .jasper
        JasperCompileManager.compileReport("src/reports/AjusteManual_cover.jrxml");
        JasperCompileManager.compileReport("src/reports/AjusteManual_backcover.jrxml");
        JasperCompileManager.compileReport("src/reports/AjusteManual_toc.jrxml");
        JasperCompileManager.compileReport("src/reports/AjusteManual_content.jrxml");
        JasperCompileManager.compileReport("src/reports/AjusteManual.jrxml");

        //Compilacao no formato jasper para o jrprint
        JasperFillManager.fillReportToFile("src/reports/AjusteManual.jasper", parameters, new JREmptyDataSource(1));
        System.err.println("Tempo de compilacao jasper -> jrprint: " + (System.currentTimeMillis() - inicioContagem));

        //Geracao do PDF
        JasperExportManager.exportReportToPdfFile("src/reports/AjusteManual.jrprint");
        System.err.println("Tempo de geracao do PDF: " + (System.currentTimeMillis() - inicioContagem));



/***************************************************************************************************************/
       /* JasperFillManager.fillReportToFile("src/reports/ManualBook_backcover.jasper", null, new JREmptyDataSource(1));
        System.err.println("Tempo de compilacao jasper -> jrprint: " + (System.currentTimeMillis() - inicioContagem));

        //Reinicia o contador
        inicioContagem = System.currentTimeMillis();

        //Geracao do PDF
        JasperFillManager.fillReportToFile("src/reports/ManualBook_backcover.jasper", null, new JREmptyDataSource());
        // JasperExportManager.exportReportToPdfFile("src/reports/ManualBook_backcover.jrprint");  */
    }
}
