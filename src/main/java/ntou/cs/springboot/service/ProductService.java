package ntou.cs.springboot.service;

import ntou.cs.springboot.entity.Product;
import ntou.cs.springboot.exception.NotFoundException;
import ntou.cs.springboot.parameter.ProductRequest;
import ntou.cs.springboot.parameter.QueryParameter;
import ntou.cs.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;

	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}

	public Product getProduct(String id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Can't find product."));
	}

	public Product createProduct(ProductRequest request) {
		Product product = new Product();
		product.setName(request.getName());
		product.setPrice(request.getPrice());

		return repository.insert(product);
	}

	public Product replaceProduct(String id, ProductRequest request) {
		Product oldProduct = getProduct(id);

		Product product = new Product();
		product.setId(oldProduct.getId());
		product.setName(request.getName());
		product.setPrice(request.getPrice());

		return repository.save(product);
	}

	public void deleteProduct(String id) {
		repository.deleteById(id);
	}

	public List<Product> getProducts(QueryParameter param) {
		String orderBy = param.getOrderedBy();
		String sortRule = param.getSortRule();
		String keyword = param.getKeyword();

		Sort sort = null;
		if (orderBy != null && sortRule != null) {
			Sort.Direction direction = sortRule.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;

			sort = Sort.by(direction, orderBy);
		}

		if (keyword == null) {
			keyword = "";
		}

		if (sort != null) {
			return repository.findByNameLike(keyword, sort);
		}

		return repository.findByNameLike(keyword);
	}

}
