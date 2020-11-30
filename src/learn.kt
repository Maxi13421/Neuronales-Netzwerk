import java.lang.Math.pow
import kotlin.math.*

fun learn(aKinder : Int, Eltern : Array<Netzwerk>, Elternb : DoubleArray, learnrange : Long, learnaccuracy : Int, mutationRate : Double) : Elternpb{
    var Input = Array<Double>(100){(0..learnrange).random().toDouble()/learnaccuracy-10}



    var Kinder : Array<Netzwerk> = Array<Netzwerk>(aKinder, {combine(Eltern,Elternb,mutationRate)})



    var score = Array<Double>(aKinder, {i -> pow(arrayproduct(Array<Double>(Input.size){a -> pow(pow(1.00000001,-1*(pow((Kinder[i].rechnen(Input[a])-Input[a]*Input[a]),2.0))),1.0/Input.size.toDouble())}),1.0) })


    var Elterni : IntArray = IntArray(Elternb.size,{0})


    var scoren = Array<Double>(score.size,{i-> score[i]})
    var max : Int
    for(aaa in Elternb.indices){
        max = 0
        for(aab in 0..aKinder-1){
            if(score[aab]>score[max]){
                max = aab
            }
        }
        Elterni[aaa]= max
        score[max] = 0.0

    }
    return Elternpb(Array<Netzwerk>(Elternb.size,{i -> Kinder[Elterni[i]]}), DoubleArray(Elternb.size,{i -> scoren[Elterni[i]]}))
}
