1.redis缓存要记得开启redis相应软件：
  D:\BaiduNetdiskDownload\Redis-x64-3.0.500 的server和client的cmd运行
  并且可以开启桌面上的redis-desktopmanager软件开启可视化查看 使用更方便。

2.标准三层结构：
  controller调用service，service调用dao（这里是代理开发方法 调用相应mapper），然后测试文件
  这里的重点层是service层，因为redis的操作在此层。