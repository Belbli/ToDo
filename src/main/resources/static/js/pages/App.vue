<template>
    <v-app>
        <NavBar />

        <v-main class="grey lighten-4">
            <v-container v-if="!profile">Необходимо авторизоваться через
                    <a href="/login">Google</a>
            </v-container>
                <todo-list v-if="profile" />
        </v-main>
    </v-app>
</template>

<script>
    import TodoList from 'components/todo/TodoList.vue'
    import NavBar from 'components/todo/NavBar.vue'

    export default{
        components: {
            TodoList,
            NavBar
        },
        data() {
            return {
                todos: frontendData.todos,
                profile: frontendData.profile,
                drawer: null,
            }
        },

    }
</script>

<style>
</style>