package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.OracleDataBaseConnection;
import vo.MemberVo;
import vo.VoteCheckVo;

public class VoteCheckDao {
	public VoteCheckDao() {
	}

	private static VoteCheckDao dao = new VoteCheckDao();

	public static VoteCheckDao getInstance() {
		return dao;
	}

	public List<VoteCheckVo> selectList() {
		Connection conn = OracleDataBaseConnection.getConection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select v_name, '19'||substr(v_jumin,1,2)||'년'||substr(v_jumin,3,2)||'월'||substr(v_jumin, 5,2)||'일생' as bday, "
				+ "'만'||(to_number(to_char(sysdate, 'yyyy')) - to_number('19'||substr(v_jumin,1,2)))||'세' as age, "
				+ "decode(substr(v_jumin,7,1), '1', '남', '2', '여') as gender, m_no, "
				+ "substr(v_time, 1,2)||':'||substr(v_time,3) as time, "
				+ "decode(v_confirm, 'Y', '확인', 'N', '미확인') as confirm from tbl_vote_202005";
		List<VoteCheckVo> list = new ArrayList<>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new VoteCheckVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		}
		return list;
	}

	public VoteCheckVo selectOne(String v_jumin) {
		Connection conn = OracleDataBaseConnection.getConection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select v_name, '19'||substr(v_jumin,1,2)||'년'||substr(v_jumin,3,2)||'월'||substr(v_jumin, 5,2)||'일생' as bday, "
				+ "'만'||(to_number(to_char(sysdate, 'yyyy')) - to_number('19'||substr(v_jumin,1,2)))||'세' as age, "
				+ "decode(substr(v_jumin,7,1), '1', '남', '2', '여') as gender, m_no, "
				+ "substr(v_time, 1,2)||':'||substr(v_time,3) as time, "
				+ "decode(v_confirm, 'Y', '확인', 'N', '미확인') as confirm from tbl_vote_202005 where v_jumin=?";
		VoteCheckVo vo = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, v_jumin);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new VoteCheckVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));
			}
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		}
		return vo;
	}
}
