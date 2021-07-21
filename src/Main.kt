/*
Data 를 담을 변수만 가지고 있는 Class 를 Data Class 라고 부릅니다.
Data 를 관리하기 위한 목적으로 생성하는 Class 입니다.
Open, Abstract 를 사용할 수 없습니다.
상속, 추상화 기능이 필요한 경우의 사용은 부적절 합니다.
 */
fun main() {
    var obj1 = TestClass1(100, 200)
    var obj2 = TestClass2(100, 200)

    println("obj1.a1 : ${obj1.a1}")
    println("obj1.a2 : ${obj1.a2}")

    println("obj2.a1 : ${obj2.a1}")
    println("obj2.a2 : ${obj2.a2}")

    var obj3 = TestClass1(100, 200, 300)
    var obj4 = TestClass2(100, 200, 300)
    println("obj3.a1 : ${obj3.a1}")
    println("obj3.a2 : ${obj3.a2}")
    println("obj3.a3 : ${obj3.a3}")

    println("obj4.a1 : ${obj4.a1}")
    println("obj4.a2 : ${obj4.a2}")
    println("obj4.a3 : ${obj4.a3}")

    obj3.testMethod1()
    obj4.testMethod2()

    println("---------------------------------")

    var obj5 = TestClass1(100, 200, 300)
    var obj6 = TestClass1(100, 200, 300)

    /*
    일반 Class 를 비교하는 경우에서 Kotlin 은 해당 Class 의 주솟값을 비교 대상으로 설정합니다.
    동일한 Class 를 객체화 하여 변수 obj5 와 obj6 에 초기화를 진행하였습니다.
    각 객체 (obj5, obj6) 는 서로 다른 객체 입니다.
    동일한 Class 가 각각 두 개의 객체로 생성된 것입니다.
    변수 obj5 와 obj6 에는 각 객체의 주솟값이 입력됩니다.
    따라서 아래 if 문에서는 두 객체의 주소의 값을 비교했기 때문에 조건식은 false 가 됩니다.
     */
    if(obj5 == obj6){
        println("obj5와 obj6은 같은 객체 입니다")
    } else {
        println("obj5와 obj6은 다른 객체 입니다")
    }

    /*
    Data Class 를 비교하는 경우에서 Kotlin 은
    해당 Data Class 의 주생성자에 정의된 변수의 값을 비교의 대상으로 설정합니다.
     */
    var obj7 = TestClass2(100, 200, 300)
    var obj8 = TestClass2(100, 200, 300)
    if(obj7 == obj8){
        println("obj7과 obj8은 같은 객체 입니다")
    } else {
        println("obj7과 ojb8은 다른 객체 입니다")
    }

    println("-------------------------------------")

    /*
    Data Class 의 복제는 주생성자의 변수만 복제가 됩니다.
    일반 Class 는 .copy() Method 를 사용할 수 없습니다.
     */
    // val obj9 = obj5.copy()
    val obj10 = obj7.copy()
    println("obj10.a1 : ${obj10.a1}")
    println("obj10.a2 : ${obj10.a2}")
    println("obj10.a3 : ${obj10.a3}")

    obj10.a1 = 1000
    println("obj7.a1 : ${obj7.a1}")
    println("obj10.a1 : ${obj10.a1}")

    println("----------------------------------")

    /*
    toString() : 객체가 가지고 있는 변수의 값을 출력합니다.
     */
    val str1 = obj5.toString()
    val str2 = obj7.toString()
    println("str1 : $str1")
    println("str2 : $str2")

    println("--------------------------------")

    /*
    .componentN() : 객체를 분해합니다.
    출력값 :
    num1 : 100
    num2 : 200
    Data Class 를 생성하면 주생성자의 개수만큼 Component 가 생성됩니다.
     */
    val num1 = obj7.component1()
    val num2 = obj7.component2()
    println("num1 : $num1")
    println("num2 : $num2")

    var obj11 = TestClass3(100, 200, 300)
    val num3 = obj11.component1()
    val num4 = obj11.component2()
    val num5 = obj11.component3()
    println("num3 : $num3")
    println("num4 : $num4")
    println("num5 : $num5")

    println("-------------------------------------")

    /*
    출력값 :
    num10 : 100
    num11 : 200
     */
    val (num10, num11) = obj7
    println("num10 : $num10")
    println("num11 : $num11")

    val (num12, num13, num14) = obj11
    println("num12 : $num12")
    println("num13 : $num13")
    println("num14 : $num14")

}

class TestClass1(var a1:Int, var a2:Int){

    var a3:Int = 0

    init{
        println("TestClass1의 init")
    }

    constructor(a1:Int, a2:Int, a3:Int) : this(a1, a2) {
        this.a3 = a3
    }

    fun testMethod1(){
        println("TestClass1의 testMethod1입니다.")
    }
}
data class TestClass2(var a1:Int, var a2:Int){

    var a3:Int = 0

    init {
        println("TestClass2의 init")
    }

    constructor(a1:Int, a2:Int, a3:Int) : this(a1, a2){
        this.a3 = a3
    }

    fun testMethod2(){
        println("TestClass2의 testMethod2 입니다")
    }
}

data class TestClass3(var a1:Int, var a2:Int, var a3:Int)







