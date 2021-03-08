package com.mindskip.xzs.controller;

import com.mindskip.xzs.domain.ctm.CategoryInfo;
import com.mindskip.xzs.service.CategoryCtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryCtmService categoryCtmService;

    @Autowired
    public CategoryController(CategoryCtmService categoryCtmService) {
        this.categoryCtmService = categoryCtmService;
    }

    /**
     * 列出所有可选的课程分类。当前此接口的调用不需要任何权限。<br>
     * <br>
     * 使用的场景是在用户选课时获取到系统支持的课程。
     *
     * @return 所有的课程分类
     */
    @GetMapping("/v1/categories")
    public List<CategoryInfo> listAllCategories() {
        return categoryCtmService.listAllCategories();
    }

    /**
     * 列出指定课程分类下支持的所有科目。当前此接口的调用不需要任何权限。<br>
     * <br>
     * 客户选过课程后，当然是要展开科目了。<br>
     * 当前无优化。暂时未缓存这些数据。谁有需要谁自己缓存去。
     *
     * @param categoryId 指定的课程分类
     * @return 该分类下的所有科目
     */
    @GetMapping("/v1/categories/{categoryId}/subjects")
    public List<CategoryInfo> listSubjects(@PathVariable String categoryId) {
        return categoryCtmService.listSubjectsInCategory(categoryId);
    }

    /**
     * 列出指定科目下所有的章节。当前此接口的调用不需要任何权限。<br>
     * <br>
     * 这个接口才真是非必需的。具体取于管理员是否需要将题目放到指定的章节下。<br>
     * 当然，也是没有经过优化的。
     *
     * @param categoryId 指定的课程分类
     * @param subjectId  指定的科目
     * @return 该科目下所有的章节信息
     */
    @GetMapping("/v1/categories/{categoryId}/subjects/{subjectId}/units")
    public List<CategoryInfo> listUnits(@PathVariable String categoryId, @PathVariable String subjectId) {
        return categoryCtmService.listUnitsInSubject(subjectId, categoryId);
    }
}
