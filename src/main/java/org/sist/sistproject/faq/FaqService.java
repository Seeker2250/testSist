package org.sist.sistproject.faq;

import org.springframework.data.domain.Page;

public interface FaqService {
	public void register(String title, String content);
	public Page<Faq> getList(int page);
	public Faq getFaq(Long id);
	public void modifyFaq(Long id, String title, String content);
}
