class Animal(name: String, weight: Double, age: Int) {
    val name: String
    var weight: Double
    val age: Int
    var isMammal: Boolean

    init {
        this.weight = if(weight < 0) 0.1 else weight
        this.age = if(age < 0) 0  else age
        this.name = name
        this.isMammal = false
    }

    constructor(name: String, weight: Double, age: Int, isMammal: Boolean) : this(name, weight, age) {
        this.weight = weight;
        this.isMammal = isMammal
    }
}

fun main() {
    val dicodingCat = Animal("Dicoding Miaw", -0.1, 2, true)
    println("Nama: ${dicodingCat.name}, Berat: ${dicodingCat.weight}, Umur: ${dicodingCat.age}, mamalia: ${dicodingCat.isMammal}")

    val dicodingBird = Animal("Dicoding tweet", -0.2, 1)
    println("Nama: ${dicodingBird.name}, Berat: ${dicodingBird.weight}, Umur: ${dicodingBird.age}, mamalia: ${dicodingBird.isMammal}")
}

/*
output:
    Nama: Dicoding Miaw, Berat: 2.5, Umur: 2, mamalia: true
    Nama: Dicoding tweet, Berat: 0.5, Umur: 1, mamalia: false
*/