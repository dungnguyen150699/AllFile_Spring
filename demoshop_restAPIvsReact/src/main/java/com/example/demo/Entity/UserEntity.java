package com.example.demo.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

import org.hibernate.annotations.ManyToAny;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.UserDetailsAwareConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "active")
	private boolean active;
	
//    @Column(name = "birth", columnDefinition = "DATETIME")
	@Column(name = "birth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birth;
    
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrderEntity> orders = new ArrayList<OrderEntity>();
	
	//@JoinColumn ch??? ra r???ng th???c th??? n??y l?? ch??? s??? h???u c???a m???i quan h???
	//mappedBy ch??? ra r???ng th???c th??? ??? b??n n??y l?? ngh???ch ?????o c???a m???i quan h??? v?? ch??? s??? h???u c?? tr?? trong th???c th??? "kh??c"
	@ManyToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<RoleEntity> roles;// Th??m CascadeType ??? user ????? khi th??m user th?? c??ng th??m user_role

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date date;
}
