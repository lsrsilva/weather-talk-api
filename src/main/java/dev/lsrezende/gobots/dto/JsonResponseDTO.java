package dev.lsrezende.gobots.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResponseDTO {
    private Object result;
    protected String message;
    private List<String> messages;

    public JsonResponseDTO() {
    }

    public JsonResponseDTO(Object result, List<String> messages) {
        this.result = result;
        this.messages = messages;
    }

    public Object getResult() {
        return this.result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getMessages() {
        return this.messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public static JsonResponseDTO ok(Object result) {
        return ok(result, null);
    }

    public static JsonResponseDTO ok(Object result, String message) {
        JsonResponseDTO JsonResponseDTO = new JsonResponseDTO();
        JsonResponseDTO.setResult(result);
        JsonResponseDTO.setMessage(message);
        return JsonResponseDTO;
    }

    public static JsonResponseDTO otherReponse(String message) {
        return otherReponse(null, message, null);
    }

    public static JsonResponseDTO otherReponse(String message, List<String> messages) {
        return otherReponse(null, message, messages);
    }

    public static JsonResponseDTO otherReponse(Object result, String message, List<String> messages) {
        JsonResponseDTO JsonResponseDTO = new JsonResponseDTO();
        JsonResponseDTO.setResult(result);
        JsonResponseDTO.setMessage(message);
        JsonResponseDTO.setMessages(messages);
        return JsonResponseDTO;
    }
}
