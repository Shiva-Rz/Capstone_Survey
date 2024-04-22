package com.relevantz.ccp.service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.model.Invitation;
import com.relevantz.ccp.model.User;
import com.relevantz.ccp.repository.InvitationRepo;
import com.relevantz.ccp.repository.UserRepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InvitationService {

    @Autowired
    private InvitationRepo invitationRepo;
    
    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private Invitation userInvitation;
    
    @Autowired
    private InvitationRepo invitaionRepo;
    
    @Autowired
    private JavaMailSender mailSender;
    
    
    

    public boolean saveOrUpdateInvitation(Invitation invitation) {
        invitationRepo.save(invitation);
        return true;
    }

    public boolean deleteInvitationById(Long invitationId) {
        invitationRepo.deleteById(invitationId);
        return true;
    }

    public List<Invitation> getAllInvitations() {
        return invitationRepo.findAll();
    }
    
    public String inviteUser(String email) throws MessagingException {
    	User user = userRepo.findByUserEmailId(email);
    	Invitation invitation = invitaionRepo.findUserByEmail(email);
    	if(user ==null && invitation ==null) {
    		inviteUserByMail(email);
    		userInvitation.setRecipientEmail(email);
    		userInvitation.setSentTime(LocalDateTime.now());
    		saveOrUpdateInvitation(userInvitation);
    		return "Pass";
    	}else if(invitation !=null) {
    		return "sent";
    	}
    	else {
    		return "Failed";
    	}
    	
    }
    
    private void inviteUserByMail(String email) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("Invitation Regarding CCP");
        mimeMessageHelper.setText("Follow the link to create your profile : http://localhost:8080/Maven-InviteEmployee/index.jsp");
        mailSender.send(mimeMessage);
    }
}