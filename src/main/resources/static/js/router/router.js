import Vue from 'vue'
import VueRouter from 'vue-router'
import TodoList from 'components/todo/TodoList.vue'
import Auth from 'pages/Auth.vue'

Vue.use(VueRouter)

const routes = [
    { path: '/', component: TodoList},
    { path: '/auth', component: Auth}
]

export default new VueRouter({
  routes
})