package com.seuprojeto.controller;

import net.sf.jasperreports.engine.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RestController
@RequestMapping("/api/relatorio")
public class RelatorioController {

    @GetMapping("/teste")
    public ResponseEntity<byte[]> gerarRelatorioTeste() throws Exception {
        InputStream jrxmlInput = new ClassPathResource("report/report_teste.jrxml").getInputStream();
        JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlInput);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JREmptyDataSource());
        byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "relatorio_teste.pdf");

        return ResponseEntity.ok().headers(headers).body(pdfBytes);
    }
}
