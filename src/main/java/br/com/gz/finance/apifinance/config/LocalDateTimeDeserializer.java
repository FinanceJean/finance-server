package br.com.gz.finance.apifinance.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Configuration
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return toLocalDateTime(p.getValueAsString());
    }

    public LocalDateTime toLocalDateTime(String value) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
            return LocalDateTime.parse(value, formatter);
        } catch (DateTimeParseException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
