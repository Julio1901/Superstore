import kotlin.random.Random


class Client (person : Person) : Person(person.getName(), person.getAge(),
                                        person.getCpf(), person.getGender())
{
    fun buyProduct(product : Product ,card : Card, typeOfPayment : TypeOfPayment){
        print("Please, enter whith card password: ")
        var password = readLine()!!.toInt()

            if (password.equals(card.getPasswordCard())) {

                if (typeOfPayment.equals(TypeOfPayment.DEBT)) {
                    if (product.getPrice() <= card.getAccountBalance()) {
                        card.setAccountBalance((card.getAccountBalance() - product.getPrice()))
                        println("successful purchase")
                        println("Updated card balance: ${card.getAccountBalance()}")
                    } else {
                        println("Sorry, you don't have enough balance")
                    }
                } else if (typeOfPayment.equals(TypeOfPayment.CREDIT)) {
                    if (product.getPrice() <= card.getCreditBalance()) {
                        card.setCreditBalance((card.getCreditBalance() - product.getPrice()))
                        println("successful purchase")
                        println("Updated credit card balance: ${card.getCreditBalance()}")
                    } else {
                        println("Sorry, you don't have enough balance")
                    }
                } else {
                    println("Sorry, check infos and try again")
                }
        }else{
            println("Sorry, incorrect password, try again")
        }
    }


    /*Make method to check if number already exists and avoid conflicts in db
    *
    * */
    private val clientNumber = Random.nextInt(11111, 99999)

    override fun showPeopleInfo() {
        super.showPeopleInfo()
        println("Client number: $clientNumber")

    }

    fun getClientNumber() : Int{
        return this.clientNumber
    }


}