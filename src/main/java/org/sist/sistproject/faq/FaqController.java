package org.sist.sistproject.faq;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/FAQ")
@RequiredArgsConstructor//final로 자동 주입 마치 autowired
public class FaqController {

	private final FaqService faqService;
	
	@GetMapping("/registerFAQ")
		public String createFAQForm(FaqForm faqForm) {
		return "FAQ/registerFAQ";
	}
	
	// FAQ 등록 처리
	@PostMapping("/registerFAQ")
		public String createFAQ(@Valid FaqForm faqForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
		return "FAQ/registerFAQ";
		}
		String title = faqForm.getTitle();
		String content = faqForm.getContent();
		faqService.register(title, content );
		return "redirect:FAQ/FAQ";
	}
	
	// 상세보기
	@GetMapping("/FAQ/{id}")
	public String getFAQ(@PathVariable("id") Long id, Model model) {
		Faq faq = faqService.getFaq(id);
		if (faq == null) {
		    System.out.println("faq 객체가 null 입니다.");
		} else {
		    System.out.println("faq 객체: " + faq.toString());
		}
		model.addAttribute("faq", faq);
		return "FAQ/FAQDetail";
	}
	
	//목록 보기
	 @GetMapping({"", "/list"})
		public String getFAQList(Model model,@RequestParam(value = "page", defaultValue = "0")int page) {
		Page<Faq> faqList = this.faqService.getList(page);
		model.addAttribute("faqList", faqList);
		return "FAQ/FAQ";
	}
	/*
	// 수정
	@GetMapping("/faq/modify/{id}")
	public String modifyFAQ(@PathVariable("id") Long id, Model model, FaqForm faqForm) {
		// 기존 FAQ 데이터를 가져와서 폼에 보여줌
		Faq faq = faqService.getFaq(id);
		
		// 폼 객체에 기존 데이터를 담아서 전달
		FaqForm faqf = new FaqForm();
		faqf.setTitle(faq.getTitle());
		faqf.setContent(faq.getContent());
		
		model.addAttribute("faq", faqf);
		return "/FAQ/FAQ";
	}
	
	// POST: 실제 수정 처리
	@PostMapping("/faq/modify/{id}")
	public String modifyFAQ(@Valid FaqForm faqForm, BindingResult bindingResult, @PathVariable("id") Long id) {
		if (bindingResult.hasErrors()) {
		return "/FAQ/FAQ";
	}
	
	// modify 메서드 호출하여 수정
	faqService.modifyFaq(id, faqForm.getTitle(), faqForm.getContent());
	return "redirect:/FAQ/FAQ/" + id;
	}
	*/
	// 삭제
	/*
	@GetMapping("/faq/delete/{id}")
		public String deleteFAQ(@PathVariable Long id) {
		faqService.delete(id);
		return "redirect:/manager/faq/list";
	}*/
}//class
