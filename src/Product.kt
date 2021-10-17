class Product (productName: String, productPrice : Float){
    private val productName = productName
    private var productPrice = productPrice
    private var productDescription = "No description assigned to product"

    constructor(productName: String, productPrice: Float, productDescription : String) : this(productName, productPrice){
        this.productDescription = productDescription
    }

    fun showProductInfo(){
        println("Product name: $productName\nPrice: R$$productPrice\nProduct Description: $productDescription")
    }

    fun getPrice() : Float{
        return this.productPrice
    }

}