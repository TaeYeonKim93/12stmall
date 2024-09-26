
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderOrderManager from "./components/listers/OrderOrderCards"
import OrderOrderDetail from "./components/listers/OrderOrderDetail"

import DeliveryDelieveryManager from "./components/listers/DeliveryDelieveryCards"
import DeliveryDelieveryDetail from "./components/listers/DeliveryDelieveryDetail"

import ProductInventoryManager from "./components/listers/ProductInventoryCards"
import ProductInventoryDetail from "./components/listers/ProductInventoryDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders/orders',
                name: 'OrderOrderManager',
                component: OrderOrderManager
            },
            {
                path: '/orders/orders/:id',
                name: 'OrderOrderDetail',
                component: OrderOrderDetail
            },

            {
                path: '/deliveries/delieveries',
                name: 'DeliveryDelieveryManager',
                component: DeliveryDelieveryManager
            },
            {
                path: '/deliveries/delieveries/:id',
                name: 'DeliveryDelieveryDetail',
                component: DeliveryDelieveryDetail
            },

            {
                path: '/products/inventories',
                name: 'ProductInventoryManager',
                component: ProductInventoryManager
            },
            {
                path: '/products/inventories/:id',
                name: 'ProductInventoryDetail',
                component: ProductInventoryDetail
            },



    ]
})
