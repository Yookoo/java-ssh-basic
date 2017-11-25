package com.young.dao;




import com.young.po.User;

/**
 * user单独的方法
 */
public interface UserDao extends BaseDao<User>{
		
	/**
	 * 根据名称查询
	 * @param username
	 * @return user对象
	 */
	public User findByUsername(String username);

}
