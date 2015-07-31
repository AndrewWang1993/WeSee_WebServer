package com.peoce.wesee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.peoce.wesee.constant.Const;
import com.peoce.wesee.model.User;
import com.peoce.wesee.utils.UserUtil;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static int ERROR_CODE = Const.error_code.SUCCESS;
	private User u = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		int id = 0;
		String phoneNumber = null;
		String nickName = null;
		String password = null;
		try {
			id = Integer.valueOf(req.getParameter(Const.users.USERS_ID));
		} catch (NumberFormatException e) {
			ERROR_CODE = Const.error_code.PARAM_MALE_FORMAT_ERROT;
			System.out.println("should ente a valid id number!!!");
			write(ERROR_CODE, resp);
			e.printStackTrace();
			return;
		}
		phoneNumber = req.getParameter(Const.users.USERS_PHONENUMBER);
		nickName = req.getParameter(Const.users.USERS_NICKNAME);
		password = req.getParameter(Const.users.USERS_PASSWORD);

		if (password != null) {
			if (id != 0) {
				u = UserUtil.getInstance().loginWithId(id, password);
			} else if (phoneNumber != null) {
				u = UserUtil.getInstance()
						.loginWithPhone(phoneNumber, password);
			} else if (nickName != null) {
				u = UserUtil.getInstance().loginWithNick(nickName, password);
			} else {
				ERROR_CODE = Const.error_code.PARAM_DISMATCH_ERROT;
				System.out.println("parameters does not match !!!");
				write(ERROR_CODE, resp);
				return;
			}
		} else {
			ERROR_CODE = Const.error_code.PARAM_DISMATCH_ERROT;
			System.out.println("parameters does not match !!!");
			write(ERROR_CODE, resp);
			return;
		}
		write(ERROR_CODE, resp);
	}

	private void write(int error_code, HttpServletResponse resp) {
		PrintWriter pw = null;
		try {
			pw = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (Const.error_code.SUCCESS == error_code && null != u) {
			String respJson = JSON.toJSONString(u);
			pw.write(respJson);
		} else {
			pw.write("{errorcode:" + ERROR_CODE + "}");
		}
		pw.flush();
		pw.close();
	}
}
