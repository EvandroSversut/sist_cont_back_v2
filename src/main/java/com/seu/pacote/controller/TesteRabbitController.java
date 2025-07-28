package com.seu.pacote.controller;

import org.springframework.web.bind.annotation.*;
import com.seu.pacote.rabbit.TesteProducer;

@RestController
@RequestMapping("/api/rabbit")
public class TesteRabbitController {

    private final TesteProducer testeProducer;

    public TesteRabbitController(TesteProducer testeProducer) {
        this.testeProducer = testeProducer;
    }

    @PostMapping("/enviar")
    public String enviar(@RequestBody String mensagem) {
        testeProducer.enviarMensagem(mensagem);
        return "Mensagem enviada para RabbitMQ!";
    }
}

