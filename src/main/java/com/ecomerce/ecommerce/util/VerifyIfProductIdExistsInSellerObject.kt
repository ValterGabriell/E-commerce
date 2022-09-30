package com.ecomerce.ecommerce.util

import com.ecomerce.ecommerce.model.Products.Products
import com.ecomerce.ecommerce.model.Products.ProductsRep

class VerifyIfProductIdExistsInSellerObject {
    companion object{
        /**
         * Método responsavel por deletar o produto caso ele exista na lista de produtos do usuario
         */
        fun verifyAndDeleteProduct(list:List<Products>, productId:Int, productsRep: ProductsRep): String? {
            list.map {
                return if (it.id == productId){
                    productsRep.deleteById(productId)
                    Constantes.DELETED_OK
                }else{
                    Constantes.DELETED_FAIL
                }
            }
            return Constantes.DELETED_FAIL
        }
    }



}