package com.rest.ResController;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.DTO.CategoryDTO;
import com.rest.DTO.CategoryResponse;
import com.rest.DTO.PageIn;
import com.rest.Entity.Category;
import com.rest.Services.CategoryServices;


@RestController
@RequestMapping("cat")
public class CategoryController {
   @Autowired
	CategoryServices categoryServices;
	
	@RequestMapping(value = "category/{name}", method = RequestMethod.GET,
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE
			}
			)
	@ResponseBody
	public ResponseEntity<CategoryResponse> get(@PathVariable("name") String name){
		List<Category> list =categoryServices.findByNameContaining(name);
		CategoryResponse categoryResponse = new CategoryResponse();
		categoryResponse.setCategoryDTOs(list);
		return ResponseEntity.ok(categoryResponse);
	}
	
	
	@RequestMapping(value = "category/{id}", method = RequestMethod.GET,
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE
			}
			)
	@ResponseBody
	public ResponseEntity<CategoryDTO> get(@PathVariable("name") Integer id){
		Optional<Category> optional =categoryServices.findById(id);
		CategoryDTO categoryDTO = new CategoryDTO();
		BeanUtils.copyProperties(optional.get(), categoryDTO);
		return ResponseEntity.ok(categoryDTO);
	}
	
	@RequestMapping(value = "category", method = RequestMethod.GET,
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE
			}
			)
	@ResponseBody
	public ResponseEntity<CategoryResponse> getlist(){
		List<Category> list =categoryServices.findAll();
		CategoryResponse categoryResponse = new CategoryResponse();
		categoryResponse.setCategoryDTOs(list);
		return ResponseEntity.ok(categoryResponse);
	}
	
	@RequestMapping(value = "category", method = RequestMethod.POST,
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE
			}
			)
	@ResponseBody
	public ResponseEntity<CategoryDTO> add(@RequestBody CategoryDTO dto){
		Category category = new Category();
		BeanUtils.copyProperties(dto, category);
		categoryServices.save(category);
		return ResponseEntity.ok(dto);
	}
	
	@RequestMapping(value = "categorys", method = RequestMethod.GET,
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE
			}
			)
	@ResponseBody
	public ResponseEntity<PageIn> search(@RequestParam("page") Optional<Integer> page,@RequestParam("size") Optional<Integer> size) {
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);
		PageIn pageIn = new PageIn();
		Pageable pageable = PageRequest.of(currentPage-1, pageSize);
		Page<Category> resultPage = categoryServices.findAll(pageable);
		int total = resultPage.getTotalPages();
		if (total>0) {
			int start = Math.max(1,currentPage-2);
			int end = Math.min(currentPage+2, total);
			if (total>5) {
				if (end == total) start = end - 5;
				else if (start==1) end =start + 5;
			}
		List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
		pageIn.setPageNumber(pageNumbers);
		}
		pageIn.setPage(resultPage);
		return ResponseEntity.ok(pageIn);
	}
	
	@RequestMapping(value = "category/{id}", method = RequestMethod.POST,
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE
			}
			)
	@ResponseBody
	public ResponseEntity<String> dele(@PathVariable("id") Integer id){
		categoryServices.deleteById(id);
		return ResponseEntity.ok("Deleted");
	}
	
}
