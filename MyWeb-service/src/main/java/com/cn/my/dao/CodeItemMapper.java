package com.cn.my.dao;

import com.cn.my.bean.CodeItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CodeItemMapper {
    /**
     * 插入代码项
     * @param codeItem
     * @return
     */
    public int insertCodeItem(CodeItem codeItem);
    /**
     * 修改代码项
     * @param codeItem
     * @return
     */
    public int updateCodeItem(CodeItem codeItem);
    /**
     * 删除代码项
     * @param codeItem
     * @return
     */
    public int deletetCodeItemById(CodeItem codeItem);
    /**
     * 根据ID查找代码项
     * @param codeItemId
     * @return
     */
    public CodeItem selectCodeItemById(int codeItemId);
    /**
     * 根据条件代码项
     * @param codeItem
     * @return
     */
    public List<CodeItem> selectCodeItemByCond(CodeItem codeItem);
    /**
     * 查找数量
     * @param codeItem
     * @return
     */
    public int selectCodeItemCountByCond(CodeItem codeItem);
}