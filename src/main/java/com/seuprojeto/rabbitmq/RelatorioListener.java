package com.seuprojeto.rabbitmq;

import net.sf.jasperreports.engine.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class RelatorioListener {

    @RabbitListener(queues = "relatorio-sist-contabil")
    public void gerarRelatorioViaRabbit(String mensagem) throws Exception {
        InputStream jrxmlInput = new ClassPathResource("report/report_teste.jrxml").getInputStream();
        JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlInput);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JREmptyDataSource());
        byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

        // Salva o PDF gerado em disco para teste
        Files.write(Paths.get("relatorio_teste_rabbit.pdf"), pdfBytes);
        System.out.println("Relatório gerado via RabbitMQ!");
    }
}
