/**
 * 
 */
 
function fn_reset() {
	alert("정보를 지우고 처음부터 다시 입력합니다!");
	const frm = document.forms[0];
	frm.v_jumin.value = "";
	frm.v_name.value = "";
	frm.m_no.value = "";
	frm.v_time.value = "";
	frm.v_area.value = "";
	frm.v_confirm.value = "";
	frm.v_jumin.focus();
}

function valid_check() {
	const frm = document.forms[0];
	const v_juminf = frm.v_jumin;
	const v_namef = frm.v_name;
	const m_nof = frm.m_no;
	const v_timef = frm.v_time;
	const v_areaf = frm.v_area;
	const v_confirmf = frm.v_confirm;
	
	if (v_juminf.value == "") {
		alert("주민번호가 입력되지 않았습니다!");
		v_juminf.focus();
		return false;
	}
	if (v_namef.value == "") {
		alert("성명이 입력되지 않았습니다!");
		v_namef.focus();
		return false;
	}
	if (m_nof.value == "") {
		alert("후보번호가 선택되지 않았습니다!");
		m_nof.focus();
		return false;
	}
	if (v_timef.value == "") {
		alert("투표시간이 입력되지 않았습니다!");
		v_timef.focus();
		return false;
	}
	if (v_areaf.value == "") {
		alert("투표장소가 입력되지 않았습니다!");
		v_areaf.focus();
		return false;
	}
	if (v_confirmf.value == "") {
		alert("유권자확인이 선택되지 않았습니다!");
		return false;
	}
	frm.submit();
}