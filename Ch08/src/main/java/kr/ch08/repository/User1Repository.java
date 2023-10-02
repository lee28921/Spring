package kr.ch08.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.ch08.entity.User1Entity;

@Repository
public interface User1Repository extends JpaRepository<User1Entity, String> {
	
	
	// JPA 쿼리 메서드
	public User1Entity findUser1EntityByUid(String uid);
	public List<User1Entity> findUser1EntityByName(String name);
	public List<User1Entity> findUser1EntityByNameNot(String name);
	
	public User1Entity findUser1EntityByUidAndName(String uid,String name);
	public List<User1Entity> findUser1EntityByUidOrName(String uid,String name);
	
	public List<User1Entity> findUser1EntityByAgeGreaterThan(int age);
	public List<User1Entity> findUser1EntityByAgeGreaterThanEqual(int age);
	public List<User1Entity> findUser1EntityByAgeLessThan(int age);
	public List<User1Entity> findUser1EntityByAgeLessThanEqual(int age);
	public List<User1Entity> findUser1EntityByAgeBetween(int low, int high);

	public List<User1Entity> findUser1EntityByNameLike(String name);
	public List<User1Entity> findUser1EntityByNameContains(String name);
	public List<User1Entity> findUser1EntityByNameStartsWith(String name);
	public List<User1Entity> findUser1EntityByNameEndsWith(String name);

	public List<User1Entity> findUser1EntityByOrderByName();
	public List<User1Entity> findUser1EntityByOrderByAgeAsc();
	public List<User1Entity> findUser1EntityByOrderByAgeDesc();
	public List<User1Entity> findUser1EntityByAgeGreaterThanOrderByAgeDesc(int age);
	
	public int countUser1EntityByUid(String uid);
	public int countUser1EntityByName(String name);
	
	// JPQL (별칭을 지정하고 * 대신 해당 별칭을 지정해야 함, 바인딩되는 파라미터는 넘버링을 부여)
	@Query("select u1 from User1Entity as u1 where u1.age < 30")
	public List<User1Entity> selectUser1UnderAge30();
	
	@Query("select u1 from User1Entity as u1 where u1.name = ?1")
	public List<User1Entity> selectUser1ByName(String name);
	
	@Query("select u1 from User1Entity as u1 where u1.name = :name") // 위 코드와 원리는 같다. 다만 매개변수에 어노테이션 지정
	public List<User1Entity> selectUser1ByParam(@Param("name") String name);
	
	@Query("select u1.uid, u1.name, u1.age from User1Entity as u1 where u1.name = :uid") // 특정 열만 호출시 오브젝트 배열 사용
	public List<Object[]> selectUser1ByUid(@Param("uid") String uid);
}
