package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.GalleryDAO;
import com.javaex.vo.GalleryVO;
import com.javaex.vo.UserVO;

@Service
public class GalleryService {
	String saveDir = "C:\\javaStudy\\upload";

	@Autowired
	GalleryDAO dao;

	// 리스트출력
	public List<GalleryVO> getList() {
		System.out.println("GalleryService.getList()");

		List<GalleryVO> galleryVOs = dao.getList();

		return galleryVOs;
	}

	// 파일 작성
	public void upload(MultipartFile file, int user_no, String content) {
		System.out.println("GalleryService.upload()");
		System.out.println(file.getOriginalFilename());

		// 원파일 이름
		String orgName = file.getOriginalFilename();
		System.out.println("orgName : " + orgName);

		// 확장자
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println("exName : " + exName);

		// 저장파일 이름
		String savaName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("savaName : " + savaName);

		// 파일패스
		String filePath = saveDir + "\\" + savaName;
		System.out.println("filePath : " + filePath);

		// 파일사이즈
		long fileSize = file.getSize();
		System.out.println("fileSize : " + fileSize);

		// 파일 업로드(하드디스크에 저장)
		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(filePath);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			bout.write(fileData);
			bout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		GalleryVO vo = new GalleryVO(0, user_no, content, filePath, orgName, savaName, fileSize);
		System.out.println(vo);

		dao.insert(vo);
	}

	public UserVO getUserByUserNo(int user_no) {
		
		UserVO vo = dao.getUserByUserNo(user_no);
		
		return vo;
	}

}
