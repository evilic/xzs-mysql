package com.mindskip.xzs.controller.wx.student;

import com.mindskip.xzs.base.RestResponse;
import com.mindskip.xzs.controller.wx.BaseWXApiController;
import com.mindskip.xzs.domain.User;
import com.mindskip.xzs.domain.enums.RoleEnum;
import com.mindskip.xzs.domain.enums.UserStatusEnum;
import com.mindskip.xzs.service.AuthenticationService;
import com.mindskip.xzs.service.UserService;
import com.mindskip.xzs.utility.DateTimeUtil;
import com.mindskip.xzs.viewmodel.student.user.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.UUID;


/**
 * @author 武汉思维跳跃科技有限公司
 */
@Controller("WXStudentUserController")
@RequestMapping(value = "/api/wx/student/user")
@ResponseBody
public class UserController extends BaseWXApiController {

    private final UserService userService;
    private final AuthenticationService authenticationService;
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public UserController(UserService userService, AuthenticationService authenticationService, ApplicationEventPublisher eventPublisher) {
        this.userService = userService;
        this.authenticationService = authenticationService;
        this.eventPublisher = eventPublisher;
    }

    @RequestMapping(value = "/current", method = RequestMethod.POST)
    public RestResponse<UserResponseVM> current() {
        User user = getCurrentUser();
        UserResponseVM userVm = UserResponseVM.from(user);
        userVm.setBirthDay(DateTimeUtil.dateShortFormat(user.getBirthDay()));
        return RestResponse.ok(userVm);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RestResponse register(@Valid UserRegisterVM model) {
        User existUser = userService.getUserByUserName(model.getUserName());
        if (null != existUser) {
            return new RestResponse<>(2, "用户已存在");
        }
        User user = modelMapper.map(model, User.class);
        String encodePwd = authenticationService.pwdEncode(model.getPassword());
        user.setUserUuid(UUID.randomUUID().toString());
        user.setPassword(encodePwd);
        user.setRole(RoleEnum.STUDENT.getCode());
        user.setStatus(UserStatusEnum.Enable.getCode());
        user.setLastActiveTime(new Date());
        user.setCreateTime(new Date());
        user.setDeleted(false);
        userService.insertByFilter(user);
//        UserEventLog userEventLog = new UserEventLog(user.getId(), user.getUserName(), user.getRealName(), new Date());
//        userEventLog.setContent("欢迎 " + user.getUserName() + " 注册来到学之思考试系统");
//        eventPublisher.publishEvent(new UserEvent(userEventLog));
        return RestResponse.ok();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RestResponse<UserResponseVM> update(@Valid UserUpdateVM model) {
        if (StringUtils.isBlank(model.getBirthDay())) {
            model.setBirthDay(null);
        }
        User user = userService.selectById(getCurrentUser().getId());
        modelMapper.map(model, user);
        user.setModifyTime(new Date());
        userService.updateByIdFilter(user);
//        UserEventLog userEventLog = new UserEventLog(user.getId(), user.getUserName(), user.getRealName(), new Date());
//        userEventLog.setContent(user.getUserName() + " 更新了个人资料");
//        eventPublisher.publishEvent(new UserEvent(userEventLog));
        UserResponseVM userVm = UserResponseVM.from(user);
        return RestResponse.ok(userVm);
    }

//    @RequestMapping(value = "/log", method = RequestMethod.POST)
//    public RestResponse<List<UserEventLogVM>> log() {
//        User user = getCurrentUser();
//        List<UserEventLog> userEventLogs = userEventLogService.getUserEventLogByUserId(user.getId());
//        List<UserEventLogVM> userEventLogVMS = userEventLogs.stream().map(d -> {
//            UserEventLogVM vm = modelMapper.map(d, UserEventLogVM.class);
//            vm.setCreateTime(DateTimeUtil.dateFormat(d.getCreateTime()));
//            return vm;
//        }).collect(Collectors.toList());
//        return RestResponse.ok(userEventLogVMS);
//    }
}
