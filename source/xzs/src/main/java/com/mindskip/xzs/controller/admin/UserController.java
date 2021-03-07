package com.mindskip.xzs.controller.admin;

import com.mindskip.xzs.base.BaseApiController;
import com.mindskip.xzs.base.RestResponse;
import com.mindskip.xzs.domain.User;
import com.mindskip.xzs.service.AuthenticationService;
import com.mindskip.xzs.service.UserService;
import com.mindskip.xzs.viewmodel.admin.user.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * @author 武汉思维跳跃科技有限公司
 */
@RestController("AdminUserController")
@RequestMapping(value = "/api/admin/user")
public class UserController extends BaseApiController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    @Autowired
    public UserController(UserService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }


    @RequestMapping(value = "/select/{id}", method = RequestMethod.POST)
    public RestResponse<UserResponseVM> select(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        UserResponseVM userVm = UserResponseVM.from(user);
        return RestResponse.ok(userVm);
    }

    @RequestMapping(value = "/current", method = RequestMethod.POST)
    public RestResponse<UserResponseVM> current() {
        User user = getCurrentUser();
        UserResponseVM userVm = UserResponseVM.from(user);
        return RestResponse.ok(userVm);
    }
}
