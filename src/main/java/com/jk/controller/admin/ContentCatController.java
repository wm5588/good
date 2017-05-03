package com.jk.controller.admin;

import com.jk.annotation.OperationLog;
import com.jk.controller.BaseController;
import com.jk.service.ContentCatService;
import com.jk.vo.TreeNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 内容分类管理
 * @author cuiP
 * Created by JK on 2017/4/21.
 */
@Controller
@RequestMapping("/admin/content/cat")
public class ContentCatController extends BaseController {

    private static final String BASE_PATH = "admin/content/";

    @Resource
    private ContentCatService contentCatService;

    @GetMapping
    public String list(){
        return BASE_PATH + "content-cat-list";
    }

    /**
     * 内容分类树
     *
     * @return
     */
    @OperationLog(value = "内容分类树")
    @GetMapping("/tree")
    public ResponseEntity<List<TreeNode>> getTreeList() {
        try {
            List<TreeNode> treeNodeList = contentCatService.findTreeList();
            return ResponseEntity.ok(treeNodeList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
