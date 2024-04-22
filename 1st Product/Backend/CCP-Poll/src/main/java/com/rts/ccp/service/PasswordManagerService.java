package com.rts.ccp.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rts.ccp.bean.PasswordManager;
import com.rts.ccp.repository.PasswordManagerRepo;

import java.util.List;

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