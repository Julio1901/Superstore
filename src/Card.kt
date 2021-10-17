import kotlin.random.Random

class Card (person : Person, password : Int) {
    private val cardNumber = makeCardNumber()
    private val customerNameOnCard = makeClienteCardName(person.getName())
    private val passwordNumber = password
    private var accountBalance = 0.0f
    private var creditBalance = 2000.0f
    //TODO: MAKE A SHOPPING METHOD

    fun getCreditBalance() : Float{
        return this.creditBalance
    }

    fun getAccountBalance() : Float {
        return this.accountBalance
    }

    fun getCardNumber(): String {
        return this.cardNumber
    }

    fun getCardName() : String{
        return this.customerNameOnCard
    }

    fun getPasswordCard() : Int {
        return this.passwordNumber
    }

    fun setAccountBalance(cashValue: Float){
        this.accountBalance = cashValue
    }

    fun setCreditBalance(newDebit : Float){
        if(newDebit <= this.creditBalance) {
            println("Purchase made successfully")
            this.creditBalance -= newDebit
        }else{
            println("Sorry, you don't have a sufficient balance for the purchase.\nCurrent balance: R$$creditBalance" +
                    "\nPurchase amount: R$$newDebit")
        }

    }

    fun makeCardNumber() : String{
        var cardNumber = ""
        var cardNumberFormated =""

        for (i in 1..10){
            cardNumber = cardNumber + Random.nextInt(0, 9)
        }
        //Formating the card number with spaces
        cardNumberFormated = cardNumber.substring(0, 4)
        cardNumberFormated = cardNumberFormated + " " + cardNumber.subSequence(4, 8)
        cardNumberFormated = cardNumberFormated + " " + cardNumber.substring(8)

        return  cardNumberFormated

    }
    //TODO: review why there was a problem in the index
    //Nubank Standard
    fun makeClienteCardName(clientName : String) : String{
        var separateNames = clientName.split(" ")
        var formatedName = ""
        val TOTAL_NUMBER_OF_NAMES = separateNames.size
        val INDEX_CORRECTION = 1

        if(TOTAL_NUMBER_OF_NAMES > 1){
            for (i in 0..(TOTAL_NUMBER_OF_NAMES - INDEX_CORRECTION)){
                if(!i.equals(0) && !i.equals(TOTAL_NUMBER_OF_NAMES - INDEX_CORRECTION)){
                    formatedName = formatedName+separateNames[i].subSequence(0,1) + " "
                }else{
                    formatedName = formatedName+separateNames[i] + " "
                }
            }
            formatedName = formatedName.uppercase()
        }else{
            formatedName = clientName.uppercase()
        }

        return formatedName
    }


}

