package com.data.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.data.entity.AntiqueRawFeed;
import com.data.repository.AntiqueRawFeedRepository;

@Service
public class AntiqueDataService {

	@Autowired
	AntiqueRawFeedRepository<AntiqueRawFeed> antiqueRawFeedRepository;

	public List<AntiqueRawFeed> getAllRecords() {
		return (List<AntiqueRawFeed>) antiqueRawFeedRepository.findAll();
	}

	public boolean enterRawFeed(boolean flag) {
		AntiqueRawFeed arf;
		try {
			for(int i=0;i<5;i++) {
				arf = new AntiqueRawFeed();
				arf.setFeedId("feedId"+i);
				arf.setData("223333|asaasf|23414|xvsfb"+i);

				antiqueRawFeedRepository.save(arf);
			}
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public List<AntiqueRawFeed> findByFeedId(String feedId) {
		AntiqueRawFeed arf = new AntiqueRawFeed();
		arf.setFeedId(feedId);
		Example<AntiqueRawFeed> arfExample = Example.of(arf);
		List<AntiqueRawFeed> arfList = (List<AntiqueRawFeed>) antiqueRawFeedRepository.findAll(arfExample);
		return arfList;
	}
}
