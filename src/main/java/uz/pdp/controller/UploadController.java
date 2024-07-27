package uz.pdp.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.dao.AttachmentRepository;
import uz.pdp.model.Attachment;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
public class UploadController {

    private final AttachmentRepository attachmentRepository;

    public UploadController(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @GetMapping("/upload")
    public String uploadPage() {
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {

        String originalFilename = file.getOriginalFilename();
        String generatedFilename = UUID.randomUUID() + "." + StringUtils.getFilenameExtension(originalFilename);
        String contentType = file.getContentType();
        long size = file.getSize();

        Attachment attachment = Attachment.builder()
                .originalName(originalFilename)
                .generatedName(generatedFilename)
                .contentType(contentType)
                .size(size)
                .build();

        Integer id = attachmentRepository.save(attachment);
        System.out.println(id);

        Path path = Path.of("/Users/otabekpanoev/Job/Pdp/Lessons/G38/files/" + generatedFilename);
        InputStream inputStream = file.getInputStream();
        Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
        return String.valueOf(id);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> download(@PathVariable("id") Integer id)  {

        Attachment attachment = attachmentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Attachment not found"));

        Path path = Path.of("/Users/otabekpanoev/Job/Pdp/Lessons/G38/files/" + attachment.getGeneratedName());
        FileSystemResource fileSystemResource = new FileSystemResource(path);

//        new ResponseEntity<Resource>(fileSystemResource, HttpStatus.OK);

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(attachment.getContentType()))
                .header("Content-Disposition", "attachment; filename=\"" + attachment.getOriginalName() + "\"")
                .body(fileSystemResource);


    }






    /*@GetMapping("/home/{v1}/v1/{v2}")
    @ResponseBody
    public String upload(@PathVariable(name = "v1") String v1, @PathVariable(name = "v2") String v2) {

        return  v1 + " : " + v2;
    }*/

}
