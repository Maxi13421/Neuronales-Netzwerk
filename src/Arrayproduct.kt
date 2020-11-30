fun arrayproduct (array : Array<Double> ) : Double{
    var tmp = 1.0
    for(aaa in array.indices){
        tmp= tmp*array[aaa]
    }
    return tmp

}