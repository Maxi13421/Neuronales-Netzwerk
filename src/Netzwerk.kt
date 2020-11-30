
import java.lang.Math.pow
import java.lang.Math.sqrt
import kotlin.math.abs

class Netzwerk(var anzahl : Int, var aSchichten : Int,var maxG : Int,  var mutationRate : Double, var mutationPower: Double, var BiasFactor : Double) {
    var Schichten : Array<Array<Neuron>> = Array<Array<Neuron>>(aSchichten) { Array<Neuron>(anzahl) { Neuron(DoubleArray(anzahl) { 0.0 }, 0.0, 0.0) } }
    var eSchicht = Array<Neuron>(anzahl) { Neuron(DoubleArray(1) { 1.0 }, 0.0, 0.0) }
    var Output = Neuron(DoubleArray(anzahl) { 1.0 }, 0.0, 0.0)
    fun rechnen(Input : Double) : Double {
        for(aaa in 0..anzahl-1){
            eSchicht[aaa].Wert = pow(Input * eSchicht[aaa].Strings[0] + eSchicht[aaa].Bias,1.0)
        }

        for(aaa in 0..anzahl-1){
            var tmp = 0.0
            for(aab in 0..anzahl-1){
                tmp+= eSchicht[aab].Wert * Schichten[0][aaa].Strings[aab]
            }
            Schichten[0][aaa].Wert = pow(tmp/Schichten[0][aaa].Strings.sum() + Schichten[0][aaa].Bias,1.0)
        }

        for(aaa in 1..aSchichten-1){
            for(aab in 0..anzahl-1){
                var tmp = 0.0
                for(aac in 0..anzahl-1){
                    tmp+= Schichten[aaa-1][aac].Wert * Schichten[aaa][aab].Strings[aac]
                }
                Schichten[aaa][aab].Wert = (tmp/Schichten[aaa][aab].Strings.sum() + Schichten[aaa][aab].Bias + abs(tmp/Schichten[aaa][aab].Strings.sum() + Schichten[aaa][aab].Bias))/2


            }
        }

        var tmp = 0.0
        for(aaa in 0..anzahl-1){
            tmp+= Schichten[Schichten.size-1][aaa].Wert * Output.Strings[aaa]
        }
        Output.Wert = pow(tmp/Output.Strings.sum() + Output.Bias,1.0)
        return Output.Wert
    }


}