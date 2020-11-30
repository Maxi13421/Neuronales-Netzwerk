fun toString(Eltern : Array<Netzwerk>) : Array<Double> {
    var zw = Eltern[0].anzahl*Eltern[0].anzahl*Eltern[0].aSchichten+2*Eltern[0].anzahl+ (Eltern[0].aSchichten+1)*Eltern[0].anzahl +1
    var a = Array<Double>(3+Eltern.size*(zw)){0.0}
    a[a.size-1]= Eltern.size.toDouble()
    a[a.size-2]= Eltern[0].anzahl.toDouble()
    a[a.size-3]= Eltern[0].aSchichten.toDouble()

    for(aaa in Eltern.indices){
        for(aab in 0..Eltern[0].anzahl-1){
            a[aaa*zw+aab] = Eltern[aaa].eSchicht[aab].Strings[0]
        }
        for(aab in 0..Eltern[0].anzahl-1){
            a[aaa*zw+aab+Eltern[0].anzahl] = Eltern[aaa].eSchicht[aab].Bias
        }


        for(aab in 0..Eltern[0].aSchichten-1){

            for(aac in 0..Eltern[0].anzahl-1){
                for(aad in 0..Eltern[0].anzahl-1)
                a[aaa*zw+2*Eltern[0].anzahl+aab*Eltern[0].anzahl*Eltern[0].anzahl+aac*Eltern[0].anzahl+aad] = Eltern[aaa].Schichten[aab][aac].Strings[aad]
            }

            for(aac in 0..Eltern[0].anzahl-1) {
                a[aaa*zw+2*Eltern[0].anzahl+Eltern[0].aSchichten*Eltern[0].anzahl*Eltern[0].anzahl+aab*Eltern[0].anzahl+aac] = Eltern[aaa].Schichten[aab][aac].Bias
            }
        }

        for(aab in 0..Eltern[0].anzahl-1){
            a[aaa*zw+2*Eltern[0].anzahl+Eltern[0].aSchichten*Eltern[0].anzahl*Eltern[0].anzahl+Eltern[0].aSchichten*Eltern[0].anzahl+aab] = Eltern[aaa].Output.Strings[aab]
        }

        a[(aaa+1)*zw-1] = Eltern[aaa].Output.Bias

    }


    return a
}