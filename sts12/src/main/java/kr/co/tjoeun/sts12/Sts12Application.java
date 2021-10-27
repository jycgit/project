package kr.co.tjoeun.sts12;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kr.co.tjoeun.sts12.model.entity.DeptDao;

@MapperScan(basePackageClasses = DeptDao.class)
@SpringBootApplication
public class Sts12Application {
    	
	public static void main(String[] args) {
		SpringApplication.run(Sts12Application.class, args);
	}
	
	@Bean
	public SqlSessionFactory getSqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		return factoryBean.getObject();
	}
	@Bean
	public SqlSession getSqlSession(SqlSessionFactory sqlSessionFactory) {
		SqlSession sqlSession=new SqlSessionTemplate(sqlSessionFactory);
		return sqlSession;
	}
}
