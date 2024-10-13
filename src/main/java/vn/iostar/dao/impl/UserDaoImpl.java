package vn.iostar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.configs.DBconnectMySQL;
import vn.iostar.dao.IUserDao;
import vn.iostar.models.UserModel;

public class UserDaoImpl extends DBconnectMySQL implements IUserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	

	@Override
	public List<UserModel> findAll() {
		String sql ="select * from users";
		
		List<UserModel> list = new ArrayList<>();//tạo 1 List để truyển dữ liệu
		
		try {
			conn = super.getConnection();//kết nối db
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next() /*Next từng dòng tới cuối bảng*/) {
				list.add(
						new UserModel(
								rs.getInt("id"), 
								rs.getString("username"), 
								rs.getString("password"), 
								rs.getString("email"), 
								rs.getString("fullname"), 
								rs.getString("images")
								)
						);//add vào
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO users(id, username, email, pasword, images, fullname) VALUE (?, ?, ?, ?, ?, ?)";
		
		try {
			conn = super.getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1,  user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getImages());
			ps.setString(6, user.getFullname());
			
			ps.executeUpdate(); 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		UserDaoImpl userDao = new UserDaoImpl();
		//System.out.println(userDao.findOne(1));
		List<UserModel> list = userDao.findAll();
		
		for(UserModel user : list) {
			System.out.println(user);
		}
	}

	@Override
	public UserModel findByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
