package com.sistema.sistema_contabil;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebugEntidades {

    @Bean
    CommandLineRunner listar(EntityManagerFactory emf) {
        return args -> {
            System.out.println("\n================ ENTIDADES =================");

            int total = 0;
            for (EntityType<?> e : emf.getMetamodel().getEntities()) {
                String entityName = e.getName();
                String tableName = e.getJavaType().getSimpleName();

                System.out.println(entityName + " | " + tableName);
                total++;
            }

            System.out.println("TOTAL_ENTIDADES=" + total);
            System.out.println("============================================");
        };
    }

    @Bean
    CommandLineRunner propriedades(EntityManagerFactory emf) {
        return args -> {
            var map = emf.getProperties();

            System.out.println("ddl-auto = " + map.get("hibernate.hbm2ddl.auto"));
            System.out.println("jakarta.persistence.schema-generation.database.action = "
                    + map.get("jakarta.persistence.schema-generation.database.action"));
        };
    }
}