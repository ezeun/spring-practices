package guestbook.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import guestbook.repository.template.JdbcContext;
import guestbook.vo.GuestbookVo;

@Repository
public class GuestbookRepository {
	private JdbcContext jdbcContext;
	
	public GuestbookRepository(JdbcContext jdbcContext) {
		this.jdbcContext = jdbcContext;
	}
	
	public List<GuestbookVo> findAll() {
		return jdbcContext.queryForList(
			"select id, name, contents, date_format(reg_date, '%Y-%m-%d %h:%i:%s') from guestbook order by reg_date desc",
			new RowMapper<GuestbookVo>() {

				@Override
				public GuestbookVo mapRow(ResultSet rs, int rowNum) throws SQLException {
					GuestbookVo vo = new GuestbookVo();
					vo.setId(rs.getLong(1));
					vo.setName(rs.getString(2));
					vo.setContents(rs.getString(3));
					vo.setRegDate(rs.getString(4));
					return vo;
				}
				
			});
	}

	public int insert(GuestbookVo vo) {
		return jdbcContext.excuteUpdate(
				"insert into guestbook values(null, ?, ?, ?, now())",
				new Object[] {vo.getName(), vo.getPassword(), vo.getContents()});
	}

	public int deleteByIdAndPassword(Long id, String password) {
		return jdbcContext.excuteUpdate(
				"delete from guestbook where id = ? and password= ?", 
				new Object[] {id, password});
	}

}
