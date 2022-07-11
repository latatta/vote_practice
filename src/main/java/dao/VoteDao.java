package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.OracleDataBaseConnection;
import vo.MemberVo;
import vo.VoteVo;

public class VoteDao {
	public VoteDao() {
	}

	private static VoteDao dao = new VoteDao();

	public static VoteDao getInstance() {
		return dao;
	}

	public void insert(VoteVo vo) {
		Connection conn = OracleDataBaseConnection.getConection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into tbl_vote_202005 (v_jumin, v_name, m_no, v_time, v_area, v_confirm) values "
				+ "(?, ?, ?, ?, ?, ?)";
		List<MemberVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getV_jumin());
			pstmt.setString(2, vo.getV_name());
			pstmt.setString(3, vo.getM_no());
			pstmt.setString(4, vo.getV_time());
			pstmt.setString(5, vo.getV_area());
			pstmt.setString(6, vo.getV_confirm());
			pstmt.executeQuery();
			
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		}
	}
}
