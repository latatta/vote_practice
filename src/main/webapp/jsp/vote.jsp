<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표하기</title>
<script type="text/javascript" src="../js/jsFile.js"></script>
</head>
<body>
	<%@ include file="top.jsp"%>
	<section>
		<h1>투표하기</h1>
		<form action="save.jsp" method="post">
		<table>
			<tr>
				<th>주민번호</th>
				<td><input type="text" name="v_jumin">예 : 8906153154726</td>
			</tr>
			<tr>
				<th>성명</th>
				<td><input type="text" name="v_name"></td>
			</tr>
			<tr>
				<th>투표번호</th>
				<td><select name="m_no">
					<option selected disabled></option>
					<option value="1">[1] 김후보</option>
					<option value="2">[2] 이후보</option>
					<option value="3">[3] 박후보</option>
					<option value="4">[4] 조후보</option>
					<option value="5">[5] 최후보</option>
				</select></td>
			</tr>
			<tr>
				<th>투표시간</th>
				<td><input type="text" name="v_time"></td>
			</tr>
			<tr>
				<th>투표장소</th>
				<td><input type="text" name="v_area"></td>
			</tr>
			<tr>
				<th>유권자확인</th>
				<td><input type="radio" name="v_confirm" value="Y">확인
				<input type="radio" name="v_confirm" value="N">미확인</td>
			</tr>
			<tr>
				<td>
					<button type="button" onclick="valid_check();return false;">투표하기</button>
					<button type="button" onclick="fn_reset()">다시하기</button>
				</td>
			</tr>
		</table>
		</form>
		
		
	</section>
	<footer>HRDKOREA Copyrightⓒ All rights reserved. Human
		Resources Development Service of Korea</footer>
</body>
</html>