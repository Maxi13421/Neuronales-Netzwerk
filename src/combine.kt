import java.lang.Math.pow

fun combine(Eltern : Array<Netzwerk>, Elternb : DoubleArray, mutationRate : Double) : Netzwerk{
    val sumb = Elternb.sum()
    val mutationRatei = mutationRate//pow(Eltern[0].mutationRate*(-pow(sumb/Elternb.size,2.0)+1.0),Eltern[0].mutationPower/2)
    var neu = Netzwerk(Eltern[0].anzahl,Eltern[0].aSchichten,Eltern[0].maxG, Eltern[0].mutationRate, Eltern[0].mutationPower, Eltern[0].BiasFactor)
        for(aaa in 0..Eltern[0].aSchichten-1){
            for(aab in 0..Eltern[0].anzahl-1){
                for(aac in 0..Eltern[0].anzahl-1){
                    var sume = 0.0
                    for(aad in Eltern.indices) {
                        sume+=Eltern[aad].Schichten[aaa][aab].Strings[aac] //* Elternb[aad]
                    }

                        neu.Schichten[aaa][aab].Strings[aac] = sume/Eltern.size + ((0..Eltern[0].maxG).random().toDouble()/Eltern[0].maxG - 0.5) *mutationRatei

                }
            }
        }

    for(aab in Eltern[0].eSchicht.indices){
            var sume = 0.0
            for(aad in Eltern.indices) {
                sume+=Eltern[aad].eSchicht[aab].Strings[0] //* Elternb[aad]
            }
            neu.eSchicht[aab].Strings[0] = sume/Eltern.size + ((0..Eltern[0].maxG).random().toDouble()/Eltern[0].maxG - 0.5) *mutationRatei


    }

    for(aac in 0..Eltern[0].anzahl-1){
        var sume = 0.0
        for(aad in Eltern.indices) {
            sume+=Eltern[aad].Output.Strings[aac] //* Elternb[aad]
        }
        neu.Output.Strings[aac] = sume/Eltern.size + ((0..Eltern[0].maxG).random().toDouble()/Eltern[0].maxG - 0.5) * mutationRatei

    }



    for(aaa in 0..Eltern[0].aSchichten-1){
        for(aab in 0..Eltern[0].anzahl-1){

                var sume = 0.0
                for(aad in Eltern.indices) {
                    sume+=Eltern[aad].Schichten[aaa][aab].Bias //* Elternb[aad]
                }

                neu.Schichten[aaa][aab].Bias = sume/Eltern.size + ((0..Eltern[0].maxG).random().toDouble()/Eltern[0].maxG - 0.5) *mutationRatei*Eltern[0].BiasFactor

            }

    }

    for(aab in Eltern[0].eSchicht.indices){
        var sume = 0.0
        for(aad in Eltern.indices) {
            sume+=Eltern[aad].eSchicht[aab].Bias// * Elternb[aad]
        }
        neu.eSchicht[aab].Bias = sume/Eltern.size  + ((0..Eltern[0].maxG).random().toDouble()/Eltern[0].maxG - 0.5) *mutationRatei*Eltern[0].BiasFactor

    }


        var sume = 0.0
        for(aad in Eltern.indices) {
            sume+=Eltern[aad].Output.Bias// * Elternb[aad]
        }
        neu.Output.Bias = sume/Eltern.size+ ((0..Eltern[0].maxG).random().toDouble()/Eltern[0].maxG - 0.5) * mutationRatei*Eltern[0].BiasFactor




    return neu
}