package com.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private Long phoneNo;
}
