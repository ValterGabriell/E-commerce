package com.ecomerce.ecommerce.util

import com.ecomerce.ecommerce.model.Products.Products
import com.ecomerce.ecommerce.model.Products.ProductsRep

class ImportantsMethods {
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

        fun calculateTotalValue(list:List<Products>): Double {
            var totalValue = 0.0
            list.forEach {
                totalValue += it.price.toInt()
            }
            return totalValue
        }

        fun returnIds(list:List<Products>): ArrayList<Int> {
            var array = arrayListOf<Int>()
            list.map {
                array.add(it.id)
            }
            return array
        }

        fun verifyIfProductExists(list: List<Products>, productsRep: ProductsRep): Boolean {
            var array = productsRep.findAll()
            list.forEach {
                    array.map { array->
                        if (array.id == it.id){
                            return true
                        }
                    }
            }
            return false
        }
    }



}