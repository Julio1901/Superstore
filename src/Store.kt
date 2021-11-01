class Store (private val storeName: String) {

    //TODO: Deve ter um caixa
    //TODO: Deve ter uma lista de funcionários
    //TODO: Deve ter uma maquininha ex: Cielo, posteriormente será criada uma
    // classe para essa máquina

    private val productList = mutableListOf<Product>()
    //Product and quantity
    private val inventory = mutableMapOf<String, Int>()


    fun testInventory(){
        println(inventory["teste"])
    }

    fun addProduct(product : Product){
        if (!inventory.contains(product.getName())){
            productList.add(product)
            inventory.put(product.getName(), 0)
            println("Product registered successfully")
        }else{
            println("This product is already registered")
        }
    }

    fun stockUp(product: Product, amount: Int){
        inventory.put(product.getName(), amount)
    }


    fun showInventory(){
        //TODO: Validar se estoque não está vazio antes de printar
        inventory.forEach {
            println(it)
        }
    }

    fun showAllProductList(){

        if(productList.isEmpty()){
            println("Sorry, the store does not currently have any products.")
        }else {
            println("Displaying $storeName product list: ")
            productList.forEach {
                println(it.getName())
            }
        }

    }


    fun showProductsInDetail(){
        if(productList.isEmpty()){
            println("Sorry, the store does not currently have any products.")
        }else{
            println("Displaying $storeName product list: ")

            productList.forEach {
                println("\n*************************************")
                println(it.showProductInfo())
            }
        }
    }

    //TODO: Verificar porque o saldo do cliente não está sendo atualizado
    // corretamente após a compra do produto
    fun buyProduct(client : Client,product : Product , typeOfPayment : TypeOfPayment){


        if(checkIfthereIsProductInStock(product)) {
            val password = client.requestPasswordCard()

            if (password.equals(client.clientCard.getPasswordCard())) {

                if (typeOfPayment.equals(TypeOfPayment.DEBT)) {
                    if (product.getPrice() <= client.clientCard.getAccountBalance()) {
                        client.clientCard.setAccountBalance(
                            (client.clientCard
                                .getAccountBalance() - product.getPrice())
                        )
                        println("successful purchase")
                        println(
                            "Updated card balance: ${
                                client.clientCard
                                    .getAccountBalance()
                            }"
                        )

                        //Updating Stock
                        val totalUnitsUpdated = (inventory.getValue(product
                            .getName()) - 1)
                        inventory.put(product.getName(), totalUnitsUpdated)
                    } else {
                        println("Sorry, you don't have enough balance")
                    }
                } else if (typeOfPayment.equals(TypeOfPayment.CREDIT)) {
                    if (product.getPrice() <= client.clientCard.getCreditBalance()) {
                        client.clientCard.setCreditBalance(
                            (client.clientCard
                                .getCreditBalance() - product.getPrice())
                        )
                        println("successful purchase")
                        println(
                            "Updated credit card balance: ${
                                client.clientCard
                                    .getCreditBalance()
                            }"
                        )
                    } else {
                        println("Sorry, you don't have enough balance")
                    }
                } else {
                    println("Sorry, check infos and try again")
                }
            } else {
                println("Sorry, incorrect password, try again")
            }
        }else{
            println("Sorry we don't have the product in stock at the moment.")
        }
    }



    fun checkIfthereIsProductInStock(product : Product) : Boolean{
        return inventory.getValue(product.getName()) > 0
    }

}