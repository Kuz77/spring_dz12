package com.example.spring_dz_6.services;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "textInputChannel") // исправлено имя канала
public interface FileGateWay {
    void writeToFile(@Header(FileHeaders.FILENAME) String fileName, String data);
}
