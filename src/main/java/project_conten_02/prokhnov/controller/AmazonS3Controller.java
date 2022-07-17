package project_conten_02.prokhnov.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project_conten_02.prokhnov.service.AmazonS3Service;

import java.util.List;

@RestController
@RequestMapping(value = "/api/storage")
public class AmazonS3Controller {
    private final AmazonS3Service amazonS3Service;

    public AmazonS3Controller(AmazonS3Service amazonS3Service) {
        this.amazonS3Service = amazonS3Service;
    }

    @PostMapping(value = "/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonS3Service.uploadFile(file);
    }

    @DeleteMapping(value = "/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl){
        return this.amazonS3Service.deleteFileFromS3Bucket(fileUrl);
    }

    @GetMapping(value = "/getFileList")
    public List<String> getFileList(){
        return this.amazonS3Service.listFiles();
    }
}
