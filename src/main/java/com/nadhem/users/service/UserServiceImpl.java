package com.nadhem.users.service;

import com.nadhem.users.dto.request.UserRequestDto;
import com.nadhem.users.dto.request.update.UpdateUserRequestDto;
import com.nadhem.users.dto.response.UserResponseDto;
import com.nadhem.users.entities.Note;
import com.nadhem.users.entities.Role;
import com.nadhem.users.entities.User;
import com.nadhem.users.repos.NoteRepository;
import com.nadhem.users.repos.RoleRepository;
import com.nadhem.users.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	UserRepository userRep;
	
	@Autowired
	RoleRepository roleRep;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private NoteRepository noteRepository;
	
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User saveUser(UserRequestDto userDto) {
		User user = new User();

		user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		user.setUsername(userDto.getUsername());
		user.setCity(userDto.getCity());
		user.setCountry(userDto.getCountry());
		user.setAddress(userDto.getAddress());
		user.setFirstname(userDto.getFirstname());
		user.setLastname(userDto.getLastname());
		user.setEmail(userDto.getEmail());
		user.setStartDate(userDto.getStartDate());
		this.userRep.save(user);

		return this.addRoleToUser(userDto.getUsername(), userDto.getRolename());
	}

	public User saveEmployee(UserRequestDto userDto, int managerId) {
		User user = new User();

		user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		user.setUsername(userDto.getUsername());
		user.setCity(userDto.getCity());
		user.setCountry(userDto.getCountry());
		user.setAddress(userDto.getAddress());
		user.setFirstname(userDto.getFirstname());
		user.setLastname(userDto.getLastname());
		user.setEmail(userDto.getEmail());
		user.setStartDate(user.getStartDate());
		user.setManagerId(managerId);
		this.userRep.save(user);

		return this.addRoleToUser(userDto.getUsername(), userDto.getRolename());
	}



	@Override
	public User addRoleToUser(String username, String rolename) {
		User usr = userRep.findByUsername(username);
		Role r = roleRep.findByRole(rolename);
		
		usr.getRoles().add(r);
		return usr;
	}

	public UserResponseDto addNoteToUser(String username, int noteId){
		User user = this.userRep.findByUsername(username);
		Note note = this.noteRepository.findById(noteId).orElseThrow(
				()-> new RuntimeException("No note much with this id")
		);
		user.getNotes().add(note);
		return UserResponseDto.toUserResponseDto(user);
	}

	
	@Override
	public Role addRole(Role role) {
		return roleRep.save(role);
	}

	@Override
	public User findUserByUsername(String username) {
		return userRep.findByUsername(username);
	}

	public UserResponseDto findUserByUsername2(String username) {
		return UserResponseDto.toUserResponseDto(userRep.findByUsername(username));
	}

	public User getUserById(int userId){
		return this.userRep.findById(userId).orElseThrow(()-> new RuntimeException("no user match with this id!"));
	}

	public UserResponseDto getUserById2(int userId){
		return UserResponseDto.toUserResponseDto(this.userRep.findById(userId).orElseThrow(()-> new RuntimeException("no user match with this id!")));

	}
	public UserResponseDto updateUserDetails(UserRequestDto userDetails, String username){
		User existingUser = this.findUserByUsername(username);

		existingUser.setEmail(userDetails.getEmail()!=null ? userDetails.getEmail() : existingUser.getEmail());
		existingUser.setCity(userDetails.getCity()!=null ? userDetails.getCity(): existingUser.getCity());
		existingUser.setCountry(userDetails.getCountry() != null ? userDetails.getCountry() : existingUser.getUsername());
		existingUser.setAddress(userDetails.getAddress() != null ? userDetails.getAddress() : existingUser.getAddress());
		existingUser.setFirstname(userDetails.getFirstname()!=null ? userDetails.getFirstname() : existingUser.getFirstname());
		existingUser.setLastname(userDetails.getLastname() != null ? userDetails.getLastname(): existingUser.getLastname());
//		existingUser.setDepartment(this.departmentService.getDepartmentById(userDetails.getDepartmentId()));
		return UserResponseDto.toUserResponseDto(this.userRep.save(existingUser));
	}



	public List<UserResponseDto> getAllUsers(String username){
		return this.userRep.findAll().stream()
				.filter(user-> user.getUsername() != username)
				.map(UserResponseDto::toUserResponseDto)
				.collect(Collectors.toList());
	}


}
