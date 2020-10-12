计划：
* 实现两个Driver
* 写一个冲突的情况(然而因为maven的依赖原则，自动给屏蔽了一个版本的jar)
* 用两个模块来调用，分别用不同的类加载器，然后再用一个模块来调用这两个模块，测试不冲突的情况

* 如果碰到statement获取不到，将Adriver、Bdriver分别install一下，install之后删除都可以，仍然可以执行