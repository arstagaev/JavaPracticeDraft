


fun main(){
//    var ax: MutableList<Int>
//    ax = mutableListOf(1,2,3)
//    ax.add(4)
//    print(ax)

    //get max num!!!
    val a  = arrayOf(2,343,54,23,14,676,8786,45,3432)
    //indexes
    var index = 0
    var curIndex = 0
    //a.max()
    for (n in 0..a.size-1)

        if (a.get(index) < a.get(n)){
            index =n

        }



    print(a.get(index))

}