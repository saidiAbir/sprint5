package com.abir.bijoux.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.abir.bijoux.entities.Image;

public interface ImageService {
	Image uplaodImage(MultipartFile file) throws IOException;

	Image getImageDetails(Long id) throws IOException;

	ResponseEntity<byte[]> getImage(Long id) throws IOException;

	void deleteImage(Long id);

	Image uplaodImageBijx(MultipartFile file, Long idBijx) throws IOException;

	List<Image> getImagesParBijx(Long bijxId);
}
