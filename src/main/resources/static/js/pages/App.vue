<template>
    <v-app>
        <NavBar />

        <v-main class="grey lighten-4">
            <!--v-container v-if="!profile">Необходимо авторизоваться через
                    <a href="/login">Google</a>
            </v-container-->
                <!--todo-list v-if="profile" /-->
                <router-view></router-view>
        </v-main>
    </v-app>
</template>

<script>
    import { mapState } from 'vuex'
    import NavBar from 'components/todo/NavBar.vue'

    export default{
        components: {
            NavBar
        },
        computed: mapState(['profile']),
        data() {
            return {
                drawer: null,
            }
        },
        beforeMount() {
            if(!this.profile) {
                this.$router.replace('/auth')
            }
        }

    }
</script>

<style>
</style>