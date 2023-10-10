package kr.co.sboard.dto;

import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TermsDTO {

    @Id
    private int no;
    private String terms;
    private String privacy;


}
