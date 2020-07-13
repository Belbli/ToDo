import Vue from 'vue'
import Vuex from 'vuex'
import todoApi from 'api/todo'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        todos: frontendData.todos,
        profile: frontendData.profile,
    },
    getters: {
      getTodos: state =>  state.todos
    },
    mutations: {
        addTodoMutation(state, todo) {
            state.todos = [
                ...state.todos,
                todo
            ]
        },
        updateTodoMutation(state, todo) {
            const updateIndex = state.todos.findIndex(item => item.id === todo.id)
            state.todos = [
                ...state.todos.slice(0, updateIndex),
                todo,
                ...state.todos.slice(updateIndex + 1)
            ]
        },
        removeTodoMutation(state, todo) {
            const deleteIndex = state.todos.findIndex(item => item.id === todo.id)
            if(deleteIndex > -1) {
                state.todos = [
                    ...state.todos.slice(0, deleteIndex),
                    ...state.todos.slice(deleteIndex + 1)
                ]
            }
        }
    },
    actions: {
        async addTodoAction({commit, state}, todo) {
            const result = await todoApi.add(todo)
            const data = await result.json()
            const index = state.todos.findIndex(item => item.id === todo.id)

            if(index > -1){
                commit('updateTodoMutation', data)
            } else {
                commit('addTodoMutation', data)
            }
        },
        async updateTodoAction({commit, state}, todo) {
            const result = await todoApi.update(todo)
            const data = await result.json()

            commit('updateTodoMutation', data)
        },
        async removeTodoAction({commit}, todo) {
            const result = await todoApi.remove(todo.id)
            commit('removeTodoMutation', todo)
        }
    }
})