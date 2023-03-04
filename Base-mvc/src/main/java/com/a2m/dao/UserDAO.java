package com.a2m.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.a2m.domain.DTO.UserDTO;

public class UserDAO {
	public static List<UserDTO> listUserDTOs = new ArrayList<>();
	
	public UserDTO findByUsername(String username) {
		System.out.println("Find username: " + username);
		for (int i = 0; i < listUserDTOs.size(); i++) {
			if (listUserDTOs.get(i).getUsername().equalsIgnoreCase(username)) {
				return listUserDTOs.get(i);
			}
		}
		return null;
	}
	
	public int update(UserDTO userDTO) {
		System.out.println("Update username: " + userDTO.getUsername());
		for (int i = 0; i < listUserDTOs.size(); i++) {
			if (listUserDTOs.get(i).getUsername().equalsIgnoreCase(userDTO.getUsername())) {
				listUserDTOs.set(i, userDTO);
				return i;
			}
		}
		return -1;
	}
	
	public int create(UserDTO userDTO) {
		if (findByUsername(userDTO.getUsername())!=null) {
			update(userDTO);
		}else {
			System.out.println("Create username: " +userDTO.getUsername());
			listUserDTOs.add(userDTO);
		}
		return 1;
	}
	public List<UserDTO> getAll(){
		return listUserDTOs;
	}
	
}
