package com.mkiats.services.entityServices;

import com.mkiats.dataAccessObjects.UserRepository;
import com.mkiats.entities.User;
import jakarta.transaction.Transactional;
import java.util.List;
import javax.management.RuntimeErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepo;

	public Page<User> getAllUsersByPage(int page, int size) {
		return userRepo.findAll(
			PageRequest.of(page, size, Sort.by("username"))
		);
	}

	public User getUser(String id) {
		return userRepo
			.findById(id)
			.orElseThrow(
				() -> new RuntimeErrorException(new Error("User not found"))
			);
	}

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
}
