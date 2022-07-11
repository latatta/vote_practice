<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.VoteCheckVo"%>
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
	List<VoteCheckVo> list = (List<VoteCheckVo>) request.getAttribute("list");
	%>
	<section>
		<h1>후보조회</h1>
		<table>
			<tr>
				<th>후보번호</th>
				<th>성명</th>
				<th>소속정당</th>
				<th>학력</th>
				<th>주민번호</th>
				<th>지역구</th>
				<th>대표전화</th>
			</tr>
			<%
			for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td><%=list.get(i).getV_name()%></td>
				<td><%=list.get(i).getB_day()%></td>
				<td><%=list.get(i).getV_age()%></td>
				<td><%=list.get(i).getV_gender()%></td>
				<td><%=list.get(i).getM_no()%></td>
				<td><%=list.get(i).getV_time()%></td>
				<td><%=list.get(i).getV_confirm()%></td>
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