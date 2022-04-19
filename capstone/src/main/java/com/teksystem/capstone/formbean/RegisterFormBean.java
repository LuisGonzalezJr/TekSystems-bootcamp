package com.teksystem.capstone.formbean;


import com.teksystem.capstone.validation.EmailUnique;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
@ToString
public class RegisterFormBean {

    // this id will be null in the case of a create
    //and will be populated with the user id in the case of an edit
    private Integer id;
    @EmailUnique(message = "Email is already being used ")
    @NotBlank(message = "Email is required")
    @Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Email format invalid")
    private String email;

    @NotBlank(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String lastName;

    @Length(min = 3, max = 15, message="Password must be between 3 and 15 characters")
    @NotBlank(message = "Password is required")
    private String password;


    @NotBlank(message = "Confirm Password is required")
    private String confirmPassword;


    @AssertTrue(message = "Checkbox is required")
    private boolean checkbox;

}

