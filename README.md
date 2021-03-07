可供参考的资料：
- 小程序的相关开发操作步骤：https://www.bilibili.com/video/av44106850
- 相关开源的题库程序：https://www.goodfirms.co/blog/best-free-open-source-exam-software-solutions

当前后端提供的管理员接口有：

|   Api 功能   |  请求路径    |    额外说明   |
| ---- | ---- | ---- |
|    管理控制台简报  |  api/admin/dashboard/index ，method = RequestMethod.POST   |   感觉没啥用暂时。DashboardController.java   |
| 当前用户的信息 | api/admin/user/current | UserController.java |
| 列出用户 | api/admin/user/page/list | UserController.java 可以根据传来的参数进行数据的过滤（即分为学生列表，管理员列表等） |
| 列出指定用户的操作记录 | api/admin/user/event/page/list | UserController.java |
| 获取指定用户的信息 | api/admin/user/select/1 | UserController.java |
| 未看 | /edit | UserController.java |
| 未看 | /update | UserController.java |
| 未看 | /changeStatus/{id} | UserController.java |
| 未看 | /delete/{id} | UserController.java |
| 未看 | /selectByUserName | UserController.java |
| 获取学科 | api/admin/education/subject/list | EducationController.java |
| 未看 | /subject/page | EducationController.java |
| 未看 | /subject/edit | EducationController.java |
| 未看 | /subject/select/{id} | EducationController.java |
| 未看 | /subject/delete/{id} | EducationController.java |
| 获取题目列表 | api/admin/question/page | QuestionController.java |
| 未看 | /edit | QuestionController.java 不提供编辑功能 |
| 未看 | /select/{id} | QuestionController.java 后台已新建替换代码 |
| 未看 | /delete/{id} | QuestionController.java |
| 跟任务考试有关，直接删除 | api/admin/exam/paper/taskExamPage | ExamPaperController.java |
| 未看 | api/admin/exam/paper/page | ExamPaperController.java |
| 未看 | /edit | ExamPaperController.java |
| 未看 | /select/{id} | ExamPaperController.java |
| 未看 | /delete/{id} | ExamPaperController.java |
| 获取答卷列表 | api/admin/examPaperAnswer/page | ExamPaperAnswerController.java 对我来说球用没有，估计马上就干掉了 |
|  |  | 。。。。 |
剩下的先不管了，跟我的需求没有太大的关系。

我需要的功能：
- 列出提供了哪些专业的内容
- 获取指定的单个题目、增加、删除题目
- 获取指定的序列


# 学之思在线考试系统 - Mysql版

### 演示地址

* 学之思考试系统：[https://www.mindskip.net/xzs.html](https://www.mindskip.net/xzs.html)

### 开发部署教程

* [https://www.mindskip.net:889](https://www.mindskip.net:889)

### 学生系统功能

* 登录、注册： 注册时要选年级，过滤不同年级的试卷， 账号为：student/123456
* 首页： 任务中心、固定试卷、时段试卷、可以能做的一部分试卷
* 试卷中心： 包含了所有能做的试卷，按学科来过滤和分页
* 考试记录： 所有的试卷考试记录在此处分页，可以查看试卷结果、用时、得分、自行批改等
* 错题本： 所有做错的题目，可以看到做题的结果、分数、难度、解析、正确答案等
* 个人中心： 个人日志记录
* 消息： 消息通知
* 试卷答题和试卷查看： 展示出题目的基本信息和需要填写的内容

### 管理系统功能

* 登录： 账号为： admin/123456
* 主页： 包含了试卷、题目、做卷数、做题数、用户活跃度的统计功能，活跃度和做题数是按月统计
* 用户管理： 对不同角色 学生、管理员 的增删改查管理功能
* 卷题管理：
    1. 试卷列表：试卷的增删改查，新增包含选择学科、试卷类型、试卷名称、考试时间，试卷内容包含添加大标题，然后添加题目到此试卷中，组成一套完整的试卷
    2. 题目列表：题目的增删改查，目前题型包含单选题、多选题、判断题、填空题、简单题，支持图片、公式等。
* 任务管理：对任务进行修改
* 教育管理：对不同年级的学科进行增删改查
* 消息中心：可以对多个用户进行消息发送
* 日志中心：用户的基本操作进行日志记录，了解用户使用过情况

### 小程序功能

* 用户登录登出功能，登录会自动绑定微信账号，登出会解绑
* 首页包含任务中心、固定试卷、时段试卷，和web端保持一致
* 试卷模块：固定试卷和时段试卷的分页查询，下拉加载更多、上拉刷新当前数据
* 记录模块：考试结果的分页，包含了试卷基本信息
* 我的模块：包含个人资料的修改、个人动态、消息中心模块
