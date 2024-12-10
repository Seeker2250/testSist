package org.sist.sistproject.faq;

import java.util.Optional;

import org.sist.sistproject.exception.DataNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
@Transactional
public class FaqServiceImpl implements FaqService{

	private final FaqRepository faqRepository;
	
	@Override
	public void register(String title, String content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Faq> getList(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Faq getFaq(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyFaq(Long id, String title, String content) {
		 Optional<Faq> optionalFaq = this.faqRepository.findById(id);
	        
	        if(optionalFaq.isPresent()) {
	            Faq faq = optionalFaq.get();
	            faq.setTitle(title);
	            faq.setContent(content);
	            // 자동 저장됨 (@Transactional)
	        } else {
	            throw new DataNotFoundException("FAQ not found");
	        }	
	}

}
