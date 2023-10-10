package kr.co.sboard.entity;

import jakarta.persistence.*;
import kr.co.sboard.dto.TermsDTO;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "terms")
public class TermsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String terms;
    private String privacy;

    public TermsDTO toDTO(){

        return TermsDTO.builder()
                       .no(no)
                       .terms(terms)
                       .privacy(privacy)
                       .build();
    }
}
