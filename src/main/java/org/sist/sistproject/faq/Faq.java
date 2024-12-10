package org.sist.sistproject.faq;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Faq {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=200)
	private String title;
	
	@Column(columnDefinition = "TEXT")//문자열 길이 제한 없어져
	private String content;
	
	private LocalDateTime createDate;
	
	private Integer viewCount;
	   @PrePersist
	     public void prePersist() {
	      this.viewCount = 0;
	  }   
	public void increaseViewCount() {
        this.viewCount++;
    }
	
	private String writer;
	
	private String email;
}
