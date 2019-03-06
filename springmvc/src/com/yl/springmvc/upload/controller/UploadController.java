package com.yl.springmvc.upload.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	 * 使用MultipartHttpServletRequest接收文件。
	 * @param request
	 * @return
	 */
	@RequestMapping(value="toUpload",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String toUpload(HttpServletRequest request) {
//		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
		MultipartFile file = mhsr.getFile("file");
		String name = mhsr.getParameter("name");
		System.err.println(name);
		if(file == null) {
			//TODO 没有找到对应的form字段。
			return "未找到文件";
		}
		String fileName = file.getOriginalFilename();
		if(StringUtils.isEmpty(fileName)) {
			//TODO 这种情况一般是客户端上传文件没有设置filename造成的。
			fileName = System.currentTimeMillis()+"";
		}else {
			//TODO 只要简单的文件名称而不是文件的全路径。
			fileName = fileName.substring(fileName.lastIndexOf(File.separatorChar)+1, fileName.length());
		}
		System.err.println(fileName);
		try {
			if(file.isEmpty()) {
				//文件字段没有选择文件
				throw new Exception("文件为空");
			}
			//TODO 这里会使用web.xml中配置的文件目录的基础上拼接上文件名称，然后保存。
			file.transferTo(new File(fileName));
			return "上传成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "上传失败:"+e;
		}
	}
	
	/**
	 * 使用MultipartFile接收文件
	 * @param f
	 * @return
	 */
	@RequestMapping(value="uploadMultipartFile",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String uploadMultipartFile(String name,@RequestParam("file") MultipartFile f) {
		System.err.println(name);
		if(f == null) {
			//TODO 没有找到对应的form字段。
			return "未找到文件";
		}
		if(f.isEmpty()) {
			//TODO 文件字段没有选择文件
			return "文件为空";
		}
		String fileName = f.getOriginalFilename();
		if(StringUtils.isEmpty(fileName)) {
			//TODO 这种情况一般是客户端上传文件没有设置filename造成的。
			fileName = System.currentTimeMillis()+"";
		}else {
			//TODO 只要简单的文件名称而不是文件的全路径。
			fileName = fileName.substring(fileName.lastIndexOf(File.pathSeparatorChar)+1);
		}
		System.err.println(fileName);
		try {
			//TODO 这里会使用web.xml中配置的文件目录的基础上拼接上文件名称，然后保存。
			f.transferTo(new File(fileName));
			//TODO 这里也可以使用绝对路径
//			f.transferTo(new File("/Users/wby/Documents/"+fileName));
			return "上传成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "上传失败:"+e;
			
		}
	}
	
	/**
	 * 使用Part接收文件，该方法获取文件原始名称比较困难，以下代码没有正确获取。不推荐使用.
	 * @param f
	 * @param name
	 * @return
	 */
	@Deprecated
	@RequestMapping(value="uploadPart",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String uploadPart(@RequestParam("file")Part f,String name) {
		System.err.println(name);
		if(f == null) {
			//TODO 没有找到对应的form字段。
			return "未找到文件";
		}
		if(f.getSize() == 0) {
			//TODO 文件字段没有选择文件
			return "文件为空";
		}
		String fHeader = f.getHeader("Content-disposition");
		System.err.println(fHeader);
		String fileName = fHeader.substring(fHeader.indexOf("filename=")+10);
		if(StringUtils.isEmpty(fileName)) {
			//TODO 这种情况一般是客户端上传文件没有设置filename造成的。
			fileName = System.currentTimeMillis()+"";
		}else {
			//TODO 只要简单的文件名称而不是文件的全路径。
			fileName = fileName.substring(fileName.lastIndexOf(File.pathSeparatorChar)+1);
		}
		System.err.println(fileName);
		try {
			f.write(fileName);
			return "上传成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "上传失败:"+e;
		}
	}
}
