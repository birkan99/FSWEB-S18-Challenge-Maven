package com.workintech.fswebs18challengemaven.exceptions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardErrorResponse {
    private String message;
    private long timestamp;
    private int status;


    public CardErrorResponse(String message) {
        this.message = message;
        this.timestamp = System.currentTimeMillis();
        this.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }
}