
package com.nbcb.demo.api.dto.request;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;


public class HelloRequestDTO implements Serializable {
    @ApiModelProperty(value = "Customer name (min 2 chars and max 20 chars: alphabet, apostrophe, hyphen, dot and space)", example = "Yulin", required = true)
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z '\\.-]{2,20}+$")
    private String name;

    @ApiModelProperty(value = "Customer title", example = "Mr", required = false)
    @Length(max = 8)
    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
