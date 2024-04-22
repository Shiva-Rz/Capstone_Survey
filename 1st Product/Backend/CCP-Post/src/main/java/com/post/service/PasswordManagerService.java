package com.post.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.entity.PasswordManager;
import com.post.repository.PasswordManagerRepo;

@Service
public class PasswordManagerService {

    @Autowired
    private PasswordManagerRepo passwordManagerRepo;

    public boolean saveOrUpdatePasswordManager(PasswordManager passwordManager) {
        passwordManagerRepo.save(passwordManager);
        return true;
    }

    public boolean deletePasswordManagerById(Long passwordId) {
        passwordManagerRepo.deleteById(passwordId);
        return true;
    }

    public List<PasswordManager> getAllPasswordManagers() {
        return passwordManagerRepo.findAll();
    }
    
    public PasswordManager findByLoginId(Long loginId) {
        return passwordManagerRepo.findUser(loginId);
    }
}