package kr.ch12.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.ch12.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name="User")
public class UserEntity implements OAuth2User{
	
	@Id
	private String uid;
	private String pass;
	private String name;
	private int age;
	private String hp;
	private String role;
	
	@CreationTimestamp
	private LocalDateTime regDate;
	
	// 추가필드
	private String provider;
	private String nickname;
	private String email;
	
	// 위 필드들을 맵 구조체로 만들어서 리턴
	@Override
	public Map<String, Object> getAttributes() {
		return null;
	}
	
	// MyUserDetails
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
}

