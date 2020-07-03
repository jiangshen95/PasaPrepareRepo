# 编程规约
## 命名风格
* 类型名使用 UpperCamelCase 风格，以下情况例外：DO/BO/DTO/VO/AO/PO/UID 等
* 方法名、参数名、成员变量、局部变量都统一使用 lowerCamelCase 风格
* 常量命名全部大写，单词间用下划线隔开，完整
* 抽象类名使用 Abstract 或 Base 开头；异常类名使用 Exception 结尾；测试类名以它要测试的类的名称开始，以 Test 结尾。
* 类型与中括号紧挨相连表示数组： `int[] arrayDemo`;
* POJO 类中的任何布尔型的变量，都不要加 is 前缀，否则部分框架解析会引起序列化错误
* 包名统一使用小写，点分隔符之间有且仅有一个自然语义的单词。包名统一使用单数形式；类名可以使用复数形式。
* 避免在子父类成员变量之间、或者不同代码块的局部变量之间采用完全相同的变量名
* 表示类型的名词放在词尾
* 如果模块、接口、类、方法使用了设计模式，在命名时需要体现出具体模式
* 接口类的方法和属性不要加任何修饰符号
* 对于 Service 和 DAO 类，基于 SOA 的理念，暴露出来的服务一定是接口，内部实现类用 Impl 的后缀与卸扣区别
* 形容能力的接口，形容词为接口名（-able）
* 枚举名带上 Enum 后缀
* Service/DAO 层方法命名规约，各种前缀
* 领域模型命名规约：
    * 数据对象：xxxDO，xxx 即为数据表名
    * 数据传输对象：xxxDTO，xxx 为业务领域相关名称
    * 展示对象：xxxVO，xxx 一般为网页名称
    * POJO 是 DO/DTO/BO/VO 的统称，禁止命名成 xxxPOJO
## 常量定义
* 不允许使用任何魔法值（即未经预先定义的常量）直接出现在代码中
* 在 long 或者 Long 赋值时，数值后面使用 L
* 不要使用一个常量类维护所有常量，要按常量功能进行归类
* 注意常量复用层次
* 如果常量值在一个固定范围变化，用 enum 定义
## 代码格式
* 左小括号和右边相邻字符之间不出现空格；右小括号和左边相邻字符之间也不出现空格；而左大括号前需要加空格
* if/for/while/switch/do 等保留字与括号之间都必须加空格
* 任何二目、三目运算符的左右两边都需要加一个空格
* 采用 4 个空格缩进，禁止使用 tab 字符，设置一个 tab 为四个空格
* 注释的双斜线与注释内容之间有且仅有一个空格
* 在进行类型强制转换时，右括号与强制转换值之间不需要任何空格隔开。
* 单行字符数限制不超过120个，超出需要换行
    * 第二行相对第一行缩进4 个空格，从第三行开始，不再继续缩进
    * 运算符与下文一起换行。
    * 方法调用的点符号与下文一起换行
    * 方法调用的多个参数需要换行时，在逗号后进行
    * 在括号前不要换行
* 多个参数逗号后必须加空格
* IDE的text file encoding 设置为UTF-8; IDE中文件的换行符使用Unix格式，不要 使用Windows格式
* 单个方法的总行数不超过80行。
* 不同逻辑、不同语义、不同业务的代码之间插入一个空行分隔开来以提升可读性。不要插入多个空行
## OOP 规约
* 所有覆写方法，必须加 @Override 注解
* 相同参数类型，相同业务含义，才可以使用 Java 的可变参数，避免使用 Object
* 接口过时必须加 @Deprecated 注解，并清晰地说明采用的新接口或者新服务是什么。
* 不能使用过时的类或方法
* 所有整型包装类对象之间值的比较，全部使用equals方法比较
* Object 的 equals 方法容易抛出空指针异常，应该使用常量或确定有值的对象来调用
* 浮点数之间的等值判断，基本数据类型不能用 == 来比较，包装数据类型不能用 equals 来判断
    * 指定一个误差范围，两个浮点数的差值在此范围内，则认为是相等的
    * 使用 BigDecimal 来定义值，再进行浮点数的运算操作
