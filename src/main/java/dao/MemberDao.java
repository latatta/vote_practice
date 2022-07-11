package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.OracleDataBaseConnection;
import vo.MemberVo;

public class MemberDao {
	public MemberDao() {
	}

	private static MemberDao dao = new MemberDao();

	public static MemberDao getInstance() {
		return dao;
	}

	public List<MemberVo> selectList() {
		Connection conn = OracleDataBaseConnection.getConection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select mt.m_no, mt.m_name, pt.p_name, decode(mt.p_school, '1', '고졸', '2', '학사', '3', '석사', '4', '학사'), "
				+ "substr(mt.m_jumin, 1, 6)||'-'||substr(mt.m_jumin, 6), mt.m_city, "
				+ "substr(pt.p_tel1, 1, 2)||'-'||pt.p_tel2||'-'||pt.p_tel3 as p_tel "
				+ "from tbl_member_202005 mt, tbl_party_202005 pt "
				+ "where pt.p_code = mt.p_code";
		List<MemberVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(new MemberVo(rs.getString(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getString(7)));
			}
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		}
		return list;
	}
}
