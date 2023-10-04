package kr.ch08.repository.board;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;
import kr.ch08.entity.board.ArticleEntity;
import kr.ch08.entity.board.CommentEntity;
import kr.ch08.entity.board.FileEntity;
import kr.ch08.entity.board.UserEntity;

@SpringBootTest
public class BoardRepositoryTests {
	
	@Autowired private ArticleRepository articleRepo;
	@Autowired private CommentRepository commentRepo;
	@Autowired private FileRepository fileRepo;
	@Autowired private UserRepository userRepo;
	
	@DisplayName("insertUser 테스트...")
	public void insertUser() {
		
		UserEntity user = UserEntity.builder()
							.uid("a103")
							.name("장보고")
							.hp("010-1234-1003")
							.build();
		userRepo.save(user);
	}
	
	@DisplayName("insertArticle 테스트...")
	public void insertArticle() {
		
		UserEntity user = UserEntity.builder().uid("a103").build();
		
		ArticleEntity article = ArticleEntity.builder()
								.title("제목3")
								.content("내용3")
								.user(user)
								.build();
		
		articleRepo.save(article);
	}
	
	@DisplayName("insertComment 테스트...")
	public void insertComment() {
		
		UserEntity user = UserEntity.builder().uid("a102").build();
		
		ArticleEntity article = ArticleEntity.builder()
								.no(3)
								.build();
		CommentEntity comment = CommentEntity.builder()
								.content("댓글4")
								.user(user)
								.article(article)
								.build();
		
		commentRepo.save(comment);
	}
	
	@DisplayName("insertFile 테스트...")
	public void insertFile() {
		ArticleEntity article = ArticleEntity.builder()
				.no(4)
				.build();
		FileEntity file = FileEntity.builder()
								.oName("테스트2.txt")
								.sName("sf9sdf73.txt")
								.article(article)
								.build();
		fileRepo.save(file);
	}
	
	@DisplayName("selectArticles 테스트...")
	public void selectArticles() {
		
		List<ArticleEntity> articles = articleRepo.findAll();
		System.out.println(articles);
		
		for(ArticleEntity article : articles) {
			System.out.println(article);
		}
		
	}
	
	@Test
	@Transactional // 조회시 추가
	/*
	 * 양방향으로 처리되는 엔티티 관계에서 다수의 SELECT를 수행하기 때문에
	 * 단일 SELECT 처리 후 종료되는 특징으로 접속이 종료됨(no session)
	 * 따라서 그다음 SELECT 실행에서 no session 에러 발생
	 * 이럴 경우 @Transactional 선언으로 트랜잭션 처리를 해줘야 됨
	 * 
	 */
	@DisplayName("selectArticle 테스트...")
	public void selectArticle() {
		
		Optional<ArticleEntity> result = articleRepo.findById(1);
		ArticleEntity article = result.orElseThrow();
		
		System.out.println(article);
		
	}
	
}
