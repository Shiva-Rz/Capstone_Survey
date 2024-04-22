package com.post.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.entity.Department;
import com.post.entity.Login;
import com.post.entity.Project;
import com.post.entity.Region;
import com.post.entity.User;
import com.post.entity.UserDTO;
import com.post.repository.DepartmentRepo;
import com.post.repository.LoginRepo;
import com.post.repository.ProjectRepo;
import com.post.repository.RegionRepo;
import com.post.repository.UserRepo;

@Service

public class UserService {

	@Autowired

	private UserRepo userRepo;

	@Autowired

	private Department department;

	@Autowired

	private DepartmentRepo departmentDAO;

	@Autowired

	private Region region;

	@Autowired

	private RegionRepo regdao;

	@Autowired

	private ProjectRepo projectdao;

	@Autowired

	private LoginRepo loginRepo;

	public boolean saveOrUpdateUser(UserDTO userdto) {

		User user = new User();

		user.setUserId(userdto.getUserId());

		user.setUserFirstName(userdto.getUserFirstName());

		user.setUserLastName(userdto.getUserLastName());

		user.setUserEmailId(userdto.getUserEmailId());

		user.setUserType(userdto.getUserType());

		user.setUserMobileNumber(userdto.getUserMobileNumber());

		department = departmentDAO.findById(userdto.getDepartment()).get();

		user.setDepartment(department);

		region = regdao.findById(userdto.getRegion()).get();

		user.setRegion(region);

		List<Long> projectId = userdto.getProject();

		if (projectId != null && !projectId.isEmpty()) {

			List<Project> projects = projectdao.findAllById(projectId);

			user.setProject(projects);

		}

		userRepo.save(user);

		return true;

	}

	public boolean deleteUserById(Long userId) {

		userRepo.deleteById(userId);

		return true;

	}

	public List<User> getAllUsers() {

		return userRepo.findAll();

	}

	public List<UserDTO> getAllEmployees() {
		Iterator<User> iterator = userRepo.viewAllEmployees().iterator();
		List<UserDTO> userList = new ArrayList<>();

//		List<Long> userUserList=new ArrayList<>();
//		List<Long> loginUserList=new ArrayList<>();

		while (iterator.hasNext()) {

			User user = iterator.next();

			Long userUserId = user.getUserId();

			Login login = loginRepo.findByUserId(userUserId);
//			Long loginuserId=login.getUser().getUserId();

			UserDTO userdto = new UserDTO();

			if (login != null && (user.getDepartment() != null || user.getRegion() != null)) {
				userdto.setUserId(user.getUserId());
				userdto.setUserFirstName(user.getUserFirstName());

				userdto.setUserLastName(user.getUserLastName());

				userdto.setUserEmailId(user.getUserEmailId());

				userdto.setUserType(user.getUserType());
				userdto.setUserMobileNumber(user.getUserMobileNumber());
				userdto.setDepartment(user.getDepartment().getDepartmentId());
				userdto.setDepartmentName(user.getDepartment().getDepartmentName());
				userdto.setRegion(user.getRegion().getRegionId());
				userdto.setRegionName(user.getRegion().getRegionName());

				userList.add(userdto);
			}
		}
		return userList;

	}

	// Employee are going to map using this function
	public List<UserDTO> getEmployeesToMap() {
		Iterator<User> iterator = userRepo.viewAllEmployees().iterator();
		List<UserDTO> userList = new ArrayList<>();
		while (iterator.hasNext()) {

			User user = iterator.next();
			Long userUserId = user.getUserId();

			Login login = loginRepo.findByUserId(userUserId);
//			Long loginuserId=login.getUser().getUserId();

			UserDTO userdto = new UserDTO();
			if (login != null && (user.getDepartment() == null || user.getRegion() == null)) {
				userdto.setUserId(user.getUserId());
				userdto.setUserFirstName(user.getUserFirstName());

				userdto.setUserLastName(user.getUserLastName());

				userdto.setUserEmailId(user.getUserEmailId());

				userdto.setUserType(user.getUserType());
				userdto.setUserMobileNumber(user.getUserMobileNumber());
				userList.add(userdto);

			}
		}
		return userList;

	}

//

	public List<UserDTO> generateEmployeePassword() {
		Iterator<User> iterator = userRepo.viewAllEmployees().iterator();
		List<UserDTO> userList = new ArrayList<>();
		while (iterator.hasNext()) {

			User user = iterator.next();
			Long userUserId = user.getUserId();

			Login login = loginRepo.findByUserId(userUserId);
//		Long loginuserId=login.getUser().getUserId();

			UserDTO userdto = new UserDTO();

			if (login == null) {
				userdto.setUserId(user.getUserId());
				userdto.setUserFirstName(user.getUserFirstName());

				userdto.setUserLastName(user.getUserLastName());

				userdto.setUserEmailId(user.getUserEmailId());

				userdto.setUserType(user.getUserType());
				userdto.setUserMobileNumber(user.getUserMobileNumber());
				userList.add(userdto);

			}
		}
		return userList;

	}

//new method

	public List<Long> findUserProject(long userId) {
		 
		List<Long> list = projectdao.findUserProjectId(userId);
		return list;
 
	}
	
	
	public User findUserById(long userId) {
		return userRepo.findById(userId).get();
	}

}