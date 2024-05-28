package com.example.spring_dz_6.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannel textInputChannel() { // исправлено имя канала
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileWriterChannel() { // исправлено имя канала
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "textInputChannel", outputChannel = "fileWriterChannel") // исправлено имя канала
    public GenericTransformer<String, String> myTransformer() {
        return text -> text.toUpperCase().trim();
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWriterChannel") // исправлено имя канала
    public FileWritingMessageHandler myMessageHandler() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("C:\\java\\spring_dz_6"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        return handler;
    }
}
