> 此部分较熟悉，在旧电脑上再熟悉一遍命令行的使用。在此主要记录常用命令

# 什么是 shell
* 提示符最后一个字符，# 代表超级用户权限，$ 代表普通用户
* X 中的鼠标跟随聚焦 单击聚焦
* df  查看磁盘
* free 内存
# 文件系统中的跳转
* pwd 显示当前路径
* ls
* cd  相对路径与绝对路径
# 探究操作系统
* 长选项使用两个中划线  --
* ls 的选项
    * -a  --all
    * -d  --directory
    * -F  --classify
    * -h  --human-readable  以人们可读而非字节形式显示大小
    * -l  长格式显示
    * -r  --reverse
    * -S  文件大小顺序排序
    * -t  修改时间顺序排序
    * -i  显示文件的节点号
* file 确定文件类型
* less 浏览文本文件内容  
  键盘命令
    * G  移到最后一行
    * 1G or g  移到开头一行
    * /charaters  向前查找指定的字符串
    * n  向前查找下一个出现的字符串
    * h  显示帮助屏幕
    * q  退出 less 程序
* 符号链接与硬链接
# 操作文件和目录
* 通配符  简化的正则
* mkdir  可以同时创建多个文件夹
* cp
    * -a  --archive  复制包括属性
    * -i  --interactive  重写已存在的文件之前提醒用户确认
    * -r  --recursive  递归的复制目录及目录中的内容
    * -u  --update  仅复制目标目录中不存在或更新的文件
    * -v  --verbose  显示翔实的命令操作信息
    * cp file1 file2 dir1
* mv  移动或重命名
* rm  删除文件或目录
    * -i  --interactive  提示用户确认
    * -r
    * -f  --force  忽视不存在的文件，不显示提示信息
    * 先用 ls 测试要删除的文件，再使用 rm 替换 ls
* ln
    * ln file link  创建硬链接
    * ln -s item link  创建符号链接
    * 使用符号链接时，要使用相对于创建的链接文件的目录结构
# 使用命令
* type  显示命令类型
* which  显示一个可执行程序的位置  
  只对可执行程序有效，不包括内建命令和命令别名
* help  得到 shell 内建命令的帮助文档
* --help  显示用法信息
* man  显示程序手册页
* apropos  显示适当的命令，基于某个关键字的匹配项
* whatis  显示非常简洁的命令说明
* info  显示程序的 info 条目
* 多个命令放在同一行，命令之间用 ; 分开
* alias name='string'  创建别名
    * unalias  删除别名
    * alias 查看所有定义在系统环境中的别名
    * 在命令行中定义，shell 会话结束时，会消失
# 重定向
* \>  输出重定向符
* \>>  追加 而非从头开始
* 2>  标准错误重定向
* &>  联合的重定向  标准输出和错误
* /dev/null  垃圾桶
* cat  读取一个或多个文件，然后复制他们到标准输出
    * 单独使用 cat 表示从标准输入（键盘输入）读取文件
* <  输入重定向
* 管道线 "|"  一个命令的标准输出通过管道送至另一个命令的标准输入
* 过滤器  几个命令放在一起组成一个管道
    * sort  排序
    * uniq  删除重复行  -d  不删除
* wc  字计数命令  显示文件所包含的行数、字数和字节数
* grep  找到文件中的匹配文本
* head/tail -n 5 file  打印文件开头/结尾部分
    * tail -f  选项  继续监视这个文件，新的内容添加后，立即出现在屏幕上
* tee  从 Stdin 读取数据，并同时输出到 Stdout 和文件  
  ls /usr/bin | tee ls.txt | grep zip
# 从 shell 眼中看世界
* echo  命令  任意一个参数都会在屏幕上显示出来  
  * echo *
  * echo $(expression)  可用于计算算数表达式
* ~  符号  指定用户/当前用户的家目录名
* 花括号展开  轮流使用花括号中的字符创建多个字符串
    * echo Front-{A,B,C}-Back
    * echo Number_{1..5}
    * mkdir {2007..2009}-0{1..9} {2007..2009}-{10..12}
* 变量
    * USER  echo $USER  变量名
    * printenv  有效变量列表
