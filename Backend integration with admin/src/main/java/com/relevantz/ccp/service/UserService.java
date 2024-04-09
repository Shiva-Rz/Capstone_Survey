package com.relevantz.ccp.service;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.dto.UserDTO;
import com.relevantz.ccp.model.Department;
import com.relevantz.ccp.model.Login;
import com.relevantz.ccp.model.Project;
import com.relevantz.ccp.model.Region;
import com.relevantz.ccp.model.User;
import com.relevantz.ccp.repository.DepartmentRepo;
import com.relevantz.ccp.repository.LoginRepo;
import com.relevantz.ccp.repository.ProjectRepo;
import com.relevantz.ccp.repository.LoginRepo;
import com.relevantz.ccp.repository.RegionRepo;
import com.relevantz.ccp.repository.UserRepo;

@Service
public class UserService {

//	@Autowired
//	UserRepo urRepo;
	
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

	public boolean insert(User user) {
		userRepo.save(user);
		return true;
	}

	public boolean update(User user) {
		userRepo.save(user);
		return true;
	}

	public boolean delete(long userId) {
		userRepo.deleteById(userId);
		return true;
	}

	public List<User> getAllUserDetails() {
		Iterator<User> it = userRepo.findAll().iterator();
		ArrayList<User> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	public List<User> getDetails() {
		Iterator<User> it = userRepo.getUserData().iterator();
		ArrayList<User> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
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

//	private List<Long> projectStorage = new ArrayList<Long>();
	List<String> projectList = new ArrayList<String>();
	public List<String> findUseProject(long userId) {
//		User user = userRepo.findById(userId).get();
		
		List<List<Long>> list = projectdao.findUserProjectId(userId);
		for (int i = 0; i < list.size(); i++) {
			List<Long> j = list.get(i);
			Long k = j.get(1);
			Project project = projectdao.findById(k).get();
			projectList.add(project.getProjectName());
		}
//		projectStorage.add(null);
		return projectList;
	}

}
