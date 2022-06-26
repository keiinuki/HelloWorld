package com.inuki.HelloWorld;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class DeleteForm {
    @NotBlank
    @Length(max = 19)
    @NotNull
    private String name;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }
}
