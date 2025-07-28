package com.seu.pacote.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.seu.pacote.config.RabbitMQConfig;

@Component
public class TesteConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receberMensagem(String mensagem) {
        System.out.println("Mensagem recebida do RabbitMQ: " + mensagem);
    }
}

