# Maven 初步学习与使用
## 下载与安装
* 下载已编译的版本，直接解压
* 直接解压到指定文件夹
* 保证已经安装过 JDK ，并且已经将 JAVA_HOME 添加到了环境变量中
* 将解压后 /bin 文件夹添加到环境变量 PATH 中
* 在命令行中使用命令 mvn -v 测试是否安装成功
## 创建一个项目
* 在自己的项目目录下运行命令行，命令内容如下：  
  ```
  mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
  ```
  > ps: 以上是官方给出的指令执行会报错，正确执行要在后面的选项加上双引号，如下
  ```
  mvn archetype:generate "-DgroupId=com.mycompany.app" "-DartifactId=my-app" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DarchetypeVersion=1.4" "-DinteractiveMode=false"
  ```
  注意需要从网络上下载需要的 jar 包，消耗一些时间。
* archetype:generate 是一个 goal
## Build the Project
```
mvn package
```
要进入项目目录  
package 表示执行项目构建生命周期的一个阶段  
测试刚刚生成的 jar 包
`java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App`
## Java 9 或以上版本与 maven 版本的对应
## Maven 工具
### Maven Phases
* validate: 验证
* compile: 编译
* test: 测试，单元测试框架测试编译后的源码，不应该要求打包或部署代码
* package: 打包成可分发格式
* integration-test: 集成测试
* verify: 检查，验证包是否符合质量标准
* install: 安装到本地仓库
* deploy: 部署，远程仓库
* clean: 清理之前构建创建的文件
* site: 生成此项目的站点文档
* phase 和 goal 可以按顺序执行  
  `mvn clean dependency:copy-dependencies package`
# 官方指导教程
## 关于原型 archetype（模板？） 的使用
* 通过 `mvn archetype:generate` 快速创建项目
### 已经提供的 archetype artifactIds
### 自定义 Archetype
* archetype descriptor(archetype-metadata.xml in src/main/resources/META-INF/maven/) 列出将包含在原型中的所有文件，并对他们进行分类，以便原型机制正确的处理这些文件
* 原型插件复制的原型文件：src/main/resources/archetype-resources/
* 原型的 pom ：pom.xml in src/main/resources/archetype-resources
* pom.xml in archetype 的根目录

步骤如下：
1. 为原型工件创建新项目和 pom.xml  
   ```xml
   <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
   <modelVersion>4.0.0</modelVersion>
   
   <groupId>my.groupId</groupId>
   <artifactId>my-archetype-id</artifactId>
   <version>1.0-SNAPSHOT</version>
   <packaging>maven-archetype</packaging>
   
   <build>
    <extensions>
      <extension>
        <groupId>org.apache.maven.archetype</groupId>
        <artifactId>archetype-packaging</artifactId>
        <version>3.1.1</version>
      </extension>
    </extensions>
   </build>
   </project>
   ```
2. 创建原型描述符  archetype-metadata.xml
   ```xml
   <archetype-descriptor
        xsi:schemaLocation="http://maven.apache.org/plugins/maven-archetype-plugin/archetype-descriptor/1.1.0
        https://maven.apache.org/xsd/archetype-descriptor-1.1.0.xsd"
        xmlns="http://maven.apache.org/plugins/maven-archetype-plugin/archetype-descriptor/1.1.0"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        name="quickstart">
    <fileSets>
        <fileSet filtered="true" packaged="true">
            <directory>src/main/java</directory>
        </fileSet>
        <fileSet>
            <directory>src/test/java</directory>
        </fileSet>
    </fileSets>
   </archetype-descriptor>
   ```
3. 创建原型文件和原型 pom.xml (prototype)
   ```xml
   <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
 
    <groupId>${groupId}</groupId>
    <artifactId>${artifactId}</artifactId>
    <version>${version}</version>
    <packaging>jar</packaging>
 
    <name>${artifactId}</name>
    <url>http://www.myorganization.org</url>
 
    <dependencies>
        <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                 <version>4.12</version>
                <scope>test</scope>
        </dependency>
    </dependencies>
   </project>
   ```
