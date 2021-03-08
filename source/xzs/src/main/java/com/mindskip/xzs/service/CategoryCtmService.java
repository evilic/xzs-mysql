package com.mindskip.xzs.service;

import com.mindskip.xzs.domain.ctm.CategoryInfo;

import java.util.List;

public interface CategoryCtmService {
    /**
     * 列出所有分类。
     *
     * @return
     */
    List<CategoryInfo> listAllCategories();

    List<CategoryInfo> listSubjectsInCategory(String categoryId);

    List<CategoryInfo> listUnitsInSubject(String subjectId, String categoryId);
}
