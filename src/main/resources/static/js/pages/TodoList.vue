<template>
     <v-container class="test">
            <todo-form :todos="getTodos" :todoAttr="todo" />
            <todo-item v-for="todo in getTodos.slice().reverse()"
                        :key="todo.id"
                        :todo="todo"
                        :editItem="editItem"
                        :todos="getTodos" />
     </v-container>
</template>

<script>
    import { mapGetters } from 'vuex'
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
        computed: mapGetters(['getTodos']),
        methods: {
            editItem(todo) {
                this.todo = todo
            }
        }
    }
</script>

<style>

</style>