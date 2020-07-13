import Vue from 'vue'
import VueRouter from 'vue-router'
import TodoList from 'pages/TodoList.vue'
import Auth from 'pages/Auth.vue'
import Teams from 'pages/Teams.vue'
import Projects from 'pages/Projects.vue'

Vue.use(VueRouter)

const routes = [
    { path: '/', component: TodoList},
    { path: '/auth', component: Auth},
    { path: '/teams', component: Teams},
    { path: '/projects', component: Projects},
    { path: '*', component: TodoList},
]

export default new VueRouter({
    mode: 'history',
    routes
})