* 定义数据对象 DO 类时，属性类型要与数据库字段类型相匹配
* 禁止使用构造方法 BigDecimal(double) 的方式把 double 值转化为 BigDecimal 对象，会有精度损失。用 valueOf 方法
* 所有的 POJO 类属性必须使用包装数据类型
* RPC 方法的返回值和参数必须使用包装数据类型
* 所有的局部变量使用基本数据类型
* 定义 DO/DTO/VO 等 POJO 类时，不要设定任何属性默认值
* 序列化类新增属性时，请不要修改 serialVersionUID 字段，避免反序列失败；如果完全不兼容升级，避免反序列化混乱，那么请修改 serialVersionUID 值。
* 构造方法里面禁止加入任何业务逻辑，如果有初始化逻辑，请放在 init方法中。 
* POJO 类必须写 toString 方法。使用 IDE 中的工具：source> generate toString 时，如果继承了另一个POJO类，注意在前面加一下super.toString。 
* 禁止在POJO类中，同时存在对应属性xxx的isXxx()和getXxx()方法
* 当一个类有多个构造方法，或者多个同名方法，这些方法应该按顺序放置在一起，便 于阅读，此条规则优先于下一条
* 类内方法定义的顺序依次是：公有方法或保护方法 > 私有方法 > getter / setter 方法
* 循环体内，字符串的连接方式，使用StringBuilder的append方法进行扩展
* final 可以声明类、成员变量、方法、以及本地变量，下列情况使用 final 关键字：  
    * 不允许被继承的类
    * 不允许修改引用的域对象
    * 不允许被覆写的方法
    * 不允许运行过程中重新赋值的局部变量
    * 避免上下文重复使用一个变量，使用 final 可以强制重新定义一个变量，方便更好地进行重构
* 慎用 Object 的 clone 方法来拷贝对象。浅拷贝，深拷贝要覆写此方法
* 类成员与方法访问控制要从严
    * 如果不允许外部直接通过 new 来创建对象，那么构造方法必须是  private
    * 工具类不允许有 public 或 default 构造方法
    * 类非 static 成员变量并且与子类共享，必须是 protected
    * 类非 static 成员变量并且仅在本类使用，必须是 private
    * 类 static 成员变量如果仅在本类使用，必须是 private
    * 若是 static 成员变量，考虑是否为 final
## 日期时间
* 日期格式化时，传入 pattern 中表示年份统一使用小写的 y
* 获取当前毫秒数：System.currentTimeMillis(); 而不是new Date().getTime()
* 不允许在程序任何地方中使用：1）java.sql.Date 2）java.sql.Time 3） java.sql.Timestamp
## 集合处理
* 关于 hashCode 和 equals 的处理，遵循如下规则：
    * 只要重写 equals 就必须重写 hashCode
    * 因为 Set 存储的是不重复的对象，依据 hashCode 和 equals 进行判断，所以 Set 存储的对象必须重这两个方法
    * 如果自定义对象作为 Map 的键，那么必须覆写 hashCode 和 equals
* 判断所有集合内部的元素是否为空，使用isEmpty()方法，而不是size()==0的方式
* 使用 java.util.stream.Collectors 类的 toMap() 方法，注意
* 使用集合转数组的方法，必须使用集合的 toArray(T[] array) ，传入的是类型完全一致、长度为 0 的空数组
* 在使用 Collection 接口任何实现类的 addAll() 方法时，都要对输入的集合参数进行 NPE 判断，判断是否为空
* 泛型通配符<? extends T>来接收返回的数据，此写法的泛型集合不能使用 add方法，而<? super T>不能使用get方法，两者在接口调用赋值的场景中容易出错
* 集合泛型定义时，在 JDK7 及以上，使用 diamond 语法或全省略  
  ```
  // diamond方式，即<> 
  HashMap<String, String> userCache = new HashMap<>(16); 
  // 全省略方式 
  ArrayList<User> users = new ArrayList(10); 
  ```
