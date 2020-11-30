import java.awt.event.KeyEvent
import java.io.File
import java.lang.Double.NaN
import java.util.function.DoubleBinaryOperator

fun main() {
    /*
    var Target = 100
    var n = Familie(Target, 1.0, 5, 3, 20, 1000000)
    var aaa = Neuron(5, 1000000000)
    aaa.random()
    for(aaaaa in 0..4){
        println(aaa.St[aaaaa])
    }


    var a  = arrayOf<Double>(1.0 , 2.0)
    println(a.sum())

     */



    var Eltern = Array<Netzwerk>(3,{Netzwerk(15,20,1000,0.001 , 0.1, 0.4)})

    var Elternb = DoubleArray(3,{0.0})
    var tmp : Elternpb
    var d = 10000
    var lossmax = 0.0
    var e = true
    var mutationRate = 0.3
    for(aaa in 0..d){
        tmp = learn(100,Eltern,Elternb,200000000,10000000,mutationRate)
        Eltern = tmp.Eltern
        Elternb = tmp.Elternb
        if( aaa % 10 == 0){
            println(aaa/10)
            println(lossmax)
            println(mutationRate)
        }

        if(Elternb[0]<lossmax) mutationRate=mutationRate*0.999
        if(Elternb[0]> lossmax){
            lossmax = Elternb[0]
            mutationRate=mutationRate*1.05
            println(lossmax)
            for(aab in 0..20) {
                print(Eltern[0].rechnen((aab-10).toDouble()))
                print(" ")

            }
            println()
        }

    }
    for(aaa in 0..10) {
        println(Eltern[0].rechnen(aaa.toDouble()))

    }
    println(Elternb.sum())
    println()
    tmp = learn(100,Eltern,Elternb,100000000,10000000,mutationRate)
    Eltern = tmp.Eltern
    Elternb = tmp.Elternb
    for(aaa in 0..10) {
        println(Eltern[0].rechnen((aaa).toDouble()))

    }
    println(Elternb.sum())
    println()
    tmp = learn(200,Eltern,Elternb,100000000,10000000,mutationRate)
    Eltern = tmp.Eltern
    Elternb = tmp.Elternb
    for(aaa in 0..10) {
        print(aaa)
        print(" ")
        println(Eltern[0].rechnen((aaa).toDouble()))

    }

    var a = toString(Eltern)
    var file = File("Eltern.txt")
    file.printWriter().use { out ->

        for(aaa in a.indices){
            out.println(a[aaa])
        }
    }

    var Ergebnis = File("Ergebnis.txt")
    Ergebnis.printWriter().use { out ->

        for(aaa in 0..2000){
            out.println(Eltern[0].rechnen(aaa.toDouble()/100.0-10.0))
        }
    }


}