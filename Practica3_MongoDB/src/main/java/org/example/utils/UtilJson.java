package org.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class UtilJson {
    private final ObjectMapper objectMapper;

    public UtilJson() {
        this.objectMapper = new ObjectMapper();
    }
    // Inyección de dependencia para ObjectMapper
    public UtilJson(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    // Lee un archivo JSON y lo convierte en una lista de objetos del tipo especificado
    public <T> List<T> readJsonFile(String filePath, Class<T> clazz) throws IOException {
        return objectMapper.readValue(
                new File(filePath),
                objectMapper.getTypeFactory().constructCollectionType(List.class, clazz)
        );
    }
   // Pasa un String JSON a un objeto del tipo especificado
    public <T> T jsonToObject(String json, Class<T> clazz) throws IOException {
        return objectMapper.readValue(json, clazz);
    }


}
