package com.abir.bijoux.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.MediaType; 
import org.springframework.http.ResponseEntity; 
import org.springframework.stereotype.Service; 
import org.springframework.web.multipart.MultipartFile;

import com.abir.bijoux.entities.Bijoux;
import com.abir.bijoux.entities.Image;
import com.abir.bijoux.repos.BijouxRepository;
import com.abir.bijoux.repos.ImageRepository; 
 
 
@Service 
public class ImageServiceImpl implements ImageService{ 
 
    @Autowired 
    ImageRepository imageRepository; 
    @Autowired 
    BijouxService bijouxService; 
    @Autowired 
    BijouxRepository bijouxRepository; 
 
    public Image uplaodImage(MultipartFile file) throws IOException { 
   /*Ce code commenté est équivalent au code utilisant le design pattern Builder 
       * Image image = new Image(null, file.getOriginalFilename(),  
                         file.getContentType(), file.getBytes(), null); 
       return imageRepository.save(image);*/ 
 
        return imageRepository.save(Image.builder() 
                .name(file.getOriginalFilename()) 
                .type(file.getContentType()) 
                .image(file.getBytes()).build() ); 
    } 
 
     
    public Image getImageDetails(Long id) throws IOException{ 
        final Optional<Image> dbImage = imageRepository. findById (id); 
 
        return Image.builder() 
                .idImage(dbImage.get().getIdImage()) 
                .name(dbImage.get().getName()) 
                .type(dbImage.get().getType()) 
                .image(dbImage.get().getImage()).build() ; 
    } 
 
    public ResponseEntity<byte[]> getImage(Long id) throws IOException{ 
        final Optional<Image> dbImage = imageRepository. findById (id); 
 
        return ResponseEntity 
                .ok() 
                .contentType(MediaType.valueOf(dbImage.get().getType())) 
                .body(dbImage.get().getImage()); 
    } 
 
    public void deleteImage(Long id) { 
        imageRepository.deleteById(id); 
    } 
    @Override 
    public Image uplaodImageBijx(MultipartFile file,Long idBijx)  
   throws IOException { 
     Bijoux b = new Bijoux(); 
     b.setIdBijoux(idBijx); 
     return imageRepository.save(Image.builder() 
                   .name(file.getOriginalFilename()) 
                   .type(file.getContentType()) 
                   .image(file.getBytes()) 
                   .bijoux(b).build() ); 
    } 
    @Override 
    public List<Image> getImagesParBijx(Long bijxId) { 
    	Bijoux b = bijouxRepository.findById(bijxId).get(); 
     return b.getImages(); 
    } 

 
} 
