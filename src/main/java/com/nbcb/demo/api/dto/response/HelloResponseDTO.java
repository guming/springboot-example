

package com.nbcb.demo.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class HelloResponseDTO implements Serializable {
    private String customerId;
    private String customerName;
    private String message;
}
