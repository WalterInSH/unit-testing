Unit Testing
===

这是一个交流单元测试(UT)的项目，我希望有更多的人来交流UT的最佳实践、方法论、经验等

Stories目录下，可以添加你自己和单元测试的故事。例如你是如何一步步学习UT的。

这是一个java maven项目，你可以添加一些实例在src目录里

整个项目还在搭建中，欢迎大家参与进来:-)


##如何阅读

[Method.java](https://github.com/WalterInSH/unit-testing/blob/master/src/main/java/io/github/walterinsh/Method.java) & [SharedClass.java](https://github.com/WalterInSH/unit-testing/blob/master/src/main/java/io/github/walterinsh/SharedClass.java) 是两个辅助类，帮助之后的演示

###基础
[CommonWrongWays.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/basic/CommonWrongWays.java) 演示一些常见的测试误区

[BasicAssertion.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/basic/BasicAssertion.java) 演示如何写基本的断言

[AssertAnException.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/basic/AssertAnException.java) 演示如何断言异常

[SetUpAndTearDown.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/basic/SetUpAndTearDown.java) 演示如何准备和结束单元测试

[UsePriority.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/basic/UsePriority.java) 演示如何控制单元测试的执行顺序

###使用Mock

[ControlReturnValue.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/mock/ControlReturnValue.java) 演示如何使用Mock控制返回值

[ThrowAnException.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/mock/ThrowAnException.java) 演示如何使用Mock抛出一个异常

[TrackInvocation.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/mock/TrackInvocation.java) 演示如何为Mock出来的对象写断言，验证对象被调用的次数

[TrackParameter.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/mock/TrackParameter.java) 演示如何抓取被Mock对象接收的参数

##综合运用

[这里](https://github.com/WalterInSH/unit-testing/tree/master/src/main/java/io/github/walterinsh/realworld)列举了一个综合运用所学知识的例子，包含了一些假象的业务场景。

[SuperMarketTest.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/realworld/SuperMarketTest.java) 是最终的单元测试

_更多例子正在设计中_
