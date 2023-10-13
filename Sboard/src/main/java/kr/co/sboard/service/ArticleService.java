package kr.co.sboard.service;

import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.FileDTO;
import kr.co.sboard.dto.PageRequestDTO;
import kr.co.sboard.dto.PageResponseDTO;
import kr.co.sboard.entity.ArticleEntity;
import kr.co.sboard.entity.FileEntity;
import kr.co.sboard.repository.ArticleRepository;
import kr.co.sboard.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final FileRepository fileRepository;
    private final ModelMapper modelMapper;
    public void save(ArticleDTO dto){
        
        // 글 등록
        ArticleEntity savedentity = articleRepository.save(dto.toEntity());

        FileDTO fileDTO = fileUpload(dto);
        if(fileDTO != null){
            // 파일 등록
            fileDTO.setAno(savedentity.getNo());
            FileEntity fileEntity = fileRepository.save(fileDTO.toEntity());

            log.info("fileEntity...1"+fileEntity);
            if(fileEntity != null){
                savedentity.setFile(1);
                articleRepository.save(savedentity);
                log.info("fileEntity...2");
            }
        }
    }

    public PageResponseDTO findByParentAndCate(PageRequestDTO pageRequestDTO){

        Pageable pageable = pageRequestDTO.getPageable("no");

        //Pageable pageable = PageRequest.of(pg-1, 10, Sort.Direction.DESC, "no"); // 0~10까지(Limit), 글번호로 내림차순
        Page<ArticleEntity> result = articleRepository.findByParentAndCate(0, pageRequestDTO.getCate(),pageable);
        
        // stream : 파이프라인(통로) 같은 기능, 스트림으로 list를 가공처리
        // map : 리스트 갯수만큼 for문을 돌린다
        // map를 사용하여 람다식으로 builder로 entity를 DTO로 변환해줘야 한다
        List<ArticleDTO> dtoList = result.getContent()
                .stream()
                .map(entity -> modelMapper.map(entity,ArticleDTO.class)) // 그러나 modelMapper를 사용하면 압축가능
                .toList();

        // 갯수
        int totalElement = (int) result.getTotalElements();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(totalElement)
                .build();
    }

    @Value("${spring.servlet.multipart.location}")
    private String filePath;

    public FileDTO fileUpload(ArticleDTO dto) {

        log.info("fileUpload...1");
        MultipartFile mf = dto.getFname();
        log.info("fileUpload...2"+mf);
        if(!mf.isEmpty()){
            // 파일 첨부 했을 경우
            String path = new File(filePath).getAbsolutePath();
            log.info("fileUpload...3"+path);
            String oName = mf.getOriginalFilename();
            String ext = oName.substring(oName.lastIndexOf("."));
            String sName = UUID.randomUUID().toString()+ext;

            log.info("fileUpload...4"+oName);

            try {
                log.info("fileUpload...5");
                mf.transferTo(new File(path, sName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return FileDTO.builder().ofile(oName).sfile(sName).build();

        }
        // 파일 첨부 안했을 경우
        return null;
    }
}
