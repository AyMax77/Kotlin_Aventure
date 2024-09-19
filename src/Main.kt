import kotlin.random.Random

fun calculDefenseTotal(defense: Int, type_armure:Int, rareté_armure:Int,) {
    var defense_total = defense + type_armure + rareté_armure
    println(defense_total)
}

fun lanceDe(nombre_de: Int,nombre_face:Int):Int{
    val aleatoire = List(nombre_de) {Random.nextInt(1,nombre_face+1)}
    var somme = 0
    for(dé in aleatoire) {somme += dé}
    println(somme)
    return somme
}

fun calculDegatArme(nombreDes: Int, nombreFaces: Int, bonusQualite: Int, seuilCritique: Int, multiplicateurCritique: Int): Int {
    var degat = 0
    var dés = lanceDe(nombreDes,nombreFaces)
    if (dés > seuilCritique){
        degat += dés * multiplicateurCritique
    }
    degat += bonusQualite
    return degat
}

fun attaque(PV:Int,defense: Int,nom_attaquant: String,nom_cible: String,atktotal:Int):String{
    var attak = atktotal-defense
    if(attak<0){
        attak = 0
    }
    var hp = PV - attak
    return "$nom_attaquant attaque $nom_cible pour $attak points de dégâts, il lui reste $hp PV\n"
}


fun boirePotion(nom_perso: String,PV:Int,PV_Max:Int,Recup_PV:Int): String {
    var exPV = PV_Max
    var pv = PV
    var boire = Recup_PV + PV
    if(boire > exPV){
        pv = PV_Max
    } else {
        pv = boire
    }
    var total_recup = Recup_PV
    if(PV + total_recup> PV_Max){
        total_recup = PV_Max - PV
    }
    return "$nom_perso avait $PV PV il a récupéré $total_recup PV il a maintenant $pv PV"
}

fun bouleDeFeu(caster:String,cible: String,scoreattaque:Int,scoredefense:Int,PV: Int) : String{
    var degat = lanceDe(nombre_de = scoreattaque/3, nombre_face = 6)
    degat = degat - scoredefense
    var hp = PV
    if (hp < 0){ error("stop")}
    return "$caster lance une boule de feu et inflige $degat points de dégats à $cible"
}


fun missileMagique(caster: String,cible: String,scoreattaque: Int,scoredefense: Int){

}



fun main() {
    (calculDefenseTotal(8,9,3))
    lanceDe(1,6)
    calculDegatArme(2,3,7,5,8)
    println(attaque(50,7,"Ratatac","Pikachu",20))
    println(boirePotion("Inoxtag",70,100,50))
    println(bouleDeFeu("Johan","Yaẽl",10,6,90))
}