package com.cn.my.dao;



import com.cn.my.bean.Code;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CodeMapper{

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
     * @param
     * @return
     */
    public List<Code> selectCodeByCond(Code code);
    /**
     * 查找数量
     * @param code
     * @return
     */
    public int selectCodeCountByCond(Code code);

}