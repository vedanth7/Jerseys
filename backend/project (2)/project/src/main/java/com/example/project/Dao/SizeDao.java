package com.example.project.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.project.model.Size;


@Repository
public interface SizeDao {
	public List<Size> getSize();
	public void addSize(Size size);
	public void deleteSize(int id);
	public void updateSize(Size size);

}
