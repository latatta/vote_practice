<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.VoteCheckVo"%>
<%@ page import="dao.VoteCheckDao"%>
<%@ page import="java.util.List"%>

<%
VoteCheckDao dao = VoteCheckDao.getInstance();

List<VoteCheckVo> list = dao.selectList();
request.setAttribute("list", list);
pageContext.forward("votecheck.jsp");
%>