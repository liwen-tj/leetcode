作用域       当前类    同一package   子孙类     其他package 

public        √       √             √           √ 

protected     √       √             √           × 

default      √       √             ×           × 

private       √       ×             ×           × 


在static方法的内部，不能调用非静态方法
