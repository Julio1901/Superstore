class Product (productName: String, productPrice : Float){
    private val productName = productName
    private var productPrice = productPrice
    private var productDescription = "No description assigned to product"

    constructor(productName: String, productPrice: Float, productDescription : String) : this(productName, productPrice){
        this.productDescription = productDescription
    }

    fun showProductInfo() : String{
        var productDetail = ("Product name: $productName\nPrice: " +
                "R$$productPrice\nProduct " +
                "Description: $productDescription")

        return productDetail
    }

    fun getPrice() : Float{
        return this.productPrice
    }
    fun getName () : String{
        return this.productName
    }


}