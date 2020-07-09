<template>
     <v-container class="test">
            <todo-form :todos="todos" :todoAttr="todo" />
            <todo-item v-for="todo in todos.slice().reverse()"
                        :key="todo.id"
                        :todo="todo"
                        :editItem="editItem"

                        :todos="todos" />
     </v-container>
</template>

<script>
    import { mapState } from 'vuex'
    import TodoItem from 'components/todo/TodoItem.vue'
    import TodoForm from 'components/todo/TodoForm.vue'
    import todoApi from 'api/todo'

    export default{
        components: {
            TodoItem,
            TodoForm
        },
        data() {
            return {
                todo: null
            }
        },
        computed: mapState(['todos']),
        methods: {
            editItem(todo) {
                this.todo = todo
            },
            /*deleteItem(todo) {
                todoApi.remove(todo.id).then(result => {
                    if(result.ok) {
                        this.todos.splice(this.todos.indexOf(this.todo), 1)
                    }
                })
            }*/
        }
    }
</script>

<style>

</style>