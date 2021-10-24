fun main() {
    val julio = Person("Julio Cesar Pereira Dos Santos", 24, "111.222.333-04", "Masc")
    val julioFuncionario = Employee(julio, 1901, 1200.0f)
    val julioClient = Client(julio)
    //TODO: Verify why this not acept start password with zero
    val julioCard = Card(julio, 1010, OperatorOptions.NUBANK)
    val eletricGuitar = Product("Eletric Guitar", 1000.0f,
                                    "this is a wosome musical instrument")
    julioCard.setAccountBalance(3000.0f)
    julioClient.buyProduct(eletricGuitar, julioCard, TypeOfPayment.CREDIT)

    //test

    //println(someCard.getCardName())


   // julioFuncionario.showPeopleInfo()
    //julioClient.showPeopleInfo()






}