* 使用 entrySet 遍历 Map 类集合 KV，而不是 keySet 方式进行遍历。如果是 JDK8 使用 Map.forEach() 方式
## 并发处理
* 线程安全
* 线程名称
* 线程资源必须通过线程池提供，不允许在应用中自行显式创建线程
* 线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式
* SimpleDateFormat 是线程不安全类，一般不要定义为 static 变量，如果定义为 static ，必须加锁，或者使用 DateUtils 类
* 必须回收自定义的 ThreadLocal 变量，尽量在代理中使用 try-finally 块进行回收
* 对多个资源、数据库表、对象同时加锁时，需要保持一致的加锁顺序，否则可能会造成死锁
* 乐观锁 与 悲观锁
* 使用 CountDownLatch进行异步转同步操作，每个线程退出前必须调用 countDown方 法，线程执行代码注意 catch异常，确保 countDown方法被执行到，避免主线程无法执行至 await方法，直到超时才返回结果
* ThreadLocal 对象使用 static 修饰，ThreadLocal 无法解决共享对象的更新问题。
## 控制语句
* swith
* 当 switch 括号内的变量类型为 String 并且此变量为外部参数时，必须先进行 null 判断
* 在 if/else/for/while/do 语句中必须使用大括号
* 表达异常的分支时，少用 if-else 方式，可以直接使用 return
* 将复杂逻辑判断的结果赋值给一个有意义的布尔变量名，以提高可读性
* 参数校验
## 注释规约
* 类、类属性、类方法的注释必须使用 Javadoc 规范，使用 /** 内容 */ 格式，不得使用 // xxx 方式。
* 所有的类都必须添加创建者和创建日期
* 待办事宜（TODO）:（标记人，标记时间，[预计处理时间]）
* 错误，不能工作（FIXME）:（标记人，标记时间，[预计处理时间]） 
## 其他
* 在使用正则表达式时，利用好其预编译功能，可以有效加快正则匹配速度
* 对于暂时被注释掉，后续可能恢复使用的代码片断，在注释代码上方，统一规定使用三个斜杠(///) 来说明注释掉代码的理由
# 异常日志
## 错误码
## 异常处理
* Java 类库中定义的可以通过预检查方式规避的 RuntimeException 异常不应该通过 catch 的方式来处理
* finally 块必须对资源对象、流对象进行关闭，有异常也要做 try-catch
* 不要在 finally 块中使用 return
* 在调用 RPC 、二方包、或动态生成类的相关方法时，捕捉异常必须使用 Throwable 类来进行拦截
* 避免重复的代码
## 日志规约
* 应用中不可直接使用日志系统（Log4j、Logback）中的 API，而应依赖使用日志框架（SLF4J、JCL--Jakarta Commons Logging）中的 API，使用门面模式的日志框架，有利于维护和 各个类的日志处理方式统一。
* 在日志输出时，字符串变量之间的拼接使用占位符的方式  
  `logger.debug("Processing trade with id: {} and symbol: {}", id, symbol);`
* 避免重复打印日志，浪费磁盘空间，务必在 log4j.xml中设置 additivity=false
* 生产环境禁止直接使用 System.out 或 System.err 输出日志或使用 e.printStackTrace() 打印异常堆栈
# 单元测试
# 安全规约
# MySQL 数据库
## 建表规约
## 索引规约
## SQL 语句
## ORM 映射
# 工程结构
## 应用分层
* 开放接口层：可直接封装 Service 方法暴露成 RPC 接口；通过 Web 封装成 http 接口；网关控制层等。
* 终端显示层：各个端的模板渲染并执行显示的层。当前主要是velocity 渲染，JS 渲染，JSP 渲染，移动端展示等
* Web 层：主要是对访问控制进行转发，各类基本参数校验，或者不复用的业务简单处理等
* Service 层：相对具体的业务逻辑服务层
* Manager 层：通用业务处理层：
    * 对第三方平台封装的层，预处理返回结果及转化异常信息
    * 对 Service 层通用能力的下沉，如缓存方案，中间件通用处理
    * 与 DAO 层交互，对多个 DAO 组合复用
* DAO 层：数据访问层，与底层 MySQL、Oracle、Hbase、OB 等进行数据交互
* 外部接口或第三方平台：包括其它部门 RPC 开放接口，基础平台，其它公司的 HTTP 接口
* 分层领域模型规约：
    * DO (Data Object)：此对象与数据库表结构一一对应，通过 DAO 层向上传输数据源对象
    * DTO (Data Transfer Object)：传输数据对象，Service 或 Manager 向外传输的对象
    * BO (Business Object)：业务对象，可以由 Service 层输出的封装业务逻辑的对象
    * Query：数据查询对象，各层接收上层的查询请求。注意超过 2 个参数的查询封装，禁止使用 Map 类来传输
    * VO (View Object)：显示层对象，通常是 Web 向模板渲染引擎层传输的对象
## 二方库依赖
## 服务器
# 设计规约
* 设计文档
* 例图
* 状态图
* 时序图
* 类图
* 活动图
* 可扩展性

# 附录
* POJO 专指只有 setter/getter/toString 的简单类，包括 DO/DTO/BO/VO 等
* NPE 空指针异常

> 初步阅读，还有许多条目没有深入理解，待以后用到的时候可以回头研究