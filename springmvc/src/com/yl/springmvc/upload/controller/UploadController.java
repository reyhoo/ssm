package com.yl.springmvc.upload.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("upload")
public class UploadController {

	@RequestMapping("toUploadForm")
	public String toUploadForm() {
		return "upload/form";
	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="toUpload",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String toUpload(HttpServletRequest request) {
//		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
		MultipartFile file = mhsr.getFile("file");
		if(file == null) {
			//TODO 没有找到对应的form字段。
			return "未找到文件";
		}
		String fileName = file.getOriginalFilename();
		if(StringUtils.isEmpty(fileName)) {
			fileName = System.currentTimeMillis()+"";
		}else {
			//TODO 只要简单的文件名称而不是文件的全路径。
			fileName = fileName.substring(fileName.lastIndexOf(File.separatorChar)+1, fileName.length());
		}
		System.err.println(fileName);
		try {
			if(file.isEmpty()) {
				throw new Exception("文件为空");
			}
			//TODO 这里会在web.xml中配置的文件目录的基础上拼接上文件名称，然后保存。
			file.transferTo(new File(fileName));
			return "上传成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "上传失败:"+e;
		}
		
	}
}
