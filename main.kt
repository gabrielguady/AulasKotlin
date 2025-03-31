import kotlin.random.Random
class Nave(var nome : String, var atn : Int, var ate  : Int, var defesa: Int, var ptsVida: Int)

class Jogador(var nome: String, var frota: MutableList<Nave>){
    fun removerNave(){
        frota.removeAt(0)
    }

}

class Duelo(var jogador1 : Jogador, var jogador2: Jogador){
    fun iniciar_batalha(){
        var resultado : 
        while(jogador1.frota.isNotEmpty() && jogador2.frota.isNotEmpty()){
            
            atacar(jogador1, jogador2)
            if (jogador1.frota.first().ptsVida <= 0){
                jogador1.removerNave()
            }
            if (jogador2.frota.first().ptsVida <= 0){
                jogador2.removerNave()
            
            }
            mostrarNaves()            
        }

        
    }

    fun atacar(jog1 : Jogador, jog2 : Jogador){
        var dano = (jog1.frota[0].ate + jog1.frota[0].atn  * ataqueCritico()) - (jog2.frota[0].defesa * defesaUltra())
        jog2.frota[0].ptsVida -= dano
        println("A Nave ${jog1.frota[0].nome} deu ${dano} de dano na Nave ${jog2.frota[0].nome}")
    }
    fun mostrarNaves(){
        println("\t")
            println("***${jogador1.nome}***".uppercase())
            for (i in jogador1.frota.indices){
            println("${i}- ${jogador1.frota[i].nome}, at normal: ${jogador1.frota[i].atn}, at especial: ${jogador1.frota[i].ate}, defesa: ${jogador1.frota[i].defesa}, pts de vida: ${jogador1.frota[i].ptsVida}" )
            }
            println("\t")
            println("***${jogador2.nome}***".uppercase())
            for (i in jogador2.frota.indices){
            println("${i}- ${jogador2.frota[i].nome}, at normal: ${jogador2.frota[i].atn}, at especial: ${jogador2.frota[i].ate}, defesa: ${jogador2.frota[i].defesa}, pts de vida: ${jogador2.frota[i].ptsVida}" )
            }
            println("\t")
    }
    
}
fun ataqueCritico(): Int{
    return Random.nextInt(1, 4)
}
fun defesaUltra(): Int{
    return Random.nextInt(1, 3)
}
fun parImpar(): Int{
    return Random.nextInt(1, 11)
}

fun listaDeNaves(): MutableList<Nave>{
    return mutableListOf(
        Nave("X-Wing", 8, 12, 6, 20),
    Nave("TIE Fighter", 6, 10, 4, 18),
    Nave("Millennium Falcon", 10, 15, 8, 30),
    Nave("Star Destroyer", 12, 20, 10, 40),
    Nave("Slave I", 9, 14, 7, 25),
    Nave("A-Wing", 7, 11, 5, 15),
    Nave("TIE Interceptor", 8, 13, 6, 20),
    Nave("Y-Wing", 6, 12, 7, 22),
    Nave("Imperial Shuttle", 5, 8, 9, 35),
    Nave("Rebel Transport", 6, 10, 7, 38),
    Nave("Ebon Hawk", 8, 14, 7, 28),
    Nave("TIE Bomber", 7, 12, 6, 22),
    Nave("ARC-170", 9, 15, 8, 26),
    Nave("Naboo Starfighter", 6, 10, 5, 18),
    Nave("Ghost", 10, 18, 9, 32),
    Nave("TIE Defender", 11, 16, 8, 30),
    Nave("Z-95 Headhunter", 7, 11, 6, 20),
    Nave("U-Wing", 8, 13, 7, 24),
    Nave("E-Wing", 9, 14, 8, 26),
    Nave("Razor Crest", 9, 16, 8, 32)
    ).shuffled().take(4).toMutableList()

}

fun main(){
    val jogador1 = Jogador("joao", listaDeNaves())
    val jogador2 = Jogador("maria", listaDeNaves())
    val duelo = Duelo(jogador1, jogador2)
    duelo.iniciar_batalha()
    
}