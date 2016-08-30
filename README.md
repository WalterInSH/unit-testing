Unit Testing
===

这是一个交流单元测试(UT)的项目，我希望有更多的人来交流UT的最佳实践、方法论、经验等

这是一个java maven项目，你可以添加一些实例在src目录里

整个项目还在搭建中，欢迎大家参与进来:-)


##故事

[Stories](https://github.com/WalterInSH/unit-testing/tree/master/stories)目录下，列举了一些和单元测试的故事,讲述大家对单元测试的认识,你可以添加你自己的故事。例如你是如何一步步学习UT的。

##如何阅读

[Method.java](https://github.com/WalterInSH/unit-testing/blob/master/src/main/java/io/github/walterinsh/Method.java) & [SharedClass.java](https://github.com/WalterInSH/unit-testing/blob/master/src/main/java/io/github/walterinsh/SharedClass.java) 是两个辅助类，帮助之后的演示

###基础

首先介绍一下单元测试的基础, 这些东西不复杂,但却是被用到最多的东西. 优秀的单元测试都是由最基础的东西组成的.

[CommonWrongWays.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/basic/CommonWrongWays.java) 演示一些常见的测试误区

[BasicAssertion.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/basic/BasicAssertion.java) 演示如何写基本的断言

[AssertAnException.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/basic/AssertAnException.java) 演示如何断言异常

[SetUpAndTearDown.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/basic/SetUpAndTearDown.java) 演示如何准备和结束单元测试

[UsePriority.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/basic/UsePriority.java) 演示如何控制单元测试的执行顺序

###可读性提升

[GoogleTruth.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/readability/GoogleTruth.java) 演示如何使用Google Truth框架增强断言的可读性

###Behavior-driven development(BDD)

除了最被人熟知的TDD, 行为驱动测试(BDD)也是十分流行

[StringReverserStory.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/bdd/StringReverserStory.java) 演示结合Jbehave进行行为驱动测试.

###使用Mock

有时我们希望验证程序在某些特殊场景下是否正常执行, 例如网络异常(我们不可能在每次测试的时候拔网线),这个时候Mock框架就派上了用场. Mock框架可以在单元测试中模拟出各种情况,并提供丰富的断言,让我们对代码在复查场景下的表现也胸有成竹

[ControlReturnValue.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/mock/ControlReturnValue.java) 演示如何使用Mock控制返回值

[ThrowAnException.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/mock/ThrowAnException.java) 演示如何使用Mock抛出一个异常

[TrackInvocation.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/mock/TrackInvocation.java) 演示如何为Mock出来的对象写断言，验证对象被调用的次数

[TrackParameter.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/mock/TrackParameter.java) 演示如何抓取被Mock对象接收的参数

###WireMock

WireMock 可以在本地启动Http server, 伪装成你依赖的第三方服务. 对于一些复杂场景或者不便于Mock的代码, WireMock是个不错的选择

[UserWireMock.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/wiremock/UserWireMock.java) 演示如何使用WireMock

###和Spring 集成

[LoadSpringContext.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/spring/LoadSpringContext.java) 演示如何和Spring集成,加载Spring上下文

[SpringProxyClassMock.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/spring/SpringProxyClassMock.java) 补充一个spring AOP测试中,如何应对代理类的mock

###使用H2内存数据库

[StudentDaoTest.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/springh2/StudentDaoTest.java) 演示如何使用H2内存数据库进行单元测试

##综合运用

也许每个知识点里的例子你都看懂了,但是却不知道该在什么时候用这些知识. 让我们通过更贴近现实的场景温习一下这些知识点.

[这里](https://github.com/WalterInSH/unit-testing/tree/master/src/main/java/io/github/walterinsh/realworld)列举了一个综合运用所学知识的例子，包含了一些假象的业务场景。

[SuperMarketTest.java](https://github.com/WalterInSH/unit-testing/blob/master/src/test/java/io/github/walterinsh/realworld/SuperMarketTest.java) 是最终的单元测试

_更多例子正在设计中_
