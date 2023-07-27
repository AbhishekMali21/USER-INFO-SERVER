package com.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
	@JsonIgnore
	private Integer id;
	private String name;
	private String email;
	private LocalDate dob;
	@Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits")
	@Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
	private String phoneNo;
}
