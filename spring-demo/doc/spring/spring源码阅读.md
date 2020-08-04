
### BeanDefinitionReader
debug调试，根据调用栈追踪调用细节

断点位置：org.springframework.beans.factory.support.DefaultListableBeanFactory.registerBeanDefinition

关键词： location, Resource, ResourceLoader, BeanDefinitionReader, BeanDefinitionRegistry, DefaultListableBeanFactory



高级容器
BeanFactory vs FactoryBean

组件扫描： 自动发现应用容器中需要创建的Bean
自动装配： 自动满足Bean之间的依赖  org.springframework.beans.factory.config.AutowireCapableBeanFactory

ApplicationContext常用容器

传统的基于xml配置的经典容器
FileSystemXmlApplicationContext -- 从文件系统加载配置
ClassPathXmlApplicationContext -- 从classpath加载配置
XmlWebApplicationContext -- 用于web应用程序的容器

目前比较流行的容器--注解
以下都是在springboot项目中
AnnotationConfigServletWebServerApplicationContext 
AnnotationConfigReactiveWebServerApplicationContext  -- 响应式编程
AnnotationConfigApplicationContext


file 或 xml容器共性： refresh()
容器初始化、配置解析
BeanFactoryPostProcessor和BeanPostProcessor的注册和激活
国际化配置



容器初始化主要做的事情

配置文件读取--读取-->Resource--解析-->BeanDefinition--注册-->容器


spring可以根据地址自动选择正确的Resource
强大的加载资源的方式： 自动识别“classpath:”、“file:”等资源地址前缀
支持自动解析Ant风格带通配符的资源地址

Ant: 路径匹配表达式，用来对URI进行匹配 （正则表达式则适用范围更广）
> `?` 匹配任何单字符
> `*` 匹配0或者任意数量的字符
> `**` 匹配0个或者更多的目录

BeanDefinitionReader
利用者：
读取BeanDefinition
BeanDefinitionRegistry

经过调试：无论是xml 还是 注解方式，都会到 
org.springframework.beans.factory.support.DefaultListableBeanFactory#registerBeanDefinition 断点可以打在这个方法中




