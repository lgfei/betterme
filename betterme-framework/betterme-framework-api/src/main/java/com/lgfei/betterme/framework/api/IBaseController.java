package com.lgfei.betterme.framework.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lgfei.betterme.framework.core.service.IBaseService;
import com.lgfei.betterme.framework.model.vo.BatchRequestVO;
import com.lgfei.betterme.framework.model.vo.ListResponseVO;
import com.lgfei.betterme.framework.model.vo.RequestVO;
import com.lgfei.betterme.framework.model.vo.ResponseVO;

import io.swagger.annotations.ApiOperation;

public interface IBaseController<T, K> {
    IBaseService<T, K> getService();

    boolean preHandle(RequestVO<T> req);

    @ApiOperation("求总数")
    @ResponseBody
    @RequestMapping(value = "/count.json", method = { RequestMethod.POST, RequestMethod.GET })
    Integer selectCount(RequestVO<T> reqData);

    @ApiOperation("分页查询")
    @ResponseBody
    @RequestMapping(value = "/page.json", method = { RequestMethod.POST, RequestMethod.GET })
    ListResponseVO<T> selectPage(RequestVO<T> reqData);

    @ApiOperation("普通查询")
    @ResponseBody
    @RequestMapping(value = "/select.json", method = { RequestMethod.POST, RequestMethod.GET })
    ListResponseVO<T> select(RequestVO<T> reqData);

    @ApiOperation("单个查询")
    @ResponseBody
    @RequestMapping(value = "/one.json", method = { RequestMethod.POST, RequestMethod.GET })
    ResponseVO<T> selectOne(RequestVO<T> reqData);

    @ApiOperation("单个保存")
    @ResponseBody
    @RequestMapping(value = "/save.json", method = { RequestMethod.POST })
    ResponseVO<T> save(RequestVO<T> reqData);

    @ApiOperation("单个保存或修改")
    @ResponseBody
    @RequestMapping(value = "/saveOrUpdate.json", method = { RequestMethod.POST })
    ResponseVO<T> saveOrUpdate(RequestVO<T> reqData);

    @ApiOperation("单个修改")
    @ResponseBody
    @RequestMapping(value = "/update.json", method = { RequestMethod.POST })
    ResponseVO<T> update(RequestVO<T> reqData);

    @ApiOperation("删除")
    @ResponseBody
    @RequestMapping(value = "/remove.json", method = { RequestMethod.POST })
    ResponseVO<T> remove(RequestVO<T> reqData);

    @ApiOperation("批量保存(增删改)")
    @ResponseBody
    @RequestMapping(value = "/batchSave.json", method = { RequestMethod.POST })
    ResponseVO<T> batchSave(@RequestBody BatchRequestVO<T> reqData);
}
