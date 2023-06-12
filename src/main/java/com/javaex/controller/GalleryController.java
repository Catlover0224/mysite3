package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVO;
import com.javaex.vo.UserVO;

@Controller
@RequestMapping(value = "/gallery")
public class GalleryController {

	@Autowired
	GalleryService galleryService;

	// 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("GalleryController.list()");

		List<GalleryVO> galleryVOs = galleryService.getList();

		for (GalleryVO galleryVO : galleryVOs) {
			int user_no = galleryVO.getUser_no();
			UserVO user = galleryService.getUserByUserNo(user_no);
			galleryVO.setUser(user);
		}

		model.addAttribute("galleryVOs", galleryVOs);

		return "gallery/list";
	}

	// 업로드
	@RequestMapping(value = "/upload", method = { RequestMethod.GET, RequestMethod.POST })
	public String upload(@RequestParam("content") String content, @RequestParam("uploadPicture") MultipartFile file,
			HttpSession session) {
		System.out.println("GalleryController.upload()");
		UserVO userVO = (UserVO) session.getAttribute("user");
		System.out.println(userVO.getNo());

		galleryService.upload(file, userVO.getNo(), content);

		return "redirect:/gallery/list";
	}
}
