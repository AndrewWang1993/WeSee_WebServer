package com.peoce.wesee.servlet.circle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.TextUI;
import javax.swing.text.AbstractDocument.Content;

import ch.qos.cal10n.util.Token;

import com.alibaba.fastjson.JSON;
import com.peoce.wesee.constant.Const;
import com.peoce.wesee.constant.Const.error_code;
import com.peoce.wesee.utils.CircleUtil;
import com.peoce.wesee.utils.CommonUtil;
import com.peoce.wesee.utils.EncryUtil;
import com.peoce.wesee.utils.JsonUtil;
import com.peoce.wesee.utils.TokenUtil;
import com.peoce.wesee.utils.UserUtil;
import com.sun.xml.internal.bind.v2.TODO;

public class MyFriendListServlet extends HttpServlet {
	private static final long serialVersionUID = 0x2000L;
	private int error_code = Const.error_code.SUCCESS;
	int[] friendList;
	String token;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		int id = 0;
		error_code = Const.error_code.SUCCESS;
		try {
			id = Integer.valueOf(req.getParameter(Const.users.USERS_ID));
		} catch (NumberFormatException e) {
			System.out.println("Number Format Exception");
		} catch (Exception e) {
			e.printStackTrace();
		}
		token = req.getParameter(Const.users.USERS_TOKEN);
		if (id == 0 || token == null || token == "") {
			System.out.println("id or token can not be 0 or null");
			error_code = Const.error_code.PARAM_MISSED_ERROT;
		}
		String[] serverToken = TokenUtil.serverToken(id);
		if (token != serverToken[0] && token != serverToken[1]) {
			System.out.println("token error");
			error_code = Const.error_code.TOKEN_ERROR;
		}
		friendList=CircleUtil.GetInstance().getFriendList(id);
		write(error_code, resp);
	}

	private void write(int error_code, HttpServletResponse resp) {
		PrintWriter pw = null;
		try {
			pw = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (Const.error_code.SUCCESS == error_code && null != friendList) {

			String respJson = JsonUtil.generaJsonArray(CommonUtil.int2Integer(friendList));
			pw.write(respJson);
		} else {
			pw.write("{errorcode:" + error_code + "}");
		}
		pw.flush();
		pw.close();
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
