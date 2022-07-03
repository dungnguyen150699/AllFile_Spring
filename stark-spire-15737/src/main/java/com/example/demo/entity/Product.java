package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	
	@Column(name = "img")
	@Lob
//	@Type(type = "org.hibernate.type.ImageType") // Cái này dùng để nói với csdl type lưu vào csdl ntn hoặc lấy nó ra
	private Byte[] img;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "count")
	private int count;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	public String getImgBase64(){
		if(getImg() == null) return "";
		return Base64.getEncoder().encodeToString(toBytePrimitive(getImg()));
	}

	public byte[] toBytePrimitive(Byte[] byteWrapper){
		if(byteWrapper == null) return null;
		byte []bytePrimitive = new byte[byteWrapper.length];
		for(int i=0 ; i<bytePrimitive.length ; i++){
			bytePrimitive[i] = byteWrapper[i];
		}
		return bytePrimitive;
	}
}