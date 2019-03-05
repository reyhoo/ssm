package com.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import com.mybatis.pojo.SexEnum;
@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(SexEnum.class)
public class SexEnumTypeHandler implements TypeHandler<SexEnum>{

	@Override
	public SexEnum getResult(ResultSet arg0, String arg1) throws SQLException {
		int id = arg0.getInt(arg1);
		return SexEnum.getSexById(id);
	}

	@Override
	public SexEnum getResult(ResultSet arg0, int arg1) throws SQLException {
		int id = arg0.getInt(arg1);
		return SexEnum.getSexById(id);
	}

	@Override
	public SexEnum getResult(CallableStatement arg0, int arg1) throws SQLException {
		int id = arg0.getInt(arg1);
		return SexEnum.getSexById(id);
	}

	@Override
	public void setParameter(PreparedStatement arg0, int arg1, SexEnum arg2, JdbcType arg3) throws SQLException {
		arg0.setInt(arg1, arg2.getId());
	}

}
