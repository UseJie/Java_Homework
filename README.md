# 实验环境:

1. jdk1.9

2. mysql6.3.10

3. jdbc驱动包

# 总结:
1. 还是有小问题没有完成，比如添加售货员，和后面的健壮性没有完成

2. 这个代码用vim 编写，实现连接本地MySql数据库的超市管理系统

3. 源码可以分为四部分
  * 商品维护界面

  * 商品管理

  * 前台收银

  * 连接数据库部分

4. 由于整个程序的完成过程是一步步由知识点堆砌起来的，所以会有很大的代码冗余，和安全性问题。

5. 可以改善连接远程数据库

6. 可以将需要使用到的功能一一实现在用到实例当中

7. 没有使用文件IO

8. 没有使用多线程

9. 压缩包还带着数据库驱动jar



# Java_Homework

## 完成了MainPage主界面的初步显示，存在的问题：

1. 使用的是FlowLayout()布局，不能够一开始就垂直显示三个Button

2. 所有的语句都写在了入口函数中'public static void main(String[] args){}'中

3. 还不知道Container的作用

## 完成了CommodityMaintenancePage的初步显示，存在问题：

与上面类似

## 完成了CommodityManagementPage的初步显示，存在问题：

与上类似

## 完成了从MainPage可以触发事件到CommodityMainTenancePage、CommodityManagementPage、SalesclerkPage中，可以完善的地方：

1. 可以设置固定JFrame的大小

2. 打开新窗口可以选择错开或者关闭就窗口，实现关闭就窗口可以设置放回上一个窗口的功能。

## 完成AddCommodityPage

## ChangeCommodityPage，存在问题：

1. 关闭窗口时，整个程序退出。

2. 将所有的合并在一个JFrame上 

3. 前两个问题解决，可是产生了新的问题，当我输入商品名称后回车后无法看到商品信息。解决的方法有两个：

(1). 可以将显示信息去掉

(2). 可以加多一个确定键

第一种方法最简单，可以省略连接数据过程，但是修改信息还是要回到数据库.


### ChangeCommodityPage 问题基本上完成，后续将继续修改

## ShowAllCommodityPage

## SelectCommodityPage

## SalesclerkLogonPage

1. 触发事件actionPerformed还未重写

2. 登录直接要求输入账号密码，把"取消"删除

## 可以把所得的商品的相关信息改用表格JTable的类型，为以后更加方便的数据库操作做准备

## 删除商品正在写预编译使用数据库
