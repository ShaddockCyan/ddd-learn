package com.ddd.api.web;

import com.ddd.api.converter.AuthorizeConverter;
import com.ddd.api.model.req.AuthorizeCreateReq;
import com.ddd.api.model.req.AuthorizeUpdateReq;
import com.ddd.api.model.vo.UserAuthorizeVO;
import com.ddd.applicaiton.dto.UserRoleDTO;
import com.ddd.applicaiton.service.AuthrizeApplicationService;
import com.ddd.common.result.BaseResult;
import com.ddd.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理web接口
 *
 */
@RestController
@RequestMapping("/api/user")
public class AuthorizeController {

    @Autowired
    private AuthorizeConverter authorizeConverter;

    @Autowired
    private AuthrizeApplicationService authrizeApplicationService;

    /**
     * 测试URL：http://127.0.0.1:8087/api/user?userId=xxx
     */
    @GetMapping("/query")
    public Result<UserAuthorizeVO> query(@RequestParam("userId") Long userId){
        UserRoleDTO userRoleDTO = authrizeApplicationService.queryUserAuthorize(userId);
        Result<UserAuthorizeVO> result = new Result<>();
        result.setData(authorizeConverter.toVO(userRoleDTO));
        result.setCode(BaseResult.CODE_SUCCESS);
        return result;
    }

    /**
     * 测试URL：http://127.0.0.1:8087/api/user/delete?userId=xxx
     */
    @PostMapping("/delete")
    public Result<Object> delete(@RequestParam("userId") Long userId){
        authrizeApplicationService.deleteUserAuthorize(userId);
        return Result.ok(BaseResult.DELETE_SUCCESS);
    }

    /**
     * 测试URL：http://127.0.0.1:8087/api/user/save
     * Post Body：{"userName":"yangwentao","realName":"杨","phone":13144445555,"password":"***","unitId":2,"province":"上海市","city":"上海市","county":"浦东新区","roles":[{"roleId":2}]}
     */
    @PostMapping("/save")
    public Result<Object> create(@RequestBody AuthorizeCreateReq authorizeCreateReq){
        authrizeApplicationService.createUserAuthorize(authorizeConverter.toDTO(authorizeCreateReq));
        return Result.ok(BaseResult.INSERT_SUCCESS);
    }

    /**
     * 测试URL：http://127.0.0.1:8087/api/user/update
     * Post Body：{"userId":1,"userName":"yangwentao","realName":"yangwentao-realname","phone":123,"roles":[{"roleId":2}]}
     */
    @PostMapping("/update")
    public Result<Object> update(@RequestBody AuthorizeUpdateReq authorizeUpdateReq){
        authrizeApplicationService.updateUserAuthorize(authorizeConverter.toDTO(authorizeUpdateReq));
        return Result.ok(BaseResult.UPDATE_SUCCESS);
    }
}
