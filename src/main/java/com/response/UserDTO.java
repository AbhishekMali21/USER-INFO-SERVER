package com.response;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
	private Integer id;
	private String name;
	private String email;
	private LocalDate dob;
	private Long phoneNo;
}
