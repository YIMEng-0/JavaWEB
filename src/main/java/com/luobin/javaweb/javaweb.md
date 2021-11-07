# JavaWEB相关的知识点学习
    前端时间和后端之间的信息交互：
       前端确定了访问了文件位置，调用后端的相关执行程序文件

# 对于动态的 Web 应用来讲：一个请求响应中有多少个角色的参与？角色之间是怎么进行通信的呢？
    整个 B/S 结构中，什么人参与进去？
        1、浏览器的开发者；
        2、Web Server 开发团队 Tomcat,Jetty；
        3、DB Server MySQL Oracle；
        4、Java 程序的开发 Web APP 开发
            Web 应用的开发的目录需要遵从一定的规范，在不同的 Web Server 都可以使用
            达到通用的实现规范，可以不同的服务器上面使用
            Serlet 就是制定的一套规范，可以规范的开发网络应用

    角色之间遵守什么规范？

        HTTP 协议（超文本传输协议）
        Browser 和 WebServer 之间存在的协议

        Servlet 规范，Webapp 和 WebServer 之间存在的协议
        Servlet 规范的作用：Web server ， Web App之间解耦合，减少依赖程度

        JDBC 的规范
        Webapp 和 DBServer 之间存在的规范
            

模拟 Servlet 本质
    不同的公司，制定了相关行业内部的规则，其他的开发者遵从相关的规则即可

    关于前端访问静态的 html 文件，使用到大服务器的路径就可以
    关于前端访问Java 程序，可以通过程序员执行的映射关系，进行程序的访问

    通过分析：
        JavaWeb 制作两件事情
            1、编写一个类实现Servlet 接口
            2、编写配置文件，编写的类配置到配置文件，在配置文件中指定请求路径和类名之间的关系

注意：
    配置文件的文件名字是固定好的，web.properties,配置文件的放的位置都是固定好的，不能乱来
    因为项目是需要放在服务器上面运行的，服务器的是其他公式已经写好的东西，所以需要遵从相关的规范，
    不能随便乱来；

严格意义上来说：
    Servlet 规范中规定了：
        合格的 webapp 应该是什么样子的目录结构；
        合格的 webapp 拥有什么样子的配置文件
        合格的webapp配置文件放在什么地方
        合格的webapp的Java程序放在什么地方
        这些都是规定好的

        Tomcat 服务器需要遵守规范，JavaWEB程序员也是同样需要遵守相关的规范，这样子Tomcat和
        webapp 之间才能解耦合；

Servlet 是一个什么样子的规范？
    遵循了Servlet 规范的webapp 可以在不同的额服务器的下面运行
    Servlet 规范中包括了什么呢？
        1、规定了什么样子的接口
        2、规范了一些类
        3、规范了web 应用中应该有什么样子的配置文件
        4、规范了配置文件的名字
        5、规范了配置文件存储的路径
        6、规范了webapp 配置文件中的内容...


开发一个带有 Servlet 的 webapp（重点）
    开发步骤：
        1、在webapp 目录下面新建一个目录，起名叫做 crm(crm就是webapp的名字)，起名字是根据自己的开发需要设定的
        2、在crm目录下面，新建一个目录：WEB-INF
            这个文件的创建是Servlet 中所规定的，必须是全部大写的才可以
        3、在 WEB-INF 下面新建一个目录叫做 classes 必须是这个名字，Servlet 规范中规定的
                注意：这里存放的是，Java 程序编译之后的class 文件，这李存放的是字节码文件
        4、在WEB-INF 下面创建一个新的目录：lib(不是必须的)
                Java在开发的过程中使用到了第三方的 jar 包，需要使用这个名字，必须使用这个名字
        5、在WEB-INF 新建一个文件叫做：web.xml 
                这个文件名字是必须的，文件的名字是必须叫做这个名字的，文件必须放在这里；
                web.xml 是一个配置文件，配置文件中描述了请求路径以及 Servlet 类之间的对照关系
                (这个文件直接从其他的webapp中赋值粘贴即可)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
  version="4.0"
  metadata-complete="true">

  <display-name>Tomcat Documentation</display-name>
  <description>
     Tomcat Documentation.
  </description>
</web-app>

```
        6、编写Java程序，小程序，不能随意开发，必须实现 Servlet 接口