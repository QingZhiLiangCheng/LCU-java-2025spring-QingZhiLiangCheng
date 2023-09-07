/**
 * 桥接模式，画笔示例。
 * <a href="https://www.cnblogs.com/WindSun/p/10260547.html">https://www.cnblogs.com/WindSun/p/10260547.html</a>
 * 提供大中小3种型号的画笔，能够绘制5种不同颜色
 * 如果使用蜡笔，需要准备3*5=15支蜡笔，即15个具体的蜡笔类。
 * 如果使用毛笔，只需要3种型号的毛笔，外加5个颜料盒，用3+5=8个类就可以实现15支蜡笔的功能。
 * 本实例使用桥接模式来模拟毛笔的使用过程。
 */
package cn.edu.lcu.cs.designpattern.bridge.pen;