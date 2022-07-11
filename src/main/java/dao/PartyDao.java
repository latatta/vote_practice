package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.OracleDataBaseConnection;
import vo.PartyVo;

public class PartyDao {
	public PartyDao() {
	}

	private static PartyDao dao = new PartyDao();

	public static PartyDao getInstance() {
		return dao;
	}

	public List<PartyVo> selectParty() {
		Connection conn = OracleDataBaseConnection.getConection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select mt.m_no, mt.m_name, count(*) as total "
				+ "from tbl_vote_202005 vt, tbl_member_202005 mt "
				+ "where vt.m_no=mt.m_no and vt.v_confirm='Y' "
				+ "group by mt.m_no, mt.m_name "
				+ "order by total desc";
		List<PartyVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new PartyVo(rs.getString(1),
									rs.getString(2),
									rs.getString(3)));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		}
		
		return list;
	}
}
