package com.mindskip.xzs.service.impl;

import com.mindskip.xzs.domain.ctm.CategoryCondition;
import com.mindskip.xzs.domain.ctm.CategoryInfo;
import com.mindskip.xzs.repository.CategoryMapper;
import com.mindskip.xzs.service.CategoryCtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryCtmServiceImpl implements CategoryCtmService {

    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryCtmServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryInfo> listAllCategories() {
        return findItems(null, 1, null);
    }

    @Override
    public List<CategoryInfo> listSubjectsInCategory(String categoryId) {
        CategoryInfo targetCategory = findOneItem(categoryId, 1, null);
        return findItems(null, 2, targetCategory.getId());
    }

    @Override
    public List<CategoryInfo> listUnitsInSubject(String subjectId, String categoryId) {
        CategoryInfo targetCategory = findOneItem(categoryId, 1, null);
        CategoryInfo targetSubject = findOneItem(subjectId, 2, targetCategory.getId());
        return findItems(null, 3, targetSubject.getId());
    }

    private List<CategoryInfo> findItems(String uuid, Integer level, Integer parentId) {
        CategoryCondition condition = new CategoryCondition();
        condition.setUuid(uuid);
        condition.setLevel(level);
        condition.setParentId(parentId);
        return categoryMapper.selectByCondition(condition);
    }

    private CategoryInfo findOneItem(String uuid, Integer level, Integer parentId) {
        return findItems(uuid, level, parentId).get(0);
    }
}
