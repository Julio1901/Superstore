fun main() {
    val julio = Person("Julio Cesar Pereira Dos Santos", 24, "111.222.333-04", "Masc")
    val julioFuncionario = Employee(julio, 1901, 1200.0f)

    //TODO: Verify why this not acept start password with zero
    val julioCard = Card(julio, 1010, OperatorOptions.NUBANK)
    val julioClient = Client(julio, julioCard)

    println(julioClient.clientCard.getCardOperator())
    println(julioClient.clientCard.getPasswordCard())


    val eletricGuitar = Product("Eletric Guitar", 1000.0f,
        "this is a wosome musical instrument")


    julioClient.clientCard.setAccountBalance(3000.0f)
    julioClient.buyProduct(eletricGuitar, TypeOfPayment.CREDIT)

    //test

    //println(someCard.getCardName())


   // julioFuncionario.showPeopleInfo()
    //julioClient.showPeopleInfo()






}