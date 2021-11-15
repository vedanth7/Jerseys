package com.example.project.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.project.model.Admin;



@Repository
public interface AdminDao {
	public int loginValidation(String username,String password);
	public List<Admin> getAdmin();
	public void addAdmin(Admin admin);
	public void deleteAdmin(int id);
	public void updateAdmin(Admin admin);
}
