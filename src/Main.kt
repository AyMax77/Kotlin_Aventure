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


fun main() {
    (calculDefenseTotal(8,9,3))
    lanceDe(1,6)
    calculDegatArme(2,3,7,5,8)
    println(attaque(50,7,"Ratatac","Pikachu",20))
}