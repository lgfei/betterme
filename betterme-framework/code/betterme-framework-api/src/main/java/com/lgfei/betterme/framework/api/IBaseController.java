package com.lgfei.betterme.framework.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lgfei.betterme.framework.core.manager.IBaseManager;
import com.lgfei.betterme.framework.model.vo.BatchDatasVO;
import com.lgfei.betterme.framework.model.vo.PageResultVO;
import com.lgfei.betterme.framework.model.vo.PageVO;
import com.lgfei.betterme.framework.model.vo.ResultVO;

import io.swagger.annotations.ApiOperation;

public interface IBaseController<T, K>
{
    IBaseManager<T, K> getManager();
    
    boolean preHandle(T entity, String params);
    
    @ApiOperation("求总数")
    @ResponseBody
    @RequestMapping(value = "/count.json", method = {RequestMethod.POST, RequestMethod.GET})
    Integer selectCount(T entity, String params);
    
    @ApiOperation("分页查询")
    @ResponseBody
    @RequestMapping(value = "/page.json", method = {RequestMethod.POST, RequestMethod.GET})
    PageResultVO<T> selectPage(T entity, PageVO page, String params);
    
    @ApiOperation("普通查询")
    @ResponseBody
    @RequestMapping(value = "/select.json", method = {RequestMethod.POST, RequestMethod.GET})
    List<T> select(T entity, String params);
    
    @ApiOperation("单个查询")
    @ResponseBody
    @RequestMapping(value = "/one.json", method = {RequestMethod.POST, RequestMethod.GET})
    T selectOne(T entity, String params);
    
    @ApiOperation("单个保存")
    @ResponseBody
    @RequestMapping(value = "/save.json", method = {RequestMethod.POST})
    public ResultVO<T> save(T entity, String params);
    
    @ApiOperation("单个保存或修改")
    @ResponseBody
    @RequestMapping(value = "/saveOrUpdate.json", method = {RequestMethod.POST})
    public ResultVO<T> saveOrUpdate(T entity, String params);
    
    @ApiOperation("单个修改")
    @ResponseBody
    @RequestMapping(value = "/update.json", method = {RequestMethod.POST})
    public ResultVO<T> update(T entity, String params);
    
    @ApiOperation("删除")
    @ResponseBody
    @RequestMapping(value = "/remove.json", method = {RequestMethod.POST})
    public ResultVO<T> remove(T entity, String params);
    
    @ApiOperation("批量保存(增删改)")
    @ResponseBody
    @RequestMapping(value = "/batchSave.json", method = {RequestMethod.POST})
    public ResultVO<T> batchSave(@RequestBody BatchDatasVO<T> datas, String params);
    
}
