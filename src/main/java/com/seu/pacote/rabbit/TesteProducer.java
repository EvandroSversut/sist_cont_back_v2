package com.seu.pacote.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import com.seu.pacote.config.RabbitMQConfig;

@Component
public class TesteProducer {

    private final RabbitTemplate rabbitTemplate;

    public TesteProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarMensagem(String mensagem) {
        rabbitTemplate.convertAndSend(
            RabbitMQConfig.EXCHANGE_NAME,
            RabbitMQConfig.ROUTING_KEY,
            mensagem
        );
    }
}

