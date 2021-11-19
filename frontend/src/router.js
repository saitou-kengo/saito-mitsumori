import Vue from 'vue'
import Router from 'vue-router'
import Home from './components/pages/Home.vue'
import Register from './components/pages/Register.vue'
import Edit from './components/pages/Edit.vue'
import Detail from './components/pages/Detail.vue'

Vue.use(Router)

export default new Router ({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            redirect: '/estimates'
        },
        {
            path: '/estimates',
            name: 'home',
            component: Home
        },
        {
            path: '/estimates/new',
            name: 'register',
            component: Register
        },
        {
            path: '/estimates/:id',
            name: 'detail',
            component: Detail
        },
        {
            path: '/estimates/:id/edit',
            name: 'edit',
            component: Edit
        }
    ]

})