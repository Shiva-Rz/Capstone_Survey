package com.post.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.post.entity.Share;
import com.post.repository.ShareRepo;

@Service
public class ShareService {
	
	@Autowired
	ShareRepo sharerepo;

	public boolean addShare(Share share) {
		sharerepo.save(share);
		return true;
	}
	
	public boolean updateShare(Share share) {
		sharerepo.save(share);
		return true;
	}
	
	public boolean deleteShare(long shareId) {
		sharerepo.deleteById(shareId);
		return true;
	}
	
	public List<Share> getAllSharedDetails() {
		Iterator<Share> it=sharerepo.findAll().iterator();
		ArrayList<Share> list = new ArrayList<>();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

}
