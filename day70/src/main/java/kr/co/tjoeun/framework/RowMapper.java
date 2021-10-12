package kr.co.tjoeun.framework;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {

	T row(ResultSet rs) throws SQLException;
}
