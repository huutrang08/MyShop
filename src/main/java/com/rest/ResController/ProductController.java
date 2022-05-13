package com.rest.ResController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
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

import com.rest.DTO.PageIn;
import com.rest.DTO.ProductDTO;
import com.rest.Entity.Category;
import com.rest.Entity.Product;
import com.rest.Services.ProductServices;
import com.rest.Services.StorageServices;

@RestController
@RequestMapping("pro")
public class ProductController {
	@Autowired
	ProductServices productServices;
	
	@Autowired
	StorageServices storageServices;
	
	@RequestMapping(value = "products", method = RequestMethod.GET,
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
		Page<Product> resultPage = productServices.findAll(pageable);
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

	@RequestMapping(value = "product", method = RequestMethod.POST,
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE
			}
			)
	@ResponseBody
	public Product Addproduct(@RequestBody ProductDTO product){
		Product entity = new Product();
		BeanUtils.copyProperties(product, entity);
		Category category = new Category();
		category.setCategotyId(product.getCategory().getCategoryId());
		entity.setCategory(category);
		productServices.save(entity);
		return entity;
	}
	
	@RequestMapping(value = "product/{productId}", method = RequestMethod.GET,
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE
			}
			)
	@ResponseBody
	public ResponseEntity<ProductDTO> searchEntity(@PathVariable("productId") Integer id){
		ProductDTO productDTO = new ProductDTO();
		BeanUtils.copyProperties(productServices.findById(id).get(), productDTO);
		return ResponseEntity.ok().body(productDTO);
	}
	@RequestMapping(value = "product/{id}", method = RequestMethod.DELETE,
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE
			}
			)
	@ResponseBody
	public String DeleProduct(@PathVariable("id") Integer id) throws IOException{
		Optional<Product> optional = productServices.findById(id);
		if (optional.isPresent()) {
			productServices.delete(optional.get());
			return "Delete Success";
		}else {
			return "Delete Faild";
		}
	}
}
