package com.cn.my.serviceImpl;

import com.cn.my.bean.Code;
import com.cn.my.bean.CodeItem;
import com.cn.my.dao.CodeItemMapper;
import com.cn.my.dao.CodeMapper;
import com.cn.my.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sonshuai
 */
@Service
public class CodeServiceImpl  implements ICodeService {

    @Autowired
    private CodeMapper codeMapper;
    @Autowired
    private CodeItemMapper codeItemMapper;

    @Override
    public int insertCode(Code code) {
        return codeMapper.insertCode(code);
    }

    @Override
    public int updateCode(Code code) {
        return codeMapper.updateCode(code);
    }

    @Override
    public int deletetCodeById(Code code) {
        return codeMapper.deletetCodeById(code);
    }

    @Override
    public Code selectCodeById(int codeId) {
        return codeMapper.selectCodeById(codeId);
    }

    @Override
    public List<Code> selectCodeByCond(Code code){
        return codeMapper.selectCodeByCond(code);
    }

    @Override
    public int selectCodeCountByCond(Code code) {
        return codeMapper.selectCodeCountByCond(code);
    }

    @Override
    public int insertCodeItem(CodeItem codeItem) {
        return codeItemMapper.insertCodeItem(codeItem);
    }

    @Override
    public int updateCodeItem(CodeItem codeItem) {
        return codeItemMapper.updateCodeItem(codeItem);
    }

    @Override
    public int deletetCodeItemById(CodeItem codeItem) {
        return codeItemMapper.deletetCodeItemById(codeItem);
    }

    @Override
    public CodeItem selectCodeItemById(int codeItemId) {
        return codeItemMapper.selectCodeItemById(codeItemId);
    }

    @Override
    public List<CodeItem> selectCodeItemByCond(CodeItem codeItem) {
        return codeItemMapper.selectCodeItemByCond(codeItem);
    }

    @Override
    public int selectCodeItemCountByCond(CodeItem codeItem) {
        return codeItemMapper.selectCodeItemCountByCond(codeItem);
    }
}