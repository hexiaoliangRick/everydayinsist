# Visitor 设计模式
- visitor:访问者，代表着要对被访问对象进行一些操作的对象。
- visitorTarget:被访问对象，通常可能存在多个这样的对象。   

未使用这样的设计模式时，visitor调用visitorTarget，visitor需要知道vistorTarget的具体对象类别(类)，
visitorTarget对象也需要知道visitor的具体类别。

将visitor对visitTarget的访问行为倒置到visitTarget内部，在内部通过以下代码，调用visitor 访问行为。
```
visitor.visite(this)
```
同时，一旦需要扩展访问行为，就可以在visitor中添加方法。具有动态延展性。