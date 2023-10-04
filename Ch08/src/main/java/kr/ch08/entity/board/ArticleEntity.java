package kr.ch08.entity.board;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="BoardArticle")
public class ArticleEntity {
	
	// entity는 무조건 id(PK) 선언 필수
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	private String title;
	private String content;
	
	// 방향성을 고려해서 Article에서 User을 참조해야 Article을 조회할때 User이 동시에 참조됨
	// @JoinColumn 선언으로 생성되는 컬럼명을 설정
	// Article >- User (다대일) - 유저는 하나지만 게시글은 여러 개로 생성가능하기 때문
	@ManyToOne(fetch = FetchType.LAZY) // FetchType.LAZY : 연관된 엔티티를 실제로 사용할 때까지 지연
	@JoinColumn(name="writer") // 조인할 컬럼명(따로 설정하지 않으면 조인할 테이블의 기본키로 조인)
	private UserEntity user; 
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "article")
	private FileEntity file;
	
	// 방향성을 고려해서 Article에서 Comment을 참조해야 Article을 조회할때 Comment이 동시에 참조됨
	// 양방향 관계에서 외래키를 갖는 엔티티의 속성을  mappedBy 속성으로 연ㄱ뎔 주인을 설정
	// Article -< comment (일대다) - 게시글은 하나지만 댓글은 여러 개
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
	private List<CommentEntity> comments; // 일대다로 지정될시 List 사용
	
	@CreationTimestamp
	private LocalDateTime rdate;
	
}
