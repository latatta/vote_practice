<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.PartyVo"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보조회</title>
</head>
<body>
	<%@ include file="top.jsp"%>
	<%
	List<PartyVo> list = (List<PartyVo>) request.getAttribute("list");
	%>
	<section>
		<h1>후보조회</h1>
		<table>
			<tr>
				<th>후보번호</th>
				<th>성명</th>
				<th>총투표건수</th>
			</tr>
			<%
			for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td><%=list.get(i).getM_no()%></td>
				<td><%=list.get(i).getM_name()%></td>
				<td><%=list.get(i).getV_sum()%></td>
			</tr>

			<%
			}
			%>
		</table>
	</section>
	<footer>HRDKOREA Copyrightⓒ All rights reserved. Human
		Resources Development Service of Korea</footer>
</body>
</html>