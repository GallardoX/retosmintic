package co.edu.usa.mintic.reto3.service;

import co.edu.usa.mintic.reto3.model.Category;
import co.edu.usa.mintic.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {

        var it = repository.findAll();
        var categories = new ArrayList<Category>();
        it.forEach(category -> categories.add(category));
        return categories;
    }

    public Optional<Category> getCategory(int id) {
        return repository.findById(id);
    }

    public Category save(Category category) {
        if(category.getId() == null) {
            return repository.save(category);
        } else {
            Optional<Category> result = repository.findById(category.getId());
            if(result.isEmpty()) {
                return repository.save(category);
            } else {
                return category;
            }
        }
    }
}
