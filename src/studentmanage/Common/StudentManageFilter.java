package studentmanage.Common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class StudentManageFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// ��request��response����һЩԤ����
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");	 
		chain.doFilter(request, response); // ��Ŀ����Դִ�У�����
	}

	@Override
	public void destroy() {
		System.out.println("----����������----");
	}

}
