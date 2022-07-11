<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.PartyVo"%>
<%@ page import="dao.PartyDao"%>
<%@ page import="java.util.List"%>

<%
PartyDao dao = PartyDao.getInstance();
List<PartyVo> list = dao.selectParty();

request.setAttribute("list", list);
pageContext.forward("party.jsp");
%>