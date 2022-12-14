package com.djtu.fywz.service.impl;

import com.djtu.fywz.dao.CategoryMapper;
import com.djtu.fywz.pojo.Category;
import com.djtu.fywz.service.CategoryService;
import com.djtu.fywz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductService productService;

    @Override
    public List<Category> list() {
        List<Category> categoryList = categoryMapper.selectByExample(null);
        return categoryList;
    }

    @Override
    public void save(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public void del(int id) {
        boolean cunzai = productService.findProByCid(id);
        if(!cunzai){
            categoryMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public Category get(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }


}
