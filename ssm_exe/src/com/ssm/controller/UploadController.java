package com.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("upload")
public class UploadController {

	@RequestMapping("toUpload")
	@ResponseBody
	public Map<String, Object> toUpload(String name,HttpServletRequest request){
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("name", name);
		MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
		MultipartFile file = mhsr.getFile("f");
		if(file == null) {
			throw new RuntimeException("文件不存在");
		}
		if(file.isEmpty()) {
			throw new RuntimeException("文件为空");
		}
		map.put("filename", file.getOriginalFilename());
		
		try {
			file.transferTo(new File(file.getOriginalFilename()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return map;
	}
	
	
	

	@RequestMapping("toUpload2")
	@ResponseBody
	public Map<String, Object> toUpload(String name,MultipartFile f){
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("name", name);
		if(f == null) {
			throw new RuntimeException("文件不存在");
		}
		if(f.isEmpty()) {
			throw new RuntimeException("文件为空");
		}
		map.put("filename", f.getOriginalFilename());
		
		try {
			f.transferTo(new File(f.getOriginalFilename()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return map;
	}
	
	@RequestMapping("toUploadForm")
	public String toUploadForm() {
		return "upload";
	}
	
	private HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes());
		return attrs.getRequest();
	}
}