* 把一个命令的输出作为一个展开模式来使用  用 $() 括起来 或者用 `` 括起来  
  ls -l $(which cp)   
  file $(ls /usr/bin/* | grep zip) 
* 双引号中，shell 使用的特殊字符，都是去他们的特殊含义，当作普通字符看待，但是 参数展开，算术表达式展开和命令替换仍然有效
* 在双引号内的作为一个参数
    * echo $(cal) 与 echo "$(cal)"  的区别
* 单引号  禁止所有的展开
* \  转义字符
# 键盘高级操作技巧
* ctl + l  清空屏幕  
  clear  命令
* 自动补全  tab 键
* history  历史命令
* 历史命令展开  
    * !!  重复执行最后一次执行的命令
    * !number  重复历史列表中第 number 行的命令
    * !string  重复最近历史列表中，以这个字符串开头的命令
    * !?string  重复最近历史列表中，包含这个字符串的命令
# 权限
* id 查看用户信息
* 文件类型
    * \-  一个普通文件
    * d  目录
    * l  一个符号链接，。注意对于符号链接文件，剩余的文件属性总 是”rwxrwxrwx”，而且都是虚拟值。真正的文件属性是指符 号链接所指向的文件的属性。
    * c  一个字符设备文件
    * b  一个块设备文件
* 权限
    * rwx
* chmod  更改文件或目录模式（权限）
    * 八进制数字表示法
    * 符号表示法
        * u  user  文件或目录所有者
        * g  用户组
        * o  others  其他所有人
        * a  ugo 三者联合
        * \+ 符号 表示加上一个权限  
          \- 符号 表示减去一个权限  
          = 符号 表示只有指定的权限可用
* umask  设置默认权限  创建文件时  
  八进制表示法，四位八进制掩码，掩码的二进制形式中出现 1 ，相应关闭此权限
* 其他特殊权限
    * setuid 位（八进制 4000）  u+s
    * setgid 位（2000）  g+s
    * sticky 位（1000）  +t  能阻止用户删除或重命名文件，除非用户是 这个目录的所有者，或者是文件所有者，或是超级用户
* su 命令  `su [-[l]] [user]`  
  -l  表示会为指定用户启动一个需要登陆的 shell 。可以缩写为 "-"
    * `su -c ‘command’`  只执行单个指令
* sudo  以另一个用户身份执行命令。只需要用户密码，而非超级用户
* chown  更改文件所有者和用户组  
  `chown [owner][:[group]] file...`
* chgrp  更改用户组所有权
* `passwd [user]`  更改用户密码
* adduser
* useradd
* groupadd
# 进程
* ps  查看进程  
  `ps x`  展示所有进程，不管由什么终端控制  
  `ps aux`  显示属于每个用户的进程
* top  以进程活动顺序显示连续更新的系统进程列表
    * h  显示帮助信息
    * q  退出
* ctrl + c  中断
* 程序命令后加上 & ，放到后台执行  
  `xlogo &`
* jobs  正在执行的任务
* fg  让一个进程返回前台  
  `fg %1`  任务序号(jobspec)
* ctrl + z  停止一个前台进程  再使用 fg 恢复到前台运行或者使用 bg 移到后台
* `kill [-signal] PID`  默认情况下发送终止信号  也可以用 jobspacs 代替 PID  
  `kill -l`  获得完整的信号列表
* `killall [-u user] [-signal] name...`  匹配特定程序或用户名的多个进程发送信号
* pstree  树形结构的进程列表，父子关系
* vmstat  输出一个资源系统使用快照
* xload  图形界面程序，画出系统负载随时间变化的图形
* tload  在终端画出图形
# shell 环境
* shell 变量  环境变量  别名  shell 函数
* `printenv | less`  显示环境变量  
  `set | less`  shell 变量、环境变量、shell 函数都会显示  
  `alias`  显示别名
* `export PATH`  告诉 shell 让这个 shell 的子进程可以使用 PATH 变量的内容
* `source .bashrc`  立即生效
# vi 简介
> vim 已经比较熟悉了，vi 和 vim 会有一些差别
# 自定制 shell 提示符
> 内容比较复杂，能够提升对 shell 的理解，自己定制提升逼格也是可以的。
# 软件包管理
* Debian 风格  dekg  apt-get
* Red Hat 风格  rpm  yum
> 我自己使用的 manjaro 是基于 archlinux 的，使用的包管理系统是 pacman
# 存储媒介
* mount  
  unmount
* df
* `fdisk /dev/sdb`  分区  
  fdisk 还用于检测文件系统的完整性与修复受损系统
* `mkfs -t ext3 /dev/sdb1`  格式化分区
* `dd if=input_file of=output_file [bs=block_size [count=blocks]]`
* `genisoimage -o cd-rom.iso -R -J ~/cd-rom-files`  创建映像文件
* `wodim dev=/dev/cdrw blank=fast`  清除一张可重写入的 CD-ROM  
  `wodim dev=/dev/cdrw image.iso`  写入镜像
* md5sum
# 网络系统
* ping  发送一个特殊的网络数据包  ICMP_ECHO_REQUEST
* traceroute  路由情况
* `netstat -ie`  查看系统中的网络接口  
  `netstat -r`  显示内核的网络路由表
* `ftp fileserver`  
  lftp  更易用的 ftp 客户端
* wget  从网络下载
* ssh  与远端主机建立连接
    * `scp remote-sys:document.txt .`  安全复制
    * sftp  远端不需要 FTP 服务，仅仅要 SSH 服务端
# 查找文件
* locate  快速搜索路径名数据库，输出每个与给定字符串相匹配的路径名  
  `locate zip | grep bin`  
  locate 数据库由另一个 updatedb 的程序创建
* find  找到符合标准的文件  
  `find ~ -type d | wc -l` 
  `find ~ -type f -name "*.JPG" -size +1M | wc -l`
  `find ~ \(-type f -not -perm 0600 \) -or \(-type d -not -perm 0700\)`  使用逻辑关系
    * -delete  删除当前匹配的文件
    * -ls  对匹配的文件执行等同 ls -dils 命令。并将结果发送到标准输出
    * -print  默认操作  匹配文件的全路径名输送到标准输出
    * -quit  一旦找到一个匹配就退出
    * `-exec command {}`  用户自定义行为  
      `-exec rm '{}' ';'`  {} 是当前路径名的符号表示
    * -ok 代替 -exec  执行每个指定命令之前会提醒用户
    * 把 ";" 改为 "+" 把搜索结果结合为一个参数 列表，然后用于所期望的命令的一次执行，提高执行效率
* xargs 从标准输入接受输入，并把输入转换为一个特定命令的参数列表  
  `find -type f -name "foo*" -print | xargs ls -l`
* 处理古怪的文件名  null 字符作为参数分隔符  
  `find ∼ -iname ‘*.jpg’ -print0 xargs –null ls -l`
# 归档和备份
* gzip  压缩  
  gunzip  恢复
    * `gunzip -c`  把输出写入到标准输出，并且保留原始文件  
      等同与 zcat  
      zless
* bzip2  更高的压缩级别
  bunzip2
* `tar mode[options] pathname...`  
  mode 指以下操作模式
    * c  为文件和 / 或者目录列表创建归档文件
    * x  抽取归档文件
    * r  追加具体的路径到归档文件的末尾
    * t  列出归档文件的内容

  `tar cf playground.tar playground`
  `tar tvf playground.tar`  列出归档文件的内容  
  `tar xf ../playground.tar`  抽取归档文件  路径名是相对的
  `tar xf archive.tar pathname`  抽取指定文件  
  `find palyground -name 'file-A' -exec tar rf playground.tar '{}' '+'`  
  `find playground -name 'file-A' | tar cf - --files-from=- | gzip > playground.tgz`  
  `find playground -name 'file-A' | tar czf plaground.tgz -T -`  gzip 归档文件  
  `find playground -name 'file-A' | tar cjf plaground.tbz -T -`  bzip2 归档文件
* `zip options zipfile file...`  
  unzip  
  `find playground -name 'file-A' | zip -@ file-A.zip`  
  `ls -l /etc | zip ls-etc.zip -`  接受标准输出作为输入文件
* `rsync options source destination`  同步  
  source 与 destination：
    * 一个本地文件或目录
    * 一个远端文件或目录，以 [user@]host:path 的形式存在
    * 一个远端 rsync 服务器，由 rsync://[user@]host:[port]/path 指定，两者之一必须是本地文件

  `rsync -av playground foo`  -a（递归和保护文件熟悉)  -v（冗余输出）  
  `sudo rsync -av --delete --rsh=ssh /etc /home /usr/local remote-sys:/backup`  远程备份
# 正则表达式
* `grep [options] regex [file...]`  regex  表示一个正则表达式
* 元字符：`^ $ . [ ] { } - ? * + ( ) | \`
* 其他字符为原义字符
* .  任何字符
* ^ $  锚点  开始或结尾
* 中括号表达式和字符集合  
  中括号内，^ 用来表示否定；- 字符用来表示一个字符范围
* POSIX 标准
* 基本正则表达式（BRE）和扩展正则表达式（ERE）  
  BRE 可以辨别以下元字符：`^ $ . [ ] *`  
  ERE 添加了一下元字符：`( ) { } ? + |`
* 交替 alternation  
  `grep -E 'AAA|BBB|CCC'`
* ?  匹配零次或一次
* \* 匹配零个或多个元素
* \+ 匹配一个或多个元素
* {}  匹配特定个数的元素  
   * n
   * n,m
   * n,
   * ,m
* `find . -regex '.*[^-\_./0-9a-zA-Z].*'`
* `locate --regex 'bin/(bz|gz|zip)'`
* less 和 vim 中使用正则表达式
# 文本处理
* cat
    * -A  显示非打印字符
    * -n  添加行号
    * -s  禁止输出多个空白行
* sort  对标准输入的内容，或命令行中指定的一个或多个文件进行排序，然后把排序结果发送到标准输出  
  `sort file1.txt file2.txt file3.txt > final_sorted_list.txt`  能够接受命令行中的多个文件作为参数，合成一个有序文件
    * -b  --ignore-leading-blanks
    * -f  --ignore-case  不分区大小写
    * -n  --numeric-sort  基于数值排序
    * -r  --reverse  相反顺序
    * -k  --key=field1[,field2]  对指定字段的字符串排序
    * -m  --merge  每个参数看作预先排好的文件，直接合并
    * -o  --output=file  结果输出到文件
    * -t  --field-separator=char  定义域分隔符  

  `ls -l /usr/bin | sort -nr -k 5 | head`  
  `sort --key=1  --key=2n distros.txt`  
  `sort -k 3.7nbr -k 3.1nbr -k 3.4nbr distros.txt`  
  `sort -t ':' -k 7 /etc/passwd | head`
* uniq 清楚重复行 输入必须是排好序的数据  
    * -c  输出所有重复行，并显示重复次数
    * -d  只输出重复行，而不是特有的文本行
    * -f n  忽略每行开头的 n 个字段
    * -i  在比较文本行时忽略大小写
    * -s n  跳过每行开头的 n 个字符
    * -u  只输出独有的文本行
* cut  从文本中抽取文本，输出到标准输出，能够接受多个文件参数或者标准输入  
    * -c char_list  从文本行中抽取由 char_list 定义的文本，这个列表可能是由一个或多个逗号分隔开的数值区间组成
    * -f field_list  从文本行中抽取一个或多个由 field_list 定义的字段。这个列表可能包括一个或多个字段，或由逗号分隔开的字段区间
    * -d delim_char  当指定 -f 选线之后，使用 delim_char 作为字段分隔符。默认情况下，字段之间必须由单个 tab 字符隔开
    * --complement  抽取整个文本行，除了那些由 -c 和 / 或 -f 指定的文本

  `cut -f 3 distros.txt`  
  `cut -f 3 distros.txt | cut -c 7-10`  
  `cut -d ':' -f 1 /etc/passwd | head`
* paste  添加一个或多个文本列到文件中，然后把每个文件中的字段整合成单个文本流，输入到标准输出
* join  类似于关系型数据库中的 join，把来自多个基于共享关键域的文件的数据结合起来，所有文件必须按照关键数据域排序  
  默认界定符为空格，可以修改
* comm  比较两个文件，输出第一列包含第一个文件中独有的文本行，第二列第二个文件中独有的，第三列共有的。  
  -n 选项，n 代表 1，2，3 指定了要隐藏的列
* diff  
  默认格式中 `range operation range` 用描述要求更改的位置和类型  
    * r1ar2  第二个文件中位置 r2 处的文件行添加到第一个文件中的 r1 处
    * r1cr2  更改（替代）
    * r1dr2  删除 r1 处，这些文本行将会出现在第二个文件中的 r2 处

  `diff -c file1.txt file2.txt`  上下文模式
    * blank  上下文显示行。并不表示两个文件之间的差异
    * \-  删除行。将会出现在第一个文件，而非第二个文件内
    * \+  添加行。第二个文件内
    * !  更改行。两个版本

  `diff -u file1.txt file2.txt`  统一模式  相似于上下文模式，但是更加简洁。消除了重复上下文
* patch  接受从 diff 程序的输出，老版本转换成新版本  
  `diff -Naur old_file new_file > diff_file`  r 选项支持递归目录树
  `patch < diff_file`
* tr  更改字符  
  `echo "lowercase letters" | tr a-z A-Z` 字符集：
    * 一个枚举列表
    * 一个字符域
    * POSIX 字符类

  `tr -d '\r' <dos_file> unix_file`  转换 MS-DOS 文本文件为 Unix 风格文本，每行末尾的回车符需要被删除  
  `tr --help`  
  `echo "aaabbbccc" | tr -s ab`  挤压（删除）重复字符，必须相邻
* ROT13 编码
* sed  流编辑器  给出单个编辑命令或者包含多个命令的脚本文件名  
  `echo "front" | sed 's/fornt/back/'`  替换  s 可以自动识别分隔符，认为紧跟其后的任意一个字符为分隔符 如 `s_front_back_`  
  `sed '1s/front/back/'`  地址  一般为行号  
    * n  行号，n 是一个正整数
    * $  最后一行
    * /regexp/  所有匹配一个 POSIX 基本正则表达式的文本行。通过 \cregexpc 来指定表达式，c 就是一个备用的界定字符
    * addr1,addr2  范围
    * first~step  匹配由数字 first 代表的文本行，然后随后的每个在 step 间隔处的文本行
    * addr1,+n  匹配地址 addr1 和随后的 n 个文本行
    * addr!  匹配所有文本行，除了 addr 之外
  
  `sed -n '1,5p' distros.txt`  p 命令，就是简单的把匹配文本行打出来；-n 不自动打印选项，让 sed 不要默认地打印每一行  
  `sed -n '/SUSE/p' distros.txt`  正则表达式匹配  
  `sed -n '/SUSE/!p' distros.txt`  ! 表示反过来  
  基本编辑命令：
    * =  输出当前地行号
    * a  在当前行之后追加文本
    * d  删除当前行
    * i  在当前行之前插入文本
    * p  打印当前行。默认情况下，sed 程序打印每一行，并且只是编辑文件中匹配指定地址的文本行。通过指定 -n 选项，这个默认的行为能够被忽略。
    * q  退出 sed，不再处理更多的文本行。如果不指定 -n 选项，输出当前行
    * Q  退出 sed，不再处理更多的文本行。
    * s/regexp/replacement/  正则匹配，替换。replacement 可能包括特殊字符 &，其等价于由 regexp 匹配的文本。另外，replacement 可能包含序列 \1 到 \9，其是 regexp 中相对应的子表达式的内容。在 replacement 末尾的斜杠之后，可以指定一个可选的标志，来修改 s 命令的行为。
    * y/set1/set2/  执行字符转写操作，通过把 set1 中的字符转变为相对应的 set2 中的字符。注意不同于 tr 程序，sed 要求两个字符集合具有相同的长度。

    `sed 's/\([0-9]\{2\}\)\/\([0-9]\{2\}\)\/\([0-9]\{4\}\)$/\3-\1-\2/' distros.txt`  修改日期格式  
    `sed 's/b/B/g'`  g 标志，对文本行全范围执行查找和替换，不仅仅对第一个实例  
    `sed -f distros.sed distros.txt`  使用脚本  
    `sed -i 's/lazy/laxy/; s/jumped/jimped/' foo.txt`  -i 表示 sed 在适当地位置编辑文件，不要发送到标准输出  多个 sed 编辑命令可以放到同一行，分号分隔。
  * aspell  交互式拼写检查器  
    `aspell check textfile`
      * -H  检查 HTML 文件
  * split 把文件分隔成碎片
  * csplit  基于上下文把文件分割成碎片
  * sdiff 并排合并文件差异
  # 格式化输出
  * nl  添加行号  输出  
    逻辑页面  header, body, footer  
    选项：
      * \-b style  把 body 按被要求方式数行，可以是以下方式：a = 数所有行； t = 数非空行； n = 无； pregexp = 只数那些匹配了正则表达式的行
      * \-f style  将 foolter 按照被要求的方式数行
      * \-h style  将 header 按要求的方式数行
      * \-i number  将页面增加量设置为数字，默认是 1
      * \-n format  设置数数的格式，可以是：ln = 左偏，没有前导零； rn = 右偏，没有前导零； rz = 右偏，有前导零
      * \-p  不要在没一个逻辑页面的开始重设页面数
      * \-s string  在没一个行的末尾加字符作分割符号。默认是单个的 tab 。
      * \-v number  将每一个逻辑页面的第一行设置成的数字，默认是 1 
      * \-w width  行数的宽度设置，默认是 6
* fold  限制文件行宽  
  `fold -w 12`  设定行宽为 12 个字符  
  `fold -w 12 -s`  考虑单词边界
* fmt  简单的文本格式器  填充和连接文本行，同时保留空白符和缩进  
  `fmt -w 50 fmt-info.txt | head`  默认情况下保留空行，单词之间的空格和缩进  
    * -c 选项不保留缩进
    * -p 选项 格式文件选中的部分  
      `fmt -w 50 -p '# ' fmt-code.txt`  对 # 开始的注释行
* pr  格式化打印文本  分页  
  `pr -l 15 -w 65 distros.txt`  页长  页宽
* printf  不接受标准输入  格式化打印  
  `printf "format" arguments`  与 C 语言中相似  
  `%[flags][width][.precision]conversion_specification`  
    * flags  有五种不同的标志：#：使用“备用格式”输出。取决于数据类型。对 o（八进制数）转换，输出以 0 为前缀。对于 x 和 X （十六进制数）转换，输出分别以 0x 或 0X 为前缀；0：用零填充输入；-：左对齐输出。默认情况下，为右对齐输出；+：在整数前添加加号
    * width  指定最小字段宽度
    * .precision  对于浮点数，指定小数点后的精确位数。对于字符串转换，指定要输出的字符数
* groff  GUN 实现的 troff 程序  制作格式化文档  
  `zcat /usr/share/man/man1/ls.1.gz | groff -mandoc -T ascii | head`  
  `zcat /usr/share/man/man1/ls.1.gz | groff -mandoc > ~/Desktop/foo.ps`  
  `ps2pdf ~/Desktop/foo.ps ~/Desktop/ls.pdf`
# 打印
* PDL  描述页面内容的编程语言，如 PostScript
* CUPs  一般 Unix 打印系统
* Ghostscript  一种 PostScript 解析器
* lpr  打印文件（Berkeley 风格）
* lp  打印文件（System V 风格）
* a2ps  ASCII to PostScript --> Anything to PostScript  
  实际功能是打印
* lpstat  显示打印系统状态
* lpq  显示打印机队列状态
* lprm（Berkeley 风格） 和 cancel（System V 风格）  取消打印任务
# 编译程序
```
./configure
make

make install
```
# 编写第一个 Shell 脚本
* #!  字符序列是一种特殊的结构叫做 shebang 。告诉操作系统执行此脚本作用的解释器的名字  
  `#!/bin/bash`
* 要有可执行权限  
  `chmod 755 helloworld`
# 启动一个项目
* 第一阶段：最小的文档
* 第二阶段：添加一点数据
    * `variable=value`  给变量和常量赋值，一般小写表示变量，大写表示常量
    * 在参数展开过程中，变量名可能被花括号“{}”包围
* here document 或者 here script 在脚本文件中嵌入正文文本  
  ```
  command << token
  text
  token
  command 是一个可以接受标准输入的命令名，token 是一个用来指示嵌入文本结束 的字符串
  ```  
  单引号和双引号会失去他们在 shell 中的特殊含义
  ```
  #!/bin/bash 
  # Script to retrieve a file via FTP 
  FTP_SERVER=ftp.nl.debian.org 
  FTP_PATH=/debian/dists/lenny/main/installer-i386/current/images/cdrom 
  REMOTE_FILE=debian-cd_info.tar.gz 
  ftp -n <<- _EOF_ 
      open $FTP_SERVER 
      user anonymous me@linuxbox 
      cd $FTP_PATH 
      hash 
      get $REMOTE_FILE 
      bye 
  _EOF_ 
  ls -l $REMOTE_FILE

  << 改为 <<- shell 会忽略在此 here document 中开头的 tab 字符，从而可以缩进
  ```
# 自顶向下设计
```
shell 函数
function name {
  commands
  return
}
and 
name() {
  commands
  return
}
```
```
local name  定义局部变量
```
# 流程控制：if 分支结构
```
if commands; then
    commands
[elif commands; then
    commands...]
[else
    commands]
fi
```
* 退出状态，当命令执行结束后，给系统发送一个 0 到 255 之间的整数，说明命令执行成功或是失败。0 值说明成功  
  `echo $?`  查看退出状态
* 如果 if 之后跟随一系列命令，则将计算列表中的最后一个命令
* `test expression`  执行各种检查与比较  
  `[expression]`  等价  
  expression  表示一个表达式
* 文件表达式
* 字符串表达式
* 整型表达式
* `[[expression]]`  复合命令  加强  
  增加了一个新的重要的字符串表达式  `string1 =~ regex`  
  == 操作符支持类型匹配  `if [[ $FILE == foo.* ]]; then`
* (())  复合命令  操作整数  支持一套完整的算术计算
* 结合表达式  逻辑操作符  &&  ||  !
* 可以执行分支任务的控制操作符  
  `command1 && command2`  
  `command1 || command2`
# 读取键盘输入
* `read [-options] [variable...]`  从标准输入读取单行数据，也可利用重定向读取文件中的一行数据  
  variable  是用来存储输入数值的一个或多个变量名，如果没有提供变量名，shell 变量 REPLY 会包含数据行  
  如果 read 命令接受到变量值数目少于期望的数字，那么额外的变量值为空，而多余的输入 数据则会被包含到最后一个变量中。
    * -a array  输入赋值到数组中。索引从零开始
    * -d delimiter  用字符串 delimiter 中的第一个字符指示输入结束，而不是一个换行符
    * -e  使用 Readline 来处理输入。使得与命令行相同的方式编辑输入
    * -n num  读取 num 个输入字符，而不是整行
    * -p prompt  为输入显示提示信息，使用字符串 prompt
    * -r  Raw mode. 不把反斜杠字符解释为转义字符
    * -s  Silent mode. 不会在屏幕上显示输入的字符。
    * -t seconds  超时。几秒后终止输入
    * -u fd  使用文件描述符 fd 输入，而不是标准输入
* 分隔符由 shell 变量 \_\_IFS__ 配置  
  ```
  file_info=$(grep "^$user_name:" $FILE)
  IFS=":" read user pw uid gid name home shell <<< "$file_info"
  here 字符串
  ```
  shell 允许在一个命令之前给一个或多个变量赋值。这些赋值会暂时改变之后的命令的环境变量  
  不能把管道用到 read 上
* 校正输入
* 使用菜单提示
# 流程控制：while/until 循环
* `while commands; do commands; done`
* break 与 continue
* `until commands; do commands; done`  与 while 刚好相反，条件成立的时候停止
```
#!/bin/bash 
# while-read: read lines from a file 
while read distro version release; do 
    printf "Distro: %s\tVersion: %s\tReleased: %s\n" \
    $distro \ 
    $version \ 
    $release 
done < distros.txt
读取  重定向操作符放在 done 后面
```
```
#!/bin/bash 
# while-read2: read lines from a file 
sort -k 1,1 -k 2n distros.txt | while read distro version release; do
    printf "Distro: %s\tVersion: %s\tReleased: %s\n" \ 
    $distro \ 
    $version \ 
    $release 
done
也可使用管道，注意管道会创建子 shell 并在子 shell 中执行
```
# 疑难排解
> 关于语法错误与逻辑错误的解决
* 语法错误
    * 丢失引号
    * 丢失或意外的标记
    * 预料不到的展开
* 逻辑错误
    * 不正确的条件表达式
    * 超出一个值错误
    * 意外情况
* 验证输入
* 测试  前面添加 echo 命令，展开参数列表，而不是实际运行
* 调试
* bash 中提供了一种追踪方法  
  ```
  #!/bin/bash -x 
  export PS4='$LINENO + '  改变追踪输出的默认字符，加上当前行号
  ```
  使用 set 命令加上 -/+x 的选项，为脚本选择一块追踪区域
  ```
  set -x # Turn on tracing 
  if [ $number = 1 ]; then 
      echo "Number is equal to 1." 
  else
      echo "Number is not equal to 1."
  fi 
  set +x # Turn off tracing
  ```
* 执行时检查数值，使用额外的 echo 语句
# 流程控制：case 分支
```
case word in
    [pattern [| pattern]...] commands ;;]...
esac
```
* 模式以 ")" 为终止符，如 a)，[[:alpha:]])
* 添加 ";;&" 作为语句结尾的语法，允许 case 语句继续执行下一条测试，而不是简单地终止运行
# 位置参数
* 位置参数的变量集合，按照从 0 到 9 给予命名  
  即使不带命令行参数，位置参数 $0 总会包含命令行中出现的第一个单词  
  参数多于 9 个，指定一个大于 9 的数字，用花括号，如 ${10}
* $#  变量  可以得到命令行参数的个数
* shift 命令  执行一次 shift 命令，所有位置参数“向下移动一个位置”，除了其值永远不会改变的 $0
* $(basename $0)  去掉前面的路径
* $*  展开成一个从 1 开始的位置参数列表。当它被用双引号引起来的时候，展开成一个由双引号引起来的字符串，包含了 所有的位置参数，每个位置参数由 shell 变量 IFS 的第一个 字符（默认为一个空格）分隔开。 
* #@  展开成一个从 1 开始的位置参数列表。当它被用双引号引起来的时候，它把每一个位置参数展开成一个由双引号引起来的分开的字符串。
# 流程控制：for 循环
```
传统 shell 格式
for variable [in words]; do
    commands
done
```
* 如果省略掉 for 命令的可选项 words 部分，for 命令会默认处理位置参数。
```
C 语言格式
for (( expression1; expression2; expression3 )); do
    commands
done

相当于

(( expression1 )) 
while (( expression2 )); do 
    commands 
    (( expression3 )) 
done
```
# 数字和字符
* 参数展开
    * 花括号的使用
* 空变量的展开：
    * `${parameter:-word}`  若 parameter 没有设置或者为空，展开结果是 word 的值  
    * `${parameter:=word}` 若 parameter 没有设置或者为空，展开结果是 word 的值，另外，word 的值会赋值给 parameter  
      位置参数或者其他的特殊参数不能以这种方式赋值  
    * `${parameter:?word}`  若 parameter 没有设置或为空，这种展开导致脚本带有错误退出，并且 word 的内容会发送到标准错误
    * `${parameter:+word}` 若 parameter 没有设置或为空，展开结果为空。若 parameter 不为空，展开结果是 word 的值会替换掉 parameter 的值；然而，parameter 的值不会改变
* `${!prefix*} 或 ${!prefix@}`  返回以 prefix 开头的已有变量
* `${#parameter}`  展开成 parameter 所包含的字符串的长度。如果 parameter 是 @ 或者是 * 的话，则展开结果是位置参数的个数
* `${parameter:offset}`  
  `${parameter:offset:length}`  从 parameter 所包含的字符串中提取一部分字符。提取的字符始于第 offset 个字符知道字符结尾，除非指定提取的长度。  
  若 offset 为负数，则认为 offset 的值是从字符串的末尾开始算起，负数前必须有一个空格，为防止与 ${parameter:-word} 展开形式混淆。length 必须不能小于 0 .  
  如果 parameter 是 @ ，展开结果是 length 个位置参数，从第 offset 个位置参数算起
* `${parameter#pattern}`  
  `${parameter##pattern}`  这些展开会从 parameter 所包含的字符串中清楚开头的一部分，匹配定义的 pattern 。pattern 是通配符模式。# 形式清除最短的匹配结果，而 ## 模式清除最长的匹配结果
* `${parameter%pattern}`  
  `${parameter%%pattern}`  清除  末尾
* `${parameter/pattern/string}`  第一个  
  `${parameter//pattern/string}`  所有  
  `${parameter/#pattern/string}`  要求匹配项出现在开头  
  `${parameter/%pattern/string}`  要求匹配项出现在结尾
  查找和替换操作，/string 可以省略，导致删除
* time  命令  可以获取脚本或命令的运行时间
* declare 命令可以用来把字符串规范成大写或小写字符  
  ```
  #!/bin/bash 
  # ul-declare: demonstrate case conversion via declare declare -u upper 
  declare -l lower 
  if [[ $1 ]]; then 
      upper="$1" lower="$1" 
      echo $upper 
      echo $lower 
  fi
  ```
* `${parameter,,}`  把 parameter 的值全部展开成小写字母
* `${parameter,}`  仅仅把 parameter 的第一个字符展开成小写字母
* `${parameter^^}`  把 parameter 的值全部展开成大写字母
* `${parameter^}`  仅仅把 parameter 的第一个字符展开成大写字母
* `$((expression))`  算数展开
* shell 支持任意进制的整型常量  
  `base#number`  number 以 base 为底
* 各种运算符
* bc  一种高精度计算器语言  
  读取一个 bc 脚本，可能是分离的文件或从标准输入  
  `bc -q`  -q  忽略版本信息  也可以使用交互模式  
  `bc < foo.bc bc <<< "2+2"`  可以使用 here 文档，here 字符串，和管道传递来的脚本
# 数组
* bash 仅支持一维数组  
  `a[1]=foo  echo ${a[1]}`  自动创建  花括号必需  
  `declare -a a`  -a 选项 创建数组 a
* `name[subscript]=value`  单个赋值  
  `name=(value1 value2 ...)`  多个赋值  
  `days=([0]=Sun [1]=Mon [2]=Tue [3]=Wed [4]=Thu [5]=Fri [6]=Sat)`  指定下标
* 下标 * 和 @ 可以用来访问数组中的每一个元素，与位置参数时的表现一致
* `echo $(#a[@])`  数组的长度，仅赋值的元素
* `${!array[*]}`  
  `${!array[@]}`  找到数组的下标  
  `for i in "${!foo[@]}"; do echo $i; done`
* 通过 += 赋值运算，能够自动的把值附加到数组末尾
* 排序  `a_sorted=($(for i in "${a[@]}"; do echo $i; done | sort))`
* `unset foo`  删除一个数组  
  `unset foo[2]`  删除单个数组元素  
  给一个数组赋空值不会清空数组内容  
  任何没有下标的对数组变量的引用都指向数组元素 0
* 关联数组，可以使用字符串作为数组索引  
  ```
  declare -A colors 
  colors["red"]="#ff0000" 
  colors["green"]="#00ff00" 
  colors["blue"]="#0000ff"
  必须使用带有 -A 选项的 declar 命令创建
  ```
# 奇珍异宝——一些零星的知识
* `{ command1; command2; [command3; ...] }`  组命令  
  花括号与命令之间必须有一个空格，并且最后一个命令必须用一个分号或者一个换行符终止
* `(command1; command2; [command3; ...])`  子 shell
* 进程替换  
  `<(list)`  适用于产生标准输出的进程  
  `>(list)`  适用于接受标准输入的进程  
  list 是一串命令列表  
  ```
  read < <(echo "foo")
  echo $REPLY
  进程替换允许我们把一个子 shell 的输出结果当作一个用于重定向的普通文件
  ```
* `trap argument signal [signal...]`  陷阱机制  
  argument 是一个字符串，被读取并当作一个命令，signal 是一个信号的说明，它会触发执行所要解释的命令  
  通常指定一个 shell 函数作为命令
* 异步执行  
    * wait 命令导致一个父脚本暂停运行，知道一个特定的进程运行结束
    * $! 参数的值  总是包含到后台执行的最后一个任务的进程 ID 号
* 命名管道  用来在两个进程之间建立连接  
  ```
  process1 > named_pipe
  和
  process2 < named_pipe
  表现出来如同：
  process1 | process2
  ```
  `mkfifo pipe1` 创建命名管道