import kotlin.random.Random

class Client (person : Person) : Person(person.getName(), person.getAge(),
                                        person.getCpf(), person.getGender())
{
    constructor(person: Person, card: Card) : this(person) {
        clientCard.setCardOperator(card.getCardOperator())
        clientCard.setPassword(card.getPasswordCard())
        clientCard.setAccountBalance(card.getAccountBalance())
        clientCard.setCreditBalance(card.getCreditBalance())
    }
    //Por padrão, cliente começa com uma instância de cartão com operadora INVALIDA
    var clientCard = Card(person)





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