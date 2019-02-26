package com.huowulian365.controller;

import com.huowulian365.center.base.controller.BaseController;
import com.huowulian365.center.base.response.ListResponse;
import com.huowulian365.center.base.response.ResponseEntity;
import com.huowulian365.center.base.util.CopyUtil;
import com.huowulian365.condition.CamInfoCondition;
import com.huowulian365.po.CamInfoPo;
import com.huowulian365.service.CamInfoService;
import com.huowulian365.vo.CamInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cam")
@Api(value = "/cam",description = "监控相关接口")
public class Index extends BaseController {

    @Autowired
    private CamInfoService camInfoService;

    @ApiOperation(value = "查询监控", notes = "查询监控", httpMethod = "GET")
    @GetMapping(value = "/query")
    @ResponseBody
    public ResponseEntity<CamInfoVo> query(@RequestParam Integer id) {
        CamInfoPo po = camInfoService.query(id);
        return this.getSuccessResult(CopyUtil.transfer(po, CamInfoVo.class));
    }

    @ApiOperation(value = "查询监控列表", notes = "查询监控列表", httpMethod = "GET")
    @GetMapping(value = "/getCamList")
    @ResponseBody
    public ResponseEntity<ListResponse<CamInfoVo>> getCamList() {

        List<CamInfoPo> camInfoPos = camInfoService.queryList(new CamInfoCondition());

        return this.getSuccessResult(getListResponse(CopyUtil.transfer(camInfoPos, CamInfoVo.class)));
    }
}
