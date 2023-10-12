package kr.co.sboard.service;

import kr.co.sboard.dto.UserDTO;
import kr.co.sboard.entity.UserEntity;
import kr.co.sboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(UserDTO dto){

        dto.setPass1(passwordEncoder.encode(dto.getPass1()));
        // DTO를 Entity로 변환
        UserEntity entity = dto.toEntity();

        // DB insert
        userRepository.save(entity);
    }

    public int countUid(String uid){
        return userRepository.countByUid(uid);
    }
    public int countNick(String nick){
        return userRepository.countByNick(nick);
    }
    public int countHp(String hp){
        return userRepository.countByHp(hp);
    }
}
