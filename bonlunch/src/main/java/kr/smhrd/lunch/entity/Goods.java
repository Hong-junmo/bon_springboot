package kr.smhrd.lunch.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "goods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
	
	// 필드
	@Id // GerneratedValue -> 이미 넣어놓은 데이터를 가지고 오는 작업
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String price;
	
	@Column(name = "is_new", nullable = false)
	private Boolean isNew;
	
	@Column(name = "is_best", nullable = false)
	private Boolean isBest;
	
	@Column(nullable = false)
	private String main_thumb;
	
}