4. 安装原型，运行原型插件 insall  plugin  
   `mvn install`  
   ```
   mvn archetype:generate                                  \
   -DarchetypeGroupId=<archetype-groupId>                \
   -DarchetypeArtifactId=<archetype-artifactId>          \
   -DarchetypeVersion=<archetype-version>                \
   -DgroupId=<my.groupid>                                \
   -DartifactId=<my-artifactId>
   ```
## 项目 pom.xml 的内容 Project Object Model
* project: 
* modelVersion:
* groupId:
* artifactId: 唯一基名称
* packaging: 包类型，JAR, WAR, EAR 等
* version: 
* name:
* url:
* desciption
## 编译
`mvn compile`  
遇到的编译错误，因为 JDK 的版本过高，需要在项目的 pom.xml 中指定 JDK 版本  
```xml
<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>14</maven.compiler.source>
    <maven.compiler.target>14</maven.compiler.target>
</properties>
```
或者在 setting.xml 中指定 JDK 版本
## 测试
`mvn test`  
`mvn test-compile`  只编译测试代码
## 创建 JAR 包及安装到本地仓库
`mvn package`  
`mvn -o package`  离线构建
> 在 setting.xml 中可以修改本地仓库的路径

`mvn site`  生成一个站点
`mvn clean`
## SHAPSHOT 版本
## 插件
* 如何设置插件
## 如何向 JAR 中添加资源
* `${basedir}/src/main/resources`
## 如何筛选资源文件
```xml
<build>
    <resources>
      <resource>
        <directory>src/main/resources</directory>
        <filtering>true</filtering>
      </resource>
    </resources>
  </build>
```
程序属性文件，引用 pom.xml 或者 setting.xml 中的节点的属性：  
```
# application.properties
application.name=${project.name}
application.version=${project.version}
```
资源文件还可以从获取系统属性的值或者命令行中输入的值
## 如何使用外部依赖项
```xml
<dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
```
## 将项目 Jar 部署到远程仓库
在 pom.xml 中这只远程仓库信息，在 setting.xml 中设置用户验证信息  
pom.xml
```xml
<distributionManagement>
    <repository>
      <id>mycompany-repository</id>
      <name>MyCompany Repository</name>
      <url>scp://repository.mycompany.com/repository/maven2</url>
    </repository>
  </distributionManagement>
```
setting.xml
```xml
<servers>
    <server>
      <id>mycompany-repository</id>
      <username>jvanzyl</username>
      <!-- Default value is ~/.ssh/id_dsa -->
      <privateKey>/path/to/identity</privateKey> (default is ~/.ssh/id_dsa)
      <passphrase>my_key_passphrase</passphrase>
    </server>
  </servers>
```
## 创建文档
## 如何构建其他类型的项目
## 多个模块的情况
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                      http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
 
  <groupId>com.mycompany.app</groupId>
  <artifactId>app</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>pom</packaging>
 
  <modules>
    <module>my-app</module>
    <module>my-webapp</module>
  </modules>
</project>
```
```xml
  <parent>
    <groupId>com.mycompany.app</groupId>
    <artifactId>app</artifactId>
    <version>1.0-SNAPSHOT</version>
  </parent>
