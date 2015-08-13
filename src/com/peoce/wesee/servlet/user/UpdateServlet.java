package com.peoce.wesee.servlet.user;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.peoce.wesee.constant.Const;

/**
 * User update information such as avatar
 * 
 * @author wangxm
 * 
 */
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		String contentType = req.getContentType();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		if (contentType.contains("multipart/form-data")
				|| contentType.contains("multipart/mixed")) {
			DiskFileItemFactory dfif = new DiskFileItemFactory();
			dfif.setSizeThreshold(512 * 1024);
			createIfNotExis(Const.avatar.AVATAR_PATH);
			dfif.setRepository(new File(Const.avatar.AVATAR_PATH));
			ServletFileUpload sfu = new ServletFileUpload(dfif);
			sfu.setFileSizeMax(Const.avatar.MAX_AVATAR_SIZE);
			try {
				List<FileItem> fileList = sfu.parseRequest(req);
				Iterator<FileItem> file_iterator = fileList.iterator();
				while (file_iterator.hasNext()) {
					FileItem fi = file_iterator.next();
					if (fi == null) {
						continue;
					}
					if (fi.isFormField()) {
						String formName = fi.getFieldName();
						String formValue = fi.getString();
						hashMap.put(formName, formValue);
						continue;
					}
					String picName = hashMap.get(Const.users.USERS_PHONENUMBER)
							+ ".jpg";
					String picPath = Const.avatar.AVATAR_PATH + picName;
					fi.write(new File(picPath));
					String picUrl = req.getScheme() + "://"
							+ req.getServerName() + ":" + req.getServerPort()
							+ req.getContextPath() + "/download?avatar="
							+ picName;
					hashMap.put(Const.users.USERS_PHOTO_URL, picUrl);
				}
			} catch (Exception e) {
			}
		} else {
			if (contentType.contains("application/x-www-form-urlencoded")) {
				@SuppressWarnings("rawtypes")
				Iterator it = req.getParameterMap().entrySet().iterator();
				while (it.hasNext()) {
					@SuppressWarnings("unchecked")
					Map.Entry<Object, Object> entry = (Map.Entry<Object, Object>) it
							.next();
					hashMap.put(entry.getKey().toString(), entry.getValue()
							.toString());
				}
			} else {
				pw.write("error");
			}
		}
		
		// regedit
		
	}

	private void createIfNotExis(String avatarPath) {
		File f = new File(avatarPath);
		if (!f.exists()) {
			f.mkdirs();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
