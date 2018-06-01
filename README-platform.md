# develop-framework-platform

提供常用jar包，常用maven插件和自研发框架版本申明

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.github.developframework</groupId>
            <artifactId>develop-framework-platform</artifactId>
            <version>${version.develop-framework}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

## 自研发项目列表

| 项目                                                         | 最新版本 | 说明                             |
| ------------------------------------------------------------ | -------- | -------------------------------- |
| [Expression](https://github.com/developframework/expression) | 1.1.0    | 以字符串表达式获取对象属性值工具 |
| [Kite](https://github.com/developframework/kite)             | 0.3      | 可配置json/xml生成器             |
| [Mock](https://github.com/developframework/mock)             | 0.2      | 随机数据生成器                   |
| [Chinese-administrative-region](https://github.com/developframework/chinese-administrative-region) | 1.0.0    | 中国行政区数据提供器             |
| [Hickey](https://github.com/developframework/hickey)         | 暂未发布 | 可配置发送http请求接口的框架     |

