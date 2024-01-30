//package com.hms.api.utility;
//
//import java.sql.Date;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import com.hms.api.entity.Role;
//import com.hms.api.entity.User;
//
//public class TestDataUtility {
//
//	public  static List<User> userList() {
//		Set<Role> role = new HashSet<>();
//		role.add(new Role(1, "Role_Admin"));
//		List<User> list = Stream.of(
//				new User("ram", "RAM", "Chadar", "ram@gmail.com", "ram123", "7020192726", "Karve Nagar", "Pune",
//						"411052", "Admin", "What was your first car?", "kia", new Date(2023, 01, 29), role),
//				new User("amol", "AMOL", "Bansode", "amol@gmail.com", "amol123", "9087654321", "Karve Nagar", "Pune",
//						"411052", "Admin", "What was your first car?", "kia", new Date(2023, 01, 29), role))
//				.collect(Collectors.toList());
//
//		return list;
//
//	}
//}
