package com.peoce.wesee.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peoce.wesee.constant.Const;
import com.peoce.wesee.utils.EncryUtil;
import com.peoce.wesee.utils.UserUtil;

/**
 * User regedit servlet
 * @author wangxm
 *
 */
public class RegeditServlet extends HttpServlet {

	private static final long serialVersionUID = 0x0001L;
	private int ERROR_CODE = Const.error_code.SUCCESS;
	private int id = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");

		ERROR_CODE = Const.error_code.SUCCESS;
		id = 0;

		String phoneNumber = null;
		String password = null;

		phoneNumber = req.getParameter(Const.users.USERS_PHONENUMBER);
		password = req.getParameter(Const.users.USERS_PASSWORD);

		/**
		 * generatived a random id,and check if duplicate
		 */
		id = generationId();
		while (UserUtil.getInstance().checkIdDupli(id) != null) {
			id = generationId();
			continue;
		}
		/**
		 * check if phonenumber is existed
		 */
		if (phoneNumber == null) {
			ERROR_CODE = Const.error_code.PHONENUMBER_MISSED_ERROT;
			System.out.println("missing phone number!!!");
			write(ERROR_CODE, resp);
			return;
		}
		/**
		 * if user don't set password so we generatived a random password based
		 * by time
		 */
		if (password == null) {
			password = EncryUtil.getHash(String.valueOf(System.nanoTime()));
		}
		int feekCode = UserUtil.getInstance()
				.regedit(id, phoneNumber, password);
		write(feekCode, resp);
	}

	private int generationId() {
		String strId = String.valueOf(System.nanoTime());
		return Integer.valueOf(strId.substring(strId.length() - 9,
				strId.length()));
	}

	private void write(int error_code, HttpServletResponse resp) {
		PrintWriter pw = null;
		try {
			pw = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.write("{errorcode:" + error_code + "}");
		pw.flush();
		pw.close();
	}

}
