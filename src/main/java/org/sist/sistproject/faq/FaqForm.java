package org.sist.sistproject.faq;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FaqForm {
	@NotEmpty(message = "제목은 필수항목입니다.")
	@Size(max = 200)
	private String title;
	
	@NotEmpty(message = "내용은 필수항목입니다.")
	private String content;
	
	@NotEmpty
	private String writer;
	
	@NotEmpty
	@Email
	private String email;
}