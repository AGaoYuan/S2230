package cn.news.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.news.entity.UserInfo;
import cn.news.service.IUserInfoService;
import cn.news.service.impl.UserInfoServiceImpl;
import cn.news.util.CreateExecl;
import cn.news.util.Message;
import cn.news.util.PageUtil;
import cn.news.util.VerifyCodeUtils;

@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	//ʵ����UserInfoService����
	private IUserInfoService uis = new UserInfoServiceImpl();
	
	//�������������֤��ʵ��
	private VerifyCodeUtils vcu = new VerifyCodeUtils();
	
	private AuthImage ai = new AuthImage();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//���Post�����������������
		request.setCharacterEncoding("utf-8");
		//�����Ӧ�����ı����ʽ
		response.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		//�ж��Ƿ�Ϊע��ҳ��
		if ("logout".equals(action)) {
			//���session
			request.getSession().getAttribute("uname");
			//��ת��login
			response.sendRedirect("/News/console/login.jsp");
		//�ж��Ƿ�Ϊ��½ҳ��
		}else if ("login".equals(action)) {
			//��¼
			try {
				loginTwo(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		//�ж��Ƿ�Ϊ����û�ҳ��
		}else if("add".equals(action)){
			//���
			save(request,response);
			
		//�ж��Ƿ�Ϊ�鿴�û��б�
		}else if ("list".equals(action)) {
			//��ѯ�����û�
			//findAll(request,response);
			//��ҳ��ʾ�û�
			try {
				userlistOnePage(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		//�ж��Ƿ�Ϊɾ��ҳ��
		}else if ("del".equals(action)) {
			delete(request,response);
		//�ж��Ƿ�Ϊ��ѯ�ض���¼
		}else if ("modify".equals(action)) {
			//�������������������ֳ��Ƿ�Ϊ�޸Ĳ�����ֵ
			request.setAttribute("oper", "Update");
			modify(request,response);
		//�ж��Ƿ�Ϊ�޸�
		}else if ("Update".equals(action)) {
			update(request, response);
		//JNDI����
		}else if ("JNDI".equals(action)) {
			try {
				Context ctx = new InitialContext();
				String name = (String) ctx.lookup("java:comp/env/tjndi");
				System.out.println(name);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}else if ("oper".equals(action)) {
			//�������������������ֳ��Ƿ�Ϊ��Ӳ�����ֵ
			request.setAttribute("oper", "add");
			request.getRequestDispatcher("/console/userAddForm.jsp").forward(request, response);
		//��������
		}else if ("export".equals(action)) {
			 /*Message book1 = new Message();
		        book1.setVin("0001");
		        book1.setMessagetime("2016-01-08");
		        book1.setReceivetime("2016-05-06");
		        book1.setMessagetype("��������");
		        book1.setMessagelength("123");
		        book1.setMessage("{115v23v}");
		        List<Message> list = new ArrayList<Message>();
		        list.add(book1);
		        CreateExecl.createExecl(list);*/
			List<UserInfo> user;
			try {
				user = uis.findAll();
				for (UserInfo item : user) {
					Message book1 = new Message();
					book1.setVin(item.getUid().toString());
					book1.setMessagetime("2018-08-12");
					book1.setReceivetime("2018-12-12");
					book1.setMessagetype(item.getUname());
					book1.setMessagelength("123");
					book1.setMessage(item.getUpwd());
					List<Message> list = new ArrayList<Message>();
					list.add(book1);
					CreateExecl.createExecl(list);
				}
				response.sendRedirect("/News/UserInfoServlet?action=list");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	
	
	private void loginTwo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		UserInfo uInfo = new UserInfo();
		uInfo.setUname(uname);
		uInfo.setUpwd(upwd);
		try {
			UserInfo result = uis.isLogin(uInfo);
			//�ж�UserInfo�����Ƿ�Ϊ��
			if (result!=null) {
				session = request.getSession();
				session.setAttribute("uname", uname);
				response.sendRedirect("/News/console/main.jsp");
			}else {
				response.sendRedirect("/News/console/login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	//�޸��û���Ϣ
	private void update(HttpServletRequest request, HttpServletResponse response) {
		int UID = Integer.parseInt(request.getParameter("uid"));
		String userName = request.getParameter("userName");
		String userpwd = request.getParameter("userPwd");
		UserInfo userInfo = new UserInfo();
		userInfo.setUid(UID);
		userInfo.setUname(userName);
		userInfo.setUpwd(userpwd);
		try {
			boolean flag = uis.update(userInfo);
			if (flag) {
				response.sendRedirect("/News/UserInfoServlet?action=list");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//�޸�ǰ��ѯ�ض���Ϣ
	private void modify(HttpServletRequest request, HttpServletResponse response) {
		int uid = Integer.parseInt(request.getParameter("uid"));
		try {
			UserInfo user = uis.getUser(uid);
			request.setAttribute("item", user);
			request.getRequestDispatcher("/console/userAddForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//ɾ���û���Ϣ
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String uid = request.getParameter("id");
		try {
			boolean flag = uis.delete(uid);
			if (flag) {
				response.sendRedirect("/News/UserInfoServlet?action=list");
			}else{
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//��ѯ�����û�
	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<UserInfo> list = uis.findAll();
			if (list!=null) {
				request.setAttribute("list",list);
				request.getRequestDispatcher("/console/userManage.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//����û���Ϣ
	private void save(HttpServletRequest request, HttpServletResponse response) {
		UserInfo uinfo = new UserInfo();
		String username = request.getParameter("userName");
		String userpwd = request.getParameter("userPwd");
		uinfo.setUname(username);
		uinfo.setUpwd(userpwd);
		try {
			boolean flag = uis.save(uinfo);
			if (flag) {
				request.setAttribute("msg", "��ӳɹ���");
				request.getRequestDispatcher("/UserInfoServlet?action=list").forward(request, response);
			}else{
				request.getRequestDispatcher("/News/console/userAddForm.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//��֤��¼
	private void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String VerifyCode = request.getParameter("VerifyCode");
		String vercode = (String) session.getAttribute("verCode");
		System.out.println(VerifyCode);
		System.out.println(vercode);
		if (!VerifyCode.equals(vercode)) {
			request.setAttribute("error", "��֤�����");
			String err = (String) request.getAttribute("verify");
			System.out.println(err);
			request.getRequestDispatcher("/console/login.jsp").forward(request, response);
			
		}else{
			UserInfo uInfo = new UserInfo();
			uInfo.setUname(uname);
			uInfo.setUpwd(upwd);
			try {
				UserInfo result = uis.isLogin(uInfo);
				//�ж�UserInfo�����Ƿ�Ϊ��
				if (result!=null) {
					session = request.getSession();
					session.setAttribute("uname", uname);
					response.sendRedirect("/News/console/main.jsp");
				}else {
					response.sendRedirect("/News/console/login.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//��ҳ��ʾ�û���Ϣ                                        ������ҳ��Ϣ�ĳ���
	private void userlistOnePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uname = request.getParameter("Uname");
		//0.1Page����
		PageUtil<UserInfo> pageUtil = new PageUtil<UserInfo>();
		//0.2���Ը�ֵ
		int pageSize=3;
		pageUtil.setPageSize(pageSize);
		//��ǰ�ڼ�ҳ
		int pageIndex = 1;
		String i = request.getParameter("curPage");
		if (i!=null&&!i.equals("")) {
			pageIndex=Integer.parseInt(i);
		}
		pageUtil.setPageIndex(pageIndex);
		
		int totalUserCount = 0;
		if (uname!=null&&!uname.equals("")) {
			totalUserCount = uis.getTotalUsersCount(uname);
		}else{
			//�ܼ�¼��
			totalUserCount = uis.getTotalUsers();
		}
		pageUtil.setTotalRecords(totalUserCount);
		
		//��ҳ��
		int totalPages = pageUtil.getTotalRecords()%pageUtil.getPageSize()==0?pageUtil.getTotalRecords()/pageUtil.getPageSize():pageUtil.getTotalRecords()/pageUtil.getPageSize()+1;
		pageUtil.setTotalPages(totalPages);
		//***************************
		List<UserInfo> list = null;
		if (uname!=null&&!uname.equals("")) {
			list = uis.getOnePageDataHasCondition(pageUtil.getPageIndex(), pageUtil.getPageSize(),uname);
		}else{
			//���ͼ���
			list = uis.getOnePageData(pageUtil.getPageIndex(), pageUtil.getPageSize());
		}
		pageUtil.setList(list);
		if (uname!=null&&!uname.equals("")) {
			request.setAttribute("UserName", uname);
		}
		//��page�����������request
		request.setAttribute("pageutil", pageUtil);
		try {
			String msg = (String) request.getAttribute("msg");
			request.setAttribute("MSG", msg);
			//0.4ת��
			request.getRequestDispatcher("/console/userManage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
