## 代码规范
* 项目包名请使用单数
* 资源类名称请使用单数
* 资源URL名称请使用复数
* 变量和方法的命名请使用`驼峰规范`
* 请使用lombok，取代Getter，Setter和toString等
* 命名规范：
    * XXXResource(资源接口)
    * XXXRequestDTO（请求DTO）
    * XXXResponseDTO（响应DTO）
    * XXXService(服务)
    * XXXDAO（数据访问对象）
    

## 分层架构

```

### 
── config (配置相关)
│   ├── Constants.java
│   └── SwaggerConfiguration.java
├── dao 《数据访问层》
│   └── package-info.java
├── domain （领域相关）
│   └── Hello.java
├── rest 《控制层》      
│   ├── dto
│   │   ├── request
│   │   └── response
│   └── resource
│       └── HelloResource.java
└── service 《服务层》
    └── HelloService.java
```

![经典三层架构.png](https://upload-images.jianshu.io/upload_images/12636540-0d41090eea583bda.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 架构守护
`ARCHUNIT`是一个基于 Java 的测试库，用于检查代码的结构特性，如包和类的依赖关系、注解验证，还能检查代码分层是否一致，它可以在现有的测试环境中以单元测试的方式运⾏。
* 分层架构守护测试，如图：
![分层架构守护.png](https://upload-images.jianshu.io/upload_images/12636540-3e92d9b80fb2cf76.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* 循环依赖检测，如图：
![分层依赖.png](https://upload-images.jianshu.io/upload_images/12636540-3a0aea31e6c0f488.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


## 本地强制检测
* Checkstyle编码风格。
* 提交日志检测。e.g:“[Your name] commit messages”。
* 测试覆盖率检测， 分支和语句覆盖率大于70%。
* Push前，本地强制运行mvn clean package。  
