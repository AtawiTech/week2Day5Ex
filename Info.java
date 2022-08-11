package com.example.week2day5;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
public class Info {
    @NotNull(message = "id cant be null")
    @Size (min = 2 , message = "id length must be more than 2")
    private String id;


    @NotNull (message = "id cant be null")
    @Size(min = 4 , message = "id length must be more than 4")
    private String name;


    @NotNull (message = "id cant be null")
    @Pattern(regexp = "[\\s]*[1-9]*[0-9]",message="Age must be a number")
    @Range(min = 25,max = 49 , message = "id length must be more than 25 and less than 50")
    private String age;


    private boolean onLeave;


    @NotNull (message = "id cant be null")
    @Pattern(regexp = "[\\s]*[1-9]*[0-9]",message="The employment year must be a number")
    @Pattern(regexp = ("^d{4}$"))
    private int employmentYear;

    @NotNull (message = "id cant be null")
    @Pattern(regexp = "[\\s]*[1-9]*[0-9]|[0]",message="The annual leave must be a number")
    private String annualLeave;
}