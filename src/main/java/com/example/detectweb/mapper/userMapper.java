package com.example.detectweb.mapper;

import com.example.detectweb.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface userMapper {
String chekuser(String username);

void registerUser(String username, String password);
void uploadUser(String username, String newname, String newpassword);

List<String> checkAllUsers();

void uploadImg(String imgPath);
}