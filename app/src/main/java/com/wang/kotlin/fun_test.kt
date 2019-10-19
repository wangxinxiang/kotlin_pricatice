package com.wang.kotlin

/**
 * kotlin源文件不需要相匹配的目录和包，源文件可以放在任何文件目录。
 */

/**
 * main函数
 */
fun main(args: Array<String>) {
    println(sum(1, 2))

    val sumLambda: (Int, Int) -> Int = {x,y -> x + y}

    //$ 表示一个变量名或者变量值
    //$varName 表示变量值
    val j = 3
    val s = "test is $j"
    print("${s.replace("test", "")}, 2333333")

    //字段后加!!像Java一样抛出空异常，另一种字段后加?可不做处理返回值为 null或配合?:做空判断处理
    val str: String? = "233"
    val cardNo: String = str?.substring(1) ?: ""
    print(cardNo)
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

/**
 * 表达式作为函数体，返回类型自动推断：
 */
fun sum1(a: Int,b: Int) = a + b
public fun sum2(a: Int,b: Int) = a + b

/**
 * 无返回值
 */
fun sum3(a: Int,b: Int) {
    print(a + b)
}

/**
 * 可变长参数函数  vars(1,2,3,4,5)
 */
fun vars(vararg v:Int) {
    for (vt in v) {
        print(vt)
    }
}

/**
 * 可变变量定义：var 关键字/
 */
fun var_test() {
    val i: Int = 1
    val j = 1
    val z : Int

    var c : Int

}

fun loop_test() {
    for (i in 1..4) {
        print(i)
    }
    for (i in 4 downTo 0) {
        print(i)
    }
    for (i in 1..4 step 2) {
        print(i)
    }
    for (i in 1 until 4) {
        print(i)
    }
}

/**
 * Kotlin 中没有基础数据类型，只有封装的数字类型，你每定义的一个变量，其实 Kotlin 帮你封装了一个对象，这样可以保证不会出现空指针。
 */
fun compare_test() {
    val a:Int = 233
    val b:Int? = a
    val c:Int? = a
    println(b === c)    //  false，值相等，对象地址不一样
    println(b == c)     // true，值相等0
}

/**
 * 数组的创建两种方式：一种是使用函数arrayOf()；另外一种是使用工厂函数。
 */
fun array_test() {
    val a = arrayOf(1, 2 ,3)
    val b = Array(3) { i -> (i * 2)}
    println(a[0])
    println(a[1])
}

fun str_test() {
    val str2 = """233 566""" //多行字符串
    println(str2)
}

fun when_test() {
    when(3) {
        1 -> println(1)
        2 -> println(2)
        3,4 -> println(3)
        in 5..7 -> println("5..7")
        !in 8..10 -> println("!in 8..10")
        else -> {
            println("default")
        }
    }
}