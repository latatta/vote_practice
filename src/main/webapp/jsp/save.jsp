<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.VoteVo" %>
<%@ page import="dao.VoteDao" %>
<%@ page import="java.util.List" %>

<%
	request.setCharacterEncoding("UTF-8");
	VoteDao dao = VoteDao.getInstance();
	String v_jumin = request.getParameter("v_jumin");
	String v_name = request.getParameter("v_name");
	String m_no = request.getParameter("m_no");
	String v_time = request.getParameter("v_time");
	String v_area = request.getParameter("v_area");
	String v_confirm = request.getParameter("v_confirm");
	VoteVo vo = new VoteVo(v_jumin, v_name, m_no, v_time, v_area, v_confirm);	
	
	dao.insert(vo);
	out.print("<script>alert('투표하기 정보가 정상적으로 등록 되었습니다!');location.href='index.jsp';");
	out.print("</script>");
%>