```
## 关于配置文件的使用

# Maven by Example
## 核心概念
* 插件与目标：archetype-plugin generate-goal
* Maven Lifecycle
* pom.xml
## 定制一个 Maven 项目
创建一个从雅虎天气获取天气然后打印在屏幕上的项目，使用 maven 创建和管理
* 建立项目骨架：archetype:generate  
  `mvn archetype:generate "-DgroupId=org.sonatype.mavenbook.custom" "-DartifactId=simple-weather" "-Dversion=1.0"`
* 修改 pom.xml 文件，添加一个编译的插件，用 Java 5 来编译  
  ```xml
  <build>
    <plugins>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.3</version> 
        <configuration>
           <source>1.5</source>
           <target>1.5</target>
        </configuration>
      </plugin>
    </plugins>
  </build>
  ```
* 将组织、法律、开发人员信息添加到 pom.xml
* 添加新的依赖  
  添加 Dom4J, Jaxen, Velocity, Log4J
* 项目中包含 5 个类，分别是：
    * Main：入口
    * Weather：Bean
    * YahooRetriever：连接到 Yahoo Weather
    * YahooParser：解析返回的 xml 文件，并返回一个 Weather 对象
    * WeatherFormatter：接受一个 Weather 对象，创建一个 VelocityContext
* 删除项目自动创建的 Java 代码文件，建立 Weather.java
* 建立 Main.java
* YahooRetriever.java
* YahooParse.java
* 添加资源文件  
  /src/main 目录下，创建 resources 文件夹
* 编译与运行 ps: 由于 API 接口失效，测试不成功，暂时不做调整
* ` mvn dependency:resolve ` 显示所有的依赖  
  `mvn dependency:tree`  依赖树
* 编写单元测试
* 添加测试的依赖  `<scop>test</scop>`
* 添加单元测试的资源
* 运行测试  `mvn test`
* 忽略测试错误  `mvn test -Dmaven.test.failure.ignore=true`  
  ```xml
  <project>
  [...]
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <configuration>
          <testFailureIgnore>true</testFailureIgnore>
          <skip>true</skip>
        </configuration>
      </plugin>
    </plugins>
  </build>
  [...]
  </project>
  ```
* 跳过测试阶段：`mvn install -Dmaven.test.skip=true`
* 构建打包命令行程序  
  maven-assembly-plugin: jar-with-dependencies
* 将装配目标附加到打包阶段 `<executions><execution></execution></executions>`
## 一个简单的 web 应用
* Spring Framework
* 创建项目  
  `mvn archetype:generate "-DgroupId=org.sonatype.mavenbook.simpleweb" "-DartifactId=simple-webapp" "-Dpackage=org.sonatype.mavenbook" "-Dversion=1.0-SNAPSHOT"`
* 设置 Jetty 插件  
  ```xml
  <project>
    [...]
    <build>
      <finalName>simple-webapp</finalName>
      <plugins>
        <plugin>
          <groupId>org.mortbay.jetty</groupId>
          <artifactId>maven-jetty-plugin</artifactId>
        </plugin>
      </plugins>
    </build>
    [...]
  </project>
  ```
  `mvn jetty:run` 启动 jetty 服务器  
  由于 jetty 插件的版本问题，会导致错误，使用最新的插件，新的配置信息如下：  
  ```xml
  <plugins>
    <!-- maven测试插件 -->
    <plugin>
        <groupId>org.eclipse.jetty</groupId>
        <artifactId>jetty-maven-plugin</artifactId>
        <version>9.4.11.v20180605</version>
    </plugin>
  </plugins>
  ```
* 添加一个简单的 Servlet  
  src/main/java/org/sonatype/mavenbook/web/SimpleServlet.java  
  编译 'mvn compile'  
  遇到错误，缺少依赖 javax.servlet 需要在 pom.xml 中添加依赖项  
  ```xml
  <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>3.1.0</version>
      <scope>provided</scope>
  </dependency>
  ```
## 一个多模块项目
* 父目录中创建 pom.xml
## 多模块企业项目
## POMs 优化与重构
* 优化依赖  
    * 把重复的依赖移到父 pom.xml 中的 <dependencyManagement> 标签中，子项目可以省略版本和排除项
    * 子项目中使用内建项目版本号和 groupId  
      `${project.version}` `${project.groupId}`
* 优化插件  
  `<properties>` 标签 定义一些属性  
  `<pluginManagement>`
* 使用 Maven 依赖插件优化  
  `mvn dependency:analyze`  
  `mvn dependency:tree`
# 在 Maven 中使用 阿里巴巴开发规约插件
```xml
<dependency>
    <groupId>com.alibaba.p3c</groupId>
    <artifactId>p3c-pmd</artifactId>
    <version>1.3.6</version>
</dependency>
```