<template>
<nav>
    <v-navigation-drawer
              v-model="drawer"
              app
              class="primary"
              v-if="profile"
    >
              <v-list dense>
                      <v-list-item v-for="link in links" :key="link.text" router :to="link.route">
                        <v-list-item-action>
                          <v-icon class="white--text">{{ link.icon }}</v-icon>
                        </v-list-item-action>
                        <v-list-item-content>
                          <v-list-item-title class="white--text">{{ link.text }}</v-list-item-title>
                        </v-list-item-content>
                      </v-list-item>
                    </v-list>
            </v-navigation-drawer>
            <v-app-bar app>
                <v-app-bar-nav-icon v-if="profile" @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
                <v-toolbar-title><h2>2DO</h2></v-toolbar-title>
                <v-spacer></v-spacer>

                <v-switch
                        v-model="$vuetify.theme.dark"
                        hide-details
                        label="Dark Theme"
                        class="mr-6"
                ></v-switch>
                <span v-if="profile">{{profile.name}}</span>
                <v-btn icon href="/logout" v-if="profile">
                    <v-icon>exit_to_app</v-icon>
                </v-btn>
            </v-app-bar>
    </nav>
</template>

<script>
    export default{
        data() {
            return {
                profile: frontendData.profile,
                drawer: false,
                links: [
                        { icon: 'dashboard', text: 'Dashboard', route: '/' },
                        { icon: 'folder', text: 'My Projects', route: '/projects' },
                        { icon: 'person', text: 'Team', route: '/teams' },
                      ]
            }
        }

    }
</script>

<style>

</style>