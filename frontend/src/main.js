import { createApp , h} from 'vue'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"

import WelcomeComponent from "@/components/WelcomeComponent";
import SearchComponent from "@/components/SearchComponent";
import AllComponent from "@/components/AllComponent";


const NotFoundComponent = { template: '<p>Page not found</p>' }

const routes = {
    '/': WelcomeComponent,
    '/search': SearchComponent,
    '/all': AllComponent
}

const SimpleRouter = {
    data: () => ({
        currentRoute: window.location.pathname
    }),

    computed: {
        CurrentComponent() {
            return routes[this.currentRoute] || NotFoundComponent
        }
    },

    render() {
        return h(this.CurrentComponent)
    }
}

createApp(SimpleRouter).mount('#app')

