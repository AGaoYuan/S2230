package cn.news.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.news.entity.NewsInfo;
import cn.news.service.impl.NewsInfoServiceImpl;
import cn.news.util.PageUtil;

/**
 * Servlet implementation class NewsInfoServlet
 */
@WebServlet("/NewsInfoServlet")
public class NewsInfoServlet extends HttpServlet {
	
	//����Service��ʵ��
	private NewsInfoServiceImpl ns = new NewsInfoServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�������
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//��ȡ��ʶ����
		String action = request.getParameter("action");
		
		//��ѯȫ����¼
		if ("newslist".equals(action)) {
			//findAll(request, response);
			try {
				userlistOnePage(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		//�޸�ǰ�Ȳ�ѯ���û�ѡ���ļ�¼
		}else if ("UpAll".equals(action)) {
			specificQuery(request, response);
		//�޸�����
		}else if("updateNews".equals(action)) {
			updateSpecific(request, response);
		//ɾ�����ż�¼
		}else if("del".equals(action)) {
			Delete(request, response);
		//���һ�����ż��ļ��ϴ�
		}else if ("saveNews".equals(action)) {
			Save(request, response);
			
		}
		
		
		
		
    }
	
	

	private void userlistOnePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//0.1Page����
		PageUtil<NewsInfo> pageUtil = new PageUtil<NewsInfo>();
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
		//�ܼ�¼��
		int totalUsers = ns.getTotalNews();
		pageUtil.setTotalRecords(totalUsers);
		//��ҳ��
		int totalPages = pageUtil.getTotalRecords()%pageUtil.getPageSize()==0?pageUtil.getTotalRecords()/pageUtil.getPageSize():pageUtil.getTotalRecords()/pageUtil.getPageSize()+1;
		pageUtil.setTotalPages(totalPages);
		//���ͼ���
		List<NewsInfo> list = ns.getOnePageData(pageUtil.getPageIndex(), pageUtil.getPageSize());
		pageUtil.setList(list);
		//��page�����������request
		request.setAttribute("pageutil", pageUtil);
		try {
			//0.4ת��
			request.getRequestDispatcher("/console/newsManage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	//��ѯȫ������
	/*private void findAll(HttpServletRequest request, HttpServletResponse response){
		NewsInfo newsInfo = new NewsInfo();
		try {
			List<NewsInfo> list = ns.findAll(newsInfo);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/console/newsManage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	//��ѯ�ض�����
	private void specificQuery(HttpServletRequest request, HttpServletResponse response){
		String nid = request.getParameter("nid");
		int id = Integer.parseInt(nid);
		try {
			NewsInfo news = ns.getNews(id);
			request.setAttribute("news", news);
			request.getRequestDispatcher("/console/newsRelease.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//�޸���������
	private void updateSpecific(HttpServletRequest request, HttpServletResponse response){
		String newstitle = request.getParameter("Newstitle");
		String newssummary = request.getParameter("Newssummary");
		String newscontent = request.getParameter("Newscontent");
		String uid = request.getParameter("newsid");
		System.out.println(uid);
		int newsid =Integer.parseInt(uid);
		NewsInfo newsInfo = new NewsInfo();
		newsInfo.setNewstitle(newstitle);
		newsInfo.setNewssummary(newssummary);
		newsInfo.setNewscontent(newscontent);
		newsInfo.setNewsdate(new Date());
		newsInfo.setNewsid(newsid);
		try {
			boolean flag = ns.updateNews(newsInfo);
			if (flag) {
				request.getRequestDispatcher("/NewsInfoServlet?action=newslist").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//ɾ����������
	private void Delete(HttpServletRequest request, HttpServletResponse response){
		String uid = request.getParameter("newsid");
		try {
			boolean flag = ns.delete(uid);
			if (flag) {
				request.getRequestDispatcher("/NewsInfoServlet?action=newslist").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//�����������
	private void Save(HttpServletRequest request, HttpServletResponse response){
		//�������Ŷ���
		NewsInfo newsInfo = new NewsInfo();
		try {
			//�����ļ��ϴ���Ҫ�Ĺ�������factory��
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//����ServletFileUpload
			ServletFileUpload sfu = new ServletFileUpload(factory);
			//�жϱ��ύԪ���Ƿ�Ϊ�ļ�����
			boolean flag = ServletFileUpload.isMultipartContent(request);
			if (flag) {//����true֤���ļ��ϴ�����
				//��ȡ����Ԫ�صļ��ϣ�ÿһ������Ͷ�ΪFileItem
				List<FileItem> list = sfu.parseRequest(request);
				//ʹ��Iteratorѭ������
				Iterator<FileItem> items = list.iterator();
				while(items.hasNext()){
					//��ȡ��һ��
					FileItem item = items.next();
					if (item.isFormField()) {//�ж��Ƿ�Ϊ��ͨ�ֶ�
						String fileName = item.getFieldName();
						if ("Newstitles".equals(fileName)) {
							//�ļ��ϴ��ǿ��ܻ�������룬ʹ��getString("utf-8")�ķ�ʽ������룬����ʹ��getString()
							newsInfo.setNewstitle(item.getString("utf-8"));
						}else if ("Newssummarys".equals(fileName)) {
							newsInfo.setNewssummary(item.getString("utf-8"));
						}else if ("Newscontents".equals(fileName)) {
							newsInfo.setNewscontent(item.getString("utf-8"));
						}
						//��ȡ��ǰ����
						newsInfo.setNewsdate(new Date());
					}else{//����false֤��Ϊ�ļ�Ԫ��
						//���Ȼ�ȡ���������ڵ�λ��,���ڷ�������ַ����ָ��һ���µ��ļ���
						String uploadPath=request.getSession().
							getServletContext().
							getRealPath("upLoadFiles/");
						System.out.println(uploadPath);
						//ͨ��File�ഴ���ļ���
						File file = new File(uploadPath);
						if (!file.exists()) {//�ж��ļ����Ƿ���ڣ��������򴴽�
							file.mkdirs();
						}
						//��ȡ�ϴ�������
						String fileName = item.getName();
						//�ж��û��Ƿ���Ҫ�ϴ��ļ�
						if (!fileName.equals("")&&fileName!=null) {
							//��ȡ�ϴ��ļ�
							File uploadFile = new File(fileName);
							//ƴ��·��   �ѻ�ȡ���ķ�����ȫ·��������ϴ����ļ�
							File saveFile = new File(uploadPath,uploadFile.getName());
							//�ϴ�����
							item.write(saveFile);
							//��ֵ�������е�����
							newsInfo.setNewspic(uploadFile.getName());
						}
					}
				}
			//ѭ��������ִ����Ӳ���
			boolean isSave = ns.save(newsInfo);
			//�ж��Ƿ���ӳɹ�����ӳɹ���ת����������Ϣҳ��
			if (isSave) {
				request.getRequestDispatcher("/NewsInfoServlet?action=newslist").forward(request, response);
			}
		//��������ļ��ϴ����ӡ
		}else{
			System.out.println("�����ļ��ϴ���");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}
