package com.cn.my.service;

import com.cn.my.bean.Code;
import com.cn.my.bean.CodeItem;

import java.util.List;

/***
 * @author songshuai
 */
public interface ICodeService {
    /**
     * 插入代码
     * @param code
     * @return
     */
    public int insertCode(Code code);
    /**
     * 修改代码
     * @param code
     * @return
     */
    public int updateCode(Code code);
    /**
     * 删除代码
     * @param code
     * @return
     */
    public int deletetCodeById(Code code);
    /**
     * 根据ID查找代码
     * @param codeId
     * @return
     */
    public Code selectCodeById(int codeId);
    /**
     * 根据条件代码
     * @param code
     * @return
     */
    public List<Code> selectCodeByCond(Code code);
    /**
     * 查找数量
     * @param code
     * @return
     */
    public int selectCodeCountByCond(Code code);
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