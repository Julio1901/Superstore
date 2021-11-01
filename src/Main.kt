fun main() {
    val julio = Person("Julio Cesar Pereira Dos Santos", 24, "111.222.333-04", "Masc")
    val julioFuncionario = Employee(julio, 1901, 1200.0f)

    //TODO: Verify why this not acept start password with zero
    val julioCard = Card(julio, 1010, OperatorOptions.NUBANK)
    julioCard.setAccountBalance(30000.0f)
    val julioClient = Client(julio, julioCard)

    //println(julioClient.clientCard.getCardOperator())
    //println(julioClient.clientCard.getPasswordCard())



    // LISTA DE PRODUTOS PARA TESTE
    val eletricGuitar = Product("Eletric Guitar", 1000.0f,
        "this is a wosome musical instrument")
    val acusticGuitar = Product("Acustic Guitar" , 500.0f, "" +
            "this is a great musical instrument to initializing your study")
    val drum = Product("Drum", 2000.0f)


    //Criando uma loja
    val cloud9 = Store("Cloud 9")
    cloud9.addProduct(eletricGuitar)
    cloud9.addProduct(acusticGuitar)
    cloud9.addProduct(drum)



    cloud9.stockUp(eletricGuitar, 10)
    cloud9.addProduct(eletricGuitar)
    cloud9.showInventory()


    cloud9.buyProduct(julioClient, eletricGuitar, TypeOfPayment.DEBT)
    cloud9.showInventory()





    //julioClient.clientCard.setAccountBalance(3000.0f)
    //julioClient.buyProduct(eletricGuitar, TypeOfPayment.CREDIT)

    //test

    //println(someCard.getCardName())


   // julioFuncionario.showPeopleInfo()
    //julioClient.showPeopleInfo()






}