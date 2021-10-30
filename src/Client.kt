import kotlin.random.Random

class Client (person : Person) : Person(person.getName(), person.getAge(),
                                        person.getCpf(), person.getGender())
{
    constructor(person: Person, card: Card) : this(person) {
        clientCard.setCardOperator(card.getCardOperator())
        clientCard.setPassword(card.getPasswordCard())
    }
    //Por padrão, cliente começa com uma instância de cartão com operadora INVALIDA
    var clientCard = Card(person)


    fun buyProduct(product : Product , typeOfPayment : TypeOfPayment){
        var password = requestPasswordCard()

            if (password.equals(this.clientCard.getPasswordCard())) {

                if (typeOfPayment.equals(TypeOfPayment.DEBT)) {
                    if (product.getPrice() <= this.clientCard.getAccountBalance()) {
                        this.clientCard.setAccountBalance((this.clientCard.getAccountBalance() - product.getPrice()))
                        println("successful purchase")
                        println("Updated card balance: ${this.clientCard.getAccountBalance()}")
                    } else {
                        println("Sorry, you don't have enough balance")
                    }
                } else if (typeOfPayment.equals(TypeOfPayment.CREDIT)) {
                    if (product.getPrice() <= this.clientCard.getCreditBalance()) {
                        this.clientCard.setCreditBalance((this.clientCard.getCreditBalance() - product.getPrice()))
                        println("successful purchase")
                        println("Updated credit card balance: ${this.clientCard.getCreditBalance()}")
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


    //TODO: Make a method to check if the client number already exists in db
    private val clientNumber = Random.nextInt(11111, 99999)

    override fun showPeopleInfo() {
        super.showPeopleInfo()
        println("Client number: $clientNumber")

    }

    fun getClientNumber() : Int{
        return this.clientNumber
    }

    fun requestPasswordCard() : Int {
        //TODO:Find a way to replace the -1 with something safer
        var userInput = -1

        do {
            print("Please, enter whith card password: ")
            try {
                userInput = readLine()!!.toInt()
            }catch (e : Exception){
                println("Sorry, the value entered is not valid")
            }
        }while (userInput == -1)

        return userInput
    }


}